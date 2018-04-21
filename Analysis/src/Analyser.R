# Importando bibioteca para paralelização de tarefas
require(parallel)

# Função para analisar os resultados dos experimentos
analyseData = function(result) {

  lang = NA
  
  for(element in result) {
    if(class(element) == "character") {
      lang = element
    
    } else {
      
    }
  }
  
}

