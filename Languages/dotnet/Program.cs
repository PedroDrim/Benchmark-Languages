using System;
using System.Collections;
using System.Text;
using System.Linq;
using System.Collections.Generic;
using experimento.src.model;

namespace experimento {
    
    /// <summary>
    /// Criando uma classe inicial "Program"
    /// </summary>
    public class Program {
        
        /// <summary>
        /// Método primário de execução 
        /// </summary>
        /// <param name="args">Lista de parametros iniciais</param>
        static void Main(string[] args) {

            int tamanho = prepareArgs(args);
            long antes = DateTimeOffset.Now.ToUnixTimeMilliseconds();

            StringBuilder builder = new StringBuilder();
            List<UserInfo> list = new List<UserInfo>();
            
            for(int index = 0; index < tamanho; index++){
                builder.Append("User").Append(index);
                string user = builder.ToString();

                builder = new StringBuilder();

                builder.Append("Password").Append(index);
                string password = builder.ToString();
                list.Add(new UserInfo(user, password));
            }

            long time = DateTimeOffset.Now.ToUnixTimeMilliseconds() - antes;

            builder = new StringBuilder();
            builder.Append("[OK]Tamanho: ").Append(tamanho).Append("\n");
            builder.Append("[OK]Tempo: ").Append(time).Append(" ms");

            Console.WriteLine(builder.ToString());
        }

        /// <summary>
        /// Método para captura e tratamento dos parametros obtidos via console
        /// </summary>
        /// <param name="args">Lista de parametros iniciais</param>
        private static int prepareArgs(string[] codes) {
            if(codes.Length != 1) {
                Console.WriteLine("Parametros inválidos.");
                Environment.Exit(-1);
            }

            int line = int.Parse(codes[0]);

            if(line <= 0) {
                Console.WriteLine("Quantidade de linhas menor que 1.");
                Environment.Exit(-1);
            }

            return line;
        }
    }
}
