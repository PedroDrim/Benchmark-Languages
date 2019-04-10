package userInfo

import (  
    "bytes"
)

type UserInfo struct {  
    _user   string
    _password    string
}

// Metodo privado para encriptar a senha do usuario
// @param password Senha a ser encriptada
// @return Nova senha encriptada
func cryptPassword(password string) string {
    runes := []rune(password)
    for i, j := 0, len(runes)-1; i < j; i, j = i+1, j-1 {
        runes[i], runes[j] = runes[j], runes[i]
    }

    var buffer bytes.Buffer
    buffer.WriteString("HASH")
    buffer.WriteString(string(runes))
    buffer.WriteString("000")

    return buffer.String()
}

// Atualiza a senha do usuario
// @param password Nova senha do usuario
func (this *UserInfo) SetUser(user string) {
    this._user = user
}

// Atualiza o nome do usuario
// @param user Novo nome do usuario
func (this *UserInfo) setPassword(password string) {
    this._password = password
}

// Obtem o nome do usuario
// @return Nome do usuario
func (this UserInfo) GetUser() string {
    return this._user
}

// Obtem a senha do usuario criptografada
// @return Senha do usuario criptografada
func (this UserInfo) GetPassword() string {
    return cryptPassword(this._password)
}

// Construtor publico da classe
// @param user Nome do usuario
// @param password Senha do usuario    
func New(user string, password string) UserInfo {  
    e := UserInfo {user, password}
    return e
}
