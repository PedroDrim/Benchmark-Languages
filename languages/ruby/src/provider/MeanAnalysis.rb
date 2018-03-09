require './src/model/SimpleTableAnalysis.rb'

class MeanAnalysis
    include SimpleTableAnalysis

    def analysis(userInfoList)
        mean = 0

        userInfoList.each do |userInfo|
            mean += userInfo.credit
        end

        return mean/userInfoList.size
    end
end