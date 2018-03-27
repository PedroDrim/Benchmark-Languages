using experimento.src.model.exception;

namespace experimento.src.model {

    /// <summary>
    /// Informacoes do usuario
    /// </summary>
    public class UserInfo {
        
        private string _password;

        /// <summary>
        /// Nome do usuario
        /// </summary>
        /// <returns>Nome do usuario</returns>
        public string user {get; set;}
        
        /// <summary>
        /// Quantidade de creditos do usuario
        /// </summary>
        /// <returns>Quantidade de creditos do usuario</returns>
        public double credit {get; set;}

        /// <summary>
        /// Construtor publico da classe
        /// </summary>
        /// <param name="user">Nome do usuario</param>
        /// <param name="password">Senha do usuario</param>
        /// <param name="credit">Quantidade de creditos do usuario</param>
        public UserInfo(string user, string password, double credit) {
            if(user == null) throw new InvalidParameterException("'user' e null");
            if(password == null) throw new InvalidParameterException("'password' e null");

            this.user = user;
            this._password = password;
            this.credit = credit;
        }

        /// <summary>
        /// Senha do usuario
        /// </summary>
        /// <returns>Senha do usuario criptografada</returns>
        public string password {
            get {
                return cryptPassword(this._password);
            }

            set {
                if(value == null) throw new InvalidParameterException("'password' e null");
                this._password = value;
            }
        }

        /// <summary>
        /// Metodo privado para encriptar a senha do usuario
        /// </summary>
        /// <param name="password">Senha a ser encriptada</param>
        /// <returns>Nova senha encriptada</returns>
        private string cryptPassword(string password){
            if(password == null) throw new InvalidParameterException("'password' e null");

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