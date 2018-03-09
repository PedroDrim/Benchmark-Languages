package model

class UserInfo(private var _user: String, private var _password: String, private var _credit: Double) {

  // Get user
  def user: String = _user

  // Set user
  def user_= (user: String): Unit = _user = user

  // Get password
  def password: String = this.cryptPassword(_password)

  // Set password
  def password_= (password: String): Unit = _password = password

  // Get credit
  def credit: Double = _credit

  // Set credit
  def credit_= (credit: Double): Unit = _credit = credit

  // Metodo privado
  private def cryptPassword(password: String): String = "HASH" + password.reverse + "000"
}
