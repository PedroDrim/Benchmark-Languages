from src.model.UserInfo import UserInfo

import sys
import time

# Classe inicial do sistema
class Start:

    # Método de inicialização do projeto
    # @param args Lista de parametros obtidos via console
    def __init__(self, param):

        tamanho = self.__getParam(param)
        antes = time.time()

        list = []

        for index in range(tamanho):
            user = "".join(["user", str(index)])
            password = "".join(["password", str(index)])
            list.append(UserInfo(user, password))

        res = (time.time() - antes) * 1000.0

        print("[OK]Tamanho: " + str(tamanho))
        print("[OK]Tempo: " + str(res) + " ms")

    # Método para captura e tratamento dos parametros obtidos via console
    # @param codes Lista de parametros obtidos via console
    # @return Tamanho de usuários á serem gerados
    def __getParam(self, codes):
        if(len(codes) != 2):
            print("Parametros inválidos.")
            sys.exit(-1)
            
        line = int(codes[1])

        if(line <= 0):
            print("Quantidade de linhas menor que 1.")
            sys.exit(-1)
       
        return line        
        
Start(sys.argv)
