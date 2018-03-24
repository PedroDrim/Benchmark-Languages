package provider;

import model.TableAnalysis;
import model.UserInfo;
import model.exception.InvalidParameterException;

import java.util.List;
import java.util.Random;

/**
 * Classe para ordenacao bubbleSort
 * @see model.TableAnalysis
 */
public class BubbleSortAnalysis implements TableAnalysis<List<UserInfo>> {

    /**
     * Realiza uma ordenacao bubbleSort
     * @param userInfoList Lista de dados a ser analisada
     * @return Elemento aleatorio da lista
     * @see TableAnalysis
     */
    @Override
    public List<UserInfo> analysis(List<UserInfo> userInfoList) {
        if(userInfoList.equals(null) || userInfoList.isEmpty())
            throw new InvalidParameterException("'userInfoList' é null ou vazio");

        UserInfo[] arrayUserInfo = new UserInfo[userInfoList.size()];
        arrayUserInfo = userInfoList.toArray(arrayUserInfo);

        UserInfo aux;
        int size = arrayUserInfo.length;

        for(int index1 = 0; index1 < size; index1++) {
            for(int index2 = 1; index2 < (size - index1); index2++) {

                UserInfo user1 = arrayUserInfo[index2];
                UserInfo user2 = arrayUserInfo[index2 - 1];

                if(user1.getCredit() > user2.getCredit()) {
                    aux = user1;
                    user1 = user2;
                    user2 = aux;

                    arrayUserInfo[index2] = user1;
                    arrayUserInfo[index2 - 1] = user2;
                }
            }
        }

        return List.of(arrayUserInfo);
    }
}
