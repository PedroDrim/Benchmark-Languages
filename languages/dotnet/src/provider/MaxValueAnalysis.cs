// Importando bibliotecas
using System;
using inputclass.src.model;
using System.Collections.Generic;

// Definindo "package" da aplicação
namespace inputclass.src.provider {
    // Criando uma classe "MaxValueAnalysis" que implementa a interface "SimpleTableAnalysis"
    public class MaxValueAnalysis : SimpleTableAnalysis {
        // Método de interface, responsável por realizar a análise na lista de "UserInfo"
        // list: List<UserInfo> -> Lista de "UserInfo"
        // RETURN: double -> valor máximo da lista
        public double analysis(List<UserInfo> list) {

            double max = double.MinValue;
            foreach(UserInfo userInfo in list) {
                if(max < userInfo.credit) max = userInfo.credit;
            }

            return max;
        }
    }
}