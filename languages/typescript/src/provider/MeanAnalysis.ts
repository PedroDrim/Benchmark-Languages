import { SimpleTableAnalysis } from '../model/SimpleTableAnalysis'
import { UserInfo } from '../model/UserInfo';

export class MeanAnalysis implements SimpleTableAnalysis {

    public analysis(userInfoList: Array<UserInfo>): number{

        var sum: number = 0.0;
        userInfoList.forEach(userInfo => sum += userInfo.getCredit() );

        return sum/(userInfoList.length);
    }
}