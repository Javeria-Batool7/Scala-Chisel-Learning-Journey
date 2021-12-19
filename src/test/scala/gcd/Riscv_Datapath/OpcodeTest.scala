package datapath_risc_v
import org.scalatest._
import chiseltest._
import chisel3._
import chisel3.util._
class opcodeTest extends FreeSpec with ChiselScalatestTester{
    "type Decoder"  in {
     test (new opcode){ c =>
        c.io.opcode.poke("b1100011".U)
        c.io.sb.expect(1.U)       
        c.clock.step(1)
        }
    }
}
