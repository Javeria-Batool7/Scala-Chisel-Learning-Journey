package datapath_risc_v
import chisel3._
import chisel3 . util . _
class ALUOP extends Module{
    val io = IO (new Bundle{
        val func_3 = Input(UInt(3.W))
        val func_7 = Input(UInt(1.W))
        val s_branch = Input(Bool())
        val alu_op = Output(UInt(5.W))
    })
    val sb = Cat("b10".U, io.func_3)
    val fun7 = Cat(0.U , io.func_3 )
    when (io.s_branch){
        io.alu_op := sb
    }
    .otherwise{
        io.alu_op := fun7
    }
}
