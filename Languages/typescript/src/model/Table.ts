import { UserInfo } from "./UserInfo";
import  fs = require('fs');

// Classe para gerenciar uma tabela de usuarios
export class Table {

    // Variavel privada do nome do arquivo
    private fileName: string
    // Variavel privada da lista de usuarios
    private userInfoList: Array<UserInfo>

    // Construtor publico da classe
    // @param fileName Nome do arquivo .csv
    constructor(fileName: string){
        this.fileName = fileName;
        this.userInfoList = this.deserializeFile(this.fileName);
    }

    // Metodo publico para obter o nome do arquivo
    // @return Nome do arquivo .csv
    public getFileName(): string {
        return this.fileName;
    }

    // Metodo publico para obter a lista de usuarios
    // @return Lista de usuarios
    public getUserInfoList(): Array<UserInfo> {
        return this.userInfoList;
    } 

    // Método privado para conversão do arquivo .csv em uma lista de usuarios
    // @param fileName Nome do arquivo
    // @return Lista convertida de usuarios    
    private deserializeFile(fileName: string): Array<UserInfo> {
        
        var list = new Array<UserInfo>()
        var lines = fs.readFileSync(fileName,'utf8')

        var first = true

        lines.split("\n").forEach(line => {

            if((!first) && (line.trim() != "")){
                let values = line.split(",");

                let user = values[0].trim();
                let password = values[1].trim();
                let credit: number = Number(values[2].trim());

                let userInfo: UserInfo = new UserInfo(user, password, credit);
                list.push(userInfo);
            }else {
                first = false
            }
        });
        
        return list;        
    }
}