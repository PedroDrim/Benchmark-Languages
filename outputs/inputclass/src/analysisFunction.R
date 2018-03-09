#====================================================
convertToDataFrame = function(fileName) {
  
  lines = readLines(fileName)
  index = grep("Identificador", lines)
  
  for(i in 1:(length(index) - 1) ){
    start = index[i]
    end = index[i+1] - 2
    
    r = lines[start:end]
    row.value = sapply(r, function(line) {
      line = strsplit(line, ":")[[1]][2]
      return(line)
    })
    
    if(i == 1){
      dt = row.value 
    } else {
      dt = rbind(dt,row.value)
    }
  }
  
  id = lapply(dt[,1], function(matrix.line) {
    matrix.line = strsplit(matrix.line, "_")[[1]]
    language = gsub(" ", "", matrix.line[1])
    id = matrix.line[2]
    file = paste(matrix.line[3:4], collapse = "_")
    
    return(c(id,language,file))
  })
  
  dt = data.frame(dt)
  
  id = transpose(id)  
  dt$id = id[[1]]
  dt$language = id[[2]]
  dt$file = id[[3]]
  
  dt[[1]] = NULL
  
  row.names(dt) = NULL
  colnames(dt) = c("leitura", "analise", "max", "min", "mean", "id", "language", "file")
  
  return(dt)
}
#====================================================

#====================================================
analysis = function(summary_table) {
  
  clusterId = sprintf("%s_%s", summary_table$language, summary_table$file)
  dt = summary_table
  dt$clusterId = clusterId
  dt$language = NULL
  dt$file = NULL
  
  firstId = lapply(unique(clusterId), function(cid, dt) {
    
    firstAnalysis = dt[dt$clusterId == cid,]
    firstAnalysis$clusterId = NULL
    firstAnalysis$id = NULL
    
    firstAnalysis = apply(firstAnalysis, 2, function(row) {
      row = gsub(" ", "", row)
      row = as.numeric(row)
      return(mean(row))
    })
    
    cid = strsplit(cid, "_")[[1]]
    language = cid[1]
    file = paste(cid[2:3], collapse = "_")
    
    firstAnalysis = c(file, language, firstAnalysis)
    names(firstAnalysis)[1:2] = c("file","language")
    return(firstAnalysis)
  }, dt)
  
  a = do.call(rbind, firstId)
  a = data.frame(a)
  return(a)
}
#====================================================

#====================================================
drawGraph = function(id, summary_table) {
  dt = summary_table[summary_table$file == id, c(1:4)]
  resh_dt = melt(dt, id = c("file", "language"))    
  resh_dt$value = round(as.numeric(resh_dt$value))
  
  id = as.character(id)
  fileid = strsplit(id, "_")[[1]][2]
  
  png(filename = sprintf("./output/benchmark_%s_inputclass.png", fileid)) 
  
  g = ggplot(data=resh_dt, aes(x=language, y=value, fill=variable)) +
    geom_bar(stat="identity", position=position_dodge()) +
    ggtitle(sprintf("File: %s", fileid)) + 
    theme_minimal()
  
  plot(g)
  
  dev.off()
}
#====================================================