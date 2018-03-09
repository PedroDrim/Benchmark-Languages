require(ggplot2)
require(reshape2)
require(data.table)

source("src/analysisFunction.R")

file = file.choose()
summary_table = convertToDataFrame(file)
summary_table = analysis(summary_table)

write.csv(summary_table, "./output/inputclass_result.csv", row.names = FALSE)

index = unique(summary_table$file)
r = lapply(index, drawGraph, summary_table)

