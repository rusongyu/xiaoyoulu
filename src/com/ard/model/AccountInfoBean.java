/**
 * @toDo:校友信息表
 * @fileName:AccountInfoBean.java
 * @createTime:上午11:06:40
 * @createUser:foxcen
 */
package com.ard.model;

/**
 * @author foxcen
 * 
 */
public class AccountInfoBean {

	private Integer id; // 用户id
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getAccountName() {
		return accountName;
	}
	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getGender() {
		return gender;
	}
	public void setGender(Integer gender) {
		this.gender = gender;
	}
	public Integer getStartYear() {
		return startYear;
	}
	public void setStartYear(Integer startYear) {
		this.startYear = startYear;
	}
	public Integer getEndYear() {
		return endYear;
	}
	public void setEndYear(Integer endYear) {
		this.endYear = endYear;
	}
	public Integer getYuan() {
		return yuan;
	}
	public void setYuan(Integer yuan) {
		this.yuan = yuan;
	}
	public Integer getXi() {
		return xi;
	}
	public void setXi(Integer xi) {
		this.xi = xi;
	}
	public String getMobilePhone() {
		return mobilePhone;
	}
	public void setMobilePhone(String mobilePhone) {
		this.mobilePhone = mobilePhone;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getRegisterTime() {
		return registerTime;
	}
	public void setRegisterTime(String registerTime) {
		this.registerTime = registerTime;
	}
	public String getValidatedTime() {
		return validatedTime;
	}
	public void setValidatedTime(String validatedTime) {
		this.validatedTime = validatedTime;
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
	private String accountName; // 账号名
	private String name; // 姓名
	private Integer gender; // 性别1：男2：女',
	private Integer startYear; // 入学年份
	private Integer endYear; // 毕业年份
	private Integer yuan; // 院
	private Integer xi; // 系
	private String mobilePhone; // 手机号
	private Integer status; // 状态0：注册1：认证'
	private String registerTime; // 注册时间
	private String validatedTime; // 认证时间
	private String sortField; // 排序字段
	private Integer isBackground; // 是否为后台添加

}
