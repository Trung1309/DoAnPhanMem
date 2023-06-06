package com.doanphanmem.dao;

import java.util.ArrayList;
import java.util.List;

import com.doanphammem.model.DonHang;
import com.doanphammem.model.DonHangDetail;
import com.doanphammem.model.ThongKe;
import com.doanphanmem.connect.DatabaseHelper;

import java.sql.*;

public class DonHangDao {
	Connection conn = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	public List<DonHang> getAllListDonHang(){
		List<DonHang> list = new ArrayList<DonHang>();
		//Khai báo một danh sách lưu trữ dữ liệu
	
		String sql = "select *,format((soLuong * khoiLuong *MaGoiCuoc),'#,##,###')\r\n" + 
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
						rs.getString(22),
						rs.getString(23),
						rs.getString(24)));													
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	
		return list;
	}
	
	
	
	public List<DonHang> getAllListDonHangKH(String user){
		List<DonHang> list = new ArrayList<DonHang>();
		//Khai báo một danh sách lưu trữ dữ liệu
	
		String sql = "select * ,format((soLuong * khoiLuong *MaGoiCuoc),'#,##,###') \r\n" + 
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
						rs.getString(22),
						rs.getString(23),
						rs.getString(24)));						
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
		String sql = "select *,format((soLuong * khoiLuong *MaGoiCuoc),'#,##,###') \r\n" + 
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
						rs.getString(22),
						rs.getString(23),
						rs.getString(24)));		
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}	
	public void addDonHang(String tenNguoiNhan,String diaChiNhanHang, String diaChiGiaoHang,
			String tinhThanh, String quanHuyen, String phuongXa, String sdtNguoiNhan,
			String dichVu, int khoiLuong,String tenSP, int soLuong, String tenTKKH,String loaiGoiCuoc,
			String hinhAnh) {
		String sql = "EXEC proc_taoDonHang \r\n" + 
				"	@tenNguoiNhan = ?,\r\n" + 
				"	@diaChiNhanHang = ?,\r\n" + 
				"	@diaChiGiaoHang  = ?,\r\n" + 
				"	@tinhThanh = ?,\r\n" + 
				"	@quanHuyen = ?,\r\n" + 
				"	@phuongXa = ?,\r\n" + 
				"	@sdtNguoiNhan = ?,\r\n" + 
				"	@dichVu = ?,\r\n" + 
				"	@khoiLuong = ?,\r\n" + 
				"	@tenSP = ?,\r\n" + 
				"	@soLuong = ?,\r\n" + 
				"	@tenTKKH = ?,\r\n" +
				"	@loaiGoiCuoc = ?,\r\n" +
				"   @hinhAnh = ?";
		try {
			conn = new DatabaseHelper().openConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, tenNguoiNhan);
			ps.setString(2, diaChiNhanHang);
			ps.setString(3, diaChiGiaoHang);
			ps.setString(4, tinhThanh);
			ps.setString(5, quanHuyen);
			ps.setString(6, phuongXa);
			ps.setString(7, sdtNguoiNhan);
			ps.setString(8, dichVu);
			ps.setInt(9, khoiLuong);
			ps.setString(10, tenSP);
			ps.setInt(11, soLuong);
			ps.setString(12, tenTKKH);
			ps.setString(13, loaiGoiCuoc);
			ps.setString(14, hinhAnh);
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
		String sql = "select * ,format((soLuong * khoiLuong *MaGoiCuoc),'#,##,###')\r\n" + 
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
						rs.getString(22),
						rs.getString(23),
						rs.getString(24)));		
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
				"SELECT *,format((soLuong * khoiLuong *MaGoiCuoc),'#,##,###')\r\n" + 
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
						rs.getString(22),
						rs.getString(23),
						rs.getString(24));		
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
			return null;
	}
	
	public DonHangDetail getDetailDonHang2(String maDH) {
		String sql = " select maDH, kh.TenKH,kh.Sdt,kh.Email,dh.diaChiNhanHang,dh.DiaChiGH,dh.phuongXa,dh.quanHuyen,dh.tinhThanh,(soLuong*khoiLuong*MaGoiCuoc)as ThanhTien, hoTenNguoiNhan,SdtNguoiNhan,NgayTaoDon,nv.TenNV,NgayGiaoHang,TrangThaiDonHang,tenSP,loaiSP,dh.hinhAnh\r\n" + 
				"from tbl_DonHang dh\r\n" + 
				"join tbl_nhanVien nv on dh.TenTKNV = nv.TenTKNV\r\n" + 
				"join tbl_KhachHang kh on dh.TenTKKH = kh.TenTKKH\r\n" + 
				"where dh.MaDH = ?";
		try {
			conn = new DatabaseHelper().openConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, maDH);
			rs = ps.executeQuery();
			while (rs.next()) {
				return new DonHangDetail(
						rs.getString(1), 
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
						rs.getString(13), 
						rs.getString(14), 
						rs.getString(15),
						rs.getString(16),
						rs.getString(17),
						rs.getString(18),
						rs.getString(19));
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	public List<DonHang> searchDonHangByKH(String maDH,String sdt,String maKH) {
		String sql = "select *,format((soLuong * khoiLuong *MaGoiCuoc),'#,##,###') \r\n" + 
				"from tbl_DonHang\r\n" + 
				"where MaDH like ? or SdtNguoiNhan = ? and TenTKKH = ?";
		List<DonHang> list = new ArrayList<DonHang>();
		try {
			conn = new DatabaseHelper().openConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1,"%" + maDH + "%");
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
						rs.getString(22),
						rs.getString(23),
						rs.getString(24)));	
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
		String sql = "select * ,format((soLuong * khoiLuong *MaGoiCuoc),'#,##,###')\r\n" + 
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
						rs.getString(22),
						rs.getString(23),
						rs.getString(24)));	
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}
	
	public List<DonHang> searchDonHangByNV(String maDH,String sdt) {
		String sql = "select * ,format((soLuong * khoiLuong *MaGoiCuoc),'#,##,###')\r\n" + 
				"from tbl_DonHang\r\n" + 
				"where MaDH like ? or SdtNguoiNhan like ?\r\n" +
				"order by MaDH desc";
		List<DonHang> list = new ArrayList<DonHang>();
		try {
			conn = new DatabaseHelper().openConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1,"%"+maDH+"%");
			ps.setString(2,"%"+sdt+"%");
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
	
	public List<DonHang> filterDonHangByNV(String trangThai,String khuVuc ) {
		String sql = "select * ,format((soLuong * khoiLuong *MaGoiCuoc),'#,##,###')\r\n" + 
				"from tbl_DonHang\r\n" + 
				"where TrangThaiDonHang = ? and tinhThanh = ? or TrangThaiDonHang = ? or tinhThanh = ? \r\n" + 
				"order by MaDH desc";
		List<DonHang> list = new ArrayList<DonHang>();
		try {
			conn = new DatabaseHelper().openConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, trangThai);
			ps.setString(2, khuVuc);
			ps.setString(3, trangThai);
			ps.setString(4, khuVuc);
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
	
	public String getSales() {
		String sql = "select format(sum(soLuong * khoiLuong *MaGoiCuoc),'#,##,###')\r\n" + 
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
	
	
	public List<ThongKe> getDoanhThuTheoThang(){
		String sql = "select MONTH(NgayTaoDon),(sum(soLuong * khoiLuong * MaGoiCuoc))\r\n" + 
				"from tbl_DonHang\r\n" + 
				"group by MONTH(NgayTaoDon)";
		List<ThongKe> list = new ArrayList<ThongKe>();
		try {
			conn = new DatabaseHelper().openConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(new ThongKe(rs.getInt(1), rs.getInt(2)));		
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}
	
	
	
	public DonHangDetail getDetailDonHang2KH(String maDH) {
		String sql = "select maDH, kh.TenKH,kh.Sdt,kh.Email,dh.diaChiNhanHang,dh.DiaChiGH,dh.phuongXa,dh.quanHuyen,dh.tinhThanh,(soLuong*khoiLuong*MaGoiCuoc)as ThanhTien, hoTenNguoiNhan,SdtNguoiNhan,NgayTaoDon,null,NgayGiaoHang,TrangThaiDonHang,tenSP,loaiSP,dh.hinhAnh\r\n" + 
				"from tbl_DonHang dh\r\n" + 
				"join tbl_KhachHang kh on dh.TenTKKH = kh.TenTKKH\r\n" + 
				"where dh.MaDH = ?";
		try {
			conn = new DatabaseHelper().openConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, maDH);
			rs = ps.executeQuery();
			while (rs.next()) {
				return new DonHangDetail(
						rs.getString(1), 
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
						rs.getString(13), 
						rs.getString(14), 
						rs.getString(15),
						rs.getString(16),
						rs.getString(17),
						rs.getString(18),
						rs.getString(19));
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return null;
	}
	
	
	
	public static void main(String[] args) {
		DonHangDao d=  new DonHangDao();
		DonHangDetail i = d.getDetailDonHang2KH("90");
		System.out.println(i);
		
	}
}
