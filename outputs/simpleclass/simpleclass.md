# SimpleClass

### Introdução

O objetivo deste experimento é gerar uma classe simples conforme o diagrama UML abaixo:

![UML UserInfo](https://raw.githubusercontent.com/PedroDrim/Benchmark-Languages/master/outputs/simpleclass/simpleclass.png)

Obs.: Um dos objetivos deste experimento **NÃO** é a execução dos métodos de acesso, entretanto os métodos foram testados para o bom funcionamento das classes.

A classe **UserInfo** possui atributos acessáveis por meios de **getters** e **setters** públicos customizados e um método privado. 

Para a análise foi gerado **1.000.000 (um milhão)** de objetos em um ciclo e armazenados em uma lista.

Foram então medidos os tempos decorridos (em milisegundos) e armazenados em uma tabela.

### Resultados

Após a execução dos códigos, os seguintes resultados forma obtidos:

|scala(ms)|kotlin(ms)|java(ms)|ruby(ms)|python(ms)|typescript(ms)|r(ms)|csharp(ms)|
|---------|----------|--------|--------|----------|--------------|-----|----------|
|944|580|591|1023|1655|568|96414|1216|
|974|587|630|1022|1755|603|89957|1219|
|1000|523|668|1031|1755|578|86104|1208|
|971|645|622|1041|1648|563|88987|1191|
|1022|538|607|1051|1701|590|106592|1152|

Para a análise desses dados foi-se gerado uma média aritmética para cada linguágem, e seu resultado foi convertido em um gráfico do tipo **BarPlot** por meio da biblioteca ggplot2 do R.

![BarPlot SimpleClass](https://raw.githubusercontent.com/PedroDrim/Benchmark-Languages/master/outputs/simpleclass/benchmark_simpleclass.png)

### Premissas

1. Há uma possibilidade dos resultados obtidos não serem verídicos, pois cada resultado foi obtido dentro da propria linguágem testada.
2. O resultado obtido (em ms) do R foi muito elevado, tendo em vista que o R não possui suporte nativo para Orientação a Objetos se foi necessário o uso do pacote **R6** o que pode ter afetado o tempo significativamente. 
3. Kotlin obteve um dos melhores resultados, tendo em vista que é uma linguagem "nova" e melhor otimizada. 
