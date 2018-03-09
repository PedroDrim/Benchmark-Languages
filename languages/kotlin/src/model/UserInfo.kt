package box

class UserInfo(var user: String, private var _password: String, var credit: Double){

    // Get e Set de user é gerado pelo construtor
    // Set de password é gerado pelo construtor, o get é gerado manualmente
    var password: String = this._password
        get() = this.cryptPassword(this._password)

    private fun cryptPassword(password: String): String {
        return "HASH" + password.reversed() + "000"
    }
}