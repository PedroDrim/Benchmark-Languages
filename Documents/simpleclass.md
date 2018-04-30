# Experimento SimpleClass

### Introdução

O objetivo deste experimento é aprender a geração de uma classe simples das linguagens selecionadas conforme o diagrama UML abaixo:

![UML UserInfo](annex/images/simpleclass.png?raw=true)

Os métodos para o gerenciamento da classe foram executados com o objetivo de verificar o funcionamento, entretanto esse não é o objetivo principal do experimento.

A classe **UserInfo** possui atributos acessáveis por meios de **getters** e **setters** públicos customizados e um método privado. 

Cada diretório de Linguagem, possui um arquivo responsável por inicializar o **experimento individual** chamado **Bench.sh** que encapsula os comandos de execução em cada linguagem, tais como: *java*, *rscript*, *python*, *ruby* etc.

### Execução

1. Clone o respositório com  `git clone -b simpleclass https://github.com/PedroDrim/Benchmark-Languages`.
2. Execute o experimento `Rscript Analysis/analysis.R`.
3. Vá pegar um café :coffee: enquanto aguarda o resultado.

O script utilizado para a execução completa do experimento pode ser visualizado [aqui](../Analysis/analysis.R?raw=true).

### Análise

Para a análise, foi-se planejado 3 (três) etapas, conforme o diagrama UML abaixo:  

![UML Analysis](annex/images/analysis.png?raw=true)

| Etapas | Arquivo | Função |
|--------|---------|--------|
| 1     | Reader.R | Executar os arquivos **Bench.sh** e tratar as saídas obtidas na forma de uma tabela. |
| 2   | Analyser.R | Analisar a tabela obtida na etapa **1** para retornar a tabela tratada. |
| 3    | Plotter.R | Gera os graficos para exibir os resultados obtidos. |

Para a análise desses dados foi-se utilizado as seguintes técnicas:

| Técnica | Motivo |
|---------|--------|
| Média aritmética. | A média aritmética permite "resumir" o conjunto de dados a ser analisado. |
| Desvio padrão | O uso média aritmética em sí mascara **ruídos extremos** tornando a analise pouco confiável. O desvio padrão evidência esses ruídos. |
| Regressão linear | Estimar o comportamento dos resultados obtidos. |

 Os resultados foram exibidos em um gráfico do tipo **ScatterPlot** por meio da biblioteca ggplot2 do R.

### Resultados Obtidos

| Linguagem | Gráfico |
|-----------|---------|
|Java|![Java Result](annex/images/result/Plot_SimpleClass_java.png?raw=true)|
|Scala|![Scala Result](annex/images/result/Plot_SimpleClass_scala.png?raw=true)|
|Kotlin|![Kotlin Result](annex/images/result/Plot_SimpleClass_kotlin.png?raw=true)|
|Dotnet|![Dotnet Result](annex/images/result/Plot_SimpleClass_dotnet.png?raw=true)|
|Ruby|![Ruby Result](annex/images/result/Plot_SimpleClass_ruby.png?raw=true)|
|Python3|![Python3 Result](annex/images/result/Plot_SimpleClass_python3.png?raw=true)|
|R|![R Result](annex/images/result/Plot_SimpleClass_R.png?raw=true)|
|Typescript|![Typescript Result](annex/images/result/Plot_SimpleClass_typescript.png?raw=true)|

### Premissas

1. Há uma possibilidade dos resultados obtidos não serem verídicos, pois cada resultado foi obtido dentro da propria linguagem testada.
2. Há uma possibilidade de que as funções padrões do sistema operacional influenciaram no tempo de execução dos experimentos, o que explica os elevados desvios padrões.