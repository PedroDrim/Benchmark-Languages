require(compiler)

#source("./src/UserInfo.R")
cmpfile("./src/functions.R","./src/functions.Rc")
cmpfile("./src/UserInfo.R","./src/UserInfo.Rc")
loadcmp("./src/functions.Rc")
loadcmp("./src/UserInfo.Rc")


size = 1000000
time = system.time(getList(size))[3]

print(time)
