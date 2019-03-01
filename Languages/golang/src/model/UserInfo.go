package userInfo

import (  
    "bytes"
)

type UserInfo struct {  
    user   string
    password    string
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

// Construtor publico da classe
// @param user Nome do usuario
// @param password Senha do usuario    
func New(user string, password string) UserInfo {  
    e := UserInfo {user, cryptPassword(password)}
    return e
}
