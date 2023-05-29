<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
	<link rel="stylesheet" href="<c:url value="/css/header_footter.css"> </c:url>">

</head>
<body>
	<header >
        <div class="container nav">
            <a href="home"><img src="https://bizweb.dktcdn.net/100/383/301/themes/767821/assets/logo.png?1675384808651" alt="" class="avatar-logo"></a>
            <div class="nav-menu">
                <ul>
                    
                     <c:if test="${sessionScope.acc.maQuyen == 1 }">
                     	<a href="home" >
	                        <li>TRANG CHỦ</li>
	                    </a>
                    	<a href="nhanVien" >
	                        <li>NGƯỜI DÙNG</li>
	                    </a>
	                    <a href="" >
	                        <li>ĐƠN HÀNG</li>
	                    </a>
                    </c:if>
                    <c:if test="${sessionScope.acc.maQuyen == 2 }">
                    	
                    	<a href="nhanVien" >
	                        <li>NHÂN VIÊN</li>
	                    </a>
	                    <a href="#" >
	                        <li>ĐƠN HÀNG ĐẶC BIỆT</li>
	                    </a>
	                    <a href="#">
                        	<li>DỊCH VỤ</li>
                    	</a>
                    </c:if>
                    
                    <c:if test="${sessionScope.acc.maQuyen == 3 }">
	                    
                    	<a href="quanli" >
	                        <li>QUẢN LÍ</li>
	                    </a>
	                    <a href="thongke">
	                        <li>THỐNG KÊ</li>
	                    </a>
	                    <a href="#">
                        	<li>DỊCH VỤ</li>
                    	</a>
                    </c:if>
                    <c:if test="${sessionScope.acc.maQuyen == 4 }">
                    	<a href="home">
                        	<li>TRANG CHỦ</li>
                    	</a>
                    	<a href="quanli?idKH=${sessionScope.acc.tenDN }"" >
	                        <li>ĐƠN HÀNG</li>
	                    </a>
	                    <a href="home">
                        	<li>DỊCH VỤ</li>
                    	</a>
                    </c:if>
                    
                    <c:if test="${sessionScope.acc == null }">
                    	<a href="home">
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
    
   
</body>
</html>