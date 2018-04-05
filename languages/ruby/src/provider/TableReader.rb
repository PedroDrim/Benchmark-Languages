require "./src/model/UserInfo.rb"
require './src/model/exception/InvalidParameterException.rb'
require './src/model/exception/DataReaderException.rb'
require './src/model/DataReader.rb'

# Classe responsavel por ler e disponibilizar os dados em um formato desejado
# @see model.DataReader
class TableReader 
    include DataReader

    # Construtor publico da classe
    # @param fileName Nome do arquivo de dados a ser lido
    # @throws DataReaderException Lancada caso nao seja possivel ler os dados corretamente
    def initialize(fileName)
        raise InvalidParameterException.new "'fileName' é nil"  if(fileName.nil?)

        @fileName = fileName
        @userInfoList = self.deserializeFile(fileName)
    end

    # Obtem o nome do arquivo de dados a ser lido
    # @return Nome do arquivo de dados a ser lido
    def getFileName
        return @fileName
    end

    # Obtem todos os dados disponiveis
    # @return Lista contendo todos os dados disponiveis
    def readAll
        return @userInfoList
    end

    # Obtem os dados disponiveis dentro de um intervalo
    # @param startIndex Inicio do intervalo
    # @param endIndex Fim do intervalo
    # @return Lista contendo todos os dados disponiveis dentro do intervalo especificado
    def read(startIndex, endIndex)
        raise InvalidParameterException.new("'startIndex' é menor que 0") if(startIndex < 0)
        raise InvalidParameterException.new("'endIndex' é menor que 0") if(endIndex < 0)
        raise InvalidParameterException.new("'startIndex' é maior ou igual á 'endIndex'") if(startIndex >= endIndex)

        return @userInfoList[startIndex..endIndex]
    end

    # Desserializa o arquivo de dados, convertendo-o em uma lista de 'UserInfo'
    # @param fileName Nome do arquivo de dados
    # @return Lista contendo os dados desserilizados
    # @throws DataReaderException Lancada caso nao seja possivel ler os dados corretamente
    def deserializeFile(fileName)
        raise InvalidParameterException("'fileName' é nil") if(fileName.nil?)

        lines = File.open(fileName).drop(1)
        
        lines.map do |line|

            values = line.chop.split(",")

            user = values[0].delete(" ")
            password = values[1].delete(" ")
            credit = values[2].delete(" ").to_f

            UserInfo.new(user, password, credit)
        end
    end
end
