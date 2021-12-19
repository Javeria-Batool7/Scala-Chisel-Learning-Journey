package datapath_risc_v
import chisel3._
class pc extends Module{
    val io = IO(new Bundle{
        val pc_input = Input(UInt(32.W)) 
        val pc_output = Output(UInt(32.W)) //output that goes into inst mem
        val pc_adder = Output(UInt(32.W)) //output that has to be added by 4 and then goes into input..
    })
    val register = RegInit(0.U(32.W)) //pc register
    register := io.pc_input 
    io.pc_output := register
    io.pc_adder := register + 4.U
}
