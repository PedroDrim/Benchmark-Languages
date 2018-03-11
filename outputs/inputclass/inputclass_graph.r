# Importando bibliotecas
require(ggplot2)
require(reshape2)
require(data.table)

source("src/analysisFunction.R")

file = "./output/analysisResult.csv"

# Convertendo arquivo .data para data.frame
summary_table = convertToDataFrame(file)

# Analisando tabela gerada
summary_table = analysis(summary_table)

# Exportando resultados
write.csv(summary_table, "./output/inputclass_result.csv", row.names = FALSE)

index = unique(summary_table$file)
# Exportando gráficos
r = lapply(index, drawGraph, summary_table)

