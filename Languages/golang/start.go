package main

import (
    "fmt"
    "os"
    "time"
    table "model/table"
    maxValueAnalysis "provider/maxValueAnalysis"
    minValueAnalysis "provider/minValueAnalysis"
    meanAnalysis "provider/meanAnalysis"
)

// Método de inicialização do projeto
// @param args Lista de parametros obtidos via console
func main() {

    var fileName string = getParam(os.Args)
   
    // Obtendo o tempo inicial de leitura em milissegundos
    leitura_inicio := time.Now().UnixNano()

    // Convertendo arquivo em lista de "UserInfo"
    userTable := table.New(fileName)

    // Obtendo o tempo final de leitura em milissegundos
    leitura_fim := time.Now().UnixNano()

    userInfoList := userTable.UserInfoList

    maxValue := maxValueAnalysis.New()
    minValue := minValueAnalysis.New()
    meanValue := meanAnalysis.New()

    // Obtendo o tempo inicial de analise em milissegundos
    analise_inicio := time.Now().UnixNano()

    // Realizando analises
    vmax := maxValue.Analysis(userInfoList)
    vmin := minValue.Analysis(userInfoList)
    vmean := meanValue.Analysis(userInfoList)

    // Obtendo o tempo final de analise em milissegundos
    analise_fim := time.Now().UnixNano()

    resultado_leitura := float64(leitura_fim - leitura_inicio) / float64(time.Millisecond)
    resultado_analise := float64(analise_fim - analise_inicio) / float64(time.Millisecond)

    // Dados de saida
    fmt.Println("[OK]Arquivo:", fileName)
    fmt.Println("[OK]Tempo_leitura:", resultado_leitura, "ms")
    fmt.Println("[OK]Tempo_analise:", resultado_analise, "ms")
    fmt.Println("[OK]Max:", vmax)
    fmt.Println("[OK]Min:", vmin)
    fmt.Println("[OK]Mean:", vmean)
}

// Método para captura e tratamento dos parametros obtidos via console
// @param codes Lista de parametros obtidos via console
// @return Tamanho de usuários á serem gerados
func getParam(codes []string) string {
    if len(codes) != 2 {
        fmt.Println("Parametros inválidos.")
        os.Exit(-1)
    }
    
    var line = codes[1]

    return line    
}
