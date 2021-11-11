package Lab1
import chisel3 ._
class task_counter(counterBits : UInt) extends Module{
    val io = IO(new Bundle {
            val output = Output(Bool())
    })
    val max = (1 .S << counterBits) - 1 . S
    val count = RegInit(0. S (3. W))
    when (count === max){
        count := 0  .S
    }
    .otherwise {
        count := count + 1 .S
    }
    io.output :=  count (1. U)

}