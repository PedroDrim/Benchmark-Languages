require './src/model/UserInfo.rb'

class Table

    attr_reader :fileName 
    attr_reader :userInfoList

    def initialize(fileName)
        @fileName = fileName
        @userInfoList = deserializeFile(@fileName)
    end

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