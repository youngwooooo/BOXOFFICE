<%@page import="java.util.Date"%>
<%@page import="common.vo.TicketingShowVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
	request.setCharacterEncoding("UTF-8");

	TicketingShowVO ticketingShowVO = (TicketingShowVO)request.getAttribute("ticketingShowVO");
	
	String payCount = (String)request.getAttribute("payCount");
	String paySeat = (String)request.getAttribute("paySeat");
	String paySeatNo = (String)request.getAttribute("paySeatNo");
	String payPrice = (String)request.getAttribute("payPrice");
	String payPriceStr = (String)request.getAttribute("payPriceStr");
	String payShowCd = (String)request.getAttribute("payShowCd");
	String payAudienceCdStr = (String)request.getAttribute("payAudienceCdStr");
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
	<script type="text/javascript" src="https://cdn.iamport.kr/js/iamport.payment-1.1.5.js"></script>
	<!-- 탭 명 -->
	<title>박스오피스 | 예매</title>
	<style type="text/css">
		#wrap_ticketing_payment {
			width: 1280px;
			margin: 80px auto;
			display: flex;
			flex-flow: row wrap;
			justify-content: center;
		}
		#wrap_ticketing_payment .title {
			font-size: 4rem;
		}
		#wrap_ticketing_payment .title span {
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
			height: 20px
		}
		.selected_show_table td:first-child {
			width: 70px;
			height: 20px
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
			margin: 0 10px 0 10px;
		}
		
		.payment {
			width: 100%;
		}
		.payment_table {
			margin: 10px 0;
			width: 100%;
		}
		.payment_table td {
			text-align: center;
			width: 50px !important;
		}
		.styleHr {
			border: 2px solid #e6e6e6;
		}
		#payment {
			margin-top: 40px;
			float: left;
		}
		#payment input {
			margin-right: 6px;
		}
		#payment label {
			margin-right: 40px;
			font-size: 1.7rem;
		}
		#card {
			display: inline-block;
 			margin-left: 25px;
 			margin-right: 5px;
			font-size: 1.5rem;
		}
		#divPay {
			margin-top: 40px;
			margin-left: 40px;
			width: 170px;
		}
		#divPay table {
			margin-bottom: 20px;
			width: 100%;
			text-align: center;
			font-size: 1.5rem;
		}
		#divPay th, td {
			height: 40px;
			padding: 0 10px;
			font-weight: normal;
		}
		#divPay th {
			background-color: black;
			color: white;
		}
		#divPay td {
			background-color: #e6e6e6;
		}
		.tdLast {
			text-align: right;
			padding: 0 10px;
		}
		#min {
			font-size: 1.3rem;
		}
		#selCard {
			margin-right: 50px;
			height: 30px;
		}
		#totalPay th {
			background: #ff1212;
			color: white;
		}
		#totalPay td {
			background: black;
			color: white;
		}
		
	</style>
</head>
<body>
	<%@include file="../../common/header.jsp" %>
	<div id="wrap_ticketing_payment">
		<h2 class="title">예매<span> / 결제</span></h2>
		<hr>
		<p class="subtitle">결제 수단</p>
		<div id="payment">
			<input type="radio" name="payment" id="paymentCard" value="pmCd" checked="checked"><label for="paymentCard">  신용카드</label>
			<input type="radio" name="payment" id="paymentPhone" value="pmPh"><label for="paymentPhone">  휴대폰 결제</label>
			<input type="radio" name="payment" id="paymentAccount" value="pmAc"><label for="paymentAccount">  계좌이체</label>
			<input type="radio" name="payment" id="paymentSimple" value="pmSp"><label for="paymentSimple">  간편결제</label>
			<input type="radio" name="payment" id="paymentMyAccount" value="pmMa"><label for="paymentMyAccount">  내통장결제</label>
			<input type="radio" name="payment" id="paymentToss" value="pmTs"><label for="paymentToss">  토스</label>
			<hr class="styleHr">
			<span id="card">카드종류</span>
			<select id="selCard">
				<option selected="selected">카드를 선택하세요</option>
				<option>BC카드</option>
				<option>현대카드</option>
				<option>삼성카드</option>
				<option>신한카드</option>
				<option>KB국민카드</option>
				<option>카카오뱅크카드</option>
				<option>NH카드</option>
				<option>K뱅크</option>
			</select>
			<span>- 신용카드 결제 가능 최소 금액은 1,000원 이상입니다.</span>
		</div>
		<div id="divPay">
			<table id="tickPay">
				<tr><th>결제하실 금액</th></tr>
				<tr><td class="tdLast" id="tickPrice"><strong><%=payPrice %></strong>원</td></tr>
			</table>
			<table id="totalPay">
				<tr><th colspan="2">남은 결제금액</th></tr>
				<tr><td colspan="2" class="tdLast" id="totalPrice"><strong><%=payPrice %></strong>원</td></tr>
			</table>
		</div>
		<hr class="styleHr">
		
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
						<td id="select_count"><%=payCount %></td>
					</tr>
					<tr>
						<td>좌석</td>
						<td id="select_seat"><%=paySeat %></td>
					</tr>
				</table>
			</div>
			<div class="btn_box">
				<button id="pay_btn" type="button" class="btn btn-danger btn-lg" onclick="payment()">결제하기 <span class="glyphicon glyphicon-chevron-right"></span></button>
			</div>
		</div>
		<hr>
		<form id="pay_form">
			<input type="hidden" id="payDate" name="payDate" value="<%=ticketingShowVO.getShowDate() %>">
			<input type="hidden" id="payMovieCd" name="payMovieCd" value="<%=ticketingShowVO.getMvCd() %>">
			<input type="hidden" id="payMovieName" name="payMovieName" value="<%=ticketingShowVO.getMvNameKor() %>">
			<input type="hidden" id="payMovieFileStoreName" name="payMovieFileStoreName" value="<%=ticketingShowVO.getFileStoreName() %>">
			<input type="hidden" id="payCinemaCd" name="payCinemaCd" value="<%=ticketingShowVO.getCinemaCd() %>">
			<input type="hidden" id="payCinemaName" name="payCinemaName" value="<%=ticketingShowVO.getCinemaName() %>">
			<input type="hidden" id="payTime" name="payTime" value="<%=ticketingShowVO.getShowStartTime() %>">
			<input type="hidden" id="payTheaterCd" name="payTheaterCd" value="<%=ticketingShowVO.getTheaterCd() %>">
			<input type="hidden" id="payTheaterNo" name="payTheaterNo" value="<%=ticketingShowVO.getTheaterNo() %>">
			<input type="hidden" id="payScreenCd" name="payScreenCd" value="<%=ticketingShowVO.getScreenCd() %>">
			<input type="hidden" id="payScreenName" name="payScreenName" value="<%=ticketingShowVO.getScreenName() %>">
			<input type="hidden" id="payCount" name="payCount" value="<%=payCount %>">
			<input type="hidden" id="paySeat" name="paySeat" value="<%=paySeat %>">
			<input type="hidden" id="paySeatNo" name="paySeatNo" value="<%=paySeatNo %>">
			<input type="hidden" id="payPrice" name="payPrice" value="<%=payPrice %>">
			<input type="hidden" id="payPriceStr" name="payPriceStr" value="<%=payPriceStr %>">
			<input type="hidden" id="payAudienceCdStr" name="payAudienceCdStr" value="<%=payAudienceCdStr %>">
			<input type="hidden" id="payShowCd" name="payShowCd" value="<%=payShowCd %>">
			<input type="hidden" id="memCd" name="memCd" value="<%=loginVO.getMemCd() %>">
		</form>
	</div>
	<%@include file="../../common/footer.jsp" %>
</body>
<script type="text/javascript">
	function payment(){
		if($("[name=countNum]").val() == 0){
			alert("수량을 선택해주세요.");
			return;
		}
		
		<%long payDate = new Date().getTime();%>
		
		//이니시스
		IMP.init('imp49208175');
		IMP.request_pay({
		    pg : 'html5_inicis',
		    pay_method : 'card',
		    merchant_uid : 'merchant_' + <%=payDate%>,
		    name : '<%=ticketingShowVO.getMvNameKor() %>',	// order 테이블에 들어갈 주문명 혹은 주문 번호
		    amount : 1,	// 결제 금액
		    buyer_email : '<%=loginVO.getMemMail() %>',
		    buyer_name : '<%=loginVO.getMemName() %>',
		    buyer_tel : '<%=loginVO.getMemHp() %>',
		    buyer_addr : '서울 강남구 도곡동',
		    buyer_postcode : '<%=loginVO.getMemZip() %>'
		}, function(rsp) {
			console.log(rsp);
		    if ( rsp.success ) {
		    	var msg = '결제가 완료되었습니다.';
		        msg += '고유ID : ' + rsp.imp_uid;
		        msg += '상점 거래ID : ' + rsp.merchant_uid;
		        msg += '결제 금액 : ' + rsp.paid_amount;
		        msg += '카드 승인번호 : ' + rsp.apply_num;
		        alert(msg);
		        
		        var param = {
		        		memCd : $("#memCd").val()
						, showCd : $("#payShowCd").val()
						, totalPrice : $("#payPrice").val()
						, totalPriceStr : $("#payPriceStr").val()						
						, seatCd : $("#paySeat").val()
						, seatNo : $("#paySeatNo").val()
						, audienceTypeCd : $("#payAudienceCdStr").val()
						, theaterCd : $("#payTheaterCd").val()
				};
				
			    // ajax
			    $.ajax({
					url: "/TicketingProject/member/ticketingCreate.do"
					, type: "post"
					, data: param
					, async: false
					, dataType: "json"
					, success: function(data) {
						console.log(data);
					}
					, error: function(xhr) {
						console.log(xhr);
						alert("오류가 발생했습니다. 관리자에게 문의하세요.");
					}
				});
		        
		        location.href = "http://localhost/TicketingProject/jsp/common/main.jsp";

		    } else {
		    	var msg = '결제에 실패하였습니다.';
		        msg += '에러내용 : ' + rsp.error_msg;
			    alert(msg);
		    }
		});
		
		//카카오페이
// 		var IMP = window.IMP; // 생략가능
// 		IMP.init('imp18656294');  // 가맹점 식별 코드
		
<%-- 		<%long payDate = new Date().getTime();%> --%>
		
// 		IMP.request_pay({
// 			pg : 'kakao', // 결제방식
// 			pay_method : 'card',	// 결제 수단
<%-- 			merchant_uid : 'merchant_' + <%=payDate%>, --%>
<%-- 			name : '<%=ticketingShowVO.getMvNameKor() %>',	// order 테이블에 들어갈 주문명 혹은 주문 번호 --%>
<%-- 			amount : '<%=Integer.parseInt(payPrice) %>',	// 결제 금액 --%>
// 			buyer_email : '',	// 구매자 email
// 			buyer_name :  '',	// 구매자 이름
// 			buyer_tel :  '',	// 구매자 전화번호
// 			buyer_addr :  '',	// 구매자 주소
// 			buyer_postcode :  '',	// 구매자 우편번호
// 			m_redirect_url : ''	// 결제 완료 후 보낼 컨트롤러의 메소드명
// 		}
// 		, function(rsp) {
// 			console.log("--- rsp ---");
// 			console.log(rsp);
// 			if ( rsp.success ) { // 성공시
// 				var msg = '결제가 완료되었습니다.';
// 				msg += '고유ID : ' + rsp.imp_uid;
// 				msg += '상점 거래ID : ' + rsp.merchant_uid;
// 				msg += '결제 금액 : ' + rsp.paid_amount;
// 				msg += '카드 승인번호 : ' + rsp.apply_num;
				
// 				// ajax 여기 쓰기
// 				console.log("--- msg ---");
// 				console.log(msg);
				
// 				alert("결제에 성공했습니다.");
				
// 	// 			location.href = "http://localhost/TicketingProject/jsp/common/main.jsp";
// 			} else { // 실패시
// 				var msg = '결제에 실패하였습니다.';
// 				msg += '에러내용 : ' + rsp.error_msg;
// 			}
// 		});
	
	}
</script>
</html>