package provider

import box.UserInfo
import model.SimpleTableAnalysis

class MinValueAnalysis: SimpleTableAnalysis {

    override fun analysis(userInfoList: List<UserInfo>): Double {
        var min: Double = Double.MAX_VALUE

        userInfoList.forEach {
            if(it.credit < min) min = it.credit
        }

        return min
    }
}