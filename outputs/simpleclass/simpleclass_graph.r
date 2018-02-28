require(ggplot2)

file = file.choose()
benchmark = read.csv(file)

treatment = apply(benchmark, 2, mean)
languages = strsplit(names(treatment), "\\.")
languages  = sapply(languages, function(x){
  return(x[1])
})

dt = data.frame(seconds = as.numeric(treatment)/1000, language = languages)

png(filename = "benchmark_simpleclass.png")

ggplot(data=dt, aes(x=language, y=seconds)) +
  geom_bar(stat="identity", fill="steelblue") +
  geom_text(aes(label=seconds), vjust=-0.3, size=3.5) +
  theme_minimal()

dev.off()
