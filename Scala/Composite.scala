import scroll.internal.support.DispatchQuery
import DispatchQuery._
import scroll.internal.Compartment
import scroll.internal.util.Many._

object Composite extends App {

  case class GenericComponent() {

  }

  case class GenericClient() {

  }

  case class Composite() extends Compartment {
    import Relationship._

    case class Root() {

    }

    case class RootClient() {

      def callOperation(): Unit = {
        // TODO: auto-generated method-stub. Implement!
      }
    }

    case class Node() {

      def operation(): Unit = {
        // TODO: auto-generated method-stub. Implement!
      }

      def addChild(c: GenericComponent): Unit = {
        // TODO: auto-generated method-stub. Implement!
      }

      def deleteChild(c: GenericComponent): Unit = {
        // TODO: auto-generated method-stub. Implement!
      }
    }

    case class NodeClient() {

      def callOperation(): Unit = {
        // TODO: auto-generated method-stub. Implement!
      }
    }

    case class Parent() {

      def operation(): Unit = {
        // TODO: auto-generated method-stub. Implement!
      }

      def addChild(c: GenericComponent): Unit = {
        // TODO: auto-generated method-stub. Implement!
      }

      def deleteChild(c: GenericComponent): Unit = {
        // TODO: auto-generated method-stub. Implement!
      }
    }

    case class Child() {

      def operation(): Unit = {
        // TODO: auto-generated method-stub. Implement!
      }
    }

    RoleGroup("SpecificNode").containing[Parent, Child](0, *)(2, 2)

    RoleImplication[RootClient, NodeClient]()

    RoleEquivalence[Node, Parent]()

    RoleEquivalence[Node, Child]()

    RoleImplication[Root, Parent]()

    RoleProhibition[Root, Child]()

    val useRoot = Relationship("useRoot").from[Root](1 To *).to[RootClient](0 To *)

    val useNode = Relationship("useNode").from[Node](1 To *).to[NodeClient](0 To *)

    val ParentChild = Relationship("ParentChild").from[Parent](0 To 1).to[Child](0 To *)

    AddRoleRestriction[GenericComponent, Root]

    AddRoleRestriction[GenericComponent, Node]

    AddRoleRestriction[GenericComponent, Parent]

    AddRoleRestriction[GenericComponent, Child]

    AddRoleRestriction[GenericClient, RootClient]

    AddRoleRestriction[GenericClient, NodeClient]
  }

}