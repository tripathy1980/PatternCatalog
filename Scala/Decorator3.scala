import scroll.internal.support.DispatchQuery
import DispatchQuery._
import scroll.internal.Compartment
import scroll.internal.util.Many._

object Decorator extends App {

  case class GenericComponent() {
    var s = new String
  }

  case class DecoratorPattern() extends Compartment {
    import Relationship._

    def callNewOperation(c: GenericComponent): Unit = {
      // TODO: auto-generated method-stub. Implement!
    }

    def callOperation(c: GenericComponent): Unit = {
      // TODO: auto-generated method-stub. Implement!
    }

    class ComponentCore() extends GenericComponent {
      def this(text: String) {
        this()
        s = text
      }

      def getS(): String = s
      def setS(c: String): Unit = { s=c  }
    }

    class Decorator(c: ComponentCore) extends GenericComponent {
       s = c.getS()
      def operation(): Unit = {
        // TODO: auto-generated method-stub. Implement!
        println("Passed to Decorator" + s)
      }
    }



    case class ConcreteDecorator1(newStjate: Unit) {

      def newOperation(): Unit = {
        // TODO: auto-generated method-stub. Implement!
      }

      def operation(o:String ): Unit = {
        // TODO: auto-generated method-stub. Implement!
        println("Drawing...." + o )
      }
    }

    case class ConcreteDecorator2(newState: Unit) {

      def newOperation(): Unit = {
        // TODO: auto-generated method-stub. Implement!
      }

      def operation(o: String): Unit = {
        // TODO: auto-generated method-stub. Implement!
        println("Changing text colour..." + o )
      }
    }


    /*RoleGroup("ConcreteDecorators").containing[ConcreteDecorator1, ConcreteDecorator2](0, *)(2, 2)

    RoleEquivalence[Decorator, ConcreteDecorator1]()

    RoleEquivalence[Decorator, ConcreteDecorator2]()

    val useComponent = Relationship("useComponent").from[Decorator](0 To *).to[Component](1)

    AddRoleRestriction[GenericComponent, Decorator]

    AddRoleRestriction[GenericComponent, Component]

    AddRoleRestriction[GenericComponent, ConcreteDecorator1]

    AddRoleRestriction[GenericComponent, ConcreteDecorator2]*/



  }


  new DecoratorPattern{
    var gc = new ComponentCore("Hello world")

    var dc= new Decorator(gc)
    var cd1= new ConcreteDecorator1()
    var cd2= new ConcreteDecorator2()
    var x = dc.s
    println("Implement Decorator for drawing")
    dc play cd1
    +dc operation x

    println("Implement Decorator for colour change")
    dc play cd2
    +dc operation x
  }

}