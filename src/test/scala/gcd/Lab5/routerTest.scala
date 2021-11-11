package Lab5
import org.scalatest._
import chisel3._
import chiseltest._

class routerTest extends FreeSpec with ChiselScalatestTester{
    "Router" in {
        test(new router(5.U)){c=>
        c.io.in_data.data_feild.poke(2.U)
        c.io.in_data.add_feild.poke(6.U)
        c.clock.step(1)
        c.io.out_data.data_feild.expect(2.U)
        c.io.out_data.add_feild.expect(6.U)
        }
    }   
}