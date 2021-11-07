<%@page import="common.vo.PostVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	PostVO postVO = (PostVO)request.getAttribute("postVO")==null?null:(PostVO)request.getAttribute("postVO");
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
	https://localhost/TicketingProject/admin/mainBoard2.do

 */
 
	function callHandler(button) {
		
		if(button.id == "updateEV") {
			window.location.href = 'updateEvent.do?postCd=<%=postVO.getPostCd()%>';
			
		}else if(button.id == "deleteEV") {
			if(!confirm("이벤트를 삭제하시겠습니까?")) {
				return;
			}else {
				window.location.href = 'deleteEvent.do?postCd=<%=postVO.getPostCd()%>';			
			}
			
		}else if(button.id == "backBoard") {
			window.location.href = 'mainBoard2.do';
		}
		
	}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>박스오피스 | 이벤트 상세 페이지</title>
</head>
<body>
<%@include file="../../common/header.jsp" %>
	<div id="divPage">
	<form method="post" enctype="multipart/form-date" action="<%=request.getContextPath() %>/admin/detailEvent.do">
			<div id="title">
				<h2 style="font-size: 30px">이벤트</h2>
			</div>
			<div id="table">
				<table>
					<tr>
						<th><%=postVO.getPostDate() %></th>
						<td><%=postVO.getPostTitle() %></td>
					</tr>
					<tr id="content">
						<%
							String imgSrc = request.getContextPath() + "/images/common/event/"+ "ev_super_matcha.jpg";
						%>
						<td colspan="2" style="padding: 0"><img id="atch" alt="이벤트" src="<%=imgSrc %>" ></td>
					</tr>
				</table>
			<div id="btn">
<%-- 				<a href="updateEvent.do?postCd=<%=postVO.getPostCd()%>"><button type="button" id=updateNT><span class="glyphicon glyphicon-pencil"></span>수정</button></a> --%>
<%-- 				<a href="deleteEvent.do?postCd=<%=postVO.getPostCd()%>"><button type="button" id=deleteNT><span class="glyphicon glyphicon-trash"></span>삭제</button></a> --%>
<!-- 				<a href="mainBoard2.do"><button type="button" id=backBoard><span class="glyphicon glyphicon-tasks"></span>목록</button></a> -->		
				<button type="button" id="updateEV" onclick="callHandler(this)" class="btn btn-danger" style="margin-right: 10px"><span class="glyphicon glyphicon-pencil"></span>&nbsp;수정</button></a>
				<button type="button" id="deleteEV" onclick="callHandler(this)" class="btn btn-danger" style="margin-right: 10px"><span class="glyphicon glyphicon-trash"></span>&nbsp;삭제</button></a>
				<button type="button" id="backBoard" onclick="callHandler(this)" class="btn btn-danger"><span class="glyphicon glyphicon-tasks"></span>&nbsp;목록</button></a>
			</div>
			</div>
		</form>
		</div>
	<%@include file="../../common/footer.jsp" %>
</body>
</html>