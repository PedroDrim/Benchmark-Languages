require(R6)

getList = function(size){
  
  list = lapply(1:size, function(index){
    user = sprintf("user%s", index)
    password = sprintf("password%s", index)
    return(UserInfo$new(user, password))
  })
  
  return(list)
}
