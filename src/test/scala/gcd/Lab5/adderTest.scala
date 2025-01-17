package Lab5
import org.scalatest._
import chisel3._
import chiseltest._

class adderTest extends FreeSpec with ChiselScalatestTester{
    "Adder TEST" in {
        test(new adder(10:Int)){c=>
        c.io.in0.poke(8.U)
        c.io.in1.poke(1.U)
        c.clock.step(1)
        c.io.output.expect(9.U)
        }
    }
}
