import {Table} from './model/Table'
import { UserInfo } from './model/UserInfo';
import { SimpleTableAnalysis } from './model/SimpleTableAnalysis';
import { MaxValueAnalysis } from './provider/MaxValueAnalysis';
import { MinValueAnalysis } from './provider/MinValueAnalysis';
import { MeanAnalysis } from './provider/MeanAnalysis';

export class Start {

    public constructor(args: string[]) {
        let fileName = this.getParam(args)
        // Obtendo o tempo inicial de leitura em milissegundos
        let leitura_antes = new Date().getTime()

        // Convertendo arquivo em lista de "UserInfo"
        var table: Table = new Table(fileName);

        // Obtendo o tempo final de leitura em milissegundos
        let leitura_depois = new Date().getTime()

        let list: UserInfo[] = table.getUserInfoList();

        let maxAnalysis: SimpleTableAnalysis = new MaxValueAnalysis()
        let minAnalysis: SimpleTableAnalysis = new MinValueAnalysis()
        let meanAnalysis: SimpleTableAnalysis = new MeanAnalysis()

        // Obtendo o tempo inicial de analise em milissegundos
        let analise_antes = new Date().getTime()

        // Realizando analises
        let max = maxAnalysis.analysis(list)
        let min = minAnalysis.analysis(list)
        let mean = meanAnalysis.analysis(list)

        // Obtendo o tempo final de analise em milissegundos
        let analise_depois = new Date().getTime()

        // Dados de saida
        console.log("[OK]Arquivo: " + fileName)
        console.log("[OK]Tempo_leitura: " + (leitura_depois - leitura_antes) + " ms")
        console.log("[OK]Tempo_analise: " + (analise_depois - analise_antes) + " ms")
        console.log("[OK]Max: " + max)
        console.log("[OK]Min: " + min)
        console.log("[OK]Mean: " + mean)
    }

    // Método para captura e tratamento dos parametros obtidos via console
    // @param codes Lista de parametros obtidos via console
    // @return Tamanho de usuários á serem gerados
    private getParam(codes: string[]): string{
        if(codes.length != 3) {
            console.log("Parametros inválidos.")
            process.exit(-1)
        }
    
        return(codes[2])    
    }
}

new Start(process.argv);
