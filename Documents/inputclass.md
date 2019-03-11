# Experimento InputClass

### Introdução

O objetivo deste experimento é aprender sobre a leitura de arquivos externos e criação de interfaces das linguagens selecionadas conforme o diagrama UML abaixo:

![UML UserInfo](annex/images/inputclass.png?raw=true)

Os métodos para o gerenciamento da classe foram executados com o objetivo de verificar o funcionamento, entretanto esse não é o objetivo principal do experimento.

A classe **UserInfo** possui atributos acessáveis por meios de **getters** e **setters** públicos customizados e um método privado. 

A classe **Table** é responsável por gerar uma lista de **UserInfo** com base em uma tabela csv.

A interface **SimpleTableAnalysis** foi gerada para testar o uso de interfaces nas linguagens em estudo, além de possibilitar a implementação de simples análises estatísticas:

* Classe **MaxValueAnalysis**: Obtem o maior valor da variável **credit** em uma lista de **UserInfo**.
* Classe **MinValueAnalysis**: Obtem o menor valor da variável **credit** em uma lista de **UserInfo**.
* Classe **MeanAnalysis**: Obtem a média da variável **credit** em uma lista de **UserInfo**.

Cada diretório de Linguagem, possui um arquivo responsável por inicializar o **experimento individual** chamado **Bench.sh** que encapsula os comandos de execução em cada linguagem, tais como: *java*, *rscript*, *python*, *ruby* etc.

### Execução

1. Clone o respositório com  `git clone -b inputclass https://github.com/PedroDrim/Benchmark-Languages`.
2. Compile cada experimento conforme a coluna de compilação presente no `README.md`.
3. Execute o experimento `Rscript Analysis/analysis.R`.
4. Vá pegar um café :coffee: enquanto aguarda o resultado.

O script utilizado para a execução completa do experimento pode ser visualizado [aqui](../Analysis/analysis.R?raw=true).

### Análise

Para a análise, foi-se planejado 4 (quatro) etapas, conforme o diagrama UML abaixo:  

![UML Analysis](annex/images/analysis.png?raw=true)

| Etapas | Arquivo | Função |
|--------|---------|--------|
| Pré    | ExperimentCreator.R | Gerar as entradas necessárias para a execução do experimento. |
| 1     | Reader.R | Executar os arquivos **Bench.sh** e tratar as saídas obtidas na forma de uma tabela.|
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
|Java|![Java Result](annex/images/result/Plot_InputClass_java.png?raw=true)|
|Scala|![Scala Result](annex/images/result/Plot_InputClass_scala.png?raw=true)|
|Kotlin|![Kotlin Result](annex/images/result/Plot_InputClass_kotlin.png?raw=true)|
|Dotnet|![Dotnet Result](annex/images/result/Plot_InputClass_dotnet.png?raw=true)|
|Ruby|![Ruby Result](annex/images/result/Plot_InputClass_ruby.png?raw=true)|
|Python3|![Python3 Result](annex/images/result/Plot_InputClass_python3.png?raw=true)|
|R|![R Result](annex/images/result/Plot_InputClass_R.png?raw=true)|
|Typescript|![Typescript Result](annex/images/result/Plot_InputClass_typescript.png?raw=true)|
|Golang|![Golang Result](annex/images/result/Plot_SimpleClass_golang.png?raw=true)|

### Premissas

1. Há uma possibilidade dos resultados obtidos não serem verídicos, pois cada resultado foi obtido dentro da propria linguagem testada.
2. Há uma possibilidade de que as funções padrões do sistema operacional influenciaram no tempo de execução dos experimentos, o que pode explicar elevados desvios padrões.
