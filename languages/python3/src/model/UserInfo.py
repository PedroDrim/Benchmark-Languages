from src.model.exception.InvalidParameterException import InvalidParameterException

# Informacoes do usuario
class UserInfo:

    # Construtor publico da classe
    # @param user Nome do usuario
    # @param password Senha do usuario
    # @param credit Quantidade de creditos do usuario
    def __init__(self, user, password, credit):

        if(user == None):
            raise InvalidParameterException("'user' é None")
        
        if(password == None):
            raise InvalidParameterException("'password' é None")

        if(credit == None):
            raise InvalidParameterException("'credit' é None")

        self.__user = user
        self.__password = password
        self.__credit = credit

    # Obtem o nome do usuario
    # @return Nome do usuario
    def getUser(self):
        return self.__user

    # Atualiza o nome do usuario
    # @param user Novo nome do usuario
    def setUser(self, user):
        if(user == None):
            raise InvalidParameterException("'user' é None")
        self.__user = user

    # Obtem a senha do usuario criptografada
    # @return Senha do usuario criptografada
    def getPassword(self):
        return self.__cryptPassword(self.__password)

    # Atualiza a senha do usuario
    # @param password Nova senha do usuario
    def setPassword(self, password):
        if(password == None):
            raise InvalidParameterException("'password' é None")
        self.__password = password

    # Obtem a quantidade de creditos do usuario
    # @return Quantidade de creditos do usuario
    def getCredit(self):
        return float(self.__credit)

    # Atualiza a quantidade de creditos do usuario
    # @param credit Nova quantidade de creditos do usuario
    def setCredit(self, credit):
        if(credit == None):
            raise InvalidParameterException("'credit' é None")
        self.__credit = credit

    # Metodo privado para encriptar a senha do usuario
    # @param password Senha a ser encriptada
    # @return Nova senha encriptada
    def __cryptPassword(self, password):
        if(password == None):
            raise InvalidParameterException("'password' é None")
        return "HASH" + password[::-1] + "000"
