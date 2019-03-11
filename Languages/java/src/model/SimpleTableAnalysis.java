package model;

import java.util.List;

/**
 * Interface para analise de uma lista de usuarios
 */
public interface SimpleTableAnalysis {

    /**
     * Método de interface, responsável por realizar uma analise em uma lista de usuarios
     * @param userInfoList Lista de usuarios
     * @return resultado da analise
     */
    double analysis(List<UserInfo> userInfoList);
}
