namespace inputclass.src.model {

    public class UserInfo {
        private string _user;
        private string _password;
        private double _credit;
        
        public UserInfo(string user, string password, double credit) {
            this._user = user;
            this._password = password;
            this._credit = credit;
        }

        public string user {
            get {
                return this._user;
            }

            set {
                this._user = value;
            }
        }

        public double credit {
            get {
                return this._credit;
            }

            set {
                this._credit = value;
            }
        }

        public string password {
            get {
                return this._password;
            }

            set {
                this._password = value;
            }
        }

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