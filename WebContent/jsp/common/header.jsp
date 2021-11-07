<%@page import="common.vo.LoginVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	LoginVO loginVO = session.getAttribute("loginVO") == null? null : (LoginVO)session.getAttribute("loginVO");
	String managerChk = "";
	
	if(loginVO != null) {
		managerChk = loginVO.getManagerYn();
	}
	
	String main = "/TicketingProject/jsp/common/main.jsp";
	String movie = "/TicketingProject/member/movielist.do";
	String ticketing = "/TicketingProject/member/setTicketingMain.do";
	String product = "/TicketingProject/member/product/memberProductList.do";

// 	String mypage = "/TicketingProject/jsp/member/mypage/mypage.jsp";
	String mypage = "/TicketingProject/member/updateMemberInfo.do";
	String signIn = "/TicketingProject/jsp/member/signIn/signInPage.jsp";
	String signOut = "/TicketingProject/member/signOut.do";
	String signUp = "/TicketingProject/jsp/common/signUp/signUp.jsp";
	String notice = "/TicketingProject/member/notice.do";
	String qna = "/TicketingProject/jsp/member/board/questionsBoard.jsp";
	
	String admin = "/TicketingProject/admin/memberList.do";
	
%>

    <!-- css -->
    <link rel="stylesheet" href="<%=request.getContextPath() %>/css/common/main/reset.css">
    <link rel="stylesheet" href="<%=request.getContextPath() %>/css/common/main/style.css?v=1">
    <link rel="stylesheet" href="<%=request.getContextPath() %>/css/common/main/swiper.css">
    <link rel="stylesheet" href="<%=request.getContextPath() %>/css/member/ticketing/ticketing.css">

    <!-- 웹 폰트 -->
    <link href="https://fonts.googleapis.com/css?family=Noto+Sans+KR:100,300,400,500,700,900&amp;subset=korean" rel="stylesheet">
    
    <header id="header">
        <div class="container">
            <div class="row">
                <div class="header clearfix">
                    <h1>
						<a href=<%=main %>><strong>한 편의 영화로 만드는 행복,<em>BOXOFFICE</em></strong></a>  
                    </h1>
                    <nav id="mNav">
                        <h2 class="ir_so">박스오피스 전체메뉴</h2>
                        <a href="#" class="ham"><span></span></a>
                    </nav>
                    <nav class="nav">
                        <ul class="clearfix">
<%--                             <li id="nav_movie"><a href="<%=movie %>">영화</a></li> --%>
                            <li id="nav_ticketing"><a href="<%=ticketing %>">예매</a></li>
                            <li id="nav_product"><a href="<%=product %>">스낵</a></li>
                            <li id="nav_board"><a href="<%=notice %>">소식</a></li>
                            <li id="nav_qna"><a href="<%=qna %>">문의</a></li>
                    <% if(loginVO == null) { %>
                            <li id="nav_sign_up"><a href="<%=signUp %>">회원가입</a></li>
                            <li id="nav_sign_in"><a href="<%=signIn %>">LOGIN</a></li>
                    <% } %>
                    <% if(loginVO != null) { %> 
                    		<% if(managerChk.equals("Y")) { %>
                            <li id="nav_manage"><a href="<%=admin %>">관리</a></li>
                    		<% } %>
                    		
                    		<% if(managerChk.equals("N")) { %>
                    		<li id="nav_manage"><a href="<%=mypage %>">마이페이지</a></li>
                    		<% } %>
                    		
                    		<li id="nav_sign_out"><a href="<%=signOut %>">로그아웃</a></li>
                    <% } %>
                        </ul>
                    </nav>    
                </div>
            </div>
        </div>
    </header>
    <!-- //header -->