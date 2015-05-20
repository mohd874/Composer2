import ae.mohd874.NodeBuilder
import ae.mohd874.EntityEngine.Types._
import ae.mohd874.EntityEngine

object sketch {

	def move(props: Props) = {
      val (x: Int, y: Int) = props("pos")
      val (vx: Int, vy: Int) = props("vel")
      
      props += (("pos", (x + vx, y + vy)))
    }                                             //> move: (props: ae.mohd874.EntityEngine.Types.Props)ae.mohd874.EntityEngine.Ty
                                                  //| pes.Props
    
    val e = EntityEngine                          //> e  : ae.mohd874.EntityEngine.type = ae.mohd874.EntityEngine$@1ccb029

		val n = NodeBuilder.createNode.buildNode
                                                  //> n  : (ae.mohd874.NodeBuilder.engine.Types.Props, ae.mohd874.NodeBuilder.engi
                                                  //| ne.Types.Actions) = (Map(),Map())
		
		e.addPropsToEntity(n, e.createProps() ++ Map("pos" -> (0,0)))
                                                  //> res0: sketch.e.Types.Props = Map(pos -> (0,0))
		
		n                                 //> res1: (ae.mohd874.NodeBuilder.engine.Types.Props, ae.mohd874.NodeBuilder.eng
                                                  //| ine.Types.Actions) = (Map(pos -> (0,0)),Map())
  // Create first Rectangle
    NodeBuilder.createNode
    		   .addPosition((30, 50))
    		   .addVelocity((1,1))
    		   .addAction("move" -> move _)
    		   .buildNode                     //> res2: (ae.mohd874.NodeBuilder.engine.Types.Props, ae.mohd874.NodeBuilder.eng
                                                  //| ine.Types.Actions) = (Map(vel -> (1,1), pos -> (30,50)),Map(move -> <functio
                                                  //| n1>))
    
    // Create second Rectangle
    NodeBuilder.createNode
    		   .addPosition((70, 60))
    		   .addVelocity((2, -1))
    		   .addAction("move" -> move _)
    		   .buildNode                     //> res3: (ae.mohd874.NodeBuilder.engine.Types.Props, ae.mohd874.NodeBuilder.eng
                                                  //| ine.Types.Actions) = (Map(vel -> (2,-1), pos -> (70,60)),Map(move -> <functi
                                                  //| on1>))

		    		
		e.entities                        //> res4: scala.collection.mutable.MutableList[(scala.collection.mutable.Map[jav
                                                  //| a.lang.String,Any], scala.collection.mutable.Map[java.lang.String,scala.coll
                                                  //| ection.mutable.Map[java.lang.String,Any] => Unit])] = MutableList((Map(),Map
                                                  //| ()), (Map(pos -> (0,0)),Map()), (Map(vel -> (1,1), pos -> (30,50)),Map(move 
                                                  //| -> <function1>)), (Map(vel -> (2,-1), pos -> (70,60)),Map(move -> <function1
                                                  //| >)))
		
		e.update
		
		e.entities                        //> res5: scala.collection.mutable.MutableList[(scala.collection.mutable.Map[jav
                                                  //| a.lang.String,Any], scala.collection.mutable.Map[java.lang.String,scala.coll
                                                  //| ection.mutable.Map[java.lang.String,Any] => Unit])] = MutableList((Map(),Map
                                                  //| ()), (Map(pos -> (0,0)),Map()), (Map(vel -> (1,1), pos -> (31,51)),Map(move 
                                                  //| -> <function1>)), (Map(vel -> (2,-1), pos -> (72,59)),Map(move -> <function1
                                                  //| >)))
    		   
}