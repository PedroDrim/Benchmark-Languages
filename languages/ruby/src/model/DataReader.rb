require './UserInfo.rb'

# Interface para leitura de dados
def DataReader

    # Obtem todos os dados disponiveis
    # @return Lista contendo todos os dados disponiveis
    def read()
        raise "Not implemented"
    end

    # Obtem os dados disponiveis dentro de um intervalo
    # @param startIndex Inicio do intervalo
    # @param endIndex Fim do intervalo
    # @return Lista contendo todos os dados disponiveis dentro do intervalo especificado
    def read(startIndex, endIndex)
        raise "Not implemented"
    end
end
