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

import com.ard.model.AccountInfoBean;

/**
 * @author geek
 * 
 */
public class AccountInfoDao {

	private Connection manager = null; // 数据库连接管理器。
	private PreparedStatement pstmt = null;
	private static Logger log = Logger.getLogger(AccountInfoDao.class);

	/**
	 * 
	 * @DoSomething:存储校友账号信息
	 * @MethodName:getMaxDateDB
	 * @Params:String
	 */
	public String saveAccountInfoDB(AccountInfoBean accountInfoBean) {
		String sql = "insert into accountinfo(AccountName,Name,Gender,StartYear,EndYear,Yuan,Xi,MobilePhone"
				+ ",Status,RegisterTime,ValidatedTime,SortField,IsBackground)  values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
		manager = DBHelper.getConnection();
		ResultSet rset = null;
		String maxDate = null;
		try {
			pstmt = manager.prepareStatement(sql);

			pstmt.setString(1, accountInfoBean.getAccountName());
			pstmt.setString(2, accountInfoBean.getName());
			pstmt.setInt(3, accountInfoBean.getGender());
			pstmt.setInt(4, accountInfoBean.getStartYear());
			pstmt.setInt(5, accountInfoBean.getEndYear());
			pstmt.setInt(6, accountInfoBean.getYuan());
			pstmt.setInt(7, accountInfoBean.getXi());
			pstmt.setString(8, accountInfoBean.getMobilePhone());
			pstmt.setInt(9, accountInfoBean.getStatus());
			pstmt.setString(10, accountInfoBean.getRegisterTime());
			pstmt.setString(11, accountInfoBean.getValidatedTime());
			pstmt.setString(12, accountInfoBean.getSortField());
			pstmt.setInt(13, accountInfoBean.getIsBackground());
			pstmt.execute(sql);

			log.info("saveAccountInfoDB存储成功,AccountNam="
					+ accountInfoBean.getAccountName());
		} catch (SQLException ex) {
			log.error("saveAccountInfoDB异常" + ex);
		} finally {
			try {
				pstmt.close();
				manager.close();
			} catch (SQLException ex) {
				log.error("saveAccountInfoDB关闭异常" + ex);
			}

		}
		return maxDate;
	}

	
	
	
	
}
