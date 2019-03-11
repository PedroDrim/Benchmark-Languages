# Criando uma classe "MinValueAnalysis"
MinValueAnalysis = R6Class("MinValueAnalysis",
                       public = list(
                         
                         # Método responsável por obter o menor valor de credit na lista de usuarios
                         # @param userInfoList Lista de usuarios
                         # @return Valor minimo da lista
                         analysis = function(userInfoList) {
                           creditVector = userInfoList$getCredit()
                           creditVector = as.numeric(creditVector)
                           return(min(creditVector))
                         }
                       )
)