<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Thống kê</title>
		
	<link href="<c:url value="/css/bootstrap.min.css"></c:url>" rel="stylesheet">
	<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css" rel="stylesheet">
	<link href="<c:url value="/css/datepicker3.css"></c:url>" rel="stylesheet">
	<link rel="stylesheet" href="//code.jquery.com/ui/1.13.2/themes/base/jquery-ui.css">
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.4.0/css/all.min.css">
	<link href="<c:url value="/css/styles.css"></c:url>" rel="stylesheet">
	<script src="https://cdn.jsdelivr.net/npm/chart.js"></script>
	
	<!--Custom Font-->
	<!--[if lt IE 9]>
	<script src="js/html5shiv.js"></script>
	<script src="js/respond.min.js"></script>
	<![endif]-->
	<style type="text/css">
		.large{
		
		font-size: 30px;
		
		}
	</style>
</head>
<body>
	<%@ include file="header.jsp" %>
	<div class="content " style="margin-top:70px">
		<div class="container">			
				<div class="row">
					<div class="col-lg-12">
						<h1 class="page-header">Thống kê</h1>
					</div>
				</div><!--/.row-->
				
				<div class="panel panel-container">
					<div class="row">
						<div class="col-xs-6 col-md-3 col-lg-3 no-padding">
							<div class="panel panel-teal panel-widget border-right">
								<div class="row no-padding"><em class="fa fa-xl fa-shopping-cart color-blue"></em>
									<div class="large">${count }</div>
									<div class="text-muted">Tổng đơn hàng</div>
								</div>
							</div>
						</div>
						<div class="col-xs-6 col-md-3 col-lg-3 no-padding">
							<div class="panel panel-blue panel-widget border-right">
								<div class="row no-padding"><em class="fa fa-xl fa-dollar color-orange"></em>
									<div class="large">${sales }</div>
									<div class="text-muted">Doanh thu</div>
								</div>
							</div>
						</div>
						<div class="col-xs-6 col-md-3 col-lg-3 no-padding">
							<div class="panel panel-orange panel-widget border-right">
								<div class="row no-padding"><em class="fa fa-xl fa-users color-teal"></em>
									<div class="large">${countKH }</div>
									<div class="text-muted">Số lượng khách hàng</div>
								</div>
							</div>
						</div>
						<div class="col-xs-6 col-md-3 col-lg-3 no-padding">
							<div class="panel panel-red panel-widget ">
								<div class="row no-padding"><em class="fa fa-xl fa-search color-red"></em>
									<div class="large">10</div>
									<div class="text-muted">Lượt truy cập</div>
								</div>
							</div>
						</div>
					</div><!--/.row-->
				</div>
				<div class="row">
					<div class="col-md-12">
						<div class="panel panel-default">
							<div class="panel-heading">
								Doanh thu theo tháng
								<ul class="pull-right panel-settings panel-button-tab-right">
									<li class="dropdown"><a class="pull-right dropdown-toggle" data-toggle="dropdown" href="#">
										<em class="fa fa-cogs"></em>
									</a>
										<ul class="dropdown-menu dropdown-menu-right">
											<li>
												<ul class="dropdown-settings">
													<li><a href="#">
														<em class="fa fa-cog"></em> Settings 1
													</a></li>
													<li class="divider"></li>
													<li><a href="#">
														<em class="fa fa-cog"></em> Settings 2
													</a></li>
													<li class="divider"></li>
													<li><a href="#">
														<em class="fa fa-cog"></em> Settings 3
													</a></li>
												</ul>
											</li>
										</ul>
									</li>
								</ul>
								<span class="pull-right clickable panel-toggle panel-button-tab-left"><em class="fa fa-toggle-up"></em></span></div>
							<div class="panel-body">
								<div>
										<canvas id="barchart"></canvas>
									</div>
								</div>
								
								
							 <%
        // Tiến hành kết nối với cơ sở dữ liệu SQL Server
        String connectionUrl = "jdbc:sqlserver://localhost:1433;database=DTB_Nhom9_01116";
		String username = "sa";
		String password = "abc123";
		Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
        	Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
    		conn = DriverManager.getConnection(connectionUrl, username, password);

            // Thực hiện truy vấn để lấy dữ liệu từ SQL Server
            String query = "select MONTH(NgayTaoDon) as Month,(sum(soLuong * khoiLuong * MaGoiCuoc)) as TotalRevenue\r\n" + 
    				"from tbl_DonHang\r\n" + 
    				"group by MONTH(NgayTaoDon)";
            stmt = conn.createStatement();
            rs = stmt.executeQuery(query);

            // Xây dựng dữ liệu cho biểu đồ
            String labels = "";
            String data = "";

            while (rs.next()) {
                labels += rs.getString("Month") + ",";
                data += rs.getString("TotalRevenue") + ",";
            }

            // Loại bỏ dấu ',' cuối cùng
            labels = labels.substring(0, labels.length() - 1);
            data = data.substring(0, data.length() - 1);

            // Tạo mã JavaScript để vẽ biểu đồ bằng Chart.js
            %>
            <script>
            const ctx  =document.getElementById('barchart').getContext('2d')
    		const labelss = [<%= labels%>]
    		const barchart = new Chart(ctx,{
    			type:'bar',
    			data:{
    				labels: labelss,
    				datasets: [{
    					label: 'Doanh thu',
    					data: [<%= data%>],
    					backgroundColor: [
    					'rgba(255, 99, 132, 0.8)',
    					'rgba(255, 159, 64, 0.8)',
    					'rgba(255, 205, 86, 0.8)',
    					'rgba(75, 192, 192, 0.8)',
    					'rgba(54, 162, 235, 0.8)',
    					'rgba(153, 102, 255, 0.8)',
    					'rgba(201, 203, 207, 0.8)'
    					],
    					borderColor: [
    					'rgb(255, 99, 132)',
    					'rgb(255, 159, 64)',
    					'rgb(255, 205, 86)',
    					'rgb(75, 192, 192)',
    					'rgb(54, 162, 235)',
    					'rgb(153, 102, 255)',
    					'rgb(201, 203, 207)'
    					],
    					borderWidth: 1
    				}]
    			}	
    			}
    		)
            </script>
            <%
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Đóng kết nối và giải phóng tài nguyên
            try { rs.close(); } catch (Exception e) { }
            try { stmt.close(); } catch (Exception e) { }
            try { conn.close(); } catch (Exception e) { }
        }
    %>	
								
								
								
								
						</div>
					</div>
				</div><!--/.row-->
				
				<div class="row">
					<div class="col-xs-6 col-md-3">
						<div class="panel panel-default">
							<div class="panel-body easypiechart-panel">
								<h4>New Orders</h4>
								<div class="easypiechart" id="easypiechart-blue" data-percent="92" ><span class="percent">92%</span></div>
							</div>
						</div>
					</div>
					<div class="col-xs-6 col-md-3">
						<div class="panel panel-default">
							<div class="panel-body easypiechart-panel">
								<h4>Comments</h4>
								<div class="easypiechart" id="easypiechart-orange" data-percent="65" ><span class="percent">65%</span></div>
							</div>
						</div>
					</div>
					<div class="col-xs-6 col-md-3">
						<div class="panel panel-default">
							<div class="panel-body easypiechart-panel">
								<h4>New Users</h4>
								<div class="easypiechart" id="easypiechart-teal" data-percent="56" ><span class="percent">56%</span></div>
							</div>
						</div>
					</div>
					<div class="col-xs-6 col-md-3">
						<div class="panel panel-default">
							<div class="panel-body easypiechart-panel">
								<h4>Visitors</h4>
								<div class="easypiechart" id="easypiechart-red" data-percent="27" ><span class="percent">27%</span></div>
							</div>
						</div>
					</div>
				</div><!--/.row-->
			</div>			
		</div>	<!--/.main-->
	<%@ include file="footter.jsp" %>
	
	
	<script>
		
			
		

		
		
	  </script>

<script>
	
	
	<script src="<c:url value="/js/jquery-1.11.1.min.js"></c:url>"></script>
	<script src="<c:url value="/js/bootstrap.min.js"></c:url>"></script>
	<script src="<c:url value="/js/chart.min.js"></c:url>"></script>
	<script src="<c:url value="/js/chart-data.js"></c:url>"></script>
	<script src="<c:url value="/js/easypiechart.js"></c:url>"></script>
	<script src="<c:url value="/js/easypiechart-data.js"></c:url>"></script>
	<script src="<c:url value="/js/bootstrap-datepicker.js"></c:url>"></script>
	<script src="<c:url value="/js/custom.js"></c:url>"></script>
	
		
</body>
</html>