package model

/**
 * Informacoes do usuario
 * @param user Nome do usuario
 * @param password Senha do usuario
 */
class UserInfo(var user: String, private var _password: String){

    /**
     * Obtem a senha cryptografada do usuario
     * @return Senha cryptografada do usuario
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