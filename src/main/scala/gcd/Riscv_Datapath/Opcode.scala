package datapath_risc_v
import chisel3._
import chisel3.util._
class opcode extends Module{
    val io = IO(new Bundle{
        val opcode = Input(UInt(7.W))
        val r = Output(UInt(1.W))
        val load = Output(UInt(1.W))
        val i = Output(UInt(1.W))
        val sb = Output(UInt(1.W))
        val s = Output(UInt(1.W))
        val lui = Output(UInt(1.W))
        val jal = Output(UInt(1.W))
        val jalr = Output(UInt(1.W))
        val auipc = Output(UInt(1.W))
   })
    io.r := 0.U
    io.load := 0.U
    io.i := 0.U
    io.sb := 0.U
    io.s := 0.U
    io.lui := 0.U
    io.jal := 0.U
    io.jalr := 0.U
    io.auipc := 0.U
    when (io.opcode === "b0110011".U){
        io.r := 1.U
    }
    .elsewhen(io.opcode === "b0000011".U){
        io.load := 1.U
    }
    .elsewhen(io.opcode === "b0010011".U){
        io.i := 1.U
    }
    .elsewhen(io.opcode === "b0100011".U){
        io.s := 1.U
    }
    .elsewhen(io.opcode === "b1100011".U){
        io.sb := 1.U
    }
    .elsewhen(io.opcode === "b0110111".U){
        io.lui := 1.U
    }
    .elsewhen(io.opcode === "b1101111".U){
        io.jal := 1.U
    }
    .elsewhen(io.opcode === "b1100111".U){
        io.jalr := 1.U
    }
    .elsewhen(io.opcode === "b0010111".U){
        io.auipc := 1.U
    }
} 
