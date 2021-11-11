package Lab3
import org.scalatest._
import chisel3._
import chiseltest._

class Encoder_switchTest extends FreeSpec with ChiselScalatestTester{
    "EncoderSwitch test" in {
        test(new Encoder_switch()){c=>
        c.io.input_en.poke(2.U)
        c.clock.step(1)
        c.io.output_en.expect(1.U)
        }
    }
}