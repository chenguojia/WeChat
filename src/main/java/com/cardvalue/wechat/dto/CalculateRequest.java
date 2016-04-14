package com.cardvalue.wechat.dto;

public class CalculateRequest {

	private String username; //用户名
	private String password; //密码
	private String R; //最近交易月活动频率
	private String F; //平均日交易笔数
	private String M; //平均客单价
	private String R1 = "0"; //一般不设置
	private String F1 = "0"; //一般不设置
	private String M1 = "0"; //一般不设置
	private String mcc_code; //省份信息
	private String pro_code; //行业分类码
	private String type; //类型 （type=crm 或 weixin）
	
	public CalculateRequest(){}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getR() {
		return R;
	}
	public void setR(String r) {
		R = r;
	}
	public String getF() {
		return F;
	}
	public void setF(String f) {
		F = f;
	}
	public String getM() {
		return M;
	}
	public void setM(String m) {
		M = m;
	}
	public String getR1() {
		return R1;
	}
	public void setR1(String r1) {
		R1 = r1;
	}
	public String getF1() {
		return F1;
	}
	public void setF1(String f1) {
		F1 = f1;
	}
	public String getM1() {
		return M1;
	}
	public void setM1(String m1) {
		M1 = m1;
	}
	public String getMcc_code() {
		return mcc_code;
	}
	public void setMcc_code(String mcc_code) {
		this.mcc_code = mcc_code;
	}
	public String getPro_code() {
		return pro_code;
	}
	public void setPro_code(String pro_code) {
		this.pro_code = pro_code;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

}
