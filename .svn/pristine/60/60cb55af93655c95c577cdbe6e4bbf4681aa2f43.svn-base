<%@page import="common.vo.PostVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	PostVO postVO = (PostVO)request.getAttribute("postVO")==null?null:(PostVO)request.getAttribute("postVO");
   		String str = postVO.getPostContent().replaceAll("\r\n", "<br>");
    	postVO.setPostContent(str);
    %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<style type="text/css">

	* {
		font-size: 17px;
	}
	
	table, th, td {
  		
  		border-bottom: 1px solid gray;
  		border-top:  1px solid gray;
  		border-collapse: collapse;
	}
	tr {
		height: 70px;
	}
	
	table{
		width: 100%;
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
/* 		margin-left: 62%; */
		float: right;
		margin-top: 20px;
	}
	button {
		width: 90px;
		height: 40px;
		margin-right: 50px;
	}
	a{
	 	color: black;
	}
	
	a:hover{
		color: black;
	}
	#table {
		margin-top: 20px;
		margin-bottom: 60px;
	}
	#divPage {
		margin-top: 95px;
		margin-bottom: 100px;
		margin-left: 22%;
		margin-right: 22%;
	}
	
	td:nth-of-type(odd) {
	    padding-left: 40px;
	}
	
</style>
<script type="text/javascript" defer>

/*
	https://localhost/TicketingProject/admin/mainBoard.do

 */
 
	function callHandler(button) {
		
		if(button.id == "backBoard") {
			window.location.href = 'notice.do';
		}
		
	}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>박스오피스 | 공지사항 상세 페이지</title>
</head>
<body>
<%@include file="../../common/header.jsp" %>
	<div id="divPage">
	<form method="post" enctype="multipart/form-date" action="<%=request.getContextPath() %>/admin/detailNotice.do">
			<div id="title">
				<h2 style="font-size: 30px">공지사항</h2>
			</div>
			<div id="table">
				<table>
<!-- 					<tr> -->
<!-- 						<th>POST CODE</th> -->
<%-- 						<td><%=postVO.getPostCd() %></td> --%>
<!-- 					</tr> -->
					<tr>
						<th>공지 제목</th>
						<td><%=postVO.getPostTitle() %></td>
					</tr>
					<tr id="content">
						<th>공지 내용</th>
						<td style="padding-top: 25px; padding-bottom: 25px; padding-right: 40px;"><%=postVO.getPostContent() %></td>
					</tr>
					<tr>
						<th>게시일</th>
						<td><%=postVO.getPostDate() %></td>
					</tr>
				</table>
			<div id="btn">
<!-- 				<button type="button" id="updateNT" onclick="callHandler(this)" class="btn btn-danger" style="margin-right: 10px"><span class="glyphicon glyphicon-pencil"></span>&nbsp;수정</button></a> -->
<!-- 				<button type="button" id="deleteNT" onclick="callHandler(this)" class="btn btn-danger" style="margin-right: 10px"><span class="glyphicon glyphicon-trash"></span>&nbsp;삭제</button></a> -->
				<button type="button" id="backBoard" onclick="callHandler(this)" class="btn btn-danger"><span class="glyphicon glyphicon-tasks"></span>&nbsp;목록</button></a>
			</div>
			</div>
		</form>
	</div>
	<%@include file="../../common/footer.jsp" %>
</body>
</html>