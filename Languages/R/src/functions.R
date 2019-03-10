start = function(args) {
  
  size = convertArgs(args)
  
  inicio = proc.time()
  
<<<<<<< HEAD
  user = sprintf("user%s", 1:size)
  password = sprintf("password%s", 1:size)
=======
  list = lapply(1:size, function(index){
    user = sprintf("user%s", index)
    password = sprintf("password%s", index)
    
    return(UserInfo$new(user, password))
  })
>>>>>>> ac0fd804d29290d391c2d367cd09d8994d27c44c
  
  list = UserInfo$new(user, password)

  time = proc.time() - inicio
  time = time[3] * 1000
  
  cat(sprintf("[OK]Tamanho: %s\n", size))
  cat(sprintf("[OK]Tempo: %s ms\n", time))
}

convertArgs = function(args) {

  if(length(args) != 1) {
    cat("Parametros inválidos.\n")
    quit(status = -1, save = "no")
  }
  
  line = as.numeric(args[1])
  
  if(line <= 0) {
    cat("Quantidade de linhas menor que 1.\n")
    quit(status = -1, save = "no")
  }
  
  return(line)
}
