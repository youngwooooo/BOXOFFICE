<%@page import="common.vo.PostVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
    <%
    	PostVO postVO = (PostVO)request.getAttribute("postVO")==null?null:(PostVO)request.getAttribute("postVO");
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="./jquery-3.6.0.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<style type="text/css">
	
	#title, #table{
		position: static;
		margin-left: 22%;
			
	}
	
	table, th, td {
  		
  		border-bottom: 1px solid gray;
  		border-top:  1px solid gray;
  		border-collapse: collapse;
	}
	
	table{
		width: 70%;
	}
	
	th{
		padding: 5px;
		width: 25%;
		text-align: center;
		background-color: #f5f5f5;
	}
	
	td{
		padding: 5px;
  		text-align: left;
		widows: 75%;
	}
	
	thead{
		background-color: black;
		color: white;
	}
	
	#content{
		height: 150px;
	}
	
	.glyphicon-ok{
		color: green;
	}
	
	#btn{
		margin-left: 62%;
	}
	a{
	 	color: black;
	}
	
	a:hover{
		color: black;
	}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@include file="../../common/header.jsp" %>
	<br><br><br><br><br>
	<form method="post" enctype="multipart/form-date" action="<%=request.getContextPath() %>/admin/detailEvent.do">
			<div id="title">
				<h4>공지사항</h4>
			</div>
<% %>
			<div id="table">
				<table>
					<tr>
						<th><span class="glyphicon glyphicon-ok"></span> POST CODE:</th>
						<td><%=postVO.getPostCd() %></td>
					</tr>
					<tr>
						<th><span class="glyphicon glyphicon-ok"></span> 공지 제목:</th>
						<td><%=postVO.getPostTitle() %></td>
					</tr>
					<tr id="content">
						<th><span class="glyphicon glyphicon-ok"></span> 공지 내용:</th>
						<td><%=postVO.getPostContent() %></td>
					</tr>
					<tr>
						<th><span class="glyphicon glyphicon-ok"></span> 게시일:</th>
						<td><%=postVO.getPostDate() %></td>
					</tr>
				</table>
			</div>
			<br><br>
			<div id="btn">
				<a href="updateEvent.do?postCd=<%=postVO.getPostCd()%>"><button type="button" id=updateNT><span class="glyphicon glyphicon-pencil"></span>수정</button></a>
				<a href="deleteEvent.do?postCd=<%=postVO.getPostCd()%>"><button type="button" id=deleteNT><span class="glyphicon glyphicon-trash"></span>삭제</button></a>
				<a href="mainBoard2.do"><button type="button" id=backBoard><span class="glyphicon glyphicon-tasks"></span>목록</button></a>
			</div>
		</form>
		<br><br><br>
	<%@include file="../../common/footer.jsp" %>
</body>
</html>