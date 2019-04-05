import scroll.internal.support.DispatchQuery
import DispatchQuery._
import scroll.internal.Compartment
import scroll.internal.util.Many._

object Mediator extends App {

  case class GenericMediator() {

  }

  case class GenericColleague() {

    def operatin(): Unit = {
      // TODO: auto-generated method-stub. Implement!
    }
  }

  case class Mediator() extends Compartment {
    import Relationship._

    case class Mediator() {

      def removeColleague(c: Unit): Unit = {
        // TODO: auto-generated method-stub. Implement!
      }

      def addColleague(c: Unit): Unit = {
        // TODO: auto-generated method-stub. Implement!
      }

      def invokeColleagues(): Unit = {
        // TODO: auto-generated method-stub. Implement!
      }

      def notification(c: Unit): Unit = {
        // TODO: auto-generated method-stub. Implement!
      }
    }

    case class Colleague() {

      def setMediator(c: Unit): Unit = {
        // TODO: auto-generated method-stub. Implement!
      }

      def notificate(): Unit = {
        // TODO: auto-generated method-stub. Implement!
      }
    }

    case class ConcreteMediator1() {

      def invokeColleagues(): Unit = {
        // TODO: auto-generated method-stub. Implement!
      }
    }

    case class ConcreteMediator2() {

      def invokeColleagues(): Unit = {
        // TODO: auto-generated method-stub. Implement!
      }
    }

    RoleGroup("ConcreteMediator").containing[ConcreteMediator1, ConcreteMediator2](1, 1)(2, 2)

    RoleEquivalence[Mediator, ConcreteMediator1]()

    RoleEquivalence[Mediator, ConcreteMediator2]()

    val MediatorColleague = Relationship("MediatorColleague").from[Mediator](1).to[Colleague](0 To *)

    AddRoleRestriction[GenericMediator, Mediator]

    AddRoleRestriction[GenericMediator, ConcreteMediator1]

    AddRoleRestriction[GenericMediator, ConcreteMediator2]

    AddRoleRestriction[GenericColleague, Colleague]
  }

}