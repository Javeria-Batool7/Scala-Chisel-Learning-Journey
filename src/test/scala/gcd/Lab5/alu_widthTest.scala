package Lab5
import org.scalatest._
import chisel3._
import chiseltest._

class alu_widthTest extends FreeSpec with ChiselScalatestTester{
    "ALU TEST" in {
        test(new alu_width(10:Int)){c=>
        c.io.alu_x.poke(8.U)
        c.io.alu_y.poke(1.U)
        c.io.alu_op.poke("b0010".U)
        c.clock.step(1)
        c.io.alu_output.expect(9.U)
        }
    }
}