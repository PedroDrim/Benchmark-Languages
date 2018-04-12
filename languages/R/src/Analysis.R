#==============================================
tableValidation = function(table) {
  if(is.na(table) || dim(table)[1] == 0 || !is.data.frame(table)) {
    stop("table e NA, vazia ou nao e uma tabela")
  }
}
#==============================================

#==============================================
summaryAnalysis = function(table) {
  tableValidation(table)
  
  result = summary(table[,3])
  return(result)
}
#==============================================

#==============================================
bubbleSortAnalysis = function(table) {
  tableValidation(table)
  
  table = as.matrix(table)
  size = dim(table)[1]
  
  for( end in 1:(size) ) {
    for( index in 2:(size - end)  ) {

      if( (index > 1) && as.numeric(table[index, 3]) > as.numeric(table[index-1, 3]) ){
        aux = table[index-1, ]
        table[index-1, ] = table[index, ]
        table[index, ] = aux      
      }   

    }
  }
  
  return(table)
}
#==============================================

#==============================================
languageSortAnalysis = function(table) {
  tableValidation(table)
  
  return(table[order(credit),])
}
#==============================================

#==============================================
quickSortAnalysis = function(dt) {
  tableValidation(dt)
  
  t = as.matrix(dt) 
  
  quickSort = function(t, baixo, alto) {
    if(baixo > alto) {
      stop("baixo e maior que alto")
    }
    
    indexInicio = baixo
    indexFim = alto
    
    # Get the pivot element from the middle of the list
    index = baixo + (alto - baixo)/2 
    indexPivot = round(index)
    
    tamanho = dim(t)[1]
    
    # Divide into two lists
    while (indexInicio <= indexFim) {
      pivotCredit = t[indexPivot, 3]
    
      # If the current value from the left list is smaller than the pivot
      # element then get the next element from the left list
      while (t[indexInicio, 3] < pivotCredit) {
          indexInicio = indexInicio + 1
          if(indexInicio > tamanho) break
      }
      
      # If the current value from the right list is larger than the pivot
      # element then get the next element from the right list
      while (t[indexFim, 3] > pivotCredit) {
          indexFim = indexFim - 1
          if(indexFim < 1) break
      }
      
        
      # If we have found a value in the left list which is larger than
      # the pivot element and If we have found a value in the right list
      # which is smaller than the pivot element then we exchange the
      # values.
      # As we are done we can increase i and j
      if (indexInicio <= indexFim) {
        aux = t[indexFim, ]
        t[indexFim, ] = t[indexInicio, ]
        t[indexInicio, ] = aux      
      
        indexInicio = indexInicio + 1
        indexFim = indexFim - 1
      }
      
    }
    
    # Recursion
    if (baixo < indexFim)
      t = quickSort(t, baixo, indexFim)
    
    if (indexInicio < alto) 
      t = quickSort(t, indexInicio, alto) 
    
    return(t)
  }
  
  t = quickSort(t, 1, dim(t)[1])
  return(t)
}
#==============================================