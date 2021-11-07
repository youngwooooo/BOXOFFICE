<%@page import="common.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%MemberVO mv = (MemberVO) request.getAttribute("memberVO"); %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<!-- 부트스트랩 -->
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
	<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
	<!-- 탭 명 -->
	<title>박스오피스 | 마이페이지</title>
	<style type="text/css">
		#wrap_mypage_header {
			width: 1280px;
			margin: 80px auto;
			display: flex;
			flex-flow: row nowrap;
			justify-content: center;
		}
		#wrap_mypage_header .title {
			font-size: 4rem;
		}
		hr.black {
			border: 1px solid black;
		}
		.mypage_btn_box {
			margin-top: 30px;
			width: 100%;
			display: flex;
			flex-flow: row wrap;
		}
		.mypage_btn_box > div {
			width: calc(25% - 2px);
			border: 1px solid gray;
			text-align: center;
			font-size: 1.7rem;
			padding: 5px 0 5px 0;
		}
		.mypage_btn_box > div:hover {
			color: #ff1212;
			cursor: pointer;
			border-bottom: none;
		}
		.info {
			display: flex;
			flex-flow: row wrap;
			width: 100%;
			background: #f0f0f0;
			height: 100px;
		}
		.info_txt {
			width: 100%;
			text-align: center;
			display: flex;
			align-items: center;
		}
		.info_txt > p {
			font-size: 2rem;
			width: 100%;
		}
		.info_txt > p > span {
			font-size: 1.7rem;
		}
		.info_txt #mem_name {
			font-size: 2.5rem;
			font-weight: bold;
		}
		.info_txt #membership {
			font-size: 2.5rem;
			font-weight: bold;
			color: #ff1212;
		}
		.mypage_content {
			width: calc(100% - 8px);
			border: 1px solid gray;
			border-top: none;
		}
		.mp_cont_detail {
			width: 90%;
			margin: 0 auto;
			padding-top: 30px;
			padding-bottom: 30px;
		}
		.mp_cont_tit {
			padding-top: 20px;
			text-align: center;
			font-size: 2.5rem;
		}
		.mp_cont_table {
			text-align: center;
		}
		.mp_cont_table thead td {
			font-size: 2rem;
		}
		.mp_cont_table tbody td {
			font-size: 1.6rem;
			vertical-align: middle !important;
		}
		.prod_info {
			display: flex;
			flex-flow: row wrap;
		}
		.prod_img {
			height: 150px;
			width: 50%;
		}
		.prod_img img {
			max-height: 150px;
			width: auto;
		}
		.prod_name {
			width: 50%;
			align-self: center;
			text-align: left;
			padding-left: 30px;
		}
		.mp_cont_table_btn_box {
			display: flex;
			flex-flow: column nowrap;
			justify-content: center;
		}
		.mp_cont_table_btn_box button {
			margin-top: 10px;
			width: 100%;
		}
		.member_info_table {
		}
		.member_info_table td:first-child {
			width: 200px;
			font-size: 2rem;
		}
		.member_info_table td:nth-child(2) {
			font-size: 1.5rem;
		}
	</style>
	<script>
		function changeMypageTap(obj) {
			$(".mypage_btn_box > div").css("border", "1px solid gray").css("color", "black");
			$(obj).css("border-bottom", "none").css("color", "#ff1212");
			
			var url = $(obj).children("[name=url]").val();
		}
	
		$(document).ready(function(){
			$("#Reservation_history").hide(); //예매내역div
			$("#Order_History").hide(); //주문내역div
			$("#Member_Info").hide(); //회원정보div
			$("#My_Wrote").hide(); //자기 쓴 글div
		});	
		
		function changeMypageTap(obj){
			
			if(obj == 1){
				$("#Reservation_history").show();			
			}else if(obj == 2){
				$("#Order_History").show();
			}else if(obj == 3){
				$("#Member_Info").show();
			}else if(obj ==4){
				$("#My_Wrote").show();
			}
			
// 			var length = $(".mypage_content").length;
// 			var mc = $(".mypage_content").get();
			
// 			for(var i=1; i<=length; i++){
// 				if(obj != i){
// 					mc.eq(i).hide();
// 				}				
// 			}
			
			if(obj != 1){
				$("#Reservation_history").hide();			
			}	
			if(obj != 2){
				$("#Order_History").hide();			
			}	
			if(obj != 3){
				$("#Member_Info").hide();			
			}	
			if(obj != 4){
				$("#My_Wrote").hide();				
			}						
			
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

	                
	                }

	                // 우편번호와 주소 정보를 해당 필드에 넣는다.
	                document.getElementById('userZip').value = data.zonecode;
	                document.getElementById("userAddr1").value = addr;
	                // 커서를 상세주소 필드로 이동한다.
	                document.getElementById("userAddr2").focus();
	            }
	        }).open();
		}
		
		// 수정완료 버튼
		function complete(){
			$.ajax({
				url: "/TicketingProject/member/updateMemberInfo.do"
				,type: "post"
				,data: $("#fm_memInfo").serialize()
				,dataType: "json"
				,success:function(data){
					console.log(data);
					// data : { "result" : 1}
					// ==> data : { result: 1 }
					// data.result = 1
					if(data.result == 1) {
						alert("회원정보가 수정되었습니다.");
						//세션 나가는 코드 입력*
						window.location.href = "<%=request.getContextPath()%>/jsp/common/main.jsp";
						
					}else{
						alert("회원정보가 수정되지 않았습니다.\n관리자에게 문의하세요.");
					}
				}
				,error:function(xhr){
					alert("오류발생. 관리자에게 문의하세요.");
					console.log(xhr);
				}
			});
		}
		
		// 회원탈퇴 버튼
// 		function secession(){
// 			$.ajax({
// 				url: ""
// 			});
// 		}
		
	</script>
	
	
</head>
<body>
	<%@include file="../../common/header.jsp" %>
	<div id="wrap_mypage_header">
		<div class="container">
			<h2 class="title">MY BOX OFFICE</h2>
			<hr class="black">
			<div class="info">
				<div class="info_txt">
					<p><span id="mem_name"><%=mv.getMemName() %></span><span id="mem_id">(<%=mv.getMemId() %>)</span>님의 현재 등급은 <span id="membership">VIP</span>입니다.</p>
				</div>
			</div>
			
			<hr class="black">
			<div class="mypage_btn_box">
				<div id="ticketing" onclick="changeMypageTap(1)">
					예매 내역
					<input type="hidden" name="url" value="">
				</div>
				<div id="order" onclick="changeMypageTap(2)">
					주문 내역
					<input type="hidden" name="url" value="">
				</div>
				<div id="mem_info" onclick="changeMypageTap(3)">
					회원 정보
					<input type="hidden" name="url" value="">
				</div>
				<div id="post" onclick="changeMypageTap(4)">
					내가 쓴 글
					<input type="hidden" name="url" value="">
				</div>
			</div>
			
			<div class="mypage_content" id="Reservation_history">
				<div class="mp_cont_detail">
					<h2 class="mp_cont_tit">예매 내역</h2>
					<hr class="black">
					<div class="mp_ticketing_detail">
						<table class="table mp_cont_table">
							<thead>
								<tr>
									<td>번호</td>
									<td>영화</td>
									<td>인원</td>
									<td>금액</td>
									<td>선택</td>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td>1</td>
									<td>
										<div class="prod_info">
											<div class="prod_img">
												<img alt="영화" src="/TicketingProject/images/common/main/poster01.jpg">
											</div>
											<div class="prod_name">
												침묵
											</div>
										</div>
									</td>
									<td>3</td>
									<td><b>30,000원</b></td>
									<td>
										<div class="mp_cont_table_btn_box">
											<button type="button" class="btn btn-default">상세정보</button>
											<button type="button" class="btn btn-default">결제 취소</button>
										</div>
									</td>
								</tr>
								<tr>
									<td>2</td>
									<td>
										<div class="prod_info">
											<div class="prod_img">
												<img alt="영화" src="/TicketingProject/images/common/main/poster02.jpg">
											</div>
											<div class="prod_name">
												신세계
											</div>
										</div>
									</td>
									<td>2</td>
									<td><b>20,000원</b></td>
									<td>
										<div class="mp_cont_table_btn_box">
											<button type="button" class="btn btn-default">상세정보</button>
											<button type="button" class="btn btn-default">리뷰 작성</button>
										</div>
									</td>
								</tr>
							</tbody>
						</table>
						<hr class="black">
					</div>
				</div>
			</div>
			
			<div class="mypage_content" id="Order_History">
				<div class="mp_cont_detail">
					<h2 class="mp_cont_tit">주문 내역</h2>
					<hr class="black">
					<div class="mp_order_detail">
						<table class="table mp_cont_table">
							<thead>
								<tr>
									<td>번호</td>
									<td>상품</td>
									<td>수량</td>
									<td>금액</td>
									<td>선택</td>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td>1</td>
									<td>
										<div class="prod_info">
											<div class="prod_img">
												<img alt="영화" src="/TicketingProject/images/common/snack/coffee1.jpg">
											</div>
											<div class="prod_name">
												아메리카노
											</div>
										</div>
									</td>
									<td>1</td>
									<td><b>4,000원</b></td>
									<td>
										<div class="mp_cont_table_btn_box">
											<button type="button" class="btn btn-default">결제 취소</button>
										</div>
									</td>
								</tr>
								<tr>
									<td>2</td>
									<td>
										<div class="prod_info">
											<div class="prod_img">
												<img alt="영화" src="/TicketingProject/images/common/snack/popcorn1.jpg">
											</div>
											<div class="prod_name">
												팝콘
											</div>
										</div>
									</td>
									<td>1</td>
									<td><b>6,000원</b></td>
									<td>
										<div class="mp_cont_table_btn_box">
											<button type="button" class="btn" disabled>사용 완료</button>
										</div>
									</td>
								</tr>
							</tbody>
						</table>
						<hr class="black">
					</div>
				</div>
			</div>
			
			
			<div class="mypage_content" id="Member_Info">
				<div class="mp_cont_detail">
					<h2 class="mp_cont_tit">회원 정보</h2>
					<hr class="black">
					<form id="fm_memInfo">
					<div class="mp_member_detail">
									
					<table class="table member_info_table">
						<tr>
							<td>아이디</td>
							<td id="td_Id"><input class="form-control" value="<%=mv.getMemId() %>" readonly name="memId" id="userId"></td>
						</tr>
						<tr>
							<td>이름</td>
							<td id="td_Name"><input class="form-control" value="<%=mv.getMemName() %>" name="memName" id="userName"></td>
						</tr>
						<tr>
							<td>휴대폰번호</td>
							<td id="td_Hp"><input class="form-control" value="<%=mv.getMemHp() %>" name="memHp" id="userPh"></td>
						</tr>
						<tr>
							<td>이메일</td>
							<td id="td_Email"><input class="form-control" value="<%=mv.getMemMail() %>" name="memMail" id="userEmail"></td>
						</tr>
						<tr>
							<td>생일</td>
							<td id="td_Birth"><input type="text" class="form-control" value="<%=mv.getMemBir() %>" readonly name="memBir" id="userBirth"></td>
						</tr>
						<tr>
							<td>우편번호</td>
							<td>
								<input style="width: 120px;display: inline;" class="form-control" type="text" value="<%=mv.getMemZip() %>" readonly name="memZip" id="userZip">
								<button type="button" class="btn btn-primary" onclick="getZipCode()">우편번호 검색</button>
							</td>
						</tr>
						<tr>
							<td>주소</td>
							<td id="td_Addr"><input type="text" class="form-control" value="<%=mv.getMemAddr1() %>" readonly name="memAddr1" id="userAddr1"></td>
						</tr>
						<tr>
							<td>상세주소</td>
							<td id="td_Addr2"><input type="text" class="form-control" value="<%=mv.getMemAddr2() %>" name="memAddr2" id="userAddr2"></td>						
						</tr>							
						<tr>
							<td>
							<button class="btn btn-success" type="button" onclick="complete()">수정완료</button>
							<button class="btn btn-danger" type="button" onclick="secession()">회원탈퇴</button>							
							</td>						
						</tr>						
					</table>
					
					<input type="hidden" value="Check" name="flag">			

					</div>
					</form>
					<hr class="black">
				</div>
			</div>
			
			<div class="mypage_content" id="My_Wrote">
				<div class="mp_cont_detail">
					<h2 class="mp_cont_tit">내가 쓴 글</h2>
					<hr class="black">
					<div class="mp_post_detail">
						<table class="table table-striped table-hover mp_cont_table">
							<thead>
								<tr>
									<td>번호</td>
									<td>게시판</td>
									<td>제목</td>
									<td>작성일자</td>
								</tr>
							</thead>
							<tbody>
								<tr>
									<td>2</td>
									<td>문의사항</td>
									<td>결제 취소를 했는데 환불이 안 됐어요.</td>
									<td>2021/06/01</td>
								</tr>
								<tr>
									<td>1</td>
									<td>문의사항</td>
									<td>안녕하세요 문의할 게 있는데요.</td>
									<td>2021/06/01</td>
								</tr>
							</tbody>
						</table>
					</div>
					<hr class="black">
				</div>
			</div>
			
			<hr>
		</div>
	</div>
	<%@include file="../../common/footer.jsp" %>
</body>
</html>