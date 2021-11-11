package Lab3
import chisel3 . _
import scala.language.postfixOps;
import chisel3 . util . _
class imm_generator extends Module{
    val io = IO(new Bundle{
        val input_imm = Input(UInt(32.W))
        val opcode = Input(UInt(7.W))
        val output_imm = Output(SInt(32.W))
    })
    io.output_imm := 0 .S
    val signed_imm_I = io.input_imm(31 , 12) .asSInt
    val u_type = io.input_imm(31 , 12) .asSInt
    val s_typeimm_a = io.input_imm(11,7) .asSInt
    val s_typeimm_b = io.input_imm(31,25) .asSInt
    val sb_typeimm_a = io.input_imm(11,8) .asSInt
    val sb_typeimm_b = io.input_imm(7).asSInt
    val sb_typeimm_c = io.input_imm(30 ,25).asSInt
    val sb_typeimm_d = io.input_imm(31).asSInt
    val uj_type_a = io.input_imm(19,12) .asSInt
    val uj_type_b = io.input_imm(20) .asSInt
    val uj_type_c = io.input_imm(30,21) .asSInt
    val uj_type_d = io.input_imm(31) .asSInt
    switch(io.opcode){
        is(19.U){
            io.output_imm := signed_imm_I
        }
        is(35.U){
            io.output_imm:=s_typeimm_a + s_typeimm_b
            
        }
        is(99.U){
            io.output_imm := sb_typeimm_a + sb_typeimm_b + sb_typeimm_c+ sb_typeimm_d
        }
        is(55.U){
            io.output_imm := u_type
        }
        is(111.U){
            io.output_imm:=uj_type_a + uj_type_b + uj_type_c + uj_type_d
        }
        
     

    }
}