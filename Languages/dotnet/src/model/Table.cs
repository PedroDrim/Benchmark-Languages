using System.Collections.Generic;
using System.IO;
using System;

namespace inputclass.src.model {

    /// <summary>
    /// Criando uma classe "Table"
    /// </summary>
    public class Table {      

        /// <summary>
        /// Variável privada para o nome do arquivo
        /// </summary>
        private string _fileName;

        /// <summary>
        /// Variável privada para a lista de usuarios
        /// </summary>
        private List<UserInfo> _userInfoList;

        /// <summary>
        /// Variável publica para o nome do arquivo
        /// </summary>
        public string fileName {

            /// <summary>
            /// Obtem o nome do arquivo
            /// </summary>
            /// <returns>Nome do arquivo</returns>
            get {
                return this._fileName;
            }
        }

        /// <summary>
        /// Variável publica para a lista de usuarios
        /// </summary>
        public List<UserInfo> userInfoList {

            /// <summary>
            /// Obtem o a lista de usuarios
            /// </summary>
            /// <returns>Lista de usuarios</returns>
            get {
                return this._userInfoList;
            }

        }

        /// <summary>
        /// Construtor publico da classe
        /// </summary>
        /// <param name="fileName">Nome do arquivo</param>
        public Table (string fileName) {
            this._fileName = fileName;
            this._userInfoList = this.deserializeFile(this.fileName);
        }

        /// <summary>
        /// Método privado para conversão do arquivo .csv em uma lista de "UserInfo"
        /// </summary>
        /// <param name="fileName">Nome do arquivo</param>
        /// <returns>Lista convertida de usuarios</returns>
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
