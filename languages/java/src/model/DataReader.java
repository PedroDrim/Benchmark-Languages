package model;

import java.util.List;

/**
 * Interface para leitura de dados
 */
public interface DataReader {

    /**
     * Obtem todos os dados disponiveis
     * @return Lista contendo todos os dados disponiveis
     */
    List<UserInfo> read();

    /**
     * Obtem os dados disponiveis dentro de um intervalo
     * @param startIndex Inicio do intervalo
     * @param endIndex Fim do intervalo
     * @return Lista contendo todos os dados disponiveis dentro do intervalo especificado
     */
    List<UserInfo> read(int startIndex, int endIndex);
}
