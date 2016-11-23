# Plus1Core
The core part of plus1.
## The API of the server:
##### [x] 验证用户名是否存在


GET **/services/userexistence/{*username*}**

返回JSON，包含

+ username
+ existence: "yes" or "no"


##### [x] 注册

POST **/services/usercreation**

接受JSON，包含

+ username
+ password

返回JSON

+ result: 数字（0代表成功，其余请参见/fudan.plus1/Kits/Finals.java）

##### [x] 登录


GET **/services/verification**

接受JSON，包含

+ username
+ password

返回JSON，包含

+ result: 数字（0代表成功，其余请参见/fudan.plus1/Kits/Finals.java）


##### [x] 创建新计数器

POST **/services/countercreation**

接受JSON，包含

+ administrator
+ counterName
+ value
+ step
+ unit

返回JSON，包含

+ result: 数字（0代表成功，其余请参见/fudan.plus1/Kits/Finals.java）

##### [x] 获取用户的所有计数器


GET **/users/{*username*}/counters**

返回JSON

+ List<AbstractCounter>
  + Counter
    + administrator
    + counterId
    + counterName
    + value
    + step
    + unit


##### [x] 添加已有计数器


POST **/users/{*username*}/{*counterId*}**

返回JSON，包含

+ result: 数字（0代表成功，其余请参见/fudan.plus1/Kits/Finals.java）


##### [x] 删除计数器


DELETE **/users/{*username}*/{*counterId*}**

接受JSON，包含

+ administrator

返回JSON，包含

+ result: 数字（0代表成功，其余请参见/fudan.plus1/Kits/Finals.java）

##### [x] 改变计数器


PUT **/users/{username}/{counterId}**

接受JSON

+ administrator
+ counterName
+ value
+ step
+ unit

返回JSON，包含

+ result: 数字（0代表成功，其余请参见/fudan.plus1/Kits/Finals.java）


##### [x] 获取一个计数器

GET **/counters/{*counterId*}**

返回JSON

+ counter
  + counterId
  + counterName
  + value
  + step
  + unit
  + administrator

##### [x] 计数加


POST **/services/incresement/{*counterId*}**

返回JSON，包含

+ result: 数字（0代表成功，其余请参见/fudan.plus1/Kits/Finals.java）

##### [x] 计数减


POST **/services/decreasement/{*counterId*}**

返回JSON，包含

+ result: 数字（0代表成功，其余请参见/fudan.plus1/Kits/Finals.java）
