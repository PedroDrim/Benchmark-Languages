"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
var MaxValueAnalysis = (function () {
    function MaxValueAnalysis() {
    }
    MaxValueAnalysis.prototype.analysis = function (userInfoList) {
        var max = Number.MIN_VALUE;
        userInfoList.forEach(function (userInfo) {
            if (max < userInfo.getCredit())
                max = userInfo.getCredit();
        });
        return max;
    };
    return MaxValueAnalysis;
}());
exports.MaxValueAnalysis = MaxValueAnalysis;
//# sourceMappingURL=MaxValueAnalysis.js.map