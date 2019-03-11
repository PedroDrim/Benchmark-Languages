# Criando uma classe "MeanValueAnalysis"
MeanAnalysis = R6Class("MeanAnalysis",
                   public = list(
                     
                     # Método responsável por obter a media dos valore de credit na lista de usuarios
                     # @param userInfoList Lista de usuarios
                     # @return Media de valores de credit da lista
                     analysis = function(userInfoList) {
                       creditVector = userInfoList$getCredit()
                       creditVector = as.numeric(creditVector)
                       return(mean(creditVector))
                     }
                   )
)