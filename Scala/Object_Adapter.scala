import scroll.internal.support.DispatchQuery
import DispatchQuery._
import scroll.internal.Compartment
import scroll.internal.util.Many._

object Object_Adapter extends App {

  case class GenericComponent() {

  }

  case class GenericAdaptee() {

    def specificOperation(): Unit = {
      // TODO: auto-generated method-stub. Implement!
    }
  }

  case class ObjectAdapter() extends Compartment {
    import Relationship._

    def callNewOperation(c: GenericComponent): Unit = {
      // TODO: auto-generated method-stub. Implement!
    }

    def callOperation(c: GenericComponent): Unit = {
      // TODO: auto-generated method-stub. Implement!
    }

    case class Adapter() {

      def newOperation(): Unit = {
        // TODO: auto-generated method-stub. Implement!
      }

      def operation(): Unit = {
        // TODO: auto-generated method-stub. Implement!
      }
    }

    case class Adaptee() {

    }

    val UseAdaptee = Relationship("UseAdaptee").from[Adapter](0 To *).to[Adaptee](1 To *)

    AddRoleRestriction[GenericComponent, Adapter]

    AddRoleRestriction[GenericAdaptee, Adaptee]
  }

}