<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  
<!--   <link href="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css"> -->
<!--   <script src="//maxcdn.bootstrapcdn.com/bootstrap/4.1.1/js/bootstrap.min.js"></script> -->
<!--   <script src="//cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script> -->
  
  
  
<style type="text/css">
	#poster{
		width: 193px;
		height: 280px;
	}
	
	#hrgray{
		background-color: gray;
	}
	
</style>
<script type="text/javascript">
	function ticketing() {
		
		window.location.href = '/TicketingProject/jsp/member/ticketing/ticketingMovie.jsp'; 
	}
</script>
</head>
<body>
<%@include file="/jsp/common/header.jsp" %>
<br><br><br><br>

	<div class="container"
		style="margin-left: 25px; width: 1800px; float: center;" id="list">
		<h1>영화상세</h1>
		<hr>
		<br>
		<div style="width: 1200px;">
		<div style="width: 770px; height: 300px; float: left;" >
			<div style="float: left;">
				<img alt="movie02"
					src="/TicketingProject/images/common/category/2.jpg" id="poster">
			</div>
			<div style="float: right;">
				<h1 style="display: inline;">여고괴담 여섯번째 이야기 : 모교</h1>
				<p style="border: 2px solid DodgerBlue; display: inline;">현재 상영중</p>
				<p>WHISPERING CORRIDORS 6 : THE HUMMING</p>
				<br> <br>
				<p>예매율 1.7%</p>
				<p>누적관객누적관객 77,363명(06.25 기준)</p>
				<hr id="hrgray">
				<p>감독 : 이미영 / 배우 : 김서형 , 김현수 , 최리 , 김형서 , 권해효 , 장원형</p>
				<p>장르 : 미스터리, 호러 / 기본 : 15세 이상, 108분, 한국</p>
				<p>개봉 : 2021.06.17</p>
				<br>
				<button style="background-color: red; color: black; width: 150px; height: 30px; font-size: large; font-weight: bold;
				 type="button" class="btn btn-primary" onclick="ticketing()">예매하기</button>
				<button style="background-color: black; width: 150px; height: 30px; font-size: large; font-weight: bold;
				 type="button" class="btn btn-primary">후기보기</button>
			</div>
		</div>
<!-- 		<div style="float: right;"> -->
<!-- 			<img alt="" src="/TicketingProject/images/common/category/grap.PNG" style="width: 400px; height: 200px;"> -->
<!-- 		</div> -->
		</div>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
		<br>
	
		<div style="float:both;">고교시절의 기억을 잃은 ‘은희(김서형)’는 모교에 교감으로 부임한 후부터 알 수 없는 환영과 환청에
			시달리기 시작한다. 피해자임에도 불구하고 문제아로 내몰린 ‘하영(김현수)’은 홀리듯 들어간 학교의 폐쇄된 화장실에서 귀신
			소리를 듣게 되고 그 곳에서 같은 아픔을 가진 ‘은희(김서형)’와 마주친다. 두 사람은 학교에서 벌어지는 기이한 일들이
			화장실에 있는 존재와 연관됐음을 알게 되고, 곧 죽음의 공포와 마주하게 된다. 기억 속에 감춰진 충격적인 진실이 밝혀진다!
		</div>

		<br>
		<br>
		<br>
		<br>
	
<!-- 		<div> -->
<!-- 			<iframe src='https://tv.naver.com/embed/20580054?autoPlay=true' -->
<!-- 			frameborder='no' scrolling='no' marginwidth='0' marginheight='0' -->
<!-- 			WIDTH='544' HEIGHT='306' allow='autoplay' allowfullscreen> -->
<!-- 			</iframe> -->
<!-- 		</div> -->

		<div>
			<div style="border: 1px solid white; background-color: gray; font-size: large;">
				<span class="glyphicon glyphicon-plus" style="border: 1px solid none; background-color: #cccccc; margin-left: 15px;"></span>   예고편
			</div>
			
			<br><br>
			
			<div>
				<iframe src='https://tv.naver.com/embed/20580054?autoPlay=true'
					frameborder='no' scrolling='no' marginwidth='0'
					marginheight='0' WIDTH='1700' HEIGHT='900' allow='autoplay' allowfullscreen style="margin-left: 33px;">
				</iframe>
			</div>	

			
		</div>
		
		<br><br><br><br>
		
		
		<div>
			<div style="border: 1px solid white; background-color: gray; font-size: large;">
				<span class="glyphicon glyphicon-plus" style="border: 1px solid none; background-color: #cccccc; margin-left: 15px;"></span>   비하인드편
			</div>
			<br><br>
			
			<div>
				<iframe src='https://tv.naver.com/embed/20742387?autoPlay=true'
					frameborder='no' scrolling='no' marginwidth='0'
					marginheight='0' WIDTH='1700' HEIGHT='900' allow='autoplay' allowfullscreen style="margin-left: 33px;">
				</iframe>
			</div>
		</div>
		
		<br><br><br><br>
		
		
		
		
		
		
		
		<div>
			<div style="border: 1px solid white; background-color: gray; font-size: large;">
				<span class="glyphicon glyphicon-plus" style="border: 1px solid none; background-color: #cccccc; margin-left: 15px;"></span>   스틸컷
			</div>
			<br><br>
			<div class="container">
				<div id="myCarousel" class="carousel slide" data-ride="carousel">
					<!-- Indicators -->
					<ol class="carousel-indicators">
						<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
						<li data-target="#myCarousel" data-slide-to="1"></li>
						<li data-target="#myCarousel" data-slide-to="2"></li>
						<li data-target="#myCarousel" data-slide-to="3"></li>
						<li data-target="#myCarousel" data-slide-to="4"></li>
						<li data-target="#myCarousel" data-slide-to="5"></li>
						<li data-target="#myCarousel" data-slide-to="6"></li>
						<li data-target="#myCarousel" data-slide-to="7"></li>
						<li data-target="#myCarousel" data-slide-to="8"></li>
						<li data-target="#myCarousel" data-slide-to="9"></li>
						<li data-target="#myCarousel" data-slide-to="10"></li>
						<li data-target="#myCarousel" data-slide-to="11"></li>
						<li data-target="#myCarousel" data-slide-to="12"></li>
						<li data-target="#myCarousel" data-slide-to="13"></li>
						<li data-target="#myCarousel" data-slide-to="14"></li>
						<li data-target="#myCarousel" data-slide-to="15"></li>
<!-- 						<li data-target="#myCarousel" data-slide-to="16"></li> -->
<!-- 						<li data-target="#myCarousel" data-slide-to="17"></li> -->
					</ol>

					<!-- Wrapper for slides -->
					<div class="carousel-inner">
<!-- 						<div class="item active"> -->
<!-- 							<img src="/TicketingProject/images/common/category/stile1.jpg" -->
<!-- 								alt="Los Angeles" style="width: 100%;"> -->
<!-- 						</div> -->
<!-- 						<div class="item"> -->
<!-- 							<img src="/TicketingProject/images/common/category/stile2.jpg" -->
<!-- 								alt="Chicago" style="width: 100%;"> -->
<!-- 						</div> -->
						<div class="item active">
							<img src="/TicketingProject/images/common/category/stile7.jpg"
								alt="Chicago" style="width: 100%;">
						</div>
						<div class="item">
							<img src="/TicketingProject/images/common/category/stile8.jpg"
								alt="Chicago" style="width: 100%;">
						</div>
						<div class="item">
							<img src="/TicketingProject/images/common/category/stile9.jpg"
								alt="Chicago" style="width: 100%;">
						</div>
						<div class="item">
							<img src="/TicketingProject/images/common/category/stile10.jpg"
								alt="Chicago" style="width: 100%;">
						</div>
						<div class="item">
							<img src="/TicketingProject/images/common/category/stile11.jpg"
								alt="Chicago" style="width: 100%;">
						</div>
						<div class="item">
							<img src="/TicketingProject/images/common/category/stile12.jpg"
								alt="Chicago" style="width: 100%;">
						</div>
						<div class="item">
							<img src="/TicketingProject/images/common/category/stile13.jpg"
								alt="Chicago" style="width: 100%;">
						</div>
						<div class="item">
							<img src="/TicketingProject/images/common/category/stile14.jpg"
								alt="Chicago" style="width: 100%;">
						</div>
						<div class="item">
							<img src="/TicketingProject/images/common/category/stile15.jpg"
								alt="Chicago" style="width: 100%;">
						</div>
						<div class="item">
							<img src="/TicketingProject/images/common/category/stile16.jpg"
								alt="Chicago" style="width: 100%;">
						</div>
						<div class="item">
							<img src="/TicketingProject/images/common/category/stile1.jpg"
								alt="Chicago" style="width: 100%;">
						</div>
						<div class="item">
							<img src="/TicketingProject/images/common/category/stile2.jpg"
								alt="Chicago" style="width: 100%;">
						</div>
						<div class="item">
							<img src="/TicketingProject/images/common/category/stile4.jpg"
								alt="Chicago" style="width: 100%;">
						</div>
						<div class="item">
							<img src="/TicketingProject/images/common/category/stile5.jpg"
								alt="Chicago" style="width: 100%;">
						</div>
						<div class="item">
							<img src="/TicketingProject/images/common/category/stile6.jpg"
								alt="Chicago" style="width: 100%;">
						</div>
						<div class="item">
							<img src="/TicketingProject/images/common/category/stile3.jpg"
								alt="Chicago" style="width: 100%;">
						</div>


					</div>

					<!-- Left and right controls -->
					<a class="left carousel-control" href="#myCarousel"
						data-slide="prev"> <span
						class="glyphicon glyphicon-chevron-left"></span> <span
						class="sr-only">Previous</span>
					</a> <a class="right carousel-control" href="#myCarousel"
						data-slide="next"> <span
						class="glyphicon glyphicon-chevron-right"></span> <span
						class="sr-only">Next</span>
					</a>
				</div>
			</div>

		</div>

	</div>
<br><br><br>	
<%@include file="/jsp/common/footer.jsp" %>
</body>
</html>