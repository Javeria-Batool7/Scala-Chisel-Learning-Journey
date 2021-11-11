package Lab1

import org.scalatest._
import chiseltest._
import chisel3._

class typecastingTest extends FreeSpec with ChiselScalatestTester{
    "Type Casting" in {
        test(new typecasting(3.U)){ c=>
        c.clock.step(20)
        
        }
    }
}