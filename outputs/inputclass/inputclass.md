# InputClass

### Introdução

O objetivo deste experimento é gerar um conjunto de classe para ler um arquivo de entrada e realizar uma análise com base nele, conforme o diagrama UML abaixo:

![UML UserInfo](https://raw.githubusercontent.com/PedroDrim/Benchmark-Languages/master/outputs/inputclass/inputclass.png)

Obs.: Um dos objetivos deste experimento **NÃO** é a execução dos métodos de acesso, entretanto os métodos foram testados para o bom funcionamento das classes.

A classe **UserInfo** possui atributos acessáveis por meios de **getters** e **setters** públicos customizados e um método privado. 

A classe **Table** é responsável por gerar uma lista de **UserInfo** com base em uma tabela csv.

A interface **SimpleTableAnalysis** foi gerada para testar o uso de interfaces nas linguagens em estudo, além de possibilitar a implementação de simples análises estatísticas:

* Classe **MaxValueAnalysis**: Obtem o maior valor da variável **credit** em uma lista de **UserInfo**.
* Classe **MinValueAnalysis**: Obtem o menor valor da variável **credit** em uma lista de **UserInfo**.
* Classe **MeanAnalysis**: Obtem a média da variável **credit** em uma lista de **UserInfo**.

Para a análise foram gerados 4 (quatro) tabelas csv's com os seguintes tamanhos:

* **1.000 (mil)** elementos, nomeado como **inputclass_1e+03.csv**.
* **10.000 (dez mil)** elementos, nomeado como **inputclass_1e+04.csv**.
* **100.000 (cem mil)** elementos, nomeado como **inputclass_1e+05.csv**.
* **1.000.000 (um milhão)** elementos, nomeado como **inputclass_1e+06.csv**.

Foram então medidos os tempos decorridos (em milisegundos) para a leitura e análise das tabelas.

### Resultados

Após a execução dos códigos, os seguintes resultados forma obtidos, e os resultados foram armazenados no seguinte formato e separados por uma linha em branco:

```
Identificador: typescript_8_inputclass_1e+06
Tempo de leitura (ms): 1333
Tempo de analise (ms): 214
Max: 488.21
Min: 0
Mean: 79.81197250999965
```

Para a análise desses dados foi-se gerado uma tabela contendo a média aritmética para cada linguagem em cada arquivo.

|file|language|leitura (ms)|analise (ms)|max|min|mean|
|----|--------|-------|-------|---|---|----|
|inputclass_1e+03|java|42.6|1.9|381.03|0.11|82.35602|
|inputclass_1e+04|java|110.5|10.7|381.03|0|80.6211560000001|
|inputclass_1e+05|java|394.8|34.8|454.21|0|80.0389994000004|
|inputclass_1e+06|java|1424.9|98.3|488.21|0|79.8119725099996|
|inputclass_1e+03|kotlin|129.4|3.4|381.03|0.11|82.35602|
|inputclass_1e+04|kotlin|274.6|13.1|381.03|0|80.6211560000001|
|inputclass_1e+05|kotlin|548.7|44.6|454.21|0|80.0389994000004|
|inputclass_1e+06|kotlin|1898.1|121.3|488.21|0|79.8119725099996|
|inputclass_1e+03|scala|0.2|22.5|381.03|0.11|82.35602|
|inputclass_1e+04|scala|0.1|27.8|381.03|0|80.6211560000001|
|inputclass_1e+05|scala|0.2|53.4|454.21|0|80.0389994000004|
|inputclass_1e+06|scala|0|233.333333333333|488.21|0|79.8119725099996|
|inputclass_1e+03|ruby|3.716445|0.2379445|381.03|0.11|82.35602|
|inputclass_1e+04|ruby|32.9111117|2.5407591|381.03|0|80.6211560000001|
|inputclass_1e+05|ruby|311.2645592|34.0162835|454.21|0|80.0389994000004|
|inputclass_1e+06|ruby|3361.9450035|387.510449|488.21|0|79.8119725099996|
|inputclass_1e+03|python|92.9544687271118|0.601363182067871|381.03|0.11|82.35602|
|inputclass_1e+04|python|806.33864402771|5.70666790008545|381.03|0|80.6211560000001|
|inputclass_1e+05|python|8141.7364358902|55.7748794555664|454.21|0|80.0389994000004|
|inputclass_1e+06|python|82671.4838027954|565.935587882996|488.21|0|79.8119725099996|
|inputclass_1e+03|csharp|3.4|1|381.03|0.11|82.35602|
|inputclass_1e+04|csharp|10.6|2.2|381.03|0|80.6211560000001|
|inputclass_1e+05|csharp|129.5|6.7|454.21|0|80.0389994000004|
|inputclass_1e+06|csharp|1522.3|81.5|488.21|0|79.8119725099996|
|inputclass_1e+03|r|218.098092079162|11.658763885498|381.03|0.11|82.35602|
|inputclass_1e+04|r|1278.32005023956|147.658896446228|381.03|0|80.621156|
|inputclass_1e+05|r|12071.0110664368|1220.36745548248|454.21|0|80.0389994|
|inputclass_1e+06|r|158446.351289749|30882.8369379044|488.21|0|79.81197251|
|inputclass_1e+03|typescript|12.8|1.5|381.03|0.11|82.35602|
|inputclass_1e+04|typescript|23.5|2.7|381.03|0|80.6211560000001|
|inputclass_1e+05|typescript|130.8|10.5|454.21|0|80.0389994000004|
|inputclass_1e+06|typescript|1374.44444444444|213.888888888889|488.21|0|79.8119725099996|

Tabela esta que foi convertida em um gráfico do tipo **BarPlot** por meio da biblioteca ggplot2 do R.

![BarPlot InputClass 1000 elementos](https://raw.githubusercontent.com/PedroDrim/Benchmark-Languages/master/outputs/inputclass/benchmark_13+03_inputclass.png)

![BarPlot InputClass 10000 elementos](https://raw.githubusercontent.com/PedroDrim/Benchmark-Languages/master/outputs/inputclass/benchmark_13+03_inputclass.png)

![BarPlot InputClass 100000 elementos](https://raw.githubusercontent.com/PedroDrim/Benchmark-Languages/master/outputs/inputclass/benchmark_13+03_inputclass.png)

![BarPlot InputClass 1000000 elementos](https://raw.githubusercontent.com/PedroDrim/Benchmark-Languages/master/outputs/inputclass/benchmark_13+03_inputclass.png)

### Premissas

1. Há uma possibilidade dos resultados obtidos não serem verídicos, pois cada resultado foi obtido dentro da propria linguagem testada.
2. Assim como no experimento anterior, o resultado obtido (em ms) do R utilizando o pacote **R6** foi muito elevado, deverei tentar outras abordagens de forma a otimizar seus recursos. 
3. Scala obteve o melhor resultado para leitura dos arquivos, entretanto foi o typescript que obteve melhor desempenho para a análise.
