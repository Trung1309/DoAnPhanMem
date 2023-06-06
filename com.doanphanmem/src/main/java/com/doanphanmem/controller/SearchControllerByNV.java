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

@WebServlet(urlPatterns= {"/searchByNV"})
public class SearchControllerByNV extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchControllerByNV() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		String txtSearch = request.getParameter("txt");
		
		DonHangDao dao = new DonHangDao();
		List<DonHang> dhByNV = dao.searchDonHangByNV(txtSearch, txtSearch);
		if (dhByNV != null) {
			request.setAttribute("listAllDH", dhByNV);
		}else {
			request.setAttribute("messNotFound", "Không tìm thấy đơn hàng");
		}
		request.setAttribute("txtSearch", txtSearch);
		request.getRequestDispatcher("/views/manager.jsp").forward(request, response);

	}

}
