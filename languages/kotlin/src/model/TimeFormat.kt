package model

/**
 * Formato de tempos disponiveis
 * @oaram proportion O valor de conversao em relacao a MILISSEGUNDOS
 */
enum class TimeFormat(val proportion: Double) {
    SEGUNDOS(0.001),
    MILISSEGUNDOS(1.0),
    NANOSSEGUNDOS(1000.0)
}