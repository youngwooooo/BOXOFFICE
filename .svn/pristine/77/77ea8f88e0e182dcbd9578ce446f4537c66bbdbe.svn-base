<%@page import="common.vo.CinemaVO"%>
<%@page import="common.vo.MovieVO"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	Map<String, Object> mapForSetMain = (Map<String, Object>)request.getAttribute("mapForSetMain");

	List<MovieVO> movieList = (List<MovieVO>)mapForSetMain.get("movieList") == null ? null : (List<MovieVO>)mapForSetMain.get("movieList");
	List<CinemaVO> cinemaList = (List<CinemaVO>)mapForSetMain.get("cinemaList") == null ? null : (List<CinemaVO>)mapForSetMain.get("cinemaList");
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
		#wrap_ticketing_movie {
			width: 1280px;
			margin: 80px auto;
			display: flex;
			flex-flow: row wrap;
			justify-content: center;
		}
		#wrap_ticketing_movie .title {
			font-size: 4rem;
		}
		#wrap_ticketing_movie .title span {
			font-size: 2rem;
			margin-left: 20px;
		}
		hr {
			width: 100%;
		}
		.show_date {
			margin-top: 50px;
			width: calc(90% - 6px);
			display: flex;
			flex-flow: row wrap;
			border-top: 1px solid black;
			border-bottom: 1px solid black;
		}
		.show_date p {
			width: calc(100% / 10);
			text-align: center;
			font-size: 2rem;
		}
		.show_date p:hover {
			color: #ff1212;
			cursor: pointer;
		}
		.show_movie {
			width: calc(30% - 2px);
			border-left: 1px solid lightgray;
			border-right: 1px solid lightgray;
		}
		.item {
			font-size: 1.7rem;
			text-align: center;
			margin: 10px 0;
		}
		.item:hover {
			color: #ff1212;
			cursor: pointer;
		}
		.show_cinema {
			width: calc(30% - 2px);
			border-left: 1px solid lightgray;
			border-right: 1px solid lightgray;
		}
		.show_time {
			width: calc(30% - 2px);
			border-left: 1px solid lightgray;
			border-right: 1px solid lightgray;
		}
		.subtitle {
			background: black;
			font-size: 2.2rem;
			color: white;
			text-align: center;
		}
		.hr_bottom {
			width: calc(90% - 6px);
			margin-top: 0px;
			border: 1px solid lightgray;
			margin-bottom: 50px;
		}
		hr.black {
			border: 1px solid black;
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
	</style>
	<script type="text/javascript">
		$(document).ready(function() {
			var now = new Date();
			
			for(var i=0 ; i<10 ; i++) {
				var year = now.getFullYear();
				var month = now.getMonth() + 1 + "";
				var date = now.getDate() + "";
				
				if(month.length == 1) {
					month = "0" + month;
				}
				if(date.length == 1) {
					date = "0" + date;
				}
				
				var dateStr = year + "-" + month + "-" + date;
				
				var str = "<p onclick='saveDate(this)'>"
							+ now.getDate()
							+ "<input type='hidden' name='date' value='" + dateStr + "'>"
						+ "일</p>"
				$("#show_date").append(str);
				now.setDate(now.getDate() + 1);
			}
		});
		
		function saveDate(obj) {
			$("#select_date").empty();
			
			$("#show_date p").css("background-color", "white").css("color", "black");
			$(obj).css("background-color", "#ebebeb").css("color", "#ff1212");
			
			var date = $(obj).children("[name=date]").val();
			var dateStr = date + " <span id='select_time'></span>";
			
			$("#savedDate").val(date);
			$("#select_date").append(dateStr);
			
			getShowList();
			removeSavedTime();
		}
		
		function saveMovie(obj) {
			$("#show_movie p.item").css("background-color", "white").css("color", "black");
			$(obj).css("background-color", "#ebebeb").css("color", "#ff1212");
			
			var mvCd = $(obj).children("[name=mvCd]").val();
			var mvName = $(obj).text().trim();
			
			var mvFileStoreName = $(obj).children("[name=mvFileStoreName]").val();
			
			$(".selected_movie_img").empty();
			
			if(mvFileStoreName != 0) {
				var mvFileStoreNameStr = '<img alt="영화" src="' + mvFileStoreName + '">';
				
				console.log(mvFileStoreName);
				
				$(".selected_movie_img").append(mvFileStoreNameStr);
				$("#savedMovieFileStoreName").val(mvFileStoreName);
			} else {
				$("#savedMovieFileStoreName").val(0);
			}
			
			$("#select_movie_name").text(mvName);
			$("#savedMovieCd").val(mvCd);
			$("#savedMovieName").val(mvName);
			
			getShowList();
			removeSavedTime();
		}
		
		function saveCinema(obj) {
			$("#show_cinema p.item").css("background-color", "white").css("color", "black");
			$(obj).css("background-color", "#ebebeb").css("color", "#ff1212");
			
			var cinemaCd = $(obj).children("[name=cinemaCd]").val();
			var cinemaName = $(obj).text().trim();
			
			$("#select_cinema").text(cinemaName);
			$("#savedCinemaCd").val(cinemaCd);
			$("#savedCinemaName").val(cinemaName);
			
			getShowList();
			removeSavedTime();
		}
		
		function removeSavedTime() {
			$("#savedTime").val("");
			$("#savedTheaterCd").val("");
			$("#savedTheaterNo").val("");
			$("#savedScreenCd").val("");
			$("#savedScreenName").val("");
			$("#savedShowCd").val("");
			$("#select_time").text("");
			$("#select_theater").text("");
			$("#select_seat_btn").attr("disabled", true);
		}
		
		function saveTime(obj) {
			$("#savedTime p.item").css("background-color", "white").css("color", "black");
			$(obj).css("background-color", "#ebebeb").css("color", "#ff1212");

			var showStartTime = $(obj).children("[name=showStartTime]").val();
			var theaterCd = $(obj).children("[name=theaterCd]").val();
			var theaterNo = $(obj).children("[name=theaterNo]").val();
			var screenCd = $(obj).children("[name=screenCd]").val();
			var screenName = $(obj).children("[name=screenName]").val();
			var showCd = $(obj).children("[name=showCd]").val();
			
			$("#savedTime").val(showStartTime);
			$("#savedTheaterCd").val(theaterCd);
			$("#savedTheaterNo").val(theaterNo);
			$("#savedScreenCd").val(screenCd);
			$("#savedScreenName").val(screenName);
			$("#savedShowCd").val(showCd);
			
			$("#select_time").text(showStartTime);
			$("#select_theater").text(theaterNo + "관 - " + screenName);
			$("#select_seat_btn").removeAttr("disabled");
			
			
		}
		
		function getShowList() {
			$.ajax({
				url: "/TicketingProject/member/retrieveTicketingShow.do"
				, type: "post"
				, data: $("#save_form").serialize()
				, dataType: "json"
				, success: function(data) {
					console.log(data);
					
					makeTimeTable(data);
				}
				, error: function(xhr) {
					console.log(xhr);
					alert("오류가 발생했습니다. 관리자에게 문의하세요.");
				}
			});
		}
		
		function makeTimeTable(data) {
			$("#show_time").children(".item").remove();
			
			if(($("#savedDate").val() != null && $("#savedDate").val() != "")
					&& ($("#savedMovieCd").val() != null && $("#savedMovieCd").val() != "")
					&& $("#savedCinemaCd").val() != null && $("#savedCinemaCd").val() != "") {
				if(data.length > 0) {
					for(var i=0 ; i<data.length ; i++) {
						var str = '<p class="item" onclick="saveTime(this)">'
									+ data[i].showStartTime
									+ ' ('
									+ data[i].theaterNo
									+ "관 - "
									+ data[i].screenName
									+ ')'
									+ '<input type="hidden" name="theaterCd" value="' + data[i].theaterCd + '">'
									+ '<input type="hidden" name="showStartTime" value="' + data[i].showStartTime + '">'
									+ '<input type="hidden" name="theaterNo" value="' + data[i].theaterNo + '">'
									+ '<input type="hidden" name="screenCd" value="' + data[i].screenCd + '">'
									+ '<input type="hidden" name="screenName" value="' + data[i].screenName + '">'
									+ '<input type="hidden" name="showCd" value="' + data[i].showCd + '">'
								+ '</p>';
						$("#show_time").append(str);
					}
				} else {
					var str = '<p class="item">등록된 상영 정보가 없습니다.</p>';
					$("#show_time").append(str);
				}
			}
		}
		
		function selectSeat() {
			if (checkLogin() == false) {
				return;
				
			}else {				
				var fm = document.getElementById("save_form");
				fm.action = "/TicketingProject/member/SetTicketingSeat.do";
				fm.method = "post";
				fm.submit();
			}
		}
		
		
	</script>
</head>
<body>
	<%@include file="../../common/header.jsp" %>

	<div id="wrap_ticketing_movie">
		<h2 class="title">예매<span> / 영화 선택</span></h2>
		<hr>
		<div id="show_date" class="show_date">
		</div>
		<div id="show_movie" class="show_movie">
			<p class="subtitle">영화</p>
<%
for(int i=0 ; i<movieList.size() ; i++){
	MovieVO movieVO = movieList.get(i);
%>
			<p class="item" onclick="saveMovie(this)">
				<%=movieVO.getMvNameKor() %>
				<input type="hidden" name="mvCd" value="<%=movieVO.getMvCd() %>">
<%
		if(movieVO.getFileStoreName() != null) {
%>
				<input type="hidden" name="mvFileStoreName" value="/TicketingProject/images/admin/<%=movieVO.getFileStoreName() %>">
<%
		} else {
%>
				<input type="hidden" name="mvFileStoreName" value="0">
<%
		}
%>
			</p>
<%
}
%>
		</div>
		<div id="show_cinema" class="show_cinema">
			<p class="subtitle">극장</p>
<%
for(int j=0 ; j<cinemaList.size() ; j++){
	CinemaVO cinemaVO = cinemaList.get(j);
%>
			<p class="item" onclick="saveCinema(this)">
				<%=cinemaVO.getCinemaName() %>
				<input type="hidden" name="cinemaCd" value="<%=cinemaVO.getCinemaCd() %>">
			</p>
<%
}
%>
		</div>
		<div id="show_time" class="show_time">
			<p class="subtitle">시각</p>
		</div>
		<hr class="hr_bottom">
		<hr class="black">
		<div class="selected_info">
			<div class="selected_movie_info">
				<div class="selected_movie">
					<div class="selected_movie_img">
					</div>
					<div id="select_movie_name" class="selected_movie_name">
					</div>
				</div>
			</div>
			<div class="selected_show_info">
				<table class="selected_show_table">
					<tr>
						<td>극장</td>
						<td id="select_cinema"></td>
					</tr>
					<tr>
						<td>일시</td>
						<td id="select_date">
						</td>
					</tr>
					<tr>
						<td>상영관</td>
						<td id="select_theater"></td>
					</tr>
					<tr>
						<td>인원</td>
						<td id="select_count"></td>
					</tr>
				</table>
			</div>
			<div class="btn_box">
				<button id="select_seat_btn" type="button" class="btn btn-danger btn-lg" disabled onclick="selectSeat()">좌석선택 <span class="glyphicon glyphicon-chevron-right"></span></button>
			</div>
		</div>
<div>
</div>
		<hr>
		<form id="save_form">
			<input type="hidden" id="savedDate" name="savedDate">
			<input type="hidden" id="savedMovieCd" name="savedMovieCd">
			<input type="hidden" id="savedMovieName" name="savedMovieName">
			<input type="hidden" id="savedMovieFileStoreName" name="savedMovieFileStoreName">
			<input type="hidden" id="savedCinemaCd" name="savedCinemaCd">
			<input type="hidden" id="savedCinemaName" name="savedCinemaName">
			<input type="hidden" id="savedTime" name="savedTime">
			<input type="hidden" id="savedTheaterCd" name="savedTheaterCd">
			<input type="hidden" id="savedTheaterNo" name="savedTheaterNo">
			<input type="hidden" id="savedScreenCd" name="savedScreenCd">
			<input type="hidden" id="savedScreenName" name="savedScreenName">
			<input type="hidden" id="savedShowCd" name="savedShowCd">
		</form>
	</div>
	<%@include file="../../common/footer.jsp" %>
</body>
<script type="text/javascript">
	//위의 script에 선언하면 인식 못해서 아래에 작성
	function checkLogin() {
		<% if(loginVO == null){ %>
				alert("로그인이 필요합니다.");
				location.href="/TicketingProject/jsp/member/signIn/signInPage.jsp";
				return false;
		<% } %>
	}
</script>
</html>