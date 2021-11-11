package Lab2
import chisel3 . _
import chisel3 . util . _
class shifter extends Module {
    val io = IO ( new Bundle {
    val input = Vec (4 , Input ( Bool () ) )
    val selector = Vec (2 , Input ( Bool () ) )
    val shift = Input ( Bool () )
    val output = Vec (4 , Output ( Bool () ) )
    })
    val in_1 = Mux(io.shift,io.input(0),0.U)
    val in_2 = Mux(io.shift,io.input(1),0.U)
    val in_3 = Mux(io.shift,io.input(2),0.U)

    io.output(0):=Mux(io.selector(1),Mux(io.selector(0),io.input(0),io.input(1)),Mux(io.selector(0),io.input(2),io.input(3))) 
    io.output(1):=Mux(io.selector(1),Mux(io.selector(0),io.input(1),io.input(2)),Mux(io.selector(0),io.input(3),in_1))
    io.output(2):=Mux(io.selector(1),Mux(io.selector(0),io.input(2),io.input(3)),Mux(io.selector(0),in_2,in_1))
    io.output(3):=Mux(io.selector(1),Mux(io.selector(0),io.input(3),in_1),Mux(io.selector(0),in_2,in_3))

}