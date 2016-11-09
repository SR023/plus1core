# Plus1Core
The core part of plus1.
## The API of the server:
##### 验证用户名是否存在

GET **/services/existence**

返回JSON，包含

+ username
+ existence: "yes" or "no"

##### 注册

POST **/services/usercreation**

接受JSON，包含

+ username
+ password

##### 登录

GET **/services/verification**

接受JSON，包含

+ username
+ password

返回JSON，包含

+ username
+ success: "yes" or "no"

##### 创建新计数器

POST **/services/countercreation**

接受JSON，包含

+ counterName
+ value
+ step
+ unit
+ creator

##### 获取用户的计数器

GET **/user/{*username*}**

返回JSON

+ counter
  + counterId
  + counterName
  + value
  + step
  + unit
  + creator

##### 计数加

POST **/services/incresement/{*counterId*}**

##### 计数减

POST **/services/decreasement/{*counterId*}**

##### 删除计数器

DELETE **/services/counterdeletion/{*counterId*}**

##### 改变计数器

PUT **/services/countermodification**

接受JSON

+ counter
  + counterId
  + counterName
  + value
  + step
  + unit
  + creator