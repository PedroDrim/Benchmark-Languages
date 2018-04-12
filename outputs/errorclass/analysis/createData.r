# Importando bibliotecas
require(data.table)
require(compiler)
require(rjson)

cmpfile("./src/analysisBuildFunction.R", "./bin/analysisBuildFunction.Rc")
loadcmp("./bin/analysisBuildFunction.Rc")

# Definindo array de tamanhos
sizes = 1000*(1:20)
#sizes = 10^(3:4)

# Gerando dados, analisando e exportando com a quantidade de elementos em cada valor de "sizes"
result = lapply(sizes, writeRandomData, "userInfoList")

d = sprintf("%s/tmp", getwd())

inputFiles = list.files(d, full.names = T, pattern = ".csv")
# runExperiments("./analysisConfig.json", d, inputFiles)

resultFiles = list.files(d, full.names = T, pattern = ".json")

dt = lapply(resultFiles[-7], convertTotable)
dt = do.call(rbind, dt)

gc()
