package com.ard.util;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import org.apache.log4j.Logger;

public class OnlineSessionListener implements HttpSessionListener {

	private Logger  log=Logger.getLogger(OnlineSessionListener.class);
	public void sessionCreated(HttpSessionEvent arg0) {

	}

	public void sessionDestroyed(HttpSessionEvent event) {

		log.info("会员退出关闭浏览器  关闭session");

		Object obj = event.getSession().getAttribute("salesUserInfoBean");
		if (obj != null) {
			event.getSession().removeAttribute("salesUserInfoBean");
		}
	}

}
