# Importando bibliotecas
import time
from src.model.Table import Table
from src.provider.MaxValueAnalysis import MaxValueAnalysis
from src.provider.MinValueAnalysis import MinValueAnalysis
from src.provider.MeanAnalysis import MeanAnalysis

fileName = "/home/pedro/MEGA/MEGAsync/Repositorio_Git/Benchmark-Languages/outputs/inputclass/inputclass_1e+06.csv"
identificador = "python_10_inputclass_1e+06"

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
print("Identificador: " + str(identificador))
print("Tempo de leitura (ms): " + str( (leitura_fim - leitura_inicio)*1000.0) )
print("Tempo de análise (ms): " + str( (analise_fim - analise_inicio)*1000.0) )
print("Max: " + str(vmax))
print("Min: " + str(vmin))
print("Mean: " + str(vmean))