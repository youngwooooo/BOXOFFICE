<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<!-- 부트스트랩 -->
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
	<!-- 탭 명 -->
	<title>박스오피스 | 극장 관리</title>
	<style type="text/css">
		#wrap_admin_cinema_manage {
			width: 1000px;
			margin-left: calc((100% - 1000px) / 2);
			display: flex;
			flex-flow: row nowrap;
			justify-content: center;
		}
		#wrap_admin_cinema_manage .title {
			font-size: 4rem;
		}
		#wrap_admin_cinema_manage .title span {
			font-size: 1.5rem;
			margin-left: 20px;
		}
		#wrap_admin_cinema_manage hr {
			width: 100%;
		}
		.btn_box {
			margin-top:	50px;
		}
		.table_cinema {
			margin-top: 10px;
		}
		.search_box {
			display: flex;
			width: 100%;
			justify-content: center;
		}
		.cinemaName span {
			cursor: pointer;
			color: #d43f3a;
		}
		.cinemaName span:hover {
			text-decoration: underline;
		}
	</style>
	<script type="text/javascript">
		var cinemaStatusCdArr = [];
		
		$(document).ready(function() {
			
			//ajax로 영업상태 코드, 스크린 유형 코드 가져와서 각 배열에 넣기
			$.ajax({
				url: "/TicketingProject/admin/cinemaCreate.do"
				, type: "get"
// 	 			, data: ""
				, dataType: "json"
				, success: function(data) {
					console.log(data);
					saveCodes(data);
				}
				, error: function(xhr) {
					console.log(xhr);
					alert("오류가 발생했습니다. 관리자에게 문의하세요.");
				}
			});
			 
			//ajax로 영업상태 코드, 스크린 유형 코드 가져와서 각 배열에 넣기
			$.ajax({
				url: "/TicketingProject/admin/cinemaListRetrieve.do"
				, type: "get"
// 	 			, data: ""
				, dataType: "json"
				, success: function(data) {
					console.log(data);
					makeTable(data);
				}
				, error: function(xhr) {
					console.log(xhr);
					alert("오류가 발생했습니다. 관리자에게 문의하세요.");
				}
			});
			
			$("#menu").css({
// 				"padding-top": "50px"
//	 			,"padding-bottom": "200px"
				"margin-left": "140px"
			});
			
		});
		
		function saveCodes(data) {
			data.forEach(item => {
				if(item.groupCd == "A07") {
					cinemaStatusCdArr.push(item);
				}
			});
		}
			
		function makeTable(data) {
			$("#table_cinema_list tbody").empty();
			
			var str = "";
			
			if(data.length == 0) {
				str = "<tr>"
						"<td colspan='4'>조회된 결과가 없습니다.</td>"
					+ "</tr>";
					
			} else {
				for(var i=0 ; i<data.length ; i++) {
					str += '<tr>'
							+ '<td>' + (i+1) + '</td>'
							+ '<td class="cinemaName">'
								+ '<span onclick="retrieveCinemaDetail(this)">'
								+ data[i].cinemaName
								+ '</span>'
								+ "<input type='hidden' name='cinemaCd' value='" + data[i].cinemacd + "'>"
							+ '</td>'
							+ '<td>' + data[i].cinemaTel + '</td>'
							+ '<td>' + data[i].cinemaTheaterCount + '</td>'
							+ '<td>';
					
					for(var j=0 ; j<cinemaStatusCdArr.length ; j++) {
						if(data[i].cinemaStatusCd == cinemaStatusCdArr[j].cd) {
							if(cinemaStatusCdArr[j].cd == "03") {
								str += '<button type="button" class="btn btn-danger btn-sm" disabled="disabled">' + cinemaStatusCdArr[j].cdName + '</button>'
							} else if(cinemaStatusCdArr[j].cd == "02") {
								str += '<button type="button" class="btn btn-sm" disabled="disabled">' + cinemaStatusCdArr[j].cdName + '</button>'
							} else {
								str += '<button type="button" class="btn btn-default btn-sm" disabled="disabled">' + cinemaStatusCdArr[j].cdName + '</button>'
							}
						}
					}
					str += '</td>'
						+ '</tr>';
				}
			}
			
			$("#table_cinema_list tbody").append(str);
		}
		
		function createCinema() {
			location.href = "/TicketingProject/jsp/admin/cinema/cinemaCreate.jsp";
		}
		
		function retrieveCinemaDetail(obj) {
			var cinemaCd = $(obj).next().val();
			
			location.href = "/TicketingProject/admin/cinemaRetrieve.do?cinemaCd=" + cinemaCd;
		}
	</script>
</head>
<body>
	<%@include file="../../common/header.jsp" %>
	<%@include file="/jsp/admin/adminMainBody.jsp" %>
	<div id="wrap_admin_cinema_manage" style="margin-top: 100px">
		<div class="container">
			<h2 class="title">극장 관리<span>극장 관리</span></h2>
			<hr>
			<div class="btn_box">
				<button type="button" class="btn btn-danger" onclick="createCinema()">극장 등록</button>
			</div>
			<table id="table_cinema_list" class="table table-hover table-striped table_cinema">
				<thead>
					<tr>
						<th>번호</th>
						<th>극장 이름</th>
						<th>전화번호</th>
						<th>상영관 개수</th>
						<th>영업 상태</th>
					</tr>
				</thead>
				<tbody>
				</tbody>
			</table>
			<div class="search_box">
				<form id="searchCinema">
					<div class="col-xs-10">
						<input type="text" class="form-control" placeholder="극장 검색">
					</div>
					<div class="col-xs-2">
						<button type="button" class="btn btn-default btn-sm">검색</button>
					</div>
				</form>
			</div>
			<hr>
		</div>
	</div>
	<%@include file="../../common/footer.jsp" %>
</body>
</html>