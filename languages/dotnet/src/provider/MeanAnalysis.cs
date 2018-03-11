// Importando bibliotecas
using inputclass.src.model;
using System.Collections.Generic;

// Definindo "package" da aplicação
namespace inputclass.src.provider {
    // Criando uma classe "MeanAnalysis" que implementa a interface "SimpleTableAnalysis"
    public class MeanAnalysis : SimpleTableAnalysis {
        // Método de interface, responsável por realizar a análise na lista de "UserInfo"
        // list: List<UserInfo> -> Lista de "UserInfo"
        // RETURN: double -> média dos valores da lista
        public double analysis(List<UserInfo> list) {

            double sum = 0;
            foreach(UserInfo userInfo in list) {
                sum += userInfo.credit;
            }

            return sum/list.Count;
        }
    }
}