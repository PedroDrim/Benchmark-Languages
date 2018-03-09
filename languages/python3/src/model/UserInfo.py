class UserInfo:

    def __init__(self, user, password, credit):
        self.__user = user
        self.__password = password
        self.__credit = credit

    def getUser(self):
        return self.__user

    def getPassword(self):
        return self.__cryptPassword(self.__password)

    def getCredit(self):
        return self.__credit

    def setUser(self, user):
        self.__user = user

    def setPassword(self, password):
        self.__password = password

    def setCredit(self, credit):
        self.__credit = credit

    def __cryptPassword(self, password):
        return "HASH" + password[::-1] + "000"
