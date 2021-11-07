<%@page import="common.vo.PostVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	PostVO postVO = (PostVO)request.getAttribute("postVO");
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
		border: 
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
		margin-left: 71%;
	}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@include file="../../common/header.jsp" %>
	<br><br><br><br><br>	
	<form method="post" enctype="multipart/form-date" action="<%=request.getContextPath() %>/admin/updateEvent.do">
		<div id="title">
			<h4>이벤트</h4>
		</div>
		<div id="table">
		<table>
			<tr>
				<th><span class="glyphicon glyphicon-ok"></span> POST CODE:</th>
				<td>
					<textarea rows="1" class=col-sm-12 name="postCd"><%=postVO.getPostCd() %></textarea>
				</td>
			</tr>
			<tr>
				<th><span class="glyphicon glyphicon-ok"></span> 이벤트 명:</th>
				<td>
					<textarea rows="1" class=col-sm-12 name="postTitle"><%=postVO.getPostTitle() %></textarea>
				</td>
			</tr>
			<tr>
				<th><span class="glyphicon glyphicon-ok"></span> 이벤트 내용:</th>
				<td>
					<textarea rows="10" class=col-sm-12 name="postContent"><%=postVO.getPostContent() %></textarea>
				</td>
			</tr>
		</table>
		</div>
		<br>
		<div id="btn">
			<button type="submit"><span class="glyphicon glyphicon-floppy-saved"></span>저장</button>
		</div>
	</form>
	<br><br><br>
	<%@include file="../../common/footer.jsp" %>
</body>
</html>