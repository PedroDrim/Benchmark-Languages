from src.provider.TableReader import TableReader
from src.model.BenchmarkOutput import BenchmarkOutput
from src.provider.BenchmarkMeasure import BenchmarkMeasure
from src.model.TableAnalysis import TableAnalysis
from src.provider.SummaryAnalysis import SummaryAnalysis
from src.provider.BubbleSortAnalysis import BubbleSortAnalysis
from src.provider.QuickSortAnalysis import QuickSortAnalysis
from src.provider.LanguageSortAnalysis import LanguageSortAnalysis
from src.model.UserInfo import UserInfo
from src.model.TimeFormat import TimeFormat
from src.model.exception.InvalidParameterException import InvalidParameterException

import json

class Start:

    def __init__(self):

        configFile = "./config.json"
        properties = self.__getConfig(configFile)

        bInput = properties["INPUT_FILENAME"]
        bOutput = properties["OUTPUT_FILENAME"]

        benchmark = BenchmarkMeasure()

        summaryAnalysis = SummaryAnalysis()
        bubbleSortAnalysis = BubbleSortAnalysis()
        quickSortAnalysis = QuickSortAnalysis()
        languageSortAnalysis = LanguageSortAnalysis()

        #==================================================
        # Leitura dos dados
        benchmark.startState("Read")
        tableReader = TableReader(bInput)
        bList = tableReader.readAll()
        benchmark.endState("Read")
        #==================================================
        # Analise dos dados (Summary)
        benchmark.startState("SummaryAnalyse")
        summary = summaryAnalysis.analysis(bList)
        benchmark.endState("SummaryAnalyse")
        #==================================================
        # Analise dos dados (Bubble)
        benchmark.startState("BubbleAnalyse")
        bubble =  bubbleSortAnalysis.analysis(bList)
        benchmark.endState("BubbleAnalyse")
        #==================================================
        # Analise dos dados (Quick)
        benchmark.startState("QuickAnalyse")
        quick =  quickSortAnalysis.analysis(bList)
        benchmark.endState("QuickAnalyse")
        #==================================================
        # Analise dos dados (Language)
        benchmark.startState("LanguageAnalyse")
        lang = languageSortAnalysis.analysis(bList)
        benchmark.endState("LanguageAnalyse")
        #==================================================

        benchmark.export(bOutput, TimeFormat.MILLISEGUNDOS)

    def __getConfig(self, fileName):
        f = open(fileName, 'r')
        serializedJson = f.read()
        f.close()

        obj = json.loads(serializedJson)
        return obj

Start()