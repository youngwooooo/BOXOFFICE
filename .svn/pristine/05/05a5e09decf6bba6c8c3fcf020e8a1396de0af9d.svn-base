<!-- 회원정보를 조회하기 전 비밀번호를 입력하는 페이지 -->
<%@page import="common.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta content="text/html; charset=UTF-8">
 	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>회원 정보 조회를 위한 패스워드 입력 페이지</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
	
	<script type="text/javascript">
		// 패스워드 확인 버튼
		// 확인 버튼 클릭시 패스워드 확인 후 memberInfo.jsp 페이지 접근		
		function confirmBtn(){
			<%MemberVO mv = (MemberVO) session.getAttribute("memberVO"); %>
			
			var param = {
				userPass : $("#userPwd").val()
			}
			
			$.ajax({
				url:"/TicketingProject/member/passing.do"
				,data: param  
				,type:"post"
				,dataType:"json"
				,success:function(data){
					console.log(data);
					
					if(data.resutlCnt == 0){
						alert("회원 비밀번호가 일치합니다.");
						
						
					}else{
						alert("회원 비밀번호가 일치하지 않습니다.");
					}
					
				}
				,error:function(){
					
				}
			});
			
		}
		
	</script>
</head>
<body>
	<%@include file="../../../common/header.jsp" %>
	<br><br><br><br><br>
	<div class="container">
		<h2>회원 패스워드 확인</h2>		
		<form id="fm">
			<div class="form-group" style="width:300px;">
				<label for="usr">패스워드:</label>
				<input type="password" class="form-control" id="userPwd" name="userPwd">
			</div>		
				<div class="form-group">			
				<button class="btn btn-primary"id="confirm" onclick="confirmBtn()">확인</button>
			</div>		
		</form>
	</div>
</body>
</html>