package Lab3
import org.scalatest._
import chisel3._
import chiseltest._

class ALUTest extends FreeSpec with ChiselScalatestTester{
    "ALU TEST" in {
        test(new ALU()){c=>
        c.io.input_a.poke(8.S)
        c.io.input_b.poke(1.S)
        c.io.alu_op.poke("b1011".U)
        c.clock.step(1)
        c.io.alu_output.expect(4.U)
        }
    }
}
