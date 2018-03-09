require(compiler)
require(data.table)
require(R6)

cmpfile("./src/model/Table.R","./bin/Table.Rc")
cmpfile("./src/model/UserInfo.R","./bin/UserInfo.Rc")
cmpfile("./src/provider/MaxValueAnalysis.R", "./bin/MaxValueAnalysis.Rc")
cmpfile("./src/provider/MinValueAnalysis.R", "./bin/MinValueAnalysis.Rc")
cmpfile("./src/provider/MeanAnalysis.R", "./bin/MeanAnalysis.Rc")

loadcmp("./bin/Table.Rc")
loadcmp("./bin/MaxValueAnalysis.Rc")
loadcmp("./bin/MinValueAnalysis.Rc")
loadcmp("./bin/MeanAnalysis.Rc")

read = function(fileName, identificador) {
  leitura_inicio = as.numeric(Sys.time())
  
  table = Table$new(fileName)
  
  leitura_fim = as.numeric(Sys.time())
  
  userInfoList = table$getUserInfoList()
  
  maxValueAnalysis = MaxValueAnalysis$new()
  minValueAnalysis = MinValueAnalysis$new()
  meanAnalysis = MeanAnalysis$new()
  
  analise_inicio = as.numeric(Sys.time())
  
  maxValue = maxValueAnalysis$analysis(userInfoList)
  minValue = minValueAnalysis$analysis(userInfoList)
  meanValue = meanAnalysis$analysis(userInfoList)
  
  analise_fim = as.numeric(Sys.time())
  
  leitura = (leitura_fim - leitura_inicio) * 1000
  analise = (analise_fim - analise_inicio) * 1000
  
  labels = c("Identificador", "Tempo de leitura (ms)", "Tempo de análise (ms)", "Max", "Min", "Mean")
  values = c(identificador, leitura, analise, maxValue, minValue, meanValue)
  cat(sprintf("%s: %s\n", labels, values), sep = "")
}

fileName = "/home/pedro/MEGA/MEGAsync/Repositorio_Git/Benchmark-Languages/outputs/inputclass/inputclass_1e+06.csv"

identificador = "r_3_inputclass_1e+06"
read(fileName, identificador)

gc()
