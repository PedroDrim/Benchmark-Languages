
import model.UserInfo

import scala.collection.mutable.ListBuffer

object  main extends App {

  // Inicia uma lista modificavel
  var list = new ListBuffer[UserInfo]()

  // Obtem o tempo inicial
  val antes = System.currentTimeMillis()

  val size: Int = 1000000

  // Acidionando elementos unicos na lista
  for (index <- 1 to size) {
    val user: String = "user" + index
    val password: String = "password" + index
    list += new UserInfo(user, password)
  }

  // Obtem o tempo final
  val depois = System.currentTimeMillis()

  // Exibe o resultado
  print(depois-antes)
}