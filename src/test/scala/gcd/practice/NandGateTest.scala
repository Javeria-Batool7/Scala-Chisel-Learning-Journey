package practice

import org.scalatest._
import chiseltest._
import chisel3._

class NandGateTest extends FreeSpec with ChiselScalatestTester{
    "Nand Gate Test" in {
        test(new NandGate()){ c=>
        c.io.a.poke(0.U)
        c.io.b.poke(0.U)
        c.clock.step(1)
        c.io.output.expect(1.U)
        }}
}