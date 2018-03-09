using System.Collections.Generic;
using System.IO;
using System;

namespace inputclass.src.model {
    public class Table {      

        public string fileName { get; }

        public List<UserInfo> userInfoList { get; }

        public Table (string fileName) {
            this.fileName = fileName;
            this.userInfoList = this.deserializeFile(this.fileName);
        }

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