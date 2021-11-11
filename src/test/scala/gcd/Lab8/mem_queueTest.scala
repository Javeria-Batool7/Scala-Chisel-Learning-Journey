package Lab8
import org.scalatest._
import chiseltest._
import chisel3._
class mem_queueTest extends FreeSpec with ChiselScalatestTester{
    "mem_queue" in  {
        test (new mem_queue()){c=>
        c.io.requestor(0).bits.poke(1.U)
        c.io.requestor(1).bits.poke(2.U)
        c.io.requestor(2).bits.poke(3.U)
        c.io.requestor(3).bits.poke(4.U)
        c.io.requestor(0).valid.poke(1 .B)
        c.io.requestor(1).valid.poke(1.B)
        c.io.requestor(2).valid.poke(1 .B)
        c.io.requestor(3).valid.poke(1 .B)
        c.io.read_addr.poke(2.U)
        c.io.write_addr.poke(2.U)
        c.io.write_en.poke(1.B)
        c.clock.step(7)}}}