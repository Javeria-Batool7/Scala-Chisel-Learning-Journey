package datapath_risc_v
import chisel3._
import chisel3.util._
class controller extends Module{
    val io = IO (new Bundle{
        val r = Input(UInt(1.W)) //done
        val i = Input(UInt(1.W)) //done
        val load = Input(UInt(1.W)) //done
        val store = Input(UInt(1.W)) //done
        val lui = Input(UInt(1.W)) //done
        val jal = Input(UInt(1.W)) //done
        val jalr = Input(UInt(1.W)) //done
        val sb = Input(UInt(1.W))
        val auipc = Input(UInt(1.W))
        val mem_write = Output(UInt(1.W))
        val mem_read = Output(UInt(1.W))
        val reg_write = Output(UInt(1.W))
        val immsel = Output(UInt(1.W))
        val loadsel = Output(UInt(1.W))
        val branch = Output(UInt(1.W))
        val auipc_out = Output(UInt(1.W))
        val lui_out = Output(UInt(1.W))
        val jal_out = Output(UInt(1.W))
        val jalr_out = Output(UInt(1.W))
    })
    io.mem_write := 0.U //1
    io.mem_read := 0.U  //2
    io.reg_write := 0.U //3
    io.immsel := 0.U //4
    io.loadsel := 0.U //5
    io.branch := 0.U //6
    io.auipc_out := 0.U //7
    io.lui_out := 0.U 
    io.jal_out := 0.U //9
    io.jalr_out := 0.U //10
    when (io.store === 1.U){
        io.mem_write := 1.U
        io.reg_write := 1.U
    }
    .elsewhen (io.load === 1.U){
        io.mem_read := 1.U
        io.loadsel := 1.U
        io.reg_write := 1.U
    }
    .elsewhen (io.i === 1.U){
        io.immsel := 1.U
        io.reg_write := 1.U
    }
    .elsewhen (io.r=== 1.U){
        io.reg_write := 1.U
    }
    .elsewhen (io.lui === 1.U){
        io.lui_out := 1.U
        io.reg_write := 1.U
    }
    .elsewhen(io.sb===1.U){
        io.branch := 1.U
    }
    .elsewhen(io.jal===1.U){
        io.jal_out := 1.U
        io.reg_write := 1.U
    }
    .elsewhen(io.jalr===1.U){
        io.jalr_out := 1.U
        io.reg_write := 1.U
    }
    .elsewhen(io.sb===1.U){
        io.branch := 1.U
    }
    
}
