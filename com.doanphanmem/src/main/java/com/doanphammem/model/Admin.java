package com.doanphammem.model;

public class Admin {
	private String tenDN;
	private String matKhau;
	private int maQuyen;
	public String getTenDN() {
		return tenDN;
	}
	public void setTenDN(String tenDN) {
		this.tenDN = tenDN;
	}
	public String getMatKhau() {
		return matKhau;
	}
	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}
	public int getMaQuyen() {
		return maQuyen;
	}
	public void setMaQuyen(int maQuyen) {
		this.maQuyen = maQuyen;
	}
	public Admin() {
		super();
	}
	public Admin(String tenDN, String matKhau, int maQuyen) {
		super();
		this.tenDN = tenDN;
		this.matKhau = matKhau;
		this.maQuyen = maQuyen;
	}
	
	@Override
	public String toString() {
		return "Admin [tenDN=" + tenDN + ", matKhau=" + matKhau + ", maQuyen=" + maQuyen + "]";
	}
	
	
}
