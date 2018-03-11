# Criando uma classe "UserInfo"
class UserInfo:

    # Definindo construtor público da classe
    # user -> nome do usuário
    # password -> senha do usuário
    def __init__(self, user, password):
        # Definindo variável privada "__user"
        self.__user = user
        # Definindo variável privada "__password"
        self.__password = password

    # Método getter da variável '__user'
    # instance.getUser(), para getter
    def getUser(self):
        return self.__user

    # Método getter customizado da variável '__password'
    # instance.getPassword(), para getter
    def getPassword(self):
        return self.__cryptPassword(self.__password)

    # instance.setUser(valor), para setter
    # valor -> novo user
    def setUser(self, user):
        self.__user = user

    # instance.setPassword(valor), para setter
    # valor -> novo password
    def setPassword(self, password):
        self.__password = password

    # Método privado para encriptar a variável 'password'
    # password -> senha do usuário
    # RETURN -> senha encriptada
    def __cryptPassword(self, password):
        return "HASH{}000".format(password[::-1])
