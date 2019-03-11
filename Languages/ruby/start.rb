require './src/model/Table.rb'
require './src/provider/MaxValueAnalysis.rb'
require './src/provider/MinValueAnalysis.rb'
require './src/provider/MeanAnalysis.rb'
require './src/model/UserInfo.rb'

# Classe inicial do sistema
class Start

    # Método de inicialização do projeto
    # @param args Lista de parametros obtidos via console
    def initialize(args)

        fileName = getParam(args)       

        # Obtendo o tempo inicial de leitura em milissegundos
        leitura_inicio = Time.now

        # Convertendo arquivo em lista de "UserInfo"
        table = Table.new(fileName)

        # Obtendo o tempo final de leitura em milissegundos
        leitura_fim = Time.now

        list = table.userInfoList

        maxValue = MaxValueAnalysis.new
        minValue = MinValueAnalysis.new
        meanValue = MeanAnalysis.new

        # Obtendo o tempo inicial de analise em milissegundos
        analise_inicio = Time.now

        # Realizando analises
        max = maxValue.analysis(list)
        min = minValue.analysis(list)
        mean = meanValue.analysis(list)

        # Obtendo o tempo final de analise em milissegundos
        analise_fim = Time.now

        # Dados de saida
        print("[OK]Arquivo: #{fileName}\n")
        print("[OK]Tempo_leitura: #{(leitura_fim - leitura_inicio)*1000.0} ms\n")
        print("[OK]Tempo_analise: #{(analise_fim - analise_inicio)*1000.0} ms\n")
        print("[OK]Max: #{max}\n")
        print("[OK]Min: #{min}\n")
        print("[OK]Mean: #{mean}\n")
    end

    private
    # Método para captura e tratamento dos parametros obtidos via console
    # @param codes Lista de parametros obtidos via console
    # @return Tamanho de usuários á serem gerados
    def getParam(codes)
        if(codes.size != 1)
            print("Parametros inválidos.\n")
            exit(-1)
        end
            
        line = codes[0].to_s
    
        return line    
    end
end

Start.new(ARGV)
