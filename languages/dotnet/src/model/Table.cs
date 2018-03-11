// Importando bibliotecas
using System.Collections.Generic;
using System.IO;
using System;

// Definindo "package" da aplicação
namespace inputclass.src.model {
    // Criando uma classe "Table"
    public class Table {      
        // Nome do arquivo com método getter
        public string fileName { get; }
        // Lista de "UserInfo" com método getter
        public List<UserInfo> userInfoList { get; }
        // Construtor publico da classe
        // fileName: string -> Nome do arquivo .csv
        public Table (string fileName) {
            this.fileName = fileName;
            this.userInfoList = this.deserializeFile(this.fileName);
        }
        // Método privado para conversão do arquivo .csv em uma lista de "UserInfo"
        // fileName: string -> Nome do arquivo
        // RETURN: List<UserInfo> -> Lista convertida de "UserInfo"
        private List<UserInfo> deserializeFile (string fileName) {

            List<UserInfo> userInfoList = new List<UserInfo>();

            StreamReader file = new StreamReader(fileName);  
            string line = file.ReadLine();
            while((line = file.ReadLine()) != null) {  
                string[] values = line.Split(",");

                string user = values[0].Trim();
                string password = values[1].Trim();

                double credit = Double.Parse(values[2].Trim(),
                    System.Globalization.CultureInfo.InvariantCulture
                );
                
                UserInfo userInfo = new UserInfo(user, password, credit);
                userInfoList.Add(userInfo);
            }  
            file.Close();  

            return userInfoList;
        }
    }
}