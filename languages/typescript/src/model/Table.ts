import { UserInfo } from "./UserInfo";
import  fs = require('fs');

export class Table {

    private fileName: string
    private userInfoList: Array<UserInfo>

    constructor(fileName: string){
        this.fileName = fileName;
        this.userInfoList = this.deserializeFile(this.fileName);
    }

    public getFileName(): string {
        return this.fileName;
    }

    public getUserInfoList(): Array<UserInfo> {
        return this.userInfoList;
    } 

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