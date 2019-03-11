package model

/**
 * Informacoes do usuario
 * @param user Nome do usuario
 * @param password Senha do usuario
 * @param credit Credito do usuario
 */
class UserInfo(private var _user: String, private var _password: String, private var _credit: Double) {

  /**
    * Obtem o nome do usuario
    * @return Nome do usuario
    */
  def user = _user

  /**
    * Atualiza o nome do usuario
    * @param user Novo nome do usuarios
    */
  def user_= (user: String): Unit = _user = user

  /**
    * Obtem a senha do usuario criptografada
    * @return Senha do usuario criptografada
    */
  def password = this.cryptPassword(_password)

  /**
    * Atualiza a senha do usuario
    * @param password Nova senha do usuario
    */
  def password_= (password: String): Unit = _password = password

  /**
    * Metodo privado para encriptar a senha do usuario
    * @param password Senha a ser encriptada
    * @return Nova senha encriptada
    */
  private def cryptPassword(password: String): String = "HASH" + password.reverse + "000"

  /**
    * Obtem o credito do usuario
    * @return Credito do usuario
    */
  def credit: Double = _credit

  /**
    * Atualiza o credito do usuario
    * @param password Novo credito do usuario
    */
  def credit_= (credit: Double): Unit = _credit = credit
}
