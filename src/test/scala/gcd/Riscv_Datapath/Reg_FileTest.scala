package datapath_risc_v
import chisel3._
import chisel3.util
import org.scalatest._
import chiseltest._

class REGFILETEST extends FreeSpec with ChiselScalatestTester{
    "reg file test" in {
        test(new REGFILE()){c=>
        c.io.reg_A.poke(8.U)    
        c.io.reg_B.poke(6.U)    
        c.io.reg_rd.poke(8.U)    
        c.io.reg_writeBack.poke(10.S)    
        c.io.reg_enable.poke(1.B)    
        c.clock.step(1) 
        c.io.a.expect(10.S)    
        c.io.b.expect(0.S)    
        }
    }
}
