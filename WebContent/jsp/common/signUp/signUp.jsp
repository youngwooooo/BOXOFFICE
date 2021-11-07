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
	<!-- 구글 recaptcha -->
	<script src="https://www.google.com/recaptcha/api.js" async defer></script>
	<!-- 다음 우편번호 -->
	<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	<!-- 탭 명 -->
	<title>박스오피스 | 회원가입</title>
	<style type="text/css">
		#wrap_sign_up {
			display: flex;
			margin: 80px auto 0;
			width: 1280px;
			flex-flow: row nowrap;
			justify-content: center;
		}
		#wrap_sign_up .title {
			text-align: center;
			font-size: 4rem;
			font-weight: bold;
		}
		hr.lightgray {
			border: 1px solid #ebebeb;
		}
		.sign_up_mem_info {
			display: flex;
			flex-flow: row nowrap;
			justify-content: center;
		}
		.sign_up_table {
			border-collapse: separate;
			border-spacing: 0 30px;
		}
		.sign_up_table tr {
			margin: 20px 0;
		}
		.sign_up_table td:first-child {
			text-align: right;
			font-size: 1.7rem;
			font-weight: bold;
			width: 150px;
			padding-right: 30px;
		}
		.sign_up_table td:nth-child(2) {
			width: 400px;
		}
		.sign_up_table td:nth-child(2) > input {
			height: 40px;
		}
		.sign_up_table td:nth-child(3) {
			padding-left: 20px;
		}
		.sign_up_btn_box {
			width: 100%;
			display: flex;
			justify-content: center;
			margin: 40px 0;
		}
		.sign_up_btn_box button {
			width: 200px;
			height: 55px;
		}
	</style>
</head>

<body>
	<%@include file="../../common/header.jsp" %>
	<div id="wrap_sign_up">
		<div class="container">
			<h2 class="title">BOX OFFICE</h2>
			<hr>
			<form id="sign_up_form">
				<div class="sign_up_mem_info">
					<table id="sign_up_table" class="sign_up_table">
						<tr>
							<td>
								<labe for="memId">아이디</labe>
							</td>
							<td>
								<input type="text" id="memId" name="memId" class="form-control" maxlength="15" placeholder="영문 소문자로 시작하여 영문 소문자, 숫자로 이루어진 4-12 글자">
								<input type="hidden" id="memIdDuplChk" value="1">
								<input type="hidden" id="memIdChk" value="N">
							</td>
							<td>
								<button type="button" class="btn btn-default" onclick="duplicateId()">중복 확인</button>
							</td>
						</tr>
						<tr>
							<td>
								<labe for="memPass">비밀번호</labe>
							</td>
							<td>
								<input type="password" id="memPass" name="memPass" class="form-control" maxlength="20" placeholder="영문 대소문자, 숫자, 특수문자가 반드시 포함된 8-20 글자">
							</td>
						</tr>
						<tr>
							<td>
								<labe for="memPassChk">비밀번호 재입력</labe>
							</td>
							<td>
								<input type="password" id="memPassChk" name="memPassChk" class="form-control" maxlength="20">
							</td>
						</tr>
						<tr>
							<td>
								<labe for="memName">이름</labe>
							</td>
							<td>
								<input type="text" id="memName" name="memName" class="form-control" maxlength="5">
							</td>
						</tr>
						<tr>
							<td>
								<labe for="memHp">휴대폰 번호</labe>
							</td>
							<td>
								<input type="tel" id="memHp" name="memHp" class="form-control" maxlength="11" placeholder="'-' 제외하고 입력">
							</td>
							<td>
								<button type="button" class="btn btn-default">본인 인증</button>
							</td>
						</tr>
						<tr>
							<td>
								<labe for="memMail">이메일</labe>
							</td>
							<td>
								<input type="mail" id="memMail" name="memMail" class="form-control" maxlength="40">
							</td>
						</tr>
						<tr>
							<td>
								<labe for="memBirth">생년월일</labe>
							</td>
							<td>
								<input type="date" id="memBirth" name="memBirth" class="form-control">
							</td>
						</tr>
						<tr>
							<td>
								<labe for="memZip">우편번호</labe>
							</td>
							<td>
								<input type="text" id="memZip" name="memZip" class="form-control" readonly>
							</td>
							<td>
								<button type="button" class="btn btn-default" onclick="searchZipCode()">번호 검색</button>
							</td>
						</tr>
						<tr>
							<td>
								<labe for="memAddr1">주소</labe>
							</td>
							<td>
								<input type="text" id="memAddr1" name="memAddr1" class="form-control" readonly>
							</td>
						</tr>
						<tr>
							<td>
								<labe for="memAddr2">상세주소</labe>
							</td>
							<td>
								<input type="text" id="memAddr2" name="memAddr2" class="form-control" maxlength="50">
							</td>
						</tr>
						<tr>
							<td>
								인증
							</td>
							<td>
								<div id="google_recaptha">
									<div class="g-recaptcha" data-sitekey="6Ldf8HkbAAAAANbGwqomhjs7X9t8aDJl2faGEx_X"></div>
								</div>
							</td>
						</tr>
					</table>
				</div>
			</form>
			<hr class="lightgray">
			<div class="sign_up_btn_box">
				<button type="button" class="btn btn-danger btn-lg" onclick="saveMemInfo()">가입하기</button>
			</div>
			<hr>
		</div>
	</div>
	<%@include file="../../common/footer.jsp" %>
</body>

<script>
	//[중복검사] 버튼 - 아이디 중복 검사
	function duplicateId() {
		if(!checkValue("memId", "아이디")) {
			return;
		}
		if(!checkValueLength("memId", "아이디", 4, 12)) {
			return;
		}
		if(!checkValueRegExp("memId", /^[a-z][0-9a-z]{4,12}$/, "아이디는 영문 소문자로 시작해야 하며, 소문자 및 숫자의 조합으로 4~12글자여야 합니다.")) {
			return;
		}
		
		var param = {
				memId: $("#memId").val()
		};
		
		$.ajax({
			url: "/TicketingProject/member/retrieveIdDupl.do"
			, type: "post"
			, data: param
			, dataType: "json"
			, success: function(data) {
				console.log(data);
				if(data.result > 0) {
					alert($("#memId").val() + "은(는) 사용 중입니다.");
					$("#memId").val("");
					$("#memId").focus();
					$("#memIdDuplChk").val("1");
					$("#memIdChk").val("N");
				} else {
					alert($("#memId").val() + "은(는) 사용 가능합니다.");
					$("#memIdDuplChk").val($("#memId").val());
					$("#memIdChk").val("Y");
				}
			}
			, error: function(xhr) {
				console.log(xhr);
				alert("오류입니다. 관리자에게 문의하세요.");
			}
		});
	}
	
	function saveMemInfo() {
		if(!validate()) {
			return;
		}
		
		if(!confirm("가입하시겠습니까?")) {
			alert("취소하셨습니다.");
			return;
		}
		
		$.ajax({
			url : "/TicketingProject/member/signUpEncrypt.do"
			, type : "post"
			, data : $("#sign_up_form").serialize()
			, dataType : "json"
			, success : function(data) {
				console.log(data);
				if(data.result > 0) {
					alert("회원가입을 축하드립니다!");
					location.href = "/TicketingProject/jsp/common/main.jsp";
					
				} else {
					alert("회원가입에 실패했습니다.");
				}
			}
			, error : function(xhr) {
				console.log(xhr);
				alert("오류가 발생했습니다. 관리자에게 문의하세요.");
			}
		});
	}
	
	//입력 값 검사
	function validate() {
		//아이디
		if(!checkValue("memId", "아이디")) {
			return false;
		}
		if(!checkValueLength("memId", "아이디", 4, 12)) {
			return false;
		}
		if(!checkValueRegExp("memId", /^[a-z][0-9a-z]{4,12}$/, "아이디는 영문 소문자로 시작해야 하며, 소문자 및 숫자의 조합으로 4~12글자여야 합니다.")) {
			return false;
		}
		
		//아이디 중복 검사
		if($("#memIdDuplChk").val() != $("#memId").val()) {
			alert("아이디 중복 검사가 필요합니다.");
			return false;
		}
		if($("#memIdChk").val() == "N") {
			alert("입력하신 아이디는 사용 불가능합니다.");
			$("#memId").focus();
			return false;
		}
		
		//비밀번호
		if(!checkValue("memPass", "비밀번호")) {
			return false;
		}
		if(!checkValueLength("memPass", "비밀번호", 8, 12)) {
			return false;
		}
		if(!checkValueRegExp("memPass", /^(?=.*[a-z])(?=.*[A-Z])(?=.*\d)(?=.*[$@$!%*?&])[A-Za-z\d$@$!%*?&]{8,12}/, "비밀번호는 영문 대문자, 영문 소문자, 숫자, 특수문자가 반드시 포함된 8~12 글자로 이루어져야 합니다.")) {
			return false;
		}
		if($("#memPass").val() != $("#memPassChk").val()) {
			alert("비밀번호가 일치하지 않습니다.");
			$("#memPassChk").focus();
			return false;
		}
		
		//이름
		if(!checkValue("memName", "이름")) {
			return false;
		}
		if(!checkValueLength("memName", "이름", 2, 5)) {
			return false;
		}
		if(!checkValueRegExp("memName", /^[가-힣]{2,5}$/, "이름은 한글로 이루어진 2~5글자여야 합니다.")) {
			return false;
		}

		//휴대폰번호
		if(!checkValue("memHp", "휴대폰 번호")) {
			return false;
		}
		if(!checkValueRegExp("memHp", /^[0-9]{10,11}$/, "유효한 핸드폰 번호를 입력해야 합니다. (예 : 01012345678)")) {
			return false;
		}

		//이메일
		if(!checkValue("memMail", "이메일")) {
			return false;
		}
		if(!checkValueRegExp("memMail", /^[0-9a-zA-z]([\-_\.]?[0-9a-zA-z])*@[0-9a-zA-z]([\-_\.]?[0-9a-zA-Z])*\.[a-zA-z]{2,3}$/, "유효한 이메일 주소를 입력해야 합니다.")) {
			return false;
		}
		
		//생년월일
		if(!checkValue("memBirth", "생년월일")) {
			return false;
		}
		if(!checkValueRegExp("memBirth", /^[0-9]{4}-[0-9]{2}-[0-9]{2}$/, "유효한 생년월일을 입력해야 합니다. (예 : 1990-01-01)")) {
			return false;
		}
		
		//우편번호
		if(!checkValue("memZip", "우편번호")) {
			return false;
		}
		
		//주소
		if(!checkValue("memAddr1", "주소")) {
			return false;
		}
		
		//상세주소
		if(!checkValue("memAddr2", "상세주소")) {
			return false;
		}
		
		//캡챠
		if(grecaptcha.getResponse() == "") {
			alert("캡챠 체크 버튼을 클릭해주세요");
			return false;
		}
		
		return true;
	}
	
	//주소 API
    function searchZipCode() {
        new daum.Postcode({
            oncomplete: function(data) {
                // 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.

                // 각 주소의 노출 규칙에 따라 주소를 조합한다.
                // 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
                var addr = ''; // 주소 변수
                var extraAddr = ''; // 참고항목 변수

                //사용자가 선택한 주소 타입에 따라 해당 주소 값을 가져온다.
                if (data.userSelectedType === 'R') { // 사용자가 도로명 주소를 선택했을 경우
                    addr = data.roadAddress;
                } else { // 사용자가 지번 주소를 선택했을 경우(J)
                    addr = data.jibunAddress;
                }

                // 우편번호와 주소 정보를 해당 필드에 넣는다.
                document.getElementById('memZip').value = data.zonecode;
                document.getElementById("memAddr1").value = addr;
                // 커서를 상세주소 필드로 이동한다.
                document.getElementById("memAddr2").focus();
            }
        }).open();
    }
</script>

</html>