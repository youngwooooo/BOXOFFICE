<%@page import="common.vo.TheaterVO"%>
<%@page import="java.util.List"%>
<%@page import="common.vo.CinemaVO"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Map<String, Object> cinemaInfo = (Map)request.getAttribute("cinemaInfo");
	
	CinemaVO cinemaVO = (CinemaVO)cinemaInfo.get("cinemaVO");
	List<TheaterVO> theaterVOs = (List<TheaterVO>)cinemaInfo.get("theaterVOs");

%>
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
		#wrap_admin_cinema_detail_manage {
			width: 1000px;
			margin: 80px auto;
			display: flex;
			flex-flow: row nowrap;
			justify-content: center;
		}
		#wrap_admin_cinema_detail_manage .title {
			font-size: 4rem;
		}
		#wrap_admin_cinema_detail_manage .subtitle {
			font-size: 3rem;
			margin-left: 30px;
			margin-top: 60px;
		}
		.title span {
			font-size: 1.5rem;
			margin-left: 20px;
			color: #d9534f;
		}
		hr {
			width: 100%;
		}
		.cinema_detail_info {
			width: 100%;
			display: flex;
			flex-flow: row wrap;
		}
		.btn_box {
			display: flex;
			width: 100%;
			justify-content: center;
		}
		.btn_box button {
			margin: 5px;
		}
		.cinema_map {
			margin-top: 30px;
			width: 58%;
			height: 300px;
			border: 1px solid lightgray;
		}
		.cinema_info {
			width: 40%;
		}
		.table_cinema_detail {
			margin-top: 30px;
		}
		.table_cinema_detail tr td:first-child {
			font-size: 2rem;
			font-weight: bold;
			text-align: center;
			border: none;
		}
		.table_cinema_detail tr td:nth-child(2) {
			font-size: 1.5rem;
			border: none;
		}
		.cinema_detail_theater {
			margin-top: 30px;
		}
		.cinema_detail_theater li span {
			color: #d9534f;
			cursor: pointer;
		}
		.cinema_detail_theater li span:hover {
			text-decoration: underline;
		}
		.cinema_seat_table thead td {
			font-weight: bold;
			text-align: center;
		}
	</style>
</head>
<body>
	<%@include file="../../common/header.jsp" %>
	<div id="wrap_admin_cinema_detail_manage">
		<div class="container">
			<h2 class="title">극장 관리<span><%=cinemaVO.getCinemaName() %></span></h2>
			<hr>
			<h2 class="subtitle">극장 정보</h2>
			<form id="cinema_info">
				<div class="cinema_detail_info">
					<div id="cinema_map" class="cinema_map">
						
					</div>
					<div class="cinema_info">
						<table class="table table_cinema_detail">
							<tr>
								<td>극장 이름</td>
								<td><%=cinemaVO.getCinemaName() %></td>
								<input type="hidden" id="cinemaCd" name="cinemaCd" value="<%=cinemaVO.getCinemaCd() %>">
							</tr>
							<tr>
								<td>개관일</td>
								<td><%=cinemaVO.getCinemaOpenDate() %></td>
							</tr>
							<tr>
								<td>전화번호</td>
								<td><%=cinemaVO.getCinemaTel() %></td>
							</tr>
							<tr>
								<td>영업 상태</td>
								<td>
									<button type="button" id="cinemaStatus" class="btn btn-default btn-sm" disabled="disabled"><%=cinemaVO.getCinemaStatusCd() %></button>
								</td>
							</tr>
							<tr>
								<td>우편주소</td>
								<td><%=cinemaVO.getCinemaZip() %></td>
							</tr>
							<tr>
								<td>기본주소</td>
								<td><%=cinemaVO.getCinemaAddr1() %></td>
							</tr>
							<tr>
								<td>상세주소</td>
								<td><%=cinemaVO.getCinemaAddr2() %></td>
							</tr>
						</table>
					</div>
				</div>
			</form>
			<hr>
			<h2 class="subtitle">상영관</h2>
			<div class="cinema_detail_theater">
				<ul id="cinema_theater" class="list-group col-sm-3">
					<% for(int i=0 ; i<theaterVOs.size() ; i++) { 
						TheaterVO theaterVO = theaterVOs.get(i);
					%>
						<li class="list-group-item">
							<input type="hidden" name="theaterCd" value="<%=theaterVO.getTheaterCd() %>">
							<input type="hidden" name="theaterNo" value="<%=theaterVO.getTheaterNo() %>">
							<input type="hidden" name="screenCd" value="<%=theaterVO.getScreenCd() %>">
							<input type="hidden" name="seatRows" value="<%=theaterVO.getRowCount() %>">
							<input type="hidden" name="seatCols" value="<%=theaterVO.getColCount() %>">
							<span onclick="makeSeatTable(this)">(좌석 배치도)</span>
						</li>	
					<% } %>
				</ul>
				<div id="cinema_seat" class="cinema_seat container col-sm-9">
					<table id="cinema_seat_table" class="table">
						<thead>
							
						</thead>
						<tbody>
							
						</tbody>
					</table>
				</div>
			</div>
			<hr>
			<div class="btn_box">
				<button type="button" class="btn btn-danger btn-lg" onclick="modifyCinema()">수정</button>
				<button type="button" class="btn btn-default btn-lg" onclick="deleteCinema()">삭제</button>
			</div>
		</div>
	</div>
	<%@include file="../../common/footer.jsp" %>
</body>

<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=1eaf0df0b50eda7d73cdf3154c6049df"></script>
<script>
	var mapContainer = document.getElementById('cinema_map'), // 지도를 표시할 div 
	    mapOption = { 
	        center: new kakao.maps.LatLng(<%=cinemaVO.getMapY() %>, <%=cinemaVO.getMapX() %>), // 지도의 중심좌표
	        level: 3 // 지도의 확대 레벨
	    };
	
	// 지도를 표시할 div와  지도 옵션으로  지도를 생성합니다
	var map = new kakao.maps.Map(mapContainer, mapOption);
	
	var marker = new kakao.maps.Marker({ 
	    // 지도 중심좌표에 마커를 생성합니다 
	    position: map.getCenter() 
	}); 
	
	// 지도에 마커를 표시합니다
	marker.setMap(map);
	
	var cinemaStatusCdArr = [];
	var screenCdArr = [];
	
	$(document).ready(function() {
		//ajax로 영업상태 코드, 스크린 유형 코드 가져와서 각 배열에 넣기
		$.ajax({
			url: "/TicketingProject/admin/cinemaCreate.do"
			, type: "get"
// 			, data: ""
			, dataType: "json"
			, success: function(data) {
				console.log(data);
				saveCodes(data);
				setCinemaStatus();
				setTheaterScreen();
			}
			, error: function(xhr) {
				console.log(xhr);
				alert("오류가 발생했습니다. 관리자에게 문의하세요.");
			}
		});
	});
	
	function saveCodes(data) {
		data.forEach(item => {
			if(item.groupCd == "A05") {
				screenCdArr.push(item);
			} else if(item.groupCd == "A07") {
				cinemaStatusCdArr.push(item);
			}
		});
	}
	
	function setCinemaStatus() {
		for(var i=0 ; i<cinemaStatusCdArr.length ; i++) {
			if(cinemaStatusCdArr[i].cd == $("#cinemaStatus").text()) {
				$("#cinemaStatus").text(cinemaStatusCdArr[i].cdName);
				return;
			}
		}
	}
	
	function setTheaterScreen() {
		var theaterInfos = $("#cinema_theater li");
		
		theaterInfos.each(function(idx, item) {
			var theaterNo = $(item).children("[name=theaterNo]").val();
			var screenCd = $(item).children("[name=screenCd]").val();
			var screenName = "";
			
			for(var i=0 ; i<screenCdArr.length ; i++) {
				if(screenCdArr[i].cd == screenCd) {
					screenName = screenCdArr[i].cdName;
					break;
				}
			}
			
			var str =  theaterNo + "관 (" + screenName + ")";
			
			$(item).prepend(str);
		})
	}
	
	function makeSeatTable(obj) {
		$("#cinema_seat_table tbody").empty();
		$("#cinema_seat_table thead").empty();
		
		var theaterCdStr = $(obj).parent().children("[name=theaterCd]").val();
		var seatList;
		
		$.ajax({
			url: "/TicketingProject/admin/seatListRetrieve.do"
			, type: "get"
			, data: {theaterCd : theaterCdStr}
			, dataType: "json"
			, async: false
			, success: function(data) {
				console.log(data);
				seatList = data;
			}
			, error: function(xhr) {
				console.log(xhr);
				alert("오류가 발생했습니다. 관리자에게 문의하세요.");
			}
		});
		
		var rowCnt = $(obj).parent().children("[name=seatRows]").val();
		rowCnt = parseInt(rowCnt);
		var colCnt = $(obj).parent().children("[name=seatCols]").val();
		colCnt = parseInt(colCnt);
		
		var theaterInfo = $(obj).parent().children("[name=theaterNo]").val() + "관";
		var tableHeadStr = "<tr><td colspan='" + rowCnt + "' style='text-align: center; font-size: 2rem;'>" + theaterInfo + "</td></tr>"
		
		$("#cinema_seat_table thead").append(tableHeadStr);
		
		var idx = 0;
		
		for(var i=0 ; i<rowCnt ; i++) {
			
			var seatStr = "<tr>";
			
			for(var j=0 ; j<colCnt ; j++) {
				seatStr += '<td>';
				
				if(seatList[idx].deleteYn == "Y") {
					seatStr += '<button type="button" class="btn btn-sm" onclick="changeSeatDeleteYn(this)">' + seatList[idx].seatNo + '</button>'
				} else {
					seatStr += '<button type="button" class="btn btn-default btn-sm" onclick="changeSeatDeleteYn(this)">' + seatList[idx].seatNo + '</button>'
				}
				
				seatStr += '<input type="hidden" name="seatCd" value="' + seatList[idx].seatCd + '">'
						 + '<input type="hidden" name="seatDeleteYn" value="' + seatList[idx].deleteYn + '">'
						+ "</td>";
						
				idx += 1;
			}
			
			seatStr += "</tr>";
			
			$("#cinema_seat_table tbody").append(seatStr);
			
		}
	}
	
	function changeSeatDeleteYn(obj) {
		var seatCdStr = $(obj).parent().children("[name=seatCd]").val();
		var seatDeleteYn = $(obj).parent().children("[name=seatDeleteYn]").val();
		
		if(seatDeleteYn == "Y") {
			$(obj).addClass("btn-default");
			$(obj).parent().children("[name=seatDeleteYn]").val("N");
			seatDeleteYn = "N";
			
		} else {
			$(obj).removeClass("btn-default");
			$(obj).parent().children("[name=seatDeleteYn]").val("Y");
			seatDeleteYn = "Y";
		}
		
		$.ajax({
			url: "/TicketingProject/admin/seatDeleteYnModify.do"
			, type: "post"
			, data: { seatCd : seatCdStr
					, deleteYn : seatDeleteYn }
			, dataType: "json"
			, success: function(data) {
				console.log(data);
			}
			, error: function(xhr) {
				console.log(xhr);
				alert("오류가 발생했습니다. 관리자에게 문의하세요.");
			}
		});
		
	}
	
	function modifyCinema() {
		var fm = document.getElementById("cinema_info");
		fm.action = "/TicketingProject/admin/cinemaModify.do";
		fm.method = "get";
		fm.submit();
	}
	
	function deleteCinema() {
		if(!confirm("극장 정보를 삭제하시겠습니까?")) {
			alert("취소하셨습니다.");
			return;
		}
		
		var param = {
			cinemaCd : $("#cinemaCd").val()
		};
		
		$.ajax({
			url: "/TicketingProject/admin/cinemaDelete.do"
			, type: "get"
			, data: param
			, dataType: "json"
			, success: function(data) {
				if(data.result > 0) {
					console.log(data.result);
					alert("극장 정보를 삭제했습니다.");
					location.href = "/TicketingProject/jsp/admin/cinema/cinema.jsp";
				} else {
					alert("극장 정보 삭제에 실패했습니다.");
				}
			}
			, error: function(xhr) {
				console.log(xhr);
				alert("오류가 발생했습니다. 관리자에게 문의하세요.");
			}
		});
	}
</script>

</html>