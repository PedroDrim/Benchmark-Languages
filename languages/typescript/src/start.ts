// Importando bibliotecas
import {UserInfo} from './model/UserInfo'

// Obtendo o tempo inicial em milissegundos
let antes = new Date().getTime()

// Iniciando um vetor vazio de "UserInfo"
var list: UserInfo[] = new Array()

// Instanciando 1.000.000 (um milhão) de "UserInfo" e adicionando-os á lista
for(var index = 0; index < 1000000; index++){
    let user = "user" + index
    let password = "password" + index
    list.push(new UserInfo(user, password))
}

// Obtendo o tempo final em milissegundos
let depois = new Date().getTime()

// Exibindo o tempo de execução
console.log(depois - antes)