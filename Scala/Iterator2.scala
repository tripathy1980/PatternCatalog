import scroll.internal.support.DispatchQuery
import DispatchQuery._
import scroll.internal.Compartment
import scroll.internal.util.Many._

object Iterator2 extends App {


  case class IteratorCompartment() extends Compartment {

    import Relationship._

    class Collection(s: String) {
      var collectionName = s
    }

    class TraversalIterator {
      def display: Unit = {
        println("Transfer to relevant iterator...")
      }
    }

    class MapIterator {
      def traverse(c: Collection): Unit = {
        println("traverse the Map : " + c.collectionName)
      }
    }

    class TreeIterator {
      def traverse(c: Collection): Unit = {
        println("traverse the Tree : " + c.collectionName)
      }
    }

  }


  new IteratorCompartment {
    var collectionMap= new Collection("Map")
    var collectionTree=new Collection("Tree")
    var mapIterator=new MapIterator
    var treeIterator=new TreeIterator
    var traversalIterator=new TraversalIterator

    traversalIterator.display
    traversalIterator play mapIterator
    +traversalIterator traverse collectionMap

    traversalIterator.display
    traversalIterator play treeIterator
    +traversalIterator traverse collectionTree

  }
}