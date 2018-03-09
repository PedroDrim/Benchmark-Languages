from src.model.SimpleTableAnalysis import SimpleTableAnalysis
from src.model.UserInfo import UserInfo

class MeanAnalysis(SimpleTableAnalysis):

    def analysis(self, userInfoList):
        vsum = 0

        for userInfo in userInfoList:
            vsum += userInfo.getCredit()

        return vsum/len(userInfoList)
