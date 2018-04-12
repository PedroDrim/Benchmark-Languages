# Importando bibliotecas
require(compiler)
require(data.table)
require(rjson)

# Compilando arquivos .R em binários .Rc
# cmpfile("./src/Analysis.R","./bin/Analysis.Rc")
# cmpfile("./src/MainFunctions.R","./bin/MainFunctions.Rc")

# Lendo binários .Rc
loadcmp("./bin/Analysis.Rc")
loadcmp("./bin/MainFunctions.Rc")

file.config = commandArgs(trailingOnly = TRUE)
properties = fromJSON(file = file.config)

result = start(properties$INPUT_FILE)

serializedResult = toJSON(result)
cat(serializedResult, file = properties$OUTPUT_FILE)
