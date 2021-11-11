package practice

import org.scalatest._
import chiseltest._
import chisel3._

class HalfAdderTest_Sum extends FreeSpec with ChiselScalatestTester{
    "Half Adder Test (Sum)" in {
        test(new HalfAdder_Sum()){ c=>
        c.io.a.poke(1.U)
        c.io.b.poke(0.U)
        c.clock.step(1)
        c.io.output_Sum.expect(1.U)
        c.io.output_Carry.expect(0.U)
        }}
  
}

