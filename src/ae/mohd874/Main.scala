package ae.mohd874

import processing.core.PApplet
import scala.collection.mutable.Map

object Main extends App{
  new Composer().main(Array())
}

class Composer extends PApplet {
  def main (argv: Array[String]) = {
    PApplet.main(Array("ae.mohd874.Composer"))
  }
  
  val engine = Engine
  
  // For testing only. Should be removed
  def test = {
    println("This function is For testing only. Should be removed later")
    def move(props: Props) = {
      val (x: Int, y: Int) = props.props("pos")
      val (vx: Int, vy: Int) = props.props("vel")
      
      props.props += (("pos", (x + vx, y + vy)))
    }
    
    def paint(props: Props) = {
      val (x: Int, y: Int) = props.props("pos")
      rect(x, y, 9, 9)
    }
    
    val props1 = Props(Map("pos" -> (30,50), "vel" -> (0,2)))
    val acts1 = Actions(Map("move" -> move _, "paint" -> paint _))
    
    val props2 = Props(Map("pos" -> (70,60), "vel" -> (2,-1)))
    val acts2 = Actions(Map("move" -> move _, "paint" -> paint _))
   
    engine.entities += ((props1, acts1), (props2, acts2))
  }
  
  override def setup = {
    size(640, 480)
    background(255)
    fill(100,100,100)
    test
  }
  
  override def draw = {
    background(255)
    rect(20, 40, 9, 9)
    text("Testing Entity Engine", 20, 20)
    engine.update
  }
}