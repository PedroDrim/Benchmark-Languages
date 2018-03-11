// Importando bibliotecas
import { UserInfo } from "./UserInfo";
import  fs = require('fs');

// Criando uma classe "Table"
export class Table {

    private fileName: string
    private userInfoList: Array<UserInfo>

    // Construtor publico da classe
    // fileName: string -> Nome do arquivo .csv
    constructor(fileName: string){
        this.fileName = fileName;
        this.userInfoList = this.deserializeFile(this.fileName);
    }

    // Método getter de "FileName"
    public getFileName(): string {
        return this.fileName;
    }

    // Método getter de "UserInfoList"
    public getUserInfoList(): Array<UserInfo> {
        return this.userInfoList;
    } 

    // Método privado para conversão do arquivo .csv em uma lista de "UserInfo"
    // fileName: string -> Nome do arquivo
    // RETURN: List<UserInfo> -> Lista convertida de "UserInfo"
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