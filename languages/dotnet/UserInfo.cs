// Definindo "package" da aplicação
namespace simpleclass {
    // Criando uma classe "UserInfo"
    public class UserInfo {
        // Definindo string privada '_user'
        private string _user;
        // Definindo string privada '_password'
        private string _password;
        
        // Definindo métodos de acesso (getter's e setter's) para a variável pública 'user'
        public string user {
            // instance.user, para getter
            get {
                return this._user;
            }

            // instance.user = valor, para setter
            set {
                this._user = value;
            }
        }

        // Definindo métodos de acesso (getter's e setter's) para a variável pública 'password' 
        public string password {
            // instance.password, para getter
            get {
                // Método getter customizado
                return cryptPassword(this._password);
            }

            // instance.password = valor, para setter
            set {
                this._password = value;
            }
        }

        // Definindo construtor público da classe
        // user: String -> nome do usuário
        // password: String -> senha do usuário
        public UserInfo(string user, string password) {
            this._user = user;
            this._password = password;
        }

        // Método privado para encriptar a variável 'password'
        // password: String -> senha do usuário
        // RETURN: String -> senha encriptada
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