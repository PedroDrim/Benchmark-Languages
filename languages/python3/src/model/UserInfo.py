# Criando uma classe "UserInfo"
class UserInfo:

    # Definindo construtor público da classe
    # user -> nome do usuário
    # password -> senha da conta
    # credit -> credito da conta
    def __init__(self, user, password, credit):
        self.__user = user
        self.__password = password
        self.__credit = credit

    # Método getter de 'user'
    def getUser(self):
        return self.__user

    # Método getter customizado de 'password'
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

    # Método privado para encriptar senhas
    # password -> senha a ser encriptada
    # RETURN -> nova senha
    def __cryptPassword(self, password):
        return "HASH" + password[::-1] + "000"
