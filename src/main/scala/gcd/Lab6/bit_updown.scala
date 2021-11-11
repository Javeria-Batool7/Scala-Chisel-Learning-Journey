package Lab6
import chisel3 . _
import chisel3 . util . _
class bit_updown (val max : Int , val min :Int = 0) extends Module{
    val io = IO(new Bundle{
        val out = Output(UInt ( log2Ceil ( max ) . W))
        val enable = Input(Bool())
    })
    io.out := 0.U
    when (io.enable){
        val reg = RegInit(min.U(log2Ceil(max).W))
        when (reg === max.U){
            reg := min.U
        }
        .otherwise{
            reg:=reg+1.U
            }
        io.out := reg
    }
    .otherwise{
        val reg = RegInit(max.U(log2Ceil(max).W))
        when (reg === min.U){
            reg := max.U
        }
        .otherwise{
            reg:=reg-1.U
        io.out := reg
        }
        }
}
