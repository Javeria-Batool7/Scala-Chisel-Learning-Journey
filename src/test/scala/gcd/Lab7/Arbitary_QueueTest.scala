package Lab7
import org.scalatest._
import chisel3._
import chiseltest._

class Arbitary_QueueTest extends FreeSpec with ChiselScalatestTester{
    "Arbitary Queue" in {
        test(new Arbitary_Queue()){c=>
            c.io.in.valid.poke(1.B)
            c.io.in.bits.poke(32.U)
            c.io.out.ready.poke(1.B)
            c.clock.step(5)
            
         
           
        }
    }
}
