package practice

import org.scalatest._
import chiseltest._
import chisel3._

class NotTest extends FreeSpec with ChiselScalatestTester{
    "Not Test" in {
        test(new Not()){ c=>
        c.io.a.poke(0 U)
        c.clock.step(1)
        c.io.output.expect(1 U)
        }}
}