require './src/model/SimpleTableAnalysis.rb'

class MinValueAnalysis
    include SimpleTableAnalysis

    def analysis(userInfoList)

        min = 1_000_000_000

        userInfoList.each do |userInfo|
            if(userInfo.credit < min) 
                min = userInfo.credit
            end
        end

        return min
    end
end