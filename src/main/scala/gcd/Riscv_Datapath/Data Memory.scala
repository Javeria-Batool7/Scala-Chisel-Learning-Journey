package datapath_risc_v
import chisel3._
import chisel3.util.experimental.loadMemoryFromFile
class DATA_MEM extends Module{
    val io = IO (new Bundle{
        val mem_add = Input(UInt(24.W))
        val mem_data = Output(SInt(32.W))
        val mem_data_in = Input(SInt(32.W))
        val mem_load = Input(Bool())
        val mem_store = Input(Bool())
    })
    val mem = Mem(1024, SInt(32.W))
    when (io.mem_load){
        io.mem_data := mem(io.mem_add)
    }
    .otherwise{
        io.mem_data := 0.S
    }
    when (io.mem_store){
    mem(io.mem_add) := io.mem_data_in
    }

}
