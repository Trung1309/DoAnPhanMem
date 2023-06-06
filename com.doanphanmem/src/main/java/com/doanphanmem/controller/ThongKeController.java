package com.doanphanmem.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.doanphammem.model.ThongKe;
import com.doanphanmem.dao.DonHangDao;
import com.doanphanmem.dao.UserDao;

@WebServlet(urlPatterns={"/thongke"})
public class ThongKeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ThongKeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		
		DonHangDao dao = new DonHangDao();
		UserDao userDao = new UserDao();
		List<ThongKe> listThongke = dao.getDoanhThuTheoThang();
		int countALLDH = dao.getTotalAllDonHang();
		String sales = dao.getSales();
		int countKH = userDao.getCountUsers();
		
		request.setAttribute("listThongKe", listThongke);
		request.setAttribute("countKH", countKH);
		request.setAttribute("count", countALLDH);
		request.setAttribute("sales", sales);
		request.getRequestDispatcher("/views/thongke.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
