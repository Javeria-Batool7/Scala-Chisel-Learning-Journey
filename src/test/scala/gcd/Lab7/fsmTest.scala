package Lab7
import org.scalatest._
import chisel3._
import chiseltest._

class fsmTest extends FreeSpec with ChiselScalatestTester{
    "FSM" in {
        test(new fsm()){c=>
            c.io.f1_in.poke(0.B)
            c.io.f2_in.poke(1.B)
            c.io.r1_in.poke(0.B)
            c.io.r2_in.poke(0.B)
            c.clock.step(25)
            c.io.out.expect(0.U)
            
         
           
        }
    }
}