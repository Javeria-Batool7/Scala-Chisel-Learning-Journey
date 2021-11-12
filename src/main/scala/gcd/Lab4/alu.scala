package Lab4
import chisel3 . _
import chisel3 . util . _
import scala.language.postfixOps;
object ALUOP{
    val ALU_ADD = 0.U(4.W)
    val ALU_SLL = 1.U(4.W)
    val ALU_SLT = 2.U(4.W)
    val ALU_XOR  = 4.U(4.W)
    val ALU_SRL = 5.U(4.W)
    val ALU_OR = 6.U(4.W)
    val ALU_AND = 7.U(4.W)
    val ALU_SUB= 8.U(4.W)

}
class alu extends Module{
    val io = IO(new Bundle{
        val input_a = Input(UInt(32.W))
        val input_b = Input(UInt(32.W))
        val alu_op = Input(UInt(5.W))
        val alu_output = Output(UInt(32.W))
    })
    io.alu_output := 0.U
    switch(io.alu_op){
        is(0.U){
            io.alu_output := io.input_a + io.input_b
        }
        is(1.U){
            io.alu_output := io.input_a << io.input_b(4,0)
        }
        is(2.U){
            when (io.input_a < io.input_b){
                io.alu_output := 1.U
            }
            .otherwise{
                io.alu_output := 0.U
            }
        }
        is(3.U){
            io.alu_output := io.input_a ^ io.input_b
        }
        is(4.U){
            io.alu_output := io.input_a >> io.input_b(4,0)
        }
        is(5.U){
            io.alu_output := io.input_a | io.input_b
        }
        is(6.U){
            io.alu_output := io.input_a & io.input_b
        }
        is(7.U){
            io.alu_output := io.input_a - io.input_b
        }

    


    }
    
}
