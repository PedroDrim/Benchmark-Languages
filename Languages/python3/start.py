import time
import sys
from src.model.Table import Table
from src.provider.MaxValueAnalysis import MaxValueAnalysis
from src.provider.MinValueAnalysis import MinValueAnalysis
from src.provider.MeanAnalysis import MeanAnalysis

# Classe inicial do sistema
class Start:
    
    # Método de inicialização do projeto
    # @param args Lista de parametros obtidos via console
    def __init__(self, args):
        fileName = self.__getParam(args)
        
        # Obtendo o tempo inicial de leitura em milissegundos
        leitura_inicio = time.time()

        # Convertendo arquivo em lista de "UserInfo"
        table = Table(fileName)

        # Obtendo o tempo final de leitura em milissegundos
        leitura_fim = time.time()

        userInfoList = table.getUserInfoList()

        maxValue = MaxValueAnalysis()
        minValue = MinValueAnalysis()
        meanValue = MeanAnalysis()

        # Obtendo o tempo inicial de analise em milissegundos
        analise_inicio = time.time()

        # Realizando analises
        vmax = maxValue.analysis(userInfoList)
        vmin = minValue.analysis(userInfoList)
        vmean = meanValue.analysis(userInfoList)

        # Obtendo o tempo final de analise em milissegundos
        analise_fim = time.time()

        # Dados de saida
        print("[OK]Arquivo: " + str(fileName))
        print("[OK]Tempo_leitura: " + str( (leitura_fim - leitura_inicio)*1000.0) + " ms")
        print("[OK]Tempo_analise: " + str( (analise_fim - analise_inicio)*1000.0) + " ms")
        print("[OK]Max: " + str(vmax))
        print("[OK]Min: " + str(vmin))
        print("[OK]Mean: " + str(vmean))

    # Método para captura e tratamento dos parametros obtidos via console
    # @param codes Lista de parametros obtidos via console
    # @return Tamanho de usuários á serem gerados
    def __getParam(self, codes):
        if len(codes) != 2:
            print("Parametros inválidos.")
            raise SystemExit(-1)
            
        line = str(codes[1])
    
        return line

Start(sys.argv)
