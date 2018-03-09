using System;
using inputclass.src.model;
using System.Collections.Generic;

namespace inputclass.src.provider {
    public class MaxValueAnalysis : SimpleTableAnalysis {

        public double analysis(List<UserInfo> list) {

            double max = double.MinValue;
            foreach(UserInfo userInfo in list) {
                if(max < userInfo.credit) max = userInfo.credit;
            }

            return max;
        }
    }
}