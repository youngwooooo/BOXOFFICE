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
	<title>박스오피스 | 아이디·비밀번호 찾기</title>
	<style type="text/css">
		#wrap_inquery_id_pw {
			display: flex;
			margin: 80px auto 0;
			width: 1280px;
			flex-flow: row nowrap;
			justify-content: center;
		}
		hr.lightgray {
			border: 1px solid #ebebeb;
		}
		#wrap_inquery_id_pw .title {
			text-align: center;
			font-size: 4rem;
			font-weight: bold;
		}
		.inquery {
			width: 100%;
			display: flex;
			flex-flow: row nowrap;
			justify-content: center;
			margin-bottom: 40px;
		}
		.inquery_id, .inquery_pw {
			border: 1px solid #ebebeb;
			margin-top: 20px;
			padding: 30px;
			font-size: 1.7rem;
			width: 50%;
		}
		.inquery_id h2:first-child, .inquery_pw h2:first-child {
			padding-left: 10px;
			font-size: 2.6rem;
		}
		.inquery_id label {
			margin-left: 10px;
		}
		.inquery_id_by_hp_div, .inquery_id_by_mail_div, .inquery_pw_by_mail_div {
			width: 100%;
			display: flex;
			flex-flow: row wrap;
			justify-content: center;
			margin: 20px 0;
		}
		.inquery_id_by_mail_div {
			display: none;
		}
		.inquery_id_by_hp_table, .inquery_id_by_mail_table, .inquery_pw_by_mail_table {
			border-collapse: separate;
			border-spacing: 0 5px;
		}
		.inquery_id_by_hp_table td:first-child {
			font-size: 1.5rem;
			width: 120px;
		}
		.inquery_pw_by_mail_table td:first-child {
			font-size: 1.5rem;
			width: 120px;
		}
		.inquery_id_by_mail_table td:first-child {
			font-size: 1.5rem;
			width: 120px;
		}
		.inquery_pw_btn_box, .inquery_id_btn_box {
			width: 100%;
			text-align: center;
		}
		.inquery_pw_btn_box button, .inquery_id_btn_box button {
			margin: 20px 0;
			width: 150px;
		}
	</style>
</head>
<body>
	<%@include file="../../common/header.jsp" %>
	<div id="wrap_inquery_id_pw">
		<div class="container">
			<h2 class="title">BOX OFFICE</h2>
			<hr>
			<div class="inquery">
				<div class="inquery_id">
					<h2>아이디 찾기</h2>
					<hr class="lightgray">
					<div>
						<input type="radio" id="inquery_id_by_hp" name="inquery_id_radio" checked><label for="inquery_id_by_hp">회원정보에 등록한 휴대폰 번호로 찾기</label>
						<div class="inquery_id_by_hp_div">
							<form id="inquery_id_by_hp_form">
								<table class="inquery_id_by_hp_table">
									<tr>
										<td>
											이름
										</td>
										<td>
											<div class="input-group">
												<span class="input-group-addon">
													<i class="glyphicon glyphicon-user"></i>
												</span>
												<input id="memName" type="text" class="form-control" name="memName" placeholder="이름을 입력하세요">
											</div>
										</td>
									</tr>
									<tr>
										<td>
											휴대폰 번호
										</td>
										<td>
											<div class="input-group">
												<span class="input-group-addon">
													<i class="glyphicon glyphicon-earphone"></i>
												</span>
												<input id="memHp" type="tel" class="form-control" name="memHp" placeholder="휴대폰 번호를 입력하세요">
											</div>
										</td>
									</tr>
								</table>
							</form>
							<div class="inquery_id_btn_box">
								<button type="button" class="btn btn-default">아이디 찾기</button>
							</div>
						</div>
					</div>
					<div>
						<input type="radio" id="inquery_id_by_mail" name="inquery_id_radio"><label for="inquery_id_by_mail">회원정보에 등록한 이메일 주소로 찾기</label>
						<div class="inquery_id_by_mail_div">
							<form id="inquery_id_by_mail_form">
								<table class="inquery_id_by_mail_table">
									<tr>
										<td>
											이름
										</td>
										<td>
											<div class="input-group">
												<span class="input-group-addon">
													<i class="glyphicon glyphicon-user"></i>
												</span>
												<input id="memName" type="text" class="form-control" name="memName" placeholder="이름을 입력하세요">
											</div>
										</td>
									</tr>
									<tr>
										<td>
											이메일 주소
										</td>
										<td>
											<div class="input-group">
												<span class="input-group-addon">
													<i class="glyphicon glyphicon-envelope"></i>
												</span>
												<input id="memMail" type="mail" class="form-control" name="memMail" placeholder="이메일 주소를 입력하세요">
											</div>
										</td>
									</tr>
								</table>
							</form>
							<div class="inquery_id_btn_box">
								<button type="button" class="btn btn-default">아이디 찾기</button>
							</div>
						</div>
					</div>
				</div>
				<div class="inquery_pw">
					<h2>비밀번호 찾기</h2>
					<hr class="lightgray">
					<div class="inquery_pw_by_mail_div">
						<form id="inquery_pw_by_mail_form">
							<table class="inquery_pw_by_mail_table">
								<tr>
									<td>
										아이디
									</td>
									<td>
										<div class="input-group">
											<span class="input-group-addon">
												<i class="glyphicon glyphicon-ok"></i>
											</span>
											<input id="memId" type="text" class="form-control" name="memId" placeholder="아이디를 입력하세요">
										</div>
									</td>
								</tr>
								<tr>
									<td>
										이름
									</td>
									<td>
										<div class="input-group">
											<span class="input-group-addon">
												<i class="glyphicon glyphicon-user"></i>
											</span>
											<input id="memName" type="text" class="form-control" name="memName" placeholder="이름을 입력하세요">
										</div>
									</td>
								</tr>
								<tr>
									<td>
										이메일 주소
									</td>
									<td>
										<div class="input-group">
											<span class="input-group-addon">
												<i class="glyphicon glyphicon-envelope"></i>
											</span>
											<input id="memMail" type="mail" class="form-control" name="memMail" placeholder="이메일 주소를 입력하세요">
										</div>
									</td>
								</tr>
							</table>
						</form>
						<div class="inquery_pw_btn_box">
							<button type="button" class="btn btn-default" onclick="findPassword()">비밀번호 찾기</button>
						</div>
					</div>
				</div>
			</div>
			<hr>
		</div>
	</div>
	<%@include file="../../common/footer.jsp" %>
</body>

<script type="text/javascript">
	function findPassword() {
		
		var retrieveResult = 0;
		
		$.ajax({
			url: "/TicketingProject/member/retrieveMemForPwChg.do"
			, type: "post"
			, data: $("#inquery_pw_by_mail_form").serialize()
			, dataType: "json"
			, async: false
			, success: function(data) {
				console.log(data);
				retrieveResult = data.result;
			}
			, error: function(xhr) {
				console.log(xhr);
			}
		});
		
		if(retrieveResult == 0) {
			alert("가입하지 않은 아이디거나, 잘못된 비밀번호입니다.");
			return;
		}
		
		$.ajax({
			url: "/TicketingProject/member/modifyPw.do"
			, type: "post"
			, data: $("#inquery_pw_by_mail_form").serialize()
			, dataType: "json"
			, success: function(data) {
				console.log(data);
				if(data.result > 0) {
					alert("임시 비밀번호가 입력한 이메일 주소로 발송되었습니다.");
					location.href = "/TicketingProject/jsp/common/main.jsp";
				} else {
					alert("오류가 발생했습니다. 관리자에게 문의하세요.");
				}
			}
			, error: function(xhr) {
				console.log(xhr);
			}
		});
		
	}
</script>

</html>