MaxValueAnalysis = 
  R6Class("MaxValueAnalysis",
          public = list(
            
            analysis = function(userInfoList) {
              
              creditVector = sapply(userInfoList, function(userInfo) {
                return(userInfo$getCredit())
              })
              
              return(max(creditVector))
            }
          )
  )