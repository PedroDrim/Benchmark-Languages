package provider;

import model.TableAnalysis;
import model.UserInfo;
import model.exception.InvalidParameterException;

import java.util.List;

/**
 * Classe para analise de dados, obtem os valores maximo e minimo dos creditos dos usuarios
 * @see model.TableAnalysis
 */
public class SummaryAnalysis implements TableAnalysis<double[]> {

    /**
     * Realiza a analise maxima e minima dos dados
     * @param userInfoList Lista de dados a ser analisada
     * @return Valores maximo e minimo dos creditos
     * @see TableAnalysis
     */
    @Override
    public double[] analysis(List<UserInfo> userInfoList) {
        if(userInfoList == null || userInfoList.isEmpty())
            throw new InvalidParameterException("'userInfoList' é null ou vazio");

        double max = Double.MIN_VALUE;
        double min = Double.MAX_VALUE;
        double sum = 0;

        for(UserInfo userInfo : userInfoList){
            double credit = userInfo.getCredit();
            sum += credit;
            if(max < credit) max = credit;
            if(min > credit) min = credit;
        }

        double mean = sum/userInfoList.size();
        return new double[]{min, max, mean};
    }
}

