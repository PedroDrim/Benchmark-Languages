# Importando bibliotecas
require(compiler)

# Compilando arquivos .R em binários .Rc
cmpfile("./src/functions.R","./src/functions.Rc")
cmpfile("./src/UserInfo.R","./src/UserInfo.Rc")

# Lendo binários .Rc
loadcmp("./src/functions.Rc")
loadcmp("./src/UserInfo.Rc")

# Definindo tamanho como 1.000.000 (um milhão)
size = 1000000

# Obtem tempo total de execução, em milissegundos, para gerar uma lista de "UserInfo" com "size" de tamanho  
time = system.time(getList(size))[3]

# Exibe o tempo
print(time)
