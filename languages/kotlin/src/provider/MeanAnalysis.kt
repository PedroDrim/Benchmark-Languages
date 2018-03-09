package provider

import box.UserInfo
import model.SimpleTableAnalysis

class MeanAnalysis: SimpleTableAnalysis {

    override fun analysis(userInfoList: List<UserInfo>): Double {
        var mean: Double = 0.0
        userInfoList.forEach {
            mean += it.credit
        }

        return mean/userInfoList.size
    }
}