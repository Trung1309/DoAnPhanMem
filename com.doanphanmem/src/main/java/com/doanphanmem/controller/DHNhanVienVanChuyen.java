package com.doanphanmem.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.doanphammem.model.DonHang;
import com.doanphammem.model.DonHangDetail;
import com.doanphanmem.dao.DonHangDao;
import com.doanphanmem.dao.NhanVienDao;

@WebServlet(urlPatterns= {"/dhNhanVien"})
public class DHNhanVienVanChuyen extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DHNhanVienVanChuyen() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		
		String maNV = request.getParameter("maNV");
		NhanVienDao nhanVienDao = new NhanVienDao();
		List<DonHang> listAllDonHangNV = nhanVienDao.getDonHangNhanVien(maNV);
		
		
		request.setAttribute("listAllDH", listAllDonHangNV);
		request.getRequestDispatcher("/nhanVienViews/manager.jsp").forward(request, response);

	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
