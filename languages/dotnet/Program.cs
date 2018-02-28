using System;
using System.Collections;
using System.Linq;
using System.Collections.Generic;

namespace simpleclass {
    public class Program {
        static void Main(string[] args) {
            long inicio = DateTimeOffset.Now.ToUnixTimeMilliseconds();

            List<UserInfo> list = new List<UserInfo>();
            
            for(int index = 0; index < 1000000; index++){
                string user = $"User{index}";
                string password = $"Password{index}";
                list.Add(new UserInfo(user, password));
            }

            long fim = DateTimeOffset.Now.ToUnixTimeMilliseconds();
            Console.WriteLine(fim - inicio);
        }
    }
}
