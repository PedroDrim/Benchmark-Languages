// Criando uma classe "UserInfo"
export class UserInfo {
     
    // Definindo string privada "user"
    private user: string;
    // Definindo string privada "password"
    private password: string;

    // Definindo construtor público da classe
    // user: string -> nome do usuário
    // password: string -> senha do usuário    
    constructor(user: string, password: string){
        this.user = user;
        this.password = password;
    }

    // Método getter da variável 'user'
    // instance.getUser(), para getter
    public getUser(): string{
        return(this.user);
    }

    // Método getter customizado da variável 'password'
    // instance.getPassword(), para getter    
    public getPassword(): string{
        return(this.cryptPassword(this.password));
    }

    // instance.setUser(valor), para setter
    // valor: string -> novo user    
    public setUser(user: string) {
        this.user = user;
    }

    // instance.setPassword(valor), para setter
    // valor: string -> novo password    
    public setPassword(password: string) {
        this.password = this.password;
    }

    // Método privado para encriptar a variável 'password'
    // password: string -> senha do usuário
    // RETURN: string -> senha encriptada    
    private cryptPassword(password: string): string {
        return password.split("").reverse().join("");
    }
}