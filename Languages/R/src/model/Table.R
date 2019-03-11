# Classe para gerenciar uma tabela de usuarios
Table = R6Class("Table",
                   public = list(
                     
                     # Construtor publico da classe
                     # @param fileNAme Nome do arquivo
                     initialize = function(fileName) {
                       private$fileName = fileName
                       private$userInfoList = private$deserializeFile(fileName)
                     },
                     
                     # Obtem o nome do arquivo
                     # @return Nome do arquivo
                     getFileName = function() {
                       return(private$fileName)
                     },
                     
                     # Obtem a lista de usuarios
                     # @return Lista de usuarios
                     getUserInfoList = function() {
                       return(private$userInfoList)
                     }
                   ),
                   
                   private = list(
                     fileName = "",
                     userInfoList = list(),
                     
                     # Método privado para conversão do arquivo .csv em uma lista de usuarios
                     # @param fileName Nome do arquivo
                     # @return Lista convertida de usuarios   
                     deserializeFile = function(fileName) {
                       
                       # Obs.: Leitura de arquivo extremamente rápida (própria para big data)
                       dt = fread(fileName)
                       
                       list = with(dt, {
                         UserInfo$new(user, password, credit)
                       })

                       return(list)
                     }
                     
                   )
)