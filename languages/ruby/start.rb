# Importando bibliotecas
require './src/UserInfo.rb'

# Obtendo o tempo inicial em milissegundos
antes = Time.now

# Iniciando um vetor vazio
list = Array.new

# Instanciando 1.000.000 (um milhão) de "UserInfo" e adicionando-os á lista
(0..1000000).each do |index|
    user = "user#{index}"
    password = "password#{index}"
    list.push(UserInfo.new(user, password))
end

# Obtendo o tempo final em milissegundos
depois = Time.now

# Exibindo o tempo de execução
p (depois - antes)* 1000.0