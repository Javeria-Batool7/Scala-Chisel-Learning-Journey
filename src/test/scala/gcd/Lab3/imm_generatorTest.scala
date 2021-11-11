package Lab3
import org.scalatest._
import chisel3._
import chiseltest._

class imm_generatorTest extends FreeSpec with ChiselScalatestTester{
    "Immediate Generator test" in {
        test(new imm_generator()){c=>
        c.io.input_imm.poke(0xA.U)
        c.io.opcode.poke(19.U)
        c.clock.step(1)
        c.io.output_imm.expect(10.S)
        }
    }
}