# Importando biblioteca para compilação
require(compiler)

# Compilando arquivos
cmpfile("src/ExperimentCreator.R", "bin/ExperimentCreator.Rc")
cmpfile("src/Reader.R", "bin/Reader.Rc")
cmpfile("src/Analyser.R", "bin/Analyser.Rc")
cmpfile("src/Plotter.R", "bin/Plotter.Rc")

# Lendo arquivos compilados
loadcmp("bin/ExperimentCreator.Rc")
loadcmp("bin/Reader.Rc")
loadcmp("bin/Analyser.Rc")
loadcmp("bin/Plotter.Rc")

#===============================
# Inicio dos experimentos 
array_size = createExperiment(1:9)

directory = "/home/pedro/MEGA/MEGAsync/Repositorio_Git/Benchmark-branches/simpleClass/Benchmark-Languages/Languages"
benchDirs = list.files(directory, full.names = T)

# Realizando Benchmark
result_matrix = lapply(benchDirs, readData, paramArray = array_size, outputTag = "\\[OK\\]") 
result_matrix = do.call(rbind, result_matrix)

# Analisando dados
analysed_df = analyseData(result_matrix)

# Gerando gráfico das análises
plotData(analysed_df, name_prefix = "Plot_SimpleClass")

# Fim dos experimentos 
#===============================