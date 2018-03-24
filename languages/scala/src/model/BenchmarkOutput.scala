package model

import model.TimeFormat.TimeFormat

/**
  * Interface para captura de estados de tempo (benchmark)
  */
trait BenchmarkOutput {

  /**
    * Inicio da captura de estado
    * @param tag Nome da captura referente
    */
  def start(tag: String)

  /**
    * Fim da captura de estado
    * @param tag Nome da captura referente
    */
  def end(tag: String)

  /**
    * Resultado da captura de estado especifica
    * @param tag Nome da captura referente
    * @param format Formato do resultado
    * @return Tempo decorrido entre o inicio e o fim da captura de estado
    */
  def result(tag: String, format: TimeFormat): Double

  /**
    * Resultado de todas as capturas de estado
    * @param format Formato do resultado
    * @return Mapa contendo o tempo decorrido entre o inicio e o fim da captura de estado para cada estado gerado.
    */
  def result(format: TimeFormat): Map[String, Double]

  /**
    * Exporta o resultado no formato de um arquivo
    * @param fileName Nome do arquivo de saida
    * @param format Formato do resultado
    */
  def export(fileName: String, format: TimeFormat)
}
