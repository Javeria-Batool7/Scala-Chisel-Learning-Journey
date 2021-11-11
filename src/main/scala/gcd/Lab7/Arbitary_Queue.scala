package Lab7
import chisel3 . _
import chisel3 . util . _
class Arbitary_Queue extends Module{
    val io = IO(new Bundle{
        val in = Flipped(Decoupled(UInt(7.W)))
        val out = Decoupled(UInt(7.W))
    })
    val queue_0 = Queue(io.in , 3)
    val queue_1 = Queue(queue_0 , 3)
    val arbitary = Module ( new RRArbiter ( UInt (7.W) , 3) )
    io.out.valid(1.B)
    
    when ((queue_1.valid && io.out.ready)===1.B){
        io.out.enq(queue_1.deq)}
        arbitary.io.in(0) <> queue_1
        arbitary.io.in(1) <> queue_1
        arbitary.io.in(2) <> queue_1
    io.out <> arbitary.io.out
    
}
