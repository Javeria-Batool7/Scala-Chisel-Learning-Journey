package Lab2
import org.scalatest._
import chisel3._
import chiseltest._

class mux5to1Test extends FreeSpec with ChiselScalatestTester{
    "Mux 5 to 1 test" in {
        test(new mux5to1()){c=>
        c.io.in_A.poke(16.U)
        c.io.in_B.poke(0.U)
        c.io.in_C.poke(0.U)
        c.io.in_D.poke(0.U)
        c.io.in_E.poke(0.U)
        c.io.sel_1.poke(1.B)
        c.io.sel_2.poke(0.B)
        c.io.sel_3.poke(0.B)
        c.clock.step(1)
        c.io.out.expect(16.U)
         
           
        }
    }
}