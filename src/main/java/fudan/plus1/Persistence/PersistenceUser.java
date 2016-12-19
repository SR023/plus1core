
package fudan.plus1.Persistence;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.sql.ResultSet;
import java.sql.SQLException;

import fudan.plus1.Persistence.*;
import fudan.plus1.Implementations.*;


public class PersistenceUser{
	
	private Statement statement;
	
    private static PersistenceUser ourInstance = new PersistenceUser();

    public static PersistenceUser getInstance() {
        return ourInstance;
    }

	private PersistenceUser(){
        try
        {
            Class.forName(SQLValue.DRIVER_MYSQL);     //加载JDBC驱动
            System.out.println("Driver Load Success.");

            Connection connection = DriverManager.getConnection(SQLValue.URL);    //创建数据库连接对象
            statement = connection.createStatement();       //创建Statement对象
        } catch (Exception e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }		
	}

    public ResultSet query(String sql) {
        ResultSet result = null;

        try
        {
            result = statement.executeQuery(sql);
        } catch (SQLException e)
        {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return result;
    }	
	
    public void executeSql(String sql) {
    try
    {
        statement.execute(sql);
    } catch (SQLException e)
    {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }
    }	
	
	public void addUser(User user){
		
		String username = user.getUsername();
		String password = user.getPassword();
		String sql = String.format("insert into Users values(\"%s\",\"%s\");", username, password);
		executeSql(sql);	
	}
	
	public void addCounter(Counter counter){
	    String counterID = counter.getCounterId();
	    String administrator = counter.getAdministrator();
	    String counterName = counter.getCounterName();
	    double value = counter.getValue();
	    double step = counter.getStep();
	    String unit = counter.getUnit();
	    System.out.println("ok1");
	    
		String sql = String.format("insert into Counters values('%s','%s','%s',%f,%f,'%s');", counterID, administrator, counterName, value, step, unit);
		System.out.println("ok2");
		System.out.println(sql);
		executeSql(sql);
	}
	
	public void updateCounter(Counter counter){
	    String counterID = counter.getCounterId();
	    String administrator = counter.getAdministrator();
	    String counterName = counter.getCounterName();
	    double value = counter.getValue();
	    double step = counter.getStep();
	    String unit = counter.getUnit();		
		
	    String sql = String.format("update Counters set administrator = '%s', countername = '%s', value = %f, step = %f, unit = '%s' where counterid = '%s';", administrator, counterName, value, step, unit, counterID);
	    executeSql(sql);
	}
	
	public void deleteCounter(Counter counter){
		String counterID = counter.getCounterId();
		String sql = String.format("delete from Counters where counterid = '%s';", counterID);
		executeSql(sql);
	}
	
	
	public void buildUserList(){
		
		String createsql = String.format("create table if not exists Users ("
				+ "username VARCHAR(200) NOT NULL PRIMARY KEY,"
				+ "password VARCHAR(200) NOT NULL);");
		executeSql(createsql);
		String sql = String.format("select * from Users;");
		ResultSet result = null;
	    try
	    {
	        result = statement.executeQuery(sql);
		    while (result.next())
		    {
		    	String username = result.getString(1);
		    	String password = result.getString(2);
		    	UserFactory.getInstance().createExistUser(username, password);
		    }
	    } catch (SQLException e)
	    {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    }
	}
	
	public void buildCounterList(){
		
		String createsql = String.format("create table if not exists Counters ("
				+ "counterid VARCHAR(200) NOT NULL PRIMARY KEY,"
				+ "administrator VARCHAR(200) NOT NULL,"
				+ "countername VARCHAR(200) NOT NULL,"
				+ "value numeric(50,20),"
				+ "step numeric(50,20),"
				+ "unit VARCHAR(200) NOT NULL);");
		executeSql(createsql);
		String sql = String.format("select * from Counters;");
		ResultSet result = null;
	    try
	    {
	        result = statement.executeQuery(sql);
		    while (result.next())
		    {
			    String counterID = result.getString(1);
			    String administrator = result.getString(2);
			    String counterName = result.getString(3);;
			    double value = result.getDouble(4);
			    double step = result.getDouble(5);
			    String unit = result.getString(6);
			    CounterFactory.getInstance().createExistCounter(counterID,administrator,counterName,value,step,unit);
		    }
	    } catch (SQLException e)
	    {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    }	
	}
	
	
}