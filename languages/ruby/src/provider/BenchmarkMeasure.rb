require './src/model/BenchmarkOutput.rb'
require './src/model/exception/InvalidParameterException.rb'
require './src/model/exception/DataReaderException.rb'
require './src/model/exception/BenchmarkException.rb'
require './src/model/TimeFormat.rb'

require 'json'

# Classe para captura de estados de tempo
# @see model.BenchmarkOutput
class BenchmarkMeasure 
    include BenchmarkOutput

    # Construtor publico da classe
    def initialize
        @benchMap = Hash.new
        @START_MARK = "_S"
        @END_MARK = "_E"
    end

    # Inicio da captura de estado
    # @param tag Nome da captura referente
    def startState(tag)
        raise InvalidParameterException.new("'tag' é nil") if(tag.nil?)

        time = Time.now
        sym = tag + @START_MARK
        @benchMap[sym.to_sym] = time
    end

    # Fim da captura de estado
    # @param tag Nome da captura referente
    def endState(tag)
        raise InvalidParameterException.new("'tag' é nil") if(tag.nil?)

        time = Time.now
        sym = tag + @END_MARK
        @benchMap[sym.to_sym] = time
    end

    # Resultado da captura de estado especifica
    # @param tag Nome da captura referente
    # @param format Formato do resultado
    # @return Tempo decorrido entre o inicio e o fim da captura de estado
    def resultByTag(tag, format)
        raise InvalidParameterException.new("'tag' é nil") if(tag.nil?)
        raise InvalidParameterException.new("'format' é nil") if(format.nil?)

        startSym = tag + @START_MARK
        endSym = tag + @END_MARK

        startTag = @benchMap.key?(startSym.to_sym)
        endTag = @benchMap.key?(endSym.to_sym)

        raise BenchmarkException.new("Não encontrado par 'inicio-fim' de:" + tag) if(!startTag || !endTag)

        startTime = @benchMap[startSym.to_sym]
        endTime = @benchMap[endSym.to_sym]
        
        return (endTime - startTime) * format
    end

    # Resultado de todas as capturas de estado
    # @param format Formato do resultado
    # @return Mapa contendo o tempo decorrido entre o inicio e o fim da captura de estado para cada estado gerado.
    def result(format)
        raise InvalidParameterException.new("'format' é nil") if(format.nil?)

        mapResult = Hash.new

        @benchMap.each do |key, value|
            tag = key.to_s.split("_")[0]
            time = self.resultByTag(tag, format)
            mapResult[tag.to_sym] = time
        end

        return mapResult
    end

    # Exporta o resultado no formato de um arquivo
    # @param fileName Nome do arquivo de saida
    # @param format Formato do resultado
    def export(fileName, format)
        raise InvalidParameterException.new("'fileName' é nil") if(fileName.nil?)
        raise InvalidParameterException.new("'format' é nil") if(format.nil?)

        mapResult = self.result(format)
        serilizedString = mapResult.to_json
        
        begin
            File.write(fileName, serilizedString)
        rescue
            raise DataReaderException.new("Arquivo não encontrado:" + fileName)
        end

    end
end
