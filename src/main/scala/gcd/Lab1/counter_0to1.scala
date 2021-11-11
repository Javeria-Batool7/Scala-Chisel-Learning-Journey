package Lab1
import chisel3 ._
class counter_0to1() extends Module{
    val io = IO(new Bundle {
            val output = Output(Bool())
    })
    val max = (1 .S << 1 . U) - 1. S
    val count = RegInit(0. S (2. W))
    when (count === max){
        count := 0 . S
    }
    .otherwise {
        count := count + 1 .S
    }
    io.output :=  count(0.U)

}
