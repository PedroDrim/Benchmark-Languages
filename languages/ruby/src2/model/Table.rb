# Importando bibliotecas
require './src/model/UserInfo.rb'

# Criando uma classe "Table"
class Table

    # Definindo método getter de "fileName"
    attr_reader :fileName 
    # Definindo método getter de "userInfoList"
    attr_reader :userInfoList

    # Construtor publico da classe
    # fileName -> Nome do arquivo .csv
    def initialize(fileName)
        @fileName = fileName
        @userInfoList = deserializeFile(@fileName)
    end

    # Método privado para conversão do arquivo .csv em uma lista de "UserInfo"
    # fileName -> Nome do arquivo
    # RETURN -> Lista convertida de "UserInfo"    
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