package com.doanphanmem.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.doanphammem.model.Admin;
import com.doanphammem.model.KhachHang;
import com.doanphammem.model.NhanVien;
import com.doanphammem.model.QuanLi;
import com.doanphanmem.dao.dao;

@WebServlet(urlPatterns= {"/login"})
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.getRequestDispatcher("/views/login.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		
		String userName = request.getParameter("user");
		String passWord = request.getParameter("pass");
		
		dao d = new dao();
		Admin admin = d.loginAD(userName, passWord);
		QuanLi quanLi = d.loginQL(userName, passWord);
		KhachHang khachHang = d.loginKH(userName, passWord);
		NhanVien nhanVien = d.loginNV(userName, passWord);
		
		
		if (khachHang == null) {
			if (nhanVien == null) {
				if (admin == null) {
					if (quanLi == null) {
						request.setAttribute("mess", "Sai tài khoản mật khẩu");
						request.getRequestDispatcher("/views/login.jsp").forward(request, response);
						
					}else {
						HttpSession session = request.getSession();
						session.setAttribute("acc", quanLi);
						request.getRequestDispatcher("home").forward(request, response);
					}
				}else {
					HttpSession session = request.getSession();
					session.setAttribute("acc", admin);
					request.getRequestDispatcher("home").forward(request, response);
				}				
			}
			else {
				HttpSession session = request.getSession();
				session.setAttribute("acc", nhanVien);
				request.getRequestDispatcher("home").forward(request, response);				
			}
		}else {
			HttpSession session = request.getSession();
			session.setAttribute("acc", khachHang);
			request.getRequestDispatcher("home").forward(request, response);	
		}
	
	}

}
