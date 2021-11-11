package Lab6

import org.scalatest._
import chiseltest._
import chisel3._

class counter_xorTest extends FreeSpec with ChiselScalatestTester{
    "Counter_Xor" in {
        test(new counter_xor()){ c=>
        c.clock.step(25)
        
        }
    }
}