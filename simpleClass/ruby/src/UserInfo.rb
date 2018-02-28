class UserInfo

    attr_accessor :user
    attr_writer :password

    def initialize(user, password)
        @user = user
        @password = password
    end

    def password
        return self.cryptPassord(@password)
    end

    private 
    def cryptPassord(password)
        return "HASH#{password.reverse}000"
    end
end