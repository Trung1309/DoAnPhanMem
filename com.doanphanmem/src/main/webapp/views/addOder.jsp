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
            <form action="">
                <div class="content-order">
                    <div class="title">
                        THÔNG TIN ĐƠN HÀNG
                    </div>
                    <div class="infor-oder">
                        <div class="col">
                            <div class="input-txt">
                                <span>Họ và tên <strong style="color: red; margin-left: 10px;">*</strong></span><br>
                                <input type="text" placeholder="" class="input-1" value="${sessionScope.acc.hoTen }">
                            </div>
                            <div class="input-txt">
                                <span>Địa chỉ lấy hàng <strong style="color: red; margin-left: 10px;">*</strong></span><br>
                                <input type="text" placeholder="" class="input-1">
                            </div>
                            <div class="input-txt">
                                <span>Tên người nhận <strong style="color: red; margin-left: 10px;">*</strong></span><br>
                                <input type="text" placeholder="" class="input-1">
                            </div>
                            <div class="input-txt">
                                <span>Địa chỉ lấy hàng <strong style="color: red; margin-left: 10px;">*</strong></span><br>
                                <input type="text" placeholder="" class="input-1">
                            </div>
                            <div class="input-txt">
                                <span>Chọn tỉnh thành <strong style="color: red; margin-left: 10px;">*</strong></span><br>
                                <select class="form-select" aria-label="Default select example">
                                    <option selected>Open this select menu</option>
                                    <option value="1">One</option>
                                    <option value="2">Two</option>
                                    <option value="3">Three</option>
                                  </select>
                            </div>
                        
                            <div class="row-1">
                                <div class="input-txt">
                                    <span>Quận /huyện<strong style="color: red; margin-left: 10px;">*</strong></span>
                                    <select class="form-select" aria-label="Default select example">
                                        <option selected>Open this select menu</option>
                                        <option value="1">One</option>
                                        <option value="2">Two</option>
                                        <option value="3">Three</option>
                                      </select>
                                </div>
                                
                                <div class="input-txt">
                                    <span>Phường / xã<strong style="color: red; margin-left: 10px;">*</strong></span>
                                    <select class="form-select" aria-label="Default select example">
                                        <option selected>Open this select menu</option>
                                        <option value="1">One</option>
                                        <option value="2">Two</option>
                                        <option value="3">Three</option>
                                      </select>
                                </div>
                            </div>
                            
                        </div>
                        <div class="col">
                            <div class="input-txt">
                                <span>SĐT người gửi <strong style="color: red; margin-left: 10px;">*</strong></span><br>
                                <input type="text" placeholder="" class="input-1">
                            </div>
                            <div class="input-txt">
                                <span>Số điện thoại người nhận <strong style="color: red; margin-left: 10px;">*</strong></span><br>
                                <input type="text" placeholder="" class="input-1">
                            </div>
                            <div class="input-txt">
                                <span>Ghi chú <strong style="color: red; margin-left: 10px;">*</strong></span><br>
                                <input type="text" placeholder="" class="input-1">
                            </div>
                            <div class="input-txt">
                                <span>Dịch vụ vận chuyển<strong style="color: red; margin-left: 10px;">*</strong></span>
                                <select class="form-select" aria-label="Default select example">
                                    <option selected>Open this select menu</option>
                                    <option value="1">One</option>
                                    <option value="2">Two</option>
                                    <option value="3">Three</option>
                                    </select>
                            </div>
                            <div class="row-1">
                                <div class="input-txt">
                                    <span>Khối lượng<strong style="color: red; margin-left: 10px;">*</strong></span><br>
                                    <input type="text" placeholder="" class="input-1">
                                </div>
                                
                                <div class="input-txt">
                                    <span>Giá trị <strong style="color: red; margin-left: 10px;">*</strong></span><br>
                                    <input type="number" placeholder="" class="input-1">
                                </div>
                            </div>
                            
                            <div class="input-txt">
                                <span>Tiền thu hộ<strong style="color: red; margin-left: 10px;">*</strong></span><br>
                                <input type="text" placeholder="" class="input-1">
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
                                <input type="text" placeholder="" class="input-1">
                            </div>
                            <div class="input-txt">
                                <span>Loại sản phẩm<strong style="color: red; margin-left: 10px;">*</strong></span>
                                <select class="form-select" aria-label="Default select example">
                                    <option selected>Open this select menu</option>
                                    <option value="1">One</option>
                                    <option value="2">Two</option>
                                    <option value="3">Three</option>
                                    </select>
                            </div>
                            <div class="input-txt">
                                <span>Số lượng <strong style="color: red; margin-left: 10px;">*</strong></span><br>
                                <input type="number" placeholder="" class="input-1">
                            </div>
                            <div class="input-txt">
                                <span>Khối lượng <strong style="color: red; margin-left: 10px;">*</strong></span><br>
                                <input type="number" placeholder="" class="input-1">
                            </div>
                            
                            
                        </div>
                        <div class="col">
                            <div class="upload-file">   
                                <label for="formFileMultiple" class="upload"><i class="fa-solid fa-upload" style="color: #e74c3c; font-size: 100px;" ></i>
                                </label>                            
                                <label for="formFileMultiple" class="form-label">Kéo thả hoặc tải lệp lên</label>
                                <input class="form-control" type="file" id="formFileMultiple" multiple />                     
                                
                            </div>                          
                        </div>
                    </div>
                </div>
                <div class="row-button">
                    <button type="" style="background: #e74c3c; color: white; border: none; padding: 10px; width: 10%;">Huỷ</button>
                    <button type="submit" style="background: #2ecc71; color: white; border: none; padding: 10px; width: 10%;">Xác nhận</button>
                </div>
            </form>
        </div>
    </div>
	<%@ include file="footter.jsp" %>
	
	<script
    type="text/javascript"
    src="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/6.2.0/mdb.min.js"
    ></script>

    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
</body>
</html>