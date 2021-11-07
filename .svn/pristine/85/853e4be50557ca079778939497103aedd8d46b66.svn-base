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
		#wrap_admin_cinema_create_manage .title span {
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
	
	<script type="text/javascript">
		var cinemaStatusCdArr = [];
		var screenCdArr = [];
		
		$(document).ready(function() {
			//ajax로 영업상태 코드, 스크린 유형 코드 가져와서 각 배열에 넣기
			$.ajax({
				url: "/TicketingProject/admin/cinemaCreate.do"
				, type: "get"
//	 			, data: ""
				, dataType: "json"
				, success: function(data) {
					console.log(data);
					saveCodes(data);
					makeSelect();
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
		
		function makeSelect() {
			cinemaStatusCdArr.forEach(item => {
				var str = '<option value="' + item.cd + '">' + item.cdName + '</option>';
				$("#cinemaStatus").append(str);
			});
		}
		
		function addTableRow() {
			var str = '<tr>'
						+ '<td>'
							+ '<input type="checkbox" class="chkbox_cinema_theater_seat">'
						+ '</td>'
						+ '<td class="theaterNo">'
							+ '<input type="number" name="theaterNo" min="1" max="10" value="1" maxlength="2">'
						+ '</td>'
						+ '<td>'
							+ '<select name="screenCd">';
							
			screenCdArr.forEach(item => {
				str += '<option value="' + item.cd + '">' + item.cdName + '</option>';
			});
							
			str += '</select>'
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
				+ '</tr>'
	
			$("#table_cinema_theater tbody").append(str);
		}
		
		function removeTableRow() {
			var checkedRows = $(".chkbox_cinema_theater_seat:checked");
			
			if(checkedRows.length == 0) {
				alert("삭제할 항목을 선택하세요.");
				
			} else {
				checkedRows.each(function(idx, item) {
					$(item).parent().parent().remove();
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
	</script>
</head>
<body>
	<%@include file="../../common/header.jsp" %>
	<div id="wrap_admin_cinema_create_manage">
		<div class="container">
			<h2 class="title">극장 관리<span>극장 등록</span></h2>
			<hr>
			<h2 class="subtitle">극장 정보</h2>
			<hr>
			<form class="form-horizontal" id="cinema_info_form">
				<div class="container cinema_info">
					<div class="form-group">
						<label class="control-label col-sm-2" for="cinemaName">극장 이름</label>
						<div class="col-sm-8">
							<input type="text" class="form-control" name="cinemaName" id="cinemaName" maxlength="13">
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2" for="cinemaOpenDate">극장 개관일</label>
						<div class="col-sm-8">
							<input type="date" class="form-control" name="cinemaOpenDate" id="cinemaOpenDate">
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2" for="cinemaTel">극장 전화번호</label>
						<div class="col-sm-8">
							<input type="tel" class="form-control" name="cinemaTel" id="cinemaTel" maxlength="11" placeholder="붙임표를 제외하고 작성 (예: 021112222)">
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2" for="cinemaStatus">극장 영업상태</label>
						<div class="col-sm-8">
							<select class="form-control" name="cinemaStatus" id="cinemaStatus">
							</select>
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2" for="cinemaZip">극장 우편번호</label>
						<div class="col-sm-8">
							<input type="text" class="form-control" name="cinemaZip" id="cinemaZip" readonly="readonly">
						</div>
						<button type="button" onclick="getAddress()" class="btn btn-default btn-sm col-sm-2">우편번호 검색</button>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2" for="cinemaAddr1">극장 주소</label>
						<div class="col-sm-8">
							<input type="text" class="form-control" name="cinemaAddr1" id="cinemaAddr1" readonly="readonly">
						</div>
					</div>
					<div class="form-group">
						<label class="control-label col-sm-2" for="cinemaAddr2">극장 상세주소</label>
						<div class="col-sm-8">
							<input type="text" class="form-control" name="cinemaAddr2" id="cinemaAddr2"  maxlength="50">
						</div>
					</div>
				</div>
				<hr>
				<h2 class="subtitle">지도</h2>
				<hr>
				<div id="cinema_map" class="cinema_map">
					<input type="hidden" id="mapX" name="mapX" value="">
					<input type="hidden" id="mapY" name="mapY" value="">
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
					</tbody>
				</table>
			</div>
			<div class="btn_box_theater">
				<button type="button" class="btn btn-default btn-sm" onclick="addTableRow()">＋</button>
				<button type="button" class="btn btn-default btn-sm" onclick="removeTableRow()">－</button>
			</div>
			<hr>
			<div class="btn_box">
				<button type="button" class="btn btn-danger" onclick="saveCinemaInfo()">등록</button>
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
           center: new daum.maps.LatLng(37.537187, 127.005476), // 지도의 중심좌표
           level: 5 // 지도의 확대 레벨
       };

	//지도를 미리 생성
	var map = new daum.maps.Map(mapContainer, mapOption);
	//주소-좌표 변환 객체를 생성
	var geocoder = new daum.maps.services.Geocoder();
	//마커를 미리 생성
	var marker = new daum.maps.Marker({
	    position: new daum.maps.LatLng(37.537187, 127.005476),
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
	
	function saveCinemaInfo() {
		if(!validate()) {
			return;
		}
		
		if(!checkTheaterInfo()) {
			return;
		}
		
		var flagNum = 0;
		var count = 0;
		var errorCheck = 0;
		
		//ajax로 보내기
		$("#table_cinema_theater tbody tr").each(function(idx, item) {
			var param = {
					cinemaName : $("#cinemaName").val()
					, cinemaOpenDate : $("#cinemaOpenDate").val()
					, cinemaTel : $("#cinemaTel").val()
					, cinemaStatusCd : $("#cinemaStatus option:selected").val()
					, cinemaZip : $("#cinemaZip").val()
					, cinemaAddr1 : $("#cinemaAddr1").val()
					, cinemaAddr2 : $("#cinemaAddr2").val()
					, mapX : $("#mapX").val()
					, mapY : $("#mapY").val()
					, theaterNo : $(item).find("input[name=theaterNo]").val()
					, screenCd : $(item).find("[name=screenCd] option:selected").val()
					, seatRows : $(item).find("input[name=seatRows]").val()
					, seatCols : $(item).find("input[name=seatColumns]").val()
					, deleteYn : $(item).find("input[name=deleteYn]").val()
					, flag : ++flagNum
			};
			
			$.ajax({
				url: "/TicketingProject/admin/cinemaCreate.do"
				, type: "post"
				, data: param
				, async: false
				, dataType: "json"
				, success: function(data) {
					if(data.result > 0) {
						console.log(data.result);
						count += 1;
					}
				}
				, error: function(xhr) {
					console.log(xhr);
					errorCheck += 1;
				}
			});
			
		});
		
		if(errorCheck > 0) {
			alert("오류가 발생했습니다. 관리자에게 문의하세요.");
		} else {
			alert("극장 정보가 등록되었습니다.");
			location.href = "/TicketingProject/jsp/admin/cinema/cinema.jsp";
		}
	}
	
	function validate() {
		//극장 이름
		if(!checkValue("cinemaName", "극장 이름")) {
			return false;
		}
		
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
	
	function checkTheaterInfo() {
		var theaters = $("#table_cinema_theater tbody tr");
		
		if(theaters.length == 0) {
			alert("상영관을 1개 이상 등록해주세요.");
			return false;
		}
		
		var theaterNos = $("[name=theaterNo]");
		var set = new Set();
		for(var i=0 ; i<theaterNos.length ; i++) {
			var theaterNo = theaterNos.eq(i);
			if(!checkNaN(theaterNo.val(), "상영관 번호")) {
				theaterNo.focus();
				return false;
			}
			
			if(!checkNum(theaterNo.val(), 1, 10, "상영관 번호")) {
				theaterNo.focus();
				return false;
			}
			set.add(theaterNo.val());
		}
		
		if(set.size != theaters.length) {
			alert("상영관 번호가 중복되었습니다.");
			return false;
		}
		
		var seatRows = $("[name=seatRows]");
		for(var i=0 ; i<theaterNos.length ; i++) {
			var seatRow = seatRows.eq(i);
			if(!checkNaN(seatRow.val(), "좌석 행 개수")) {
				seatRow.focus();
				return false;
			}
			
			if(!checkNum(seatRow.val(), 1, 11, "좌석 행 개수")) {
				seatRow.focus();
				return false;
			}
		}
		
		var seatColumns = $("[name=seatColumns]");
		for(var i=0 ; i<seatColumns.length ; i++) {
			var seatColumn = seatColumns.eq(i);
			if(!checkNaN(seatColumn.val(), "좌석 열 개수")) {
				seatColumn.focus();
				return false;
			}
			
			if(!checkNum(seatColumn.val(), 1, 13, "좌석 열 개수")) {
				seatColumn.focus();
				return false;
			}
		}
		
		return true;
	}
	
</script>
</html>