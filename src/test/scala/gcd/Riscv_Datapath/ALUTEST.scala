package datapath_risc_v
import org.scalatest._
import chisel3._
import chiseltest._

class alu1test extends FreeSpec with ChiselScalatestTester{
    "ALU_TEST" in {
        test(new alu1){c=>
        c.io.a.poke(10.S)
        c.io.b.poke(10.S)
        c.io.alu_op.poke("b00000".U)
        c.clock.step(1)
        c.io.output.expect(20.S)
        c.io.branch.expect(0.U)
        }
    }
}
