// Importando bibliotecas
using inputclass.src.model;
using System.Collections.Generic;

// Definindo "package" da aplicação
namespace inputclass.src.provider {
    // Criando uma classe "MinValueAnalysis" que implementa a interface "SimpleTableAnalysis"
    public class MinValueAnalysis : SimpleTableAnalysis {
        // Método de interface, responsável por realizar a análise na lista de "UserInfo"
        // list: List<UserInfo> -> Lista de "UserInfo"
        // RETURN: double -> valor minimo da lista
        public double analysis(List<UserInfo> list) {

            double min = double.MaxValue;
            foreach(UserInfo userInfo in list) {
                if(min > userInfo.credit) min = userInfo.credit;
            }

            return min;
        }
    }
}