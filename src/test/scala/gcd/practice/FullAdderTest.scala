package practice

import org.scalatest._
import chiseltest._
import chisel3._

class FullAdderTest extends FreeSpec with ChiselScalatestTester{
    "Full Adder Test (Sum)" in {
        test(new FullAdder()){ c=>
        c.io.a.poke(1.U)
        c.io.b.poke(0.U)
        c.io.j.poke(1.U)
        c.clock.step(1)
        c.io.output_sum.expect(0.U)
        c.io.output_carry.expect(1.U)
        }}
}