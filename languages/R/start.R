# Importando bibliotecas
require(compiler)
require(data.table)
require(R6)

# Compilando arquivos .R em binários .Rc
cmpfile("./src/model/Table.R","./bin/Table.Rc")
cmpfile("./src/model/UserInfo.R","./bin/UserInfo.Rc")
cmpfile("./src/provider/MaxValueAnalysis.R", "./bin/MaxValueAnalysis.Rc")
cmpfile("./src/provider/MinValueAnalysis.R", "./bin/MinValueAnalysis.Rc")
cmpfile("./src/provider/MeanAnalysis.R", "./bin/MeanAnalysis.Rc")

# Lendo binários .Rc
loadcmp("./bin/Table.Rc")
loadcmp("./bin/MaxValueAnalysis.Rc")
loadcmp("./bin/MinValueAnalysis.Rc")
loadcmp("./bin/MeanAnalysis.Rc")

# Definindo função para realizar o experimento
read = function(fileName, identificador) {
  # Obtendo o tempo inicial de leitura em segundos
  leitura_inicio = as.numeric(Sys.time())
  
  # Convertendo arquivo em lista de "UserInfo"
  table = Table$new(fileName)
  
  # Obtendo o tempo final de leitura em segundos
  leitura_fim = as.numeric(Sys.time())
  
  userInfoList = table$getUserInfoList()
  
  maxValueAnalysis = MaxValueAnalysis$new()
  minValueAnalysis = MinValueAnalysis$new()
  meanAnalysis = MeanAnalysis$new()
  
  # Obtendo o tempo inicial de analise em segundos
  analise_inicio = as.numeric(Sys.time())
  
  # Realizando analises
  maxValue = maxValueAnalysis$analysis(userInfoList)
  minValue = minValueAnalysis$analysis(userInfoList)
  meanValue = meanAnalysis$analysis(userInfoList)
  
  # Obtendo o tempo final de analise em segundos
  analise_fim = as.numeric(Sys.time())
  
  # Tempo de leitura em milissegundos
  leitura = (leitura_fim - leitura_inicio) * 1000
  
  # Tempo de análise em milissegundos
  analise = (analise_fim - analise_inicio) * 1000
  
  # Dados de saida
  labels = c("Identificador", "Tempo de leitura (ms)", "Tempo de análise (ms)", "Max", "Min", "Mean")
  values = c(identificador, leitura, analise, maxValue, minValue, meanValue)
  cat(sprintf("%s: %s\n", labels, values), sep = "")
}

fileName = "/home/pedro/MEGA/MEGAsync/Repositorio_Git/Benchmark-Languages/outputs/inputclass/inputclass_1e+06.csv"
identificador = "r_3_inputclass_1e+06"
read(fileName, identificador)

# Executando garbage collector manualmente
gc()
