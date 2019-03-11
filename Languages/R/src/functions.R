# Método para captura e tratamento dos parametros obtidos via console
# @param codes Lista de parametros obtidos via console
# @return Tamanho de usuários á serem gerados
convertArgs = function(args) {
  
  if(length(args) != 1) {
    cat("Parametros inválidos.\n")
    quit(status = -1, save = "no")
  }
  
  line = args[1]
  return(line)
}

# Método de inicialização do projeto
# @param args Lista de parametros obtidos via console
start = function(args) {

  fileName = convertArgs(args)
  
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
  labels = c("Arquivo", "Tempo_leitura", "Tempo_analise", "Max", "Min", "Mean")
  values = c(fileName, leitura, analise, maxValue, minValue, meanValue)
  end = c("", "ms", "ms", "", "", "")
  cat(sprintf("[OK]%s: %s %s\n", labels, values, end), sep = "")
}