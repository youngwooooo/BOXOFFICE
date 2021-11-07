<%@page import="common.vo.PostVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<%
	List<PostVO> BoardList = (List<PostVO>)request.getAttribute("boardList");
	
%>    
    

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>


	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<style type="text/css">
	
	#title, #table{
		position: static;
		margin-left: 22%;
			
	}
	
	#insert{
		position: static;
		margin-left: 71%;
	}
	
	table{
		 width: 70%;
  		 border-collapse: collapse;
	}
	tr{
		border-top: 1px solid #C0C0C0;
		border-bottom: 1px solid #C0C0C0;
	}
	
	thead{
		background-color: black;
		color: white;
		border-bottom: 2px solid red;
		border-top: 2px solid red;
	}
	.notice{
		background-color: #eeeeee;
		color: orange;
	}
	
	
	tbody tr:hover{
		background-color: #eeeeee;
		color: orange;
		font-weight: 900;
	}
	
	td a{
		color: black;
	}
	
	td a:hover{
		color: orange;
	}
	
	#insertEV{
		background-color: black;
		color:white;
		border: 3px solid red;			
	}
	
</style>
</head>
<body>
	<%@include file="../../common/header.jsp" %>
	<br><br><br><br><br>
<%-- 	<%@include file="/jsp/admin/adminMain.jsp" %> --%>
	<div id=title>
		<h3 style="font-size: large;"><span class="glyphicon glyphicon-thumbs-up"></span>이벤트</h3>
	</div>
	<div id=insert>
		<a href="insertEvent.do"><button type="submit" id=insertEV style="width: 90px; height: 30px"><span class="glyphicon glyphicon-pencil"></span>이벤트등록</button></a>
	</div>
	<br>
	<div id=table>
		<table>
			<thead>
				<tr>
					<th>구분</th>
					<th>제목</th>
					<th>등록일</th>
					<th>조회수</th>
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
					<td><a href="detailEvent.do?postCd=<%=BoardList.get(i).getPostCd()%>"><%=BoardList.get(i).getPostTitle()%></a></td>
					<td><%=BoardList.get(i).getPostDate()%></td>
					<td>0</td>
				</tr>		
						
				<%
					}
				%>		
			<%		
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
	</div>
	<br><br><br><br><br><br><br>
	<%@include file="../../common/footer.jsp" %>
</body>
</html>