# Criando uma classe "Table"
Table = 
  R6Class("Table",
          # Definindo valores e funções públicas
          public = list(
            
            # Construtor da classe
            # fileName -> nome do arquivo
            initialize = function(fileName) {
              private$fileName = fileName
              private$userInfoList = private$deserializeFile(fileName)
            },

            #Método getter de "fileName"  
            getFileName = function() { return(private$fileName) },
            
            #Método getter de "userInfoList"
            getUserInfoList = function() { return(private$userInfoList) }
          ),

          # Definindo valores e funções privadas      
          private = list(
            fileName = NULL,
            userInfoList = c(),
            
            # Método privado para conversão do arquivo .csv em uma lista de "UserInfo"
            # fileName -> Nome do arquivo
            # RETURN -> Lista convertida de "UserInfo"
            deserializeFile = function(fileName) {
              # Obs.: Leitura de arquivo extremamente rápida (própria para big data)
              dt = fread(fileName)
              vec = 1:dim(dt)[1]
              
              # Lendo Binário de UserInfo
              loadcmp("./bin/UserInfo.Rc")
              
              # Obs.: Conversão demorada
              list = sapply(vec, function(index){
                user = dt$user[index]
                password = dt$password[index]
                credit = dt$credit[index]
                userInfo = UserInfo$new(user, password, credit)
                return(userInfo)
              })
              
              return(list)
            }
          )
  )