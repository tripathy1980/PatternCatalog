import scroll.internal.support.DispatchQuery
import DispatchQuery._
import scroll.internal.Compartment
import scroll.internal.util.Many._

object State extends App {

  case class GenericComponent() {

  }

  case class State() extends Compartment {
    import Relationship._

    case class Component() {

      def configure(): Unit = {
        // TODO: auto-generated method-stub. Implement!
      }

      def operation(): Unit = {
        // TODO: auto-generated method-stub. Implement!
      }

      def changeState(newState: Unit): Unit = {
        // TODO: auto-generated method-stub. Implement!
      }
    }

    case class Client() {

      def configureComponent(): Unit = {
        // TODO: auto-generated method-stub. Implement!
      }

      def callOperation(): Unit = {
        // TODO: auto-generated method-stub. Implement!
      }
    }

    case class AbstractState() {

      def changeState(): Unit = {
        // TODO: auto-generated method-stub. Implement!
      }

      def operation(): Unit = {
        // TODO: auto-generated method-stub. Implement!
      }
    }

    case class ConcreteState1() {

      def operation(): Unit = {
        // TODO: auto-generated method-stub. Implement!
      }
    }

    case class ConcreteState2() {

      def operation(): Unit = {
        // TODO: auto-generated method-stub. Implement!
      }
    }

    RoleGroup("ConcreteStates").containing[ConcreteState1, ConcreteState2](0, *)(2, 2)

    RoleImplication[ConcreteState1, AbstractState]()

    RoleImplication[ConcreteState2, AbstractState]()

    val useComponent = Relationship("useComponent").from[Component](1 To *).to[Client](0 To *)

    val ComponentState = Relationship("ComponentState").from[Component](1).to[AbstractState](1)

    AddRoleRestriction[GenericComponent, Component]

    AddRoleRestriction[GenericComponent, Client]

    AddRoleRestriction[GenericComponent, AbstractState]

    AddRoleRestriction[GenericComponent, ConcreteState1]

    AddRoleRestriction[GenericComponent, ConcreteState2]
  }

}