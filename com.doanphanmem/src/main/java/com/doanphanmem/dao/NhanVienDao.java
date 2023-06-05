package com.doanphanmem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.doanphammem.model.DonHang;
import com.doanphanmem.connect.DatabaseHelper;

public class NhanVienDao {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	public List<DonHang> getDonHangNhanVien(String maNV){
		String sql = "select *,format((soLuong * khoiLuong *MaGoiCuoc),'#,##,###') \r\n" + 
				"from tbl_DonHang\r\n" + 
				"where TenTKNV = ?";
		List<DonHang> list = new ArrayList<DonHang>();
		try {
			conn = new DatabaseHelper().openConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, maNV);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new DonHang(
						rs.getInt(1), 
						rs.getString(2), 
						rs.getString(3), 
						rs.getString(4), 
						rs.getString(5), 
						rs.getString(6), 
						rs.getString(7), 
						rs.getString(8), 
						rs.getString(9), 
						rs.getString(10), 
						rs.getString(11), 
						rs.getString(12), 
						rs.getInt(13), 
						rs.getString(14), 
						rs.getString(15), 
						rs.getString(16), 
						rs.getString(17), 
						rs.getString(18), 
						rs.getInt(19), 
						rs.getInt(20), 
						rs.getString(21), 
						rs.getString(22),
						rs.getString(23),
						rs.getString(24)));	
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}
	public void xacNhanDaGiao(String maDH) {
		String sql ="update tbl_DonHang\r\n" + 
				"set TrangThaiDonHang = N'Đã giao',NgayGiaoHang = FORMAT (getdate(), 'yyyy-MM-dd')\r\n" + 
				"where MaDH = ?";
		try {
			conn = new DatabaseHelper().openConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, maDH);
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public List<DonHang> getDonHangTrangThai(String maNV,String trangThai){
		String sql = "select * , format((soLuong * khoiLuong *MaGoiCuoc),'#,##,###') \r\n" + 
				"from tbl_DonHang\r\n" + 
				"where TenTKNV= ? and TrangThaiDonHang = ?";
		List<DonHang> list = new ArrayList<DonHang>();
		try {
			conn = new DatabaseHelper().openConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, maNV);
			ps.setString(2, trangThai);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new DonHang(
						rs.getInt(1), 
						rs.getString(2), 
						rs.getString(3), 
						rs.getString(4), 
						rs.getString(5), 
						rs.getString(6), 
						rs.getString(7), 
						rs.getString(8), 
						rs.getString(9), 
						rs.getString(10), 
						rs.getString(11), 
						rs.getString(12), 
						rs.getInt(13), 
						rs.getString(14), 
						rs.getString(15), 
						rs.getString(16), 
						rs.getString(17), 
						rs.getString(18), 
						rs.getInt(19), 
						rs.getInt(20), 
						rs.getString(21), 
						rs.getString(22),
						rs.getString(23),
						rs.getString(24)));	
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}
	
	
	
	public static void main(String[] args) {
		NhanVienDao dao = new NhanVienDao();
		List<DonHang> list = dao.getDonHangTrangThai("NV00002", "Đang Giao");
		for (DonHang d : list) {
			System.out.println(d);
		}
		
	}
}
