package com.doanphanmem.dao;

import java.util.ArrayList;
import java.util.List;

import com.doanphammem.model.DonHang;
import com.doanphanmem.connect.DatabaseHelper;

import java.sql.*;

public class DonHangDao {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	public List<DonHang> getAllListDonHang(){
		List<DonHang> list = new ArrayList<DonHang>();
		//Khai báo một danh sách lưu trữ dữ liệu
	
		String sql = "select *\r\n" + 
				"from tbl_DonHang";
		try {
			//Mở kết nối 
			conn = new DatabaseHelper().openConnection();
			//Thực hiện lệnh query
			ps = conn.prepareStatement(sql);
			//Chạy query nhận kết quả
			rs = ps.executeQuery();
			//Lấy Resutset đổ vào list
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
						rs.getInt(13)));						
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	
		return list;
	}
	
	
	
	public List<DonHang> getAllListDonHangKH(String user){
		List<DonHang> list = new ArrayList<DonHang>();
		//Khai báo một danh sách lưu trữ dữ liệu
	
		String sql = "select *\r\n" + 
				"from tbl_DonHang\r\n" + 
				"where TenTKKH = ?";
		try {
			//Mở kết nối 
			conn = new DatabaseHelper().openConnection();
			//Thực hiện lệnh query
			ps = conn.prepareStatement(sql);
			ps.setString(1, user);
			//Chạy query nhận kết quả
			rs = ps.executeQuery();
			//Lấy Resutset đổ vào list
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
						rs.getInt(13)));						
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	
		return list;
	}
	
	public static void main(String[] args) {
		DonHangDao d=  new DonHangDao();
		List<DonHang> l = d.getAllListDonHangKH("KH00001");
		for (DonHang item : l) {
			System.out.println(item);
		}
	}
}
