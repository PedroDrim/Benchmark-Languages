package main

import (
    "fmt"
    "os"
    "strconv"
    "time"
    "model"
)

// Método de inicialização do projeto
// @param args Lista de parametros obtidos via console
func main() {

    var tamanho int = getParam(os.Args)
    
    antes := time.Now().UnixNano()
    lista := make([]int, tamanho)
    
    for index := 0; index < len(lista); index++ {
        index := strconv.Itoa(index)
        userInfo.New("user" + index, "password" + index)
    }
    
    depois := time.Now().UnixNano()
    resultado := float64(depois - antes) / float64(time.Millisecond)
    
    fmt.Println("[OK]Tamanho:", tamanho)
    fmt.Println("[OK]Tempo:", resultado, "ms")
}

// Método para captura e tratamento dos parametros obtidos via console
// @param codes Lista de parametros obtidos via console
// @return Tamanho de usuários á serem gerados
func getParam(codes []string) int {
    if len(codes) != 2 {
        fmt.Println("Parametros inválidos.")
        os.Exit(-1)
    }
    
    var line int
    line, _ = strconv.Atoi(codes[1])

    if line <= 0 {
        fmt.Println("Quantidade de linhas menor que 1.")
        os.Exit(-1)
    }

    return line    
}
