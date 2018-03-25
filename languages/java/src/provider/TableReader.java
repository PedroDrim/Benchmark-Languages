package provider;

import model.DataReader;
import model.UserInfo;
import model.exception.DataReaderException;
import model.exception.InvalidParameterException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe responsavel por ler e disponibilizar os dados em um formato desejado
 * @see model.DataReader
 */
public class TableReader implements DataReader {

    /**
     * Nome do arquivo de dados
     */
    private String fileName;

    /**
     * Lista contendo os dados
     */
    private List<UserInfo> userInfoList;

    /**
     * Construtor publico da classe
     * @param fileName Nome do arquivo de dados a ser lido
     * @throws DataReaderException Lancada caso nao seja possivel ler os dados corretamente
     */
    public TableReader(String fileName) throws DataReaderException {
        if(fileName == null) throw new InvalidParameterException("'fileName' é null");

        this.fileName = fileName;
        this.userInfoList = this.deserializeFile(this.fileName);
    }

    /**
     * Obtem o nome do arquivo de dados a ser lido
     * @return Nome do arquivo de dados a ser lido
     */
    public String getFileName() {
        return fileName;
    }

    /**
     * Obtem todos os dados disponiveis
     * @return Lista contendo todos os dados disponiveis
     */
    @Override
    public List<UserInfo> read() {
        return this.userInfoList;
    }

    /**
     * Obtem os dados disponiveis dentro de um intervalo
     * @param startIndex Inicio do intervalo
     * @param endIndex Fim do intervalo
     * @return Lista contendo todos os dados disponiveis dentro do intervalo especificado
     */
    @Override
    public List<UserInfo> read(int startIndex, int endIndex) {
        if(startIndex < 0) throw new InvalidParameterException("'startIndex' é menor que 0");
        if(endIndex < 0) throw new InvalidParameterException("'endIndex' é menor que 0");
        if(startIndex >= endIndex) throw new InvalidParameterException("'startIndex' é maior ou igual á 'endIndex'");

        return this.userInfoList.subList(startIndex, endIndex);
    }

    /**
     * Desserializa o arquivo de dados, convertendo-o em uma lista de 'UserInfo'
     * @param fileName Nome do arquivo de dados
     * @return Lista contendo os dados desserilizados
     * @throws DataReaderException Lancada caso nao seja possivel ler os dados corretamente
     */
    private List<UserInfo> deserializeFile(String fileName) throws DataReaderException {
        if(fileName == null) throw new InvalidParameterException("'fileName' é null");

        List<UserInfo> list = new ArrayList<>();

        try {

            Reader reader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(reader);
            bufferedReader.readLine();

            String line;
            while ((line = bufferedReader.readLine()) != null) {

                UserInfo userInfo = this.convertLine(line);
                list.add(userInfo);
            }

            bufferedReader.close();
            reader.close();

        } catch(IOException e) {
            throw new DataReaderException("Erro ao ler arquivo:" + fileName);
        }

        return list;
    }

    /**
     * Converte a linha em um 'UserInfo'
     * @param line Linha a ser desserializada
     * @return Objeto 'UserInfo'
     */
    private UserInfo convertLine(String line) {
        if(line == null) throw new InvalidParameterException("'line' é null");

        String[] values = line.split(",");

        String user = values[0].trim();
        String password = values[1].trim();
        double credit = Double.valueOf(values[2].trim());

        UserInfo userInfo = new UserInfo(user, password, credit);
        return userInfo;
    }

}
