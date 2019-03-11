package minvalueanalysis

import(
	"math"
	userInfo "model/userInfo"
)

// Classe de analise que implementa a interface "SimpleTableAnalysis"
type MinValueAnalysis struct { }

// Construtor publico da classe
func New() MinValueAnalysis {  
    e := MinValueAnalysis {}
    return e
}

// Método responsável por obter o menor valor de credit na lista de usuarios
// @list Lista de usuarios
// @return Valor minimo da lista
func (obj MinValueAnalysis) Analysis(userInfoList []userInfo.UserInfo) float64 {
	minValue := math.MaxFloat64

	for i := range userInfoList {
		user := userInfoList[i]
		if user.Credit < minValue {
			minValue = user.Credit
		}
	}
	return minValue
}