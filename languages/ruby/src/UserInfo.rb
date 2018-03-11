# Criando uma classe "UserInfo"
class UserInfo

    # Definindo métodos getter e setter da variável "user"
    # instance.user, para getter
    # instance.user = valor, para setter
    attr_accessor :user

    # Definindo método getter da variável "password"
    # instance.password, para getter
    attr_writer :password

    # Definindo construtor público da classe
    # user -> nome do usuário
    # password -> senha do usuário    
    def initialize(user, password)
        @user = user
        @password = password
    end

    # Definindo método setter customizado da variável "password"
    # instance.password = valor, para setter    
    def password
        return self.cryptPassord(@password)
    end

    # Método privado para encriptar a variável 'password'
    # password: String -> senha do usuário
    # RETURN: String -> senha encriptada
    private 
    def cryptPassord(password)
        return "HASH#{password.reverse}000"
    end
end