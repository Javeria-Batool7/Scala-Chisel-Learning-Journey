package Lab6

import org.scalatest._
import chiseltest._
import chisel3._

class countertest extends FreeSpec with ChiselScalatestTester{
    "Counter Test" in {
        test(new counter()){ c=>
        c.clock.step(25)
        
        }
    }
}