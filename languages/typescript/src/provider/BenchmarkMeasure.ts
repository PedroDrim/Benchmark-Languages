import {BenchmarkOutput} from '../model/BenchmarkOutput'
import {InvalidParameterException} from '../model/exception/InvalidParameterException'
import {DataReaderException} from '../model/exception/DataReaderException'
import {BenchmarkException} from '../model/exception/BenchmarkException'
import { TimeFormat } from '../model/TimeFormat';

import { TSMap } from "typescript-map"
import fs = require('fs');

/**
 * Classe para captura de estados de tempo
 * @see model.BenchmarkOutput
 */
export class BenchmarkMeasure implements BenchmarkOutput {

    /**
     * Marca de inicio de estado
     */
    private START_MARK: string = "_S";

    /**
     * Marca de fim de estado
     */
    private END_MARK: string = "_E";

    /**
     * Mapa de estados
     */
    private benchMap: Map<string, number>;

    /**
     * Construtor publico da classe
     */
    constructor() {
        this.benchMap = new Map();
    }

    /**
     * Inicio da captura de estado
     * @param tag Nome da captura referente
     */
    public start(tag: string): void {
        if(tag == null) throw new InvalidParameterException("'tag' é null");

        let time: number = new Date().getTime();
        this.benchMap.set(tag + this.START_MARK, time);
    }

    /**
     * Fim da captura de estado
     * @param tag Nome da captura referente
     */
    public end(tag: String): void {
        if(tag == null) throw new InvalidParameterException("'tag' é null");

        let time: number = new Date().getTime();
        this.benchMap.set(tag + this.END_MARK, time);
    }

    /**
     * Resultado da captura de estado especifica
     * @param tag Nome da captura referente
     * @param format Formato do resultado
     * @return Tempo decorrido entre o inicio e o fim da captura de estado
     */
    public resultByTag(tag: string, format: TimeFormat): number {
        if(tag == null) throw new InvalidParameterException("'tag' é null");
        if(format == null) throw new InvalidParameterException("'format' é null");

        let startTag: boolean = this.benchMap.has(tag + this.START_MARK);
        let endTag: boolean = this.benchMap.has(tag + this.END_MARK);

        if(!startTag || !endTag) throw new BenchmarkException("Não encontrado par 'inicio-fim' de:" + tag);

        let start: number = this.benchMap.get(tag + this.START_MARK);
        let end: number = this.benchMap.get(tag + this.END_MARK);
        return (end - start) * format;
    }

    /**
     * Resultado de todas as capturas de estado
     * @param format Formato do resultado
     * @return Mapa contendo o tempo decorrido entre o inicio e o fim da captura de estado para cada estado gerado.
     */
    public result(format: TimeFormat): Map<string, number> {
        if(format == null) throw new InvalidParameterException("'format' é null");

        var mapResult: Map<string, number> = new Map();
        let tagSet = this.benchMap.keys();

        this.benchMap.forEach( (value: number, key: string) => {
            let tag: string = key.split("_")[0];
            let time: number = this.resultByTag(tag, format);
            mapResult.set(tag, time);
        })

        return mapResult;
    }

    /**
     * Exporta o resultado no formato de um arquivo
     * @param fileName Nome do arquivo de saida
     * @param format Formato do resultado
     */
    public export(fileName: string, format: TimeFormat): void {
        if(fileName == null) throw new InvalidParameterException("'fileName' é null");
        if(format == null) throw new InvalidParameterException("'format' é null");

        let mapResult: Map<string, number> = this.result(format);

        var serilizedString: string = "{";

        let size: number = mapResult.size;
        var index:number = 1;
        mapResult.forEach((value: number, key: string) => {
            serilizedString += "\"" + key.toString() + "\":";
            serilizedString += "\"" + value.toString() + "\"";
            
            if(index < size) {
                serilizedString += ",";
                index++;
            }
        })

        serilizedString += "}";

        try {
            let file = fs.writeFileSync(fileName, serilizedString);

        } catch (e) {
            throw new DataReaderException("Arquivo não encontrado:" + fileName);
        }

    }
}
