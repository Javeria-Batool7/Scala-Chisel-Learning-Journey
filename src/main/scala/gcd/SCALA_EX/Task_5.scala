package TASK
import scala.collection.mutable.Map
object map {
  def main (args : Array[String]) : Unit = {
    var lst = Array(1 , 2 , 3 , 4 ,5)
    var mapping = Map()
    for (x <- lst){
      if ( x % 2 == 0){
        val maps = true
        var lst = mapping.mapFactory(x -> maps )
        println(lst)
      }
      else {
        val false_map = false
        var lst_1 = mapping.mapFactory(x -> false_map)
        println(lst_1)
      }
    }
  }
}
