package com.doanphanmem.dao;

import java.sql.*;

import com.doanphammem.model.KhachHang;
import com.doanphanmem.connect.DatabaseHelper;


public class SignUpDao {
	
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	public KhachHang checkUser(String tenDN) {
		String sql = "select *\r\n" + 
				"from tbl_KhachHang\r\n" + 
				"where TenTKKH = ?";
		try {
			conn = new DatabaseHelper().openConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, tenDN);
			rs = ps.executeQuery();
			while (rs.next()) {
				return new KhachHang(
						rs.getString(1), 
						rs.getInt(2), 
						rs.getString(3), 
						rs.getString(4), 
						rs.getString(5), 
						rs.getString(6), 
						rs.getString(7), 
						rs.getString(8),
						rs.getString(9),
						rs.getString(10),
						rs.getString(11),
						rs.getString(12));			
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;	
	}
	
	public void SignUp(String tenDN,String hoten, String email, String sdt, String matKhau) {
		String sql = "EXEC proc_dangKiTaiKhoan \r\n" + 
				"	@tenDN = ?,\r\n" + 
				"	@tenKH = ?,\r\n" + 
				"	@email = ?,\r\n" + 
				"	@sdt = ?,\r\n" + 
				"	@matKhau = ?";
		try {
			conn = new DatabaseHelper().openConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, tenDN);
			ps.setString(2, hoten);
			ps.setString(3, email);
			ps.setString(4, sdt);
			ps.setString(5, matKhau);
			ps.executeUpdate();
		} catch (Exception e) {		
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		
	}
}
