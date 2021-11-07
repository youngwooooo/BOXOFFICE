<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- <script src="../../../js/lib/jquery-3.6.0.min.js"></script> -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
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
	
	textarea{
		resize: none;
	}
</style>
<script type="text/javascript">
	function saveQ(){
		$.ajax({
			url:"/TicketingProject/member/insertQuestionsBoard.do"
			,type:"post"
			,data:$("#fm").serialize()
			,dataType: "json"
			,success:function(data){
				if(data.result == 1) {
					alert("저장되었습니다.");
					window.location.href="<%=request.getContextPath()%>/member/questionsBoard.do";
				}else{
					console.log(data);
					alert("저장에 실패하였습니다. 관리자에게 문의하세요.");
				}
			}
			,error:function(xhr){
				console.log(xhr);
				alert("핸들러와 통신에 실패하였습니다.");
			}
		});
	}	
	
</script>
<title>문의사항 등록</title>
</head>
<body>
	<%@include file="../../common/header.jsp" %>
	<br><br><br><br><br>	
	<form id="fm">
		<div id="title">
			<h4>문의사항 등록</h4>			
		</div>
		<br>
		<div id="table">
			<table>
				<tr>
					<th><span class="glyphicon glyphicon-ok"></span> POST CODE:</th>
					<td><input type="text" class="form-control" rows="1" name="postCd" id="pCode" maxlength="7"></td>
				</tr>
				<tr>
					<th><span class="glyphicon glyphicon-ok"></span> 문의 제목:</th>
					<td><textarea class="form-control" rows="1" name="postTitle" id="questionTitle"></textarea></td>
				</tr>
				<tr>
					<th><span class="glyphicon glyphicon-ok"></span> 문의 내용:</th>
					<td><textarea class="form-control" rows="10" name="postContent" id="questionContent"></textarea></td>
				</tr>
				<tr>
					<th><span class="glyphicon glyphicon-ok"></span> BOARD CODE</th>
					<td><input class="form-control" rows="1" name="boardCd" id="bdCode" value="BD03" readonly></td>
				</tr>				
			</table>
			<input type="hidden" name="flag" value="Check">
		</div>
		<br>
		<div id="btn">
			<button type="button" id="saveBtn" onclick="saveQ()"><span class="glyphicon glyphicon-floppy-saved"></span>저장</button>
		</div>
	</form>
	<br><br><br>
	<%@include file="../../common/footer.jsp" %>
</body>
</html>