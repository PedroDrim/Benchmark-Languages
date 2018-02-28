import {UserInfo} from './model/UserInfo'

let antes = new Date().getTime()

var list: UserInfo[] = new Array()

for(var index = 0; index < 1000000; index++){
    let user = "user" + index
    let password = "password" + index
    list.push(new UserInfo(user, password))
}

let depois = new Date().getTime()

console.log(depois - antes)