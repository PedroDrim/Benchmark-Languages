# Importando biblioteca para compilação
require(compiler)
require(parallel)

# Compilando arquivos
cmpfile("src/Reader.R", "bin/Reader.Rc")
cmpfile("src/Analyser.R", "bin/Analyser.Rc")
cmpfile("src/Plotter.R", "bin/Plotter.Rc")
cmpfile("src/ExperimentCreator.R", "bin/ExperimentCreator.Rc")

# Lendo arquivos compilados
loadcmp("bin/Reader.Rc")
loadcmp("bin/Analyser.Rc")
loadcmp("bin/Plotter.Rc")
loadcmp("bin/ExperimentCreator.Rc")

#===============================
# Inicio dos experimentos 

directory = "../Languages"
benchDirs = list.dirs(directory, full.names = T, recursive = F)

array_experiment = createExperiment(1:9)

# Realizando Benchmark
result_matrix = lapply(benchDirs, readData, paramArray = array_experiment, outputTag = "\\[OK\\]") 
result_matrix = do.call(rbind, result_matrix)

# Analisando dados
analysed_df = analyseData(result_matrix)

# Gerando gráfico das análises
plotData(analysed_df, name_prefix = "Plot_InputClass")

# Fim dos experimentos 
#===============================