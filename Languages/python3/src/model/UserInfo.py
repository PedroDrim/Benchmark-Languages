# Informacoes do usuario
class UserInfo:

    # Construtor publico da classe
    # @param user Nome do usuario
    # @param credit Credito do usuario
    # @param password Senha do usuario    
    def __init__(self, user, password, credit):
        self.__user = user
        self.__password = password
        self.__credit = credit

    # Método getter de 'user'
    def getUser(self):
        return self.__user

    # Obtem a senha do usuario criptografada
    # @return Senha do usuario criptografada
    def getPassword(self):
        return self.__cryptPassword(self.__password)

    # Método getter de 'credit'
    def getCredit(self):
        return self.__credit

    # Método setter de 'user'
    def setUser(self, user):
        self.__user = user

    # Método setter de 'password'
    def setPassword(self, password):
        self.__password = password

    # Método setter de 'credit'
    def setCredit(self, credit):
        self.__credit = credit

    # Metodo privado para encriptar a senha do usuario
    # @param password Senha a ser encriptada
    # @return Nova senha encriptada
    def __cryptPassword(self, password):
        return "HASH" + password[::-1] + "000"
