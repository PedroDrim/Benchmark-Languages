#====================================================
writeRandomData = function(size, fileName, seedId = 1, maxInterval = 1000000) {
  
  set.seed(seedId)
  
  size = abs(size)

  iterations = ceiling(size/maxInterval) 
  
  for(i in 1:iterations) {
    a1 = 1 + ((i-1) * maxInterval)
    a2 = i * maxInterval
    
    if(a2 > size)
      a2 = size
    
    userlist = sprintf("user%s", a1:a2)
    passwordlist = sprintf("password%s", a1:a2)
    credit = abs(rnorm(length(a1:a2)) * 100)
    
    table = data.table(user = userlist, password = passwordlist, credit = round(credit, 2))
    
    name = sprintf("./tmp/%s_%s.csv", fileName, as.character(size) )
    fwrite(table, name, append = (i != 1))
  }
  
}
#====================================================

#====================================================
runExperiments = function(projectConfigurationFile, outputDir, inputList, times = 10) {
  
  line = paste(readLines(projectConfigurationFile), collapse = "")
  properties = fromJSON(line)
  
  for(experiment in properties) {
    cat(sprintf("[!] Experimento: %s\n", experiment$id), sep = "")
    resultList = list()
  
    first = TRUE  
    for(i in inputList) {    
      fn = strsplit(i, split = "/")[[1]]
      fn = fn[length(fn)]
      
      for(t in 1:times) {
        
        startTime = proc.time()
        
        cat(sprintf("[START %s] File: %s\n", t, fn), sep = "")
        
        valuesList = list()
        valuesList$INPUT_FILENAME = i
        valuesList$OUTPUT_FILENAME = "benchmark.json"
          
        propFile = strsplit(experiment$run, " ")[[1]]
        propFile = propFile[length(propFile)]
        
        createConfigFile(propFile, valuesList, directory = experiment$directory)
        
        cmd = sprintf("cd %s && %s", experiment$directory, experiment$run)
        system(cmd , ignore.stdout = TRUE, ignore.stderr = TRUE)
        
        benchmarkOutput = sprintf("%s/%s", experiment$directory, valuesList$OUTPUT_FILENAME)
        
        result = fromJSON(file = benchmarkOutput)
        
        tag = sprintf("%s_%s_%s", experiment$id, t, fn)
        resultList[[tag]] = result
        
        endTime = proc.time()
        cat(sprintf("[END %s] Time: %s sec\n\n",t ,round(endTime[3] - startTime[3], 2) ) , sep = "")
      }
      
      outputJsonResult = sprintf("%s/%s_Result.json", outputDir, experiment$id)
      cat(toJSON(resultList), file = outputJsonResult, sep = "", append = !first)
    }
  }
  
  return(resultList)
}
#====================================================

#====================================================
createConfigFile = function(fileName, valuesList, directory = "./") {
  fileType = strsplit(fileName, split = "\\.")[[1]]
  fileType = fileType[length(fileType)]
  
  fileName = gsub("./", "", fileName)
  
  fileName = sprintf("%s/%s", directory, fileName)
  
  if(fileType == "properties") {
    for(i in 1:length(valuesList)) {
      index = names(valuesList)[i]
      value = valuesList[[i]]   
      
      cat(sprintf("%s=%s", index, value), file = fileName, sep = "\n", append = (i != 1))
    }
  
  } else if (fileType  == "json") {
      cat(toJSON(valuesList), file = fileName, sep = "")
    
  } else {
    stop("formato de propriedade desconhecido")
  }
  
}
#====================================================

#====================================================
convertTotable = function(arq) {
  a = fromJSON(file = arq)
  
  b = lapply(a, unlist)
  b = do.call(rbind,b)
  
  rn = sapply(rownames(b), function(x) {
    x = strsplit(x, split = "_")[[1]]
    x = paste(x[c(1,3,4)], collapse = "_")
    return(x)
  })
  
  b = data.frame(b)
  rownames(b) = NULL
  b$id = rn
  
  r = data.frame()
  
  for(i in unique(b$id)) {
    x = b[b$id == i, -6]
    x = apply(x, 2, function(x) {
      x = as.numeric(x)
      x = c(mean(x), sd(x))
      names(x) = c("mean", "sd")
      return(x)
    })
    
    x = data.frame(x)
    x$id = i
    x$type = rownames(x)
    
    r = rbind(r, x)
  }
  
  return(r)
}
#====================================================