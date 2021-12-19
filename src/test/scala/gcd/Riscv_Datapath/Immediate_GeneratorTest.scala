package datapath_risc_v
import chisel3._
import chisel3.util
import org.scalatest._
import chiseltest._
class imm_generatorTest extends FreeSpec with ChiselScalatestTester{
    "Immediate_Generation_Test" in {
        test(new imm_gen()){c=>
        c.io.input_imm.poke(11.U)
        //c.io.PC.poke(0.U)
        c.clock.step(1)    
        c.io.i_TYPE.expect(11.S)    
        
        }
    }
}
