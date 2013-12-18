/**
 * @toDo:校友录账号信息dao
 * @fileName:AccountInfoDao.java
 * @createTime:上午11:41:48
 * @createUser:geek
 */
package com.ard.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;



/**
 * @author geek
 *
 */
public class AccountInfoDao {

	
	private Connection manager = null; // 数据库连接管理器。
	private PreparedStatement pstmt = null;
	private static Logger log = Logger.getLogger(AccountInfoDao.class);

	private Integer watageNum = 0;
	private Integer countA = 0;

	/**
	 * 功能：统计数据库中最新日期数据
	 * 
	 * @param startDate
	 * @param endDate
	 * @return
	 */
	public String getMaxDateDB() {
		String sql = "select max(reg_date) as maxDate  FROM  reg_wastage_rate";
		manager = DBHelper.getConnection();
		ResultSet rset = null;
		String maxDate = null;
		try {
			pstmt = manager.prepareStatement(sql);

			rset = pstmt.executeQuery(sql);
			while (rset.next()) {
				maxDate = rset.getString("maxDate");
			}
			log.info("查询成功,maxDate=" + maxDate);
		} catch (SQLException ex) {
			log.error("getMaxDateDB异常" + ex);
		} finally {
			try {
				rset.close();
				pstmt.close();
				manager.close();
			} catch (SQLException ex) {
				log.error("getMaxDateDB关闭异常" + ex);
			}

		}
		return maxDate;
	}
	
}
