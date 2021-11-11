package Lab1
import chisel3 . _
import chisel3 . util . _
import java . io . File
class counter_up_down ( n : UInt ) extends Module {
    val io = IO ( new Bundle {
        val data_in = Input ( UInt ( 4 . W ) )
        val reload = Input ( Bool () )
        val out = Output ( Bool () )
        })
    var updown_counter = RegInit(0.U(4.W))
    val counter = RegInit (0. U ( 3 . W ) )
    val max_count = RegInit (6. U ( 4 . W ) )
    val max = ((1 .U << n) - 1 .U )
    val count = RegInit(0. U (4. W))
    io.out := 0 . U
    when (count === max){
        max_count := max_count - 1.U  
        updown_counter := updown_counter - 1.U
        when (max_count === 0.U){
            count := 0.U
        }
    }
    .otherwise {
        count := count + 1 .U
        updown_counter := updown_counter + 1.U
    }
    when (updown_counter === 0.U){
        io.out := 1.U
    }
    .elsewhen(updown_counter === max){
        io.out := 1.U
    }
}