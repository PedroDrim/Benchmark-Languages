require './src/model/UserInfo.rb'

# Classe para gerenciar uma tabela de usuarios
class Table

    attr_reader :fileName 
    attr_reader :userInfoList

    # Construtor publico da classe
    # @param fileName Nome do arquivo .csv
    def initialize(fileName)
        @fileName = fileName
        @userInfoList = deserializeFile(@fileName)
    end

    # Método privado para conversão do arquivo .csv em uma lista de usuarios
    # @param fileName Nome do arquivo
    # @return Lista convertida de usuarios    
    private
    def deserializeFile(fileName) 
        
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