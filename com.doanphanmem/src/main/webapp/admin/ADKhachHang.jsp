<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>Trang chủ</title>
	<link rel="stylesheet" href="<c:url value="/css/index.css"> </c:url>">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
	<link rel="stylesheet" href="//code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
  	<link rel="stylesheet" href="/resources/demos/style.css">
	  
</head>
<body>
	<%@ include file="header.jsp" %>
	<!--  -->
	<!--Content -->
    <div class="content">
        <div class="container">
        	<c:if test="${sessionScope.acc == null }">
        		
        		<div class="title">Dịch Vụ</div>
        	</c:if>
        	<c:if test="${sessionScope.acc.maQuyen == 1 }">     		
        		<div class="title">Quản lí người dùng</div><br>
        		<span>Xin chào Admin</span>
        		<div class="users">
		             <a href="nhanVien"> <div class="users-button">Nhân Viên</div></a>
		             <a href="khachHang"> <div class="users-button"  style="background: #2ecc71;color: white; border-radius: 10px">Khách Hàng</div></a>
           		</div>
        	</c:if>
        	<c:if test="${sessionScope.acc.maQuyen == 2 }">
        		<div class="title">Quản lí nhân viên</div>
        	</c:if>
        	<c:if test="${sessionScope.acc.maQuyen == 3 }">
        		<div class="title">Quản lí đơn hàng</div>
        	</c:if>
        	<c:if test="${sessionScope.acc.maQuyen == 4 }">
        		
        		<div class="title">Đơn hàng của tôi</div><br>
        		<input name="idKH" value="${sessionScope.acc.tenDN }" >
        	</c:if>
            
            <div class="row-one">
                <form action="" class="search-box">
                    <input type="text" placeholder="Tìm kiếm khách hàng">
                    <button type="submit"><i class="fa-solid fa-magnifying-glass"></i></button>
                </form>
                <c:if test="${sessionScope.acc.maQuyen == 4 }">
                	<a href="addOder"><button class="btn-add"><i class="fa-solid fa-plus" style="color: white; margin-right: 15px;"></i>Tạo đơn hàng</button></a>
        		</c:if>
            </div>            
            <table class="table table-striped" >
                <thead>
                  <tr style="background: #27AE60">
                    <th scope="col" style="color: white;">Mã khách hàng</th>
                    <th scope="col" style="color: white;">Họ và tên</th>
                    <th scope="col" style="color: white;">Email</th>
                    <th scope="col" style="color: white;">Số điện thoại</th>
                    <th scope="col" style="color: white;">Mã quyền</th>
                  </tr>
                </thead>
                <tbody>
                <c:if test="${sessionScope.acc.maQuyen == 1 }"> 
                	<c:forEach items="${listAllKhachHang}" var="o">
                	<tr>
	                    <td>${o.tenDN }</td>
	                    <td>${o.hoTen}</td>
	                    <td>${o.email}</td>
	                    <td>${o.sdt}</td>
	                    <td>${o.maQuyen}</td>
                  	</tr>
                </c:forEach> 
                </c:if>
                          
                </tbody>
              </table>
              <nav aria-label="..." style="margin: 30px 0px;">
                <ul class="pagination" style="justify-content: center; ">
                  <li class="page-item disabled">
                    <a class="page-link" href="#" tabindex="-1" aria-disabled="true">Previous</a>
                  </li>
                  <li class="page-item"><a class="page-link" href="#">1</a></li>
                  <li class="page-item " aria-current="page">
                    <a class="page-link" href="#">2</a>
                  </li>
                  <li class="page-item active"><a class="page-link" href="#">3</a></li>
                  <li class="page-item">
                    <a class="page-link" href="#">Next</a>
                  </li>
                </ul>
              </nav>
        </div>
    </div>
	
	<!--  -->
	<%@ include file="footter.jsp" %>
	<!--  -->
	<!-- Boostrap -->
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>

	<!-- Jquery -->
	<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
	  <script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
	  <script>
	  $( function() {
	    $( "#datepicker" ).datepicker();
	  } );
	  </script>

</body>
</html>