<%@page import="common.vo.PagingVO"%>
<%@page import="common.vo.PostVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
PostVO pv = new PostVO();
List<PostVO> questionsBoardList = (List<PostVO>)request.getAttribute("list"); 
PagingVO pagingVO = (PagingVO)request.getAttribute("pagingVO");
%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
	<link rel="stylesheet" href="/TicketingProject/css/common/main/reset.css">
    <link rel="stylesheet" href="/TicketingProject/css/common/main/style.css?v=1">
    <link rel="stylesheet" href="/TicketingProject/css/common/main/swiper.css">
    <link rel="stylesheet" href="/TicketingProject/css/member/ticketing/ticketing.css">
    <link href="https://fonts.googleapis.com/css?family=Noto+Sans+KR:100,300,400,500,700,900&amp;subset=korean" rel="stylesheet">
<title>박스오피스 | 문의사항 페이지</title>

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
		#div_regBtn {
/* 			width: 100%; */
			float: right;
		}
	</style>
	<script type="text/javascript">
		$(document).ready(function(){
			retrieveListForPaging();
		});
	
		function retrieveListForPaging(pPageNo){
			if(pPageNo == "")
				pPageNo = "<%=request.getParameter("pageNo")==null?"1":request.getParameter("pageNo")%>";
				
			$.ajax({
				url: "/TicketingProject/QuestionsListServlet"
					, type: "post"
					, dataType: "json"
					,data: {"pageNo" : pPageNo}
					, success: function(data) {
						console.log(data);		
						makeTable(data.list);
						pagingTable(data.pagingVO);
					}
					, error: function(xhr) {
						console.log(xhr);
						alert("오류가 발생했습니다. 관리자에게 문의하세요.");
					}
			});
		}
		
		function makeTable(data){
			var str = "";
			$("#tb").empty();
			
			for(var i=0; i<data.length; i++){
				str = "<tr><td>"
					+ data[i].boardName
					+ "</td>"
					+ "<td>"
					+ data[i].postTitle
					+ "</td>"
					+ "<td>"
					+ data[i].postDate
					+ "</td>"
					+ "<td>"
					+ data[i].postView
					+ "</td></tr>";
					
				$("#tb").append(str);
			}
			
			console.log("str : " + str);
//	 		$("#dataRow").html(str);	
	      	
		}
		
		// 페이징 처리 메서드
		function pagingTable(data){		
			$("#pagingRow").empty();
			
			var str ="";
			
			str += "<td colspan='4' align='center'>";		

				if(Number(data.firstPageNo) > Number(data.pageSize)){

					str += "<a href='javascript:retrieveListForPaging(" + (Number(data.firstPageNo) - Number(data.pageSize)) + ")'>[이전]</a>";
				}
				
				for(var pNo = Number(data.firstPageNo) ; pNo <= Number(data.lastPageNo) ; pNo++){
					if(pNo == data.currentPageNo){
						str += "<a style='color:orange;' href='javascript:retrieveListForPaging(" + pNo + ")'>[" + pNo + "]</a>";
					}else{
						str += "<a style='color:black;' href='javascript:retrieveListForPaging(" + pNo + ")'>[" + pNo + "]</a>";
					}		
				}
				
				if(Number(data.lastPageNo) < Number(data.totalPageCount)){
					str += "<a href='javascript:retrieveListForPaging(" + (Number(data.firstPageNo) + Number(data.pageSize)) + ")'>[다음]</a>";
				}
				
			str += "</td>";	
			
			console.log("data.firstPageNo : " + data.firstPageNo + ", data.pageSize : " + data.pageSize + ", data.lastPageNo : " + data.lastPageNo + ", data.totalPageCount : " + data.totalPageCount + ", pageStr : " + str);
				
			$("#pagingRow").append(str);			
		}
		
	</script>
</head>

<body>    
	<%@include file="../../common/header.jsp" %>
	<div id="wrap_admin_seat_manage" style="margin-bottom:500px;">
		<div class="container" style="margin-top: 100px">
			<h2 class="title" style="font-size: 30px">문의사항
			</h2>
			<hr>
			<form>
				<table id="table_seat" class="table table-hover table-striped table_seat">
					<thead>
						<tr>
							<th>구분</th>
							<th>제목</th>
							<th>작성일</th>
							<th>조회수</th>
						</tr>
					</thead>
					<tbody id="tb">					
						<tr></tr>	
<%-- 						<%for(int i=0; i<pv.size(); i++){ %>								 --%>
<!-- 						<tr>			 -->
<!-- 							detailNotice.do?postCd=f			 --> 
<%-- 							<td id="qName"><%=pv.get(i).getBoardName() %></td> --%>
<%-- 							<td id="qTitle"><a href=""><%=pv.get(i).getPostTitle() %></a></td> --%>
<%-- 							<td id="qDate"><%=pv.get(i).getPostDate() %></td> --%>
<%-- 							<td id="qView"><%=pv.get(i).getPostView() %></td> --%>
<!-- 						</tr>	 -->
<%-- 						<%} %>					 --%>
					</tbody>
					<tfoot>
						<tr id="pagingRow"></tr>
					</tfoot>
				</table>
			</form>
			<hr>
			<div id="div_regBtn">
				<a href="<%=request.getContextPath() %>/member/insertQuestionsBoard.do"><button type="button" id="regBtn" class="btn btn-danger">
				<span class="glyphicon glyphicon-pencil"></span>&nbsp;&nbsp;질문 등록</button></a>
			</div>
		</div>
		</div>
	<input type="hidden" value="Check" name="flag">
	<%@include file="../../common/footer.jsp" %>
</body>    
	
</html>