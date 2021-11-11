package Lab8
import chisel3 . _
import chisel3 . util . _
class memory extends Module{
    val io = IO(new Bundle{
        val enable = Input(Bool())
        val data_in = Input(Vec(4 , UInt(32.W)))
        val data_out = Output(UInt(32.W))
        val write = Input(Bool())
        val addr = Input(UInt(5.W))
        val data_sel = Input(UInt(2.W))

    })
    val mem = SyncReadMem(32 , UInt(32.W))
    mem.write(io.addr , io.data_in(io.data_sel))
    io.data_out := mem.read(io.addr , io.enable) 
}