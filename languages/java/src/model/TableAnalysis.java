package model;

import java.util.List;

/**
 * Interface para analise dos dados
 * @param <T> Tipo de classe do resultado
 */
public interface TableAnalysis<T> {

    /**
     * Realiza a analise dos dados
     * @param userInfoList Lista de dados a ser analisada
     * @return Resultado da analise
     */
    T analysis(List<UserInfo> userInfoList);
}
