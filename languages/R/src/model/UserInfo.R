UserInfo = 
  R6Class("UserInfo",
          public = list(
            
            initialize = function(user, password, credit) {
              private$user = user
              private$password = password
              private$credit = credit
            },
            
            getUser = function() { return(private$user) },
            
            getCredit = function() { return(private$credit) },
            
            getPassword = function() { 
              crypt = private$cryptPassword( private$password ) 
              return(crypt) 
            },
            
            setUser = function(user) { self$user = user },
            
            setCredit = function(credit) { self$credit = credit },
            
            setPassword = function(password) { self$password = password }
            
          ),
          
          private = list(
            user = NULL,
            password = NULL,
            credit = 0,
            cryptPassword = function(password) {
              crypt = strsplit(password, "")[[1]]
              crypt = rev(crypt)
              return(sprintf("HASH%s000", paste(crypt, collapse = "") ))
            }
          )
 )
