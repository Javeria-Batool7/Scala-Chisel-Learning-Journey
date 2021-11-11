package Lab1

import org.scalatest._
import chiseltest._
import chisel3._

class task_counterTest extends FreeSpec with ChiselScalatestTester{
    "Task 1 Counter test" in {
        test(new task_counter(3.U)){ c=>
        c.clock.step(20)
        
        }
    }
}