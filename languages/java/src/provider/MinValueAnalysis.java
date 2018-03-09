package provider;

import model.SimpleTableAnalysis;
import model.UserInfo;

import java.util.List;

public class MinValueAnalysis implements SimpleTableAnalysis {

    @Override
    public double analysis(List<UserInfo> userInfoList) {
        double min = Double.MAX_VALUE;
        for(UserInfo userInfo : userInfoList){
            double credit = userInfo.getCredit();
            if(min > credit) min = credit;
        }
        return min;
    }
}

