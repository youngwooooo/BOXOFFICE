<!-- 작성자: 정범 -->
<%@page import="common.vo.PagingVO"%>
<%@page import="common.vo.CodeVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
CodeVO cv = new CodeVO(); 
List<CodeVO> genreList = (List<CodeVO>) request.getAttribute("genreList");
PagingVO pagingVO = (PagingVO)request.getAttribute("pagingVO");
%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">	
  	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>		
	<script src="<%=request.getContextPath() %>/js/lib/jquery-3.6.0.js"></script>
<%-- 	<script type="text/javascript" src="<%=request.getContextPath() %>/js/admin/category/manageCategory.js"></script>	 --%>
	<link rel="stylesheet" href="<%=request.getContextPath() %>/css/admin/category/manageCategory.css">
	<style type="text/css">
		.btn-plus {
			border-color: #B40D0C;
			color: #B40D0C;
		}	
		.btn-minus{
			border-color: #B40D0C;
			color: #B40D0C;		
		}
		.btn-save {
 			background-color: #B40D0C;
 			color: white;
 		}
 		thead {
 			background: #000000;
 			color: #FFFFFF;
 		}
 		table, td, th { 
 		    border: 1px solid black; 
 		}
 		thead td {
			background-color: black;
			color: white;
 		}
 		thead td:last-child {
 			background-color: #ff1212;
 		}
 		table {
 			border-collapse: collapse;
 			width: 100%;
 		}
 		
 		#wrap_admin_seat_manage {
			width: 1000px;
			margin-left: calc((100% - 1000px) / 2);
			display: flex;
			flex-flow: row nowrap;
		}
		.title span {
			font-size: 1.5rem;
			font-size: 24px; font-weight: bold;
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
		.btn_box_save button {
			width: 50px;
			margin-right: 10px;
		}
		.table_seat {
			margin-top: 10px;
		}
/* 		td { */
/* 			width: calc(100% / 4); */
/* 		} */
		
	</style>
	
	<script type="text/javascript">
	$(document).ready(function(){
		
		$("#menu").css({
			"padding-top": "90px"
			,"padding-bottom": "200px"
			,"margin-left": "140px"
		});
		
		retrieveListForPaging();
	});
	
	function retrieveListForPaging(pPageNo){
		if(pPageNo == "")
			pPageNo = "<%=request.getParameter("pageNo")==null?"1":request.getParameter("pageNo")%>";
			
		$.ajax({
			url: "/TicketingProject/ManageCategoryServlet"
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

	// 영화 장르 데이터 조회 메서드	
	function makeTable(data){
		var str = "";
		$("#tb").empty();
		
		for(var i=0; i<data.length; i++){
			str = "<tr><td>"
				+ data[i].groupCd
				+ "</td>"
				+ "<td>"
				+ data[i].cdName
				+ "</td></tr>";
				
			$("#tb").append(str);
		}
		
		console.log("str : " + str);
// 		$("#dataRow").html(str);	
      	
	}
	
	// 페이징 처리 메서드
	function pagingTable(data){		
		$("#pagingRow").empty();
		
		var str ="";
		
		str += "<td colspan='2' align='center'>";
		
			//alert(data.firstPageNo + " : " + data.pageSize);
			if(Number(data.firstPageNo) > Number(data.pageSize)){
// 				str += "<a href='manageCategory.do?pageNo=" + (Number(data.firstPageNo) - Number(data.pageSize)) + "'>[이전]</a>";
				str += "<a href='javascript:retrieveListForPaging(" + (Number(data.firstPageNo) - Number(data.pageSize)) + ")'>[이전]</a>";
			}
			
			for(var pNo = Number(data.firstPageNo) ; pNo <= Number(data.lastPageNo) ; pNo++){
				if(pNo == data.currentPageNo){
// 					str += "<a style='color:orange;' href='manageCategory.do?pageNo=" + pNo + "'>[" + pNo + "]</a>";
					str += "<a style='color:orange;' href='javascript:retrieveListForPaging(" + pNo + ")'>[" + pNo + "]</a>";
				}else{
// 					str += "<a style='color:black;' href='manageCategory.do?pageNo=" + pNo + "'>[" + pNo + "]</a>";
					str += "<a style='color:black;' href='javascript:retrieveListForPaging(" + pNo + ")'>[" + pNo + "]</a>";
				}		
			}
// 			alert(data.lastPageNo + " / " + data.totalPageCount);
			if(Number(data.lastPageNo) < Number(data.totalPageCount)){
// 				str += "<a href='manageCategory.do?pageNo=" + (Number(data.firstPageNo) + Number(data.pageSize)) + "'>[다음]</a>";
				str += "<a href='javascript:retrieveListForPaging(" + (Number(data.firstPageNo) + Number(data.pageSize)) + ")'>[다음]</a>";
			}
			
		str += "</td>";	
		
		console.log("data.firstPageNo : " + data.firstPageNo + ", data.pageSize : " + data.pageSize + ", data.lastPageNo : " + data.lastPageNo + ", data.totalPageCount : " + data.totalPageCount + ", pageStr : " + str);
			
		$("#pagingRow").append(str);	
			
// 	<tr>
//   		<td colspan="2" align="center">
<%--   		<%if(pagingVO.getFirstPageNo() > pagingVO.getPageSize()){ %> --%>
<%--   		<a href="manageCategory.do?pageNo=<%=pagingVO.getFirstPageNo() - pagingVO.getPageSize()%>">[이전]</a>				      		 --%>
<%--   		<%} %> --%>
<%--   		<%for(int pNo = pagingVO.getFirstPageNo(); pNo <= pagingVO.getLastPageNo(); pNo++){ %> --%>
<%--   		<a <%if(pNo == pagingVO.getCurrentPageNo()){ %> style="color:orange;" <%} %> href="manageCategory.do?pageNo=<%=pNo %>">[<%=pNo %>]</a>				      		 --%>
<%--   		<%} %> --%>
<%--   		<%if(pagingVO.getLastPageNo() < pagingVO.getTotalPageCount()){ %> --%>
<%--   		<a href="manageCategory.do?pageNo=<%=pagingVO.getFirstPageNo() + pagingVO.getPageSize()%>">[다음]</a> --%>
<%--   		<%} %> --%>
//   		</td>
//   	</tr>	
		
	}

	// 행 추가 버튼
	function addData(){
		var str = "<tr>"
				+ "<td>"
				+ "<input type='checkbox' class='checkCheckedRow'>"
				+ "</td>"
				+ "<td ondblclick='changeValue(this)' class='genreName_input'>"
				+ "<input type='hidden' name='genreName' value=''>"
				+ "</td>"
				+ "</tr>";
		
			$("#tb").prepend(str);
			$("#table_changed_check").val("changed");
			
	}

	// 행 삭제 버튼
	function removeData(){
		var checkedRows = $("input:checked");
	
		if(checkedRows.length == 0) {
			alert("삭제할 항목을 선택하세요.");
		
		} else {
			checkedRows.each(function(idx, item) {
				$(item).parent().parent().children("[name='flag']").val("D");
				$(item).parent().parent().hide();
				$(item).parent().parent().children(".check").append("삭제예정");
				$(item).parent().parent().children(".realData").append("삭제예정");
				$(item).prop("checked", false);
			});
		
			$("#table_changed_check").val("changed");
		}
	}

	// 저장 버튼
	function saveData(){
		if($("table_changed_check").val() == "unchanged"){
			alert("변경된 내용이 없습니다.");
			return;
		}
	
		var eleTd = $("#tb td.c_chgWeekendYn");
		for(var i=0 ; i<eleTd.length ; i++) {
			if($(eleTd[i]).text() == null || $(eleTd[i]).text() == "") {
				alert("값이 입력되지 않은 항목이 있습니다.");
				return;
			}
		}
	
	
	}

	function changeValue(obj) {
		var ele = $(obj).children();
		var val = $(obj).text();
		$(obj).text("");
	
		var str = "<input id='insertChargeValue' type='text' value='" + val + "' onfocusout='saveValue(this)'>"
		$(obj).append(str);
		$(obj).append(ele);
		$("#insertChargeValue").focus();
	}
		
	</script>
	
	<title>(관리자)카테고리 관리</title>
</head>	

<body>
	<%@include file="../../common/header.jsp" %>
	<%@include file="/jsp/admin/adminMainBody.jsp" %>
<!-- 	<div class="container-fluid"> -->
<!-- 	  <div class="row content">	   -->
	<div id="wrap_admin_seat_manage">
	<div class="container" style="margin-top: 100px">
	    <div class="col-sm-9">
	      <h2>영화 장르 관리</h2>
	      <hr>
	      	<!-- 여기서부터 카테고리 관리 테이블 작성하기 -->	      	
	      		<div id="topOfTb">
	      			<button type="button" class="btn btn-plus"id="addBtn" onclick="addData()">+</button>
	      			<button type="button" class="btn btn-minus" id="removeBtn" onclick="removeData()">-</button>
	      			<button type="button" class="btn btn-save" id="saveBtn" onclick="saveData()">저장</button>
	      		</div>	      		
	      		<br>
	      		<form id="table_charge_check">
					<input id="table_changed_check" type="hidden" value="unchanged">
				</form>
				<form>
		      		<table class="table table-striped" id="categoryTb">
					    <thead id="th">
					      <tr>			      	
					      	<th>체크</th>			        
					        <th>카테고리</th>			        
					      </tr>
					    </thead>
					    <tbody id="tb">				      			      
					      	<!-- 영화 장르 리스트 테이블로 출력하기 -->				      				      	
<%-- 					      	<% --%>
<%-- 					      	if(genreList.size() > 0){%> --%>
					      	<!-- 데이터 행 시작 -->
<!-- 					      	<tr id="dataRow"></tr> -->
					      	<!-- 데이터 행 끝 -->
					      	
					    </tbody>
					    <tfoot>
					      	<!-- 페이징 시작 -->
					      	<tr id="pagingRow">
					      	</tr>				
					      	<!-- 페이징 행 끝 -->
					      	
<%-- 					      	<%}else{ %> --%>
<!-- 					      		페이징 행 시작 -->
<!-- 					      		<tr> -->
<!-- 					      			<td colspan="2">등록된 정보가 없습니다.</td> -->
<!-- 					      		</tr> -->
<!-- 					      		<td colspan="2" align="center"> -->
<%-- 					      		<%if(pagingVO.getFirstPageNo() > pagingVO.getPageSize()){ %> --%>
<%-- 					      		<a href="manageCategory.do?pageNo=<%=pagingVO.getFirstPageNo() - pagingVO.getPageSize()%>">[이전]</a>				      		 --%>
<%-- 					      		<%} %> --%>
<%-- 					      		<%for(int pNo = pagingVO.getFirstPageNo(); pNo <= pagingVO.getLastPageNo(); pNo++){ %> --%>
<%-- 					      		<a <%if(pNo == pagingVO.getCurrentPageNo()){ %> style="color:orange;" <%} %> href="manageCategory.do?pageNo=<%=pNo %>">[<%=pNo %>]</a>				      		 --%>
<%-- 					      		<%} %> --%>
<%-- 					      		<%if(pagingVO.getLastPageNo() < pagingVO.getTotalPageCount()){ %> --%>
<%-- 					      		<a href="manageCategory.do?pageNo=<%=pagingVO.getFirstPageNo() + pagingVO.getPageSize()%>">[다음]</a> --%>
<%-- 					      		<%} %> --%>
<!-- 					      		</td> -->
<!-- 					      		페이징 행 끝 -->
<%-- 					      	<%} %>      					      	 --%>
					    </tfoot>
					</table>
				</form>
				<div id="downOfTb">					      	    
					<span class="glyphicon glyphicon-arrow-left" id="backKey" ><a href="">뒤로가기</a></span>
				</div>	
	      		
	      			
<!-- 	    </div> -->
<!-- 	  </div> -->
	</div>
	</div>
	</div>
	<%@include file="../../common/footer.jsp" %>
</body>
</html>
