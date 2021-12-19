package datapath_risc_v
import chisel3._
import chisel3 . util . _
import scala.language.postfixOps;
class alu1 extends Module{
    val io = IO(new Bundle{
        val a = Input(SInt(32.W))
        val b = Input(SInt(32.W))
        val output = Output(SInt(32.W))
        val branch = Output(UInt(1.W))
        val alu_op = Input(UInt(5.W)) 
    })
    io.output := 0.S
    //add 00000
    when (io.alu_op === "b00000".U){
        io.output := io.a + io.b
    }
    //Sub 01000
    .elsewhen(io.alu_op === "b01000".U){
        io.output := io.a - io.b
    }
    //And 00111
    .elsewhen (io.alu_op === "b00111".U){
        io.output := io.a & io.b
    }
    //Or 00110
    .elsewhen(io.alu_op === "b00110".U){
        io.output := io.a | io.b
    }
    //Xor 00100
    .elsewhen(io.alu_op === "b00100".U){
        io.output := io.a ^ io.b
    }
    //SLL 00001
    .elsewhen (io.alu_op === "b00001".U){
        io.output := io.a << io.b(4,0)
    }
    //slt 00010
    .elsewhen (io.alu_op === "b00010".U){
        when (io.a < io.b){
            io.output := 1.S
        }
        .otherwise{
            io.output := 0.S
        }
    }
    //srl 00101
    .elsewhen (io.alu_op === "b00101".U){
        io.output := io.a >> io.b(4 , 0)
    }
    //sra 01101
    .elsewhen(io.alu_op === "b01101".U){
        io.output := io.a >> io.b(4 ,0)
    }
    //beq 10000
    .elsewhen (io.alu_op === "b10000".U){
        when (io.a === io.b){
            io.output := 1.S
        }
        .otherwise {
            io.output := 0.S
        }
    }
    //bne 10001
    .elsewhen (io.alu_op === "b10001".U ){
        when (io.a != io.b){
            io.output := 1.S
        }
        .otherwise {
            io.output := 0.S
        }
    }
    //blt 10100
    .elsewhen (io.alu_op === "b10100".U){
        when (io.a < io.b){
            io.output := 1.S
        }
        .otherwise {
            io.output := 0.S
        }
    }
    //bge
    .elsewhen (io.alu_op === "b10101".U){
        when (io.a >= io.b){
            io.output := 1.S
        }
        .otherwise {
            io.output:= 0.S
        }
    }
    //sltu 
    .elsewhen (io.alu_op === "b00011".U ){
        when (io.a.asUInt < io.b.asUInt){
            io.output := 1.S
        }
        .otherwise{
            io.output := 0.S
        }
    }
    //bltu
    .elsewhen(io.alu_op === "b10110".U){
        when (io.a.asUInt < io.b.asUInt){
            io.output := 1.S
        }
        .otherwise{
            io.output := 0.S
        }
    }
    when (io.alu_op(4 , 3) === "b10".U & io.output === 1.S){
        io.branch:= 1.U
    }
    .otherwise{
        io.branch := 0.U
    }
} 
