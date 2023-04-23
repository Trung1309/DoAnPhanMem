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

@WebServlet(urlPatterns= {"/home"})
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		
		
		String user = request.getParameter("idKH");
		
		
		DonHangDao donHangDao = new DonHangDao();
		List<DonHang> listAll = donHangDao.getAllListDonHang();
		List<DonHang> listDHByKH = donHangDao.getAllListDonHangKH(user);
		
		request.setAttribute("listAllDonHang", listAll);
		request.setAttribute("listAllDonHangKH", listDHByKH);
		request.getRequestDispatcher("/views/home.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
