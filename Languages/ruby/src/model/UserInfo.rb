# Informacoes do usuario
class UserInfo

    attr_accessor :user
    attr_accessor :credit
    attr_writer :password

    # Construtor publico da classe
    # @param user Nome do usuario
    # @param credit Credito do usuario
    # @param password Senha do usuario    
    def initialize(user, password, credit)
        @user = user
        @credit = credit
        @password = password
    end

    # Obtem a senha do usuario criptografada
    # @return Senha do usuario criptografada
    def password
        return self.cryptPassord(@password)
    end

    # Metodo privado para encriptar a senha do usuario
    # @param password Senha a ser encriptada
    # @return Nova senha encriptada
    private 
    def cryptPassord(password)
        return "HASH#{password.reverse}000"
    end
end