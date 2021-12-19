package datapath_risc_v
import chisel3._
import chisel3.util
import org.scalatest._
import chiseltest._

class DATA_MEMTEST extends FreeSpec with ChiselScalatestTester{
    "Data_Memory_Test" in {
        test(new DATA_MEM()){c=>
        c.io.mem_add.poke(2.U)
        c.io.mem_data_in.poke(16.S)
        c.io.mem_store.poke(1.B)
        c.io.mem_load.poke(1.B)
       
        c.clock.step(1)
        c.io.mem_data.expect(16.S)
        }
    }
}
