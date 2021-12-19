package datapath_risc_v
import chisel3._
import chisel3.util._
class controluint extends Module{
    val io = IO(new Bundle{
        val opcode = Input(UInt(7.W))
        val mem_write = Output(UInt(1.W))
        val mem_read = Output(UInt(1.W))
        val reg_write = Output(UInt(1.W))
        val immsel = Output(UInt(1.W))
        val loadsel = Output(UInt(1.W))
        val branch = Output(UInt(1.W))
        val auipc_out = Output(UInt(1.W))
        val lui_out = Output(UInt(1.W))
        val jal_out = Output(UInt(1.W))
        val jalr_out = Output(UInt(1.W))
    })
    val control = Module(new controller())
    val op_code = Module(new opcode())
    op_code.io.opcode := io.opcode
    control.io.r := op_code.io.r
    control.io.load := op_code.io.load
    control.io.i := op_code.io.i
    control.io.store := op_code.io.s
    control.io.lui := op_code.io.lui
    control.io.jal := op_code.io.jal
    control.io.jalr := op_code.io.jalr
    control.io.sb := op_code.io.sb
    control.io.auipc := op_code.io.auipc
    io.mem_write := control.io.mem_write
    io.mem_read := control.io.mem_read
    io.reg_write := control.io.reg_write
    io.loadsel := control.io.loadsel
    io.immsel := control.io.immsel
    io.branch := control.io.branch
    io.auipc_out := control.io.auipc_out
    io.lui_out := control.io.lui_out
    io.jal_out := control.io.jal_out
    io.jalr_out := control.io.jalr_out
}
