import java.util
import scroll.internal.support.DispatchQuery
import DispatchQuery._
import scroll.internal.Compartment
import scroll.internal.util.Many._
import scala.collection.mutable

object PropertyExample extends App {

  case class PropertyCompartment() extends Compartment {
    import Relationship._

    class PropertyContainer{
      var propertyMap : mutable.HashMap[String,String] = mutable.HashMap.empty[String,String]

      def addProperty(o: util.ArrayList[String]): Unit ={
        propertyMap.put(o.get(0),o.get(1))
      }


      def getProperty(k:String):String={
        var x= ""
        x= propertyMap(k)
        if(x!=null)
          return x
        return "Property does not exist..."

      }

    }

    class Movie {
      var title = new String
      var price = new String
      def setTitle(str:String): Unit ={
        title=str
      }
      def getTitle:String={
        return title
      }
      def setPrice(str:String): Unit ={
        price=str
      }
      def getPrice:String={
        return price
      }
    }
  }

  new PropertyCompartment{
    var movie1=new Movie
    var propertyContainer=new PropertyContainer
    var propertyList = new util.ArrayList[String]()
    movie1.setTitle("ABC")
    movie1.setPrice("123")

    //New property is created
    propertyList.add("Rating")
    propertyList.add("4.5")

    //Movie play the container role and the new party is added
    movie1 play propertyContainer
    +movie1 addProperty propertyList

    var propertyList1 = new util.ArrayList[String]()
    propertyList1.add("Gener")
    propertyList1.add("Commedy")
    +movie1 addProperty propertyList1

    println("Movie Title: "+ movie1.getTitle)
    println("--------------------------")
    println("Price  : "+movie1.getPrice)
    var x = ""
    x = +movie1 getProperty propertyList.get(0)
    println("Rating : " + x )
    x = +movie1 getProperty propertyList1.get(0)
    println("Gener  : " + x )

  }

}