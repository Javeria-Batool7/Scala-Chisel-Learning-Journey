package Lab6

import org.scalatest._
import chiseltest._
import chisel3._

class bit_updownTest extends FreeSpec with ChiselScalatestTester{
    "UpDown Test" in {
        test(new bit_updown(9)){ c=>
        c.io.enable.poke(0.B)
        c.clock.step(25)
        
        }
    }
}
