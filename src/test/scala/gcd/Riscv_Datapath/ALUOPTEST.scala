package datapath_risc_v
import chisel3._
import chisel3.util
import org.scalatest._
import chiseltest._

class ALUOPTEST extends FreeSpec with ChiselScalatestTester{
    "alu_op Test " in {
        test(new ALUOP()){c=>
        c.io.func_3.poke(1.U)    
        c.io.func_7.poke(1.U)    
        c.io.s_branch.poke(1.B)  
        c.clock.step(10)
        c.io.alu_op.expect("b10001".U)  
        }
    }
}
