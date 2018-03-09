require './src/model/SimpleTableAnalysis.rb'

class MaxValueAnalysis
    include SimpleTableAnalysis

    def analysis(userInfoList)

        max = -1000_000_000

        userInfoList.each do |userInfo|
            if(userInfo.credit > max) 
                max = userInfo.credit
            end
        end

        return max
    end
end