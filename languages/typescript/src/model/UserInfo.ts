import {InvalidParameterException} from './exception/InvalidParameterException'

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
     * Quantidade de creditos do usuario
     */
    private credit: number;

    /**
     * Construtor publico da classe
     * @param user Nome do usuario
     * @param password Senha do usuario
     * @param credit Quantidade de creditos do usuario
     */

    constructor(user: string, password: string, credit: number) {

        if(user == null) throw new InvalidParameterException("'user' é null");
        if(password == null) throw new InvalidParameterException("'password' é null");

        this.user = user;
        this.password = password;
        this.credit = credit;
    }

    /**
     * Obtem o nome do usuario
     * @return Nome do usuario
     */
    public getUser(): string {
        return this.user;
    }

    /**
     * Atualiza o nome do usuario
     * @param user Novo nome do usuario
     */
    public setUser(user: string): void {
        if(user == null) throw new InvalidParameterException("'user' é null");
        this.user = user;
    }

    /**
     * Obtem a senha do usuario criptografada
     * @return Senha do usuario criptografada
     */
    public getPassword(): string {
        return this.cryptPassword(this.password);
    }

    /**
     * Atualiza a senha do usuario
     * @param password Nova senha do usuario
     */
    public setPassword(password: string): void {
        if(password == null) throw new InvalidParameterException("'password' é null");
        this.password = password;
    }

    /**
     * Obtem a quantidade de creditos do usuario
     * @return Quantidade de creditos do usuario
     */
    public getCredit(): number {
        return this.credit;
    }

    /**
     * Atualiza a quantidade de creditos do usuario
     * @param credit Nova quantidade de creditos do usuario
     */
    public setCredit(credit: number): void {
        this.credit = credit;
    }

    /**
     * Metodo privado para encriptar a senha do usuario
     * @param password Senha a ser encriptada
     * @return Nova senha encriptada
     */
    private cryptPassword(password: string): string{
        if(password == null) throw new InvalidParameterException("'password' é null");
        return password.split("").reverse().join("");
    }
}
