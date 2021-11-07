<!-- 로그인 페이지 -->
<!-- 작성장: 정범 -->
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
	<title>박스오피스 | 로그인</title>
	<style type="text/css">
		#wrap_sign_in {
			display: flex;
			margin: 80px auto;
			width: 1280px;
			flex-flow: row nowrap;
			justify-content: center;
		}
		hr.lightgray {
			border: 1px solid #ebebeb;
		}
		#wrap_sign_in .title {
			text-align: center;
			font-size: 4rem;
			font-weight: bold;
		}
		.mem_info_div {
			width: 100%;
			display: flex;
			flex-flow: row nowrap;
			justify-content: center;
		}
		.mem_info_table {
			border-collapse: separate;
			border-spacing: 0 5px;
		}
		.mem_info_table td:first-child {
			font-size: 1.5rem;
			width: 120px;
		}
		.sign_in_btn_box {
			width: 100%;
			display: flex;
			justify-content: center;
			margin-top: 20px;
		}
		.sign_in_btn_box button {
			width: 200px;
			height: 40px;
		}
		.search {
			width: 100%;
			margin-top: 20px;
			display: flex;
			justify-content: center;
		}
		.search > span {
			text-align: center;
			margin: 5px;
		}
		.search > span:hover {
			text-decoration: underline;
			cursor: pointer;
		}
		.sign_up {
			border: 1px solid #ebebeb;
			text-align: center;
			margin-top: 20px;
			padding: 15px;
			font-size: 1.5rem;
		}
		.sign_up button {
			margin-left: 50px;
		}
	</style>
	<script type="text/javascript">
		function login() {
			if(!checkEmpty()) {
				return;
			}
			
			console.log(1);
			
			$.ajax({
				url: "/TicketingProject/member/signIn.do"
				, type: "post"
				, data: $("#mem_info").serialize()
				, dataType: "json"
				, success: function(data) {
					console.log(data);
					if(data.result > 0) {
						location.href = "/TicketingProject/jsp/common/main.jsp";
					} else {
						alert("가입하지 않은 아이디거나, 잘못된 비밀번호입니다.")
					}
				}
				, error: function(xhr) {
					console.log(xhr);
				}
			});
		}
		
		function checkEmpty() {
			if(!checkValue("memId", "아이디")) {
				return false;
			}
			
			if(!checkValue("memPass", "비밀번호")) {
				return false;
			}
			
			return true;
		}
		
		function signUp() {
			location.href = "/TicketingProject/jsp/common/signUp/signUp.jsp";
		}
		
		function inqueryIdPw() {
			location.href = "/TicketingProject/jsp/member/inquiryIdPw/inqueryIdAndPw.jsp";
		}
	</script>
</head>
<body>
	<%@include file="../../common/header.jsp" %>
	<div id="wrap_sign_in">
		<div class="container">
			<h2 class="title">BOX OFFICE</h2>
			<hr>
			<div class="mem_info_div">
				<form id="mem_info">
					<table class="mem_info_table">
						<tr>
							<td>
								아이디
							</td>
							<td>
								<div class="input-group">
									<span class="input-group-addon">
										<i class="glyphicon glyphicon-user"></i>
									</span>
									<input id="memId" type="text" class="form-control" name="memId" placeholder="아이디를 입력하세요">
								</div>
							</td>
						</tr>
						<tr>
							<td>
								비밀번호
							</td>
							<td>
								<div class="input-group">
									<span class="input-group-addon">
										<i class="glyphicon glyphicon-lock"></i>
									</span>
									<input id="memPass" type="password" class="form-control" name="memPass" placeholder="비밀번호를 입력하세요">
								</div>
							</td>
						</tr>
					</table>
				</form>
			</div>
			<div class="sign_in_btn_box">
				<button type="button" class="btn btn-danger" onclick="login()">로그인</button>
			</div>
			<div class="search">
				<span onclick="inqueryIdPw()">아이디 · 비밀번호 찾기 <span class="glyphicon glyphicon-chevron-right"></span></span>
			</div>
			<div class="sign_up">
				박스 오피스의 회원이 아니라면 회원가입 하시고 다양한 혜택을 누리세요! 
				<button type="button" class="btn btn-default btn-sm" onclick="signUp()">회원가입</button>
			</div>
			<hr>
		</div>
	</div>
	<%@include file="../../common/footer.jsp" %>
</body>
</html>