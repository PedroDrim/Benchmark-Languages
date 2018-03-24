package provider

import java.io.{File, PrintWriter}

import com.google.gson.GsonBuilder
import model.BenchmarkOutput
import model.TimeFormat.TimeFormat

import scala.collection.mutable

/**
  * Classe para captura de estados de tempo
  * @see model.BenchmarkOutput
  */
class BenchmarkMeasure extends BenchmarkOutput {

  private val START_MARK = "_S"
  private val END_MARK = "_E"
  private var _benchMap = new mutable.HashMap[String, Double]()

  /**
    * Inicio da captura de estado
    * @param tag Nome da captura referente
    * @see BenchmarkOutput
    */
  override def start(tag: String): Unit = {
    val time = System.currentTimeMillis().toDouble
    _benchMap += (tag + START_MARK -> time)
  }

  /**
    * Fim da captura de estado
    * @param tag Nome da captura referente
    * @see BenchmarkOutput
    */
  override def end(tag: String): Unit = {
    val time = System.currentTimeMillis().toDouble
    _benchMap += (tag + END_MARK -> time)
  }

  /**
    * Resultado da captura de estado especifica
    * @param tag    Nome da captura referente
    * @param format Formato do resultado
    * @return Tempo decorrido entre o inicio e o fim da captura de estado
    * @see BenchmarkOutput
    */
  override def result(tag: String, format: TimeFormat): Double = {
    val start = _benchMap.get(tag + START_MARK)
    val end = _benchMap.get(tag + END_MARK)
    val proportion = format.toString.toDouble

    return (end.get - start.get) * proportion
  }

  /**
    * Resultado de todas as capturas de estado
    * @param format Formato do resultado
    * @return Mapa contendo o tempo decorrido entre o inicio e o fim da captura de estado para cada estado gerado.
    * @see BenchmarkOutput
    */
  override def result(format: TimeFormat): Map[String, Double] = {
    var mapResult = new mutable.HashMap[String, Double]()
    val tagSet = this._benchMap.keySet

    tagSet.foreach { tagMark =>
      val tag = tagMark.split("_")(0)
      val time = this.result(tag, format)
      mapResult += (tag -> time)
    }

    return mapResult.toMap
  }

  /**
    * Exporta o resultado no formato de um arquivo
    * @param fileName Nome do arquivo de saida
    * @param format   Formato do resultado
    * @see BenchmarkOutput
    */
  override def export(fileName: String, format: TimeFormat): Unit = {

    val builder = new GsonBuilder
    val gson = builder.create

    val mapResult = this.result(format)
    val serilizedString = gson.toJson(mapResult)

    val printWriter = new PrintWriter( new File(fileName))
    printWriter.println(serilizedString)
    printWriter.close()
  }
}
