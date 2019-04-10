# Informacoes do usuario
class UserInfo:

    # Construtor publico da classe
    # @param user Nome do usuario
    # @param password Senha do usuario
    def __init__(self, user, password):
        self.__user = user
        self.__password = password

    # Obtem o nome do usuario
    # @return Nome do usuario
    def getUser(self):
        return self.__user

    # Obtem a senha do usuario criptografada
    # @return Senha do usuario criptografada
    def getPassword(self):
        return self.__cryptPassword(self.__password)

    # Atualiza o nome do usuario
    # @param user Novo nome do usuario
    def setUser(self, user):
        self.__user = user

    # Atualiza a senha do usuario
    # @param password Nova senha do usuario
    def setPassword(self, password):
        self.__password = password

    # Metodo privado para encriptar a senha do usuario
    # @param password Senha a ser encriptada
    # @return Nova senha encriptada
    def __cryptPassword(self, password):
        return "HASH{}000".format(password[::-1])
