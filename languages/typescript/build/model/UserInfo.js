"use strict";
Object.defineProperty(exports, "__esModule", { value: true });
var UserInfo = (function () {
    function UserInfo(user, password, credit) {
        this.user = user;
        this.password = password;
        this.credit = credit;
    }
    UserInfo.prototype.getUser = function () {
        return (this.user);
    };
    UserInfo.prototype.getCredit = function () {
        return (this.credit);
    };
    UserInfo.prototype.getPassword = function () {
        return (this.cryptPassword(this.password));
    };
    UserInfo.prototype.setUser = function (user) {
        this.user = user;
    };
    UserInfo.prototype.setCredit = function (credit) {
        this.credit = credit;
    };
    UserInfo.prototype.setPassword = function (password) {
        this.password = this.password;
    };
    UserInfo.prototype.cryptPassword = function (password) {
        return password.split("").reverse().join("");
    };
    return UserInfo;
}());
exports.UserInfo = UserInfo;
//# sourceMappingURL=UserInfo.js.map