# Importando biblioteca para compilação
require(compiler)
require(parallel)

# Compilando arquivos
cmpfile("src/Reader.R", "bin/Reader.Rc")
cmpfile("src/Analyser.R", "bin/Analyser.Rc")
cmpfile("src/Plotter.R", "bin/Plotter.Rc")

# Lendo arquivos compilados
loadcmp("bin/Reader.Rc")
loadcmp("bin/Analyser.Rc")
loadcmp("bin/Plotter.Rc")

#===============================
# Inicio dos experimentos 

array_size = sprintf("%s00000", 1:9)

directory = "/home/pedro/MEGA/MEGAsync/Repositorio_Git/Benchmark-Languages/Languages"
benchDirs = list.files(directory, full.names = T)

# Realizando Benchmark
cl = makeCluster(getOption("cl.cores", length(benchDirs)) )
result_matrix = parLapply(cl, benchDirs, readData, paramArray = array_size, outputTag = "\\[OK\\]") 
result_matrix = do.call(rbind, result_matrix)
stopCluster(cl)

# Analisando dados
analysed_df = analyseData(result_matrix)

# Gerando gráfico das análises
plotData(analysed_df, name_prefix = "Plot_SimpleClass")

# Fim dos experimentos 
#===============================