// Informacoes do usuario
export class UserInfo {
     
    private user: string;
    private password: string;
    private credit: number;

    // Construtor publico da classe
    // @param user Nome do usuario
    // @param credit Credito do usuario
    // @param password Senha do usuario    
    constructor(user: string, password: string, credit: number){
        this.user = user;
        this.password = password;
        this.credit = credit;
    }

    // Obtem o nome do usuario
    // @return Nome do usuario
    public getUser(): string{
        return(this.user);
    }

    // Obtem o credito do usuario
    // @return Credito do usuario
    public getCredit(): number{
        return(this.credit);
    }

    // Obtem a senha criptografada do usuario
    // @return Senha criptografada do usuario
    public getPassword(): string{
        return(this.cryptPassword(this.password));
    }

    // Altera o nome do usuario
    // @param user Novo nome do usuario
    public setUser(user: string) {
        this.user = user;
    }

    // Altera o credito do usuario
    // @param credit Novo credito do usuario
    public setCredit(credit: number){
        this.credit = credit;
    }

    // Altera a senha do usuario
    // @param password Nova senha do usuario
    public setPassword(password: string) {
        this.password = this.password;
    }

    // Metodo privado para encriptar a senha do usuario
    // @param password Senha a ser encriptada
    // @return Nova senha encriptada
    private cryptPassword(password: string): string {
        return password.split("").reverse().join("");
    }
}