# Importando biblioteca de gráficos
require(ggplot2)

file = "./fileclass.csv"

# Importando tabela 'file' como data.frame
benchmark = read.csv(file)

# Obtendo média aritmética do tempo obtido em cada linguagem 
treatment = apply(benchmark, 2, mean)

# Separando o nome das colunas da tabela pelo caractere "."
# (Alguns caracteres, como os parênteses, são convertidos para "." durante a leitura do arquivo)
languages = strsplit(names(treatment), "\\.")

# Obtendo o nome das linguagens
languages  = sapply(languages, function(x){
  return(x[1])
})

# Gerando tabela de análise
dt = data.frame(seconds = as.numeric(treatment)/1000, language = languages)

#============================================
# Gerando gráfico "boxplot" dos dados de "dt"
#============================================
png(filename = "benchmark_simpleclass.png")

ggplot(data=dt, aes(x=language, y=seconds)) +
  geom_bar(stat="identity", fill="steelblue") +
  geom_text(aes(label=seconds), vjust=-0.3, size=3.5) +
  theme_minimal()

dev.off()
#============================================