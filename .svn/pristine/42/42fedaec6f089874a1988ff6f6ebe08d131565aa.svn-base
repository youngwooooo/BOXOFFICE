<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
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
     
	<aside class="container col-sm-2 sidenav" id="menu" style="width: 250px">
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
					<li><a href="<%=adminMovie %>">영화 정보</a></li>
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
					<li><a href="<%=adminProduct %>">간식</a></li>
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
