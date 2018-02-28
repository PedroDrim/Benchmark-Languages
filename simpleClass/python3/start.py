from src.UserInfo import UserInfo
import time

antes = time.time() * 1000
list = []

for index in range(1000000):
    user = "user{}".format(index)
    password = "password{}".format(index)
    list.append(UserInfo(user, password))

depois = time.time() * 1000

print(depois - antes)