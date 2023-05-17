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
	<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
	<style type="text/css">
				body{
		    background-color: #edf1f5;
		    margin-top:20px;
		}
		.card {
		    margin-bottom: 30px;
		}
		.card {
		    position: relative;
		    display: flex;
		    flex-direction: column;
		    min-width: 0;
		    word-wrap: break-word;
		    background-color: #fff;
		    background-clip: border-box;
		    border: 0 solid transparent;
		    border-radius: 0;
		}
		.card .card-subtitle {
		    font-weight: 300;
		    margin-bottom: 10px;
		    color: #8898aa;
		}
		.table-product.table-striped tbody tr:nth-of-type(odd) {
		    background-color: #f3f8fa!important
		}
		.table-product td{
		    border-top: 0px solid #dee2e6 !important;
		    color: #728299!important;
		}
	</style>
</head>
<body>
	<%@ include file="header.jsp" %>
	<!--  -->
	<div class="content" style="margin-top: 120px">
		<div class="container">
	    <div class="card">
	        <div class="card-body">
	            <h3 class="card-title">Chi tiết đơn hàng</h3>
	            <div class="row">
	                <div class="col-lg-5 col-md-5 col-sm-6" style="height: 500px;overflow: hidden;">
	                    <div class="white-box text-center"><img src="https://www.bootdey.com/image/430x600/00CED1/000000" class="img-responsive"></div>
	                </div>
	                <div class="col-lg-7 col-md-7 col-sm-6">
	                    <h4 class="box-title mt-5">Mô tả</h4>
	                    <p>Lorem Ipsum available,but the majority have suffered alteration in some form,by injected humour,or randomised words which don't look even slightly believable.but the majority have suffered alteration in some form,by injected humour</p>
	                    
	                    <ul class="list-unstyled">
	                        <li><i class="fa fa-check text-success"></i>Sturdy structure</li>
	                        <li><i class="fa fa-check text-success"></i>Designed to foster easy portability</li>
	                        <li><i class="fa fa-check text-success"></i>Perfect furniture to flaunt your wonderful collectibles</li>
	                    </ul>
	                </div>
	                <div class="col-lg-12 col-md-12 col-sm-12">
	                    <h3 class="box-title mt-5">Thông tin chi tiết</h3>
	                    <div class="table-responsive">
	                        <table class="table table-striped table-product">
	                            <tbody>
	                                <tr>
	                                    <td width="390">Số điện thoại người nhận</td>
	                                    <td>${dt.sdtNguoiNhan }</td>
	                                </tr>
	                                <tr>
	                                    <td>Họ tên người nhận</td>
	                                    <td>${dt.hoTenNguoiNhan}</td>
	                                </tr>
	                                <tr>
	                                    <td>Địa chỉ giao hàng</td>
	                                    <td>${dt.diaChiGH }, ${dt.phuongXa },${dt.quanHuyen },${dt.tinhThanh }</td>
	                                </tr>
	                                <tr>
	                                    <td>Ngày tạo đơn</td>
	                                    <td>${dt.ngayTaoDon }</td>
	                                </tr>
	                                <tr>
	                                    <td>Ngày giao hàng</td>
	                                    <td>${dt.ngayGiaoHang }</td>
	                                </tr>
	                                <tr>
	                                    <td>Trạng thái</td>
	                                    <td>${dt.trangThaiDonHang }</td>
	                                </tr>
	                                <tr>
	                                    <td>Tên Sản Phẩm</td>
	                                    <td>${dt.tenSP }</td>
	                                </tr>
	                                <tr>
	                                    <td>Loại Sản phẩm</td>
	                                    <td>${dt.loaiSP }</td>
	                                </tr>
	                                
	                            </tbody>
	                        </table>
	                    </div>
	                </div>
	            </div>
	        </div>
	    </div>
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