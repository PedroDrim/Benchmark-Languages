# ErrorClass

### Introdução

O objetivo deste experimento é implementar o conceito de programação defensiva nos códigos e realizar uma análise com base nele, conforme o diagrama UML abaixo:

![UML UserInfo](https://raw.githubusercontent.com/PedroDrim/Benchmark-Languages/master/outputs/errorclass/errorclass.png)

Obs.: Um dos objetivos deste experimento **NÃO** é a execução dos métodos de acesso, entretanto os métodos foram testados para o bom funcionamento das classes.

A classe **UserInfo** possui atributos acessáveis por meios de **getters** e **setters** públicos customizados e um método privado. 

A classe **BenchmarkMeasure**, que implementa a interface **BenchmarkOutput**, possui técnicas para mensurar a execução de blocos de códigos. 

A classe **TableReader**, que implementa a interface **DataReader**, é responsável por gerar uma lista de **UserInfo** com base em uma tabela csv.

A interface **TableAnalysis** foi gerada para testar o uso de interfaces nas linguagens em estudo, além de possibilitar a implementação de simples análises estatísticas:

* Classe **LanguageSortAnalysis**: Ordena uma lista de **UserInfo**, com base no **credit**, por meio do algorítmo de ordenação da própria linguagem.
* Classe **BubbleSortAnalysis**: Ordena uma lista de **UserInfo**, com base no **credit**, por meio do algorítmo de ordenação bubbleSort.
* Classe **QuickSortAnalysis**: Ordena uma lista de **UserInfo**, com base no **credit**, por meio do algorítmo de ordenação quickSort.
* Classe **SummaryAnalysis**: Obtem os valores máximo, mínimo e média da variavel **credit** de uma lista de **UserInfo**.

Para a análise foram gerados 20 (tabelas) tabelas csv's com tamanhos de **1.000 (mil)** até **20.000 (vinte mil)** elementos, com intervalos de **1.000 (mil)** elementos.

Foram então medidos os tempos decorridos (em milisegundos) para a leitura e análise das tabelas.

### Resultados

Após a execução dos códigos de forma automátizada, os resultados foram obtidos e após uma breve limpeza dos dados foi obtido a seguinte [tabela]().

O script utilizado para a análise pode ser visualizado [aqui](https://github.com/PedroDrim/Benchmark-Languages/blob/master/outputs/inputclass/inputclass_graph.r).

Tabela esta que foi convertida em um gráfico do tipo **ScatterPlot**, com base no tamanho das tabelas utilizadas nos experimentos, por meio da biblioteca ggplot2 do R.

* Leitura dos dados:

![ScatterPlot 'Read data' em dotnet]()
![ScatterPlot 'Read data' em R]()
![ScatterPlot 'Read data' em java]()
![ScatterPlot 'Read data' em scala]()
![ScatterPlot 'Read data' em kotlin]()
![ScatterPlot 'Read data' em python3]()
![ScatterPlot 'Read data' em ruby]()
![ScatterPlot 'Read data' em typescript]()

* Ordenação por bubblesort:

![ScatterPlot 'bubble sort' em dotnet]()
![ScatterPlot 'bubble sort' em R]()
![ScatterPlot 'bubble sort' em java]()
![ScatterPlot 'bubble sort' em scala]()
![ScatterPlot 'bubble sort' em kotlin]()
![ScatterPlot 'bubble sort' em python3]()
![ScatterPlot 'bubble sort' em ruby]()
![ScatterPlot 'bubble sort' em typescript]()

* Ordenação por quicksort:

![ScatterPlot 'quick sort' em dotnet]()
![ScatterPlot 'quick sort' em R]()
![ScatterPlot 'quick sort' em java]()
![ScatterPlot 'quick sort' em scala]()
![ScatterPlot 'quick sort' em kotlin]()
![ScatterPlot 'quick sort' em python3]()
![ScatterPlot 'quick sort' em ruby]()
![ScatterPlot 'quick sort' em typescript]()

* Ordenação pela linguagem:

![ScatterPlot 'language sort' em dotnet]()
![ScatterPlot 'language sort' em R]()
![ScatterPlot 'language sort' em java]()
![ScatterPlot 'language sort' em scala]()
![ScatterPlot 'language sort' em kotlin]()
![ScatterPlot 'language sort' em python3]()
![ScatterPlot 'language sort' em ruby]()
![ScatterPlot 'language sort' em typescript]()

* Valores máximo, mínimo e média:

![ScatterPlot 'summary' em dotnet]()
![ScatterPlot 'summary' em R]()
![ScatterPlot 'summary' em java]()
![ScatterPlot 'summary' em scala]()
![ScatterPlot 'summary' em kotlin]()
![ScatterPlot 'summary' em python3]()
![ScatterPlot 'summary' em ruby]()
![ScatterPlot 'summary' em typescript]()

### Premissas

1. Há uma possibilidade dos resultados obtidos não serem verídicos, pois cada resultado foi obtido dentro da propria linguagem testada.
2. Para a linguagem **R** foi-se retirado a biblioteca de orientação a objetos **R6**. 
3. Para este experimento foi-se implementado um ambiente para automatização, entretanto esse ambiente ainda é necessário ser melhorado.
4. Apesar dos resuldados obtidos pela interpretação dos gráficos possuírem um gigantesco desvio padrão, esses resultados serão utilizados para a melhor compreênsão das linguagens em estudo.