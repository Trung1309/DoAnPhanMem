package com.doanphammem.model;

public class NhanVien {
	private String tenDN;
	private int maQuyen;
	private String matKhau;
	private String hoTen;
	private String ngaySinh;
	private String cccd	;
	private String gioiTinh;
	private String sdt;
	private String email;
	private String ngayQD;
	private String anh;
	private String idPX;
	private String maCV;
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
	public String getNgaySinh() {
		return ngaySinh;
	}
	public void setNgaySinh(String ngaySinh) {
		this.ngaySinh = ngaySinh;
	}
	public String getCccd() {
		return cccd;
	}
	public void setCccd(String cccd) {
		this.cccd = cccd;
	}
	public String getGioiTinh() {
		return gioiTinh;
	}
	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNgayQD() {
		return ngayQD;
	}
	public void setNgayQD(String ngayQD) {
		this.ngayQD = ngayQD;
	}
	public String getAnh() {
		return anh;
	}
	public void setAnh(String anh) {
		this.anh = anh;
	}
	public String getIdPX() {
		return idPX;
	}
	public void setIdPX(String idPX) {
		this.idPX = idPX;
	}
	public String getMaCV() {
		return maCV;
	}
	public void setMaCV(String maCV) {
		this.maCV = maCV;
	}
	public NhanVien() {
		super();
	}
	public NhanVien(String tenDN, int maQuyen, String matKhau, String hoTen, String ngaySinh, String cccd,
			String gioiTinh, String sdt, String email, String ngayQD, String anh, String idPX, String maCV) {
		super();
		this.tenDN = tenDN;
		this.maQuyen = maQuyen;
		this.matKhau = matKhau;
		this.hoTen = hoTen;
		this.ngaySinh = ngaySinh;
		this.cccd = cccd;
		this.gioiTinh = gioiTinh;
		this.sdt = sdt;
		this.email = email;
		this.ngayQD = ngayQD;
		this.anh = anh;
		this.idPX = idPX;
		this.maCV = maCV;
	}
	@Override
	public String toString() {
		return "NhanVien [tenDN=" + tenDN + ", maQuyen=" + maQuyen + ", matKhau=" + matKhau + ", hoTen=" + hoTen
				+ ", ngaySinh=" + ngaySinh + ", cccd=" + cccd + ", gioiTinh=" + gioiTinh + ", sdt=" + sdt + ", email="
				+ email + ", ngayQD=" + ngayQD + ", anh=" + anh + ", idPX=" + idPX + ", maCV=" + maCV + "]";
	}
	
	
	
	
	
	
	
}
