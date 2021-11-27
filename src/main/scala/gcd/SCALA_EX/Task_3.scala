package TASK
import scala.collection.mutable.ListBuffer
case object prime_no{
  def main (args : Array[String]) : Unit ={
    var lst_1 = ListBuffer[Int](1 , 2 , 3 )
    var lst_2 = ListBuffer[Int](4 , 5 , 6)
    var name = ListBuffer[Int]()
    for (i <- 0 to 4){
      var y = lst_1(i) + lst_2(i)
      name += y
      println(name)
    }
  }
}
