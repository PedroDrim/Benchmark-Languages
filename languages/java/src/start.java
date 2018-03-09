import model.SimpleTableAnalysis;
import model.Table;
import model.UserInfo;
import provider.MaxValueAnalysis;
import provider.MeanAnalysis;
import provider.MinValueAnalysis;

import java.io.IOException;
import java.util.List;

public class start {

    public static void main(String args[]) throws IOException {

        String fileName = "/home/pedro/MEGA/MEGAsync/Repositorio_Git/Benchmark-Languages/outputs/inputclass/inputclass_1e+06.csv";
        read(fileName, "java_10_inputclass_1e+06");

    }

    public static void read(String fileName, String identificador) throws IOException {

        long leituraInicio = System.currentTimeMillis();

        Table table = new Table(fileName);

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

        System.out.println("\nIdentificador: " + identificador);
        System.out.println("Tempo de leitura (ms): " + (leituraFim - leituraInicio));
        System.out.println("Tempo de análise (ms): " + (analiseFim - analiseInicio));

        System.out.println("Max: " + max);
        System.out.println("Min: " + min);
        System.out.println("Mean: " + mean);
    }
}
