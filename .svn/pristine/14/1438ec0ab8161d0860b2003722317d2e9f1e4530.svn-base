<%@page import="common.vo.TheaterVO"%>
<%@page import="common.vo.SeatVO"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.ArrayList"%>
<%@page import="common.vo.TicketingVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	List<TicketingVO> ticketingInfoList = (List)request.getAttribute("TicketingInfoList");
	TheaterVO theaterVO = (TheaterVO)request.getAttribute("theaterVO");
	List<SeatVO> seatList = (List)request.getAttribute("seatList");
	
	TicketingVO tkVO;
	if(ticketingInfoList == null) {
		tkVO = new TicketingVO();
	} else {
		tkVO = ticketingInfoList.get(0);
	}
		String screenCd = tkVO.getScreenCd();
		if(screenCd.equals("01")){
			screenCd = "2D";
		}else if(screenCd.equals("02")){
			screenCd = "3D";
		}else if(screenCd.equals("03")){
			screenCd = "4D";
		}else if(screenCd.equals("04")){
			screenCd = "IMAX";
		}
		String screen = tkVO.getTheaterNo() + "관 " + "(" + screenCd + ")";
		String movieTime = tkVO.getShowStartTime() + " ~ " + tkVO.getShowEndTime();
		String showDate = tkVO.getShowDate();
		showDate = showDate.substring(0, 11);
		System.out.println("상영관코드 :" + tkVO.getTheaterCd());
%>    
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, width=device-width">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <meta name="format-detection" content="telephone=no">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <title>박스오피스 | 예매</title>
    <style type="text/css">
    	.member-separate button {cursor: pointer;}
    </style>
</head>
<script type="text/javascript">
	
	function addCount(obj){
		var num = $(obj).prev().children("[name=countNum]").val();
		num = parseInt(num) + 1;

		var sumPCountNum = parseInt($(".kid p").text()) + parseInt($(".teen p").text()) + parseInt($(".adult p").text()) + parseInt($(".Disabled p").text());
		var sumInputCountNum = parseInt($(".kid input").val()) + parseInt($(".teen input").val()) + parseInt($(".adult input").val()) + parseInt($(".Disabled input").val());
		
		if(sumPCountNum >= 4 && sumInputCountNum >= 4){
			alert("예매 인원 수를 초과하셨습니다.(최대 4명)");
			num = 0;
			$(".member-count p").text(num);
			$(".member-count input").val(num);
			
		}
		
		$(obj).prev().children("[name=countNum]").val(num);
		$(obj).prev().children("p").text(num);
		
		
	}
	
	function downCount(obj){
		var num = $(obj).next().children("[name=countNum]").val();
		num = parseInt(num) - 1;
		if(num < 0){
			num = 0;
		}
		
		
		$(obj).next().children("[name=countNum]").val(num);
		$(obj).next().children("p").text(num);
	}
	
	$(function(){
		$(".seat th").click(function(){
			$(this).css("background-color", "black");
	});
		$(".seat .eco th").dblclick(function(){
			$(this).css("background-color", "#f9f992");
	});
		$(".seat .std th").dblclick(function(){
			$(this).css("background-color", "#f79999");
	});
		$(".seat .prm th").dblclick(function(){
			$(this).css("background-color", "skyblue");
	});
		
			
	});	
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
							<h2>영화</h2>
							<select name="movie">
								<option><%=tkVO.getMvNameKor() %></option>
							</select>
						</li>
						<li class="choiceMenu">
							<h2>영화관</h2>
							<select name="cinema">
								<option><%=tkVO.getCinemaName() %></option>
							</select>
						</li>
						<li class="choiceMenu">
							<h2>상영 날짜</h2>
							<select name="movieDate">
								<option><%=showDate %></option>
							</select>
						</li>
						<li class="choiceMenu">
							<h2>상영관</h2>
							<select name="theater">
								<option><%=screen %></option>
							</select>
						</li>
						<li class="choiceMenu">
							<h2>상영 시간</h2>
							<select name="movieTime">
								<option><%=movieTime %></option>
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
					<button class="memberBtn" type="button" onclick="downCount(this)">-</button>
					<div class="member-count">
						<p>0</p>
						<input type="hidden" value="0" name="countNum">
					</div>
					<button class="memberBtn" type="button" onclick="addCount(this)">+</button>
				</div>
				<div class="teen">
					<h2>청소년</h2>
					<button class="memberBtn" type="button" onclick="downCount(this)">-</button>
					<div class="member-count">
						<p>0</p>
						<input type="hidden" value="0" name="countNum">
					</div>
					<button class="memberBtn" type="button" onclick="addCount(this)">+</button>
				</div>
				<div class="adult">
					<h2>성인</h2>
					<button class="memberBtn" type="button" onclick="downCount(this)">-</button>
					<div class="member-count">
						<p>0</p>
						<input type="hidden" value="0" name="countNum">
					</div>
					<button class="memberBtn" type="button" onclick="addCount(this)">+</button>
				</div>
				<div class="Disabled">
					<h2>장애인</h2>
					<button class="memberBtn" type="button" onclick="">-</button>
					<div class="member-count">
						<p>0</p>
						<input type="hidden" value="0" name="countNum">
					</div>
					<button class="memberBtn" type="button" onclick="addCount(this)">+</button>
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
					<tr class="eco">
						<th>A01</th>
						<th>A02</th>
						<th>A03</th>
						<th>A04</th>
						<th>A05</th>
						<th>A06</th>
						<th>A07</th>
						<th>A08</th>
						<th>A09</th>
						<th>A10</th>
						<th>A11</th>
						<th>A12</th>
						<th>A13</th>
					</tr>
					<tr class="eco">
						<th>B01</th>
						<th>B02</th>
						<th>B03</th>
						<th>B04</th>
						<th>B05</th>
						<th>B06</th>
						<th>B07</th>
						<th>B08</th>
						<th>B09</th>
						<th>B10</th>
						<th>B11</th>
						<th>B12</th>
						<th>B13</th>
					</tr>
					<tr class="eco">
						<th>C01</th>
						<th>C02</th>
						<th>C03</th>
						<th>C04</th>
						<th>C05</th>
						<th>C06</th>
						<th>C07</th>
						<th>C08</th>
						<th>C09</th>
						<th>C10</th>
						<th>C11</th>
						<th>C12</th>
						<th>C13</th>
					</tr>
					<tr class="std">
						<th>D01</th>
						<th>D02</th>
						<th>D03</th>
						<th>D04</th>
						<th>D05</th>
						<th>D06</th>
						<th>D07</th>
						<th>D08</th>
						<th>D09</th>
						<th>D10</th>
						<th>D11</th>
						<th>D12</th>
						<th>D13</th>
					</tr>
					<tr class="std">
						<th>E01</th>
						<th>E02</th>
						<th>E03</th>
						<th>E04</th>
						<th>E05</th>
						<th>E06</th>
						<th>E07</th>
						<th>E08</th>
						<th>E09</th>
						<th>E10</th>
						<th>E11</th>
						<th>E12</th>
						<th>E13</th>
					</tr>
					<tr class="std">
						<th>F01</th>
						<th>F02</th>
						<th>F03</th>
						<th>F04</th>
						<th>F05</th>
						<th>F06</th>
						<th>F07</th>
						<th>F08</th>
						<th>F09</th>
						<th>F10</th>
						<th>F11</th>
						<th>F12</th>
						<th>F13</th>
					</tr>
					<tr class="std">
						<th>G01</th>
						<th>G02</th>
						<th>G03</th>
						<th>G04</th>
						<th>G05</th>
						<th>G06</th>
						<th>G07</th>
						<th>G08</th>
						<th>G09</th>
						<th>G10</th>
						<th>G11</th>
						<th>G12</th>
						<th>G13</th>
					</tr>
					<tr class="std">
						<th>H01</th>
						<th>H02</th>
						<th>H03</th>
						<th>H04</th>
						<th>H05</th>
						<th>H06</th>
						<th>H07</th>
						<th>H08</th>
						<th>H09</th>
						<th>H10</th>
						<th>H11</th>
						<th>H12</th>
						<th>H13</th>
					</tr>
					<tr class="prm">
						<th>I01</th>
						<th>I02</th>
						<th>I03</th>
						<th>I04</th>
						<th>I05</th>
						<th>I06</th>
						<th>I07</th>
						<th>I08</th>
						<th>I09</th>
						<th>I10</th>
						<th>I11</th>
						<th>I12</th>
						<th>I13</th>
					</tr>
					<tr class="prm">
						<th>J01</th>
						<th>J02</th>
						<th>J03</th>
						<th>J04</th>
						<th>J05</th>
						<th>J06</th>
						<th>J07</th>
						<th>J08</th>
						<th>J09</th>
						<th>J10</th>
						<th>J11</th>
						<th>J12</th>
						<th>J13</th>
					</tr>
					<tr class="prm">
						<th>K01</th>
						<th>K02</th>
						<th>K03</th>
						<th>K04</th>
						<th>K05</th>
						<th>K06</th>
						<th>K07</th>
						<th>K08</th>
						<th>K09</th>
						<th>K10</th>
						<th>K11</th>
						<th>K12</th>
						<th>K13</th>
					</tr>
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