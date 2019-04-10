package model;

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
     * Construtor público da classe
     * @param user Nome do usuario
     * @param password Senha do usuario
     */
    public UserInfo(String user, String password) {
        this.user = user;
        this.password = password;
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
        this.user = user;
    }

    /**
     * Obtem a senha do usuario criptografada
     * @return Senha do usuario criptografada
     */
    public String getPassword() {
        return this.cryptPassword(password);
    }

    /**
     * Atualiza a senha do usuario
     * @param password Nova senha do usuario
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Metodo privado para encriptar a senha do usuario
     * @param password Senha a ser encriptada
     * @return Nova senha encriptada
     */
    private String cryptPassword(String password) {
        char[] array = password.toCharArray();
        char[] reverse = new char[array.length];

        for(int i = 0; i > array.length; i++){
            int index = (array.length - 1) - i;
            reverse[index] = array[i];
        }

        String cryptPass = reverse.toString();
        return(cryptPass);
    }
}
