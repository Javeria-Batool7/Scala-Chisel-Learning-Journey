package datapath_risc_v
import org.scalatest._
import chiseltest._
import chisel3._
import chisel3.util._

class topTest extends FreeSpec with ChiselScalatestTester{
    "Top Test"  in {
     test (new Top()){ c =>
 
        c.clock.step(1)

        }
    }
}
