using inputclass.src.model;
using System.Collections.Generic;

namespace inputclass.src.provider {
    public class MinValueAnalysis : SimpleTableAnalysis {

        public double analysis(List<UserInfo> list) {

            double min = double.MaxValue;
            foreach(UserInfo userInfo in list) {
                if(min > userInfo.credit) min = userInfo.credit;
            }

            return min;
        }
    }
}