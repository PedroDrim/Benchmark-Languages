# Importando bibioteca para paralelização de tarefas
require(parallel)

# Função para executar os experimentos
readData = function(langDirectory, shellFile = "Bench.sh", times = 10, paramArray = "1000") {
  if(times <= 0) times = 1
  
  lang = strsplit(langDirectory, split = "/")[[1]]
  result = list()
  result$lang = lang[length(lang)]
  
  for(param in paramArray) {
    result[[param]] = list()
    
    for(t in 1:times) {
      
      cmd = sprintf("cd %s && sh %s %s", langDirectory, shellFile, param)
      result[[param]][[t]] = system(cmd, intern = T)
    }
  }
  
  return(result)
}