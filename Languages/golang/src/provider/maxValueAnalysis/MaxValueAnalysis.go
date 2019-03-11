package maxvalueanalysis

import(
	"math"
	userInfo "model/userInfo"
)

// Classe de analise que implementa a interface "SimpleTableAnalysis"
type MaxValueAnalysis struct { }

// Construtor publico da classe
func New() MaxValueAnalysis {  
    e := MaxValueAnalysis {}
    return e
}

// Método responsável por obter o maior valor de credit na lista de usuarios
// @list Lista de usuarios
// @return Valor maximo da lista
func (obj MaxValueAnalysis) Analysis(userInfoList []userInfo.UserInfo) float64 {
	maxValue := math.SmallestNonzeroFloat64

	for i := range userInfoList {
		user := userInfoList[i]
		if user.Credit > maxValue {
			maxValue = user.Credit
		}
	}
	return maxValue
}
