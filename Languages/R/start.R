# Importando bibliotecas
require(compiler)
require(R6)

if(!dir.exists("./bin"))
  dir.create("./bin")

# Compilando arquivos .R em binários .Rc
cmpfile("./src/functions.R","./bin/functions.Rc")
cmpfile("./src/model/UserInfo.R","./bin/UserInfo.Rc")

# Lendo binários .Rc
loadcmp("./bin/functions.Rc")
loadcmp("./bin/UserInfo.Rc")

args = commandArgs(trailingOnly = TRUE)
start(args)
