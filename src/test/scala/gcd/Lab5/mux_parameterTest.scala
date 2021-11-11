package Lab5
import org.scalatest._
import chisel3._
import chiseltest._

class mux_parameterTest extends FreeSpec with ChiselScalatestTester{
    "Muxparameter" in {
        test(new mux_parameter(UInt(5.W))){c=>
        c.io.input1.poke(4.U)
        c.io.input2.poke(2.U)
        c.io.select.poke(1.B)
        c.clock.step(1)
        c.io.output.expect(2.U)
         
           
        }
    }   
}