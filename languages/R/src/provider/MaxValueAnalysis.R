# Criando uma classe "MaxValueAnalysis"
MaxValueAnalysis = 
  R6Class("MaxValueAnalysis",
          # Definindo valores e funções públicas
          public = list(
            
            # Método de interface, responsável por realizar a análise na lista de "UserInfo"
            # list -> Lista de "UserInfo"
            # RETURN -> Valor máximo da lista
            analysis = function(userInfoList) {
              
              creditVector = sapply(userInfoList, function(userInfo) {
                return(userInfo$getCredit())
              })
              
              return(max(creditVector))
            }
          )
  )