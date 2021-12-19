package datapath_risc_v
import chisel3._
import chisel3 . util . _
class REGFILE extends Module{
    val io = IO (new Bundle{
        val reg_A = Input(UInt(5.W))
        val reg_B = Input(UInt(5.W))
        val reg_rd = Input(UInt(5.W))
        val reg_enable = Input(Bool())
        val reg_writeBack = Input(SInt(32.W))
        val a = Output(SInt(32.W))
        val b = Output(SInt(32.W))
    })
    val reg = Reg(Vec(32 , SInt(32.W)))
    when (io.reg_enable){
        when (io.reg_rd === 0.U){
            reg(io.reg_rd) := 0.S
        }
        .otherwise{
            reg(io.reg_rd) := io.reg_writeBack
        }
    }
    io.a := reg(io.reg_A)
    io.b := reg(io.reg_B)
}
