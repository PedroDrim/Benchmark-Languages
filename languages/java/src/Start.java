import model.BenchmarkOutput;
import model.TableAnalysis;
import model.TimeFormat;
import model.exception.DataReaderException;
import model.exception.InvalidParameterException;
import provider.*;
import model.UserInfo;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

public class Start {

    public static void main(String args[]) throws IOException {

        if(args.length == 0) throw new InvalidParameterException("Parametros iniciais nao encontrados");

        String configFile = args[0];
        Properties properties = loadProperties(configFile);

        String input = properties.getProperty("INPUT_FILENAME");
        String output = properties.getProperty("OUTPUT_FILENAME");

        BenchmarkOutput benchmark = new BenchmarkMeasure();

        TableAnalysis summaryAnalysis = new SummaryAnalysis();
        TableAnalysis bubbleSortAnalysis = new BubbleSortAnalysis();
        TableAnalysis quickSortAnalysis = new QuickSortAnalysis();
        TableAnalysis languageSortAnalysis = new LanguageSortAnalysis();

        //==================================================
        // Leitura dos dados
        benchmark.start("Read");
        TableReader tableReader = new TableReader(input);
        List<UserInfo> list = tableReader.read();
        benchmark.end("Read");
        //==================================================
        // Analise dos dados (Summary)
        benchmark.start("SummaryAnalyse");
        double[] summary = (double[]) summaryAnalysis.analysis(list);
        benchmark.end("SummaryAnalyse");
        //==================================================
        // Analise dos dados (Bubble)
        benchmark.start("BubbleAnalyse");
        List<UserInfo> bubble = (List<UserInfo>) bubbleSortAnalysis.analysis(list);
        benchmark.end("BubbleAnalyse");
        //==================================================
        // Analise dos dados (Quick)
        benchmark.start("QuickAnalyse");
        List<UserInfo> quick = (List<UserInfo>) quickSortAnalysis.analysis(list);
        benchmark.end("QuickAnalyse");
        //==================================================
        // Analise dos dados (Language)
        benchmark.start("LanguageAnalyse");
        List<UserInfo> lang = (List<UserInfo>) languageSortAnalysis.analysis(list);
        benchmark.end("LanguageAnalyse");
        //==================================================

        benchmark.export(output, TimeFormat.MILLISEGUNDOS);
    }

    public static Properties loadProperties(String configFile) throws IOException {
        if(configFile == null) throw new InvalidParameterException("'configFile' é null");

        try {
            InputStream input = new FileInputStream(configFile);
            Properties properties = new Properties();
            properties.load(input);

            return properties;

        } catch(IOException e) {
            throw new DataReaderException("Erro ao ler arquivo:" + configFile);
        }
    }
}
