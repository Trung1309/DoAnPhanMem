package com.doanphanmem.controller;

import java.io.IOException;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.doanphammem.model.DonHangDetail;
import com.doanphanmem.dao.DonHangDao;
import com.doanphanmem.dao.NhanVienDao;

@WebServlet(urlPatterns= {"/daGiao"})
public class XacNhanDonHang extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public XacNhanDonHang() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		
		String maDH = request.getParameter("maDH");
		NhanVienDao nhanVienDao = new NhanVienDao();
		nhanVienDao.xacNhanDaGiao(maDH);
		
		DonHangDao d = new DonHangDao();
		DonHangDetail detailDH = d.getDetailDonHang2(maDH);
		
		request.setAttribute("dt", detailDH);
		
		
		request.getRequestDispatcher("/views/detalOrder.jsp").forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Thông tin cấu hình SMTP
    	response.setContentType("text/html;charset=UTF-8");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		String maDH = request.getParameter("maDH");
		NhanVienDao nhanVienDao = new NhanVienDao();
		nhanVienDao.xacNhanDaGiao(maDH);
		DonHangDao d = new DonHangDao();
		DonHangDetail detailDH = d.getDetailDonHang2(maDH);
		
		request.setAttribute("dt", detailDH);
        final String username = "quoctrung3887@gmail.com";
        final String password = "acgkknqkdlwovqfd";
        final String host = "smtp.gmail.com";
        final int port = 587;
        
        // Đọc thông tin từ yêu cầu gửi email
        String to = request.getParameter("to");
        
        // Cấu hình các thuộc tính
        java.util.Properties props = new java.util.Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", port);

        // Xây dựng đối tượng Session
        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password);
            }
        });

        try {
            // Tạo đối tượng MimeMessage
            MimeMessage mimeMessage = new MimeMessage(session);
            mimeMessage.setFrom(new InternetAddress(username));
            mimeMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            mimeMessage.setSubject("Thông báo");
            mimeMessage.setText("Đơn hàng của bạn đã được giao thành công cảm ơn bạn đã sử dụng dịch vụ của công ty TNHH Vận chuyển hàng hoá Vận Đạt");
           
            // Gửi email
            Transport.send(mimeMessage);
            
            
            // Chuyển hướng về trang thành công
            request.setAttribute("mess", "Đơn hàng đã giao thành công");
            request.getRequestDispatcher("/views/detalOrder.jsp").forward(request, response);
        } catch (MessagingException e) {
            // Xử lý lỗi khi gửi email
            e.printStackTrace();

            // Chuyển hướng về trang lỗi
           
        }
        
	}

}
