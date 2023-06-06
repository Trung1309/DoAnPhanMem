package com.doanphanmem.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.doanphammem.model.KhachHang;
import com.doanphanmem.dao.SignUpDao;
import com.doanphanmem.dao.UserDao;


@WebServlet(urlPatterns= {"/profileEdit"})
public class EditProfile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditProfile() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		String tenTKKH = request.getParameter("tenTKKH");
		SignUpDao signupDao = new SignUpDao();
		KhachHang kh = signupDao.checkUser(tenTKKH);
		
		request.setAttribute("profile", kh);
		request.getRequestDispatcher("/views/editProfile.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		SignUpDao signupDao = new SignUpDao();
		
		
		String tenTKKH = request.getParameter("tenTKKH");
		String hoTen = request.getParameter("hoTen");
		String email = request.getParameter("email");	
		String diaChi = request.getParameter("diaChi");
		String phuongXa = request.getParameter("phuongXa");
		String quanHuyen = request.getParameter("quanHuyen");
		String tinhThanh = request.getParameter("tinhThanh");
		String sdt = request.getParameter("sdt");
		UserDao dao = new UserDao();
		dao.updateUsers(hoTen, email, diaChi, phuongXa, quanHuyen, tinhThanh, tenTKKH,sdt);

		KhachHang kh = signupDao.checkUser(tenTKKH);
		
		
		
		request.setAttribute("profile", kh);
		request.setAttribute("mess", "Cập nhật thông tin cá nhân thành công");
		request.getRequestDispatcher("/views/editProfile.jsp").forward(request, response);

		
	}

}
