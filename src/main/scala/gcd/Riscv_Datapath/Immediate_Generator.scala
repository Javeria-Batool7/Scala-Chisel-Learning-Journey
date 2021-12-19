package datapath_risc_v
import chisel3 . _
import scala.language.postfixOps;
import chisel3 . util . _
class imm_gen extends Module{
    val io = IO(new Bundle{
        val input_imm = Input(UInt(32.W))
        val pc = Input(UInt(32.W))
        val i_TYPE = Output(SInt(32.W))
        val s_TYPE = Output(SInt(32.W))
        val sb_TYPE = Output(SInt(32.W))
        val u_TYPES = Output(SInt(32.W))
        val uj_TYPES = Output(SInt(32.W))
    })
    val signed_imm_I = io.input_imm(31 , 20)
    val u_type = io.input_imm(31 , 12)
    val s_typeimm_a = io.input_imm(11,7)
    val s_typeimm_b = io.input_imm(31,25)
    val sb_typeimm_a = io.input_imm(11,8)
    val sb_typeimm_b = io.input_imm(7)
    val sb_typeimm_c = io.input_imm(30 ,25)
    val sb_typeimm_d = io.input_imm(31)
    val sb_typeimm_e = io.input_imm(0)
    val uj_type_a = io.input_imm(19,12)
    val uj_type_b = io.input_imm(20)
    val uj_type_c = io.input_imm(30,21)
    val uj_type_d = io.input_imm(31)
    io.i_TYPE := (signed_imm_I).asSInt
    io.s_TYPE := Cat(s_typeimm_a , s_typeimm_b).asSInt
    io.sb_TYPE := Cat(sb_typeimm_a , sb_typeimm_b , sb_typeimm_c , sb_typeimm_d ).asSInt + (io.pc).asSInt
    io.u_TYPES := (u_type).asSInt
    io.uj_TYPES := Cat(uj_type_a ,uj_type_b , uj_type_c , uj_type_d).asSInt + (io.pc).asSInt

}
