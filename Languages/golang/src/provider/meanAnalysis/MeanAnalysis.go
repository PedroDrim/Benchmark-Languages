package meananalysis

import(
	userInfo "model/userInfo"
)

// Classe de analise que implementa a interface "SimpleTableAnalysis"
type MeanAnalysis struct { }

// Construtor publico da classe
func New() MeanAnalysis {  
    e := MeanAnalysis {}
    return e
}

// Método responsável por obter a media de valores de credit na lista de usuarios
// @list Lista de usuarios
// @return Media de valores de credit da lista
func (obj MeanAnalysis) Analysis(userInfoList []userInfo.UserInfo) float64 {
	var sum float64

	for i := range userInfoList {
		user := userInfoList[i]
		sum += user.Credit
	}
	return sum/float64(len(userInfoList))
}
