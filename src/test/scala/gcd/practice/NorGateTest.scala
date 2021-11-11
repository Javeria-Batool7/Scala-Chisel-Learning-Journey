package practice

import org.scalatest._
import chiseltest._
import chisel3._

class NorGateTest extends FreeSpec with ChiselScalatestTester{
    "Nor Gate Test" in {
        test(new NorGate()){ c=>
        c.io.a.poke(0.U)
        c.io.b.poke(1.U)
        c.clock.step(1)
        c.io.output.expect(0.U)
        }}
}