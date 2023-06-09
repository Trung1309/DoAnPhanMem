<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <!-- Font Awesome -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css" rel="stylesheet"
    />
    <!-- Google Fonts -->
    <link href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap" rel="stylesheet"
    />
    <!-- MDB -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/6.2.0/mdb.min.css" rel="stylesheet"    />
	<link rel="stylesheet" href="<c:url value="/css/addOder.css"> </c:url>">
</head>
<body>
	<%@ include file="header.jsp" %>
	<!--  -->
	<div class="container">
        <div class="content">
            <div class="title-page" style="margin-top: 150px; margin-bottom: 30px; text-align: center; font-size: 30px;">
                TẠO ĐƠN HÀNG
            </div>
            <p class="text-success" style="font-size: 20px; background: #d8ecdc;color: #2d5b42; 
            	margin-left:100px; border-radius: 10px;">${messSuccsess}</p>
            <form action="addOrder" method="post" enctype="multipart/form-data">
                <div class="content-order">
                    <div class="title">
                        THÔNG TIN ĐƠN HÀNG
                    </div>
                    <div class="infor-oder">
                        <div class="col">
                        	<div class="input-txt" style="display: none;">
                                <span>Mã khách hàng</span><br>
                                <input name="idKH"  type="text" placeholder="" class="input-1" value="${sessionScope.acc.tenDN }">
                            </div>
                            <div class="input-txt">
                                <span>Họ và tên <strong style="color: red; margin-left: 10px;">*</strong></span><br>
                                <input type="text" placeholder="" class="input-1" value="${sessionScope.acc.hoTen }">
                            </div>
                            <div class="input-txt">
                                <span>Địa chỉ nhận hàng <strong style="color: red; margin-left: 10px;">*</strong></span><br>
                                <input name="diaChiNhanHang" type="text" placeholder="" class="input-1" value="${sessionScope.acc.diaChi },${sessionScope.acc.phuongXa },${sessionScope.acc.quanHuyen },${sessionScope.acc.tinhThanh }">
                            </div>
                           
                            <div class="input-txt">
                                <span>Địa chỉ giao hàng <strong style="color: red; margin-left: 10px;">*</strong></span><br>
                                <input name="diaChiGH" type="text" placeholder="" class="input-1">
                            </div>
                            <div class="input-txt">
                                <span>Chọn tỉnh thành <strong style="color: red; margin-left: 10px;">*</strong></span><br>
                                	<select name="tinhThanh" class="form-select" aria-label="Default select example" >
                                		 <option value="TP Đà Nẵng" >TP Đà Nẵng</option>
                                		 <option value="tỉnh Thừa Thiên Huế" >tỉnh Thừa Thiên Huế</option>
                                		 <option value="tỉnh Quảng Trị" >tỉnh Quảng Trị</option>
                                		 <option value="tỉnh Quảng Bình" >tỉnh Quảng Bình</option>
                                		 <option value="tỉnh Hà Tỉnh" >tỉnh Hà Tỉnh</option>
                                		
                                  	</select>
                            </div>
                        
                            <div class="input-txt">
                                    <span>Quận /huyện<strong style="color: red; margin-left: 10px;">*</strong></span>
                                    <select name="quanHuyen" class="form-select" aria-label="Default select example" id="district">
                                        <option value="" selected>Quận huyện</option>
                                        <option value="huyện IaGrai" >huyện IaGrai</option>
                                		 <option value="huyện IaTo" >huyện IaTo</option>
                                		 <option value="huyện Chư Pứ" >huyện Chư Pứ</option>
                                        <option value="q. Hải Châu" >q Hải Châu</option>
                                		 <option value="q. Liên Chiểu" >q Liên Chiểu</option>
                                		 <option value="q. Ngũ Hành Sơn" >q. Ngũ Hành Sơn</option>
                                      </select>
                                </div>
                                
                                <div class="input-txt">
                                    <span>Phường / xã<strong style="color: red; margin-left: 10px;">*</strong></span>
                                    <select name="phuongXa" class="form-select" aria-label="Default select example" id="ward" >
                                        <option value="" selected>Phường / xã</option>
                                         <option value="xã IaYok" >xã IaYok</option>
                                		 <option value="xã IaSao" >xã IaSao</option>
                                		 <option value="xã IaKlai" >xã IaKlai</option>
                                        <option value="p. Thanh Bình" >p. Thanh Bình</option>
                                		 <option value="p. Thuận Phước" >p. Thuận Phước</option>
                                		 <option value="p. Thạch Thang" >p. Thạch Thang</option>
                                      </select>
                                </div>	
                            
                        </div>
                        
                         
                        
                        <div class="col">
                         	<div class="input-txt">
                                <span>Tên người nhận <strong style="color: red; margin-left: 10px;">*</strong></span><br>
                                <input name="tenNguoiNhan" type="text" placeholder="" class="input-1">
                            </div>
                            <div class="input-txt">
                                <span>SĐT người gửi <strong style="color: red; margin-left: 10px;">*</strong></span><br>
                                <input name="sdtNguoiGui" type="text" value="${sessionScope.acc.sdt }" placeholder="" class="input-1">
                            </div>
                            <div class="input-txt">
                                <span>Số điện thoại người nhận <strong style="color: red; margin-left: 10px;">*</strong></span><br>
                                <input name="sdtNguoiNhan"  type="text" placeholder="" class="input-1">
                            </div>
                            <div class="input-txt">
                                <span>Ghi chú <strong style="color: red; margin-left: 10px;">*</strong></span><br>
                                <input type="text" placeholder="" class="input-1">
                            </div>
                            <div class="input-txt">
                                <span>Dịch vụ vận chuyển<strong style="color: red; margin-left: 10px;">*</strong></span>
                                <select name="dichVu" class="form-select" aria-label="Default select example">
                                    <option selected>Dịch vụ vận chuyển</option>
                                    <option value="20000">Vận chuyển cơ bản <span style="color:red">(20000VNĐ/1kg)</span></option>
                                    <option value="35000">Chuyển phát nhanh <span style="color:red">(35000VNĐ/1kg)</span></option>
                                    <option value="50000">Vận chuyển quốc tế <span style="color:red">(50000VNĐ/1kg)</span></option>
                                    </select>
                            </div>
                			
                         
                            
                        </div>
                    </div>
                </div>
                <div class="content-order">
                    <div class="title">
                        THÔNG TIN SẢN PHẨM
                    </div>
                    <div class="infor-oder">
                        <div class="col">
                            <div class="input-txt">
                                <span>Tên sản phẩm <strong style="color: red; margin-left: 10px;">*</strong></span><br>
                                <input name="tenSP" type="text" placeholder="" class="input-1">
                            </div>
                            <div class="input-txt">
                                <span>Loại khối lượng sản phẩm<strong style="color: red; margin-left: 10px;">*</strong></span>
                                <select name="loaiGoiCuoc"  class="form-select" aria-label="Default select example">
                                    <option selected>Loại sản phẩm</option>
                                    <option value="Hàng dễ vỡ">Hàng dễ vỡ</option>
                                    <option value="Hàng da dụng">Hàng da dụng</option>
                                    <option value="Đồ điện tử">Đồ điện tử</option>
                                    <option value="Đồ thời trang"> > Đồ thời trang</option>
                                    </select>
                            </div>
                            <div class="input-txt">
                                <span >Số lượng <strong style="color: red; margin-left: 10px;">*</strong></span><br>
                                <input name="soLuong" type="number" placeholder="" class="input-1">
                            </div>
                            <div class="input-txt">
                                <span>Khối lượng (kg) <strong style="color: red; margin-left: 10px;">*</strong></span><br>
                                <input name="khoiLuong" type="number" placeholder="" class="input-1">
                            </div>
                            
                            
                        </div>
                        <div class="col">
                            <div class="upload-file">   
                                <label for="formFileMultiple" class="upload"><i class="fa-solid fa-upload" style="color: #e74c3c; font-size: 100px;" ></i>
                                </label>                            
                                <label for="formFileMultiple" class="form-label">Kéo thả hoặc tải lệp lên</label>
                                <input name="hinhAnh" class="form-control" type="file" id="formFileMultiple" multiple />                     
                                
                            </div>                          
                        </div>
                    </div>
                </div>
                <div class="row-button">
                    <button type="" style="background: #e74c3c; color: white; border: none; padding: 10px; width: 10%;">Huỷ</button>
                    <button type="submit"  style="background: #2ecc71; color: white; border: none; padding: 10px; width: 10%;">Xác nhận</button>
                </div>
            </form>
        </div>
    </div>
   
	<%@ include file="footter.jsp" %>
	
	<script
    type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/6.2.0/mdb.min.js"
    ></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js" integrity="sha512-894YE6QWD5I59HgZOGReFYm4dnWc1Qt5NtvYSaNcOP+u1T9qYdvdihz0PPSiiqn/+/3e7Jo4EaG7TubfWGUrMQ==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/axios/0.26.1/axios.min.js" integrity="sha512-bPh3uwgU5qEMipS/VOmRqynnMXGGSRv+72H/N260MQeXZIK4PG48401Bsby9Nq5P5fz7hy5UGNmC/W1Z51h2GQ==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
	 
	
	<script src="<c:url value="/js/tinhThanh.js"></c:url>"></script>
</body>
</html>