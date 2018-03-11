# Importando biblioteca de OO
require(R6)

# Função para gerar uma lista de "UserInfo" com tamanho "size"
# size -> Tamanho da lista
# RETURN -> lista gerada
getList = function(size){
  
  # Método de interação de listas (map)
  list = lapply(1:size, function(index){
    user = sprintf("user%s", index)
    password = sprintf("password%s", index)
    return(UserInfo$new(user, password))
  })
  
  return(list)
}
