# Importando bibioteca para paralelização de tarefas
require(plyr)

#====================================================
# Função para analisar os resultados dos experimentos
analyseData = function(result, timeScale = "ms") {

  #====================================================
  # Prepare the data
  
  result = data.frame(result)
  
  tamanho_array = as.character(result$Arquivo)
  tamanho_array = sapply(tamanho_array, function(tam) {
    res = strsplit(tam, split = "/")[[1]]
    return(res[length(res)])
  })
  
  result$Arquivo = tamanho_array
  
  result$Tempo_leitura = gsub(timeScale, "", result$Tempo_leitura)
  result$Tempo_leitura = gsub(" " , "", result$Tempo_leitura)
  result$Tempo_leitura = as.numeric(result$Tempo_leitura)
  
  result$Tempo_analise = gsub(timeScale, "", result$Tempo_analise)
  result$Tempo_analise = gsub(" " , "", result$Tempo_analise)
  result$Tempo_analise = as.numeric(result$Tempo_analise)
  #====================================================
  
  #====================================================
  # Analyse the data
  
  result$lang = as.character(result$lang)
  
  a = ddply(result, c("lang", "Arquivo"), summarise,
        mean_leitura = round(mean(Tempo_leitura), 2),
        sd_leitura = round(sd(Tempo_leitura), 2),
        mean_analise = round(mean(Tempo_analise), 2),
        sd_analise = round(sd(Tempo_analise), 2))
  
  a$mean_leitura = as.numeric(as.character(a$mean_leitura))
  a$sd_leitura = as.numeric(as.character(a$sd_leitura))
  
  a$mean_analise = as.numeric(as.character(a$mean_analise))
  a$sd_analise = as.numeric(as.character(a$sd_analise))
  #====================================================
  
  a$Tamanho = sapply(a$Arquivo, function(x) {
    x = strsplit(x, split = "/")[[1]]
    x = x[length(x)]
    x = strsplit(x, split = "_")[[1]]
    x = x[length(x)]
    x = strsplit(x, split = "\\.")[[1]]
    x = x[1]
    
    return(x)
  })
  
  a$Tamanho = as.numeric(a$Tamanho)
  return(a)
}
#====================================================