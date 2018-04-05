require './src/model/TableAnalysis.rb'
require './src/model/UserInfo.rb'
require './src/model/exception/InvalidParameterException.rb'

# Classe para ordenacao bubbleSort
# @see model.TableAnalysis
class BubbleSortAnalysis
    include TableAnalysis

    # Realiza uma ordenacao bubbleSort
    # @param userInfoList Lista de dados a ser analisada
    # @return Elemento aleatorio da lista
    # @see TableAnalysis
    def analysis(userInfoList)
        if(userInfoList.nil? || userInfoList.size == 0)
            raise InvalidParameterException.new("'userInfoList' é nil ou vazio")
        end

        aux = nil
        size = userInfoList.size

        for index1 in 0...size
            for index2 in 1...(size - index1)

                user1 = userInfoList[index2];
                user2 = userInfoList[index2 - 1];

                if user1.getCredit() > user2.getCredit()
                    aux = user1;
                    user1 = user2;
                    user2 = aux;

                    userInfoList[index2] = user1;
                    userInfoList[index2 - 1] = user2;
                end
            end
        end

        return userInfoList;
    end
end