package provider

import model.{SimpleTableAnalysis, UserInfo}

class MinValueAnalysis extends SimpleTableAnalysis {

  override def analysis(userInfoList: List[UserInfo]): Double = {

    var min = Double.MaxValue

    userInfoList.foreach { userInfo =>
      if( userInfo.credit < min) min = userInfo.credit
    }

    return min
  }
}
