package com.doanphammem.model;

public class QuanLi {
	private String tenDN;
	private int maQuyen;
	private String matKhau;
	private String maPB;
	public String getTenDN() {
		return tenDN;
	}
	public void setTenDN(String tenDN) {
		this.tenDN = tenDN;
	}
	public int getMaQuyen() {
		return maQuyen;
	}
	public void setMaQuyen(int maQuyen) {
		this.maQuyen = maQuyen;
	}
	public String getMatKhau() {
		return matKhau;
	}
	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}
	public String getMaPB() {
		return maPB;
	}
	public void setMaPB(String maPB) {
		this.maPB = maPB;
	}
	
	public QuanLi() {
		super();
	}
	public QuanLi(String tenDN, int maQuyen, String matKhau, String maPB) {
		super();
		this.tenDN = tenDN;
		this.maQuyen = maQuyen;
		this.matKhau = matKhau;
		this.maPB = maPB;
	}
	@Override
	public String toString() {
		return "QuanLi [tenDN=" + tenDN + ", maQuyen=" + maQuyen + ", matKhau=" + matKhau + ", maPB=" + maPB + "]";
	}
	
	
	
	
}
