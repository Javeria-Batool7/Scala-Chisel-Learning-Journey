package Lab6

import org.scalatest._
import chiseltest._
import chisel3._

class one_shot_timerTest extends FreeSpec with ChiselScalatestTester{
    "One Shot Timer" in {
        test(new one_shot_timer(7)){ c=>
        c.clock.step(25)
        
        }
    }
}