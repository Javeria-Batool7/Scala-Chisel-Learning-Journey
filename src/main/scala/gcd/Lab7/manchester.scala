package Lab7
import chisel3 . _
import chisel3 . util . _
class manchester extends Module{
    val io = IO(new Bundle{
        val in = Input(UInt(8.W))
        val out = Output(UInt(8.W))
        val start = Input(Bool())
        val flag = Output(Bool())
    })
    val state = RegInit(io.in)
    io.out := 0.U
    io.flag := 0.U
    when (io.start === 1.B){
       state := state + 1.U
    when (state(0) === 1.U){
        io.flag := 0.B
    }
    .otherwise{
        io.flag := 1.B
    }
    }
    io.out := state
    

}    