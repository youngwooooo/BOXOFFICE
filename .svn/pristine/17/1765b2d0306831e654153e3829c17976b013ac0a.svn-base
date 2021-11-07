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
  <script type="text/javascript">

  	$(document).ready(function(){
  	
  		for(var i=1; i<29; i++){
  			var name = "/TicketingProject/images/common/category/" + i + ".jpg"
  			var alt = "영화";
  			var str = "<a href='/TicketingProject/jsp/member/category/detailcategory.jsp'><img src=" + name + "></a>"
  			$("#detailEmg").append(str);
		
  		}
  	});
  	
  	function proc(flag, obj){
  		
  		if(flag == 1){
  			
  		}
  		
  	}
 	
  </script>
  <style type="text/css">
  		
  	#list h1{
  		font-size: 2em;
  	}
  	#list hr{
/*   		background-color: black; 안먹혀 */ 
/*   		color: black; */
  	}
  	
  	#detailEmg img{
  		width: 193px;
  		height: 280px;
  		padding: 15px 15px 15px 0px;
  	}
  	
  	#detailEmg img:hover{
  		border: 4px ridge blue;
  		padding: inherit;
  	}
  	
  	li:hover{
	
	background: black;
	color: white;
	}
	
	a:hover{
		color: white;
		text-decoration: none;
	}
  </style>
</head>
<body>
	<%@include file="/jsp/common/header.jsp" %>
	<br><br><br><br>
	<div class="container" style="margin-left: 0px; width: 1900px;" id="list">
		<h1>카테고리</h1>
		<hr>
		<br>
		<div  style="float:left; width: 400px;">
			<div>
				<ul class="list-group" style="width: 350px;">
					<li class="list-group-item" onclick="proc(1, this)">액션</li>
					<li class="list-group-item" onclick="proc(2, this)">모험</li>
					<li class="list-group-item" onclick="proc(3, this)">예술</li>
					<li class="list-group-item" onclick="proc(4, this)">코미디</li>
					<li class="list-group-item" onclick="proc(5, this)">다큐멘터리</li>
					<li class="list-group-item" onclick="proc(6, this)">드라마</li>
					<li class="list-group-item" onclick="proc(7, this)">교육</li>
					<li class="list-group-item" onclick="proc(8, this)">서사</li>
					<li class="list-group-item" onclick="proc(9, this)">실험</li>
					<li class="list-group-item" onclick="proc(10, this)">엑스플로이테이션</li>
					<li class="list-group-item" onclick="proc(11, this)">판타지</li>
					<li class="list-group-item" onclick="proc(12, this)">누아르</li>
					<li class="list-group-item" onclick="proc(13, this)" >공포</li>
					<li class="list-group-item" onclick="proc(14, this)">멈블코어</li>
					<li class="list-group-item" onclick="proc(15, this)">뮤지컬</li>
					<li class="list-group-item" onclick="proc(16, this)">미스터리</li>
					<li class="list-group-item" onclick="proc(17, this)">포르노</li>
					<li class="list-group-item" onclick="proc(18, this)">로맨스</li>
					<li class="list-group-item" onclick="proc(19, this)">일상물</li>
					<li class="list-group-item" onclick="proc(20, this)">SF</li>
					<li class="list-group-item" onclick="proc(21, this)">애니메이션</li>
					<li class="list-group-item" onclick="proc(22, this)">음악</li>
					<li class="list-group-item" onclick="proc(23, this)">멜로</li>
					<li class="list-group-item" onclick="proc(24, this)">전쟁</li>
					<li class="list-group-item" onclick="proc(25, this)">스포츠</li>
				</ul>
			</div>
		</div>

		<div class="container"
			style="float: right; width: 1400px; margin-right: 60px;">
			<div id="myCarousel" class="carousel slide" data-ride="carousel">
				<!-- Indicators -->
				<ol class="carousel-indicators">
					<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
					<li data-target="#myCarousel" data-slide-to="1"></li>
					<li data-target="#myCarousel" data-slide-to="2"></li>
				</ol>
	
				<!-- Wrapper for slides -->
				<div style="width: 30%;height:1px;float: left;"></div>
				<div class="carousel-inner" style="width: 40%;">
					<div class="item active">
						<img src="/TicketingProject/images/common/category/new1.jpg" alt="Los Angeles" style="width: 100%;height: 800px;;">
					</div>
					<div class="item">
						<img src="/TicketingProject/images/common/category/2.jpg" style="width: 100%;height: 800px;">
					</div>
					<div class="item">
						<img src="/TicketingProject/images/common/category/new2.jpg" style="width: 100%;height: 800px;">
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
				<div style="width: 30%;height:1px;float: right;"></div>
				<br><br><br>
				<div id="detailEmg" style="clear: both;">
	
				</div>
			</div>
		
		</div>
	</div>


<%@include file="/jsp/common/footer.jsp" %>

</body>
</html>