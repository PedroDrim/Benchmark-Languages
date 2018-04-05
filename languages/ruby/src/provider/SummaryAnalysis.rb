require './src/model/TableAnalysis.rb'
require './src/model/exception/InvalidParameterException.rb'
require './src/model/UserInfo.rb'

# Classe para analise de dados, obtem os valores maximo e minimo dos creditos dos usuarios
# @see model.TableAnalysis
class SummaryAnalysis 
    include TableAnalysis
    
    # Realiza a analise maxima e minima dos dados
    # @param userInfoList Lista de dados a ser analisada
    # @return Valores maximo e minimo dos creditos
    # @see TableAnalysis
    def analysis(userInfoList)
        if(userInfoList.nil? || userInfoList.size == 0)
            raise InvalidParameterException.new("'userInfoList' é nil ou vazio")
        end

        max = -1_000_000_000
        min = -1_000_000_000
        sum = 0

        userInfoList.each do |userInfo|
            sum += userInfo.getCredit
            max = userInfo.getCredit if(userInfo.getCredit > max) 
            min = userInfo.getCredit if(userInfo.getCredit > min)             
        end
    
        mean = sum/userInfoList.size

        return [min, max, mean]
    end
end

