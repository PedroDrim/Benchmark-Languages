Table = 
  R6Class("Table",
          public = list(
            
            initialize = function(fileName) {
              private$fileName = fileName
              private$userInfoList = private$deserializeFile(fileName)
            },
            
            getFileName = function() { return(private$fileName) },
            
            getUserInfoList = function() { return(private$userInfoList) }
          ),
          
          private = list(
            fileName = NULL,
            userInfoList = c(),
            
            deserializeFile = function(fileName) {
              dt = fread(fileName)
              vec = 1:dim(dt)[1]
              
              loadcmp("./bin/UserInfo.Rc")
              
              list = sapply(vec, function(index){
                user = dt$user[index]
                password = dt$password[index]
                credit = dt$credit[index]
                userInfo = UserInfo$new(user, password, credit)
                return(userInfo)
              })
              
              return(list)
            }
          )
  )