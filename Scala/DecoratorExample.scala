import scroll.internal.support.DispatchQuery
import DispatchQuery._
import scroll.internal.Compartment
import scroll.internal.util.Many._

object DecoratorExample extends App {

  case class GenericComponent() {
    var str = new String
  }

  case class DecoratorCompartment() extends Compartment {
    import Relationship._

    class ComponentCore() extends GenericComponent {
      def this(text: String) {
        this()
        str = text
      }

      def getStr(): String = str
      def setStr(c: String): Unit = { str=c  }
    }

    class Decorator(c: ComponentCore) extends GenericComponent {
      str = c.getStr()
      def operation(): Unit = {
        println("Passed to Decorator" + str)
      }
    }

    //Concrete Decorator for border
    case class ConcreteDecorator1(newStjate: Unit) {
      def operation(s :String ): Unit = {
        println("Changing border color...." + s )
      }
    }

    //Concrete Decorator for text colour change
    case class ConcreteDecorator2(newState: Unit) {
      def operation(s: String): Unit = {
        println("Changing text colour..." + s )
      }
    }
  }


  new DecoratorCompartment{
    var gc = new ComponentCore("Hello world")
    var dc= new Decorator(gc)
    var cd1= new ConcreteDecorator1()
    var cd2= new ConcreteDecorator2()
    var x = dc.str

    println("Implement Decorator for Border colour: ")
    dc play cd1
    +dc operation x

    println("")
    println("Implement Decorator for text colour change: ")
    dc play cd2
    +dc operation x
  }

}