import scroll.internal.support.DispatchQuery
import DispatchQuery._
import scroll.internal.Compartment
import scroll.internal.util.Many._

object IteratorExample extends App {
  case class IteratorCompartment() extends Compartment {
    import Relationship._

    class Collection(str: String) {
      var collectionName = str
    }

    //Iterator
    class TraversalIterator {
      def display: Unit = {
        println("Transfer to relevant iterator...")
      }
    }


    //Like External Iterator
    class MapIterator {
      def traverse(c: Collection): Unit = {
        println("Traverse the Map : " + c.collectionName)
      }
    }

    //Like Internal Iterator
    class TreeIterator {
      def traverse(c: Collection): Unit = {
        println("Traverse the Tree : " + c.collectionName)
      }
    }
  }

  new IteratorCompartment {
    var collectionMap= new Collection("Map")
    var collectionTree=new Collection("Tree")
    var mapIterator=new MapIterator
    var treeIterator=new TreeIterator
    var traversalIterator=new TraversalIterator

    //Traversal Iterator play the Map Iterator to do the iteration
    traversalIterator.display
    traversalIterator play mapIterator
    +traversalIterator traverse collectionMap

    println("------------------------------------------")
    //Traversal Iterator play the Tree Iterator to do the iteration
    traversalIterator.display
    traversalIterator play treeIterator
    +traversalIterator traverse collectionTree
  }
}