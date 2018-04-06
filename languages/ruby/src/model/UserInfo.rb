require './src/model/exception/InvalidParameterException.rb'

# Informacoes do usuario
class UserInfo

    # Construtor publico da classe
    # @param user Nome do usuario
    # @param password Senha do usuario
    # @param credit Quantidade de creditos do usuario
    def initialize(user, password, credit)

        raise InvalidParameterException.new("'user' é nil") if(user.nil?)
        raise InvalidParameterException.new("'password' é nil") if(password.nil?)
        raise InvalidParameterException.new("'credit' é nil") if(credit.nil?)

        @user = user
        @password = password
        @credit = credit
    end

    # Obtem o nome do usuario
    # @return Nome do usuario
    def getUser
        return @user
    end

    # Atualiza o nome do usuario
    # @param user Novo nome do usuario
    def setUser(user)
        raise InvalidParameterException.new("'user' é nil") if(user.nil?)
        @user = user
    end

    # Obtem a senha do usuario criptografada
    # @return Senha do usuario criptografada
    def getPassword
        return cryptPassword(@password)
    end

    # Atualiza a senha do usuario
    # @param password Nova senha do usuario
    def setPassword(password)
        raise InvalidParameterException.new("'password' é nil") if(password.nil?)
        @password = password
    end

    # Obtem a quantidade de creditos do usuario
    # @return Quantidade de creditos do usuario
    def getCredit
        return @credit.to_f
    end

    # Atualiza a quantidade de creditos do usuario
    # @param credit Nova quantidade de creditos do usuario
    def setCredit(credit)
        raise InvalidParameterException.new("'credit' é nil") if(credit.nil?)
        @credit = credit
    end

    # Metodo privado para encriptar a senha do usuario
    # @param password Senha a ser encriptada
    # @return Nova senha encriptada
    private 
    def cryptPassword(password)
        raise InvalidParameterException.new("'password' é nil") if(password.nil?)
        return "HASH#{password.reverse()}000"
    end
end
