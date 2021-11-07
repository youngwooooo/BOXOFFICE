<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
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
	
	
	table {
		width: 100%;
	}
	
	th {
		padding: 5px;
		width: 25%;
		text-align: center;
		background-color: #f5f5f5;
	}
	tr {
		height: 70px;
	}
	td{
		padding: 5px;
  		text-align: left;
		widows: 75%;
		font-size: 16px;
	}
	
	thead{
		background-color: black;
		color: white;
	}
	
	#content{
		height: 150px;
	}
	
	#btn{
/* 		margin-left: 62%; */
		float: right;
		margin-top: 20px;
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
		margin-bottom: 96px;
		margin-left: 22%;
		margin-right: 22%;
	}
	button {
		width: 90px;
		height: 40px;
		margin-right: 50px;
	}
	td:nth-of-type(odd) {
	    padding-left: 40px;
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
		
		$("textarea").css({			"font-size": "16px" });
		$("textarea:last").css({
									"margin-top": "25px", 
									"margin-bottom": "25px"
								});
		
	});
	
	function callHandler(button) {
		
		if(button.id == "backBoard") {
			window.location.href = 'mainBoard2.do';
		}
		
	}
</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>박스오피스 | 이벤트 등록</title>
</head>
<body>
<%@include file="../../common/header.jsp" %>
	<div id="divPage">	
	<form method="post" enctype="multipart/form-date" action="<%=request.getContextPath() %>/admin/insertEvent.do">
		<div id="title">
			<h2 style="font-size: 30px">이벤트</h2>
		</div>
		<div id="table">
			<table>
				<tr>
					<th>POST CODE</th>
					<td><textarea rows="1" class=col-sm-9 name="postCd"></textarea></td>
				</tr>
				<tr>
					<th>이벤트 제목</th>
					<td>
						<textarea rows="1" class=col-sm-9 name="postTitle"></textarea>
					</td>
				</tr>
				<tr>
					<th>이벤트 내용</th>
					<td>
						<textarea rows="9" class=col-sm-9 name="postContent"></textarea>
					</td>
				</tr>
				<tr>
					<th>BOARD CODE</th>
					<td>
						<textarea id="code" class="form-control" rows="1" name="boardCd" placeholder="BD02"></textarea>
					</td>
				</tr>
			</table>
			<div id="btn">
				<button type="submit" id="saveNT" class="btn btn-danger" style="font-size: 16px; margin-right: 10px;">저장</button>
				<button type="button" id="backBoard" onclick="callHandler(this)" class="btn" style="font-size: 16px; margin-right: 10px;">목록</button></a>
			</div>
		</div>
	</form>
	</div>
	<%@include file="../../common/footer.jsp" %>
</body>
</html>