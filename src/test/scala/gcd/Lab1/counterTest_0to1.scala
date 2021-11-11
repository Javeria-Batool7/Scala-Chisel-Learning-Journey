package Lab1

import org.scalatest._
import chiseltest._
import chisel3._

class counterTest_0to1 extends FreeSpec with ChiselScalatestTester{
    "Tasks 1 Counter test" in {
        test(new counter_0to1()){ c=>
        c.clock.step(20)
        
        }
    }
}
