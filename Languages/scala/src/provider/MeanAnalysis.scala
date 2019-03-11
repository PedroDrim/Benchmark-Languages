package provider

import model.{SimpleTableAnalysis, UserInfo}

class MeanAnalysis extends SimpleTableAnalysis {

  override def analysis(userInfoList: List[UserInfo]): Double = {

    var sum: Double = 0.0

    userInfoList.foreach(sum += _.credit)

    return sum/userInfoList.length
  }
}
