# Informacoes do usuario
UserInfo = R6Class("UserInfo",
  public = list(
    
    # Construtor publico da classe
    # @param user Nome do usuario
    # @param password Senha do usuario
    initialize = function(user, password) {
      private$user = user
      private$password = private$cryptPassword(password)
    },
                   
    # Obtem o nome do usuario
    # @return Nome do usuario
    getUser = function() {
      return(private$user)
    },
    
    # Obtem a senha do usuario criptografada
    # @return Senha do usuario criptografada
    getPassword = function() {
      cryptPass = private$cryptPassword(private$password)
      return(cryptPass)
    },
    
    # Atualiza o nome do usuario
    # @param user Novo nome do usuario
    setUser = function(user) {
      private$user = user
    },
    
    # Atualiza a senha do usuario
    # @param password Nova senha do usuario
    setPassword = function(password) {
      private$password = password
    }
  ),
                 
  private = list(
    user = "",
    password = "",
    
    # Metodo privado para encriptar a senha do usuario
    # @param password Senha a ser encriptada
    # @return Nova senha encriptada
    cryptPassword = function(password) {
      crypt = strsplit(password, "")[[1]]
      crypt = rev(crypt)
      crypt = sprintf("HASH%s000", paste(crypt, collapse = "") )
      
      return(crypt)
    }
  )
)