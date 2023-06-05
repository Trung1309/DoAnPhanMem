package com.doanphammem.model;

public class DonHangDetail {
	 private String maDH;	
	 private String tenKH;
	 private String sdt;
	 private String email;
	 private String diaChiNhanHang;
	 private String diaChiGH;
	 private String phuongXa;
	 private String quanHuyen;
	 private String tinhThanh;
	 private String thanhTien;
	 private String hoTenNguoiNhan;
	 private String sdtNguoiNhan;
	 private String ngayTaoDon;
	 private String tenNV;
	 private String ngayGiaoHang;
	 private String trangThaiDonHang;
	 private String tenSP;
	 private String loaiSP;
	 private String hinhAnh;
	public String getMaDH() {
		return maDH;
	}
	public void setMaDH(String maDH) {
		this.maDH = maDH;
	}
	public String getTenKH() {
		return tenKH;
	}
	public void setTenKH(String tenKH) {
		this.tenKH = tenKH;
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
	public String getDiaChiNhanHang() {
		return diaChiNhanHang;
	}
	public void setDiaChiNhanHang(String diaChiNhanHang) {
		this.diaChiNhanHang = diaChiNhanHang;
	}
	public String getDiaChiGH() {
		return diaChiGH;
	}
	public void setDiaChiGH(String diaChiGH) {
		this.diaChiGH = diaChiGH;
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
	public String getThanhTien() {
		return thanhTien;
	}
	public void setThanhTien(String thanhTien) {
		this.thanhTien = thanhTien;
	}
	public String getHoTenNguoiNhan() {
		return hoTenNguoiNhan;
	}
	public void setHoTenNguoiNhan(String hoTenNguoiNhan) {
		this.hoTenNguoiNhan = hoTenNguoiNhan;
	}
	public String getSdtNguoiNhan() {
		return sdtNguoiNhan;
	}
	public void setSdtNguoiNhan(String sdtNguoiNhan) {
		this.sdtNguoiNhan = sdtNguoiNhan;
	}
	public String getNgayTaoDon() {
		return ngayTaoDon;
	}
	public void setNgayTaoDon(String ngayTaoDon) {
		this.ngayTaoDon = ngayTaoDon;
	}
	public String getTenNV() {
		return tenNV;
	}
	public void setTenNV(String tenNV) {
		this.tenNV = tenNV;
	}
	public String getNgayGiaoHang() {
		return ngayGiaoHang;
	}
	public void setNgayGiaoHang(String ngayGiaoHang) {
		this.ngayGiaoHang = ngayGiaoHang;
	}
	public String getTrangThaiDonHang() {
		return trangThaiDonHang;
	}
	public void setTrangThaiDonHang(String trangThaiDonHang) {
		this.trangThaiDonHang = trangThaiDonHang;
	}
	public String getTenSP() {
		return tenSP;
	}
	public void setTenSP(String tenSP) {
		this.tenSP = tenSP;
	}
	public String getLoaiSP() {
		return loaiSP;
	}
	public void setLoaiSP(String loaiSP) {
		this.loaiSP = loaiSP;
	}
	public String getHinhAnh() {
		return hinhAnh;
	}
	public void setHinhAnh(String hinhAnh) {
		this.hinhAnh = hinhAnh;
	}
	public DonHangDetail() {
		super();
	}
	public DonHangDetail(String maDH, String tenKH, String sdt, String email, String diaChiNhanHang, String diaChiGH,
			String phuongXa, String quanHuyen, String tinhThanh, String thanhTien, String hoTenNguoiNhan,
			String sdtNguoiNhan, String ngayTaoDon, String tenNV, String ngayGiaoHang, String trangThaiDonHang,
			String tenSP, String loaiSP, String hinhAnh) {
		super();
		this.maDH = maDH;
		this.tenKH = tenKH;
		this.sdt = sdt;
		this.email = email;
		this.diaChiNhanHang = diaChiNhanHang;
		this.diaChiGH = diaChiGH;
		this.phuongXa = phuongXa;
		this.quanHuyen = quanHuyen;
		this.tinhThanh = tinhThanh;
		this.thanhTien = thanhTien;
		this.hoTenNguoiNhan = hoTenNguoiNhan;
		this.sdtNguoiNhan = sdtNguoiNhan;
		this.ngayTaoDon = ngayTaoDon;
		this.tenNV = tenNV;
		this.ngayGiaoHang = ngayGiaoHang;
		this.trangThaiDonHang = trangThaiDonHang;
		this.tenSP = tenSP;
		this.loaiSP = loaiSP;
		this.hinhAnh = hinhAnh;
	}
	@Override
	public String toString() {
		return "DonHangDetail [maDH=" + maDH + ", tenKH=" + tenKH + ", sdt=" + sdt + ", email=" + email
				+ ", diaChiNhanHang=" + diaChiNhanHang + ", diaChiGH=" + diaChiGH + ", phuongXa=" + phuongXa
				+ ", quanHuyen=" + quanHuyen + ", tinhThanh=" + tinhThanh + ", thanhTien=" + thanhTien
				+ ", hoTenNguoiNhan=" + hoTenNguoiNhan + ", sdtNguoiNhan=" + sdtNguoiNhan + ", ngayTaoDon=" + ngayTaoDon
				+ ", tenNV=" + tenNV + ", ngayGiaoHang=" + ngayGiaoHang + ", trangThaiDonHang=" + trangThaiDonHang
				+ ", tenSP=" + tenSP + ", loaiSP=" + loaiSP + ", hinhAnh=" + hinhAnh + "]";
	}
	 
	
	 
	 
}
