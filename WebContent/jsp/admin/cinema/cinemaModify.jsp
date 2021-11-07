<%@page import="common.vo.CodeVO"%>
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
	List<CodeVO> codeVOs = (List<CodeVO>)request.getAttribute("list");
	
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
	<script src="/TicketingProject/js/common/myUtils.js?v=1"></script>
	<!-- 탭 명 -->
	<title>박스오피스 | 극장 관리</title>
	<style type="text/css">
		#wrap_admin_cinema_create_manage {
			width: 1000px;
			margin: 80px auto;
			display: flex;
			flex-flow: row nowrap;
			justify-content: center;
		}
		#wrap_admin_cinema_create_manage .title {
			font-size: 4rem;
		}
		#wrap_admin_cinema_create_manage .subtitle {
			font-size: 3rem;
			margin-left: 30px;
			margin-top: 60px;
		}
		.title span {
			font-size: 1.5rem;
			margin-left: 20px;
			color: #d43f3a;
		}
		hr {
			width: 100%;
		}
		.btn_box {
			display: flex;
			width: 100%;
			justify-content: center;
		}
		.btn_box button {
			margin: 5px;
		}
		.cinema_info {
			width: 100%;
			justify-content: center;
		}
		.cinema_map {
			width: 100%;
			height: 400px;
/* 			border: 1px solid black; */
		}
		.cinema_theater {
			width: 100%;
		}
		.btn_box_theater {
			width: 100%;
			display:flex;
			justify-content: center;
		}
		.btn_box_theater button {
			margin: 0 5px;
		}
		.table_cinema_theater {
			margin-top: 10px;
		}
		.table_cinema_theater select {
			height: 26px;
		}
	</style>
</head>

<body>
	<%@include file="../../common/header.jsp" %>
	<div id="wrap_admin_cinema_create_manage">
		<div class="container">
			<h2 class="title">극장 관리<span>극장 수정</span></h2>
			<hr>
			<h2 class="subtitle">극장 정보</h2>
			<hr>
			<form class="form-horizontal" id="cinema_info_form">
				<div class="container cinema_info">
					<div class="form-group">
						<label class="control-label col-sm-2" for="cinemaName">극장 이름</label>
						<div class="col-sm-8">
							<input type="hidden" name="cinemaCd" value="<%=cinemaVO.getCinemaCd() %>" id="cinemaCd">
							<input type="text" class="form-control" name="cinemaName" value="<%=cinemaVO.getCinemaName() %>" id="cinemaName" readonly>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2" for="cinemaOpenDate">극장 개관일</label>
						<div class="col-sm-8">
							<input type="date" class="form-control" name="cinemaOpenDate" value="<%=cinemaVO.getCinemaOpenDate().replace("/", "-") %>" id="cinemaOpenDate">
							<input type="hidden" value="<%=cinemaVO.getCinemaOpenDate().replace("/", "-") %>" id="orgCinemaOpenDate">
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2" for="cinemaTel">극장 전화번호</label>
						<div class="col-sm-8">
							<input type="tel" class="form-control" name="cinemaTel" value="<%=cinemaVO.getCinemaTel() %>" id="cinemaTel" maxlength="11" placeholder="붙임표를 제외하고 작성 (예: 021112222)">
							<input type="hidden" value="<%=cinemaVO.getCinemaTel() %>" id="orgCinemaTel">
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2" for="cinemaStatus">극장 영업상태</label>
						<div class="col-sm-8">
							<select class="form-control" name="cinemaStatus" id="cinemaStatus">
								<% for(int j=0 ; j<codeVOs.size() ; j++) {
										CodeVO codeVO = codeVOs.get(j);
										if(codeVO.getGroupCd().equals("A07")) {
											if(cinemaVO.getCinemaStatusCd().equals(codeVO.getCd())) {
								%>
									<option value="<%=codeVO.getCd() %>" selected="selected"><%=codeVO.getCdName() %></option>
								<%
											} else {
								%>
									<option value="<%=codeVO.getCd() %>"><%=codeVO.getCdName() %></option>
								<%
											}
										}
									}
								%>
							</select>
							<input type="hidden" value="<%=cinemaVO.getCinemaStatusCd() %>" id="orgCinemaStatus">
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2" for="cinemaZip">극장 우편번호</label>
						<div class="col-sm-8">
							<input type="text" class="form-control" name="cinemaZip" value="<%=cinemaVO.getCinemaZip() %>" id="cinemaZip" readonly="readonly">
							<input type="hidden" value="<%=cinemaVO.getCinemaZip() %>" id="orgCinemaZip">
						</div>
						<button type="button" onclick="getAddress()" class="btn btn-default btn-sm col-sm-2">우편번호 검색</button>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2" for="cinemaAddr1">극장 주소</label>
						<div class="col-sm-8">
							<input type="text" class="form-control" name="cinemaAddr1" value="<%=cinemaVO.getCinemaAddr1() %>" id="cinemaAddr1" readonly="readonly">
							<input type="hidden" value="<%=cinemaVO.getCinemaAddr1() %>" id="orgCinemaAddr1">
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2" for="cinemaAddr2">극장 상세주소</label>
						<div class="col-sm-8">
							<input type="text" class="form-control" name="cinemaAddr2" value="<%=cinemaVO.getCinemaAddr2() %>" id="cinemaAddr2"  maxlength="50">
							<input type="hidden" value="<%=cinemaVO.getCinemaAddr2() %>" id="orgCinemaAddr2">
						</div>
					</div>
				</div>
				<hr>
				<h2 class="subtitle">지도</h2>
				<hr>
				<div id="cinema_map" class="cinema_map">
					<input type="hidden" id="mapX" name="mapX" value="<%=cinemaVO.getMapX() %>">
					<input type="hidden" id="mapY" name="mapY" value="<%=cinemaVO.getMapY() %>">
					<input type="hidden" id="orgMapX" value="<%=cinemaVO.getMapX() %>">
					<input type="hidden" id="orgMapY" value="<%=cinemaVO.getMapY() %>">
				</div>
			</form>
			<hr>
			<h2 class="subtitle">상영관</h2>
			<hr>
			<div class="cinema_theater">
				<table id="table_cinema_theater" class="table table-striped table_cinema_theater">
					<thead>
						<tr>
							<th>선택</th>
							<th>관 번호</th>
							<th>스크린 유형</th>
							<th>좌석 행 개수</th>
							<th>좌석 열 개수</th>
							<th>사용여부</th>
						</tr>
					</thead>
					<tbody>
						<% for(int i=0 ; i<theaterVOs.size() ; i++) { 
								TheaterVO theaterVO = theaterVOs.get(i);
						%>
							<tr>
								<td>
									<input type="checkbox" class="chkbox_cinema_theater_seat">
								</td>
								<td class="theaterNo">
									<input type="hidden" name="theaterCd" value="<%=theaterVO.getTheaterCd() %>">
									<input type="number" name="theaterNo" min="1" max="10" value="<%=theaterVO.getTheaterNo() %>" maxlength="2">
									<input type="hidden" name="orgTheaterNo" value="<%=theaterVO.getTheaterNo() %>">
								</td>
								<td>
									<select name="screenCd">
										<% for(int j=0 ; j<codeVOs.size() ; j++) {
												CodeVO codeVO = codeVOs.get(j);
												if(codeVO.getGroupCd().equals("A05")) {
													if(theaterVO.getScreenCd().equals(codeVO.getCd())) {
										%>
											<option value="<%=codeVO.getCd() %>" selected="selected"><%=codeVO.getCdName() %></option>
										<%
													} else {
										%>
											<option value="<%=codeVO.getCd() %>"><%=codeVO.getCdName() %></option>
										<%
													}
												}
											}
										%>
									</select>
									<input type="hidden" name="orgScreenCd" value="<%=theaterVO.getScreenCd() %>">
								</td>
								<td>
									<input type="number" name="seatRows" min="1" max="11" value="<%=theaterVO.getRowCount() %>" maxlength="2">
									<input type="hidden" name="orgSeatRows" value="<%=theaterVO.getRowCount() %>">
								</td>
								<td>
									<input type="number" name="seatColumns" min="1" max="13" value="<%=theaterVO.getColCount() %>" maxlength="2">
									<input type="hidden" name="orgSeatColumns" value="<%=theaterVO.getColCount() %>">
								</td>
								<td>
									<% if(theaterVO.getDeleteYn().equals("Y")) { %>
										<button type="button" class="btn btn-sm" onclick="changeDeleteYn(this)">사용하기</button>
									<% } else { %>
										<button type="button" class="btn btn-default btn-sm" onclick="changeDeleteYn(this)">사용중지</button>
									<% } %>
									<input type="hidden" name="deleteYn" value="<%=theaterVO.getDeleteYn() %>">
									<input type="hidden" name="orgDeleteYn" value="<%=theaterVO.getDeleteYn() %>">
								</td>
								<input type="hidden" name="flag" value="">
							</tr>
						<% } %>
					</tbody>
				</table>
			</div>
			<div class="btn_box_theater">
				<button type="button" class="btn btn-default btn-sm" onclick="addTableRow()">＋</button>
				<button type="button" class="btn btn-default btn-sm" onclick="removeTableRow()">－</button>
			</div>
			<hr>
			<div class="btn_box">
				<button type="button" class="btn btn-danger" onclick="modifyCinemaInfo()">수정</button>
			</div>
			<hr>
		</div>
	</div>
	<%@include file="../../common/footer.jsp" %>
</body>
<!-- 카카오 지도 API -->
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src="//dapi.kakao.com/v2/maps/sdk.js?appkey=1eaf0df0b50eda7d73cdf3154c6049df&libraries=services"></script>
<script type="text/javascript">
	var mapContainer = document.getElementById('cinema_map'), // 지도를 표시할 div
	mapOption = {
	    center: new daum.maps.LatLng(<%=cinemaVO.getMapY() %>, <%=cinemaVO.getMapX() %>), // 지도의 중심좌표
	    level: 5 // 지도의 확대 레벨
	};
	
	//지도를 미리 생성
	var map = new daum.maps.Map(mapContainer, mapOption);
	//주소-좌표 변환 객체를 생성
	var geocoder = new daum.maps.services.Geocoder();
	//마커를 미리 생성
	var marker = new daum.maps.Marker({
	 position: new daum.maps.LatLng(<%=cinemaVO.getMapY() %>, <%=cinemaVO.getMapX() %>),
	 map: map
	});
	
	function getAddress() {
	 new daum.Postcode({
	     oncomplete: function(data) {
	         var addr = data.address; // 최종 주소 변수
	
	         // 주소 정보를 해당 필드에 넣는다.
	         document.getElementById("cinemaZip").value = data.zonecode;
	         document.getElementById("cinemaAddr1").value = addr;
	         // 주소로 상세 정보를 검색
	         geocoder.addressSearch(data.address, function(results, status) {
	             // 정상적으로 검색이 완료됐으면
	             if (status === daum.maps.services.Status.OK) {
	
	                 var result = results[0]; //첫번째 결과의 값을 활용
	
	                 // 해당 주소에 대한 좌표를 받아서
	                 var coords = new daum.maps.LatLng(result.y, result.x);
	                 document.getElementById("mapX").value = result.x;
	                 document.getElementById("mapY").value = result.y;
	                 // 지도를 보여준다.
	                 mapContainer.style.display = "block";
	                 map.relayout();
	                 // 지도 중심을 변경한다.
	                 map.setCenter(coords);
	                 // 마커를 결과값으로 받은 위치로 옮긴다.
	                 marker.setPosition(coords)
	             }
	         });
	     }
	 }).open();
	}
	
	function addTableRow() {
		var str = '<tr>'
					+ '<td>'
						+ '<input type="checkbox" class="chkbox_cinema_theater_seat">'
					+ '</td>'
					+ '<td class="theaterNo">'
						+ '<input type="hidden" name="theaterCd" value="">'
						+ '<input type="number" name="theaterNo" min="1" max="10" value="1" maxlength="2">'
					+ '</td>'
					+ '<td>'
						+ '<select name="screenCd">'
								<% for(int j=0 ; j<codeVOs.size() ; j++) {
										CodeVO codeVO = codeVOs.get(j);
										if(codeVO.getGroupCd().equals("A05")) {
								%>
									+ '<option value="<%=codeVO.getCd() %>"><%=codeVO.getCdName() %></option>'
								<%
										}
									}
								%>
						+ '</select>'
					+ '</td>'
					+ '<td>'
						+ '<input type="number" name="seatRows" min="1" max="11" value="1" maxlength="2">'
					+ '</td>'
					+ '<td>'
						+ '<input type="number" name="seatColumns" min="1" max="13" value="1" maxlength="2">'
					+ '</td>'
					+ '<td>'
						+ '<button type="button" class="btn btn-default btn-sm" onclick="changeDeleteYn(this)">사용중지</button>'
						+ '<input type="hidden" name="deleteYn" value="N">'
					+ '</td>'
					+ '<input type="hidden" name="flag" value="">'
				+ '</tr>';
		
		$("#table_cinema_theater tbody").append(str);
	}
	
	function removeTableRow() {
		var checkedRows = $(".chkbox_cinema_theater_seat:checked");
		
		if(checkedRows.length == 0) {
			alert("삭제할 항목을 선택하세요.");
			
		} else {
			checkedRows.each(function(idx, item) {
				$(item).parent().parent().children("[name='flag']").val("D");
				$(item).parent().parent().hide();
				$(item).prop("checked", false);
			});
		}
	}
	
	function changeDeleteYn(obj) {
		if($(obj).text() == "사용하기") {
			$(obj).addClass("btn-default");
			$(obj).text("사용중지");
			$(obj).next().val("N");
			
		} else {
			$(obj).removeClass("btn-default");
			$(obj).text("사용하기");
			$(obj).next().val("Y");
		}
	}
	
	function modifyCinemaInfo() {
		//빈 값, 유효성 검사
		if(!validate()) {
			return;
		}
		
		//변경된 정보가 있으면 극장 수정
		if(checkModifiedValue()) {
			var ModifyCinemaResult = 0;
			
			$.ajax({
				url: "/TicketingProject/admin/cinemaModify.do"
				, type: "post"
				, data: $("#cinema_info_form").serialize()
				, async : false
				, dataType: "json"
				, success: function(data) {
					console.log(data.result);
					ModifyCinemaResult = data.result;
				}
				, error: function(xhr) {
					console.log(xhr);
				}
			});
			
			if(ModifyCinemaResult == 0) {
				alert("극장 정보 수정에 실패했습니다. 관리자에게 문의하세요.");
				return;
			}
		}
		
		//상영관 정보 수정
		//ajax로 보내기
		$("#table_cinema_theater tbody tr").each(function(idx, item) {
			var theaterCd = $(item).find("input[name=theaterCd]").val();
			var flag = $(item).find("[name=flag]").val();
			
			if(flag == "D") {
				modifyTheaterInfo(item, "D");
				return;
			}
			
			if(theaterCd == "" || theaterCd == null) {
				modifyTheaterInfo(item, "C");
				return;
				
			} else {
				if($(item).find("input[name=theaterNo]").val() != $(item).find("input[name=orgTheaterNo]").val()) {
					modifyTheaterInfo(item, "M");
					return;
				}
				
				if($(item).find("[name=screenCd]").val() != $(item).find("input[name=orgScreenCd]").val()) {
					modifyTheaterInfo(item, "M");
					return;
				}
				
				if($(item).find("input[name=seatRows]").val() != $(item).find("input[name=orgSeatRows]").val()) {
					modifyTheaterInfo(item, "M");
					return;
				}
				
				if($(item).find("input[name=seatColumns]").val() != $(item).find("input[name=orgSeatColumns]").val()) {
					modifyTheaterInfo(item, "M");
					return;
				}
				
				if($(item).find("input[name=deleteYn]").val() != $(item).find("input[name=orgDeleteYn]").val()) {
					modifyTheaterInfo(item, "M");
					return;
				}
			}

			
		});
		
		alert("극장 정보가 수정되었습니다.");
		location.href = "/TicketingProject/jsp/admin/cinema/cinema.jsp";
		
	}
	
	function modifyTheaterInfo(item, flag) {
		var param = {
			cinemaCd : $("#cinemaCd").val()
			, theaterCd : $(item).find("input[name=theaterCd]").val()
			, theaterNo : $(item).find("input[name=theaterNo]").val()
			, screenCd : $(item).find("[name=screenCd] option:selected").val()
			, seatRows : $(item).find("input[name=seatRows]").val()
			, seatCols : $(item).find("input[name=seatColumns]").val()
			, deleteYn : $(item).find("input[name=deleteYn]").val()
			, flag : flag
		};
		
		$.ajax({
			url: "/TicketingProject/admin/theaterModify.do"
			, type: "post"
			, data: param
			, async: false
			, dataType: "json"
			, success: function(data) {
				console.log(data.result);
			}
			, error: function(xhr) {
				console.log(xhr);
				alert("오류가 발생했습니다. 관리자에게 문의하세요.");
			}
		});
	}
	
	function validate() {
		//개관일
		if(!checkValue("cinemaOpenDate", "극장 개관일")) {
			return false;
		}
		
		if(!checkValueRegExp("cinemaOpenDate", /^[0-9]{4}-[0-9]{2}-[0-9]{2}$/, "극장 개관일을 바르게 선택해주세요.")) {
			return false;
		}
		
		//극장 전화번호
		if(!checkValue("cinemaTel", "극장 전화번호")) {
			return false;
		}
		
		if(!checkValueRegExp("cinemaTel", /^[0-9]{8,11}$/, "극장 전화번호를 바르게 작성해주세요.")) {
			return false;
		}
		
		//극장 우편번호
		if(!checkValue("cinemaZip", "극장 우편번호")) {
			return false;
		}
		
		//극장 주소
		if(!checkValue("cinemaAddr1", "극장 주소")) {
			return false;
		}
		
		//극장 상세주소
		if(!checkValue("cinemaAddr2", "극장 상세주소")) {
			return false;
		}
		
		return true;
	}
	
	function checkModifiedValue() {
		//개관일
		if($("#cinemaOpenDate").val() != $("#orgCinemaOpenDate").val()) {
			return 2;
		}
		
		//극장 전화번호
		if($("#cinemaTel").val() != $("#orgCinemaTel").val()) {
			return 3;
		}
		
		//극장 영업상태
		if($("#cinemaStatus").val() != $("#orgCinemaStatus").val()) {
			return true;
		}
		
		//극장 우편번호
		if($("#cinemaZip").val() != $("#orgCinemaZip").val()) {
			return true;
		}
		
		//극장 주소
		if($("#cinemaAddr1").val() != $("#orgCinemaAddr1").val()) {
			return true;
		}
		
		//극장 상세주소
		if($("#cinemaAddr2").val() != $("#orgCinemaAddr2").val()) {
			return true;
		}
		
		return false;
	}
</script>
</html>