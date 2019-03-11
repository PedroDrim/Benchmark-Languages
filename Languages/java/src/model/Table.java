package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe para gerenciar uma tabela de usuarios
 */
public class Table {

    /**
     * Nome do arquivo .csv
     */
    private String fileName;

    /**
     * Lista de usuarios
     */
    private List<UserInfo> userInfoList;

    /**
     * Construtor publico da classe
     * @param fileName Nome do arquivo .csv
     * @throws IOException
     */
    public Table(String fileName) throws IOException {
        this.fileName = fileName;
        this.userInfoList = this.deserializeFile(this.fileName);
    }

    /**
     * metodo publico para obter o nome do arquivo
     * @return Nome do arquivo de usuarios
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * metodo publico para obter a lista de usuarios
     * @return Lista de usuarios
     */
    public List<UserInfo> getUserInfoList() {
        return userInfoList;
    }

    /**
     * Método privado para conversão do arquivo .csv em uma lista de usuarios
     * @param fileName Nome do arquivo
     * @return Lista convertida de usuarios
     * @throws IOException
     */
    private List<UserInfo> deserializeFile(String fileName) throws IOException {

        List<UserInfo> list = new ArrayList<>();

        Reader reader = new FileReader(fileName);
        BufferedReader bufferedReader = new BufferedReader(reader);
        bufferedReader.readLine();

        String line;
        while ((line = bufferedReader.readLine()) != null) {
            String[] values = line.split(",");

            String user = values[0].trim();
            String password = values[1].trim();
            double credit = Double.valueOf(values[2].trim());

            UserInfo userInfo = new UserInfo(user, password, credit);
            list.add(userInfo);
        }

        bufferedReader.close();
        reader.close();

        return list;
    }
}
