import scroll.internal.support.DispatchQuery
import DispatchQuery._
import scroll.internal.Compartment
import scroll.internal.util.Many._

object Bridge extends App {

  case class GenericImplementation() {

  }

  case class GenericComponent() {

  }

  case class Bridge() extends Compartment {
    import Relationship._

    case class Abstraction(defaultImplementation: GenericImplementation) {

      def setImplementation(newImp: Unit): Unit = {
        // TODO: auto-generated method-stub. Implement!
      }

      def operation(): Unit = {
        // TODO: auto-generated method-stub. Implement!
      }
    }

    case class Client() {

      def callOperation(): Unit = {
        // TODO: auto-generated method-stub. Implement!
      }
    }

    case class Implementation() {

      def operationImp(): Unit = {
        // TODO: auto-generated method-stub. Implement!
      }
    }

    case class RefinedAbstraction1() {

      def operation(): Unit = {
        // TODO: auto-generated method-stub. Implement!
      }
    }

    case class RefinedAbstraction2() {

      def operation(): Unit = {
        // TODO: auto-generated method-stub. Implement!
      }
    }

    case class ConcreteImplementation1() {

      def operationImp(): Unit = {
        // TODO: auto-generated method-stub. Implement!
      }
    }

    case class ConcreteImplementation2() {

      def operationImp(): Unit = {
        // TODO: auto-generated method-stub. Implement!
      }
    }

    RoleGroup("RefinedAbstraction").containing[RefinedAbstraction1, RefinedAbstraction2](0, *)(2, 2)

    RoleGroup("ConcreteImplementation").containing[ConcreteImplementation1, ConcreteImplementation2](0, *)(2, 2)

    RoleEquivalence[Implementation, ConcreteImplementation1]()

    RoleEquivalence[Implementation, ConcreteImplementation2]()

    RoleEquivalence[Abstraction, RefinedAbstraction1]()

    RoleEquivalence[Abstraction, RefinedAbstraction2]()

    val useAbstraction = Relationship("useAbstraction").from[Abstraction](1 To *).to[Client](0 To *)

    val hasImplementation = Relationship("hasImplementation").from[Implementation](1).to[Abstraction](0 To *)

    AddRoleRestriction[GenericComponent, Abstraction]

    AddRoleRestriction[GenericComponent, Client]

    AddRoleRestriction[GenericComponent, RefinedAbstraction1]

    AddRoleRestriction[GenericComponent, RefinedAbstraction2]

    AddRoleRestriction[GenericImplementation, Implementation]

    AddRoleRestriction[GenericImplementation, ConcreteImplementation1]

    AddRoleRestriction[GenericImplementation, ConcreteImplementation2]
  }

}