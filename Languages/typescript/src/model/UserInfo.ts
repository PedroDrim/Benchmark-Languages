/**
 * Informacoes do usuario
 */
export class UserInfo {
     
    /**
     * Nome do usuario
     */
    private user: string;
    
    /**
     * Senha do usuario
     */
    private password: string;

    /**
     * Construtor público da classe
     * @param user Nome do usuario
     * @param password Senha do usuario
     */
    constructor(user: string, password: string){
        this.user = user;
        this.password = password;
    }

    /**
     * Obtem o nome do usuario
     * @return Nome do usuario
     */
    public getUser(): string{
        return(this.user);
    }

    /**
     * Obtem a senha do usuario criptografada
     * @return Senha do usuario criptografada
     */
    public getPassword(): string{
        return(this.cryptPassword(this.password));
    }

    /**
     * Atualiza o nome do usuario
     * @param user Novo nome do usuario
     */
    public setUser(user: string) {
        this.user = user;
    }

    /**
     * Atualiza a senha do usuario
     * @param password Nova senha do usuario
     */
    public setPassword(password: string) {
        this.password = this.password;
    }

    /**
     * Metodo privado para encriptar a senha do usuario
     * @param password Senha a ser encriptada
     * @return Nova senha encriptada
     */
    private cryptPassword(password: string): string {
        return password.split("").reverse().join("");
    }
}