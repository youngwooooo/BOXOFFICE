<%@page import="common.vo.PagingVO"%>
<%@page import="common.vo.PostVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	List<PostVO> BoardList = (List<PostVO>)request.getAttribute("boardList");
	
	PagingVO pagingVO = (PagingVO)request.getAttribute("pagingVO");
%>    
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	
	<!-- 부트스트랩 -->
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
	
	<!-- 탭 명 -->
	<title>박스오피스 | 공지사항 페이지</title>
	<style type="text/css">
		#wrap_admin_seat_manage {
			width: 1000px;
			margin-left: calc((100% - 1000px) / 2);
			display: flex;
			flex-flow: row nowrap;
		}
		.title span {
			font-size: 1.5rem;
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
		.table_seat {
			margin-top: 10px;
		}
		a:link, a:visited {
 			text-decoration: none;
 			color: black;
 		}
 		#btn{
			float: right;
			margin-top: 20px;
			margin-bottom: 100px;
		}
		button {
			width: 120px;
			height: 50px;
			margin-right: 50px;
		}
	</style>
	<script type="text/javascript">
	
		$(document).ready(function(){
			
			$("td").css({			"font-size": "16px" });
			$("button").css({			"font-size": "16px" });
			$("th:nth-child(4n)").css({
				"text-align": "center"
			});
			$("td:nth-child(4n)").css({
				"text-align": "center"
			});
			$("#menu").css({
				"padding-top": "90px"
				,"padding-bottom": "200px"
				,"margin-left": "140px"
			});
		});
		
		function callHandler(button) {
			if(button.id == "insertNT") {
				window.location.href = 'insertNotice.do';
			}
		}
	</script>
</head>
<body>
	<%@include file="../../common/header.jsp" %>
<%-- 	<%@include file="/jsp/admin/adminMainHead.jsp" %> --%>
	<%@include file="/jsp/admin/adminMainBody.jsp" %>
<!-- <div class="container-fluid"> -->
<!--   <div class="row content"> -->
<!--     <div class="col-sm-2 sidenav"> -->
<%-- <%--     <%@include file="../adminMainBody.jsp" %> --%> --%>
<!--     </div> -->
<!--     <div class="col-sm-9"> -->
	<div id="wrap_admin_seat_manage">
		<div class="container" style="margin-top: 100px">
			<h2 class="title" style="font-size: 30px">공지사항
			</h2>
			<hr>
			<form>
				<table id="table_seat" class="table table-hover table-striped table_seat">
					<thead>
						<tr>
							<th>구분</th>
							<th>제목</th>
							<th>작성일</th>
<!-- 							<th>조회수</th> -->
						</tr>
					</thead>
					<tbody>
					<%
						int boardSize = BoardList.size();
						
						if(boardSize > 0){
							for(int i=0; i<boardSize; i++){
						%>			
						<tr>
							<td id="name"><%=BoardList.get(i).getBoardName() %></td>
							<td><a href="detailNotice.do?postCd=<%=BoardList.get(i).getPostCd()%>"><%=BoardList.get(i).getPostTitle()%></a></td>
							<td><%=BoardList.get(i).getPostDate()%></td>
<%-- 							<td><%=BoardList.get(i).getPostView() %></td> --%>
						</tr>	
						<%
							}
							
						}else{
						%>	
						<tr>
							<td colspan="4">조회된 내용이 없습니다.</td>
						</tr>
						<%		
						}
					%>
					</tbody>
				</table>
			</form>
			<hr>
			<div id="btn">
				<a href="insertNotice.do"><button type="submit" id=insertNT class="btn btn-danger">
				<span class="glyphicon glyphicon-pencil"></span>&nbsp;&nbsp;공지 등록</button></a>
			</div>
		</div>
		</div>
<!-- 		</div> -->
<!-- 		</div> -->
<!-- 		</div> -->
		<%@include file="../../common/footer.jsp" %>
</body>
</html>