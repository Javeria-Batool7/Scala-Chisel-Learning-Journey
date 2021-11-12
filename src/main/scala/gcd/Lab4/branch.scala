package Lab4
import chisel3 . _
import chisel3 . util . _

object BranchOP {
    val ALU_BEQ = 0.U(2.W)
    val ALU_BNE = 1.U(2.W)
    val ALU_BGE = 2.U(2.W)
    val ALU_BLT =3.U(2.W)
    //val ALU_BLTU = 4.U(2.W)
    //val 
}


class branch extends Module{
    val io = IO(new Bundle{
        val branch_input_a = Input(SInt(32.W))
        val branch_input_b = Input(SInt(32.W))
        val branch_func = Input(UInt(2.W))
        val branch_output = Output(Bool())
        })

            io.branch_output := 0.B
            switch(io.branch_func){
                is("b00".U){
                    when(io.branch_input_a === io.branch_input_b){
                        io.branch_output := 1.B}
                        .otherwise{
                            io.branch_output := 0.B
                            
                        }
                }
                is("b01".U){
                    when(io.branch_input_a =/= io.branch_input_b){
                        io.branch_output := 1.B
                } .otherwise{
                            io.branch_output := 0.B
                            
                        }
                }
                is("b10".U){
                    when(io.branch_input_a >= io.branch_input_b){
                        io.branch_output := 1.B
                } .otherwise{
                            io.branch_output := 0.B
                            
                        }
                }
                is("b11".U){
                    when(io.branch_input_a < io.branch_input_b){
                        io.branch_output := 1.B
                } .otherwise{
                            io.branch_output := 0.B
                            
                        }
                }
                

            
        }
        
        
        
        
        
        }