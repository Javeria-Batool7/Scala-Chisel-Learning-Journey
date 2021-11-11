package Lab2
import org.scalatest._
import chisel3._
import chiseltest._

class mux2to1Test extends FreeSpec with ChiselScalatestTester{
    "Mux 2 to 1 test" in {
        test(new Mux_2to1()){c=>
        c.io.in_A.poke(0.B)
        c.io.in_B.poke(1.B)
        c.io.select.poke(1.B)
        c.clock.step(1)
        c.io.out.expect(1.B)
         
           
        }
    }
}