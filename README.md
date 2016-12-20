# Plus1Core
## 使用

```shell
cd .
mvn clean compile -PcheckstyleSkip exec:java
```

## The API of the server:
##### [xxx]验证用户名是否存在


GET **/services/userexistence/{*username*}**

返回JSON，包含

+ username
+ available: "yes" or "no"


##### [xxx] 注册

POST **/services/usercreation**

接受JSON，包含

+ username
+ password

返回JSON

+ result: 数字（0代表成功，其余请参见/fudan.plus1/Kits/Finals.java）

##### [xxx] 登录


GET **/services/verification/{*username*}/{*password*}**

返回JSON，包含

+ result: 数字（0代表成功，其余请参见/fudan.plus1/Kits/Finals.java）


##### [xxx] 创建新计数器

POST **/services/countercreation**

接受JSON，包含

+ administrator
+ counterName
+ value
+ step
+ unit

返回JSON，包含

+ result: 数字（0代表成功，其余请参见/fudan.plus1/Kits/Finals.java）
+ counterId: String

##### [xxx] 获取用户的所有计数器


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


##### [xxx] 添加已有计数器


POST **/users/{*username*}/{*counterId*}**

返回JSON，包含

+ result: 数字（0代表成功，其余请参见/fudan.plus1/Kits/Finals.java）


##### [xxx] 删除计数器


DELETE **/users/{*username}*/{*counterId*}**

接受JSON，包含

+ administrator

返回JSON，包含

+ result: 数字（0代表成功，其余请参见/fudan.plus1/Kits/Finals.java）

##### [xxx] 改变计数器


PUT **/users/{username}/{counterId}**

接受JSON

+ administrator
+ counterName
+ value
+ step
+ unit

返回JSON，包含

+ result: 数字（0代表成功，其余请参见/fudan.plus1/Kits/Finals.java）


##### [xxx] 获取一个计数器

GET **/counters/{*counterId*}**

返回JSON

+ counter
  + counterId
  + counterName
  + value
  + step
  + unit
  + administrator

##### [xxx] 计数加


POST **/counters/{*counterId*}/increase**

返回JSON，包含

+ result: 数字（0代表成功，其余请参见/fudan.plus1/Kits/Finals.java）

##### [xxx] 计数减


POST **/counters/{*counterId*}/decrease**

返回JSON，包含

+ result: 数字（0代表成功，其余请参见/fudan.plus1/Kits/Finals.java）

##### 获取计数器（纯文本）信息

GET **/info/{*counterId*}**

返回"text/plain"，具体信息由','隔开：

counterId + "," + 
                administrator + "," + 
                counterName + "," + 
                value + "," + 
                step + "," +
                unit