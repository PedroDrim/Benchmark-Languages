"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
var UserInfo_1 = require("./UserInfo");
var fs = require("fs");
var Table = (function () {
    function Table(fileName) {
        this.fileName = fileName;
        this.userInfoList = this.deserializeFile(this.fileName);
    }
    Table.prototype.getFileName = function () {
        return this.fileName;
    };
    Table.prototype.getUserInfoList = function () {
        return this.userInfoList;
    };
    Table.prototype.deserializeFile = function (fileName) {
        var list = new Array();
        var lines = fs.readFileSync(fileName, 'utf8');
        lines.split("\n").forEach(function (line) {
            if (line != '') {
                var values = line.split(",");
                var user = values[0].trim();
                var password = values[1].trim();
                var credit = Number(values[2].trim());
                var userInfo = new UserInfo_1.UserInfo(user, password, credit);
                list.push(userInfo);
            }
        });
        return list;
    };
    return Table;
}());
exports.Table = Table;
//# sourceMappingURL=Table.js.map