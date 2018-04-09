import java.io.{FileInputStream, FileOutputStream, ObjectInputStream, ObjectOutputStream}

case class Hippie(val name: String, @transient val age: Int) extends Serializable

object Serialization {

  val fos = new FileOutputStream("hippie.txt")
  val oos = new ObjectOutputStream(fos)

  val p1 = new Hippie("zml", 34)
  oos.writeObject(p1)
  oos.close()
}

object Deserialization extends App {

  val fis = new FileInputStream("hippie.txt")
  val ois = new ObjectInputStream(fis)

  val hippy = ois.readObject.asInstanceOf[Hippie]
  println(hippy.name)
  println(hippy.age)
  ois.close()
}