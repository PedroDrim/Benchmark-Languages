# Importando bibliotecas
require './src/model/Table.rb'
require './src/provider/MaxValueAnalysis.rb'
require './src/provider/MinValueAnalysis.rb'
require './src/provider/MeanAnalysis.rb'

fileName = "/home/pedro/MEGA/MEGAsync/Repositorio_Git/Benchmark-Languages/outputs/inputclass/inputclass_1e+06.csv"
identificador = "ruby_1_inputclass_1e+06"

# Obtendo o tempo inicial de leitura em milissegundos
leitura_inicio = Time.now

# Convertendo arquivo em lista de "UserInfo"
table = Table.new(fileName)

# Obtendo o tempo final de leitura em milissegundos
leitura_fim = Time.now

list = table.userInfoList

maxValue = MaxValueAnalysis.new
minValue = MinValueAnalysis.new
meanValue = MeanAnalysis.new

# Obtendo o tempo inicial de analise em milissegundos
analise_inicio = Time.now

# Realizando analises
max = maxValue.analysis(list)
min = minValue.analysis(list)
mean = meanValue.analysis(list)

# Obtendo o tempo final de analise em milissegundos
analise_fim = Time.now

# Dados de saida
p("Identificador: #{identificador}")
p("Tempo de leitura (ms): #{(leitura_fim - leitura_inicio)*1000.0}")
p("Tempo de análise (ms): #{(analise_fim - analise_inicio)*1000.0}")
p("Max: #{max}")
p("Min: #{min}")
p("Mean: #{mean}")