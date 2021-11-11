package Lab5
import org.scalatest._
import chisel3._
import chiseltest._

class mux_bundleTest extends FreeSpec with ChiselScalatestTester{
    "Muxparameter" in {
        test(new mux_bundle(UInt(5.W))){c=>
        c.io.input_1.poke(4.U)
        c.io.input_2.poke(2.U)
        c.io.select_1.poke(1.B)
        c.clock.step(1)
        c.io.out_put.expect(2.U)
         
           
        }
    }   
}