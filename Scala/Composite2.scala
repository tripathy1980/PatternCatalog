package scroll.examples

import scroll.internal.support.DispatchQuery.Bypassing
import scroll.internal.Compartment
import scroll.internal.support.DispatchQuery

import java.util.ArrayList
import java.util.HashMap

object Composite4 extends App {

  /**
    *
    * Compartment for the Observerpattern including three role types, i.e., FileParent, DirectoryChild, FileChild.
    *
    * @author Thomas Kühn
    *
    */
  class CompositePattern extends Compartment {

    //var root = new Parent
    private val parents: HashMap[Directory, Parent] = new HashMap
    private val dchildren: HashMap[Directory, Child] = new HashMap
    private val fchildren: HashMap[File, Child] = new HashMap
    // ?? private val root = Parent
    var root: Parent = null

    /*def this(root: Directory) {
      this()
      this.root = asParent(root)
    }*/

    def addRootParent(p: Parent): Unit = {
      if (p!= null)
        root = p
    }

    /*
    def getRoot: CompositePattern {
      Parent = root
    }
    */

    /*def asParent(player: Directory): Parent = {
      var result = parents.get(player)
      if (result == null) {
        result = new Parent(player)
        parents.put(player, result)
      }
      result
    }

    def isParent(player: Directory): Boolean = parents.containsKey(player)

    def asChild(player: Directory): CompositePattern#DirectoryChild = {
      var result = dchildren.get(player)
      if (result == null) {
        result = new DirectoryChild(player)
        dchildren.put(player, result)
      }
      result
    }

    def isChild(player: Directory): Boolean = dchildren.containsKey(player)

    def asChild(player: File): CompositePattern#FileChild = {
      var result = fchildren.get(player)
      if (result == null) {
        result = new FileChild(player)
        fchildren.put(player, result)
      }
      result
    }

    def isChild(player: File): Boolean = fchildren.containsKey(player)*/

    class Parent {
      private val children = new ArrayList[Object]

      def add(c: Object): Boolean = {
        val result = children.add(c)
        if (result) +c setParent(this)
        result
      }

      def sum(): Int = {
        println("-----Children Size: " + children.size())
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

    class Child {
      private var parent: CompositePattern#Parent = null

      def setParent(p: CompositePattern#Parent): Unit = {
        parent = p
      }

      def getParent(): CompositePattern#Parent = parent

      def sum(): Int = +this getSize()

      def list(): String = +this getName()
    }

  }

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

  val dir1 = new Directory("dir1")
  dir1.setSize(1000)
  val dir2 = new Directory("dir2")
  dir2.setSize(200)
  val dir3 = new Directory("dir3")
  dir3.setSize(500)

  val file1 = new File("file1", 70)
  val file2 = new File("file2", 30)
  val file3 = new File("file3", 50)
  val file4 = new File("file4", 200)

  new CompositePattern {

    val parent1 = new Parent
    val parent2 = new Parent
    val parent3 = new Parent
    val fileChild1 = new Child
    val fileChild2 = new Child
    val fileChild3 = new Child

    dir1 play parent1
    dir2 play parent2
    dir3 play parent3

    println(+dir1 add parent2)
    println(+dir1 add parent3)

    file1 play fileChild1
    file2 play fileChild2
    file3 play fileChild3

    println(+dir2 add fileChild1)
    println(+dir3 add fileChild2)
    println(+dir3 add fileChild3)

    println("Directory1 is playing Parent:" + (+dir1).isPlaying[Parent])
    println("Directory2 is playing child:" + (+dir2).isPlaying[Child])
    println("Directory3 is playing child:" + (+dir3).isPlaying[Child])
    println("Directory2 is playing child:" + (+dir2).isPlaying[Parent])
    println("Directory3 is playing child:" + (+dir3).isPlaying[Parent])


    println("size of dir1: " + dir1.getSize)
    println("size of dir2: " + dir2.getSize)
    println("size of dir3: " + dir3.getSize)

    println("size of file1: " + file1.getSize)
    println("size of file2: " + file2.getSize)
    println("size of file3: " + file3.getSize)

    println("show the total size" + (+dir1 sum()))

    /* Add new directory and resize */
    val fileChild4 = new Child
    file4 play fileChild4
    println(+dir2 add file4)
    println("show the total size" + (+dir1 sum()))

  }
}

