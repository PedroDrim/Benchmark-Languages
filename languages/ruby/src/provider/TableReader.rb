import { UserInfo } from "../model/UserInfo";
import {InvalidParameterException} from '../model/exception/InvalidParameterException'
import {DataReaderException} from '../model/exception/DataReaderException'
import {DataReader} from '../model/DataReader'

import fs = require('fs');

/**
 * Classe responsavel por ler e disponibilizar os dados em um formato desejado
 * @see model.DataReader
 */
export class TableReader implements DataReader {

    /**
     * Nome do arquivo de dados
     */
    private fileName: string;

    /**
     * Lista contendo os dados
     */
    private userInfoList: Array<UserInfo>;

    /**
     * Construtor publico da classe
     * @param fileName Nome do arquivo de dados a ser lido
     * @throws DataReaderException Lancada caso nao seja possivel ler os dados corretamente
     */
    constructor(fileName: string) {
        if(fileName == null) throw new InvalidParameterException("'fileName' é null");

        this.fileName = fileName;
        this.userInfoList = this.deserializeFile(this.fileName);
    }

    /**
     * Obtem o nome do arquivo de dados a ser lido
     * @return Nome do arquivo de dados a ser lido
     */
    public getFileName(): string {
        return this.fileName;
    }

    /**
     * Obtem todos os dados disponiveis
     * @return Lista contendo todos os dados disponiveis
     */
    public readAll(): Array<UserInfo> {
        return this.userInfoList;
    }

    /**
     * Obtem os dados disponiveis dentro de um intervalo
     * @param startIndex Inicio do intervalo
     * @param endIndex Fim do intervalo
     * @return Lista contendo todos os dados disponiveis dentro do intervalo especificado
     */
    public read(startIndex: number, endIndex: number): Array<UserInfo> {
        if(startIndex < 0) throw new InvalidParameterException("'startIndex' é menor que 0");
        if(endIndex < 0) throw new InvalidParameterException("'endIndex' é menor que 0");
        if(startIndex >= endIndex) throw new InvalidParameterException("'startIndex' é maior ou igual á 'endIndex'");

        return this.userInfoList.slice(startIndex, endIndex);
    }

    /**
     * Desserializa o arquivo de dados, convertendo-o em uma lista de 'UserInfo'
     * @param fileName Nome do arquivo de dados
     * @return Lista contendo os dados desserilizados
     * @throws DataReaderException Lancada caso nao seja possivel ler os dados corretamente
     */
    private deserializeFile(fileName: string): Array<UserInfo> {
        if(fileName == null) throw new InvalidParameterException("'fileName' é null");

        var list: Array<UserInfo> = new Array();
        var first: boolean = true;

        try {

            var file = fs.readFileSync(fileName, 'utf8');
            var lines: Array<String> = file.split("\n");

            for(let line of lines) {

                if( (!first) && (line.trim() != "") ) {
                    let userInfo: UserInfo = this.convertLine(line);
                    list.push(userInfo);
                } else {
                    first = false;
                }
            }                

        } catch(e) {
            throw new DataReaderException("Erro ao ler arquivo:" + fileName);
        }

        return list;
    }

    /**
     * Converte a linha em um 'UserInfo'
     * @param line Linha a ser desserializada
     * @return Objeto 'UserInfo'
     */
    private convertLine(line: String): UserInfo {
        if(line == null) throw new InvalidParameterException("'line' é null");

        let values: string[] = line.split(",");

        let user: string = values[0].trim();
        let password: string = values[1].trim();
        let credit: number = Number(values[2].trim());

        let userInfo: UserInfo = new UserInfo(user, password, credit);
        return userInfo;
    }

}
