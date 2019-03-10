# Informacoes do usuario
UserInfo = R6Class("UserInfo",
<<<<<<< HEAD
                   public = list(
                     
                     # Construtor publico da classe
                     # @param user Nome do usuario
                     # @param password Senha do usuario
                     initialize = function(user, password) {
                       private$user = user
                       private$password = private$cryptPassword(password)
                       private$tamanho = length(user)
                     },
                     
                     # Obtem o nome do usuario
                     # @param index posicao dos usuarios
                     # @return Nome do usuario
                     getUser = function(index = NA) {
                       if(is.na(index))
                         index = 1:private$tamanho
                       return(private$user[index])
                     },
                     
                     # Obtem a senha do usuario criptografada
                     # @param index posicao dos usuarios
                     # @return Senha do usuario criptografada
                     getPassword = function(index = NA) {
                       if(is.na(index))
                         index = 1:private$tamanho
                       return(private$password[index])
                     },
                     
                     # Atualiza o nome do usuario
                     # @param index posicao dos usuarios
                     # @param user Novo nome do usuario
                     setUser = function(index, user) {
                       private$user[index] = user
                     },
                     
                     # Atualiza a senha do usuario
                     # @param index posicao dos usuarios
                     # @param password Nova senha do usuario
                     setPassword = function(index, password) {
                       private$password[index] = private$cryptPassword(password)
                     }
                     
                   ),
                   
                   private = list(
                     user = "",
                     password = "",
                     tamanho = 0,
                     
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
=======
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
>>>>>>> ac0fd804d29290d391c2d367cd09d8994d27c44c
