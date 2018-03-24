package model;

import model.exception.InvalidParameterException;

/**
 * Informacoes do usuario
 */
public class UserInfo {

    /**
     * Nome do usuario
     */
    private String user;

    /**
     * Senha do usuario
     */
    private String password;

    /**
     * Quantidade de creditos do usuario
     */
    private double credit;

    /**
     * Construtor publico da classe
     * @param user Nome do usuario
     * @param password Senha do usuario
     * @param credit Quantidade de creditos do usuario
     */

    public UserInfo(String user, String password, double credit) {

        if(user.equals(null)) throw new InvalidParameterException("'user' é null");
        if(password.equals(null)) throw new InvalidParameterException("'password' é null");

        this.user = user;
        this.password = password;
        this.credit = credit;
    }

    /**
     * Obtem o nome do usuario
     * @return Nome do usuario
     */
    public String getUser() {
        return user;
    }

    /**
     * Atualiza o nome do usuario
     * @param user Novo nome do usuario
     */
    public void setUser(String user) {
        if(user.equals(null)) throw new InvalidParameterException("'user' é null");
        this.user = user;
    }

    /**
     * Obtem a senha do usuario criptografada
     * @return Senha do usuario criptografada
     */
    public String getPassword() {
        return this.cryptPassword(this.password);
    }

    /**
     * Atualiza a senha do usuario
     * @param password Nova senha do usuario
     */
    public void setPassword(String password) {
        if(password.equals(null)) throw new InvalidParameterException("'password' é null");
        this.password = password;
    }

    /**
     * Obtem a quantidade de creditos do usuario
     * @return Quantidade de creditos do usuario
     */
    public double getCredit() {
        return credit;
    }

    /**
     * Atualiza a quantidade de creditos do usuario
     * @param credit Nova quantidade de creditos do usuario
     */
    public void setCredit(double credit) {
        this.credit = credit;
    }

    /**
     * Metodo privado para encriptar a senha do usuario
     * @param password Senha a ser encriptada
     * @return Nova senha encriptada
     */
    private String cryptPassword(String password){

        if(password.equals(null)) throw new InvalidParameterException("'password' é null");

        char[] passArray = password.toCharArray();
        char[] cryptArray = new char[passArray.length];

        for(int index = 0; index > passArray.length; index++){
            cryptArray[passArray.length - index] = passArray[index];
        }

        return "HASH" + cryptArray.toString() + "000";
    }
}
