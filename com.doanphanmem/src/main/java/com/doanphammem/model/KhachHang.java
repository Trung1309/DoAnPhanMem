package com.doanphammem.model;

public class KhachHang {
	private String tenDN;
	private int maQuyen;
	private String matKhau;
	private String hoTen;
	private String email;
	private String sdt;
	private String cccd;
	private String idPX;
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
	public String getHoTen() {
		return hoTen;
	}
	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	public String getCccd() {
		return cccd;
	}
	public void setCccd(String cccd) {
		this.cccd = cccd;
	}
	public String getIdPX() {
		return idPX;
	}
	public void setIdPX(String idPX) {
		this.idPX = idPX;
	}
	public KhachHang() {
		super();
	}
	public KhachHang(String tenDN, int maQuyen, String matKhau, String hoTen, String email, String sdt, String cccd,
			String idPX) {
		super();
		this.tenDN = tenDN;
		this.maQuyen = maQuyen;
		this.matKhau = matKhau;
		this.hoTen = hoTen;
		this.email = email;
		this.sdt = sdt;
		this.cccd = cccd;
		this.idPX = idPX;
	}
	@Override
	public String toString() {
		return "KhachHang [tenDN=" + tenDN + ", maQuyen=" + maQuyen + ", matKhau=" + matKhau + ", hoTen=" + hoTen
				+ ", email=" + email + ", sdt=" + sdt + ", cccd=" + cccd + ", idPX=" + idPX + "]";
	}
	
	
}
