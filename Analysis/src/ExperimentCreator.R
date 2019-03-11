#====================================================
# Funcao para gerar parametros dos experimentos
createExperiment = function(size) {
  array_size = sprintf("%s00000", size)
  cl = makeCluster(getOption("cl.cores", length(array_size) - 1) )
  
  res = parSapply(cl, array_size, function(size) {
    fileName = sprintf("./output/experimento_%s.csv", size)
    cat("user,password,credit\n", file = fileName, append = F)
    vec = 1:size
    users = sprintf("user_%s,password_%s,%s", vec, vec, abs(rnorm(vec)) )
    cat(users, file = fileName, append = T, sep = "\n")
    
    return(fileName)
  })
  
  stopCluster(cl)
  outputDir = sprintf("%s/output", getwd())
  fullDir = list.files(outputDir, full.names = T, pattern = ".csv$")
  return(fullDir)
}
#====================================================