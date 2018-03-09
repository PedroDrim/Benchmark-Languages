from src.model.SimpleTableAnalysis import SimpleTableAnalysis
from src.model.UserInfo import UserInfo

class MinValueAnalysis(SimpleTableAnalysis):

    def analysis(self, userInfoList):
        vmin = 1000000000
        
        for userInfo in userInfoList:
            if(userInfo.getCredit() < vmin): 
                vmin = userInfo.getCredit()

        return vmin