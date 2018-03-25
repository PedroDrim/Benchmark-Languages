package provider;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import model.BenchmarkOutput;
import model.TimeFormat;
import model.exception.BenchmarkException;
import model.exception.DataReaderException;
import model.exception.InvalidParameterException;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Classe para captura de estados de tempo
 * @see model.BenchmarkOutput
 */
public class BenchmarkMeasure implements BenchmarkOutput {

    /**
     * Marca de inicio de estado
     */
    private String START_MARK = "_S";

    /**
     * Marca de fim de estado
     */
    private String END_MARK = "_E";

    /**
     * Mapa de estados
     */
    private Map<String, Double> benchMap;

    /**
     * Construtor publico da classe
     */
    public BenchmarkMeasure() {
        this.benchMap = new HashMap<>();
    }

    /**
     * Inicio da captura de estado
     * @param tag Nome da captura referente
     */
    @Override
    public void start(String tag) {
        if(tag == null) throw new InvalidParameterException("'tag' é null");

        double time = System.currentTimeMillis();
        this.benchMap.put(tag + START_MARK, time);
    }

    /**
     * Fim da captura de estado
     * @param tag Nome da captura referente
     */
    @Override
    public void end(String tag) {
        if(tag == null) throw new InvalidParameterException("'tag' é null");

        double time = System.currentTimeMillis();
        this.benchMap.put(tag + END_MARK, time);
    }

    /**
     * Resultado da captura de estado especifica
     * @param tag Nome da captura referente
     * @param format Formato do resultado
     * @return Tempo decorrido entre o inicio e o fim da captura de estado
     */
    @Override
    public double result(String tag, TimeFormat format) {
        if(tag == null) throw new InvalidParameterException("'tag' é null");
        if(format == null) throw new InvalidParameterException("'format' é null");

        boolean startTag = this.benchMap.containsKey(tag + START_MARK);
        boolean endTag = this.benchMap.containsKey(tag + END_MARK);

        if(!startTag || !endTag) throw new BenchmarkException("Não encontrado par 'inicio-fim' de:" + tag);

        double start = this.benchMap.get(tag + START_MARK);
        double end = this.benchMap.get(tag + END_MARK);
        return (end - start) * format.getValor();
    }

    /**
     * Resultado de todas as capturas de estado
     * @param format Formato do resultado
     * @return Mapa contendo o tempo decorrido entre o inicio e o fim da captura de estado para cada estado gerado.
     */
    @Override
    public Map<String, Double> result(TimeFormat format) {
        if(format == null) throw new InvalidParameterException("'format' é null");

        Map<String, Double> mapResult = new HashMap<>();
        Set<String> tagSet = this.benchMap.keySet();

        for(String tagMark : tagSet) {
            String tag = tagMark.split("_")[0];
            double time = this.result(tag, format);
            mapResult.put(tag, time);
        }

        return mapResult;
    }

    /**
     * Exporta o resultado no formato de um arquivo
     * @param fileName Nome do arquivo de saida
     * @param format Formato do resultado
     */
    @Override
    public void export(String fileName, TimeFormat format) {
        if(fileName == null) throw new InvalidParameterException("'fileName' é null");
        if(format == null) throw new InvalidParameterException("'format' é null");

        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();

        Map<String, Double> mapResult = this.result(format);
        String serilizedString = gson.toJson(mapResult);

        try {
            PrintWriter writer = new PrintWriter(fileName);
            writer.println(serilizedString);
            writer.close();

        } catch (FileNotFoundException e) {
            throw new DataReaderException("Arquivo não encontrado:" + fileName);
        }

    }
}
