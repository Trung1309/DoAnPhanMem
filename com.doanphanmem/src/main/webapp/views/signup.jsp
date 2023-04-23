<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đăng kí</title>

	<link
    href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css"
    rel="stylesheet"
    />
    <!-- Google Fonts -->
    <link
    href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap"
    rel="stylesheet"
    />
    <!-- MDB -->
    <link
    href="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/6.2.0/mdb.min.css"
    rel="stylesheet"
    />
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	<link rel="stylesheet" href="<c:url value="/css/login-sigup.css"> </c:url>">
</head>
<body>
	<!--  -->
	<%@ include file="header.jsp" %>
	<!-- header end -->
	<div class="container">
        <div class="content">
            <div class="login" id="id-login">
                <form action="signup" method="post" name="FormSignup">     
                    <div class="d-flex align-items-center mb-3 pb-1">
                    <div class="title-login" style="display: flex; flex-direction: column;">
                        <span style="font-size: 30px;">ĐĂNG KÍ</span>
                        <span>Tạo tài khoản mới tại đây</span>
                    </div>
                    </div>
                    <p class="text-success">${messSuccsess}</p>
                    <p class="text-danger" id="alert-danger">${messDanger }</p>
        
                    <div class="form-outline mb-4">
                        <input name="tenDN" type="text" id="form2Example17" class="form-control form-control-lg" />
    
                        <label class="form-label" for="form2Example17">Tên đăng nhập</label>
                    </div>
    
                    <div class="form-outline mb-4">
                        <input name="hoten" type="text" id="form2Example17" class="form-control form-control-lg" />
                        <label class="form-label" for="form2Example17">Họ và tên</label>
                    </div>
    
                    
                    <div class="form-outline mb-4">
                        <input name="email" type="email" id="form2Example17" class="form-control form-control-lg" />
                        <label class="form-label" for="form2Example17">Email</label>
                    </div>
    
                    
                    <div class="form-outline mb-4">
                        <input name="sdt" type="" id="form2Example17" class="form-control form-control-lg" />
                        <label class="form-label" for="form2Example17">Số điện thoại</label>
                    </div>
                        
        
                    <div class="form-outline mb-4">
                    <input name="pass" type="password" id="form2Example27" class="form-control form-control-lg" />
                    <label class="form-label" for="form2Example27">Mật khẩu</label>
                    </div>
    
                    <div class="form-outline mb-4">
                        <input name="repass" type="password" id="form2Example27" class="form-control form-control-lg" />
                        <label class="form-label" for="form2Example27">Xác nhận mật khẩu</label>
                        </div>
        
                        <div class="form-check d-flex justify-content-center mb-5">
                            <input type="checkbox" value="" id="form2Example3cg" style="width: 20px; " />
                            <label class="form-check-label" for="form2Example3g">
                            Tôi đồng ý tất cả các tuyên bố trong 
                            <a href="#!" class="text-body" ><u style="color: #2980b9;">Điều khoản sử dụng</u></a> và
                            <a href="#!" class="text-body" ><u style="color: #2980b9;">Dịch vụ</u></a>
                            </label>
                          </div>
                    <div class="pt-1 mb-4">
                    <button onclick="return formSignUp()" class="btn btn-dark btn-lg btn-block" type="submit" style="background-color: #2ecc71; border: none;">Đăng kí</button>
                    </div>
                    
                </form>
            </div>
        </div>
    </div>
	
	<%@ include file="footter.jsp" %>
	
	<!-- Javascript -->
	
	<script type="text/javascript">
        function formSignUp(){
            var txt_tendn = document.FormSignup.tenDN.value;
            if(txt_tendn == ""){
                document.getElementById('alert-danger').innerHTML = "Nhập đầy đủ tên đăng nhập";
                return false;
            }else if(txt_tendn.length < 5 |txt_tendn.length >10){
                document.getElementById('alert-danger').innerHTML = "Tên đăng nhập trên 5 kí tự không quá 10 kí tự";
                return false;
            }
            var txt_hoten = document.FormSignup.hoten.value;
            if(txt_hoten == ""){
                document.getElementById('alert-danger').innerHTML = "Nhập đầy đủ họ tên của bạn";
                return false;
            }
            var txt_email = document.FormSignup.email.value;
            if(txt_email == ""){
                document.getElementById('alert-danger').innerHTML = "Nhập tài khoản email của bạn";
                return false;
            }
            var txt_sdt= document.FormSignup.sdt.value;
            if(txt_sdt == ""){
                document.getElementById('alert-danger').innerHTML = "Nhập số điện thoại của bạn";
                return false;
            }
            var txt_pass = document.FormSignup.pass.value;
            if(txt_pass == ""){
                document.getElementById('alert-danger').innerHTML = "Nhập mật khẩu bạn muốn dùng";
                return false;
            }else if(txt_pass.length < 5 |txt_pass.length >10){
                document.getElementById('alert-danger').innerHTML = "Mật khẩu đủ 8 kí tự không quá 20 kí tự";
                return false;
            }
            var txt_repass = document.FormSignup.repass.value;
            if(txt_pass != txt_repass){
                document.getElementById('alert-danger').innerHTML = "Xác nhận mật khẩu không khớp";
                return false;
            }
        }
    </script>
	
	
	 <script
    type="text/javascript"
    src="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/6.2.0/mdb.min.js"
    ></script>
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>
</body>
</html>