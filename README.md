# Benchmark-Languages

### Introdução

O objetivo deste repositório é estudar o comportamento, estrutura e o desempenho de diversas linguagens.

Os experimentos deste repositório não possuem os arquivos de build com o objetivo de reduzir o tamanho dos commits.

No momento, as seguintes linguagens de programação estão sendo estudadas simultaneamente:

| Linguagem | IDE utilizada | Compilação |
|-----------|---------------|------------|
| Java | Intellij (JVM) | [Criação de pacotes com Intellij](https://www.jetbrains.com/help/idea/packaging-a-module-into-a-jar-file.html) |
| Scala | Intellij (JVM) | [Criação de pacotes com Intellij](https://www.jetbrains.com/help/idea/packaging-a-module-into-a-jar-file.html) |
| Kotlin | Intellij (JVM) | [Criação de pacotes com Intellij](https://www.jetbrains.com/help/idea/packaging-a-module-into-a-jar-file.html) |
| R | Visual Studio Code | - |
| C# | Visual Studio Code | - |
| Ruby | Visual Studio Code | - |
| Python3 | Visual Studio Code | - |
| Typescript | Visual Studio Code | `npm install && npm run build` |
| Golang | Visual Studio Code | - |

### Experimentos

Esta seção é a mais divertida (na minha opinião), pois nela descrevo os experimentos realizados com as linguagens bem como as técnicas utilizadas para as respectivas análises.

| Nome (com link) | Objetivo | Técnicas utilizadas para análise |
|-----------------|----------|----------------------------------|
| [simpleclass](https://github.com/PedroDrim/Benchmark-Languages/blob/simpleclass/Documents/simpleclass.md) | Estudar a criação de classes simples | Scatterplot de média com desvio padrão e regressão linear simples.|
