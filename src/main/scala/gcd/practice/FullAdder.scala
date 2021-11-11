package practice
import chisel3._
class FullAdder extends Module {
    val io = IO(new Bundle {
        val a = Input(UInt(32.W))
        val b = Input(UInt(32.W))
        val j = Input(UInt(32.W))
        val output_sum = Output(UInt(32.W))
        val output_carry = Output(UInt(32.W))
    })
    io.output_sum := (io.j^(io.a ^ io.b))
    io.output_carry := ((io.a & io.b)|(io.j & (io.a ^ io.b)))
    
}