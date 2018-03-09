package provider

import model.{SimpleTableAnalysis, UserInfo}

class MaxValueAnalysis extends SimpleTableAnalysis{

  override def analysis(userInfoList: List[UserInfo]): Double = {

    var max = Double.MinValue

    userInfoList.foreach { userInfo =>
      if(userInfo.credit > max) max = userInfo.credit
    }

    return max
  }
}
