package cn.com.ts.system.model;

import java.math.BigDecimal;
import java.util.Date;
import java.sql.Timestamp;
import java.sql.Time;
import cn.com.ts.base.BaseModel;
/**
 * 
 * @author jiangjiaxin
 * @date 
 */
public class SUser extends BaseModel{
	
	/**
	 * 主键
	 */
	private String id;
	
	/**
	 * 性别(0:女,1:男)
	 */
	private String gender;
	
	/**
	 * 备注
	 */
	private String commentInfo;
	
	/**
	 * 登录用户名
	 */
	private String loginName;
	
	/**
	 * 密码
	 */
	private String password;
	
	/**
	 * 中文姓名
	 */
	private String chineseName;
	
	/**
	 * 身份证号码
	 */
	private String identificationCard;
	
	/**
	 * 手机号
	 */
	private String mobilePhone;
	
	/**
	 * email
	 */
	private String email;
	
	/**
	 * 是否在用(1:是,0:否,2:离职)
	 */
	private String state;
	
	/**
	 * 入职时间
	 */
	private Date entryTime;
	
	/**
	 * 离职时间
	 */
	private Date dimissionTime;
	
	/**
	 * 创建人ID
	 */
	private String createBy;
	
	/**
	 * 创建时间
	 */
	private Timestamp createTime;
	
	/**
	 * 最后修改人ID
	 */
	private String lastmodifyBy;
	
	/**
	 * 最后修改时间
	 */
	private Timestamp lastmodifyTime;
	
	
	/**
	 * 主键
	 */
	public String getId() {
		return id;
	}

	/**
	 * 主键
	 */
	public void setId(String id){
		this.id = id;
	}
	
	/**
	 * 性别(0:女,1:男)
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * 性别(0:女,1:男)
	 */
	public void setGender(String gender){
		this.gender = gender;
	}
	
	/**
	 * 备注
	 */
	public String getCommentInfo() {
		return commentInfo;
	}

	/**
	 * 备注
	 */
	public void setCommentInfo(String commentInfo){
		this.commentInfo = commentInfo;
	}
	
	/**
	 * 登录用户名
	 */
	public String getLoginName() {
		return loginName;
	}

	/**
	 * 登录用户名
	 */
	public void setLoginName(String loginName){
		this.loginName = loginName;
	}
	
	/**
	 * 密码
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * 密码
	 */
	public void setPassword(String password){
		this.password = password;
	}
	
	/**
	 * 中文姓名
	 */
	public String getChineseName() {
		return chineseName;
	}

	/**
	 * 中文姓名
	 */
	public void setChineseName(String chineseName){
		this.chineseName = chineseName;
	}
	
	/**
	 * 身份证号码
	 */
	public String getIdentificationCard() {
		return identificationCard;
	}

	/**
	 * 身份证号码
	 */
	public void setIdentificationCard(String identificationCard){
		this.identificationCard = identificationCard;
	}
	
	/**
	 * 手机号
	 */
	public String getMobilePhone() {
		return mobilePhone;
	}

	/**
	 * 手机号
	 */
	public void setMobilePhone(String mobilePhone){
		this.mobilePhone = mobilePhone;
	}
	
	/**
	 * email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * email
	 */
	public void setEmail(String email){
		this.email = email;
	}
	
	/**
	 * 是否在用(1:是,0:否,2:离职)
	 */
	public String getState() {
		return state;
	}

	/**
	 * 是否在用(1:是,0:否,2:离职)
	 */
	public void setState(String state){
		this.state = state;
	}
	
	/**
	 * 入职时间
	 */
	public Date getEntryTime() {
		return entryTime;
	}

	/**
	 * 入职时间
	 */
	public void setEntryTime(Date entryTime){
		this.entryTime = entryTime;
	}
	
	/**
	 * 离职时间
	 */
	public Date getDimissionTime() {
		return dimissionTime;
	}

	/**
	 * 离职时间
	 */
	public void setDimissionTime(Date dimissionTime){
		this.dimissionTime = dimissionTime;
	}
	
	/**
	 * 创建人ID
	 */
	public String getCreateBy() {
		return createBy;
	}

	/**
	 * 创建人ID
	 */
	public void setCreateBy(String createBy){
		this.createBy = createBy;
	}
	
	/**
	 * 创建时间
	 */
	public Timestamp getCreateTime() {
		return createTime;
	}

	/**
	 * 创建时间
	 */
	public void setCreateTime(Timestamp createTime){
		this.createTime = createTime;
	}
	
	/**
	 * 最后修改人ID
	 */
	public String getLastmodifyBy() {
		return lastmodifyBy;
	}

	/**
	 * 最后修改人ID
	 */
	public void setLastmodifyBy(String lastmodifyBy){
		this.lastmodifyBy = lastmodifyBy;
	}
	
	/**
	 * 最后修改时间
	 */
	public Timestamp getLastmodifyTime() {
		return lastmodifyTime;
	}

	/**
	 * 最后修改时间
	 */
	public void setLastmodifyTime(Timestamp lastmodifyTime){
		this.lastmodifyTime = lastmodifyTime;
	}
	
}
