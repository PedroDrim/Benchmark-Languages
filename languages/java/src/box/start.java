package box;

import java.util.ArrayList;
import java.util.List;

/**
 Classe inicial do programa
 */
public class start {

    /**
     * Método de inicialização do projeto
     * @param args lista de parametros passados via console
     */
    public static void main(String args[]){

        // Gera uma lista de UserInfo
        List<UserInfo> list = new ArrayList<>();

        long antes = System.currentTimeMillis();

        for(int index = 0; index < 1000000; index++){
            String user = "user" + index;
            String password = "password" + index;
            list.add(new UserInfo(user, password));
        }

        long depois = System.currentTimeMillis();

        System.out.println(list.get(0).getPassword());
        System.out.println("Diff: " + (depois - antes));
    }
}
