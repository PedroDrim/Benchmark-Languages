MinValueAnalysis = 
  R6Class("MinValueAnalysis",
          public = list(
            
            analysis = function(userInfoList) {
              
              creditVector = sapply(userInfoList, function(userInfo) {
                return(userInfo$getCredit())
              })
              
              return(min(creditVector))
            }
          )
  )