package org.iesalixar.servidor.db;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Logger;

public class PoolDB {

	private final static Logger logger = Logger.getLogger("botacora.subnivel.Control");
	public DataSource dataSource;

    public String db 	= "dbname";
    public String url 	= "jdbc:mysql://localhost/"+db;
    public String user 	= "root";
    public String pass 	= "root";

    public PoolDB() {

        initDataSource();

    }
    
    private void initDataSource() {


        BasicDataSource basicDataSource = new BasicDataSource();

        basicDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        basicDataSource.setUsername(user);
        basicDataSource.setPassword(pass);
        basicDataSource.setUrl(url);
        basicDataSource.setMaxTotal(50);


        dataSource = basicDataSource;

    }

    
    public Connection getConnection() {
    	
      	 Connection result = null;
      	 try {
      		 
      		 result = dataSource.getConnection();
      		 
      	 } catch (SQLException e) {
      		 e.printStackTrace();
      	 }
      	 
      	 logger.info("PoolDB 'getConnection' method called (it returned valid connection: '" + (result!=null) + "')");    	 
      	 return result;
       }

}
