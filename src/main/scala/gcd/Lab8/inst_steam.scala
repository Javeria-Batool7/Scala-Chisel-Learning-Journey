package Lab8
import chisel3 . _
import chisel3.util.experimental.loadMemoryFromFile
import scala . io . Source
class InstMemIO extends Bundle {
    val addr = Input ( UInt ( 32 . W ) )
    val inst = Output ( UInt ( 32. W ) )
}
class InstMem ( initFile : String ) extends Module {
    val io = IO ( new InstMemIO )
    // INST_MEM_LEN in Bytes or INST_MEM_LEN / 4 in words
    val inst_mem_len = 1024
    val imem = Mem ( inst_mem_len , UInt ( 32 . W ) )
    loadMemoryFromFile ( imem , initFile )
    io . inst := imem ( io . addr )
}