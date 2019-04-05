import scroll.internal.support.DispatchQuery
import DispatchQuery._
import scroll.internal.Compartment
import scroll.internal.util.Many._

object Property extends App {

  case class GenericComponent() {

  }

  case class Property() extends Compartment {
    import Relationship._

    def AddProperty(c: GenericComponent, value: Unit): Unit = {
      // TODO: auto-generated method-stub. Implement!
    }

    def createProperty(): Unit = {
      // TODO: auto-generated method-stub. Implement!
    }

    def handleComponent(c: GenericComponent): Unit = {
      // TODO: auto-generated method-stub. Implement!
    }

    case class Property1(value: Unit) {

    }

    case class Property2(value: Unit) {

    }

    case class Property3(value: Unit) {

    }

    RoleGroup("Properties").containing[Property1, Property2, Property3](1, *)(3, 3)

    AddRoleRestriction[GenericComponent, Property1]

    AddRoleRestriction[GenericComponent, Property2]

    AddRoleRestriction[GenericComponent, Property3]
  }

}