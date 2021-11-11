package Lab5
import chisel3 . _
import chisel3 . util . _
class mux_parameter[T <: Data](gen : T) extends Module{
    val io = IO(new Bundle{
        val input1 = Input(gen)
        val input2 = Input(gen)
        val output = Output(gen)
        val select = Input(Bool())
    })
    val mux = Mux(io.select , io.input2 , io.input1)
    io.output := mux
}