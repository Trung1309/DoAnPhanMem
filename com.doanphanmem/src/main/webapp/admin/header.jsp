<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>

<link rel="stylesheet" href="<c:url value="/css/header_footter.css"> </c:url>">

    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

</head>
<body>
	<header >
        <div class="container nav">
            <img src="https://bizweb.dktcdn.net/100/383/301/themes/767821/assets/logo.png?1675384808651" alt="" class="avatar-logo">
            <div class="nav-menu">
                <ul>
                    
                     <c:if test="${sessionScope.acc.maQuyen == 1 }">
                     	<a href="home" >
	                        <li>TRANG CHỦ</li>
	                    </a>
                    	<a href="nhanVien" >
	                        <li>NGƯỜI DÙNG</li>
	                    </a>
	                    <a href="quanli" >
	                        <li>ĐƠN HÀNG</li>
	                    </a>
                    </c:if>
                    <c:if test="${sessionScope.acc.maQuyen == 2 }">
                    	<a href="nhanVien" >
	                        <li>NHÂN VIÊN</li>
	                    </a>
	                    <a href="home" >
	                        <li>ĐƠN HÀNG ĐẶC BIỆT</li>
	                    </a>
	                    <a href="#">
                        	<li>DỊCH VỤ</li>
                    	</a>
                    </c:if>
                    
                    <c:if test="${sessionScope.acc.maQuyen == 3 }">
	                    <a href="#">
	                        <li>TRANG CHỦ</li>
	                    </a>
                    	<a href="home" >
	                        <li>QUẢN LÍ</li>
	                    </a>
	                    <a href="#">
                        	<li>DỊCH VỤ</li>
                    	</a>
                    </c:if>
                    <c:if test="${sessionScope.acc.maQuyen == 4 }">
                    	<a href="home">
                        	<li>TRANG CHỦ</li>
                    	</a>
                    	<a href="quanli" >
	                        <li>ĐƠN HÀNG</li>
	                    </a>
	                    <a href="">
                        	<li>DỊCH VỤ</li>
                    	</a>
                    </c:if>
                    
                    <c:if test="${sessionScope.acc == null }">
                    	<a href="#">
	                        <li>TRANG CHỦ</li>
	                    </a>
	                    <a href="#">
                        	<li>DỊCH VỤ</li>
                    	</a>
                    	<a href="login" >
	                        <li>ĐĂNG NHẬP</li>
	                    </a>
                    </c:if>
	                <c:if test="${sessionScope.acc != null }">
                    	<a href="logout" >
                        	<li>ĐĂNG XUẤT</li>
                    	</a>
                    </c:if>   
                    
                    <div class="avatar-user"></div>
                </ul>
            </div> 
        </div>    
    </header>
    
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>
</html>