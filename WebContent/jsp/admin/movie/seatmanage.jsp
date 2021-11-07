<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Bootstrap Example</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<style>
/* Set height of the grid so .sidenav can be 100% (adjust if needed) */
.row.content {
	height: 1500px
}

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

.category {
	font-size: small;
	float: right;
}

button {
	float: right;
	background: black;
	color: white;
}

/* On small screens, set height to 'auto' for sidenav and grid */
@media screen and (max-width: 767px) {
	.sidenav {
		height: auto;
		padding: 15px;
	}
	.row.content {
		height: auto;
	}
}
</style>
</head>
<body>
	<div class="container-fluid">
		<div class="row content">
			<div class="col-sm-2 sidenav">
				<h4>관리자 페이지</h4>
				<hr>
				<ul class="nav nav-pills nav-stacked">
					<li><a href="#section1">Home</a></li>
					<li class="active"><a href="movieregister.jsp">영화관리</a></li>
					<li><a href="#section3">Family</a></li>
					<li><a href="#section3">Photos</a></li>
				</ul>
				<br>
				<div class="input-group">
					<input type="text" class="form-control" placeholder="Search Blog..">
					<span class="input-group-btn">
						<button class="btn btn-default" type="button">
							<span class="glyphicon glyphicon-search"></span>
						</button>
					</span>
				</div>
				<br>
			</div>

			<div class="col-sm-9">
				<h4>
					<small>RECENT POSTS</small>
				</h4>
				<hr>
				<h2>좌석유형관리</h2>

				<br> <br> <br>

				<div class="row"></div>
				
				
				<button type="button"  class="btn btn-default">-</button>
				<button type="button"  class="btn btn-default">+</button>
				<table class="table">
			
					<tbody>
						
						<tr>
							<td>좌석유형</td>
							<td>01</td>
							<td>이코노미</td>
							<td>저가좌석</td>
						</tr>
						
						<tr>
							<td>좌석유형</td>
							<td>02</td>
							<td>스탠다드</td>
							<td>중가좌석</td>
						</tr>
						<tr>
							<td>좌석유형</td>
							<td>03</td>
							<td>프리미엄</td>
							<td>고가좌석</td>
						</tr>
						<tr>
							<td>좌석유형</td>
							<td>04</td>
							<td>장애인석</td>
							<td>장애인전용좌석</td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</div>



	<footer class="container-fluid">
		<p>Footer Text</p>
	</footer>
</body>
</html>
