package com.doanphanmem.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.doanphammem.model.Admin;
import com.doanphammem.model.KhachHang;
import com.doanphammem.model.NhanVien;
import com.doanphammem.model.QuanLi;
import com.doanphammem.model.TableDonHang;
import com.doanphanmem.connect.DatabaseHelper;

public class dao {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	
	public Admin loginAD(String user, String pass) {
		
		String sql = "select *\r\n" + 
				"from tbl_Admin\r\n" + 
				"where tenTK = ? and matKhau = ?";
		try {
			conn = new DatabaseHelper().openConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, user);
			ps.setString(2, pass);
			rs = ps.executeQuery();
			while (rs.next()) {
				return new Admin(
						rs.getString(1), 
						rs.getString(2), 
						rs.getInt(3));
				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	
	public QuanLi loginQL(String user, String pass) {	
		String sql = "select *\r\n" + 
				"from tbl_banQuanLy\r\n" + 
				"where tenTKQL = ? and matKhau=?";
		try {
			conn = new DatabaseHelper().openConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, user);
			ps.setString(2, pass);
			rs = ps.executeQuery();
			while (rs.next()) {
				return new QuanLi(
						rs.getString(1), 
						rs.getInt(2), 
						rs.getString(3), 
						rs.getString(4));
				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	public KhachHang loginKH(String user, String pass) {
		
		String sql = "select * \r\n" + 
				"from tbl_KhachHang\r\n" + 
				"where TenTKKH = ? and MatKhau = ?";
		try {
			conn = new DatabaseHelper().openConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, user);
			ps.setString(2, pass);
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
	
	
	public NhanVien loginNV(String user, String pass) {
		
		String sql = "select *\r\n" + 
				"from tbl_nhanVien\r\n" + 
				"where TenTKNV = ? and MatKhau = ?";
		try {
			conn = new DatabaseHelper().openConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, user);
			ps.setString(2, pass);
			rs = ps.executeQuery();
			while (rs.next()) {
				return new NhanVien(
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
						rs.getString(13));
				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return null;
		
	}
	
	public List<TableDonHang> getTableAllDonHangByKH(String idKH){
		List<TableDonHang> list = new ArrayList<TableDonHang>();
		String sql = "select MaDH,Sdt,NgayTaoDon,SdtNguoiNhan,TrangThaiDonHang\r\n" + 
				"from tbl_DonHang as dh, tbl_KhachHang as kh\r\n" + 
				"where dh.TenTKKH = kh.TenTKKH and dh.TenTKKH=? ";
		
		try {
			conn = new DatabaseHelper().openConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, idKH);
			rs = ps.executeQuery();
			while (rs.next()) {
				list.add(new TableDonHang(
						rs.getInt(1), 
						rs.getString(2), 
						rs.getString(3), 
						rs.getString(4), 
						rs.getString(5)));
				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}
	
	public static void main(String[] args) {
		dao d = new dao();
		List<TableDonHang> list = d.getTableAllDonHangByKH("KH00001");
		for (TableDonHang i : list) {
			System.out.println(i);
		}
	}
	
}	
