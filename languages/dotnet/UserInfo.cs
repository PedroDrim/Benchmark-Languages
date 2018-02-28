namespace simpleclass {
    public class UserInfo {

        private string _user;
        private string _password;
        
        public string user {
            get {
                return this._user;
            }

            set {
                this._user = value;
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

        public UserInfo(string user, string password) {
            this.user = user;
            this.password = password;
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