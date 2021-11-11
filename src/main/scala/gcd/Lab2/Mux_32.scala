package Lab2
import chisel3 . _
// Mux IO interface class
class Mux_32 extends Module {
    val io  = IO(new Bundle{
        val in_A = Input ( UInt (32.W) )
        val in_B = Input ( UInt (32.W) )
        val select = Input ( Bool () )
        val out = Output ( UInt (32.W) )
    })
    // update the output
    io.out := io.in_A & (~io.select) | io . in_B &  io . select 
}