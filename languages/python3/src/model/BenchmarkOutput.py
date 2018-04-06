from src.model.TimeFormat import TimeFormat

# Interface para captura de estados de tempo (benchmark)
class BenchmarkOutput:

    # Inicio da captura de estado
    # @param tag Nome da captura referente
    def startState(self, tag):
        raise NotImplementedError()

    # Fim da captura de estado
    # @param tag Nome da captura referente
    def endState(self, tag):
        raise NotImplementedError()

    # Resultado da captura de estado especifica
    # @param tag Nome da captura referente
    # @param format Formato do resultado
    # @return Tempo decorrido entre o inicio e o fim da captura de estado
    def resultByTag(self, tag, format):
        raise NotImplementedError()

    # Resultado de todas as capturas de estado
    # @param format Formato do resultado
    # @return Mapa contendo o tempo decorrido entre o inicio e o fim da captura de estado para cada estado gerado.
    def result(self, format):
        raise NotImplementedError()

    # Exporta o resultado no formato de um arquivo
    # @param fileName Nome do arquivo de saida
    # @param format Formato do resultado
    def export(self, fileName, format):
        raise NotImplementedError()
