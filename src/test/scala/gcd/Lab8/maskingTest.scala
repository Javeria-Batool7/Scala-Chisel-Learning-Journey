package Lab8
import org.scalatest._
import chisel3._
import chiseltest._

class maskingTest extends FreeSpec with ChiselScalatestTester{
    "Masking" in {
        test(new masking()){c=>
            c.io.enable.poke(1.B)
            c.io.write.poke(1.B)
            c.io.addr.poke(4.U)
            c.io.mask(0).poke(1.B)
            c.io.mask(1).poke(1.B)
            c.io.mask(2).poke(1.B)
            c.io.mask(3).poke(1.B)
            c.io.dataIn(0).poke(1.U)
            c.io.dataIn(1).poke(2.U)
            c.io.dataIn(2).poke(3.U)
            c.io.dataIn(3).poke(4.U)
            c.clock.step(25)
            
            
         
           
        }
    }
}