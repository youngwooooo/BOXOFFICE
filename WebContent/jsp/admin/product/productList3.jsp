<%@page import="common.vo.ProductVO"%>
<%@page import="common.vo.PagingVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	List<ProductVO> productList = (List)request.getAttribute("productList");
	PagingVO pagingVO = (PagingVO)request.getAttribute("pagingVO");
%>    

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- html 화면 -->
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<!-- 부트스트랩 -->
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
	<!-- 탭 명 -->
	<title>박스오피스 | 상품 관리</title>
	<style type="text/css">
		#wrap_admin_seat_manage {
			width: 1000px;
			margin-left: calc((100% - 1000px) / 2);
			display: flex;
			flex-flow: row nowrap;
		}
		.title span {
			font-size: 1.5rem;
			font-size: 24px; font-weight: bold;
			margin-left: 20px;
		}
		hr {
			width: 100%;
		}
		.btn_box_table {
			margin-top:	50px;
		}
		.btn_box_save {
			display: flex;
			width: 100%;
			justify-content: center;
		}
		.btn_box_save button {
			width: 50px;
			margin-right: 10px;
		}
		.table_seat {
			margin-top: 10px;
		}
		th, td {
			text-align: center;
		}
		td {
			width: calc(100% / 7);
		}
		
	</style>
	<script type="text/javascript">
	
	
	$(document).ready(function() {
		
		$("#menu").css({
			"padding-top": "90px"
// 			,"padding-bottom": "200px"
			,"margin-left": "140px"
		});
		
// 		$("th:first").css("padding-left", "4.3%");
	});
	
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
	<%@include file="/jsp/admin/adminMainBody.jsp" %>
	
	<div id="wrap_admin_seat_manage">
		<div class="container" style="margin-top: 100px">
			<h2 class="title">상품 관리</h2>
			<hr>
			<form>
				<table id="table_seat" class="table table-hover table-striped table_seat">
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
			</form>
			<form id="table_seat_check">
				<input id="table_changed_check" type="hidden" value="unchanged">
			</form>
<!-- 			<div class="btn_box_table"> -->
<!-- 			</div> -->
			<hr>
			<div class="btn_box_save">
				<button type="button" class="btn btn-danger btn-sm" onclick="addRow()">＋</button>
				<button type="button" class="btn btn-danger btn-sm" onclick="removeRows()">－</button>
				<button type="button" class="btn btn-danger" onclick="saveTable()">저장</button>
			</div>
		</div>
	</div>
	<%@include file="../../common/footer.jsp" %>
</body>
</html>