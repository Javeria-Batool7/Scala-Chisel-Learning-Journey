package TASK
import scala.collection.mutable.Set
import scala.collection.mutable.Map
object SETS {
  def main (args : Array[String]) : Unit = {
    var set = Set("apple" , "orange" , "bananas")
    var s = set.add(("pears"))
    println("SETS : ")
    for (i <- set) {
      println(i)
    }
    var map = Map("Pakistan" -> "Karachi" , "India" -> "New Dehli" , "Bangladesh" -> "Dhaka")
    var m = map.addOne("Sindh" -> "Balochistan")
    println("MAP : ")
    for (i <- map) {
      println(i)
    }
  }
}
