package Lab7
import chisel3 . _
import chisel3 . util . _
import chisel3 . experimental . ChiselEnum
class fsm extends Module{
    val io = IO(new Bundle{
        val f1_in = Input(Bool())
        val f2_in = Input(Bool())
        val r1_in = Input(Bool())
        val r2_in = Input(Bool())
        val out = Output(UInt(10.W))
    })
    val s0 :: s1 :: s2 :: s3 :: s4 :: s5 :: Nil = Enum(6)
    val state = RegInit(s0)
    io.out := 0.U
    switch(state){
        is (s0){
            when ((! io.f1_in) && (io.f2_in)){
                state := s0
            }
            .elsewhen (io.f1_in && (! io.f2_in)){
                state := s1
            }
            .elsewhen((! io.f1_in) && io.f2_in){
                state := s5
            }
            .elsewhen(io.f1_in && io.f2_in){
                state := s1
            }
        }
        is (s1){
            when ((! io.f1_in) && (! io.r1_in)){
                state := s1
            }
            .elsewhen (io.f1_in){
                state := s2
            }
            .elsewhen ((! io.f1_in) && (io.r1_in)){
                state := s0
            }
        }
        is (s2){
            when (( io.f1_in) && (! io.r1_in)){
                state := s2 
            }
            .elsewhen (io.f1_in){
                state := s3
            }
            .elsewhen ((! io.f1_in) && (io.r1_in)){
                state := s1
            }
        io.out := 3.U
        }
        is (s3) {
            state := s0  
        }
        is (s4){
            when (io.f2_in){
                state := s3
            }
            .elsewhen ((! io.f2_in) && (! io.r2_in)){
                state := s4
            }
            .elsewhen ((! io.f1_in) && (io.r2_in)){
                state := s5
            }
        io.out := 7.U
        }
        is (s5){
            when (io.f2_in){
                state := s4
            }
            .elsewhen ((! io.f2_in) && (! io.r2_in)){
                state := s5
            }
            .elsewhen ((! io.f2_in) && (io.r2_in)){
                state := s0
            }
        }
    }
    }
