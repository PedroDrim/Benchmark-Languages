#====================================================
writeRandomData = function(size, seedId = 1) {
  
  set.seed(seedId)
  
  size = abs(size)
  userlist = sprintf("user%s", 1:size)
  passwordlist = sprintf("password%s", 1:size)
  credit = abs(rnorm(size) * 100)
  
  table = data.frame(user = userlist, password = passwordlist, credit = round(credit, 2))
  
  name = sprintf("./output/inputclass_%s.csv", as.character(size) )
  fwrite(table, name)
  
  result = summary(table$credit)[c(1,6,4)]
  result = c(size, result)
  
  return(result)  
}
#====================================================