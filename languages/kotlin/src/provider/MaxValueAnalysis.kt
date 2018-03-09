package provider

import box.UserInfo
import model.SimpleTableAnalysis

class MaxValueAnalysis: SimpleTableAnalysis {

    override fun analysis(userInfoList: List<UserInfo>): Double {
        var max: Double = Double.MIN_VALUE

        userInfoList.forEach {
            if(it.credit > max) max = it.credit
        }

        return max
    }
}