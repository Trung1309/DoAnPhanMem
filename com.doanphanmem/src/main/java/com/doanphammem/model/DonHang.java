package com.doanphammem.model;

public class DonHang {
	private int maDH; 
	private String sdtNguoiNhan;
	private String ngayTaoDon;
	private String donGia;
	private String ngayGiaoHang;
	private String trangThaiDonHang;
	private String trangThaiGiaoHang;
	private String diaChiGH;
	private String hinhAnh;
	private String tenTKKH;
	private String TenTKNV;
	private String maGoiCuoc;
	private int maVC;
	public int getMaDH() {
		return maDH;
	}
	public void setMaDH(int maDH) {
		this.maDH = maDH;
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
	public String getDonGia() {
		return donGia;
	}
	public void setDonGia(String donGia) {
		this.donGia = donGia;
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
	public String getTrangThaiGiaoHang() {
		return trangThaiGiaoHang;
	}
	public void setTrangThaiGiaoHang(String trangThaiGiaoHang) {
		this.trangThaiGiaoHang = trangThaiGiaoHang;
	}
	public String getDiaChiGH() {
		return diaChiGH;
	}
	public void setDiaChiGH(String diaChiGH) {
		this.diaChiGH = diaChiGH;
	}
	public String getHinhAnh() {
		return hinhAnh;
	}
	public void setHinhAnh(String hinhAnh) {
		this.hinhAnh = hinhAnh;
	}
	public String getTenTKKH() {
		return tenTKKH;
	}
	public void setTenTKKH(String tenTKKH) {
		this.tenTKKH = tenTKKH;
	}
	public String getTenTKNV() {
		return TenTKNV;
	}
	public void setTenTKNV(String tenTKNV) {
		TenTKNV = tenTKNV;
	}
	public String getMaGoiCuoc() {
		return maGoiCuoc;
	}
	public void setMaGoiCuoc(String maGoiCuoc) {
		this.maGoiCuoc = maGoiCuoc;
	}
	public int getMaVC() {
		return maVC;
	}
	public void setMaVC(int maVC) {
		this.maVC = maVC;
	}
	public DonHang() {
		super();
	}
	public DonHang(int maDH, String sdtNguoiNhan, String ngayTaoDon, String donGia, String ngayGiaoHang,
			String trangThaiDonHang, String trangThaiGiaoHang, String diaChiGH, String hinhAnh, String tenTKKH,
			String tenTKNV, String maGoiCuoc, int maVC) {
		super();
		this.maDH = maDH;
		this.sdtNguoiNhan = sdtNguoiNhan;
		this.ngayTaoDon = ngayTaoDon;
		this.donGia = donGia;
		this.ngayGiaoHang = ngayGiaoHang;
		this.trangThaiDonHang = trangThaiDonHang;
		this.trangThaiGiaoHang = trangThaiGiaoHang;
		this.diaChiGH = diaChiGH;
		this.hinhAnh = hinhAnh;
		this.tenTKKH = tenTKKH;
		TenTKNV = tenTKNV;
		this.maGoiCuoc = maGoiCuoc;
		this.maVC = maVC;
	}
	@Override
	public String toString() {
		return "DonHang [maDH=" + maDH + ", sdtNguoiNhan=" + sdtNguoiNhan + ", ngayTaoDon=" + ngayTaoDon + ", donGia="
				+ donGia + ", ngayGiaoHang=" + ngayGiaoHang + ", trangThaiDonHang=" + trangThaiDonHang
				+ ", trangThaiGiaoHang=" + trangThaiGiaoHang + ", diaChiGH=" + diaChiGH + ", hinhAnh=" + hinhAnh
				+ ", tenTKKH=" + tenTKKH + ", TenTKNV=" + TenTKNV + ", maGoiCuoc=" + maGoiCuoc + ", maVC=" + maVC + "]";
	}
	
	
}	
