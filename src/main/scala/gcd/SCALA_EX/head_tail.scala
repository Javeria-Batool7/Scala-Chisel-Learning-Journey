package TASK
import scala.util.Random
object head_tail {
  def main (args : Array[String]) : Unit = {
    var arr = Array()
    for (i <- 1 to 1){
      val t = arr.appended(Random.between(10 , 70))
      println(t)
      println(t.head)
      println(t.tail)
    }
  }
}
