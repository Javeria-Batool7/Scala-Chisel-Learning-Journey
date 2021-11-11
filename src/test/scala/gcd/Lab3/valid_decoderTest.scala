package Lab3
import org.scalatest._
import chisel3._
import chiseltest._

class valid_decoderTest extends FreeSpec with ChiselScalatestTester{
    "ALU TEST" in {
        test(new valid_decoder()){c=>
        c.io.valid_in.poke("b00".U)
        c.clock.step(1)
        c.io.valid_out.bits.expect(1.U)
        }
    }
}