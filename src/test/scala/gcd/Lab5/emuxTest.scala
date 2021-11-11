package Lab5
import org.scalatest._
import chisel3._
import chiseltest._

class emuxTest extends FreeSpec with ChiselScalatestTester{
    "EMux" in {
        test(new emux(7.S , 7.U)){c=>
        c.io.input.poke(4.S)
        c.io.input2.poke(2.U)
        c.io.select.poke(0.B)
        c.clock.step(1)
        c.io.output.expect(4.U)
         
           
        }
    }   
}