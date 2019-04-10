import model.UserInfo;

import java.util.ArrayList;
import java.util.List;

/**
 Classe inicial do programa
 */
public class start {

    /**
     * Método de inicialização do projeto
     * @param args Lista de parametros obtidos via console
     */
    public static void main(String args[]){

        int tamanho = prepareArgs(args);

        StringBuilder builder = new StringBuilder();
        List<UserInfo> list = new ArrayList<>();

        long antes = System.currentTimeMillis();

        for(int index = 0; index < tamanho; index++){
            builder.append("user").append(index);
            String user = builder.toString();

            builder = new StringBuilder();

            builder.append("password").append(index);
            String password = builder.toString();

            list.add(new UserInfo(user, password));
        }

        long time = System.currentTimeMillis() - antes;

        builder = new StringBuilder();
        builder.append("[OK]Tamanho: ").append(tamanho).append("\n");
        builder.append("[OK]Tempo: ").append(time).append(" ms");

        System.out.println(builder.toString());
    }

    /**
     * Método para captura e tratamento dos parametros obtidos via console
     * @param codes Lista de parametros obtidos via console
     * @return Tamanho de usuários á serem gerados
     */
    private static int prepareArgs(String codes[]) {
        if(codes.length != 1) {
            System.out.println("Parametros inválidos.");
            System.exit(-1);
        }

        int line = Integer.parseInt(codes[0]);

        if(line <= 0) {
            System.out.println("Quantidade de linhas menor que 1.");
            System.exit(-1);
        }

        return line;
    }
}
