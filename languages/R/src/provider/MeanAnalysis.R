# Criando uma classe "MeanAnalysis"
MeanAnalysis = 
  R6Class("MeanAnalysis",
          # Definindo valores e funções públicas
          public = list(

            # Método de interface, responsável por realizar a análise na lista de "UserInfo"
            # list -> Lista de "UserInfo"
            # RETURN -> Média de valores da lista            
            analysis = function(userInfoList) {
              
              creditVector = sapply(userInfoList, function(userInfo) {
                return(userInfo$getCredit())
              })
              
              return(mean(creditVector))
            }
          )
  )