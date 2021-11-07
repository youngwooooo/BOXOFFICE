<%@page import="common.vo.PagingVO"%>
<%@page import="java.util.List"%>
<%@page import="common.vo.CdChargeVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>박스오피스 | 상영시간표 관리</title>
	
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
	<script src="../../../js/lib/jquery-3.6.0.js"></script>
<!-- 	<link rel="stylesheet" href="../../../css/common/style.css"> -->
	<style type="text/css">
 		table, td, th { 
 		    border: 1px solid black; 
 		}
 		thead td {
			background-color: black;
			color: white;
 		}
 		thead td:last-child {
 			background-color: #ff1212;
 		}
 		table {
 			border-collapse: collapse;
 			width: 100%;
 			text-align: center;	
 		}
 		tr {
 			height: 45px;
 			vertical-align: middle;			
 		}
 		td {
 			width: calc(100% / 10);
 			vertical-align: middle;
 			line-height: 45px;
 		}
 		
 		input {
 			width: 120px;
 			text-align: center;
 		}
 		
 		#divBtn {
 			width: 100%;
 			float: left;
 		}
 		
 		.btn-plus {
 			border-color: #B40D0C;
 			color: #B40D0C;
 			font-size: 18px;
 			height: 34px;
 		}
 		.btn-minus {
 			border-color: #B40D0C;
 			color: #B40D0C;
 		}
 		.btn-save {
 			background-color: #B40D0C;
 			color: white;
 		}
 		
 		a:link, a:visited {
 			text-decoration: none;
 			color: black;
 		}
 		#tbCinemaDate {
 			width: 40%;
 			border-style: none;
 			text-align: left;
 		}
 		#tbCinemaDate td {
 			border-style: none;
 			text-align: right;
 		}
 		#tbCinemaDate td:first {
 			width: 50px;
 		}
 		#tbTimetable {
 			text-align: left;
 		}
 		#tbTimetable td {
 			padding-left: 20px;
 		}
 		
 		
 		/* Set height of the grid so .sidenav can be 100% (adjust if needed) */
     .row.content {height: 1500px}
    
    /* Set gray background color and 100% height */
    .sidenav {
      background-color: #f1f1f1;
      height: 100%;
    }
    
    /* Set black background color, white text and some padding */
    footer {
      background-color: #555;
      color: white;
      padding: 15px;
    }
    
    /* On small screens, set height to 'auto' for sidenav and grid */
    @media screen and (max-width: 767px) {
      .sidenav {
        height: auto;
        padding: 15px;
      }
      .row.content {height: auto;} 
    }
    #menu{
    	color: black;
    	
    }
    
    .list-group-item{
    	color: black;
    }
    .list-group-item:hover{
    	color: black;
    	background-color: #969696;
    }
    
    #select li a{
    	color: white;
    	
    }
    #select li a:link {
			text-decoration: none;
			color: white;
			background-color: black;
	}
	#select li a:hover {
			text-decoration: underline;
			color: black; 
 			background-color: #FF1212;
 	} 
 	
 	
 	
 	
	.dropdown-menu{
		color: black;
		background-color: #696969;
	}
	#title-select a{
			text-decoration: none;
			color: black;
	}
	#title-select li:hover {
			text-decoration: underline;
			color: black; 
 			background-color: #969696;
 	}
 		
	</style>
	<script type="text/javascript">
		
		$(document).ready(function() {
			
			$.ajax({
				url: "/TicketingProject/admin/showtimetable.do"
				, type: "post"
				, dataType: "json"
				, success: function(data) {
					console.log(data);
				}
				, error: function(xhr) {
					console.log(xhr);
// 					alert("오류가 발생했습니다. 관리자에게 문의하세요.");
				}
			});
		});
		
		
	</script>
</head>	

<body>
	<div class="container-fluid">
	  <div class="row content">
	    <div class="col-sm-2 sidenav" id="menu" style="width: 250px">
			<%@include file="../adminMainBody.jsp" %>	
			</div>
	
	    <div class="col-sm-9" style="margin-left: 7%;">
	    	<div class="ticketing-container">
<!-- 				<div class="ticketing"> -->
<!-- 					<h1>상영시간표</h1> -->
<!-- 				</div> -->
				<div class="ticketing-movie">
					<h3>상영 시간표</h3>
					<hr>
					<div>
						<table id="tbCinemaDate">
							<tr>
								<td><h6>지역</h6></td>
								<td>
									<select required>
										<option value="S001">서울특별시</option>
										<option value="S002">대전광역시</option>
									</select>
								</td>
								<td><h6>극장정보</h6></td>
								<td>
									<select>
										<option value="CN001">대전 가수원점</option>
										<option value="CN002">대전 유성점</option>
									</select>
								</td>
								<td><h6>상영일자</h6></td>
								<td>
									<select>
										<option value="2021.06.22">2021.06.22 (화)</option>
										<option value="2021.06.22">2021.06.23 (수)</option>
										<option value="2021.06.23">2021.06.24 (목)</option>
										<option value="2021.06.24">2021.06.25 (금)</option>
										<option value="2021.06.25">2021.06.26 (토)</option>
										<option value="2021.06.27">2021.06.27 (일)</option>
										<option value="2021.06.28">2021.06.28 (월)</option>
										<option value="2021.06.29">2021.06.29 (화)</option>
									</select>
								</td>
							</tr>
						</table>
						<table id="tbTimetable">
							<thead>
								<tr>
									<td>상영영화</td>
									<td>상영시간표</td>
								</tr>
							</thead>
							<!-- tbody 시작 -->
							<tbody>
								<tr>
									<td>분노의 질주: 더 얼티메이트</td>
									<td>
										<a href="#">10:20</a>&nbsp;&nbsp;|
										<a href="#">12:40</a>&nbsp;&nbsp;|
										<a href="#">15:30</a>&nbsp;&nbsp;|
										<a href="#">19:00</a>
									</td>
								</tr>
								<tr>
									<td>콰이어트 플레이스 2</td>
									<td>
										<a href="#">10:20</a>&nbsp;&nbsp;|
										<a href="#">11:00</a>&nbsp;&nbsp;|
										<a href="#">11:40</a>&nbsp;&nbsp;|
										<a href="#">12:25</a>&nbsp;&nbsp;|
										<a href="#">13:05</a>&nbsp;&nbsp;|
										<a href="#">13:45</a>&nbsp;&nbsp;|
										<a href="#">14:30</a>&nbsp;&nbsp;|
										<a href="#">15:10</a>&nbsp;&nbsp;|
										<a href="#">15:50</a>&nbsp;&nbsp;|
										<a href="#">16:35</a>&nbsp;&nbsp;|
										<a href="#">17:15</a>&nbsp;&nbsp;|
										<a href="#">17:55</a>&nbsp;&nbsp;|
										<a href="#">18:40</a>&nbsp;&nbsp;|
										<a href="#">19:20</a>&nbsp;&nbsp;|
										<a href="#">20:00</a>
									</td>
								</tr>
								<tr>
									<td>크루엘라</td>
									<td>
										<a href="#">10:40</a>&nbsp;&nbsp;|
										<a href="#">13:20</a>&nbsp;&nbsp;|
										<a href="#">16:00</a>&nbsp;&nbsp;|
										<a href="#">18:40</a>&nbsp;&nbsp;|
										<a href="#">19:50</a>
									</td>
								</tr>
							</tbody>
							<!-- tbody 끝 -->
						</table>
					</div>	
				</div>
				<!-- ticketing movie -->
			</div> 
		</div> <!-- col-sm-9 -->
	</div>
	</div>
</body>
</html>
