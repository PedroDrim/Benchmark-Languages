# Importando bibliotecas
require(compiler)
require(data.table)
require(R6)

if(!dir.exists("./bin"))
  dir.create("./bin")

# Compilando arquivos .R em binários .Rc
cmpfile("./src/functions.R","./bin/functions.Rc")
cmpfile("./src/model/Table.R","./bin/Table.Rc")
cmpfile("./src/model/UserInfo.R","./bin/UserInfo.Rc")
cmpfile("./src/provider/MaxValueAnalysis.R", "./bin/MaxValueAnalysis.Rc")
cmpfile("./src/provider/MinValueAnalysis.R", "./bin/MinValueAnalysis.Rc")
cmpfile("./src/provider/MeanAnalysis.R", "./bin/MeanAnalysis.Rc")

# Lendo binários .Rc
loadcmp("./bin/functions.Rc")
loadcmp("./bin/Table.Rc")
loadcmp("./bin/UserInfo.Rc")
loadcmp("./bin/MaxValueAnalysis.Rc")
loadcmp("./bin/MinValueAnalysis.Rc")
loadcmp("./bin/MeanAnalysis.Rc")

args = commandArgs(trailingOnly = TRUE)

start(args)