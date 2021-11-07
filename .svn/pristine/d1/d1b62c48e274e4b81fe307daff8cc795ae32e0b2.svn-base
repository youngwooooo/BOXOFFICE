<%@page import="java.text.DecimalFormat"%>
<%@page import="common.vo.MemberProductVO"%>
<%@page import="common.vo.ProductVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	MemberProductVO mpdVO = (MemberProductVO)request.getAttribute("memberProductVO");
	DecimalFormat df = new DecimalFormat("###,###");
	String imgSrc = "/TicketingProject/images/admin/" + mpdVO.getFileStoreName();
	
 	LoginVO loginVO2 = session.getAttribute("loginVO") == null? null : (LoginVO)session.getAttribute("loginVO");
//  	String managerChk2 = "";
	
//  	if(loginVO2 != null) {
// 		managerChk2 = loginVO2.getManagerYn();
// 	}
	
	
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
	<title>박스오피스 | 간식</title>
	<style type="text/css">
		#wrap_product_detail {
			display: flex;
			margin: 80px auto;
			width: 1280px;
			flex-flow: row nowrap;
		}
		#wrap_product_detail .title {
			font-size: 4rem;
		}
		#wrap_product_detail .title span {
			font-size: 2rem;
			margin-left: 20px;
		}
		.product {
			display: flex;
			flex-flow: row wrap;
		}
		.product_img {
			width: calc(40% - 1px);
			border-right: 1px solid #ebebeb;
			height: 400px;
			display: flex;
			align-items: center;
			justify-content: center;
		}
		.product_img img {
			width: auto;
			max-height: 100%;
		}
		.product_info {
			width: 60%;
			padding: 20px;
		}
		hr.black {
			border: 1px solid black;
		}
		hr.lightgray {
			border: 1px solid #ebebeb;
		}
		
		.product_info_table {
			border-collapse: separate;
			border-spacing: 0 10px;
		}
		.product_info_table td:first-child {
			font-size: 2rem;
			width: 150px;
		}
		.product_info_table td:nth-child(2) {
			font-size: 1.6rem;
		}
		.amout_btn_box button {
			display: inline-block;
		}
		.amout_btn_box div {
			display: inline-block;
			margin: 0 10px 0 10px;
		}
		.total_price {
			margin-bottom: 30px;
			display: flex;
			justify-content: center;
		}
		.total_price p {
			font-size: 2.5rem;
		}
		.total_price p span {
			margin-left: 10px;
			color: #c9302c;
		}
		.pay_btn_box {
			display: flex;
			justify-content: center;
		}
		.pay_btn_box button {
			width: 200px;
			height: 40px;
			margin-right: 10px;
		}
		.product_notice_btn_box {
			width: 100%;
			display: flex;
			justify-content: center;
		}
		.product_notice_btn_box button {
			width: 300px;
			margin: 0 20px 0 20px;
		}
		.product_notice_txt {
			margin-top: 30px;
			width: 100%;
			border: 1px solid #ebebeb;
		}
	</style>		
	<script type="text/javascript">
		function addCount(obj){
			var num = $(obj).prev().children("[name=countNum]").val();
			num = parseInt(num) + 1;
			
			$(obj).prev().children("[name=countNum]").val(num);
			$(obj).prev().children("p").text(num);
			var totalPrice = <%=Integer.parseInt(mpdVO.getProdPrice()) %> * num;
			totalPrice = parseInt(totalPrice);
			$(".total_price span").text(totalPrice + "원");
			
			
		}
		
		function downCount(obj){
			var num = $(obj).next().children("[name=countNum]").val();
			num = parseInt(num) - 1;
			if(num < 0){
				num = 0;
			}
			
			
			$(obj).next().children("[name=countNum]").val(num);
			$(obj).next().children("p").text(num);
			var totalPrice = <%=Integer.parseInt(mpdVO.getProdPrice()) %> * num;
			totalPrice = parseInt(totalPrice);
			$(".total_price span").html(totalPrice + "원");
		}
		

	</script>
</head>
<body>
	<%@include file="../../common/header.jsp" %>
	<div id="wrap_product_detail">
		<div class="container">
			<h2 class="title">상품 <span>/ 베스트 콤보</span></h2>
			<hr class="black">
				<div class="product">
					<div class="product_img">
						<img alt="콤보" src=<%=imgSrc %>>
					</div>
					<div class="product_info">
						<table id="product_info_table" class="product_info_table">
							<tr>
								<td>상품명</td>
								<td><%=mpdVO.getProdName() %></td>
							</tr>
							<tr>
								<td>상품 설명</td>
								<td><%=mpdVO.getProdDesc() %></td>
							</tr>
							<tr>
								<td>상품 가격</td>
								<td><%=df.format(Integer.parseInt(mpdVO.getProdPrice())) %></td>
							</tr>
							<tr>
								<td>수량</td>
								<td>
									<div class="amout_btn_box">
										<button type="button" class="btn btn-default btn-sm" onclick="downCount(this)">－</button>
										<div class="product-count">
											<p>0</p>
											<input type="hidden" value="0" name="countNum">
										</div>
										<button type="button" class="btn btn-default btn-sm" onclick="addCount(this)">＋</button>
									</div>
								</td>
							</tr>
						</table>
						<hr class="lightgray">
						<div class="total_price">
							<p>총 구매금액 <span></span></p>
						</div>
						<div class="pay_btn_box">
							<button type="button" class="btn btn-danger" onclick="payment()">바로구매</button>
						</div>
					</div>
				</div>
			<hr class="black">
			<div class="product_notice">
				<div class="product_notice_btn_box">
					<button type="button" class="btn btn-default">구매 후 취소 <span class="glyphicon glyphicon-chevron-down"></span></button>
					<button type="button" class="btn btn-default">상품 이용 안내 <span class="glyphicon glyphicon-chevron-down"></span></button>
				</div>
				<div class="product_notice_txt">
					
				</div>
			</div>
			<hr>
		</div>
	</div>
	
	<%@include file="../../common/footer.jsp" %>
<script type="text/javascript">
	function payment(){
		<% if(loginVO2 == null){
		%>
			alert("로그인이 필요합니다.");
			location.href="/TicketingProject/jsp/member/signIn/signInPage.jsp";
		<%
		}else {
		%>
			if($("[name=countNum]").val() == 0){
				alert("수량을 선택해주세요.");
				return;
			}
		<%
		} 
		%>
		
		var IMP = window.IMP; // 생략가능
		IMP.init('imp18656294');  // 가맹점 식별 코드
		var price = $(".total_price span").text();
		price = price.substring(0, price.length-1);
		console.log(price);
		
		IMP.request_pay({
			pg : 'kakao', // 결제방식
			pay_method : 'card',	// 결제 수단
			merchant_uid : 'merchant_' + new Date().getTime(),
			name : '팝콘',	// order 테이블에 들어갈 주문명 혹은 주문 번호
			amount : price,	// 결제 금액
			buyer_email : '',	// 구매자 email
			buyer_name :  '',	// 구매자 이름
			buyer_tel :  '',	// 구매자 전화번호
			buyer_addr :  '',	// 구매자 주소
			m_redirect_url : '/TicketingProject/jsp/common/main.jsp'	// 결제 완료 후 보낼 컨트롤러의 메소드명
		}
		, function(rsp) {
			console.log(rsp);
			if ( rsp.success ) { // 성공시
				var msg = '결제가 완료되었습니다.';
				msg += '고유ID : ' + rsp.imp_uid;
				msg += '상점 거래ID : ' + rsp.merchant_uid;
				msg += '결제 금액 : ' + rsp.paid_amount;
				msg += '카드 승인번호 : ' + rsp.apply_num;
				
				alert("결제가 완료되었습니다.");
				location.href= "/TicketingProject/jsp/common/main.jsp";
			} else { // 실패시
				var msg = '결제에 실패하였습니다.';
				msg += '에러내용 : ' + rsp.error_msg;
			}
		});
		
	}
				
					
</script>
</body>
</html>