require './src/UserInfo.rb'

antes = Time.now

list = Array.new
(0..1000000).each do |index|
    user = "user#{index}"
    password = "password#{index}"
    list.push(UserInfo.new(user, password))
end

depois = Time.now

p (depois - antes)* 1000.0