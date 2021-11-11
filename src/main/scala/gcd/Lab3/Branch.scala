package Lab3
import chisel3 . _
import chisel3 . util . _
class Branch extends Module{
    val io = IO(new Bundle{
        val branch_input_a = Input(SInt(32.W))
        val branch_input_b = Input(SInt(32.W))
        val branch_op = Input(Bool())
        val fuc       = Input(UInt(3.W))
        val branch_output = Output(UInt(32.W))
        })
    io.branch_output := 0.B
    switch(io.branch_op){
        is(1.B){
            switch(io.fuc){
                is("b000".U){
                    when(io.branch_input_a === io.branch_input_b){
                        io.branch_output := 1.B
                }}
                is("b001".U){
                    when(io.branch_input_a =/= io.branch_input_b){
                        io.branch_output := 1.B
                }}
                is("b100".U){
                    when(io.branch_input_a > io.branch_input_b){
                        io.branch_output := 1.B
                }}
                is("b101".U){
                    when(io.branch_input_a < io.branch_input_b){
                        io.branch_output := 1.B
                }}}
                
            
        }
        
        
        
        
        
        }

}