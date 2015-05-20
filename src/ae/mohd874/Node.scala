package ae.mohd874

import ae.mohd874.EntityEngine.Types._

object NodeBuilder {
	val engine = EntityEngine
	private var bufferNode = engine.createEntity()
	
	def createCircle(pos: (Int, Int), rad: Int): Entity = {
	  val props: Props = engine.createProps() ++ Map("pos" -> pos, "radius" -> rad)
	  engine.createEntity(props)
	}
	
	def createNode = {
	  bufferNode = engine.createEntity()
	  this
	}
	
	def addProp(p: (String, Any)) = {
	  engine.addPropsToEntity(bufferNode, engine.createProps() ++ Map(p))
	  this
	}
	
	def addAction(a: (String, Props => Unit)) = {
	  engine.addActionsToEntity(bufferNode, engine.createActions() ++ Map(a))
	  this
	}
	
	def addVelocity(vel: (Int, Int) = (0, 0)) = {
	  addProp(("vel" -> vel))
	}
	
	def addPosition(pos: (Int, Int) = (0, 0)) = {
	  addProp(("pos" -> pos))
	}
	
	def buildNode = bufferNode
	
}