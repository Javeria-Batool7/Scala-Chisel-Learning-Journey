package Lab7
import org.scalatest._
import chisel3._
import chiseltest._

class manchesterTest extends FreeSpec with ChiselScalatestTester{
    "Manchester" in {
        test(new manchester()){c=>
            c.io.start.poke(1.B)
            c.io.in.poke(0.U)
            c.clock.step(10)
           
        }
    }
}