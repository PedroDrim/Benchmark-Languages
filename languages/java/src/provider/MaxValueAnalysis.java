package provider;

import model.SimpleTableAnalysis;
import model.UserInfo;

import java.util.List;

public class MaxValueAnalysis implements SimpleTableAnalysis {

    @Override
    public double analysis(List<UserInfo> userInfoList) {

        double max = Double.MIN_VALUE;
        for(UserInfo userInfo : userInfoList){
            double credit = userInfo.getCredit();
            if(max < credit) max = credit;
        }
        return max;
    }
}

