package Lab6
import org.scalatest._
import chisel3._
import chiseltest._

class shifterTest extends FreeSpec with ChiselScalatestTester{
    "Shifter TEST" in {
        test(new shifter()){c=>
        c.io.in.poke(1.U)
        c.io.in1.poke(1.U)
        c.io.in2.poke(1.U)
        c.io.in3.poke(1.U)
        c.clock.step(1)
        c.io.out.expect(3.U)
        c.io.out1.expect(3.U)
        c.io.out2.expect(3.U)
        c.io.out3.expect(3.U)
        }
    }
}