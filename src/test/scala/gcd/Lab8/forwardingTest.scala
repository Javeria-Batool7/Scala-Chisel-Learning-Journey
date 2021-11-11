package Lab8
import org.scalatest._
import chisel3._
import chiseltest._

class forwardingTest extends FreeSpec with ChiselScalatestTester{
    "forwarding" in {
        test(new forwarding()){c=>
            c.io.rdAddr.poke(5.U)
            c.io.wrAddr.poke(5.U)
            c.io.wrData.poke(7.U)
            c.io.wr_en.poke(1.B)
            c.clock.step(7)
            
            
         
           
        }
    }
}
