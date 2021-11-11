package practice
import chisel3._
class HalfAdder_Sum extends Module {
    val io = IO(new Bundle {
        val a = Input(UInt(32.W))
        val b = Input(UInt(32.W))
        val output_Sum = Output(UInt(32.W))
        val output_Carry = Output(UInt(32.W))
    })
    io.output_Sum := io.a ^ io.b
    io.output_Carry := io.a & io.b

}