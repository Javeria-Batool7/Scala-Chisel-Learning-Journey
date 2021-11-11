package Lab2
import org.scalatest._
import chisel3._
import chiseltest._

class mux1hTest extends FreeSpec with ChiselScalatestTester{
    "Mux1H" in {
        test(new mux1h()){c=>
        c.io.in0.poke(1.U)
        c.io.in1.poke(2 .U)
        c.io.in2.poke(3.U)
        c.io.in3.poke(4.U)
        c.io.sel.poke(3.U)
        c.clock.step(1)
        c.io.out.expect(3.U)
         
           
        }
    }
}