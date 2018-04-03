using System.Collections.Generic;
using System.IO;
using System;
using experimento.src.model.exception;

namespace experimento.src.model {

    /// <summary>
    /// Classe responsavel por ler e disponibilizar os dados em um formato desejado
    /// </summary>
    public class TableReader : DataReader {      
        
        /// <summary>
        /// Nome do arquivo de dados
        /// </summary>
        /// <returns>Nome do arquivo de dados</returns>
        public string fileName { get; }

        /// <summary>
        /// Lista contendo os dados
        /// </summary>
        private List<UserInfo> userInfoList;
        
        /// <summary>
        /// Construtor publico da classe
        /// </summary>
        /// <param name="fileName">Nome do arquivo de dados a ser lido</param>
        public TableReader (string fileName) {
            if(fileName == null) throw new InvalidParameterException("'fileName' e null");

            this.fileName = fileName;
            this.userInfoList = this.deserializeFile(this.fileName);
        }

        /// <summary>
        /// Obtem todos os dados disponiveis
        /// </summary>
        /// <returns>Lista contendo todos os dados disponiveis</returns>
        public List<UserInfo> read() {
            return this.userInfoList;
        }

        /// <summary>
        /// Obtem os dados disponiveis dentro de um intervalo
        /// </summary>
        /// <param name="startIndex">Inicio do intervalo</param>
        /// <param name="endIndex">Fim do intervalo</param>
        /// <returns>Lista contendo todos os dados disponiveis dentro do intervalo especificado</returns>
        public List<UserInfo> read(int startIndex, int endIndex) {
            if(startIndex < 0) throw new InvalidParameterException("'startIndex' é menor que 0");
            if(endIndex < 0) throw new InvalidParameterException("'endIndex' é menor que 0");
            if(startIndex >= endIndex) throw new InvalidParameterException("'startIndex' é maior ou igual á 'endIndex'");

            return this.userInfoList.GetRange(startIndex, endIndex);
        }

        /// <summary>
        /// Desserializa o arquivo de dados, convertendo-o em uma lista de 'UserInfo'
        /// </summary>
        /// <param name="fileName">Nome do arquivo de dados</param>
        /// <returns>Lista contendo os dados desserilizados</returns>
        private List<UserInfo> deserializeFile (string fileName) {
            if(fileName == null) throw new InvalidParameterException("'fileName' e null");

            List<UserInfo> userInfoList = new List<UserInfo>();

            try {
                StreamReader file = new StreamReader(fileName);  
                string line = file.ReadLine();
                while((line = file.ReadLine()) != null) {  
                    UserInfo userInfo = this.convertLine(line);
                    userInfoList.Add(userInfo);
                }  
                file.Close();  
                
            }catch(FileNotFoundException e) {
                throw new DataReaderException("Erro ao abrir o arquivo " + fileName);
            } 

            return userInfoList;
        }

        /// <summary>
        /// Converte a linha em um 'UserInfo'
        /// </summary>
        /// <param name="line">line Linha a ser desserializada</param>
        /// <returns>Objeto 'UserInfo'</returns>
        private UserInfo convertLine(String line) {
            if(line == null) throw new InvalidParameterException("'line' e null");

            string[] values = line.Split(",");

            string user = values[0].Trim();
            string password = values[1].Trim();

            double credit = Double.Parse(values[2].Trim(),
                System.Globalization.CultureInfo.InvariantCulture
            );

            UserInfo userInfo = new UserInfo(user, password, credit);
            return userInfo;
        }
    }
}