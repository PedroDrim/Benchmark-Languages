# Importando bibliotecas
require(data.table)
source("./src/dataFunction.R")

# Definindo array de tamanhos
sizes = c(1000, 10000, 100000, 1000000)

# Gerando dados, analisando e exportando com a quantidade de elementos em cada valor de "sizes"
result = lapply(sizes, writeRandomData)

# Unindo os resultados em um data.frame
a = do.call(rbind, result)
colnames(a)[1] = "Size"
a = as.data.frame(a)

# exportando resultado
write.csv(a, "../output/analysisResult.csv")
