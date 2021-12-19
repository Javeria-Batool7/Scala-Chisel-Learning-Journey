package datapath_risc_v
import org.scalatest._
import chiseltest._
import chisel3._
import chisel3.util._

class controlunitTest extends FreeSpec with ChiselScalatestTester{
    "Control_Unit_Test"  in {
     test (new controluint){ c =>
        c.io.opcode.poke(55.U)         
        c.clock.step(10)
        c.io.reg_write.expect(1.U)
        }
    }
}
