# Importando biblioteca para compilação
require(compiler)

# Compilando arquivos
cmpfile("src/Reader.R", "bin/Reader.Rc")

# Lendo arquivos compilados
loadcmp("bin/Reader.Rc")

#===============================
# Inicio dos experimentos 

result = list()
array_size = sprintf("%s0000", 1:9)

directory = "/home/pedro/MEGA/MEGAsync/Repositorio_Git/Benchmark-Languages/Languages"
benchDirs = list.files(directory, full.names = T)

cl = makeCluster(getOption("cl.cores", length(benchDirs)) )
result_matrix = parLapply(cl, benchDirs, readData, paramArray = array_size) 
stopCluster(cl)

# Fim dos experimentos 
#===============================