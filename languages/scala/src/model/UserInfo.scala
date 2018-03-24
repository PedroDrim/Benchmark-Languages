package model

/**
  * Informacoes do usuario
  * @param _user Nome do usuario
  * @param _password senha do usuario
  * @param _credit Quantidade de creditos do usuario
  */
class UserInfo(private var _user: String, private var _password: String, private var _credit: Double) {

  /**
    * Obtem o nome do usuario
    * @return Nome do usuario
    */
  def user: String = _user

  /**
    * Atualiza o nome do usuario
    * @param user Novo nome do usuarios
    */
  def user_= (user: String): Unit = _user = user

  /**
    * Obtem a senha do usuario criptografada
    * @return Senha do usuario criptografada
    */
  def password: String = this.cryptPassword(_password)

  /**
    * Atualiza a senha do usuario
    * @param password Nova senha do usuario
    */
  def password_= (password: String): Unit = _password = password

  /**
    * Obtem a quantidade de creditos do usuario
    * @return Quantidade de creditos do usuario
    */
  def credit: Double = _credit

  /**
    * Atualiza a quantidade de creditos do usuario
    * @param credit Nova quantidade de creditos do usuario
    */
  def credit_= (credit: Double): Unit = _credit = credit

  /**
    * Metodo privado para encriptar a senha do usuario
    * @param password Senha a ser encriptada
    * @return Nova senha encriptada
    */
  private def cryptPassword(password: String): String = "HASH" + password.reverse + "000"
}
