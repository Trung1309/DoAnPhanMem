package com.doanphanmem.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.StyledEditorKit.StyledTextAction;

import com.doanphammem.model.DonHang;
import com.doanphanmem.dao.DonHangDao;
import com.doanphanmem.dao.dao;

@WebServlet(urlPatterns={"/searchDH"})
public class SearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchController() {
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
		
		String txtSearch = request.getParameter("txt");
		String idKH = request.getParameter("maKH");
		
		DonHangDao dao = new DonHangDao();
		List<DonHang> dh = dao.searchDonHangByKH(txtSearch,txtSearch, idKH);
		
		if (dh != null) {
			request.setAttribute("listAllDHByKH", dh);
		}else if(dh == null) {
			request.setAttribute("messNotFound", "Không tìm thấy đơn hàng");
		}
			
		request.getRequestDispatcher("/views/manager.jsp").forward(request, response);
	}

}
