package com.doanphammem.model;

public class ThongKe {
	private int thang;
	private int doanhThu;
	public int getThang() {
		return thang;
	}
	public void setThang(int thang) {
		this.thang = thang;
	}
	public int getDoanhThu() {
		return doanhThu;
	}
	public void setDoanhThu(int doanhThu) {
		this.doanhThu = doanhThu;
	}
	public ThongKe() {
		super();
	}
	public ThongKe(int thang, int doanhThu) {
		super();
		this.thang = thang;
		this.doanhThu = doanhThu;
	}
	@Override
	public String toString() {
		return "ThongKe [thang=" + thang + ", doanhThu=" + doanhThu + "]";
	}
	
	
}	
