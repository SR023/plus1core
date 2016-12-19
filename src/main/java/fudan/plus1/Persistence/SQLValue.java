
package fudan.plus1.Persistence;

public class SQLValue
{
    public static String DRIVER_MYSQL = "com.mysql.jdbc.Driver";    //MySQL JDBC驱动字符串
    public static String URL = "jdbc:mysql://localhost:3306/msys?"
            + "user=root&password=123456&useUnicode=true&characterEncoding=UTF8";//数据库Url,用来标识要连接的数据库，其中数据库名、用户名、密码是根据你自己的数据库情况设定
}