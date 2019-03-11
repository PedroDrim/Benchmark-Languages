package table

import(
	"os"
	"bufio"
	"fmt"
	"strings"
	"strconv"
	userInfo "model/userInfo"
)

// Estrutura para gerenciar uma tabela de usuarios
type Table struct {
	FileName string
	UserInfoList []userInfo.UserInfo
}

// Construtor publico da classe
// @param fileName Nome do arquivo .csv
func New(fileName string) Table {  
    e := Table {fileName, deserializeFile(fileName)}
    return e
}

// Método privado para conversão do arquivo .csv em uma lista de usuarios
// @param fileName Nome do arquivo
// @return Lista convertida de usuarios    
func deserializeFile(fileName string) []userInfo.UserInfo {
	file, _ := os.Open(fileName)
	scanner := bufio.NewScanner(file)

	defer file.Close()

	userInfoList := make([]userInfo.UserInfo, 0)

	// Eliminando primeira linha (cabecalho)
	var first bool = true

    for scanner.Scan() {
		if(!first) {
			line := scanner.Text()
			values := strings.Split(line, ",")

			credit, _ := strconv.ParseFloat(values[2], 64)
			user := userInfo.New(values[0], values[1], credit)
			userInfoList = append(userInfoList, user)	
		}
		
		first = false
	}
	
	fmt.Println(len(userInfoList))
	return userInfoList
}