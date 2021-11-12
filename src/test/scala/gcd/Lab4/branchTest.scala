package Lab4
import chisel3 . _
import chisel3 . util
import org . scalatest . _
import chiseltest . _
import chiseltest . experimental . TestOptionBuilder . _
import chiseltest . internal . VerilatorBackendAnnotation
import scala . util . Random
import BranchOP._

class branchTest extends FreeSpec with ChiselScalatestTester {
    "BranchTest" in {
        test ( new branch ) { c =>
        // ALU operations
            val array_op = Array ( ALU_BEQ,ALU_BNE,ALU_BGE,ALU_BLT )
            for ( i <- 0 until 100) {
                // println(s"i=>$i")
                val src_a = Random.nextLong()&0xFFFFFFFFL
                val src_b = Random.nextLong()&0xFFFFFFFFL
                val opr = Random.nextInt(4)
                val aluop = array_op ( opr )
                //println(s"aluop=>$aluop")
                // println(s"srcA=>$src_a*")
                
                // println(s"srcB=>$src_b")
                val result:Int = aluop match {
                    case ALU_BEQ => if(src_a.toInt == src_b.toInt) 1 else 0
                    
                    case ALU_BNE =>if(src_a.toInt != src_b.toInt) 1 else 0
                    case ALU_BGE => if(src_a.toInt >= src_b.toInt) 1 else  0
                    case ALU_BLT => if(src_a.toInt < src_b.toInt) 1 else  0
                    // case _=> 0
                }
            
            
                    println(s"aluop=>$result")
                    c.io.branch_input_a.poke(src_a.S)
                    c.io.branch_input_b.poke(src_b.S)
                    c.io.branch_func.poke(aluop)
                    c . clock . step (1)
                    c . io . branch_output.expect (result.B)
                }
            
            c . clock . step (200)}
        }
    }