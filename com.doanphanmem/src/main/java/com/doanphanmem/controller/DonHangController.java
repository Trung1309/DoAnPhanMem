package com.doanphanmem.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.doanphammem.model.DonHang;
import com.doanphammem.model.TableDonHang;
import com.doanphanmem.dao.DonHangDao;
import com.doanphanmem.dao.dao;


/**
 * Servlet implementation class DonHangController
 */
@WebServlet(urlPatterns= {"/quanli"})
public class DonHangController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DonHangController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		
		String maKH = request.getParameter("idKH");
		
		DonHangDao dao = new DonHangDao();
		
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
		request.setAttribute("tagNumPageNV", indexNumPageNV);
		request.setAttribute("endPNV",endPNV);
		
		
		//Thiết lập số trang khách hàng
		String indexNumPage = request.getParameter("numPage");
		if (indexNumPage == null) {
			indexNumPage ="1";
		}
		int numPage = Integer.parseInt(indexNumPage);
		int soLuong = 10;                                                                                                                                                       ;
		
		List<DonHang> list = dao.getPagingDonHang(maKH, numPage, soLuong);

		int count = dao.getTotalDonHang(maKH);
		int endP = count /soLuong;
		if (count % soLuong != 0) {
			endP++;
		}
			
		//Thiết lập ngày nhỏ nhất lớn nhất
		String minDay = dao.getMinDayGiaoHang();
		String maxDay = dao.getMaxDayGiaoHang();
		
		request.setAttribute("maxDay", maxDay);
		request.setAttribute("minDay", minDay);
		//B3: Thiết lập dữ liệu lên jsp
		
		request.setAttribute("tagNumPage", indexNumPage);
		request.setAttribute("endP", endP);
		
		//B4: Trả về trang jsp
		request.setAttribute("listAllDH", listAllDonHangNV);
		request.setAttribute("listAllDHByKH", list);

		
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
