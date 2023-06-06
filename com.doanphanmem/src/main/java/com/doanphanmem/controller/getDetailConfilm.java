package com.doanphanmem.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.doanphammem.model.DonHang;
import com.doanphammem.model.DonHangDetail;
import com.doanphanmem.dao.DonHangDao;

@WebServlet(urlPatterns={"/detail2"})
public class getDetailConfilm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public getDetailConfilm() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		
		String maDH = request.getParameter("maDH");
		
		DonHangDao d = new DonHangDao();
		DonHangDetail detailDH = d.getDetailDonHang2(maDH);
		
		request.setAttribute("dt", detailDH);
		request.getRequestDispatcher("/views/detalOrder.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
