package provider;

import model.TableAnalysis;
import model.UserInfo;
import model.exception.InvalidParameterException;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Classe para analise de dados, obtem um usuario aleatoriamente
 * @see TableAnalysis
 */
public class LanguageSortAnalysis implements TableAnalysis<List<UserInfo>> {

    /**
     * Realiza uma analise aleatoria dos dados
     * @param userInfoList Lista de dados a ser analisada
     * @return Elemento aleatorio da lista
     * @see TableAnalysis
     */
    @Override
    public List<UserInfo> analysis(List<UserInfo> userInfoList) {
        if(userInfoList.equals(null) || userInfoList.isEmpty())
            throw new InvalidParameterException("'userInfoList' é null ou vazio");

        Collections.sort(userInfoList, userInfoComparator());

        return userInfoList;
    }

    /**
     * Obtem um comparador de 'userInfo'
     * @return Um comparador de 'userInfo'
     */
    private Comparator<UserInfo> userInfoComparator() {

        Comparator<UserInfo> comparator = new Comparator<>() {

            /**
             * Compara dois userInfo com base no credito disponivel
             * @param userInfo1 Primeiro 'userInfo'
             * @param userInfo2 Segundo 'userInfo'
             * @return
             */
            @Override
            public int compare(UserInfo userInfo1, UserInfo userInfo2) {
                if(userInfo1.equals(null)) throw new InvalidParameterException("'userInfo1' é null");
                if(userInfo2.equals(null)) throw new InvalidParameterException("'userInfo2' é null");

                Double credit1 = userInfo1.getCredit();
                Double credit2 = userInfo2.getCredit();
                return credit1.compareTo(credit2);
            }

        };

        return comparator;
    }
}
