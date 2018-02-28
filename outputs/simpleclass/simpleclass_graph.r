require(ggplot2)

file = file.choose()
benchmark = read.csv(file)

treatment = apply(benchmark, 2, mean)
languages = strsplit(names(treatment), "\\.")
languages  = sapply(languages, function(x){
  return(x[1])
})

dt = data.frame(time = as.numeric(treatment)/1000, lang = languages)

tiff(filename = "benchmark_simpleclass.tiff")

ggplot(data=dt, aes(x=lang, y=time)) +
  geom_bar(stat="identity", fill="steelblue") +
  theme_minimal()

dev.off()
