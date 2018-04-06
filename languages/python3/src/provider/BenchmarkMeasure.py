from src.model.BenchmarkOutput import BenchmarkOutput
from src.model.exception.InvalidParameterException import InvalidParameterException
from src.model.exception.DataReaderException import DataReaderException
from src.model.exception.BenchmarkException import BenchmarkException
from src.model.TimeFormat import TimeFormat

import time
import json

# Classe para captura de estados de tempo
# @see model.BenchmarkOutput
class BenchmarkMeasure(BenchmarkOutput):

    # Construtor publico da classe
    def __init__(self):
        self.__benchMap = {}
        self.__START_MARK = "_S"
        self.__END_MARK = "_E"

    # Inicio da captura de estado
    # @param tag Nome da captura referente
    def startState(self, tag):
        if(tag == None):
            raise InvalidParameterException("'tag' é None")

        bTime = time.time()
        sym = tag + self.__START_MARK
        self.__benchMap[sym] = bTime

    # Fim da captura de estado
    # @param tag Nome da captura referente
    def endState(self, tag):
        if(tag == None):
            raise InvalidParameterException("'tag' é None")

        bTime = time.time()
        sym = tag + self.__END_MARK
        self.__benchMap[sym] = bTime
    
    # Resultado da captura de estado especifica
    # @param tag Nome da captura referente
    # @param format Formato do resultado
    # @return Tempo decorrido entre o inicio e o fim da captura de estado
    def __resultByTag(self, tag, format):
        if(tag == None):
            raise InvalidParameterException("'tag' é None")

        if(format == None):
            raise InvalidParameterException("'format' é None")

        startSym = tag + self.__START_MARK
        endSym = tag + self.__END_MARK

        startTag = startSym in self.__benchMap
        endTag = endSym in self.__benchMap

        if(not startTag or not endTag):
            raise BenchmarkException("Não encontrado par 'inicio-fim' de:" + tag)

        startTime = self.__benchMap[startSym]
        endTime = self.__benchMap[endSym]
        
        return (endTime - startTime) * format.value
    
    # Resultado de todas as capturas de estado
    # @param format Formato do resultado
    # @return Mapa contendo o tempo decorrido entre o inicio e o fim da captura de estado para cada estado gerado.
    def __result(self, format):
        if(format == None):
            raise InvalidParameterException("'format' é None")

        mapResult = {}

        for key in self.__benchMap:
            tag = key.split("_")[0]
            time = self.__resultByTag(tag, format)
            mapResult[tag] = time

        return mapResult

    # Exporta o resultado no formato de um arquivo
    # @param fileName Nome do arquivo de saida
    # @param format Formato do resultado
    def export(self, fileName, format):

        if(fileName == None):
            raise InvalidParameterException("'fileName' é None")
        
        if(format == None):
            raise InvalidParameterException("'format' é None")

        mapResult = self.__result(format)
        serilizedString = json.dumps(mapResult)
        
        try:
            f = open(fileName, 'w')
            f.write(serilizedString)
            f.close()
        except:
            raise DataReaderException("Arquivo não encontrado:" + fileName)
