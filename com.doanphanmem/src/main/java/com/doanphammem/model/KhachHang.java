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
	private String diaChi;
	private String phuongXa;
	private String quanHuyen;
	private String tinhThanh;
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

	public String getDiaChi() {
		return diaChi;
	}
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	public String getPhuongXa() {
		return phuongXa;
	}
	public void setPhuongXa(String phuongXa) {
		this.phuongXa = phuongXa;
	}
	public String getQuanHuyen() {
		return quanHuyen;
	}
	public void setQuanHuyen(String quanHuyen) {
		this.quanHuyen = quanHuyen;
	}
	public String getTinhThanh() {
		return tinhThanh;
	}
	public void setTinhThanh(String tinhThanh) {
		this.tinhThanh = tinhThanh;
	}
	public KhachHang() {
		super();
	}
	public KhachHang(String tenDN, int maQuyen, String matKhau, String hoTen, String email, String sdt, String cccd,
			String idPX, String diaChi, String phuongXa, String quanHuyen, String tinhThanh) {
		super();
		this.tenDN = tenDN;
		this.maQuyen = maQuyen;
		this.matKhau = matKhau;
		this.hoTen = hoTen;
		this.email = email;
		this.sdt = sdt;
		this.cccd = cccd;
		this.idPX = idPX;
		this.diaChi = diaChi;
		this.phuongXa = phuongXa;
		this.quanHuyen = quanHuyen;
		this.tinhThanh = tinhThanh;
	}
	@Override
	public String toString() {
		return "KhachHang [tenDN=" + tenDN + ", maQuyen=" + maQuyen + ", matKhau=" + matKhau + ", hoTen=" + hoTen
				+ ", email=" + email + ", sdt=" + sdt + ", cccd=" + cccd + ", idPX=" + idPX + ", diaChi=" + diaChi
				+ ", phuongXa=" + phuongXa + ", quanHuyen=" + quanHuyen + ", tinhThanh=" + tinhThanh + "]";
	}

	
	
	
}
