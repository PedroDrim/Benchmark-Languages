require(data.table)
source("./src/dataFunction.R")

sizes = c(1000, 10000, 100000, 1000000)
result = lapply(sizes, writeRandomData)

a = do.call(rbind, result)
colnames(a)[1] = "Size"
a = as.data.frame(a)

write.csv(a, "./output/analysisResult.csv")
