package provider

import java.io.{File, FileNotFoundException, PrintWriter}

import com.google.gson.GsonBuilder
import model.BenchmarkOutput
import model.TimeFormat.TimeFormat
import model.exception.{BenchmarkException, DataReaderException, InvalidParameterException}

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
    if (tag == null) throw new InvalidParameterException("'tag' é null")

    val time = System.currentTimeMillis().toDouble
    _benchMap += (tag + START_MARK -> time)
  }

  /**
    * Fim da captura de estado
    * @param tag Nome da captura referente
    * @see BenchmarkOutput
    */
  override def end(tag: String): Unit = {
    if (tag == null) throw new InvalidParameterException("'tag' é null")

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
    if (tag == null) throw new InvalidParameterException("'tag' é null")
    if (format == null) throw new InvalidParameterException("'format' é null")

    val startTag = _benchMap.contains(tag + START_MARK)
    val endTag = _benchMap.contains(tag + END_MARK)

    if (!startTag || !endTag) throw new BenchmarkException("Não encontrado par 'inicio-fim' de:" + tag)

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
    if (format == null) throw new InvalidParameterException("'format' é null")

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
    if (fileName == null) throw new InvalidParameterException("'fileName' é null")
    if (format == null) throw new InvalidParameterException("'format' é null")

    val builder = new GsonBuilder
    val gson = builder.create

    val mapResult = this.result(format)
    val serilizedString = gson.toJson(mapResult)

    try {
      val printWriter = new PrintWriter(new File(fileName))
      printWriter.println(serilizedString)
      printWriter.close()
    } catch {
      case e: FileNotFoundException => throw new DataReaderException("Arquivo nao encontrado: " + fileName, e)
    }
  }
}
