package datapath_risc_v
import chisel3 . _
import chisel3 . util . _
import chisel3 . util . experimental . loadMemoryFromFile
class inst_mem extends Module{
    val io = IO (new Bundle{
        val mem_add = Input(UInt(24.W))
        val mem_Data = Output(UInt(32.W))
    })
    val mem = Mem(1024,UInt(32.W))
    io.mem_Data := mem(io.mem_add)
    loadMemoryFromFile(mem , "/home/javeriabatool/javeria.txt")
}
