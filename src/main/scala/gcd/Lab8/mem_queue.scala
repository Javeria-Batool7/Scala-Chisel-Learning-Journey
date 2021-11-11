package Lab8
import chisel3._
import chisel3.util._
class mem_queue extends Module{
    val io = IO(new Bundle{
        val mem_out = Output(UInt(32.W))
        val requestor = Vec(4,Flipped(Decoupled ( UInt (32. W ) ) ))
        val read_addr = Input(UInt(5.W))
        val write_addr = Input(UInt(5.W))
        val write_en = Input(Bool())
    })
    val mem = Mem(32 , UInt(32.W))
    val queue_0 = Queue(io.requestor(0) , 1)
    val queue_1 = Queue(io.requestor(1) , 1)
    val queue_2 = Queue(io.requestor(2) , 1)
    val queue_3 = Queue(io.requestor(3) , 1)
    queue_0.nodeq()
    queue_1.nodeq()
    queue_2.nodeq()
    queue_3.nodeq()
    val arbitary = Module ( new RRArbiter ( UInt () , 4) )
    arbitary.io.in(0)<> queue_0
    arbitary.io.in(1) <> queue_1
    arbitary.io.in(2) <> queue_2
    arbitary.io.in(3) <> queue_3
    arbitary.io.out.ready := 1.U
    when (io.write_en ){
        mem.write(io.write_addr , (arbitary.io.out) .asUInt)
    }
    io.mem_out := mem.read(io.read_addr)
}