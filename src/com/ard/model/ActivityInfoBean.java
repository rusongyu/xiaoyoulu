/**
 * @toDo:活动信息表
 * @fileName:ActivityInfoBean.java
 * @createTime:上午11:18:22
 * @createUser:foxcen
 */
package com.ard.model;

/**
 * @author foxcen
 *
 */
public class ActivityInfoBean {
private Integer id;
public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public Integer getUserId() {
	return userId;
}
public void setUserId(Integer userId) {
	this.userId = userId;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
public Integer getType() {
	return type;
}
public void setType(Integer type) {
	this.type = type;
}
public String getContent() {
	return content;
}
public void setContent(String content) {
	this.content = content;
}
public String getCreateTime() {
	return createTime;
}
public void setCreateTime(String createTime) {
	this.createTime = createTime;
}
public String getActivityStartTime() {
	return activityStartTime;
}
public void setActivityStartTime(String activityStartTime) {
	this.activityStartTime = activityStartTime;
}
public String getActivityEndTime() {
	return activityEndTime;
}
public void setActivityEndTime(String activityEndTime) {
	this.activityEndTime = activityEndTime;
}
public Integer getIsOverdue() {
	return isOverdue;
}
public void setIsOverdue(Integer isOverdue) {
	this.isOverdue = isOverdue;
}
public Integer getCount() {
	return count;
}
public void setCount(Integer count) {
	this.count = count;
}
public String getSortField() {
	return sortField;
}
public void setSortField(String sortField) {
	this.sortField = sortField;
}
public Integer getIsBackground() {
	return isBackground;
}
public void setIsBackground(Integer isBackground) {
	this.isBackground = isBackground;
}
private Integer  userId;
private  String city;
private  Integer  type;
private  String  content;
private  String  createTime;
private  String  activityStartTime;
private  String   activityEndTime;
private  Integer   isOverdue;
private Integer   count;
private  String  sortField;
private  Integer  isBackground;
}
