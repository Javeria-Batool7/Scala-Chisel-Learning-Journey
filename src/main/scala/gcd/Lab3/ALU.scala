package Lab3
import chisel3 . _
import chisel3 . util . _
import scala.language.postfixOps;
class ALU extends Module{
    val io = IO(new Bundle{
        val input_a = Input(SInt(32.W))
        val input_b = Input(SInt(32.W))
        val alu_op = Input(UInt(4.W))
        val alu_output = Output(UInt(32.W))
    })
    io.alu_output := 0.U
    val sra = io.input_a >> io.input_b(4,0)
    val alu_a = (io.input_a). asUInt
    val alu_b = (io.input_b). asUInt
    val sra_unsigned = (sra). asUInt
    switch(io.alu_op){
        is("b0000".U){
            io.alu_output := alu_a + alu_b
        }
        is("b0001".U){
            io.alu_output := alu_a - alu_b
        }
        is("b1100".U){
            io.alu_output := alu_a | alu_b
        }
        is("b1110".U){
            io.alu_output := alu_a & alu_b
        }
        is("b1000".U){
            io.alu_output := alu_a ^ alu_b
        }
        is("b0100".U){
            io.alu_output := io.input_a < io.input_b
        }
        is("b0010".U){
            io.alu_output := alu_a << alu_b(4,0)
        }
        is("b1010".U){
            io.alu_output := alu_a >> alu_b(4,0)
        }
        is("b1011".U){
            io.alu_output := sra_unsigned
        }
        is("b0110".U){
            io.alu_output := alu_a < alu_b
        }

    


    }
    
}
