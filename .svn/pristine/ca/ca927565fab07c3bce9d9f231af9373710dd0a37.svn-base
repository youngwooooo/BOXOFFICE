<%@page import="common.vo.TheaterVO"%>
<%@page import="common.vo.SeatVO"%>
<%@page import="common.vo.TicketingVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	List<TicketingVO> TicketingInfoList = (List)request.getAttribute("TicketingInfoList");
	TheaterVO theaterVO = (TheaterVO)request.getAttribute("theaterVO");
	List<SeatVO> seatList = (List)request.getAttribute("seatList");
%>    
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, width=device-width">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <meta name="format-detection" content="telephone=no">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <title>박스오피스 | 예매</title>
    
    <style type="text/css">
    	.btn btn-default btn-sm
    </style>
</head>
<script type="text/javascript">
	
	
	
</script>
<body>
<%@include file="../../common/header.jsp" %>
<div class="ticketing-container">
	<div class="ticketing">
		<h1>영화예매</h1>
	</div>
	<div class="ticketing-movie">
		<h2><span>▶</span> 영화</h2>
		<hr>
			<div class="choice-movie-info">
				<div class="choice-movie">
					<ul>
						<li class="choiceMenu">
							<h2>영화 선택</h2>
							<select name="movie">
								<option></option>
							</select>
						</li>
						<li class="choiceMenu">
							<h2>영화관 선택</h2>
							<select name="cinema">
								<option></option>
							</select>
						</li>
						<li class="choiceMenu">
							<h2>상영 날짜</h2>
							<select name="movieDate">
								<option></option>
							</select>
						</li>
						<li class="choiceMenu">
							<h2>상영관 선택</h2>
							<select name="theater">
								<option></option>
							</select>
						</li>
						<li class="choiceMenu">
							<h2>상영 시간</h2>
							<select name="movieTime">
								<option></option>
							</select>					
						</li>
					</ul>
				</div>
			</div>	
		</div>
		<!-- ticketing movie -->
		
		<div class="ticketing-seat">
			<h2><span>▶</span> 좌석</h2>
			<hr>
			<div class="member-separate">
				<div class="kid">
					<h2>어린이</h2>
					<button class="memberBtn" type="button" onclick="">-</button>
					<div id="kids" class="member-count">
						<p>0</p>
						<input type="hidden" value="0" name="countNum">
					</div>
					<button class="memberBtn" type="button" onclick="addCount(this)">+</button>
				</div>
				<div class="teen">
					<h2>청소년</h2>
					<button class="memberBtn" type="button">-</button><div class="member-count">0</div><button class="memberBtn" type="button">+</button>
				</div>
				<div class="adult">
					<h2>성인</h2>
					<button class="memberBtn" type="button">-</button><div class="member-count">0</div><button class="memberBtn" type="button">+</button>
				</div>
				<div class="Disabled">
					<h2>장애인</h2>
					<button class="memberBtn" type="button">-</button><div class="member-count">0</div><button class="memberBtn" type="button">+</button>
				</div>
			</div>
			<div class="table-left">
				<table>
					<tr>
						<th>A</th>
					</tr>
					<tr>
						<th>B</th>
					</tr>
					<tr>
						<th>C</th>
					</tr>
					<tr>
						<th>D</th>
					</tr>
					<tr>
						<th>E</th>
					</tr>
					<tr>
						<th>F</th>
					</tr>
					<tr>
						<th>G</th>
					</tr>
					<tr>
						<th>H</th>
					</tr>
					<tr>
						<th>I</th>
					</tr>
					<tr>
						<th>J</th>
					</tr>
					<tr>
						<th>K</th>
					</tr>
				</table>
			</div>
			<div class="table-center">
				<table class="screen">
					<tr>
						<th colspan="11">SCREEN</th>
					</tr>	
				</table>
				<br>
				<table class="seat">
					<thead>
						
					</thead>
					<tbody>
						<%
							int rowCnt = theaterVO.getRowCount();
							int colCnt = theaterVO.getColCount();
							
							for(int i=0 ; i<colCnt ; i++) {
								int idx = i;
						%>
							<tr>
						<%
								for(int j=0 ; j<rowCnt ; j++) {
						%>
							<td>
						<% 			if(seatList.get(idx).getDeleteYn().equals("Y")) { %>
								<button type="button" class="btn btn-sm"><%=seatList.get(idx).getSeatNo() %></button>
						<% 			} else { %>
								<button type="button" class="btn btn-default btn-sm"><%=seatList.get(idx).getSeatNo() %></button>
						<%			 } %>
								<input type="hidden" name="seatCd" value="<%=seatList.get(idx).getSeatCd() %>">
								<input type="hidden" name="seatDeleteYn" value="<%=seatList.get(idx).getDeleteYn() %>">
							</td>
						<%
									idx += colCnt;
								}
						%>
							</tr>
						<%
							}
						%>
					</tbody>
				</table>
				<table class="table-num">
					<tr>
						<th>01</th>
						<th>02</th>
						<th>03</th>
						<th>04</th>
						<th>05</th>
						<th>06</th>
						<th>07</th>
						<th>08</th>
						<th>09</th>
						<th>10</th>
						<th>11</th>
						<th>12</th>
						<th>13</th>
					</tr>	
				</table>
			</div>
			<div class="table-right">
				<table>
					<tr>
						<th class="st1">이코노미</th>
					</tr>
					<tr>
						<th class="st2">스탠다드</th>
					</tr>
					<tr>
						<th class="st3">프리미엄</th>
					</tr>
				</table>
			</div>
		</div>
		<!-- choice-seat -->
		<div class="ticketing-snack">
		<h2><span>▶</span> 스낵</h2>
		<hr>
			<div class="choice-snack-info">
				<div class="snack-menu">
					<div class="snackDiv">
						<div class="snack">
							<figure>
								<img src="/TicketingProject/images/common/snack/popcorn1.png" alt="팝콘1">
								<h2>고소팝콘(L)</h2>
								<p>옥수수 본연의 맛을 즐길 수 있는 짭짜름한 클래식 고소팝콘!</p>
							</figure>
						</div>
						<div class="snack">
							<figure>
								<img src="/TicketingProject/images/common/snack/popcorn2.png" alt="팝콘2">
								<h2>달콤팝콘(L)</h2>
								<p>달콤한 카라멜 향이 가득한 달콤팝콘을 즐겨보세요!</p>
							</figure>
						</div>
						<div class="snack">
							<figure>
								<img src="/TicketingProject/images/common/snack/popcorn3.png" alt="팝콘3">
								<h2>더블치즈팝콘(L)</h2>
								<p>치즈매니아들이라면 놓칠 수 없는 바로 그 팝콘!</p>
							</figure>
						</div>
						<div class="snack">
							<figure>
								<img src="/TicketingProject/images/common/snack/popcorn4.png" alt="팝콘4">
								<h2>바질어니언팝콘(L)</h2>
								<p>수많은 매니아를 보유한 바로 그 팝콘! 중독성 200%</p>
							</figure>
						</div>
						<div class="snack">
							<figure>
								<img src="/TicketingProject/images/common/snack/popcon5.png" alt="팝콘5">
								<h2>바질어니언팝콘(M)</h2>
								<p>수많은 매니아를 보유한 바로 그 팝콘! 중독성 200%</p>
							</figure>
						</div>
						<div class="snack">
							<figure>
								<img src="/TicketingProject/images/common/snack/popcon6.png" alt="팝콘6">
								<h2>더블치즈팝콘(M)</h2>
								<p>치즈매니아들이라면 놓칠 수 없는 바로 그 팝콘!</p>
							</figure>
						</div>
						<div class="snack">
							<figure>
								<img src="/TicketingProject/images/common/snack/popcon7.png" alt="팝콘7">
								<h2>고소팝콘(M)</h2>
								<p>옥수수 본연의 맛을 즐길 수 있는 짭짜름한 클래식 고소팝콘!</p>
							</figure>
						</div>
						<div class="snack">
							<figure>
								<img src="/TicketingProject/images/common/snack/popcon8.png" alt="팝콘8">
								<h2>달콤팝콘(M)</h2>
								<p>달콤한 카라멜 향이 가득한 달콤팝콘을 즐겨보세요!</p>
							</figure>
						</div>
						<div class="snack">
							<figure>
								<img src="/TicketingProject/images/common/snack/nacho1.jpg" alt="나쵸1">
								<h2>칠리치즈나쵸</h2>
								<p>바삭바삭한 나쵸에 칠리치즈의 조합, 여기가 멕시코인가요?</p>
							</figure>
						</div>
					</div>
					<div class="drinkDiv">
						<div class="drink">
							<figure>
								<img src="/TicketingProject/images/common/snack/drink1.png" alt="음료1">
								<h2>탄산음료(M)</h2>
								<p>콜라, 사이다, 환타 중 원하는 맛으로 교환하세요!</p>
							</figure>
						</div>
						<div class="drink">
							<figure>
								<img src="/TicketingProject/images/common/snack/drink2.png" alt="음료2">
								<h2>탄산음료(L)</h2>
								<p>콜라, 사이다, 환타 중 원하는 맛으로 교환하세요!</p>
							</figure>
						</div>
						<div class="drink">
							<figure>
								<img src="/TicketingProject/images/common/snack/coffee1.png" alt="커피1">
								<h2>아메리카노(HOT)</h2>
								<p>현대인의 필수품, 아메리카노 한잔하세요~</p>
							</figure>
						</div>
						<div class="drink">
							<figure>
								<img src="/TicketingProject/images/common/snack/coffee2.png" alt="커피2">
								<h2>아메리카노(ICE)</h2>
								<p>현대인의 필수품, 아메리카노 한잔하세요~</p>
							</figure>
						</div>	
					</div>
				</div>
				<div class="choice-snack">
					<ul>
						<li class="choiceMenu">
							<h2>스낵 선택</h2>
							<select name="sanck">
								<option>스낵을 선택해주세요.</option>
							</select>
						</li>
						<li class="choiceMenu">
							<h2>스낵 수량</h2>
							<input type="number" min="0" max="100">
						</li>
					</ul>
				</div>
			</div>	
		</div>
		<!-- ticketing snack -->
		
		<div class="ticketing-payment">
			<h2><span>▶</span> 결제</h2>
			<hr>
			<div class="payment-process">
				<div class="payment-price">
					<h2>총 결제금액 : <span>10,000</span>원</h2>
				</div>
				<div class="payment-btn">
					<button type="submit">결제하기</button>
				</div>
			</div>
		</div>		
</div>
<%@include file="../../common/footer.jsp" %>
</body>
</html>