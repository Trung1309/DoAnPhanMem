package com.doanphammem.model;

public class TableDonHang {
	private int maDH;
	private String sdtNguoiGui;
	private String ngayTaoDon;
	private String sdtNguoiNhan;
	private String trangThai;
	public int getMaDH() {
		return maDH;
	}
	public void setMaDH(int maDH) {
		this.maDH = maDH;
	}
	public String getSdtNguoiGui() {
		return sdtNguoiGui;
	}
	public void setSdtNguoiGui(String sdtNguoiGui) {
		this.sdtNguoiGui = sdtNguoiGui;
	}
	public String getNgayTaoDon() {
		return ngayTaoDon;
	}
	public void setNgayTaoDon(String ngayTaoDon) {
		this.ngayTaoDon = ngayTaoDon;
	}
	public String getSdtNguoiNhan() {
		return sdtNguoiNhan;
	}
	public void setSdtNguoiNhan(String sdtNguoiNhan) {
		this.sdtNguoiNhan = sdtNguoiNhan;
	}
	public String getTrangThai() {
		return trangThai;
	}
	public void setTrangThai(String trangThai) {
		this.trangThai = trangThai;
	}
	public TableDonHang() {
		super();
	}
	public TableDonHang(int maDH, String sdtNguoiGui, String ngayTaoDon, String sdtNguoiNhan, String trangThai) {
		super();
		this.maDH = maDH;
		this.sdtNguoiGui = sdtNguoiGui;
		this.ngayTaoDon = ngayTaoDon;
		this.sdtNguoiNhan = sdtNguoiNhan;
		this.trangThai = trangThai;
	}
	@Override
	public String toString() {
		return "TableDonHang [maDH=" + maDH + ", sdtNguoiGui=" + sdtNguoiGui + ", ngayTaoDon=" + ngayTaoDon
				+ ", sdtNguoiNhan=" + sdtNguoiNhan + ", trangThai=" + trangThai + "]";
	}
	
	
}
