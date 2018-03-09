from src.model.SimpleTableAnalysis import SimpleTableAnalysis
from src.model.UserInfo import UserInfo

class MaxValueAnalysis(SimpleTableAnalysis):

    def analysis(self, userInfoList):
        vmax = -1000000000
        
        for userInfo in userInfoList:
            if(userInfo.getCredit() > vmax): 
                vmax = userInfo.getCredit()

        return vmax