package userinfo

import(
	"bytes"
)

type UserInfo struct {  
    User string
    Password string
    Credit float64
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
// @param credit Credito do usuario    
func New(user, password string, credit float64) UserInfo {  
    e := UserInfo {user, cryptPassword(password), credit}
    return e
}
