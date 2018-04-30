# Função para executar os experimentos
readData = function(langDirectory, outputTag = "\\[OK\\]", shellFile = "Bench.sh", times = 10, paramArray = "1000") {
  if(times <= 0) times = 1
  
  lapply_res = lapply(paramArray, function(param, ot) {
    
    #====================================================
    # Run and get the output
    
    r = list()
    
    for(t in 1:times) {
      cmd = sprintf("cd %s && sh %s %s", langDirectory, shellFile, param)
      out = system(cmd, intern = T)
      
      index = grep(ot, out)
      r[[t]] = out[index]
    }
    
    #====================================================

    #====================================================
    # Clean and return the output
    
    lang_result = as.data.frame(r)
    names(lang_result) = NULL
    
    start_data = apply(lang_result, 1, function(f_line) {
      
      treat = strsplit(f_line, split = ":")
      treat_matrix = do.call(rbind, treat)
      
      return(list(treat_matrix))
    })
    
    size = length(start_data)
    m_res = matrix(NA, ncol = size, nrow = length(lang_result))

    label_array = c()    
    for(i in 1:size )  {
      i_array = start_data[[i]]
      i_array = i_array[[1]]
      label = unique(i_array[,1])
      label = gsub(ot, "", label)
      
      m_res[,i] = i_array[,-1]
      
      label_array = c(label_array, label)
    }    
  
    colnames(m_res) = label_array
    return(m_res)
    
    #====================================================
    
  }, outputTag)

  lang = strsplit(langDirectory, split = "/")[[1]]
  lang = lang[length(lang)]
  
  result = do.call(rbind, lapply_res)
  result = cbind(lang, result)
  
  return(result)
}