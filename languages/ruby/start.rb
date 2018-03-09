require './src/model/Table.rb'
require './src/provider/MaxValueAnalysis.rb'
require './src/provider/MinValueAnalysis.rb'
require './src/provider/MeanAnalysis.rb'

fileName = "/home/pedro/MEGA/MEGAsync/Repositorio_Git/Benchmark-Languages/outputs/inputclass/inputclass_1e+06.csv"
identificador = "ruby_1_inputclass_1e+06"

leitura_inicio = Time.now
table = Table.new(fileName)
leitura_fim = Time.now


list = table.userInfoList

maxValue = MaxValueAnalysis.new
minValue = MinValueAnalysis.new
meanValue = MeanAnalysis.new

analise_inicio = Time.now

max = maxValue.analysis(list)
min = minValue.analysis(list)
mean = meanValue.analysis(list)

analise_fim = Time.now

p("Identificador: #{identificador}")
p("Tempo de leitura (ms): #{(leitura_fim - leitura_inicio)*1000.0}")
p("Tempo de análise (ms): #{(analise_fim - analise_inicio)*1000.0}")
p("Max: #{max}")
p("Min: #{min}")
p("Mean: #{mean}")