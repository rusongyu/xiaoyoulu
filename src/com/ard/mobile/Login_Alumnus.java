package com.ard.mobile;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.apache.struts2.ServletActionContext;

//import net.sf.json.JSONObject;


public class Login_Alumnus{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String AccountName;

	private String Password;

	private String loginInfoJson;

	public String loginServer() {

		
		HttpServletRequest request=ServletActionContext.getRequest();
	try{
		BufferedReader br = request.getReader();
		 String line = null;
		 StringBuilder sb = new StringBuilder();
		 while((line = br.readLine())!=null){
		 sb.append(line);
		 }
		
		System.out.println("server coming  ***********************"+sb.toString());

		System.out.println("用户名：" + AccountName + "***********************");

		System.out.println("密码：" + Password + "***********************");

		JSONObject jsonObject = new JSONObject();

		jsonObject.put("loginInfoJson", "ok，Login，success");
		jsonObject.put("rescode", "0");
		jsonObject.put("res_msg", "success");
		loginInfoJson = jsonObject.toString();
	}
	catch (Exception e) {
		// TODO: handle exception
	
	}
		return "success";
	}

	/**
	 * seters and getters
	 * 
	 * @return
	 */
	

	public String getLoginInfoJson() {
		return loginInfoJson;
	}

	public void setLoginInfoJson(String loginInfoJson) {
		this.loginInfoJson = loginInfoJson;
	}

	public void setAccountName(String accountName) {
		AccountName = accountName;
	}

	public String getAccountName() {
		return AccountName;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getPassword() {
		return Password;
	}

}
