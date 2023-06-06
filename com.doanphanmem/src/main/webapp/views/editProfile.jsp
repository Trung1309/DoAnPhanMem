<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.beans.Statement"%>
<%@page import="com.doanphanmem.connect.DatabaseHelper"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<meta content="width=device-width, initial-scale=1.0" name="viewport">


    <!-- Favicon -->
    <link href="../img/favicon.ico" rel="icon">

    <!-- Google Web Fonts -->
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@100;200;300;400;500;600;700;800;900&display=swap" rel="stylesheet">

    <!-- Font Awesome -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">

    <!-- Libraries Stylesheet -->
    <link href="../lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">

    <!-- Customized Bootstrap Stylesheet -->
    <link href="../css/style.css" rel="stylesheet">
    <link href="<c:url value = "../css/home.css"/>" rel="stylesheet">
    
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    
     <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

	<style type="text/css">
	.main-body{
		margin-top: 150px}
		.card {
    position: relative;
    display: flex;
    flex-direction: column;
    min-width: 0;
    word-wrap: break-word;
    background-color: #fff;
    background-clip: border-box;
    border: 0 solid transparent;
    border-radius: .25rem;
    margin-bottom: 1.5rem;
    box-shadow: 0 2px 6px 0 rgb(218 218 253 / 65%), 0 2px 6px 0 rgb(206 206 238 / 54%);
}
.me-2 {
    margin-right: .5rem!important;
}
	
	</style>
</head>
<body>
	<%@ include file="header.jsp" %>
	<div class="container">
		
		<div class="main-body">
		<p style="color: green; font-size: 30px">${mess }</p>
			<div class="row">
				<div class="col-lg-4">
					<div class="card">
						<div class="card-body">
							<div class="d-flex flex-column align-items-center text-center">
								<img src="https://img.freepik.com/free-icon/user_318-159711.jpg" alt="Admin" class="rounded-circle p-1 bg-primary" width="110">
								<div class="mt-3">
									<h4>${profile.hoTen }</h4>
									<button class="btn btn-primary">Follow</button>
									<button class="btn btn-outline-primary">Message</button>
								</div>
								
							</div>
							<hr class="my-4">
							<ul class="list-group list-group-flush">
								
								<li class="list-group-item d-flex justify-content-between align-items-center flex-wrap">
									<h6 class="mb-0"><svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-instagram me-2 icon-inline text-danger"><rect x="2" y="2" width="20" height="20" rx="5" ry="5"></rect><path d="M16 11.37A4 4 0 1 1 12.63 8 4 4 0 0 1 16 11.37z"></path><line x1="17.5" y1="6.5" x2="17.51" y2="6.5"></line></svg>Instagram</h6>
									<span class="text-secondary">bootdey</span>
								</li>
								<li class="list-group-item d-flex justify-content-between align-items-center flex-wrap">
									<h6 class="mb-0"><svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-facebook me-2 icon-inline text-primary"><path d="M18 2h-3a5 5 0 0 0-5 5v3H7v4h3v8h4v-8h3l1-4h-4V7a1 1 0 0 1 1-1h3z"></path></svg>Facebook</h6>
									<span class="text-secondary">bootdey</span>
								</li>
							</ul>
						</div>
					</div>
				</div>
				<div class="col-lg-8">
					<div class="card">
						<form class="card-body" action="profileEdit?tenTKKH=${sessionScope.acc.tenDN }" method="post">
							<div class="row mb-3">
								<div class="col-sm-3">
									<h6 class="mb-0">Họ và tên</h6>
								</div>
								<div class="col-sm-9 text-secondary">
									<input name="hoTen" type="text" class="form-control" value="${profile.hoTen }">
								</div>
							</div>
							<div class="row mb-3">
								<div class="col-sm-3">
									<h6 class="mb-0">Email</h6>
								</div>
								<div class="col-sm-9 text-secondary">
									<input name="email" type="text" class="form-control" value="${profile.email }">
								</div>
							</div>
							<div class="row mb-3">
								<div class="col-sm-3">
									<h6 class="mb-0">Số điện thoại</h6>
								</div>
								<div class="col-sm-9 text-secondary">
									<input  name="sdt" type="text" class="form-control" value="${profile.sdt }">
								</div>
							</div>
							
							<div class="row mb-3">
								<div class="col-sm-3">
									<h6 class="mb-0">Thôn / đường</h6>
								</div>
								<div class="col-sm-9 text-secondary">
									<input name="diaChi" type="text" class="form-control" value="${profile.diaChi }">
								</div>
							</div>
							<div class="row mb-3" >
								<div class="col-sm-3">
									<h6 class="mb-0">Tỉnh Thành</h6>
								</div>
								<select name="tinhThanh"  class="col-sm-9 text-secondary form-select " aria-label="Default select example">	  
									<option  value="" selected="selected">Tỉnh Thành</option>	
									<option  value="tỉnh Gia Lai" >tỉnh Gia Lai</option>
									<option  value="tỉnh Đăk Lắk" >tỉnh Đăk Lắk</option>
									<option  value="tỉnh Kon Tum" >tỉnh Kon Tum</option>
									
								</select>
							</div>
							<div class="row mb-3" >
								<div class="col-sm-3">
									<h6 class="mb-0">Quận huyện</h6>
								</div>
								<select name="quanHuyen"  class="col-sm-9 text-secondary form-select " aria-label="Default select example">
								  <option value="" class="form-control">quận huyện</option>
									<option  value="huyện IaGrai" >huyện Iagrai</option>
									<option  value="huyện Ia Pa" >huyện Ia Pa</option>
									<option  value="huyện Chư Pưh" >huyện Chư Pưh</option>
								</select>
							</div>
							<div class="row mb-3" >
								<div class="col-sm-3">
									<h6 class="mb-0">Phường xã</h6>
								</div>
								<select name="phuongXa"  class="col-sm-9 text-secondary form-select " aria-label="Default select example">
								  <option value="" class="form-control">Phường xã</option>
								 <option  value="xã IaYok" >xã Iagrai</option>
									<option  value="xã IaSao" >xã IaSao</option>
									<option  value="xã Ia To" >xã Ia To</option>
								</select>
							</div>
							<div class="row mb-3">
								<div class="col-sm-3">
									<h6 class="mb-0">Địa chỉ</h6>
								</div>
								<div class="col-sm-9 text-secondary">
									<input  name="sdt" type="text" class="form-control" value="">
								</div>
							</div>
						
							
							<div class="row">
								<div class="col-sm-3"></div>
								<div class="col-sm-9 text-secondary">
									<input  type="submit" class="btn btn-primary px-4" value="Lưu">
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<%@ include file="footter.jsp" %>
	
	<script src="../https://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script src="../https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js"></script>
    <script src="../lib/easing/easing.min.js"></script>
    <script src="../lib/waypoints/waypoints.min.js"></script>
    <script src="../lib/counterup/counterup.min.js"></script>
    <script src="../lib/owlcarousel/owl.carousel.min.js"></script>

    <!-- Contact Javascript File -->
    <script src="../mail/jqBootstrapValidation.min.js"></script>
    <script src="../mail/contact.js"></script>
	 <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js" integrity="sha512-894YE6QWD5I59HgZOGReFYm4dnWc1Qt5NtvYSaNcOP+u1T9qYdvdihz0PPSiiqn/+/3e7Jo4EaG7TubfWGUrMQ==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/axios/0.26.1/axios.min.js" integrity="sha512-bPh3uwgU5qEMipS/VOmRqynnMXGGSRv+72H/N260MQeXZIK4PG48401Bsby9Nq5P5fz7hy5UGNmC/W1Z51h2GQ==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
    <!-- Template Javascript -->
    <script src="../js/main.js"></script>
    <script src="<c:url value="/js/tinhThanh.js"></c:url>"></script>
    
</body>
</html>