package datapath_risc_v
import org.scalatest._
import chiseltest._
import chisel3._
import chisel3.util._

class controllerTest extends FreeSpec with ChiselScalatestTester{
    "Controller_Test"  in {
     test (new controller){ c =>
        c.io.r.poke(1.U)
        c.io.load.poke(1.U)         
        c.clock.step(10)
        c.io.mem_read.expect(1.U)
        c.io.reg_write.expect(1.U)
        }
    }
}
