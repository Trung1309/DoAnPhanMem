package com.doanphanmem.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.doanphammem.model.DonHang;
import com.doanphanmem.dao.DonHangDao;
import com.doanphanmem.dao.NhanVienDao;

@WebServlet(urlPatterns= {"/locTTNV"})
public class FilterTTDHNV extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FilterTTDHNV() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		String maNV = request.getParameter("maNV");
		String trangThai = request.getParameter("txtTrangThai");
		String khuVuc= request.getParameter("txtKhuVuc");
		NhanVienDao nhanVienDao = new NhanVienDao();
		
		List<DonHang> list = nhanVienDao.getDonHangTrangThai(maNV, trangThai);
		
		request.setAttribute("listAllDH", list);
		request.setAttribute("txtTT", trangThai);
		request.getRequestDispatcher("/nhanVienViews/manager.jsp").forward(request, response);
	}

}
