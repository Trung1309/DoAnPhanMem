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
	
		String sql = "select * \r\n" + 
				"from tbl_DonHang\r\n" + 
				"order by MaDH desc";
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
						rs.getInt(13), 
						rs.getString(14), 
						rs.getString(15), 
						rs.getString(16), 
						rs.getString(17), 
						rs.getString(18), 
						rs.getInt(19), 
						rs.getInt(20), 
						rs.getString(21), 
						rs.getString(22)));													
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	
		return list;
	}
	
	
	
	public List<DonHang> getAllListDonHangKH(String user){
		List<DonHang> list = new ArrayList<DonHang>();
		//Khai báo một danh sách lưu trữ dữ liệu
	
		String sql = "select * \r\n" + 
				"from tbl_DonHang\r\n" + 
				"where TenTKKH = ?\r\n" + 
				"order by MaDH desc";
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
						rs.getInt(13), 
						rs.getString(14), 
						rs.getString(15), 
						rs.getString(16), 
						rs.getString(17), 
						rs.getString(18), 
						rs.getInt(19), 
						rs.getInt(20), 
						rs.getString(21), 
						rs.getString(22)));						
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	
		return list;
	}
	
	public int getTotalDonHang(String user) {
		String sql = "select count(*)\r\n" + 
				"from tbl_DonHang\r\n" + 
				"where TenTKKH = ?";
		try {
			conn = new DatabaseHelper().openConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, user);
			rs = ps.executeQuery();
			while (rs.next()) {
				return rs.getInt(1);
				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return 0;
	}
	
	public List<DonHang> getPagingDonHang(String user,int numPage, int soLuong){
		String sql = "select * \r\n" + 
				"from tbl_DonHang\r\n" + 
				"where TenTKKH = ?\r\n" + 
				"order by MaDH desc\r\n" + 
				"OFFSET ? ROWS FETCH NEXT ? ROWS ONLY ";
		List<DonHang> list = new ArrayList<DonHang>();
		try {
			conn = new DatabaseHelper().openConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1,	user);
			ps.setInt(2, (numPage-1)*soLuong);
			ps.setInt(3, soLuong);
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
						rs.getString(22)));		
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}
	
	public void addDonHang(String tenNguoiNhan, String diaChiGiaoHang,
			String tinhThanh, String quanHuyen, String phuongXa, String sdtNguoiNhan,
			String dichVu, int khoiLuong,String tenSP, int soLuong, String tenTKKH ) {
		String sql = "EXEC proc_taoDonHang \r\n" + 
				"	@tenNguoiNhan = ?,\r\n" + 
				"	@diaChiGiaoHang  = ?,\r\n" + 
				"	@tinhThanh = ?,\r\n" + 
				"	@quanHuyen = ?,\r\n" + 
				"	@phuongXa = ?,\r\n" + 
				"	@sdtNguoiNhan = ?,\r\n" + 
				"	@dichVu = ?,\r\n" + 
				"	@khoiLuong = ?,\r\n" + 
				"	@tenSP = ?,\r\n" + 
				"	@soLuong = ?,\r\n" + 
				"	@tenTKKH = ?";
		try {
			conn = new DatabaseHelper().openConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, tenNguoiNhan);
			ps.setString(2, diaChiGiaoHang);
			ps.setString(3, tinhThanh);
			ps.setString(4, quanHuyen);
			ps.setString(5, phuongXa);
			ps.setString(6, sdtNguoiNhan);
			ps.setString(7, dichVu);
			ps.setInt(8, khoiLuong);
			ps.setString(9, tenSP);
			ps.setInt(10, soLuong);
			ps.setString(11, tenTKKH);
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}		
	}
	
	
	public int getTotalAllDonHang() {
		String sql = "select count(*)\r\n" + 
				"from tbl_DonHang\r\n";
		try {
			conn = new DatabaseHelper().openConnection();
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
	
	public List<DonHang> getAllPagingDonHang(int numPage, int soLuong){
		String sql = "select * \r\n" + 
				"from tbl_DonHang\r\n" + 
				"order by MaDH desc\r\n" + 
				"OFFSET ? ROWS FETCH NEXT ? ROWS ONLY ";
		List<DonHang> list = new ArrayList<DonHang>();
		try {
			conn = new DatabaseHelper().openConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, (numPage-1)*soLuong);
			ps.setInt(2, soLuong);
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
						rs.getString(22)));		
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}
	
	public void deleteDH(String maDH) {
		String sql = "delete \r\n" + 
				"from tbl_DonHang\r\n" + 
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
	public void confilmDH(String maKH, String maDH) {
		String sql = "update tbl_DonHang\r\n" + 
				"SET TrangThaiDonHang = N'Đang Giao', TenTKNV = ?\r\n" + 
				"WHERE MaDH = ?";
		try {
			conn = new DatabaseHelper().openConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, maKH);
			ps.setString(2, maDH);
			ps.executeUpdate();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public DonHang getDetailDonHang(int maDH) {
		String sql = "\r\n" + 
				"SELECT *\r\n" + 
				"FROM tbl_DonHang\r\n" + 
				"WHERE MaDH = ?";
		try {
			conn = new DatabaseHelper().openConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, maDH);
			rs = ps.executeQuery();
			while (rs.next()) {
				return new DonHang(
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
						rs.getString(22));		
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
			return null;
	}
	
	public List<DonHang> searchDonHangByKH(String maDH,String sdt,String maKH) {
		String sql = "select * \r\n" + 
				"from tbl_DonHang\r\n" + 
				"where MaDH = ? or SdtNguoiNhan = ? and TenTKKH = ?";
		List<DonHang> list = new ArrayList<DonHang>();
		try {
			conn = new DatabaseHelper().openConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, maDH);
			ps.setString(2, sdt);
			ps.setString(3, maKH);
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
						rs.getString(22)));	
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}
	public String getMinDayGiaoHang() {
		String sql = "select min(NgayTaoDon)\r\n" + 
				"from tbl_DonHang";
		try {
			conn = new DatabaseHelper().openConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				return rs.getString(1);
				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	public String getMaxDayGiaoHang() {
		String sql = "select max(NgayTaoDon)\r\n" + 
				"from tbl_DonHang";
		try {
			conn = new DatabaseHelper().openConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				return rs.getString(1);
				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public List<DonHang> filterDonHangByKH(String trangThai,String maKH) {
		String sql = "select *\r\n" + 
				"from tbl_DonHang\r\n" + 
				"where TrangThaiDonHang = ? and TenTKKH = ?";
		List<DonHang> list = new ArrayList<DonHang>();
		try {
			conn = new DatabaseHelper().openConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, trangThai);
			ps.setString(2, maKH);
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
						rs.getString(22)));	
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}
	
	public List<DonHang> searchDonHangByNV(String maDH,String sdt) {
		String sql = "select * \r\n" + 
				"from tbl_DonHang\r\n" + 
				"where MaDH = ? or SdtNguoiNhan = ?";
		List<DonHang> list = new ArrayList<DonHang>();
		try {
			conn = new DatabaseHelper().openConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, maDH);
			ps.setString(2, sdt);
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
						rs.getString(22)));	
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}
	
	public List<DonHang> filterDonHangByNV(String trangThai) {
		String sql = "select *\r\n" + 
				"from tbl_DonHang\r\n" + 
				"where TrangThaiDonHang = ?\r\n" + 
				"order by MaDH desc";
		List<DonHang> list = new ArrayList<DonHang>();
		try {
			conn = new DatabaseHelper().openConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, trangThai);
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
						rs.getString(22)));	
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}
	
	
	public static void main(String[] args) {
		DonHangDao d=  new DonHangDao();
		List<DonHang> l  = d.filterDonHangByNV("Đang Giao");
		for(DonHang i : l) {
			System.out.println(i);
		}
		
	}
}
