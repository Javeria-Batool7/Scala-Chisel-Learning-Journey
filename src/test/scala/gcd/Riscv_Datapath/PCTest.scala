package datapath_risc_v
import org.scalatest._
import chiseltest._
import chisel3._
class pcTest extends FreeSpec with ChiselScalatestTester{
    "Program_Counter Test" in {
        test (new(pc)){ c => 
        c.io.pc_input.poke(0.U)
        c.io.pc_output.expect(0.U)
        c.io.pc_adder.expect(4.U)
        c.clock.step(1)
        }
    }
}
