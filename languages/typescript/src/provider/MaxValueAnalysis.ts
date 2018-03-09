import { SimpleTableAnalysis } from '../model/SimpleTableAnalysis'
import { UserInfo } from '../model/UserInfo';

export class MaxValueAnalysis implements SimpleTableAnalysis {

    public analysis(userInfoList: Array<UserInfo>): number{

        var max: number = Number.MIN_VALUE;

        userInfoList.forEach(userInfo => {
            if(max < userInfo.getCredit()) max = userInfo.getCredit()
        });

        return max;
    }
}