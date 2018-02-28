package model

class UserInfo(private var _user: String, private var _password: String) {

  // Get user
  def user = _user

  // Set user
  def user_= (user: String): Unit = _user = user

  // Get password
  def password = this.cryptPassword(_password)

  // Set password
  def password_= (password: String): Unit = _password = password

  // Metodo privado
  private def cryptPassword(password: String): String = "HASH" + password.reverse + "000"
}
