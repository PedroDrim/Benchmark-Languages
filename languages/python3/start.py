# Importando bibliotecas
from src.UserInfo import UserInfo
import time

# Obtendo o tempo inicial em milissegundos
antes = time.time() * 1000

# Iniciando um vetor vazio
list = []

# Instanciando 1.000.000 (um milhão) de "UserInfo" e adicionando-os á lista
for index in range(1000000):
    user = "user{}".format(index)
    password = "password{}".format(index)
    list.append(UserInfo(user, password))

# Obtendo o tempo final em milissegundos
depois = time.time() * 1000

# Exibindo o tempo de execução
print(depois - antes)