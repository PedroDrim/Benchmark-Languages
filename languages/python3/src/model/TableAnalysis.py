from src.model.UserInfo import UserInfo

# Interface para analise dos dados
class TableAnalysis:

    # Realiza a analise dos dados
    # @param userInfoList Lista de dados a ser analisada
    # @return Resultado da analise
    def analysis(self, userInfoList):
        raise NotImplementedError()
