package Lab8
import org.scalatest._
import chiseltest._
import chisel3._

class inst_steamTest extends FreeSpec with ChiselScalatestTester{
    "instruction" in  {
        test (new InstMem("/home/javeriabatool/Desktop/Chisel/Scala-Chisel-Learning-Journey/src/test/scala/Lab8/inst.txt")){c=>
        c.io.addr.poke(1.U)
        c.io.inst.expect(47186195.U)
        c.clock.step(50)
        }
    }
}
