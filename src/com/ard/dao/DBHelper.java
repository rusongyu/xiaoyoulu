package com.ard.dao;

import java.beans.PropertyVetoException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.apache.log4j.Logger;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class DBHelper {
	static Logger log = Logger.getLogger(DBHelper.class);
	private static String c3p0Properties = "/c3p0MySqlPool.properties";
	private static ComboPooledDataSource ds = new ComboPooledDataSource();
	static {
		try {
			
			
			System.out.println("");

			Properties p = new Properties();
			p.load(DBHelper.class.getResourceAsStream(c3p0Properties));
			ds = new ComboPooledDataSource();
			ds.setUser(p.getProperty("jdbc.user"));
			ds.setPassword(p.getProperty("jdbc.password"));
			ds.setJdbcUrl(p.getProperty("jdbc.jdbcUrl"));
			ds.setDriverClass(p.getProperty("jdbc.driverClass"));
			ds.setInitialPoolSize(Integer.parseInt(p
					.getProperty("jdbc.initialPoolSize")));
			ds.setMinPoolSize(Integer.parseInt(p
					.getProperty("jdbc.miniPoolSize")));
			ds.setMaxPoolSize(Integer.parseInt(p
					.getProperty("jdbc.maxPoolSize")));
			ds.setMaxStatements(Integer.parseInt(p
					.getProperty("jdbc.maxStatements")));
			ds.setMaxIdleTime(Integer.parseInt(p
					.getProperty("jdbc.maxIdleTime")));

			ds.setAcquireIncrement(Integer.parseInt(p
					.getProperty("jdbc.acquireIncrement")));
			ds.setAcquireRetryAttempts(Integer.parseInt(p
					.getProperty("jdbc.acquireRetryAttempts")));
			ds.setAcquireRetryDelay(Integer.parseInt(p
					.getProperty("jdbc.acquireRetryDelay")));
			ds.setAutomaticTestTable(p
					.getProperty("jdbc.automaticTestTable"));
			ds.setTestConnectionOnCheckin(Boolean.valueOf(p
					.getProperty("jdbc.testConnectionOnCheckin")));
			ds.setIdleConnectionTestPeriod(Integer.parseInt(p
					.getProperty("jdbc.idleConnectionTestPeriod")));
			ds.setCheckoutTimeout(Integer.parseInt(p
					.getProperty("jdbc.checkoutTimeout")));
			// 驱动器
			// cpds.setDriverClass("oracle.jdbc.OracleDriver");
			// 数据库url
			// cpds.setJdbcUrl("jdbc:oracle:thin:@127.0.0.1:1521:ORCL");
			// 用户名
			// cpds.setUser("sa");
			// 密码
			// cpds.setPassword("sa");
			// 初始化连接池的大小
			// cpds.setInitialPoolSize(30);
			// 最小连接数
			// cpds.setMinPoolSize(20);
			// 最大连接数
			// cpds.setMaxPoolSize(100);
		} catch (PropertyVetoException e) {
			log.error(e.getMessage());
			e.printStackTrace();
		} catch (IOException e) {
			log.error(e.getMessage());
			e.printStackTrace();
		}

	}

	/**
	 * 用于数据库的链接
	 * 
	 * @return 返回Connection
	 */
	public static Connection getConnection() {

		try {
			return ds.getConnection();
		} catch (SQLException e) {
			log.error(e.getMessage());
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 用于关闭数据库的关闭
	 * 
	 * @param rs
	 *            ResultSet对象
	 * @param st
	 *            Statement对象
	 * @param con
	 *            Connection对象
	 */
	public static void closeJDBC(ResultSet rs, Statement st, Statement pst,
			Connection con) {
		if (rs != null) {
			try {
				rs.close();
				rs = null;
			} catch (SQLException e) {
				log.warn(e.getMessage());
				e.printStackTrace();
			}
		}
		if (st != null) {
			try {
				st.close();
				st = null;
			} catch (SQLException e) {
				log.warn(e.getMessage());
				e.printStackTrace();
			}
		}
		if (pst != null) {
			try {
				pst.close();
				pst = null;
			} catch (SQLException e) {
				log.warn(e.getMessage());
				e.printStackTrace();
			}
		}
		if (con != null) {
			try {
				con.close();
				con = null;
			} catch (SQLException e) {
				log.warn(e.getMessage());
				e.printStackTrace();
			}
		}
	}

	// 这个方式是用来获取指定表明的列对应JAVA中的数据类型，和数据库连接无关，我只是当作一个小工具来用。
	/**
	 * 用于获取指定表明的列对应JAVA中的数据类型。
	 * 
	 * @param tablename
	 *            指定的表名
	 * @return 列数据类型的数组
	 */
	public Class[] getTypeOfJava(String tablename) {
		Connection con = DBHelper.getConnection();
		if (con == null) {
			return null;
		}
		Statement st = null;
		ResultSet rs = null;
		Class[] types = null;
		try {
			st = con.createStatement();
			rs = st.executeQuery("select * from " + tablename);
			int count = rs.getMetaData().getColumnCount();
			types = new Class[count];
			for (int i = 0; i < types.length; i++) {
				types[i] = Class.forName(rs.getMetaData().getColumnClassName(
						i + 1));
			}
			return types;

		} catch (SQLException e) {
			log.warn(e.getMessage());
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			log.warn(e.getMessage());
			e.printStackTrace();
		} finally {
			DBHelper.closeJDBC(rs, st, null, con);
		}
		return null;

	}
}
