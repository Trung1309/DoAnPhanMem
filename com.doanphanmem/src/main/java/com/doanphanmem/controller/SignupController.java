package com.doanphanmem.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.doanphammem.model.KhachHang;
import com.doanphanmem.dao.SignUpDao;
import com.doanphanmem.dao.dao;

@WebServlet(urlPatterns= {"/signup"})
public class SignupController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignupController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.getRequestDispatcher("/views/signup.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		
		String tenDN = request.getParameter("tenDN");
		String hoTen = request.getParameter("hoten");
		String email = request.getParameter("email");
		String sdt = request.getParameter("sdt");
		String matKhau = request.getParameter("pass");
		String repass = request.getParameter("repass");
		
		SignUpDao signUpDao = new SignUpDao();
		
		if (!matKhau.equals(repass)) {
			request.getRequestDispatcher("/views/signup.jsp").forward(request, response);
		}
		else {
			KhachHang khachHang = signUpDao.checkUser(tenDN);
			if (khachHang==null){
				signUpDao.SignUp(tenDN, hoTen, email, sdt, matKhau);
				dao d = new dao();
				KhachHang userModel = d.loginKH(tenDN, matKhau);
				if (userModel!=null) {
					request.setAttribute("messSuccsess", "Bạn đã đăng kí tài khoản thành công quay lại đăng nhập");
					request.getRequestDispatcher("/views/signup.jsp").forward(request, response);
				}				
			}else {	
				request.setAttribute("messDanger", "Tài khoản đã tồn tại vui lòng đổi tên đăng nhập");
				request.getRequestDispatcher("/views/signup.jsp").forward(request, response);
				
			}
		}
		
	}

}
