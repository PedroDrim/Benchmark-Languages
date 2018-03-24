package model;

/**
 * Formato de tempos disponiveis
 */
public enum TimeFormat {
    SEGUNDOS(0.001),
    MILLISEGUNDOS(1),
    NANOSSEGUNDOS(1000);

    /**
     * Valor de conversao
     */
    private double valor;

    /**
     * Construtor do Enum
     * @param valor Valor de conversao
     */
    TimeFormat(double valor) {
        this.valor = valor;
    }

    /**
     * Obtem o valor de conversao
     * @return Valor de conversao
     */
    public double getValor() {
        return valor;
    }
}
