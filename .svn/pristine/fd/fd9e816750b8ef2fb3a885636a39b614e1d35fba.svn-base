<%@page import="common.vo.PagingVO"%>
<%@page import="java.util.List"%>
<%@page import="common.vo.CdChargeVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>박스오피스 | 상영시간표 관리</title>
	
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
	<script src="../../../js/lib/jquery-3.6.0.js"></script>
<!-- 	<link rel="stylesheet" href="../../../css/common/style.css"> -->
	<style type="text/css">
 		table, td, th { 
 		    border: 1px solid black; 
 		}
 		thead td {
			background-color: black;
			color: white;
 		}
 		thead td:last-child {
 			background-color: #ff1212;
 		}
 		table {
 			border-collapse: collapse;
 			width: 100%;
 			text-align: center;	
 		}
 		tr {
 			height: 45px;
 			vertical-align: middle;			
 		}
 		td {
 			width: calc(100% / 10);
 			vertical-align: middle;
 			line-height: 45px;
 		}
 		
 		input {
 			width: 120px;
 			text-align: center;
 		}
 		
 		#divBtn {
 			width: 100%;
 			float: left;
 		}
 		
 		.btn-plus {
 			border-color: #B40D0C;
 			color: #B40D0C;
 			font-size: 18px;
 			height: 34px;
 		}
 		.btn-minus {
 			border-color: #B40D0C;
 			color: #B40D0C;
 		}
 		.btn-save {
 			background-color: #B40D0C;
 			color: white;
 		}
 		
 		a:link, a:visited {
 			text-decoration: none;
 			color: black;
 		}
 		#tbCinemaDate {
 			width: 40%;
 			border-style: none;
 			text-align: left;
 		}
 		#tbCinemaDate td {
 			border-style: none;
 			text-align: right;
 		}
 		#tbCinemaDate td:first {
 			width: 50px;
 		}
 		#tbTimetable {
 			text-align: left;
 		}
 		#tbTimetable td {
 			padding-left: 20px;
 		}
 		
 		
/*  		/* Set height of the grid so .sidenav can be 100% (adjust if needed) */ */
/* /*     .row.content {height: 1500px} */ */
    
/*     /* Set gray background color and 100% height */ */
/*     .sidenav { */
/*       background-color: #f1f1f1; */
/*       height: 100%; */
/*     } */
    
/*     /* Set black background color, white text and some padding */ */
/*     footer { */
/*       background-color: #555; */
/*       color: white; */
/*       padding: 15px; */
/*     } */
    
/*     /* On small screens, set height to 'auto' for sidenav and grid */ */
/*     @media screen and (max-width: 767px) { */
/*       .sidenav { */
/*         height: auto; */
/*         padding: 15px; */
/*       } */
/*       .row.content {height: auto;}  */
/*     } */
/*     #menu{ */
/*     	background-color: black; */
/*     	color: white; */
    	
/*     } */
    
/*     .list-group-item{ */
/*     	color: black; */
/*     } */
/*     .list-group-item:hover{ */
/*     	color: black; */
/*     	background-color: #969696; */
/*     } */
    
/*     #select li a{ */
/*     	color: white; */
    	
/*     } */
/*     #select li a:link { */
/* 			text-decoration: none; */
/* 			color: white; */
/* 			background-color: black; */
/* 	} */
/* 	#select li a:hover { */
/* 			text-decoration: underline; */
/* 			color: black;  */
/*  			background-color: #FF1212; */
/*  	}  */
 	
 	
 	
 	
	.dropdown-menu{
		color: black;
		background-color: #696969;
	}
	#title-select a{
			text-decoration: none;
			color: black;
	}
	#title-select li:hover {
			text-decoration: underline;
			color: black; 
 			background-color: #969696;
 	}
 		
	</style>
	<script type="text/javascript">
		
		var ticketing = "/TicketingProject/jsp/member/ticketing/ticketingMovie.jsp";
	
		$(document).ready(function() {
			
			$("#menu").css({
				"padding-top": "100px"
// 				,"padding-bottom": "200px"
	 			,"margin-left": "140px"
			});
			
			$("select").each(function(idx, ele){
				
				console.log("this");
				console.log(this);
				$(this).change(function(){
					console.log("ele");					
	 				console.log(ele);					
					console.log($(this).val());
					
					if(		$("select").eq(0).val() != "극장" && $("select").eq(0).val() != ""
						 && $("select").eq(1).val() != "상영일자" && $("select").eq(1).val() != "") {
						
						console.log("축 성공 ---------------");
						console.log($("select").eq(0).val());
						console.log($("select").eq(1).val());
						console.log("---------------------");
						
						var param = {
								cinemaCd : $("select").eq(0).val()
								, showDate : $("select").eq(1).val()
						};
						
						console.log(param);
						
	 					$.ajax({
		 					url: "/TicketingProject/admin/showtimetable.do"
		 					, data: param
		 					, type: "post"
		 					, dataType: "json"
		 					, success: function(data) {
		 						console.log(data);
		 						makeTable(data);
		 					}
		 					, error: function(xhr) {
		 						console.log(xhr);
		 						alert("오류가 발생했습니다. 관리자에게 문의하세요.");
		 					}
	 	 				});
						
					}
					
				});
				
			});
			
			
		}); /* .ready(function(){}) */
		
		function makeTable(data) {
			$("#tbTimetable tbody").empty();
			
			var str = "";
			if(data.length != 0) {
				
				//받아온 데이터 배열에서 중복 영화명 제거
				var mvName = new Array();
				var mvStart = new Array();
				var j = 0;
				
				//데이터가 1개일 경우
				if(data.length == 1) {
					mvName[0] = data[0].mvNameKor;
					mvStart[0] = data[0].showStartTime;
					
				}else {
					var i;
					for(i = 0; i < data.length - 1; i++) {
						
						//현재 mvCd와 다음 mvCd가 다를 때, 현재 mvCd 별도 저장
						if(data[i].mvCd != data[i+1].mvCd) {
							mvName[j++] = data[i].mvNameKor;
						}
						
// 						//i가 data배열의 제일 마지막 데이터일 때 
						if(i == data.length - 1) { //-1, -2 데이터에 따라 상영시간표 결과가 맞기도 하고, 틀리기도 하다.
						
							if(data[i].mvNameKor != mvName[j]) {								
								mvName[j++] = data[i].mvNameKor;								
							}
							
						}
												
					}
				}
				console.log("-- mvName --");
				console.log(mvName);
				
				//나중에 우리 예매 사이트 주소로 변경
// 				var ticketingLink = "https://movie.naver.com/movie/bi/ti/running.nhn?code=732&sdate=2021-06-22"; 
				
				
				// 영화명 중복을 없앤 데이터 배열에서, 영화에 따라 상영시간표 값 저장
				for(var i=0 ; i<mvName.length; i++) {
					
					str +=
						  "<tr>                                   "
						+ "	<td>"+ mvName[i] +"</td>              "
						+ "	<td>                                  "
					
					var j = 0;
					while(j <= data.length-1) {
						if(mvName[i] == data[j].mvNameKor) {
							str += "&nbsp;&nbsp;<a href='"+ ticketing +"'>" + data[j].showStartTime + "</a>&nbsp;&nbsp;|"
						}
						j++;
					}
					str = str.substr(0,str.length-1);
					
					console.log("str");
					console.log(str);
					
					str += "</td>"
						+ "</tr>"

				} //for문
				
			} else {
				console.log("else data");
				console.log(data);
				
				str = "<tr>"
					+	"<td colspan='2' style='text-align: center'>조회된 결과가 없습니다.</td>"
					+ "</tr>";	
			}
			
			$("#tbTimetable tbody").append(str);
		}
		
	</script>
</head>	

<body>
	<%@include file="../../common/header.jsp" %>
	<%@include file="/jsp/admin/adminMainBody.jsp" %>
	<div class="container-fluid">
	  <div class="row content">

	    <div class="col-sm-9">
	    	<div class="ticketing-container">
<!-- 				<div class="ticketing"> -->
<!-- 					<h1>상영시간표</h1> -->
<!-- 				</div> -->
				<div class="ticketing-movie" style="margin-left: 0">
					<h2><span>▶</span> 상영영화 시간표</h2>
					<hr>
					<div>
						<table id="tbCinemaDate">
							<tr>
								<td><h6>극장정보</h6></td>
								<td>
									<select id="selCinema">
										<option value="">극장</option>
										<option value="CN001">대전 가수원점</option>
										<option value="CN002">대전 유성점</option>
									</select>
								</td>
								<td><h6>상영일자</h6></td>
								<td>
									<select id="selDate">
										<option value="">상영일자</option>
										<option value="2021.06.22 (화)">2021.06.22 (화)</option>
										<option value="2021.06.23 (수)">2021.06.23 (수)</option>
										<option value="2021.06.24 (목)">2021.06.24 (목)</option>
										<option value="2021.06.25 (금)">2021.06.25 (금)</option>
										<option value="2021.06.26 (토)">2021.06.26 (토)</option>
										<option value="2021.06.27 (일)">2021.06.27 (일)</option>
										<option value="2021.06.28 (월)">2021.06.28 (월)</option>
										<option value="2021.06.29 (화)">2021.06.29 (화)</option>
									</select>
								</td>
							</tr>
						</table>
						<table id="tbTimetable">
							<thead>
								<tr>
									<td>상영영화</td>
									<td>상영시간표</td>
								</tr>
							</thead>
							<!-- tbody 시작 -->
							<tbody>
								<!-- 상영시간표 데이터를 읽어와서 tbody에 행 생성 -->
							</tbody>
							<!-- tbody 끝 -->
						</table>
					</div>	
				</div>
				<!-- ticketing movie -->
			</div> 
		</div> <!-- col-sm-9 -->
	</div>
	</div>
	<%@include file="../../common/footer.jsp" %>
</body>
</html>
