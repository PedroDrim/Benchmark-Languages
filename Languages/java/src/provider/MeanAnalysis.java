package provider;

import model.SimpleTableAnalysis;
import model.UserInfo;

import java.util.List;

/**
 * Classe de analise que implementa a interface "SimpleTableAnalysis"
 */
public class MeanAnalysis implements SimpleTableAnalysis {

    /**
     * Método de interface, responsável por obter a media dos valores de credit em uma lista de usuarios
     * @param userInfoList Lista de usuarios
     * @return media de valores de credit
     */
    @Override
    public double analysis(List<UserInfo> userInfoList) {

        double sum = 0;
        for(UserInfo userInfo : userInfoList){
            sum += userInfo.getCredit();
        }
        return sum/userInfoList.size();
    }
}
