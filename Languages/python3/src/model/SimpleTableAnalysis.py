# Interface para analise de uma lista de usuarios
class SimpleTableAnalysis:

    # Método de interface, responsável por realizar uma analise em uma lista de usuarios
    # @param userInfoList Lista de usuarios
    def analysis(self, userInfoList):
        raise NotImplementedError()