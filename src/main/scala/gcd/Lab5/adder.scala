package Lab5
import chisel3 . _
import chisel3 . util . _
class adder(width : Int) extends Module{
    val io = IO(new Bundle{
        val in0 = Input(UInt(width .W))
        val in1 = Input(UInt(width.W))
        val output = Output(UInt(width.W))
    })
    io.output := io.in0 + io.in1
}
