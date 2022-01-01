package datapath_risc_v
import chisel3._
import chisel3.util._
class Top extends Module{
    val io = IO (new Bundle{
        val out = Output(SInt(32.W))
    })
    val alu = Module(new alu1())
    val aluop = Module(new ALUOP())
    val controlunit = Module(new controluint)
    val data_mem = Module(new DATA_MEM())
    val imm_gen = Module(new imm_gen())
    val inst_mem = Module(new inst_mem())
    val pc = Module(new pc())
    val reg_file = Module(new REGFILE())

    //PC = PC+4
    pc.io.pc_input := pc.io.pc_adder
    
    //now address from pc goes into inst mem
    inst_mem.io.mem_add := pc.io.pc_output(11,2)
    
    //the the data out from inst mem (0,6) => opcode
    controlunit.io.opcode := inst_mem.io.mem_Data(6,0)
    
    //wired imm_gen input to the data out from instruction mem
    //and wired pc out to inst mem pc
    imm_gen.io.input_imm := inst_mem.io.mem_Data
    imm_gen.io.pc := pc.io.pc_output
    
    //now the address of rs1 rs2 and rd will be maped
    reg_file.io.reg_A := inst_mem.io.mem_Data(19,15)
    reg_file.io.reg_B:= inst_mem.io.mem_Data(24,20)
    
    //if there is a jump it will always save in x1
    when(controlunit.io.jal_out === 1.U){
        reg_file.io.reg_rd := 1.U
    }
    .otherwise{
        reg_file.io.reg_rd := inst_mem.io.mem_Data(11,7)
    }

    // reg_enable is wired with control unit if reg_write is enable then the register will be write
    reg_file.io.reg_enable := controlunit.io.reg_write
    
    //now the bits from instruction mem is distributed among func3 , func7 
    aluop.io.func_3 := inst_mem.io.mem_Data(14,12)
    aluop.io.func_7 := inst_mem.io.mem_Data(30)
    
    //if there is a branch inst
    aluop.io.s_branch := controlunit.io.branch
    // concantenate sb, func3 , func7
    alu.io.alu_op := Cat(aluop.io.func_3 , aluop.io.func_7 ,aluop.io.s_branch)
    
    //alu_input_a if its auipc then alu_a will be pc+4 otherwise reg_a will goes into alu_a
    when(controlunit.io.auipc_out === 1.U){
        alu.io.a := (pc.io.pc_adder).asSInt
    }
    .otherwise{
        alu.io.a := reg_file.io.a 
    }
    //alu_input_b 
    val s = RegInit(0.U(32.W)) //if s_imm is there
    val i = 0.U //if i_imm is there
    when(controlunit.io.immsel === 1.B){
      s := 1.U
    }
    .otherwise{
        //i := 1.U
    }
    when(s === 1.U){
       alu.io.b := imm_gen.io.s_TYPE //if there is store inst 
    }
    .elsewhen(i === 1.U){
        alu.io.b := imm_gen.io.i_TYPE //if there is immediate
    }
    .elsewhen(controlunit.io.lui_out === 1.U){
        alu.io.b := imm_gen.io.u_TYPES
    }
    .otherwise{
        alu.io.b := reg_file.io.b
    }

    //now writback from alu output for operation or load or jump
    when(controlunit.io.loadsel === 1.U){
         reg_file.io.reg_writeBack := data_mem.io.mem_data
     }
    // .elsewhen(controlunit.io.jal_out === 1.U){
    //      reg_file.io.reg_writeBack := pc.io.pc_adder
    // }
    .otherwise{
        reg_file.io.reg_writeBack := alu.io.output
     }

    //if there is any jump
    when(controlunit.io.jalr_out === 1.U){
        pc.io.pc_input := (alu.io.output).asUInt
    }
    .elsewhen(controlunit.io.branch === 1.U){
        pc.io.pc_input := (imm_gen.io.sb_TYPE).asUInt
    }
    // .otherwise{
    //     pc.io.pc_input := pc.io.pc_adder
    // }

    //Data Memory
    data_mem.io.mem_add := (alu.io.output(23 , 0)).asUInt
    data_mem.io.mem_data_in := reg_file.io.b
    data_mem.io.mem_load := controlunit.io.mem_write
    data_mem.io.mem_store:= controlunit.io.mem_read
    io.out := alu.io.output
}
