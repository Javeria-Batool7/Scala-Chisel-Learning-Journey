package TASK

import java.lang

object opt {
  def name(name: Option[String] = None): String = name match {
    case Some(string: String) => s"You name  may be ${name}"
    case None => "You are anonymous"
  }
  def main(args: Array[String]): Unit = {
    println(name())
    println(name(Some("Javeria")))
    
  }
}
