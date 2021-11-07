<%@page import="java.text.SimpleDateFormat"%>
<%@page import="common.vo.PagingVO"%>
<%@page import="common.vo.MemberVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	List<MemberVO> memList = (List<MemberVO>)request.getAttribute("memList");
	PagingVO pagingVO = (PagingVO)request.getAttribute("pagingVO");
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
%>    
<!DOCTYPE html>
<html lang="ko">
<head>
  <title>박스오피스 | 회원 관리</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <style>
    /* Set height of the grid so .sidenav can be 100% (adjust if needed) */
    .row.content {height: 1500px}
    
    /* Set gray background color and 100% height */
    .sidenav {
      background-color: #f1f1f1;
      height: 100%;
    }
    
    /* Set black background color, white text and some padding */
    footer {
      background-color: #555;
      color: white;
      padding: 15px;
    }
    
    /* On small screens, set height to 'auto' for sidenav and grid */
    @media screen and (max-width: 767px) {
      .sidenav {
        height: auto;
        padding: 15px;
      }
      .row.content {height: auto;} 
    }
    
    #memberTable a:hover {
    	background-color: lightgray;
    }
    
    #memberSerach {
    	text-align: center;
    	margin-bottom: 20px;
    }
    
    #searchVal {
    	margin-left: 10px;
    	margin-right: 10px;
    }
    
     #memberSerach button {
     	border: 1px solid black;
     	background-color: black;
     	color : white;
     	width: 100px;
     	height: 30px;
     	border-radius: 30px;
     }
  </style>
  <script type="text/javascript">
  	$(function(){
  		var memberManagement = $("ul > li");
  		memberManagement.find("a").click(function(){
  			memberManagement.removeClass("active");
  			$(this).parent().addClass("active");
  		});
  		
  		
  	});
  	
  	
  	function memberSerach(){
  		if($("[name=search]:checked").val() == null){
  			alert("검색 기준을 선택해주세요.");
  			return;
  		}
  		
  		var param = {
  						search : $("[name=search]:checked").val()
  						, searchVal : $("#searchVal").val()
  		};
  		console.log(param);
  		 
  		$.ajax({
  			url : "/TicketingProject/admin/memberSearched.do"
  			, data : param
  			, type : "post"
  			, dataType : "json"
  			, success : function(data){
//   				alert("성공!");
  				console.log(data);
  				SearchedMember(data);
  			}
  			, error : function(xhr){
  				alert("오류가 발생했습니다. 담당 관리자에게 문의하세요.");
  				console.log(xhr);
  			}
  			
  		});
  	}
  	
  	function SearchedMember(data){
  		$("#memberTable tbody").empty();
  		
  		var strHtml = "";
  		
  		if(data.length > 0){
  			for(var i=0; i<data.length; i++){
  				console.log(data[i].rowNum);
  				strHtml += "<tr>"
  							+ "<td>" + data[i].rowNum + "</td>"
  							+ "<td>" + data[i].memCd + "</td>"
  							+ "<td>" + data[i].memId + "</td>"
  							+ "<td>" + data[i].memName + "</td>"
  							+ "<td>" + data[i].memBir + "</td>"
  							+ "<td>" + data[i].msName + "</td>"
  							+ "<td>" + data[i].memHp + "</td>"
  							+ "<td>" + data[i].memMail+ "</td>"
  							+ "<td>" + data[i].joinDate + "</td>"
  							+ "<td>" + data[i].managerYn + "</td>"
  							+ "</tr>";
  			}
  			
  		}else {
  			strHtml += "<tr>"
  						+ "<td colspan='10' style='text-align:center;'>검색 결과가 존재하지 않습니다.</td>"
  						+ "</tr>";
  		}
  		console.log(strHtml);
  		$("#memberTable tbody").append(strHtml);
  				
  	}
  	
  	function memberDetail(obj){
  		var param = { memId : $(obj).text()};
  		console.log(param);
  		
  		$.ajax({
  			url : "/TicketingProject/admin/memberDetail.do"
  	  			, data : param
  	  			, type : "post"
  	  			, dataType : "json"
  	  			, success : function(data){
//   	  				alert("성공!");
  	  				console.log(data);
  	  				DetailedMember(data);
  	  			}
  	  			, error : function(xhr){
					alert("오류가 발생했습니다. 담당 관리자에게 문의하세요.");
  	  				console.log(xhr);
  	  			}	
  		});
  	}
  	
  	function DetailedMember(data){
  		$("#addrTb tbody").empty;
  		
		var strHtml = "";
  		
  		if(data.length > 0){
  			for(var i=0; i<data.length; i++){
  				if(data[i].cdName == "null"){
  					data[i].cdName = "없음";
  				}
  				strHtml += "<tr>"
  							+ "<th>회원코드<th>"
  							+ "<td>" + data[i].memCd + "</td>"
  							+ "</tr>"
  							+ "<tr>"
  							+ "<th>아이디</th>"
  							+ "<td>" + data[i].memId + "</td>"
  							+ "</tr>"
  							+ "<tr>"
  							+ "<th>이름</th>"
  							+ "<td>" + data[i].memName + "</td>"
  							+ "</tr>"
  							+ "<tr>"
  							+ "<th>생년월일<th>"
  							+ "<td>" + data[i].memBir + "</td>"
  							+ "</tr>"
  							+ "<tr>"
  							+ "<th>등급<th>"
  							+ "<td>" + data[i].MsName + "</td>"
  							+ "</tr>"
  							+ "<tr>"
  							+ "<th>마일리지<th>"
  							+ "<td>" + data[i].memMileage + "</td>"
  							+ "</tr>"
  							+ "<tr>"
  							+ "<th>휴대폰번호<th>"
  							+ "<td>" + data[i].memHp + "</td>"
  							+ "</tr>"
  							+ "<tr>"
  							+ "<th>이메일<th>"
  							+ "<td>" + data[i].memMail + "</td>"
  							+ "</tr>"
  							+ "<tr>"
  							+ "<th>선호장르<th>"
  							+ "<td>" + data[i].cdName + "</td>"
  							+ "</tr>"
  							+ "<tr>"
  							+ "<th>주소<th>"
  							+ "<td>" + data[i].memAddr + "</td>"
  							+ "</tr>"
  							+ "<tr>"
  							+ "<th>가입날짜<th>"
  							+ "<td>" + data[i].joinDate + "</td>"
  							+ "</tr>"
  							+ "<tr>"
  							+ "<th>관리자여부<th>"
  							+ "<td>" + data[i].manageYn + "</td>"
  							+ "</tr>"
  							

  			}
  			
  		}
  		
  		$("#addrTb tbody").append(strHtml);
  	}
  	
  </script> 
</head>
<body>
<%@include file="../common/header.jsp" %>
<div class="container-fluid">
  <div class="row content" style="padding-left: 130px;">
    <div style="background-color: white;">
        <%
    	/* 관리자 페이지 jsp */
    	/* 폴더 이름 순으로 정렬 */
		String adminAudience = "/TicketingProject/jsp/admin/audience/audience.jsp";

    	String adminNotice = "/TicketingProject/admin/mainBoard.do";
    	String adminEvent = "/TicketingProject/admin/mainBoard2.do";
    	
    	String adminCategory = "/TicketingProject/jsp/admin/category/manageCategory.jsp";

    	String adminCharge = "/TicketingProject/jsp/admin/charge/charge.jsp";

    	String adminCinema = "/TicketingProject/jsp/admin/cinema/cinema.jsp";
    	String adminScreen = "/TicketingProject/jsp/admin/cinema/screen.jsp";
    	
    	String adminMember = "/TicketingProject/admin/memberList.do";
    	
    	String adminMovie = "/TicketingProject/admin/movielist.do";
    	
    	String adminMovieRating = "/TicketingProject/jsp/admin/movieRating/movieRating.jsp";
    	
    	String adminProduct = "http://localhost/TicketingProject/admin/product.do";
    	
    	String adminSeat = "/TicketingProject/jsp/admin/seat/seat.jsp";

    	String adminShowTimetable = "/TicketingProject/jsp/admin/showTimetable/showTimetable.jsp";

    	String adminTime = "/TicketingProject/jsp/admin/time/time.jsp";
    	
    	String adminSales = "/TicketingProject/jsp/admin/sales/sales.jsp";
    
    %>
<aside class="container col-sm-2 sidenav" id="menu" style="width: 250px; height: 1000px; background-color: white; margin-top: 80px;">
		<h4 style="margin-top: 30px;">관리 목록</h4>
		<hr>
		<div class="list-group nav nav-pills nav-stacked list-group" id="select">
			<div class="dropdown">
				<a href="<%=adminMember %>" class="list-group-item dropdown-toggle">회원 관리</a>
			</div>
			<div class="dropdown">
				<a href="#" class="list-group-item dropdown-toggle"
					data-toggle="dropdown">영화 관리</a>
				<ul class="dropdown-menu" style="width: 220px">
					<li><a href="<%=adminMovie %>">-영화 정보</a></li>
					<li><a href="<%=adminCategory %>">장르 카테고리</a></li>
				</ul>
			</div>
			<div class="dropdown">
				<a href="<%=adminMovieRating %>" class="list-group-item dropdown-toggle"
					>영화 관람 등급 관리</a>
			</div>
			<div class="dropdown">
				<a href="#" class="list-group-item dropdown-toggle"
					data-toggle="dropdown">상영 관리</a>
				<ul class="dropdown-menu" style="width: 220px">
					<li><a href="<%=adminShowTimetable %>">극장별 상영 시간표 조회</a></li>
					<li><a href="<%=adminTime %>">상영 시간대 유형 조회</a></li>
				</ul>
			</div>
			<div class="dropdown">
				<a href="#" class="list-group-item dropdown-toggle"
					data-toggle="dropdown">상품 관리</a>
				<ul class="dropdown-menu" style="width: 220px">
					<li><a href="<%=adminProduct %>">-간식</a></li>
				</ul>
			</div>
			<div class="dropdown">
				<a href="#" class="list-group-item dropdown-toggle"
					data-toggle="dropdown">지점 관리</a>
				<ul class="dropdown-menu" style="width: 220px">
					<li><a href="<%=adminCinema %>">극장 정보</a></li>
					<li><a href="<%=adminSeat %>">좌석 유형</a></li>
					<li><a href="<%=adminScreen %>">스크린 유형</a></li>
				</ul>
			</div>
			<div class="dropdown">
				<a href="#" class="list-group-item dropdown-toggle"
					data-toggle="dropdown">게시판 관리</a>
				<ul class="dropdown-menu" style="width: 220px">
					<li><a href="<%=adminNotice %>">공지</a></li>
					<li><a href="<%=adminEvent %>">이벤트</a></li>
				</ul>
			</div>
			<div class="dropdown">
				<a href="<%=adminCharge %>" class="list-group-item dropdown-toggle"
					>요금 관리</a>
			</div>
			<div class="dropdown">
				<a href="<%=adminSales %>" class="list-group-item dropdown-toggle">
					매출 관리
				</a>
			</div>
		</div>
	</aside>
</div>
    <div class="col-sm-10" style="margin-top: 83px; width: 1500px;">
       <h1 class="h3 mb-2 text-gray-800" style="font-size: 30px;">회원 목록</h1>
       	<hr>
       	<div id="memberSerach">
	       		<input class="serachOption" type="radio" id="memCd" name="search" value="memCd"><label for="memCd">회원코드</label>
				<input class="serachOption" type="radio" id="memId" name="search" value="memId"><label for="memId">회원아이디</label>
	       		<input id="searchVal" name="searchVal" type="text">
	       		<button type="button" onclick="memberSerach()">검색</button>
       	</div>
            <div class="table-responsive">
                <table class="table table-bordered" id="memberTable" width="100%" cellspacing="0">
                	<col width="50px;">
                	<col width="100px;">
                	<col width="200px;">
                	<col width="150px;">
                	<col width="150px;">
                	<col width="80px;">
                	<col width="200px;">
                	<col width="auto;">
                	<col width="200px;">
                	<col width="100px;">
                    <thead>
                        <tr>
                            <th>번호</th>
                            <th>회원코드</th>
                            <th>아이디</th>
                            <th>이름</th>
                            <th>생년월일</th>
                            <th>등급</th>
                            <th>휴대폰번호</th>
                            <th>이메일</th>
                            <th>가입날짜</th>
                            <th>관리자여부</th>
                        </tr>
                    </thead>
                    <tbody>
                    <!-- 회원 목록 조회 -->
                    
                    <%
                    	int memSize = memList.size();
                    	if(memSize > 0){
                    		for(int i=0; i<memSize; i++){
                    %>
                        <tr>
                            <td><%= memList.get(i).getRn() %></td>
                            <td><%= memList.get(i).getMemCd()%></td>
                            <td class="touch"><a href="#memberDetailModal" data-toggle="modal" onclick="memberDetail(this)" style="text-decoration: none; color: black;"><%= memList.get(i).getMemId()%></a></td>
                            <td><%= memList.get(i).getMemName()%></td>
                            <td><%= memList.get(i).getMemBir().substring(0, 10)%></td>
                            <td><%= memList.get(i).getMsName()%></td>
                            <td><%= memList.get(i).getMemHp()%></td>
                            <td><%= memList.get(i).getMemMail()%></td>
                            <td><%= sdf.format(memList.get(i).getJoinDate())%></td>
                            <td><%= memList.get(i).getManagerYn()%></td>
                        </tr>
                     <%
                    	}
                     %>
                      <!-- 회원 목록 조회 끝-->
                      
                     <!-- 페이징 처리 -->
                     
                     <tr>
                     	<td colspan="10" align="center">
                     		<% if(pagingVO.getFirstPageNo() > pagingVO.getPageSize()){ // %> 
								<a href="memberList.do?pageNo=<%= pagingVO.getFirstPageNo() - pagingVO.getPageSize() %>">[이전]</a>
							<% }  %>
							<% for(int pNo = pagingVO.getFirstPageNo(); pNo <= pagingVO.getLastPageNo(); pNo++){ %>
								<a <% if(pNo == pagingVO.getCurrentPageNo()){ %> style="color: orange;" <% } %> href="memberList.do?pageNo=<%= pNo %>">[<%= pNo %>]</a>
							<% } %>
							<% if(pagingVO.getLastPageNo() < pagingVO.getTotalPageCount()){ // 이전, 다음 판단을 할 수 있음 %> 
								<a href="memberList.do?pageNo=<%= pagingVO.getFirstPageNo() + pagingVO.getPageSize() %>">[다음]</a>
							<% }  %>
                     	</td>
                     </tr>
                     
                     <!-- 페이징 처리 끝 -->
                     
                    <% 		
                    	}else{
                     %>
                     <tr>
                     	<td colspan="10" align="center">회원정보가 존재하지 않습니다.</td>
                     </tr>
                     <%
                    	}
                     %>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>

<div class="modal fade" id="memberDetailModal" role="dialog">
    <div class="modal-dialog">
    	
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">회원정보 상세조회</h4>
        </div>
        <div class="modal-body">
        	<div>
        		<table id="addrTb" style="width : 100%;">
					<tbody>
					</tbody>        		
	        	</table>
        	</div>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">닫기</button>
        </div>
      </div>
    </div>
  </div>
  
<%@include file="../common/footer.jsp" %>

</body>
</html>