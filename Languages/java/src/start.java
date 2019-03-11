import model.SimpleTableAnalysis;
import model.Table;
import model.UserInfo;
import provider.MaxValueAnalysis;
import provider.MeanAnalysis;
import provider.MinValueAnalysis;

import java.io.IOException;
import java.util.List;

/**
 * Classe inicial do programa
 */
public class start {

    /**
     * Método de inicialização do projeto
     * @param args Lista de parametros obtidos via console
     */
    public static void main(String args[]) throws IOException {

        String arquivo = prepareArgs(args);
        long leituraInicio = System.currentTimeMillis();

        Table table = new Table(arquivo);

        long leituraFim = System.currentTimeMillis();

        List<UserInfo> list = table.getUserInfoList();
        SimpleTableAnalysis maxAnalysis = new MaxValueAnalysis();
        SimpleTableAnalysis minAnalysis = new MinValueAnalysis();
        SimpleTableAnalysis meanAnalysis = new MeanAnalysis();

        long analiseInicio = System.currentTimeMillis();

        double max = maxAnalysis.analysis(list);
        double min = minAnalysis.analysis(list);
        double mean = meanAnalysis.analysis(list);

        long analiseFim = System.currentTimeMillis();

        StringBuilder builder = new StringBuilder();

        builder.append("[OK]Arquivo: ").append(arquivo).append("\n");
        builder.append("[OK]Tempo_leitura: ").append((leituraFim - leituraInicio)).append(" ms").append("\n");
        builder.append("[OK]Tempo_analise: ").append((analiseFim - analiseInicio)).append(" ms").append("\n");
        builder.append("[OK]Max: ").append(max).append("\n");
        builder.append("[OK]Min: ").append(min).append("\n");
        builder.append("[OK]Mean: ").append(mean).append("\n");

        System.out.println(builder.toString());

    }

    /**
     * Método para captura e tratamento dos parametros obtidos via console
     * @param codes Lista de parametros obtidos via console
     * @return Nome do arquivo de usuarios
     */
    private static String prepareArgs(String codes[]) {
        if(codes.length != 1) {
            System.out.println("Parametros inválidos.");
            System.exit(-1);
        }

        String line = codes[0];
        return line;
    }

}
