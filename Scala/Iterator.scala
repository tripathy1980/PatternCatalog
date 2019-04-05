import scroll.internal.support.DispatchQuery
import DispatchQuery._
import scroll.internal.Compartment
import scroll.internal.util.Many._

object Iterator extends App {

  case class GenericCollection(items: Unit) {

    def colOperation(): Unit = {
      // TODO: auto-generated method-stub. Implement!
    }
  }

  case class GenericIterator() {

  }

  case class Iterator() extends Compartment {
    import Relationship._

    case class Collection() {

      def createIterator(): Unit = {
        // TODO: auto-generated method-stub. Implement!
      }
    }

    case class Iterator() {

      def nextItem(): Unit = {
        // TODO: auto-generated method-stub. Implement!
      }

      def firstItem(): Unit = {
        // TODO: auto-generated method-stub. Implement!
      }

      def getCurrentItem(): Unit = {
        // TODO: auto-generated method-stub. Implement!
      }

      def noMoreItems(): Unit = {
        // TODO: auto-generated method-stub. Implement!
      }

      def otherOperation(): Unit = {
        // TODO: auto-generated method-stub. Implement!
      }

      def forAll(c: Unit): Unit = {
        // TODO: auto-generated method-stub. Implement!
      }
    }

    case class ExternalIterator(currentItem: Unit) {

      def nextItem(): Unit = {
        // TODO: auto-generated method-stub. Implement!
      }

      def firstItem(): Unit = {
        // TODO: auto-generated method-stub. Implement!
      }

      def getCurrentItem(): Unit = {
        // TODO: auto-generated method-stub. Implement!
      }

      def noMoreItems(): Unit = {
        // TODO: auto-generated method-stub. Implement!
      }

      def otherOperation(): Unit = {
        // TODO: auto-generated method-stub. Implement!
      }
    }

    case class InternalIterator(currentItem: Unit) {

      def forAll(c: Unit): Unit = {
        // TODO: auto-generated method-stub. Implement!
      }
    }

    case class Cursor(currentItem: Unit) {

      def getCurrentItem(): Unit = {
        // TODO: auto-generated method-stub. Implement!
      }
    }

    RoleGroup("ConcreteIterators").containing[ExternalIterator, InternalIterator, Cursor](0, *)(3, 3)

    RoleEquivalence[ExternalIterator, Iterator]()

    RoleEquivalence[InternalIterator, Iterator]()

    RoleEquivalence[Cursor, Iterator]()

    val CollectionIterator = Relationship("CollectionIterator").from[Collection](1).to[Iterator](0 To *)

    AddRoleRestriction[GenericCollection, Collection]

    AddRoleRestriction[GenericIterator, Iterator]

    AddRoleRestriction[GenericIterator, ExternalIterator]

    AddRoleRestriction[GenericIterator, InternalIterator]

    AddRoleRestriction[GenericIterator, Cursor]
  }

}