package Lab6
import chisel3 . _
class shifter(val init : Int = 1) extends Module {
    val io = IO(new Bundle {
        val in = Input(UInt(4.W))
        val in1 = Input(UInt(4.W))
        val in2 = Input(UInt(4.W))
        val in3 = Input(UInt(4.W))
        val out= Output(UInt(4.W))
        val out1= Output(UInt(4.W))
        val out2= Output(UInt(4.W))
        val out3= Output(UInt(4.W))
    })
    val state = RegInit(init.U(4.W))
    val state1 = RegInit(init.U(4.W))
    val state2 = RegInit(init.U(4.W))
    val state3 = RegInit(init.U(4.W))
    val nextstate = (state << 1.U) | io.in
    val nextstate1 = (state << 1.U) | io.in1
    val nextstate2 = (state << 1.U) | io.in2
    val nextstate3 = (state << 1.U) | io.in3
    state := nextstate
    state1 := nextstate1
    state2 := nextstate2
    state3 := nextstate3
    io.out := state
    io.out1 := state1
    io.out2 := state2
    io.out3 := state3
}