package model

import box.UserInfo

interface SimpleTableAnalysis {

    fun analysis(userInfoList: List<UserInfo>): Double
}