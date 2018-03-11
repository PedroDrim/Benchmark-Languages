# Criando uma classe "UserInfo"
UserInfo = 
  R6Class("UserInfo",

          # Definindo valores e funções públicas
          public = list(
            
            # Construtor da classe
            # user -> nome do usuário
            # password -> senha do usuário
            initialize = function(user, password) {
              private$user = user
              private$password = password
            },

            # Método getter da variável 'user'
            # instance.getUser(), para getter        
            getUser = function() { return(private$user) },
            
            # Método getter customizado da variável 'password'
            # instance.getPassword(), para getter
            getPassword = function() { 
              crypt = private$cryptPassword( private$password ) 
              return(crypt) 
            },
            
            # instance.setUser(valor), para setter
            # valor -> novo user
            setUser = function(user) { self$user = user },
            
            # instance.setPassword(valor), para setter
            # valor -> novo password           
            setPassword = function(password) { self$password = password }
            
          ),
          
          # Definindo valores e funções privadas          
          private = list(

            # Variavel privada 'user'
            user = NULL,

            # Variavel privada 'password'
            password = NULL,

            # Método privado para encriptar 'password'
            cryptPassword = function(password) {
              crypt = strsplit(password, "")[[1]]
              crypt = rev(crypt)
              return(sprintf("HASH%s000", paste(crypt, collapse = "") ))
            }
          )
 )
