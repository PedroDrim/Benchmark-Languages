// Importando bibliotecas
using System.Collections.Generic;

// Definindo "package" da aplicação
namespace inputclass.src.model {
    // Criando uma interface "SimpleTableAnalysis"
    public interface SimpleTableAnalysis {      
        // Método de interface, responsável por realizar a análise na lista de "UserInfo"
        // list: List<UserInfo> -> Lista de "UserInfo"
        // RETURN: double -> valor da análise
        double analysis(List<UserInfo> list);
    }
}