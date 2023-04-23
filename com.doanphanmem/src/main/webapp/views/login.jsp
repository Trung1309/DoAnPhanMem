<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đăng nhập</title>

<!-- Font Awesome -->
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
    <link rel="stylesheet" href="<c:url value="/css/login-sigup.css"> </c:url>">
</head>
<body>
	<%@ include file="header.jsp" %>
	
	<!--Login-->
    <div class="container">
        <div class="content">
            <div class="login" id="id-login">
                <form action="login" name="form_Login" method="post">     
                    <div class="d-flex align-items-center mb-3 pb-1">
                    <div class="title-login" style="display: flex; flex-direction: column;">
                        <span style="font-size: 30px;">ĐĂNG NHẬP</span>
                        <span>Chào mừng bạn đến với trang web của VÂN ĐẠT</span>
                    </div>
                    </div>
        
                   <p class="text-danger" id="text-danger">${mess }</p>  
        
                    <div class="form-outline mb-4">
                    <input name="user" type="text" id="form2Example17" class="form-control form-control-lg" />
                    <label class="form-label" for="form2Example17">Tên đăng nhập</label>
                    </div>
        
                    <div class="form-outline mb-4">
                    <input name="pass" type="password" id="form2Example27" class="form-control form-control-lg" />
                    <label class="form-label" for="form2Example27">Mật khẩu</label>
                    </div>
        
                    <div class="pt-1 mb-4">
                    <button onclick="return formLogin()" class="btn btn-dark btn-lg btn-block" type="submit" style="background-color: #2ecc71; border: none;">Đăng nhập</button>
                    </div>
        
                    <a class="small text-muted" href="#!">Quên mật khẩu?</a>
                    <p class="mb-5 pb-lg-2" style="color: #393f81;">Bạn chưa có tài khoản? <a href="signup"
                        style="color: #393f81;">Đăng kí</a></p>
                    <a href="#!" class="small text-muted">Điều khoản sử dụng</a>
                    <a href="#!" class="small text-muted">Chính sách bảo mật</a>
                </form>
            </div>
        </div>
    </div>
    
	
	<%@ include file="footter.jsp" %>
	<!--  -->
	<script type="text/javascript">
    function formLogin(){
        var txt_user = document.form_Login.user.value;
        if(txt_user == ""){
            document.getElementById('text-danger').innerHTML = "Vui lòng nhập tên đăng nhập";
            return false;
        }else if(txt_user.length < 7){
            document.getElementById('text-danger').innerHTML = "Tên đăng nhập phải đủ 7 kí tự trở lên";
            return false;
        }  
        
        var txt_pass = document.form_Login.pass.value;
        if(txt_pass == ""){
            document.getElementById('text-danger').innerHTML = "Vui lòng nhập mật khẩu của bạn";
            return false;
        }else if(txt_pass.length < 7){
            document.getElementById('text-danger').innerHTML = "Mật khẩu phải đủ 7 kí tự trở lên";
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
</html>