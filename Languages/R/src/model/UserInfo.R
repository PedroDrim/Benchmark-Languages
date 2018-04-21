# Criando uma classe "UserInfo"
# @param user Nome do usuario
# @param password Senha do usuario
UserInfo.new = function(user, password) {
  crypt = strsplit(password, "")[[1]]
  crypt = rev(crypt)
  crypt = sprintf("HASH%s000", paste(crypt, collapse = "") )
  
  res = matrix(NA, ncol = 2, nrow = 1)
  res[1] = user
  res[2] = crypt
  
  colnames(res) = c("user", "password")
  
  class(res) = c("matrix", "UserInfo")
  return(res)
}
