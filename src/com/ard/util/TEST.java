package com.ard.util;

import com.google.gson.Gson;

public class TEST {

	private String userName;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	private String password;

	public static void main(String args[]) {

		TEST test = new TEST();
		test.setPassword("aaaaaaaaaaa");
		test.setUserName("bbbbbbbbbbbbb");

		Gson gson = new Gson();
		String testJson = gson.toJson(test);
		System.out.println(testJson);
		TEST test0 = gson.fromJson(testJson, TEST.class);

		System.out.println(test0.getPassword());
	}
}
