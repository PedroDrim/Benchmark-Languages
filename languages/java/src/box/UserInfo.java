package box;

/**
 * Construção da classe "UserInfo"
 */
public class UserInfo {

    // String privada "user"
    private String user;

    // String privada "password"
    private String password;

    /**
     * Construtor público da classe
     * @param user nome do usuario
     * @param password senha do usuario
     */
    public UserInfo(String user, String password) {
        this.user = user;
        this.password = password;
    }

    // Getter da variavel "user"
    public String getUser() {
        return user;
    }

    // Setter da variavel "user"
    public void setUser(String user) {
        this.user = user;
    }

    // Getter customizado da variavel "password"
    public String getPassword() {
        return this.cryptPassword(password);
    }

    // Setter da variavel "password"
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Método para encriptar senhas
     * @param password senha a ser encriptada
     * @return senha encriptada
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
