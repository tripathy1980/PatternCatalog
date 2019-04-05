import scroll.internal.support.DispatchQuery
import DispatchQuery._
import scroll.internal.Compartment
import scroll.internal.util.Many._

object Class_Adapter extends App {

  case class GenericAdaptee() {

    def specificOperation(): Unit = {
      // TODO: auto-generated method-stub. Implement!
    }
  }

  case class ClassAdapter() extends Compartment {
    import Relationship._

    def callNewOperation(c: GenericAdaptee): Unit = {
      // TODO: auto-generated method-stub. Implement!
    }

    def callOperation(c: GenericAdaptee): Unit = {
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

    AddRoleRestriction[GenericAdaptee, Adapter]
  }

}