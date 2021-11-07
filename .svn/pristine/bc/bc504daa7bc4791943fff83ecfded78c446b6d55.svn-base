<%@page import="common.vo.TicketingShowVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	TicketingShowVO ticketingShowVO = (TicketingShowVO)request.getAttribute("ticketingShowVO");
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
	<title>박스오피스 | 예매</title>
	<style type="text/css">
		#wrap_ticketing_seat {
			width: 1280px;
			margin: 80px auto;
			display: flex;
			flex-flow: row wrap;
			justify-content: center;
		}
		#wrap_ticketing_seat .title {
			font-size: 4rem;
		}
		#wrap_ticketing_seat .title span {
			font-size: 2rem;
			margin-left: 20px;
		}
		hr {
			width: 100%;
		}
		hr.black {
			border: 1px solid black;
		}
		.subtitle {
			background: black;
			font-size: 2.2rem;
			color: white;
			text-align: center;
			width: 100%;
		}
		.selected_info {
			width: 100%;
			height: 140px;
			background: #e6e6e6;
			display: flex;
			flex-flow: row wrap;
			justify-content: space-between;
			align-items: center;
		}
		
		.selected_movie_info {
			width: 20%;
			margin-left: 100px;
		}
		.selected_movie {
			display: flex;
			flex-flow: row wrap;
			justify-content: flex-end;
		}
		.selected_movie_img {
			height: 100px;
			width: 30%;
			text-align: right;
		}
		.selected_movie_img img {
			max-height: 100px;
			width: auto;
		}
		.selected_movie_name {
			width: 70%;
			padding-left: 20px;
			align-self: center;
			font-size: 1.5rem;
			font-weight: bold;	
		}
		
		.selected_show_info {
			width: 20%;
		}
		.selected_show_table td {
			font-size: 1.5rem;
		}
		.selected_show_table td:first-child {
			width: 70px;
		}
		
		.btn_box {
			width: 20%;
		}
		.btn_box button {
			height: 100px;
		}
		
		.personnel {
			width: 100%;
			display: flex;
			flex-flow: row wrap;
			justify-content: center;
		}
		.personnel_each {
			width: 20%;
			display: flex;
			flex-flow: row wrap;
			margin: 20px 0;
		}
		.personnel_each p {
			width: 20%;
			font-size: 1.6rem;
		}
		.personnel_btn_box {
			width: 80%;
			display: flex;
			justify-content: center;
		}
		.personnel_btn_box div {
			font-size: 1.7rem;
		}
		.personnel_btn_box button {
			margin: 0 30px 0 30px;
		}
		
		.seat {
			width: 100%;
			display: flex;
			flex-flow: row wrap;
			justify-content: center;
		}
		.seat_table {
			margin: 10px 0;
			width: 50%;
		}
		.seat_table td {
			text-align: center;
		}
		.seat_side {
			width: 20%;
			background: #f7f7f7;
			margin-left: 40px;
		}
		hr.bottom {
			border: 1px solid black;
			margin-top: 0;
		}
		.seat_side_tit {
			width: 100%;
			margin-top: 200px;
			text-align: center;
			font-size: 1.6rem;
			font-weight: bold;
		}
		.seat_notify_table {
			width: 100%;
 			margin: 15px auto;
		}
		.seat_notify_table td:first-child {
			width: 120px;
			text-align: right;
			font-weight: bold;
		}
		.seat_notify_table td:nth-child(2) {
			text-align: left;
		}
		.price_info {
			margin-top: 150px;
		}
		.price_info p {
			text-align: center;
			font-size: 2rem;
		}
		.total_price {
			margin-left: 5px;
			margin-right: 5px;
			font-size: 2.2rem;
			color: #ff1212;
		}
	</style>
	<script type="text/javascript">
		$(document).ready(function() {
			var theaterCdStr = $("#savedTheaterCd").val();
			var seatList;
			
			$.ajax({
				url: "/TicketingProject/member/retrieveTicketingSeat.do"
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
			
			var rowCnt = seatList[0].rowCount;
			rowCnt = parseInt(rowCnt);
			var colCnt = seatList[0].colCount;
			colCnt = parseInt(colCnt);
			var idx = 1;
			
			for(var i=0 ; i<rowCnt ; i++) {
				var seatStr = "<tr>";
				
				for(var j=0 ; j<colCnt ; j++) {
					seatStr += '<td>';
					
					if(seatList[idx].deleteYn == "Y") {
						seatStr += '<button type="button" class="btn btn-sm" disabled>' + seatList[idx].seatNo + '</button>'
					} else {
						seatStr += '<button type="button" class="btn btn-default btn-sm" onclick="selectSeat(this)">' + seatList[idx].seatNo + '</button>'
					}
					
					seatStr += '<input type="hidden" name="seatCd" value="' + seatList[idx].seatCd + '">'
							 + '<input type="hidden" name="seatTypeCd" value="' + seatList[idx].seatTypeCd + '">'
							 + '<input type="hidden" name="seatNo" value="' + seatList[idx].seatNo + '">'
							 + '<input type="hidden" name="selectedChk" value="N">'
							+ "</td>";
							
					idx += 1;
				}
				
				seatStr += "</tr>";
				
				$("#seat_table tbody").append(seatStr);
				
			}
			
			setSeatForm();
			setPayForm();
		});
		
		function setPayForm() {
			
			$("#payDate").val($("#savedDate").val());
			$("#payMovieCd").val($("#savedMovieCd").val());
			$("#payMovieName").val($("#savedMovieName").val());
			$("#payMovieFileStoreName").val($("#savedMovieFileStoreName").val());
			$("#payCinemaCd").val($("#savedCinemaCd").val());
			$("#payCinemaName").val($("#savedCinemaName").val());
			$("#payTime").val($("#savedTime").val());
			$("#payTheaterCd").val($("#savedTheaterCd").val());
			$("#payTheaterNo").val($("#savedTheaterNo").val());
			$("#payScreenCd").val($("#savedScreenCd").val());
			$("#payScreenName").val($("#savedScreenName").val());
			$("#payShowCd").val($("#savedShowCd").val());
			
		}
		
		function setSeatForm() {
			var date = $("#savedDate").val();
			var day = new Date(date).getDay();
			
			if(day == 6 || day == 0) {
				$("#weekendYn").val("Y");
			} else {
				$("#weekendYn").val("N");
			}
			
			var hour = parseInt($("#savedTime").val().substr(0, 2));
			
			if(hour >= 6 && hour <= 9) {
				$("#timeTypeCd").val("01");
			} else if(hour >= 10 && hour <= 22) {
				$("#timeTypeCd").val("02");
			} else {
				$("#timeTypeCd").val("03");
			}
			
			$("#screenCd").val($("#savedScreenCd").val());
		}
		
		function subCount(obj) {
			var count = parseInt($(obj).next().text());
			
			if(count == 0) {
				return;
			}
			
			var totalCount = 0;
			
			$(".personnel_count").each(function(idx, item) {
				totalCount = totalCount + parseInt($(item).text());
			})
			
			var selectedSeatCount = $("[name=selectedChk][value='Y']").length;
			
			if(totalCount == selectedSeatCount) {
				alert("선택한 좌석을 취소해주세요.");
				return;
			}
			
			$(obj).next().text(count - 1);
			
			$("#select_count").text(totalCount - 1);
			$("#payCount").val(totalCount - 1);
		}
		
		function addCount(obj) {
			var totalCount = 0;
			
			$(".personnel_count").each(function(idx, item) {
				totalCount = totalCount + parseInt($(item).text());
			})
			
			console.log(totalCount);
			
			if(totalCount >= 4) {
				alert("4명 이상의 인원을 선택할 수 없습니다.");
				return;
			}
			
			var count = parseInt($(obj).prev().text());
			
			$(obj).prev().text(count + 1);
			
			$("#pay_btn").attr("disabled", true);
			
			$("#select_count").text(totalCount + 1);
			$("#payCount").val(totalCount + 1);
			
		}
		
		function selectSeat(obj) {
			var selectedChk = $(obj).parent().children("[name=selectedChk]").val();
			
			if(selectedChk == "Y") {
				$(obj).parent().children("[name=selectedChk]").val("N");
				$(obj).removeClass("btn-danger");
				$(obj).addClass("btn-default");
				$("#pay_btn").attr("disabled", true);
			} else {
				var totalCount = 0;
				
				$(".personnel_count").each(function(idx, item) {
					totalCount = totalCount + parseInt($(item).text());
				})
				
				if(totalCount == 0) {
					alert("인원 수를 선택해주세요.");
					return;
				}
				
				var selectedSeatCount = $("[name=selectedChk][value='Y']").length;
				
				if(totalCount == selectedSeatCount) {
					alert("인원 수를 초과하여 좌석을 선택할 수 없습니다.");
					return;
				}
				
				$(obj).parent().children("[name=selectedChk]").val("Y");
				$(obj).addClass("btn-danger");
				$(obj).removeClass("btn-default");
				
				selectedSeatCount = $("[name=selectedChk][value='Y']").length;
				
				if(totalCount == selectedSeatCount) {
					$("#pay_btn").removeAttr("disabled");
				}
			}
			
			var selectedSeatStr = "";
			var selectedSeatNoStr = "";
			var selectedSeats = $("[name=selectedChk][value='Y']");
			
			if(selectedSeats.length > 0) {
				for(var i=0 ; i<selectedSeats.length ; i++) {
					if(i > 0) {
						selectedSeatStr += ", ";
						selectedSeatNoStr += ", ";
					}
					selectedSeatStr += selectedSeats.eq(i).prev().val();
					
					selectedSeatNoStr += selectedSeats.eq(i).parent().children("[name=seatTypeCd]").val()
					//여기
				}
			}
			
			$("#select_seat").text(selectedSeatStr);
			
			$("#paySeat").val(selectedSeatStr);
			$("#paySeatNo").val(selectedSeatNoStr);
			
			getTotalPrice();
		}
		
		function getTotalPrice() {
			var audienceCds = [];
			
			$(".personnel_count").each(function(idx, item) {
				var count = parseInt($(item).text());
				
				if(count != 0) {
					for(var i=0 ; i<count ; i++) {
						audienceCds.push($(item).parent().children("[name=audienceCd]").val());
					}
				}
			});
			
			var selectedSeats = $("[name=selectedChk][value='Y']");
			var totalPrice = 0;
			var totalPriceStr = "";
			var audienceCdStr = "";
			
			//선택된 좌석들에 해당하는 관객 코드 --> 문자열
			for(var i=0; i<audienceCds.length; i++) {
				audienceCdStr += audienceCds[i] + ", ";
			}
			if(audienceCdStr != "") { //제일 마지막 , 제거
				audienceCdStr = audienceCdStr.substr(0, audienceCdStr.length-2);
			}
			
			selectedSeats.each(function(idx, item) {
				var param = {
					weekendYn : $("#weekendYn").val()
					, audienceCd : audienceCds[idx]
					, timeTypeCd : $("#timeTypeCd").val()
					, seatTypeCd : $(item).parent().children("[name=seatTypeCd]").val() //이거
					, screenCd : $("#screenCd").val()
				};
				
				$.ajax({
					url: "/TicketingProject/member/retrieveTicketingPrice.do"
					, type: "post"
					, data: param
					, async: false
					, dataType: "json"
					, success: function(data) {
						console.log(data);
						totalPrice += parseInt(data.price);
						totalPriceStr += data.price + ", ";
					}
					, error: function(xhr) {
						console.log(xhr);
						alert("오류가 발생했습니다. 관리자에게 문의하세요.");
					}
				});
												
			});
			
			$("#total_price").text(totalPrice);
			$("#payPrice").val(totalPrice);
			
			if(totalPriceStr != "") { //제일 마지막 , 제거
				totalPriceStr = totalPriceStr.substr(0, totalPriceStr.length-2);
			}
			
			$("#payPriceStr").val(totalPriceStr);
			$("#payAudienceCdStr").val(audienceCdStr);
		}
		
		function pay() {
			var fm = document.getElementById("pay_form");
			fm.action = "/TicketingProject/member/setTicketingPay.do";
			fm.method = "post";
			fm.submit();
		}
	</script>
</head>
<body>
	<%@include file="../../common/header.jsp" %>
	<div id="wrap_ticketing_seat">
		<h2 class="title">예매<span> / 인원 및 좌석 선택</span></h2>
		<hr>
		<div class="personnel">
			<p class="subtitle">인원</p>
			<div id="personnel_adult" class="personnel_each">
				<p>성인</p>
				<div class="personnel_btn_box">
					<button type="button" class="btn btn-default btn-sm" onclick="subCount(this)">－</button>
					<div class="personnel_count">0</div>
					<button type="button" class="btn btn-default btn-sm" onclick="addCount(this)">＋</button>
					<input type="hidden" name="audienceCd" value="01">
				</div>
			</div>
			<div id="personnel_youth" class="personnel_each">
				<p>청소년</p>
				<div class="personnel_btn_box">
					<button type="button" class="btn btn-default btn-sm" onclick="subCount(this)">－</button>
					<div class="personnel_count">0</div>
					<button type="button" class="btn btn-default btn-sm" onclick="addCount(this)">＋</button>
					<input type="hidden" name="audienceCd" value="02">
				</div>
			</div>
			<div id="personnel_elderly" class="personnel_each">
				<p>경로</p>
				<div class="personnel_btn_box">
					<button type="button" class="btn btn-default btn-sm" onclick="subCount(this)">－</button>
					<div class="personnel_count">0</div>
					<button type="button" class="btn btn-default btn-sm" onclick="addCount(this)">＋</button>
					<input type="hidden" name="audienceCd" value="03">
				</div>
			</div>
			<div id="personnel_disabled" class="personnel_each">
				<p>우대</p>
				<div class="personnel_btn_box">
					<button type="button" class="btn btn-default btn-sm" onclick="subCount(this)">－</button>
					<div class="personnel_count">0</div>
					<button type="button" class="btn btn-default btn-sm" onclick="addCount(this)">＋</button>
					<input type="hidden" name="audienceCd" value="04">
				</div>
			</div>
		</div>
		<div class="seat">
			<p class="subtitle">좌석</p>
			<table id="seat_table" class="table seat_table">
				<thead>
				</thead>
				<tbody>
				</tbody>
			</table>
			<div class="seat_side">
				<p class="seat_side_tit">좌석 안내</p>
				<table class="seat_notify_table">
					<tr>
						<td>A - C　</td>
						<td>| 이코노미석</td>
					</tr>
					<tr>
						<td>D - H　</td>
						<td>| 스탠다드석</td>
					</tr>
					<tr>
						<td>I - K　</td>
						<td>| 프리미엄석</td>
					</tr>
				</table>
				<div class="price_info">
					<p>총 금액 <span id="total_price" class="total_price">0</span>원</p>
				</div>
			</div>
		</div>
		<hr class="bottom">
		<div class="selected_info">
			<div class="selected_movie_info">
				<div class="selected_movie">
					<div class="selected_movie_img">
						<% if(!ticketingShowVO.getFileStoreName().equals("0")) { %>
						<img alt="영화" src="<%=ticketingShowVO.getFileStoreName() %>">
						<% } %>
					</div>
					<div id="select_movie_name" class="selected_movie_name">
						<%=ticketingShowVO.getMvNameKor() %>
					</div>
				</div>
			</div>
			<div class="selected_show_info">
				<table class="selected_show_table">
					<tr>
						<td>극장</td>
						<td id="select_cinema">
							<%=ticketingShowVO.getCinemaName() %>
						</td>
					</tr>
					<tr>
						<td>일시</td>
						<td id="select_date">
							<%=ticketingShowVO.getShowDate() %> <%=ticketingShowVO.getShowStartTime() %>
						</td>
					</tr>
					<tr>
						<td>상영관</td>
						<td id="select_theater">
							<%=ticketingShowVO.getTheaterNo() %>관 - <%=ticketingShowVO.getScreenName() %>
						</td>
					</tr>
					<tr>
						<td>인원</td>
						<td id="select_count">0</td>
					</tr>
					<tr>
						<td>좌석</td>
						<td id="select_seat">0</td>
					</tr>
				</table>
			</div>
			<div class="btn_box">
				<button id="pay_btn" type="button" class="btn btn-danger btn-lg" disabled onclick="pay()">결제하기 <span class="glyphicon glyphicon-chevron-right"></span></button>
			</div>
		</div>
		<hr>
		<form id="save_form">
			<input type="hidden" id="savedDate" name="savedDate" value="<%=ticketingShowVO.getShowDate() %>">
			<input type="hidden" id="savedMovieCd" name="savedMovieCd" value="<%=ticketingShowVO.getMvCd() %>">
			<input type="hidden" id="savedMovieName" name="savedMovieName" value="<%=ticketingShowVO.getMvNameKor() %>">
			<input type="hidden" id="savedMovieFileStoreName" name="savedMovieFileStoreName" value="<%=ticketingShowVO.getFileStoreName() %>">
			<input type="hidden" id="savedCinemaCd" name="savedCinemaCd" value="<%=ticketingShowVO.getCinemaCd() %>">
			<input type="hidden" id="savedCinemaName" name="savedCinemaName" value="<%=ticketingShowVO.getCinemaName() %>">
			<input type="hidden" id="savedTime" name="savedTime" value="<%=ticketingShowVO.getShowStartTime() %>">
			<input type="hidden" id="savedTheaterCd" name="savedTheaterCd" value="<%=ticketingShowVO.getTheaterCd() %>">
			<input type="hidden" id="savedTheaterNo" name="savedTheaterNo" value="<%=ticketingShowVO.getTheaterNo() %>">
			<input type="hidden" id="savedScreenCd" name="savedScreenCd" value="<%=ticketingShowVO.getScreenCd() %>">
			<input type="hidden" id="savedScreenName" name="savedScreenName" value="<%=ticketingShowVO.getScreenName() %>">
			<input type="hidden" id="savedShowCd" name="savedShowCd" value="<%=ticketingShowVO.getShowCd() %>">
		</form>
		<form id="seat_form">
			<input type="hidden" id="weekendYn" name="weekendYn">
			<input type="hidden" id="timeTypeCd" name="timeTypeCd">
			<input type="hidden" id="screenCd" name="screenCd">
		</form>
		<form id="pay_form">
			<input type="hidden" id="payDate" name="payDate">
			<input type="hidden" id="payMovieCd" name="payMovieCd">
			<input type="hidden" id="payMovieName" name="payMovieName">
			<input type="hidden" id="payMovieFileStoreName" name="payMovieFileStoreName">
			<input type="hidden" id="payCinemaCd" name="payCinemaCd">
			<input type="hidden" id="payCinemaName" name="payCinemaName">
			<input type="hidden" id="payTime" name="payTime">
			<input type="hidden" id="payTheaterCd" name="payTheaterCd">
			<input type="hidden" id="payTheaterNo" name="payTheaterNo">
			<input type="hidden" id="payScreenCd" name="payScreenCd">
			<input type="hidden" id="payScreenName" name="payScreenName">
			<input type="hidden" id="payCount" name="payCount">
			<input type="hidden" id="paySeat" name="paySeat">
			<input type="hidden" id="paySeatNo" name="paySeatNo">
			<input type="hidden" id="payPrice" name="payPrice">
			<input type="hidden" id="payPriceStr" name="payPriceStr">
			<input type="hidden" id="payShowCd" name="payShowCd">
			<input type="hidden" id="payAudienceCdStr" name="payAudienceCdStr">
		</form>
	</div>
	<%@include file="../../common/footer.jsp" %>
</body>
</html>