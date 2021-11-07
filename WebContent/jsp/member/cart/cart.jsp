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
	<title>박스오피스 | 장바구니</title>
	<style type="text/css">
		#wrap_cart {
			width: 1280px;
			margin: 80px auto;
			display: flex;
			flex-flow: row nowrap;
			justify-content: center;
		}
		#wrap_cart .title {
			font-size: 4rem;
		}
		hr.black {
			border: 1px solid black;
		}
		.cart_table {
			text-align: center;
		}
		.cart_table thead td {
			font-size: 2rem;
		}
		.cart_table tbody td {
			font-size: 1.6rem;
			vertical-align: middle !important;
		}
		.prod {
			display: flex;
			flex-flow: row wrap;
		}
		.prod_img {
			height: 100px;
			width: 70%;
		}
		.prod_img img {
			max-height: 100px;
			width: auto;
		}
		.prod_name {
			width: 30%;
			align-self: center;
		}
		.amt_btn_box button {
			display: inline-block;
		}
		.amt_btn_box div {
			display: inline-block;
			margin: 0 10px 0 10px;
		}
		.cart_btn_box {
			display: flex;
			justify-content: flex-end;
		}
		.cart_btn_box button {
			margin-left: 10px;
		}
		.pay_btn_box p {
			font-size: 2rem;
		}
		.pay_btn_box p span {
			margin-left: 15px;
			margin-right: 20px;
			font-size: 2.5rem;
			color: #ff1212;
		}
		.pay_btn_box {
			display: flex;
			justify-content: flex-end;
			margin-top: 20px;
			margin-bottom: 40px;
		}
		.pay_btn_box button {
			width: 170px;
		}
	</style>
</head>
<body>
	<%@include file="../../common/header.jsp" %>
	<div id="wrap_cart">
		<div class="container">
			<h2 class="title">장바구니</h2>
			<hr>
			<table class="cart_table table">
				<thead>
					<tr>
						<td>선택</td>
						<td>상품</td>
						<td>판매금액</td>
						<td>수량</td>
						<td>구매금액</td>
						<td>삭제</td>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>
							<input type="checkbox">
						</td>
						<td>
							<div class="prod">
								<div class="prod_img">
									<img alt="커피" src="/TicketingProject/images/common/snack/coffee1.png">
								</div>
								<div class="prod_name">
									아메리카노
								</div>
							</div>
						</td>
						<td>3,500원</td>
						<td>
							<div class="amt_btn_box">
								<button type="button" class="btn btn-default btn-xs">－</button>
								<div>
									1
								</div>
								<button type="button" class="btn btn-default btn-xs">＋</button>
							</div>
						</td>
						<td>3,500원</td>
						<td>
							<button type="button" class="btn btn-default btn-xs">×</button>
						</td>
					</tr>
					<tr>
						<td>
							<input type="checkbox">
						</td>
						<td>
							<div class="prod">
								<div class="prod_img">
									<img alt="팝콘" src="/TicketingProject/images/common/snack/popcorn1.png">
								</div>
								<div class="prod_name">
									팝콘
								</div>
							</div>
						</td>
						<td>6,500원</td>
						<td>
							<div class="amt_btn_box">
								<button type="button" class="btn btn-default btn-xs">－</button>
								<div>
									1
								</div>
								<button type="button" class="btn btn-default btn-xs">＋</button>
							</div>
						</td>
						<td>3,500원</td>
						<td>
							<button type="button" class="btn btn-default btn-xs">×</button>
						</td>
					</tr>
				</tbody>
			</table>
			<hr class="black">
			<div class="cart_btn_box">
				<button type="button" class="btn btn-default">전체 선택</button>
				<button type="button" class="btn btn-default">선택 삭제</button>
			</div>
			<div class="pay_btn_box">
				<p>총 결제 금액 <span>9,000원</span></p>
				<button type="button" class="btn btn-danger">구매하기</button>
			</div>
			<hr>
		</div>
	</div>
	<%@include file="../../common/footer.jsp" %>
</body>
</html>