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
  	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>	  
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
		             <a href="khachHang"> <div class="users-button">Khách Hàng</div></a>
           		</div>
        	</c:if>
        	<c:if test="${sessionScope.acc.maQuyen == 2 }">
        		<div class="title">Quản lí nhân viên</div>
        	</c:if>
        	<c:if test="${sessionScope.acc.maQuyen == 3 }">
        		<div class="title">Quản lí đơn hàng</div>
        		<input value="${sessionScope.acc.tenDN }" style="display: none;">
        	</c:if>
        	<c:if test="${sessionScope.acc.maQuyen == 4 }">
        		
        		<div class="title">Đơn hàng của tôi</div><br>
        		<span>Chào mừng <strong>${sessionScope.acc.hoTen }</strong></span>
        	
        	</c:if>
        	
        	<c:if test="${sessionScope.acc.maQuyen == 3 }">       		
	        		<div class="row-one">
	                <form action="searchByNV" method="post" class="search-box">
	                    <input name="txt" type="text" placeholder="Nhập mã đơn hàng hoặc sdt người nhận	" value="${txtSearch }">
	                    <button type="submit"><i class="fa-solid fa-magnifying-glass"></i></button>
	                </form>	                
	            </div>           
	            <div >
	                <form action="filterByNV" method="post" class="filter">
	                	<div class="dropdown">
	                    <div class="title-filter">Trạng thái</div>
	                    <select  name="txtTrangThai" class="form-select" aria-label="Default select example">
						  <option selected="Chọn" >Tất cả</option>
						  <option value="Chờ xử lý">Chờ xử lý</option>
						  <option value="Đang Giao">Đang Giao</option>
						  <option value="Đã giao">Đã giao</option>
						</select>
	                </div>
	                <div class="dropdown">
	                    <div class="title-filter">Từ ngày</div>
	                    <p>Date: <input type="text" id="datepicker" value="${minDay }"></p>
	                </div>
	                <div class="dropdown">
	                    <div class="title-filter" >Đến ngày</div>
	                    <p>Date: <input  type="text" id="datepickers" value="${maxDay }"></p>                 
	                </div>
	                <button type="submit" class="btn btn-success">Lọc</button>
	                </form>
	            </div>      	
        	</c:if>
        	
        	<c:if test="${sessionScope.acc.maQuyen == 4 }">       		
	        		<div class="row-one">
	                <form action="searchDH?maKH=${sessionScope.acc.tenDN }" method="post" class="search-box">
	                    <input name="txt" type="text" placeholder="Nhập mã đơn hàng	">
	                    <button type="submit"><i class="fa-solid fa-magnifying-glass"></i></button>
	                </form>
	                <c:if test="${sessionScope.acc.maQuyen == 4 }">
	                	<a href="addOrder"><button class="btn-add"><i class="fa-solid fa-plus" style="color: white; margin-right: 15px;"></i>Tạo đơn hàng</button></a>
	        		</c:if>
	            </div>           
	            <div >
	                <form action="filter?maKH=${sessionScope.acc.tenDN }" method="post" class="filter">
	                	<div class="dropdown">
	                    <div class="title-filter">Trạng thái</div>
	                    <select  name="txtTrangThai" class="form-select" aria-label="Default select example">
						  <option selected="${txtTT }" ></option>
						  <option value="Chờ xử lý">Chờ xử lý</option>
						  <option value="Đang Giao">Đang Giao</option>
						  <option value="Đã giao">Đã giao</option>
						</select>
	                </div>
	                <div class="dropdown">
	                    <div class="title-filter">Từ ngày</div>
	                    <p>Date: <input type="text" id="datepicker" value="${minDay }"></p>
	                </div>
	                <div class="dropdown">
	                    <div class="title-filter" >Đến ngày</div>
	                    <p>Date: <input  type="text" id="datepickers" value="${maxDay }"></p>                 
	                </div>
	                <button type="submit" class="btn btn-success">Lọc</button>
	                </form>
	            </div>      	
        	</c:if>
        	
            
            <p class="text-success" style="font-size: 20px; font-weight: 500">${messSuccsess}</p>
            
                <c:if test="${sessionScope.acc.maQuyen == 3 }"> 
                <table class="table table-striped" >
	                <thead>
	                  <tr style="background: #27AE60">
	                    <th scope="col" style="color: white;">Mã DH</th>
	                    <th scope="col" style="color: white;">Ngày tạo</th>
	                    <th scope="col" style="color: white;">SDT người nhận</th>
	                    <th scope="col" style="color: white;">Trạng thái đơn hàng</th>	
	                    <th scope="col" style="color: white;">Thành tiền</th>                    
	                    <th scope="col" style="color: white;">Tuỳ chỉnh</th>
	                  </tr>
	                </thead>
                	<tbody>
	                	<c:forEach items="${listAllDH}" var="o">
	                	<tr>
		                    <td>${o.maDH }</td>
		                 	<td>${o.ngayTaoDon }</td>
		                 	<td>${o.sdtNguoiNhan }</td>
		                 	<td>${o.trangThaiDonHang }</td>
		                 	<td>${o.thanhTien } <span style="color: #bdc3c7">VNĐ</span></td>
		                
		                 	     
		                 	<td>	                 		
		                 		<a href="detail?maDH=${o.maDH}"><button type="button" class="btn btn-success"><i class="fa-solid fa-eye" style="color: #ffffff;"></i></button></a>
								<c:if test="${o.trangThaiDonHang == 'Chờ xử lý'}">
									<a onclick="return showMessCF(${o.maDH})" href="confilm?maNV=${sessionScope.acc.tenDN }&maDH=${o.maDH }">
										<button type="button" class="btn btn-primary">
											<i class="fa-solid fa-check" style="color: #ffffff"></i>
										</button>
									</a>
								</c:if> 
						
									<a onclick="return showMess(${o.maDH})" href="delete?maDH=${o.maDH }&numPageNV=1">
										<button type="button" class="btn " style="background: #e74c3c">
											<i class="fa-sharp fa-solid fa-trash" style="color: #ffffff"></i>
										</button>
									</a>
						              		
		                 	</td>
	                  	</tr>
	                	</c:forEach> 
                	</tbody>
                	</table> 
					<p style="text-align: center;">${messNotFound }</p>
                </c:if>
                
                <c:if test="${sessionScope.acc.maQuyen == 4 }"> 
                <table class="table table-striped" >
	                <thead>
	                  <tr style="background: #27AE60">
	                    <th scope="col" style="color: white;">Mã đơn hàng</th>
	                    <th scope="col" style="color: white;">Ngày tạo</th>
	                    <th scope="col" style="color: white;">SDT người nhận</th>
	                    <th scope="col" style="color: white;">Trạng thái đơn hàng</th>
	                    <th scope="col" style="color: white;">Thành tiền</th>
	                    <th scope="col" style="color: white;">Tuỳ chỉnh</th>
	                  </tr>
	                </thead>
	                	<tbody>
		                	<c:forEach items="${listAllDHByKH}" var="o">
		                	<tr>
			                    <td>${o.maDH }</td>
			                 	<td>${o.ngayTaoDon }</td>
			                 	<td>${o.sdtNguoiNhan }</td>
			                 	<td>${o.trangThaiDonHang }</td>
			                 	<td>${o.thanhTien } <span style="color: #bdc3c7">VNĐ</span></td>
			                 	<td>
			                 		<a href="detail?maDH=${o.maDH}&idKH=${sessionScope.acc.tenDN}"><button type="button" class="btn btn-success"><i class="fa-solid fa-eye" style="color: #ffffff;"></i></button></a>	                 		
		                 			<a onclick="return showMessDeleteKH(${o.maDH})" href="delete?idKH=${sessionScope.acc.tenDN }&maDH=${o.maDH }&numPage=1">
										<button type="button" class="btn " style="background: #e74c3c">
											<i class="fa-sharp fa-solid fa-trash" style="color: #ffffff"></i>
										</button>
									</a>					                 		
			                 	</td>                 	
		                  	</tr>
		                	</c:forEach> 
	                	</tbody>
                	</table>
                </c:if>
                          
                
             
              
              <c:if test="${sessionScope.acc.maQuyen == 3 }"> 
               		<nav aria-label="..." style="margin: 30px 0px;">
		                <ul class="pagination" style="justify-content: center; ">
		                	<c:forEach begin="1" end="${endPNV}" var="i">
		                  		<li class="${tagNumPageNV == i? "active":"" } page-item "><a class="page-link" href="quanli?numPageNV=${i}">${i }</a></li>
		                 	</c:forEach>
		                </ul>
              		</nav>
               </c:if> 
               <c:if test="${sessionScope.acc.maQuyen == 4 }"> 
               		<nav aria-label="..." style="margin: 30px 0px;">
		                <ul class="pagination" style="justify-content: center; ">
		                	<c:forEach begin="1" end="${endP }" var="i">
		                  		<li class="${tagNumPage == i?"active":""} page-item "><a class="page-link" href="quanli?numPage=${i}&idKH=${sessionScope.acc.tenDN}">${i }</a></li>
		                 	</c:forEach>
		                </ul>
              		</nav>
               </c:if>          
              
        </div>
    </div>
	
	<!--  -->
	<%@ include file="footter.jsp" %>
	<!--  -->
	<!-- Boostrap -->
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
	
	<script type="text/javascript">
		function showMess(id) {
			var option = confirm('Bạn có chắc chắn huỷ đơn hàng này không');
			if(option == true){
				window.location.href = 'delete?maDH='+id+'&numPageNV=1'
				return false;
				
			}else {
				window.location.href = 'quanli'
				return false;
			}
		}	
	</script>
	
	<script type="text/javascript">
		function showMessCF(id) {
			var optionCF = confirm('Đơn hàng này sẽ được xác nhận');
			if(optionCF == true){
				window.location.href = 'confilm?maNV=${sessionScope.acc.tenDN }&maDH='+id+''
				return false;				
			}else {
				window.location.href = 'quanli'
				return false;
			}
		}	
	</script>
	
	<script type="text/javascript">
		function showMessDeleteKH(id) {
			var option = confirm('Bạn có chắc chắn huỷ đơn hàng này không');
			if(option == true){
				window.location.href = 'delete?idKH=${sessionScope.acc.tenDN }&maDH='+id+'&numPage=1'
				return false;
				
			}else {
				window.location.href = 'quanli?idKH=${sessionScope.acc.tenDN }'
				return false;
			}
		}	
	</script>
	
	<!-- Jquery -->
	<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
	  <script src="https://code.jquery.com/ui/1.13.2/jquery-ui.js"></script>
	  <script>
	  $( function() {
	    $( "#datepicker" ).datepicker();
	  } );
	  </script>
	  <script>
	  $( function() {
	    $( "#datepickers" ).datepicker();
	  } );
	  </script>

</body>
</html>