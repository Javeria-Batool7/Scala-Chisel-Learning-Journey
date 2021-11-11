package Lab3
import chisel3 . _
import chisel3.util._
class valid_decoder extends Module{
    val io = IO(new Bundle{
        val valid_in = Input(UInt(2.W))
        val valid_out = Valid(Output(UInt(4.W)))
    })
    io.valid_out.bits :=  4.U
    io.valid_out.valid := 1.B
    switch (io.valid_in){
        is ("b00".U){
            io.valid_out.bits := 1.U
        }
        is ("b01".U){
            io.valid_out.bits := 2.U
        }
        is ("b10".U){
            io.valid_out.bits := 3.U
        }
    }
}