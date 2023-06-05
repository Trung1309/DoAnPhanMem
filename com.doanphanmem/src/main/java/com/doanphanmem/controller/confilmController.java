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

/**
 * Servlet implementation class confilmController
 */
@WebServlet(urlPatterns="/confilm")
public class confilmController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public confilmController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		
		String maNV = request.getParameter("maNV");
		String maDH = request.getParameter("maDH");
		
		DonHangDao dao = new DonHangDao();
		dao.confilmDH(maNV, maDH);
		
		String indexNumPageNV = request.getParameter("numPageNV");
		if (indexNumPageNV == null) {
			indexNumPageNV = "1";
		}
		int numPageNV = Integer.parseInt(indexNumPageNV);
		
		//Thiết lập số trang nhân viên
		int countTotalDH = dao.getTotalAllDonHang();
		int soLuongDHNV = 10;
		int endPNV = countTotalDH/soLuongDHNV;
		List<DonHang> listAllDonHangNV = dao.getAllPagingDonHang(numPageNV, soLuongDHNV);
		if (countTotalDH % soLuongDHNV != 0) {
			endPNV++;
		}
		request.setAttribute("messSuccsess", "Đơn hàng đã được xác nhận");
		request.setAttribute("tagNumPageNV", indexNumPageNV);
		request.setAttribute("endPNV",endPNV);
		request.setAttribute("listAllDH", listAllDonHangNV);
		request.getRequestDispatcher("/views/manager.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
