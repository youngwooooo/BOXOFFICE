<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
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
		margin-left: 70%;
	}
</style>

<script type="text/javascript">
	
	$(document).ready(function(){
		
		$("#save").click(function(){
			if($("#code").val() != 'BD02'){
				alert('다시 입력해주세요');
				$("#code").focus();
				return false;
			}
		});
		
	});
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@include file="../../common/header.jsp" %>
	<br><br><br><br><br>	
	<form method="post" enctype="multipart/form-date" action="<%=request.getContextPath() %>/admin/insertEvent.do">
		<div id="title">
			<h4>이벤트</h4>
		</div>
		<div id="table">
			<table>
				<tr>
					<th><span class="glyphicon glyphicon-ok"></span> POST CODE:</th>
					<td><textarea class="form-control" rows="1" name="postCd"></textarea></td>
				</tr>
				<tr>
					<th><span class="glyphicon glyphicon-ok"></span> 이벤트 제목:</th>
					<td><textarea class="form-control" rows="1" name="postTitle"></textarea></td>
				</tr>
				<tr>
					<th><span class="glyphicon glyphicon-ok"></span> 이벤트 내용:</th>
					<td><textarea class="form-control" rows="10" name="postContent"></textarea></td>
				</tr>
				<tr>
					<th><span class="glyphicon glyphicon-ok"></span> BOARD CODE:</th>
					<td><textarea id="code" class="form-control" rows="1" name="boardCd" placeholder="BD02"></textarea></td>
				</tr>
			</table>
			
			
<!-- 			<textarea class="form-control" rows="4" id="comment"></textarea> -->
<!-- <input type="text" name="postContent"> -->
		</div>
		<br>
		<div id="btn">
			<button type="submit" id="save"><span class="glyphicon glyphicon-floppy-saved"></span>완료</button>
		</div>
		

	</form>
</body>
</html>