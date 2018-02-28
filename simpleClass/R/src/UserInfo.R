UserInfo = 
  R6Class("UserInfo",
          public = list(
            
            initialize = function(user, password) {
              private$user = user
              private$password = password
            },
            
            getUser = function() { return(private$user) },
            
            getPassword = function() { 
              crypt = private$cryptPassword( private$password ) 
              return(crypt) 
            },
            
            setUser = function(user) { self$user = user },
            
            setPassword = function(password) { self$password = password }
            
          ),
          
          private = list(
            user = NULL,
            password = NULL,
            cryptPassword = function(password) {
              crypt = strsplit(password, "")[[1]]
              crypt = rev(crypt)
              return(sprintf("HASH%s000", paste(crypt, collapse = "") ))
            }
          )
 )
