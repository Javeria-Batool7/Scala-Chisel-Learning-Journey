package Lab5
import chisel3 . _
import chisel3 . util . _
import scala.language.postfixOps;

class emux(size : SInt , datatype : UInt) extends Module {
    val io = IO(new Bundle{
         val input = Input(size)
         val input2= Input(datatype)
         val select = Input(Bool())
         val output = Output(UInt(7.W))
    })
    io.output := Mux(io.select , io.input , io.input2)  
}
