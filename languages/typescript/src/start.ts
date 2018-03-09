import {Table} from './model/Table'
import { UserInfo } from './model/UserInfo';
import { SimpleTableAnalysis } from './model/SimpleTableAnalysis';
import { MaxValueAnalysis } from './provider/MaxValueAnalysis';
import { MinValueAnalysis } from './provider/MinValueAnalysis';
import { MeanAnalysis } from './provider/MeanAnalysis';

let fileName = "/home/pedro/MEGA/MEGAsync/Repositorio_Git/Benchmark-Languages/outputs/inputclass/inputclass_1e+06.csv"
let identificador = "typescript_1_inputclass_1e+06"

let leitura_antes = new Date().getTime()

var table: Table = new Table(fileName);

let leitura_depois = new Date().getTime()

let list: UserInfo[] = table.getUserInfoList();

let maxAnalysis: SimpleTableAnalysis = new MaxValueAnalysis()
let minAnalysis: SimpleTableAnalysis = new MinValueAnalysis()
let meanAnalysis: SimpleTableAnalysis = new MeanAnalysis()

let analise_antes = new Date().getTime()

let max = maxAnalysis.analysis(list)
let min = minAnalysis.analysis(list)
let mean = meanAnalysis.analysis(list)

let analise_depois = new Date().getTime()

console.log("Identificador: " + identificador)
console.log("Tempo de leitura (ms): " + (leitura_depois - leitura_antes))
console.log("Tempo de analise (ms): " + (analise_depois - analise_antes))
console.log("Max: " + max)
console.log("Min: " + min)
console.log("Mean: " + mean)