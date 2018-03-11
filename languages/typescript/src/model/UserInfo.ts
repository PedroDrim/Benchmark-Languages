// Criando uma classe "UserInfo"
export class UserInfo {
     
    private user: string;
    private password: string;
    private credit: number;

    // Construtor da classe
    // user: string -> nome do usuário
    // password: string -> senha da conta
    // credit: double -> creditos da conta
    constructor(user: string, password: string, credit: number){
        this.user = user;
        this.password = password;
        this.credit = credit;
    }

    // Método getter de "user"
    public getUser(): string{
        return(this.user);
    }

    // Método getter de "credit"
    public getCredit(): number{
        return(this.credit);
    }

    // Método getter customizado de "password"
    public getPassword(): string{
        return(this.cryptPassword(this.password));
    }

    // Método setter de "user"
    public setUser(user: string) {
        this.user = user;
    }

    // Método setter de "credit"
    public setCredit(credit: number){
        this.credit = credit;
    }

    // Método setter de "password"
    public setPassword(password: string) {
        this.password = this.password;
    }

    // Método privado para encriptar senhas
    // password: string -> senha a ser encriptada
    // RETURN: string -> nova senha    
    private cryptPassword(password: string): string {
        return password.split("").reverse().join("");
    }
}