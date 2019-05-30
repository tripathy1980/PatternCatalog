package scroll.examples
import scroll.internal.support.DispatchQuery.Bypassing
import scroll.internal.Compartment
import scroll.internal.support.DispatchQuery
import java.util.ArrayList
import java.util.HashMap

object CompositeExample extends App {

  class CompositeCompartment() extends Compartment {

    private val parents: HashMap[Directory, Parent] = new HashMap
    private val dchildren: HashMap[Directory, Child] = new HashMap
    private val fchildren: HashMap[File, Child] = new HashMap
    var root: Parent = null


    def addRootParent(p: Parent): Unit = {
      if (p!= null)
        root = p
    }

    /*Parent class
    Add(): Create the list of child objects and add them
    Sum(): provide the size of the parent object
    */
    class Parent {
      private val children = new ArrayList[Object]

      def add(c: Object): Boolean = {
        val result = children.add(c)
        if (result) +c setParent(this)
        result
      }

      def sum(): Int = {
        //println("-----Children Size: " + children.size())
        var size: Int = +this getSize()
        children.forEach(c => {
          val i: Int = +c sum()
          size += i
        })
        size
      }

      def list(): String = {
        val ls = new ArrayList[String]
        ls.add(+this getName)

        children.forEach(c => {
          val s: String = +c list()
          ls.add(s)
        })
        String.join("\n", ls)
      }
    }

    /* Child Class
    Set and Get the Parent of this child object
     */
    class Child {
      private var parent: Parent = null

      def setParent(p: Parent): Unit = {
        parent = p
      }

      def getParent(): Parent = parent
      def sum(): Int = +this getSize()
      def list(): String = +this getName()
    }

    /*Example:
    There are 2 classes Directory & File. Directory can be parent or child. Files are children objects
    Files are added to Directory. This alters the size of the Directory.
     */
    class Directory {
      var name = ""
      var size = 0

      def this(n: String) {
        this()
        name = n
      }

      override def toString: String = "d " + name + " (" + size + " Byte)"
      def getName(): String = name
      def getSize(): Int = size
      def setSize(s: Int): Unit = {
        size = s
      }
    }

    class File {
      var name = ""
      var size = 0

      def this(n: String) {
        this()
        name = n
      }

      def this(n: String, s: Int) {
        this()
        name = n
        size = s
      }

      override def toString: String = "- " + name + " (" + size + " Byte)"
      def getName(): String = name
      def getSize(): Int = size
      def append(c: Int): Unit = {
        size += 1
      }
    }

  }


  new CompositeCompartment {
    val dir1 = new Directory("dir1")
    dir1.setSize(1000)
    val dir2 = new Directory("dir2")
    dir2.setSize(200)
    val dir3 = new Directory("dir3")
    dir3.setSize(500)

    val file1 = new File("file1", 70)
    val file2 = new File("file2", 30)
    val file3 = new File("file3", 50)
    val file4 = new File("file4", 250)

    val parent1 = new Parent
    val parent2 = new Parent
    val parent3 = new Parent
    val fileChild1 = new Child
    val fileChild2 = new Child
    val fileChild3 = new Child

    dir1 play parent1
    dir2 play parent2
    dir3 play parent3


    +dir1 add parent2
    +dir1 add parent3


    file1 play fileChild1
    file2 play fileChild2
    file3 play fileChild3

    //For testing roles working or not
    /*
    println(+dir2 add fileChild1)
    println(+dir3 add fileChild2)

    println("Directory1 is playing Parent:" + (+dir1).isPlaying[Parent])
    println("Directory2 is playing child:" + (+dir2).isPlaying[Child])
    println("Directory3 is playing child:" + (+dir3).isPlaying[Child])
    println("Directory2 is playing child:" + (+dir2).isPlaying[Parent])
    println("Directory3 is playing child:" + (+dir3).isPlaying[Parent])

    println("size of dir1: " + dir1.getSize)
    println("size of file1: " + file1.getSize)


    //println(+dir1 add parent2)
    //println(+dir1 add parent3)
    */

    //Current size of the directory
    var totalSize: Int = +dir1 sum()
    println("Total size of root directory: " + totalSize)

    /* Add new file, resize & show */
    val fileChild4 = new Child
    file4 play fileChild4
    +dir2 add file4
    println("")
    println("New file has added----------")
    var totalNewSize: Int = +dir1 sum()
    println("Total size of root directory with new file: " + totalNewSize)

  }
}

