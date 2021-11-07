<!-- 회원가입 페이지 -->
<!-- 작성장: 정범 -->
<%@page import="common.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head> 
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
	<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	<script src="<%=request.getContextPath() %>/js/lib/jquery-3.6.0.js"></script>
	<script type="text/javascript">		
		// 아이디 중복체크	
		function idCheck(){
			
			var param = {
				userId : $("#userId").val()				
			};
			
			$.ajax({
				url: "/TicketingProject/common/memberResult.do"
				,type: "post"
				,data: param
				,dataType: "json"
				,success: function(data){
					console.log(data);
					var flag = true;					
				
					if(data.resultCnt == 0){
						$("#wnMsgId").text("사용 가능한 ID입니다.").css("color", "green");
						$("#wnMsgId").addClass("text-success");						
						
					}else {
						alert("이미 사용중인 ID입니다.");
						$("#wnMsgId").text("이미 사용중인 ID입니다.").css("color", "red");
						$("#userId").focus();
						$("#wnMsgId").addClass("text-warning");		
						
					}						
					
					
				}
				,error: function(xhr){
					console.log(xhr);
					alert("오류입니다. 관리자에게 문의하세요.");
				}
			});			
		}	
		
		// 주소 가져오기 
		function getZipCode(){
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

	                // 사용자가 선택한 주소가 도로명 타입일때 참고항목을 조합한다.
	                if(data.userSelectedType === 'R'){
	                    // 법정동명이 있을 경우 추가한다. (법정리는 제외)
	                    // 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
	                    if(data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
	                        extraAddr += data.bname;
	                    }
	                    // 건물명이 있고, 공동주택일 경우 추가한다.
	                    if(data.buildingName !== '' && data.apartment === 'Y'){
	                        extraAddr += (extraAddr !== '' ? ', ' + data.buildingName : data.buildingName);
	                    }
	                    // 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
	                    if(extraAddr !== ''){
	                        extraAddr = ' (' + extraAddr + ')';
	                    }
	                    // 조합된 참고항목을 해당 필드에 넣는다.
// 	                    document.getElementById("sample6_extraAddress").value = extraAddr;
	                
	                } 
// 	                else {
// 	                    document.getElementById("sample6_extraAddress").value = '';
// 	                }

	                // 우편번호와 주소 정보를 해당 필드에 넣는다.
	                document.getElementById('sample6_postcode').value = data.zonecode;
	                document.getElementById("sample6_address").value = addr;
	                // 커서를 상세주소 필드로 이동한다.
	                document.getElementById("sample6_detailAddress").focus();
	            }
	        }).open();
		}
		
		function JoinForm_sumbit(){
			
			var regId = /^[A-za-z0-9]{5,15}$/g; // 아이디 형식 : [영문 대문자 또는 소문자 또는 숫자로 시작하는 아이디, 길이는 5~15자, 끝날때 영문 대문자 또는 소문자 또는 숫자/ ex)appleMango1234]
			var regPwd = /^(?=.*[a-zA-Z])((?=.*\d)|(?=.*\W)).{8,20}$/; // 패스워드 형식 : [8~20 영문 대소문자, 최소 1개의 숫자 혹은 특수 문자를 포함 / ex) abcdefg1234!]
			var regEmail = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
			var regName = /^[가-힣]{2,4}$/; // 이름 형식 : [한글 이름 2~4자 이내 / ex) 이정범]
			var regPh = /^\d{3}-\d{4}-\d{4}$/;
			var regBirth = /^(19[0-9][0-9]|20\d{2})-(0[0-9]|1[0-2])-(0[1-9]|[1-2][0-9]|3[0-1])$/;
			
			var userId = $("#userId").val();			
			userId = userId.trim();
			
			if( userId.length == 0 ){
				alert("[경고] : 아이디를 입력해주세요.");
				$("#userId").focus();
				return false;
			}
			
			if( !userId.match(regId) ){
				alert("[경고] : 아이디가 형식과 일치하지 않습니다.");
				$("#userId").focus();	
				return false;
			}
			
			var pwd = $("#pwd").val();			
			pwd = pwd.trim();			
			
			if( pwd.length == 0 ){
				alert("[경고] : 패스워드를 입력해주세요.");
				$("#pwd").focus();
				return false;
			}
			
			if( !pwd.match(regPwd) ){
				alet("[경고] : 패스워드가 형식과 일치하지 않습니다.");
				$("#pwd").focus();
				return false;
			}
			
			var rePwd = $("#rePwd").val();			
			rePwd = rePwd.trim();
			
			if( rePwd.length == 0 ){
				alert("[경고] : 패스워드 재입력을 입력해주세요.");
				$("#rePwd").focus();
				return false;
			}
			
			if( $("#pwd").val() != $("#rePwd").val() ){
				alert("[경고] : 패스워드가 일치하지 않습니다.");
				$("#rePwd").focus();
				return false;
			}
			
			var userEmail = $("#userEmail").val();			
			userEmail = userEmail.trim();
			
			if( userEmail.length == 0 ){
				alert("[경고] : 이메일을 입력해주세요.");
				$("#userEmail").focus();
				return false;
			}
			
			if( !userEmail.match(regEmail) ){
				alert("[경고] : 이메일 형식이 일치하지 않습니다.");
				$("#userEmail").focus();
				return false;
			}
			
			var userName = $("#userName").val();			
			userName = userName.trim();
			
			if( userName.length == 0 ){
				alert("[경고] : 이름을 입력해주세요.");
				$("#userName").focus();
				return false;
			}
			
			if( !userName.match(regName) ){
				alert("[경고] : 이름이 형식과 일치하지 않습니다.");
				$("#userName").focus();
				return false;
			}
			
			var phoneNumber = $("#phoneNumber").val();			
			phoneNumber = phoneNumber.trim();
			
			if( phoneNumber.length == 0 ){
				alert("[경고] : 휴대폰번호를 입력해주세요.");
				$("#phoneNumber").focus();
				return false;
			}
			
			if( !phoneNumber.match(regPh) ){
				alert("[경고] : 휴대폰번호가 형식과 일치하지 않습니다.");
				$("#phoneNumber").focus();
				return false;
			}
			
			var birth = $("#birth").val();			
			birth = birth.trim();
			
			if( birth.length == 0 ){
				alert("[경고] : 생년월일을 입력해주세요.");
				$("#birth").focus();
				return false;
			}
			
			if( !birth.match(regBirth) ){
				alert("[경고] : 생일이 형식과 일치하지 않습니다.");
				$("#birth").focus();
				return false;
			}
			
			var zip = $("#sample6_postcode").val();			
			zip = zip.trim();
			
			if( zip.length == 0 ){
				alert("[경고] : 우편번호를 입력해주세요.");
				$("#sample6_postcode").focus();
				return false;
			}
			
			var addr = $("#sample6_address").val();			
			addr = addr.trim();
			
			if( addr.length == 0 ){
				alert("[경고] : 주소를 입력해주세요.");
				$("#sample6_address").focus();
				return false;
			}
			
			var addrDe = $("#sample6_detailAddress").val();			
			addrDe = addrDe.trim();
			
			if( addrDe.length == 0 ){
				alert("[경고] : 상세주소를 입력해주세요.");
				$("#sample6_detailAddress").focus();
				return false;
			}
			
			
			$.ajax({
				url: "/TicketingProject/common/signUpPage.do"
				,type: "post"
				,data: $("#fm").serialize()
// 				,dataType: "json"
				,success: function(){
					alert("회원가입을 축하드립니다!");
					window.location.href = "<%=request.getContextPath()%>/jsp/common/main.jsp";
// 					http://localhost:8000/TicketingProject/jsp/common/main.jsp
				}
				,error: function(xhr){
					alert("오류발생. 관리자에게 문의하세요");
					console.log(xhr);
				}
				
			});
			
		}		
		
	
	</script>
<title>회원가입</title>
</head>
<body>
<%@include file="../../common/header.jsp" %>
	<br><br><br><br>
	<div class="container" style="margin-bottom: 10px;">
		<h2>회원가입</h2>
<!-- 		<form class="form-horizontal" id="fm" action="/common/signUpPage.do" method="POST" onsubmit="JoinForm_sumbit(this); return false;"> -->

<!-- 		<form class="form-horizontal" id="fm" action="/common/signUpPage.do" method="POST" onsubmit="return false;"> -->
<!-- 		<form class="form-horizontal" id="fm" action="/common/signUpPage.do" method="POST" onsubmit="return true;"> -->

		<form class="form-horizontal" id="fm">
		
			<div style="border:gray solid 2px;">
				<div style="margin:20px;">				
				
					<div class="form-group">
						<label class="control-label col-sm-2" for="userId">아이디:</label>
						<div class="col-sm-10">
							<input type="text" class="form-control" id="userId" placeholder="길이 5~15자의 영문 대문자 또는 소문자 또는 숫자로 시작" name="memId">					
							<button class="btn" type="button" onclick="idCheck()">중복확인</button>												
							<span id="wnMsgId"></span>
						</div>					
					</div>
					
					<div class="form-group">
						<label class="control-label col-sm-2" for="pwd">패스워드:</label>
						<div class="col-sm-10">
						<input type="password" class="form-control" id="pwd" placeholder="8~20 영문 대소문자, 최소 1개의 숫자 혹은 특수 문자를 포함" name="memPass">
						</div>						
						<span id="wnMsgPwd"></span>
					</div>
					
					<div class="form-group">
						<label class="control-label col-sm-2" for="rePwd">패스워드 재입력:</label>
						<div class="col-sm-10">
						<input type="password" class="form-control" id="rePwd" placeholder="패스워드 재입력" name="rePwd">
						</div>			
						<span id="wnMsgRePwd"></span>		
					</div>
					
					<div class="form-group">
						<label class="control-label col-sm-2" for="userEmail">이메일:</label>
						<div class="col-sm-10">
						<input type="email" class="form-control" id="userEmail" placeholder="abc123@email.com" name="memMail">
						</div>
					</div>
					
					<div class="form-group">
						<label class="control-label col-sm-2" for="userName">이름:</label>
						<div class="col-sm-10">
						<input type="text" class="form-control" id="userName" placeholder="ex) 홍길동" name="memName">
						</div>
					</div>
					
					<div class="form-group">
						<label class="control-label col-sm-2" for="phoneNumber">휴대폰 번호:</label>
						<div class="col-sm-10">
						<input type="text" class="form-control" id="phoneNumber" placeholder="ex) 010-1234-5678" name="memHp">
						</div>
					</div>
					
					<div class="form-group">
						<label class="control-label col-sm-2" for="birth">생년월일:</label>
						<div class="col-sm-10">
						<input type="date" class="form-control" id="birth" placeholder="2021-06-22" name="memBir">
						</div>
					</div>
					
					<div class="form-group">
						<label class="control-label col-sm-2" for="sample6_postcode">우편번호:</label>
						<div class="col-sm-10">
						<input type="text" class="form-control" id="sample6_postcode" readonly placeholder="00000" name="memZip">
						<button class="btn" type="button" onclick="getZipCode()">우편번호 찾기</button>
						</div>
					</div>					
					
					<div class="form-group">
						<label class="control-label col-sm-2" for="sample6_address">주소:</label>
						<div class="col-sm-10">
						<input type="text" class="form-control" id="sample6_address" readonly placeholder="ex) 대전광역시 중구" name="memAddr1">
						</div>
					</div>
					
					<div class="form-group">
						<label class="control-label col-sm-2" for="sample6_detailAddress">상세주소:</label>
						<div class="col-sm-10">
						<input type="text" class="form-control" id="sample6_detailAddress" placeholder="ex) 스마일 아파트" name="memAddr2">
						</div>
					</div>
								
					<div class="form-group">        
						<div class="col-sm-offset-2 col-sm-10">
						<button type="button" class="btn btn-primary" onclick="JoinForm_sumbit(this.form.memId.value)">저장</button>
						<button type="button" class="btn btn-danger"><a href="<%=request.getContextPath() %>/jsp/common/main.jsp">돌아가기</a></button>
						</div>
					</div>
								
				</div>				
			</div>
			<input type="hidden" name="flag" value="C">
		</form>
	</div>
	<%@include file="../../common/footer.jsp" %>
</body>
</html>