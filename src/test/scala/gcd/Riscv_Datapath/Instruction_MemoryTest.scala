package datapath_risc_v
import chisel3._
import chisel3.util
import org.scalatest._
import chiseltest._

class inst_memtest extends FreeSpec with ChiselScalatestTester{
    "inst memory test" in {
        test(new inst_mem()){c=>
        c.io.mem_add.poke(2.U)
        c.clock.step(2)
        c.io.mem_Data.expect(7439027.U)
        }
    }
}
