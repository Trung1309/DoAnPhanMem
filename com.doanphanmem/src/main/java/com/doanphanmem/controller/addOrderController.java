package com.doanphanmem.controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.doanphammem.model.DonHang;
import com.doanphanmem.dao.DonHangDao;

/**
 * Servlet implementation class addOrderController
 */
@MultipartConfig
@WebServlet(urlPatterns= {"/addOrder"})
public class addOrderController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addOrderController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.getRequestDispatcher("/views/addOder.jsp").forward(request, response);
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		String maKH = request.getParameter("idKH");
		String tenNguoiNhan = request.getParameter("tenNguoiNhan");
		String diaChiGH = request.getParameter("diaChiGH");
		String tinhThanh = request.getParameter("tinhThanh");
		String quanHuyen = request.getParameter("quanHuyen");
		String phuongXa = request.getParameter("phuongXa");
		String sdtNguoiNhan = request.getParameter("sdtNguoiNhan");
		String dichVu = request.getParameter("dichVu");
		String tenSP = request.getParameter("tenSP");
		String khoiLuong = request.getParameter("khoiLuong");
		String soLuong = request.getParameter("soLuong");
		int sl = Integer.parseInt(soLuong);
		int kl = Integer.parseInt(khoiLuong);
		String loaiGoiCuoc = request.getParameter("loaiGoiCuoc");
		System.out.println("Up");
		Part file = request.getPart("hinhAnh");
		
		String imageFileName = file.getSubmittedFileName();
		System.out.println("ten image: " + imageFileName);
		
		String upLoadPath="D:/JavaWeb/Workd-space/com.doanphanmem/src/main/webapp/imageOrder/"+imageFileName;
		System.out.println("Path: "+ upLoadPath);
		try {
			FileOutputStream fos = new FileOutputStream(upLoadPath);
			InputStream is = file.getInputStream();
			
			byte[] data = new byte[is.available()];
			is.read(data);
			fos.write(data);
			fos.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}	
		
		
		DonHangDao dao = new DonHangDao();
		dao.addDonHang(tenNguoiNhan, diaChiGH, tinhThanh, quanHuyen, phuongXa, sdtNguoiNhan, dichVu, kl, tenSP, sl, maKH,loaiGoiCuoc,imageFileName);
		request.setAttribute("messSuccsess", "Bạn đã tạo đơn hàng thành công và đang chờ xử lý");
		request.getRequestDispatcher("/views/addOder.jsp").forward(request, response);
	}

}
