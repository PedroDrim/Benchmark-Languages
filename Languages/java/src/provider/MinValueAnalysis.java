package provider;

import model.SimpleTableAnalysis;
import model.UserInfo;

import java.util.List;

/**
 * Classe de analise que implementa a interface "SimpleTableAnalysis"
 */
public class MinValueAnalysis implements SimpleTableAnalysis {

    /**
     * Método de interface, responsável por obter o menor valor de credit em uma lista de usuarios
     * @param userInfoList Lista de usuarios
     * @return menor valor de credit
     */
    @Override
    public double analysis(List<UserInfo> userInfoList) {
        double min = Double.MAX_VALUE;
        for(UserInfo userInfo : userInfoList){
            double credit = userInfo.getCredit();
            if(min > credit) min = credit;
        }
        return min;
    }
}

