"use strict";Object.defineProperty(exports,"__esModule",{value:!0});var MinValueAnalysis=function(){function e(){}return e.prototype.analysis=function(e){var n=Number.MAX_VALUE;return e.forEach(function(e){n>e.getCredit()&&(n=e.getCredit())}),n},e}();exports.MinValueAnalysis=MinValueAnalysis;