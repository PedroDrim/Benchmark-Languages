import {UserInfo} from './UserInfo'

export interface SimpleTableAnalysis {
    analysis(userInfoList: Array<UserInfo>): number
}