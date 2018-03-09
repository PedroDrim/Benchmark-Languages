using inputclass.src.model;
using System.Collections.Generic;

namespace inputclass.src.provider {
    public class MeanAnalysis : SimpleTableAnalysis {

        public double analysis(List<UserInfo> list) {

            double sum = 0;
            foreach(UserInfo userInfo in list) {
                sum += userInfo.credit;
            }

            return sum/list.Count;
        }
    }
}