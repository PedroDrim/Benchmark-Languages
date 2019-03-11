# Criando uma classe "MaxValueAnalysis"
MaxValueAnalysis = R6Class("MaxValueAnalysis",
                           public = list(
                             
                             # Método responsável por obter o maior valor de credit na lista de usuarios
                             # @param userInfoList Lista de usuarios
                             # @return Valor máximo da lista
                             analysis = function(userInfoList) {
                               creditVector = userInfoList$getCredit()
                               creditVector = as.numeric(creditVector)
                               return(max(creditVector))
                             }
                           )
)