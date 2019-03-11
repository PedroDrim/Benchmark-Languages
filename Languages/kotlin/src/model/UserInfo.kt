package box

/**
 * Informacoes do usuario
 * @param user Nome do usuario
 * @param password Senha do usuario
 * @param credit Credito do usuario
 */
class UserInfo(var user: String, private var _password: String, var credit: Double){

    /**
     * Obtem a senha do usuario criptografada
     * @return Senha do usuario criptografada
     */
    var password: String = this._password
        get() = this.cryptPassword(this._password)

    /**
     * Metodo privado para encriptar a senha do usuario
     * @param password Senha a ser encriptada
     * @return Nova senha encriptada
     */
    private fun cryptPassword(password: String): String {
        return "HASH" + password.reversed() + "000"
    }
}