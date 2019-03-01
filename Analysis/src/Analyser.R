# Importando bibioteca para paralelização de tarefas
require(plyr)

#====================================================
# Função para analisar os resultados dos experimentos
analyseData = function(result, timeScale = "ms") {

  #====================================================
  # Prepare the data
  
  result = data.frame(result)
  
  tamanho_array = as.character(result$Tamanho)
  tamanho_array = gsub("\"", "", tamanho_array)
  
  result$Tamanho = tamanho_array
  
  tempo_array = as.character(result$Tempo)
  tempo_array = gsub(timeScale, "", result$Tempo)
  tempo_array = gsub("\"", "", tempo_array)
  
  result$Tempo = as.numeric(tempo_array)
  
  #====================================================
  
  #====================================================
  # Analyse the data
  
  result$lang = as.character(result$lang)
  
  a = ddply(result, c("lang", "Tamanho"), summarise,
        mean = round(mean(Tempo), 2),
        sd = round(sd(Tempo), 2))
  
  a$Tamanho = as.character(a$Tamanho)
  a$Tamanho = as.numeric(a$Tamanho)
  #====================================================
  
  return(a)
}
#====================================================
