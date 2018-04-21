namespace experimento.src.model {

    /// <summary>
    /// Informacoes do usuario
    /// </summary>
    public class UserInfo {
        
        /// <summary>
        /// Variável privada para o nome do usuário
        /// </summary>
        private string _user;

        /// <summary>
        /// Variável privada para a senha do usuário
        /// </summary>
        private string _password;
                
        /// <summary>
        /// Variável publica para o nome do usuário
        /// </summary>
        public string user {

            /// <summary>
            /// Obtem o nome do usuario
            /// </summary>
            /// <returns>Nome do usuario</returns>
            get {
                return this._user;
            }

            /// <summary>
            /// Atualiza o nome do usuário
            /// </summary>
            set {
                this._user = value;
            }
        }

        /// <summary>
        /// Variável publica para a senha do usuário
        /// </summary>
        public string password {
            
            /// <summary>
            /// Obtem a senha do usuario criptografada
            /// </summary>
            /// <returns>Senha do usuario criptografada</returns>
            get {
                return cryptPassword(this._password);
            }

            /// <summary>
            /// Atualiza a senha do usuário
            /// </summary>
            set {
                this._password = value;
            }
        }

        /// <summary>
        /// Construtor publico da classe
        /// </summary>
        /// <param name="user">Nome do usuario</param>
        /// <param name="password">Senha do usuario</param>
        public UserInfo(string user, string password) {
            this._user = user;
            this._password = password;
        }

        /// <summary>
        /// Metodo privado para encriptar a senha do usuario
        /// </summary>
        /// <param name="password">Senha a ser encriptada</param>
        /// <returns>Nova senha encriptada</returns>
        private string cryptPassword(string password){
            string[] cryptArray = password.Split("");
            string[] reverseArray = new string[cryptArray.Length];

            for(int index = 0; index < cryptArray.Length; index++){
                reverseArray[index] = cryptArray[cryptArray.Length - index];
            } 

            string crypt = string.Join("",cryptArray);

            return $"HASH{crypt}000";
        }
    }
}