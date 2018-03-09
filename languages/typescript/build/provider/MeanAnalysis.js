"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
var MeanAnalysis = (function () {
    function MeanAnalysis() {
    }
    MeanAnalysis.prototype.analysis = function (userInfoList) {
        var creditArray = userInfoList.map(function (userInfo) { return userInfo.getCredit(); });
        console.log(userInfoList[0]);
        var x = creditArray.reduce(function (sum, credit) { return sum += credit; }, 0);
        return x / (userInfoList.length);
    };
    return MeanAnalysis;
}());
exports.MeanAnalysis = MeanAnalysis;
//# sourceMappingURL=MeanAnalysis.js.map