// Definindo "package" da aplicação
namespace inputclass.src.model {
    // Criando uma classe "UserInfo"
    public class UserInfo {
        // Nome do usuario com métodos getter e setter
        private string user {get; set}
        // Variável privada para senha da conta
        private string _password;
        // credito da conta com métodos getter e setter
        private double credit {get; set}
        // Construtor da classe
        // user: string -> nome do usuário
        // password: string -> senha da conta
        // credit: double -> creditos da conta
        public UserInfo(string user, string password, double credit) {
            this.user = user;
            this._password = password;
            this.credit = credit;
        }
        // Metodos getter (customizado) e setter da senha da conta
        public string password {
            get {
                return cryptPassword(this._password);
            }

            set {
                this._password = value;
            }
        }
        // Método privado para encriptar senhas
        // password: string -> senha a ser encriptada
        // RETURN: string -> nova senha
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