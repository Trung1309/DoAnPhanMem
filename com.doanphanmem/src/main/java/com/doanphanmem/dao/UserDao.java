package com.doanphanmem.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.doanphammem.model.KhachHang;
import com.doanphammem.model.NhanVien;
import com.doanphanmem.connect.DatabaseHelper;

public class UserDao {
	Connection conn = null ;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	public List<KhachHang> getListAllKH(){
		List<KhachHang> list = new ArrayList<KhachHang>();
		String sql = "select *\r\n" + 
				"from tbl_KhachHang";
		
		try {
			conn = new DatabaseHelper().openConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new KhachHang(
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
						rs.getString(12)));	
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return list;
		
	}
	
	public List<NhanVien> getListAllNV(){
		List<NhanVien> list = new ArrayList<NhanVien>();
		String sql = "select *\r\n" + 
				"from tbl_nhanVien";
		
		try {
			conn = new DatabaseHelper().openConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new NhanVien(
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
						rs.getString(12), 
						rs.getString(13)));	
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return list;
		
	}
	
	public int getCountUsers() {
		String sql = "\r\n" + 
				"select count(*)\r\n" + 
				"from tbl_KhachHang";
		try {
			conn= new DatabaseHelper().openConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				return rs.getInt(1);
				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return 0;
	}
	public KhachHang updateUsers(String hoTen, String email,String diaChi, String phuongXa, String quanHuyen, String tinhThanh,String tenTKKH, String sdt) {
		String sql = "update tbl_KhachHang\r\n" + 
				"set TenKH  = ?, Email = ?, diaChi = ?, phuongXa = ?, quanHuyen = ?, tinhThanh = ? , Sdt = ?\r\n" + 
				"where TenTKKH = ?";
		try {
			conn = new DatabaseHelper().openConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, hoTen);
			ps.setString(2, email);
			ps.setString(3, diaChi);
			ps.setString(4, phuongXa);
			ps.setString(5, quanHuyen);
			ps.setString(6, tinhThanh);
			ps.setString(7, sdt);
			ps.setString(8, tenTKKH);
			ps.executeUpdate();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return null;
	}
	
	public static void main(String[] args) {
		UserDao u = new UserDao();
		
	}
}
