import time
from src.model.Table import Table
from src.provider.MaxValueAnalysis import MaxValueAnalysis
from src.provider.MinValueAnalysis import MinValueAnalysis
from src.provider.MeanAnalysis import MeanAnalysis



fileName = "/home/pedro/MEGA/MEGAsync/Repositorio_Git/Benchmark-Languages/outputs/inputclass/inputclass_1e+06.csv"
identificador = "python_10_inputclass_1e+06"

leitura_inicio = time.time()

table = Table(fileName)

leitura_fim = time.time()

userInfoList = table.getUserInfoList()

maxValue = MaxValueAnalysis()
minValue = MinValueAnalysis()
meanValue = MeanAnalysis()

analise_inicio = time.time()

vmax = maxValue.analysis(userInfoList)
vmin = minValue.analysis(userInfoList)
vmean = meanValue.analysis(userInfoList)

analise_fim = time.time()

print("Identificador: " + str(identificador))
print("Tempo de leitura (ms): " + str( (leitura_fim - leitura_inicio)*1000.0) )
print("Tempo de análise (ms): " + str( (analise_fim - analise_inicio)*1000.0) )
print("Max: " + str(vmax))
print("Min: " + str(vmin))
print("Mean: " + str(vmean))