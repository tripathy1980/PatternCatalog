import scroll.internal.support.DispatchQuery
import DispatchQuery._
import scroll.internal.Compartment
import scroll.internal.util.Many._

object Decorator extends App {

  case class GenericComponent() {

    def operation(): Unit = {
      // TODO: auto-generated method-stub. Implement!
    }
  }

  case class Decorator() extends Compartment {
    import Relationship._

    def callNewOperation(c: GenericComponent): Unit = {
      // TODO: auto-generated method-stub. Implement!
    }

    def callOperation(c: GenericComponent): Unit = {
      // TODO: auto-generated method-stub. Implement!
    }

    case class Decorator() {

      def operation(): Unit = {
        // TODO: auto-generated method-stub. Implement!
      }
    }

    case class Component() {

    }

    case class ConcreteDecorator1(newState: Unit) {

      def newOperation(): Unit = {
        // TODO: auto-generated method-stub. Implement!
      }

      def operation(): Unit = {
        // TODO: auto-generated method-stub. Implement!
      }
    }

    case class ConcreteDecorator2(newState: Unit) {

      def newOperation(): Unit = {
        // TODO: auto-generated method-stub. Implement!
      }

      def operation(): Unit = {
        // TODO: auto-generated method-stub. Implement!
      }
    }

    RoleGroup("ConcreteDecorators").containing[ConcreteDecorator1, ConcreteDecorator2](0, *)(2, 2)

    RoleEquivalence[Decorator, ConcreteDecorator1]()

    RoleEquivalence[Decorator, ConcreteDecorator2]()

    val useComponent = Relationship("useComponent").from[Decorator](0 To *).to[Component](1)

    AddRoleRestriction[GenericComponent, Decorator]

    AddRoleRestriction[GenericComponent, Component]

    AddRoleRestriction[GenericComponent, ConcreteDecorator1]

    AddRoleRestriction[GenericComponent, ConcreteDecorator2]
  }

}