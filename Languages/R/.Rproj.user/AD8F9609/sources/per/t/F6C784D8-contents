# Criando uma classe "UserInfo"
# @param user Nome do usuario
# @param password Senha do usuario
UserInfo.new = function(user, password) {
  crypt = strsplit(password, "")[[1]]
  crypt = rev(crypt)
  crypt = sprintf("HASH%s000", paste(crypt, collapse = "") )
  
  res = list()
  res$user = user
  res$password = crypt
  
  class(res) = c("UserInfo")
  return(res)
}
