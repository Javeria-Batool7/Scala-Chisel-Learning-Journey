package Lab1

import org.scalatest._
import chiseltest._
import chisel3._

class updown_counterTest extends FreeSpec with ChiselScalatestTester{
    "Up down Counter" in {
        test(new counter_up_down(3.U)){ c=>
        c.clock.step(25)
        
        }
    }
}