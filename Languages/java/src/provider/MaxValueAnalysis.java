package provider;

import model.SimpleTableAnalysis;
import model.UserInfo;

import java.util.List;

/**
 * Classe de analise que implementa a interface "SimpleTableAnalysis"
 */
public class MaxValueAnalysis implements SimpleTableAnalysis {

    /**
     * Método de interface, responsável por obter o maior valor de credit em uma lista de usuarios
     * @param userInfoList Lista de usuarios
     * @return maior valor de credit
     */
    @Override
    public double analysis(List<UserInfo> userInfoList) {

        double max = Double.MIN_VALUE;
        for(UserInfo userInfo : userInfoList){
            double credit = userInfo.getCredit();
            if(max < credit) max = credit;
        }
        return max;
    }
}

