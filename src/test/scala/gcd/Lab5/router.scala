package Lab5
import chisel3 . _
import chisel3 . util . _
class interface_router [ T <: Data](generic : T) extends Bundle{
    val add_feild = (UInt(5.W))
    val data_feild = (generic)
}
class router(size : UInt) extends Module {
    val io = IO(new Bundle{
        val in_data = Input(new interface_router(size))
        val out_data = Output(new interface_router(size))
    })
    io.out_data := io.in_data
}