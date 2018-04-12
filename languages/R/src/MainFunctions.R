#===================================================
benchmark = function(table, code, format = 1000) {
  
  # Obtendo o tempo inicial em segundos
  estado_inicio = as.numeric(proc.time()[3])
  result = code(table)
  # Obtendo o tempo final em segundos
  estado_fim = as.numeric(proc.time()[3])
  
  r = list()
  r$time = (estado_fim - estado_inicio) * format
  r$value = result
  
  return(r)
}
#===================================================

#===================================================
# Definindo função para realizar o experimento
start = function(fileName) {

  dataReader = benchmark(fileName, fread)
  dataInput = dataReader$value
  
  summaryResult = benchmark(dataInput, summaryAnalysis)
  bubbleSortResult = benchmark(dataInput, bubbleSortAnalysis)
  languageSortResult = benchmark(dataInput, languageSortAnalysis)
  quickSortResult = benchmark(dataInput, quickSortAnalysis)
  
  timeMap = list()
  timeMap$Read= dataReader$time
  timeMap$SummaryAnalyse = summaryResult$time
  timeMap$BubbleAnalyse = bubbleSortResult$time
  timeMap$LanguageAnalyse = languageSortResult$time
  timeMap$QuickAnalyse = quickSortResult$time
  
  return(timeMap)
}
#===================================================