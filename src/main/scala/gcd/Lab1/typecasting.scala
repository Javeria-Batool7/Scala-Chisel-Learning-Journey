package Lab1
import chisel3 ._
import scala.language.postfixOps;
class typecasting(counterBits : UInt) extends Module{
    val io = IO(new Bundle {
            val output = Output(Bool())
    })
    val max = ((1 .S << counterBits) - 1 . S)
    val max_signed = (max). asUInt
    val count = RegInit(0. U (4. W))
    when (count === max_signed){
        count := 0  .U
    }
    .otherwise {
        count := count + 1 .U
    }
    io.output :=  count (0. U)

}