package Lab8
import org.scalatest._
import chisel3._
import chiseltest._

class memoryTest extends FreeSpec with ChiselScalatestTester{
    "Memory" in {
        test(new memory()){c=>
            c.io.data_in(0).poke(1.U)
            c.io.data_in(1).poke(2.U)
            c.io.data_in(2).poke(3.U)
            c.io.data_in(3).poke(4.U)
            c.io.enable.poke(1.B)
            c.io.write.poke(1. B)
            c.io.addr.poke(4.U)
            c.io.data_sel.poke(2.U)
            c.clock.step(2)
            
            
         
           
        }
    }
}