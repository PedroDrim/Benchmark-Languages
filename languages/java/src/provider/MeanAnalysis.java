package provider;

import model.SimpleTableAnalysis;
import model.UserInfo;

import java.util.List;

public class MeanAnalysis implements SimpleTableAnalysis {

    @Override
    public double analysis(List<UserInfo> userInfoList) {

        double sum = 0;
        for(UserInfo userInfo : userInfoList){
            sum += userInfo.getCredit();
        }
        return sum/userInfoList.size();
    }
}
