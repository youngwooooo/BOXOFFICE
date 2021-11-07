<%@page import="common.vo.ProductVO"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="common.vo.PagingVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	List<ProductVO> productList = (List)request.getAttribute("productList");
	PagingVO pagingVO = (PagingVO)request.getAttribute("pagingVO");
%>    
<!DOCTYPE html>
<html lang="ko">
<head>
  <title>박스오피스 | 상품 관리</title>
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
    
    #productTable a:hover {
    	background-color: lightgray;
    }
    
    
     #productInsert button {
     	border: 1px solid black;
     	background-color: black;
     	color : white;
     	width: 100px;
     	height: 30px;
     	border-radius: 30px;
     	margin-bottom: 20px;
     	float: right;
     }
     
     .table-responsive {clear: both;}
  </style>
  <script type="text/javascript">
  	$(function(){
  		var memberManagement = $("ul > li");
  		memberManagement.find("a").click(function(){
  			memberManagement.removeClass("active");
  			$(this).parent().addClass("active");
  		});
  		
  		
  	});
  	
  	
  	function productInset(){
  		location.href = "/TicketingProject/jsp/admin/product/productInsert.jsp";
  	}
  	
  	
  	function productDelete(){
  		var val = $("[name=checkBox]:checked").val();
  		location.href = "productDelete.do?prodCd=" + val;
  	}
  </script> 
</head>
<body>
    <%@include file="../../common/header.jsp" %>
<div class="container-fluid" style="padding-left: 0px;">
  <div class="row content">
    <div class="col-sm-2 sidenav" style="margin-top: 50px; height: 1000px;">
	<%@include file="/jsp/admin/adminMainBody.jsp" %>
<!--       <h4>관리자 페이지</h4> -->
<!--       <ul class="nav nav-pills nav-stacked"> -->
<!--         <li class="active"><a href="/TicketingProject/admin/memberList.do">회원 관리</a></li> -->
<!--         <li><a href="#">영화 관리</a></li> -->
<!--         <li><a href="/TicketingProject/jsp/admin/movieRating/movieRating.jsp">영화등급 관리</a></li> -->
<!--         <li><a href="#">상영 관리</a></li> -->
<!--         <li><a href="#">영화관 관리</a></li> -->
<!--         <li><a href="/TicketingProject/jsp/admin/seat/seat.jsp">좌석관리</a></li> -->
<!--         <li><a href="#">지점 관리</a></li> -->
<!--         <li><a href="/TicketingProject/admin/mainBoard.do">공지사항 관리</a></li> -->
<!--         <li><a href="/TicketingProject/admin/mainBoard2.do">이벤트 관리</a></li> -->
<!--         <li><a href="/TicketingProject/jsp/admin/charge/charge.jsp">요금 관리</a></li> -->
<!--         <li><a href="/TicketingProject/jsp/admin/showTimetable/showTimetable2.jsp"></a>상영시간표 관리</li> -->
<!--         <li><a href="/TicketingProject/jsp/admin/audience/audience.jsp">관람객 관리</a></li> -->
<!--       </ul><br> -->
<!--     </div>  -->
</div>
    <div class="col-sm-10" style="margin-top: 52px;">
       <h1 class="h3 mb-2 text-gray-800">상품 목록</h1>
       	<hr>
       	<div id="productInsert">
       			<button type="button" onclick="productDelete()">삭제</button>
	       		<button type="button" onclick="productInset()" style="margin-right: 5px;">등록</button>
	       		
       	</div>
            <div class="table-responsive">
                <table class="table table-bordered" id="productTable" width="100%" cellspacing="0">
                <col width="80px;">
                	<col width="110px;">
                	<col width="80px;">
                	<col width="120px;">
                	<col width="auto;">
                	<col width="100px;">
                	<col width="120px;">
                    <thead>
                        <tr>
                        	<th>구분</th>
                            <th>상품타입코드</th>
                            <th>상품코드</th>
                            <th>상품이름</th>
                            <th>상품설명</th>
                            <th>상품가격</th>
                            <th>상품이미지파일</th>
                        </tr>
                    </thead>
                    <tbody>
                    <!-- 상품 목록 조회 -->
                    
                    <%
                    	int productListSize = productList.size();
                    	if(productListSize > 0){
                    		for(int i=0; i<productListSize; i++){
                    %>
                        <tr>
                        	<td><input type="checkbox" name="checkBox" value=<%= productList.get(i).getProdCd()%>></td>
                            <td><%= productList.get(i).getProdTypeCd()%></td>
                            <td><%= productList.get(i).getProdCd()%></a></td>
                            <td><%= productList.get(i).getProdName()%></td>
                            <td><%= productList.get(i).getProdDesc()%></td>
                            <td><%= productList.get(i).getProdPrice()%></td>
                            <td><%= productList.get(i).getAtchFileCd()%></td>
                        </tr>
                     <%
                    	}
                     %>
                      <!-- 회원 목록 조회 끝-->
                     
                    <% 		
                    	}else{
                     %>
                     <tr>
                     	<td colspan="7" align="center">상품정보가 존재하지 않습니다.</td>
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
<%@include file="../../common/footer.jsp" %>
</body>
</html>