// Importando bibliotecas
using System;
using System.Collections;
using System.Linq;
using System.Collections.Generic;

// Definindo "package" da aplicação
namespace simpleclass {
    // Criando uma classe inicial "Program"
    public class Program {
        // Método primário de execução
        // args: String[] -> lista de parametros iniciais
        static void Main(string[] args) {

            // Obtendo o tempo inicial em milissegundos
            long inicio = DateTimeOffset.Now.ToUnixTimeMilliseconds();

            // Instanciando uma lista de "UserInfo"
            List<UserInfo> list = new List<UserInfo>();
            
            // Instanciando 1.000.000 (um milhão) de "UserInfo" e adicionando-os á lista
            for(int index = 0; index < 1000000; index++){
                string user = $"User{index}";
                string password = $"Password{index}";
                list.Add(new UserInfo(user, password));
            }

            // Obtendo o tempo final em milissegundos
            long fim = DateTimeOffset.Now.ToUnixTimeMilliseconds();

            // Exibindo o tempo de execução
            Console.WriteLine(fim - inicio);
        }
    }
}
