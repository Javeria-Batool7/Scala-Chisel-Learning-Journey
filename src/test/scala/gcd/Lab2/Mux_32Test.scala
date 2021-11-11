package Lab2
import org.scalatest._
import chisel3._
import chiseltest._

class Mux_32Test extends FreeSpec with ChiselScalatestTester{
    "Mux_32" in {
        test(new Mux_32()){c=>
        c.io.in_A.poke(1.U)
        c.io.in_B.poke(0.U)
        c.io.select.poke(0.B)
        c.clock.step(4)
        c.io.out.expect(1.U)
         
           
        }
    }
}