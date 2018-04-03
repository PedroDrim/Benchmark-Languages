# Criando uma classe "UserInfo"
class UserInfo

    # Definindo métodos getter e setter de "user"
    attr_accessor :user
    # Definindo método setter de "password"
    attr_writer :password
    # Definindo métodos getter e setter de "credit"
    attr_accessor :credit

    # Definindo construtor público da classe
    # user -> nome do usuário
    # password -> senha da conta
    # credit -> credito da conta
    def initialize(user, password, credit)
        @user = user
        @password = password
        @credit = credit
    end

    # Definindo método getter customizado de "password"
    def password
        return self.cryptPassord(@password)
    end

    # Método privado para encriptar senhas
    # password -> senha a ser encriptada
    # RETURN -> nova senha
    private 
    def cryptPassord(password)
        return "HASH#{password.reverse}000"
    end
end