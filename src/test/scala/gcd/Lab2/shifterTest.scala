package Lab2
import org.scalatest._
import chisel3._
import chiseltest._

class shifterTest extends FreeSpec with ChiselScalatestTester{
    "Barrel Shifter" in {
        test(new shifter){c=>
          c.io.input(0).poke(0.B)
          c.io.input(1).poke(0.B)
          c.io.input(2).poke(1.B)
          c.io.input(3).poke(0.B)
          c.io.selector(0).poke(0.B)
          c.io.selector(1).poke(0.B)
          c.io.shift.poke(0.B)
          c.clock.step(20)
         
           
        }
    }
}