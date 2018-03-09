MeanAnalysis = 
  R6Class("MeanAnalysis",
          public = list(
            
            analysis = function(userInfoList) {
              
              creditVector = sapply(userInfoList, function(userInfo) {
                return(userInfo$getCredit())
              })
              
              return(mean(creditVector))
            }
          )
  )