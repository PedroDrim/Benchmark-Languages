# Criando uma classe "MinValueAnalysis"
MinValueAnalysis = 
  R6Class("MinValueAnalysis",
          # Definindo valores e funções públicas
          public = list(
            
            # Método de interface, responsável por realizar a análise na lista de "UserInfo"
            # list -> Lista de "UserInfo"
            # RETURN -> Valor minimo da lista            
            analysis = function(userInfoList) {
              
              creditVector = sapply(userInfoList, function(userInfo) {
                return(userInfo$getCredit())
              })
              
              return(min(creditVector))
            }
          )
  )