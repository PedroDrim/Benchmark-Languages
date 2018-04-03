require './exception/InvalidParameterException.rb'

# Informacoes do usuario
class UserInfo

    # Construtor publico da classe
    # @param user Nome do usuario
    # @param password Senha do usuario
    # @param credit Quantidade de creditos do usuario
    def initialize(user, password, credit) {

        if(user.isNil?) raise InvalidParameterException.new("'user' é null")
        if(password.isNil?) raise InvalidParameterException.new("'password' é null")
        if(credit.isNil?) raise InvalidParameterException.new("'credit' é null")

        @user = user
        @password = password
        @credit = credit
    }

    # Obtem o nome do usuario
    # @return Nome do usuario
    def getUser
        return @user
    end

    # Atualiza o nome do usuario
    # @param user Novo nome do usuario
    def setUser(user)
        raise InvalidParameterException.new("'user' é null") if(user.isNil?)
        @user = user
    end

    # Obtem a senha do usuario criptografada
    # @return Senha do usuario criptografada
    def getPassword
        return self.cryptPassword(@password)
    end

    # Atualiza a senha do usuario
    # @param password Nova senha do usuario
    def setPassword(password)
        raise InvalidParameterException.new("'password' é null") if(password.isNil?)
        this.password = password
    end

    # Obtem a quantidade de creditos do usuario
    # @return Quantidade de creditos do usuario
    def getCredit
        return @credit
    end

    # Atualiza a quantidade de creditos do usuario
    # @param credit Nova quantidade de creditos do usuario
    def setCredit(credit)
        @credit = credit
    end

    # Metodo privado para encriptar a senha do usuario
    # @param password Senha a ser encriptada
    # @return Nova senha encriptada
    private 
    def cryptPassword(password)
        raise InvalidParameterException.new("'password' é null") if(password.isNil?)
        return password.reverse();
    end
}
