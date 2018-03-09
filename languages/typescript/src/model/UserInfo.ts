export class UserInfo {
     
    private user: string;
    private password: string;
    private credit: number;

    constructor(user: string, password: string, credit: number){
        this.user = user;
        this.password = password;
        this.credit = credit;
    }

    public getUser(): string{
        return(this.user);
    }

    public getCredit(): number{
        return(this.credit);
    }

    public getPassword(): string{
        return(this.cryptPassword(this.password));
    }

    public setUser(user: string) {
        this.user = user;
    }

    public setCredit(credit: number){
        this.credit = credit;
    }

    public setPassword(password: string) {
        this.password = this.password;
    }

    private cryptPassword(password: string): string {
        return password.split("").reverse().join("");
    }
}