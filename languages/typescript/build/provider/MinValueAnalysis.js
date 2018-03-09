"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
var MinValueAnalysis = (function () {
    function MinValueAnalysis() {
    }
    MinValueAnalysis.prototype.analysis = function (userInfoList) {
        var min = Number.MAX_VALUE;
        userInfoList.forEach(function (userInfo) {
            if (min > userInfo.getCredit())
                min = userInfo.getCredit();
        });
        return min;
    };
    return MinValueAnalysis;
}());
exports.MinValueAnalysis = MinValueAnalysis;
//# sourceMappingURL=MinValueAnalysis.js.map