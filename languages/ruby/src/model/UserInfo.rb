class UserInfo

    attr_accessor :user
    attr_writer :password
    attr_accessor :credit

    def initialize(user, password, credit)
        @user = user
        @password = password
        @credit = credit
    end

    def password
        return self.cryptPassord(@password)
    end

    private 
    def cryptPassord(password)
        return "HASH#{password.reverse}000"
    end
end