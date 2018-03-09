import {SimpleTableAnalysis} from '../model/SimpleTableAnalysis'
import { UserInfo } from '../model/UserInfo';

export class MinValueAnalysis implements SimpleTableAnalysis {

    public analysis(userInfoList: Array<UserInfo>): number{

        var min: number = Number.MAX_VALUE;

        userInfoList.forEach(userInfo => {
            if(min > userInfo.getCredit()) min = userInfo.getCredit()
        });

        return min;
    }
}