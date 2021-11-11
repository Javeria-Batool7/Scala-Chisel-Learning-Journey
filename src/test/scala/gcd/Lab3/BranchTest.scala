package Lab3
import org.scalatest._
import chisel3._
import chiseltest._

class BranchTest extends FreeSpec with ChiselScalatestTester{
    "Branch TEST" in {
        test(new Branch()){c=>
        c.io.branch_input_a.poke(1.S)
        c.io.branch_input_b.poke(2.S)
        c.io.fuc.poke("b101".U)
        c.io.branch_op.poke(1.B)
        c.clock.step(1)
        c.io.branch_output.expect(1.B)
        }
    }
}