# Criando uma classe "UserInfo"
UserInfo = 
  R6Class("UserInfo",
          # Definindo valores e funções públicas
          public = list(
            
            # Construtor da classe
            # user -> nome do usuário
            # password -> senha do usuário
            # credit -> credito do usuário
            initialize = function(user, password, credit) {
              private$user = user
              private$password = password
              private$credit = credit
            },
            
            # Método getter de "user"
            getUser = function() { return(private$user) },
            
            # Método getter de "credit"
            getCredit = function() { return(private$credit) },
            
            # Método getter customizado de "password"
            getPassword = function() { 
              crypt = private$cryptPassword( private$password ) 
              return(crypt) 
            },
            
            # Método setter de "user"
            setUser = function(user) { self$user = user },

            # Método getter de "credit"
            setCredit = function(credit) { self$credit = credit },
            
            # Método getter de "password"
            setPassword = function(password) { self$password = password }
            
          ),
          # Definindo valores e funções privadas
          private = list(
            user = NULL,
            password = NULL,
            credit = 0,
            
            # Método privado para encriptar senhas
            # password -> senha a ser encriptada
            # RETURN -> nova senha
            cryptPassword = function(password) {
              crypt = strsplit(password, "")[[1]]
              crypt = rev(crypt)
              return(sprintf("HASH%s000", paste(crypt, collapse = "") ))
            }
          )
 )
