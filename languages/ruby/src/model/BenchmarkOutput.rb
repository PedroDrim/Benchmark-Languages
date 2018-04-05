require './src/model/TimeFormat.rb'

# Interface para captura de estados de tempo (benchmark)
module BenchmarkOutput

    # Inicio da captura de estado
    # @param tag Nome da captura referente
    def startState(tag)
        raise "Not implemented"
    end

    # Fim da captura de estado
    # @param tag Nome da captura referente
    def endState(tag)
        raise "Not implemented"
    end

    # Resultado da captura de estado especifica
    # @param tag Nome da captura referente
    # @param format Formato do resultado
    # @return Tempo decorrido entre o inicio e o fim da captura de estado
    def resultByTag(tag, format)
        raise "Not implemented"
    end

    # Resultado de todas as capturas de estado
    # @param format Formato do resultado
    # @return Mapa contendo o tempo decorrido entre o inicio e o fim da captura de estado para cada estado gerado.
    def result(format)
        raise "Not implemented"
    end

    # Exporta o resultado no formato de um arquivo
    # @param fileName Nome do arquivo de saida
    # @param format Formato do resultado
    def export(fileName, format)
        raise "Not implemented"
    end
end
