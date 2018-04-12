import { TableReader } from "./provider/TableReader";
import { BenchmarkOutput } from "./model/BenchmarkOutput";
import { BenchmarkMeasure } from "./provider/BenchmarkMeasure";
import { TableAnalysis } from "./model/TableAnalysis";
import { SummaryAnalysis } from "./provider/SummaryAnalysis";
import { BubbleSortAnalysis } from "./provider/BubbleSortAnalysis";
import { QuickSortAnalysis } from "./provider/QuickSortAnalysis";
import { LanguageSortAnalysis } from "./provider/LanguageSortAnalysis";
import { UserInfo } from "./model/UserInfo";
import { TimeFormat } from "./model/TimeFormat";
import { InvalidParameterException } from "./model/exception/InvalidParameterException";

import fs = require('fs');

export class Start {

    public constructor() {

        let configFile = process.argv[2];
        let properties = require(configFile);

        let input: string = properties.INPUT_FILENAME;
        let output: string = properties.OUTPUT_FILENAME;

        let benchmark: BenchmarkOutput = new BenchmarkMeasure();

        let summaryAnalysis: TableAnalysis<Array<number>> = new SummaryAnalysis();
        let bubbleSortAnalysis: TableAnalysis<Array<UserInfo>> = new BubbleSortAnalysis();
        let quickSortAnalysis: TableAnalysis<Array<UserInfo>> = new QuickSortAnalysis();
        let languageSortAnalysis: TableAnalysis<Array<UserInfo>> = new LanguageSortAnalysis();

        //==================================================
        // Leitura dos dados
        benchmark.start("Read");
        let tableReader: TableReader = new TableReader(input);
        let list: Array<UserInfo> = tableReader.readAll();
        benchmark.end("Read");
        //==================================================
        // Analise dos dados (Summary)
        benchmark.start("SummaryAnalyse");
        let summary: Array<number> = summaryAnalysis.analysis(list);
        benchmark.end("SummaryAnalyse");
        //==================================================
        // Analise dos dados (Bubble)
        benchmark.start("BubbleAnalyse");
        let bubble: Array<UserInfo> =  bubbleSortAnalysis.analysis(list);
        benchmark.end("BubbleAnalyse");
        //==================================================
        // Analise dos dados (Quick)
        benchmark.start("QuickAnalyse");
        let quick: Array<UserInfo> =  quickSortAnalysis.analysis(list);
        benchmark.end("QuickAnalyse");
        //==================================================
        // Analise dos dados (Language)
        benchmark.start("LanguageAnalyse");
        let lang: Array<UserInfo> =   languageSortAnalysis.analysis(list);
        benchmark.end("LanguageAnalyse");
        //==================================================

        benchmark.export(output, TimeFormat.MILLISEGUNDOS);
    }
}

let start: Start = new Start()