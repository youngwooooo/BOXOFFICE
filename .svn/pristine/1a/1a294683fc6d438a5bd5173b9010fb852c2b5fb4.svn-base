<%@page import="common.vo.PagingVO"%>
<%@page import="java.util.List"%>
<%@page import="common.vo.CdChargeVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>박스오피스 | 요금 관리</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<!-- 	<script src="../../../js/lib/jquery-3.6.0.js"></script> -->
	<style type="text/css">
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
 			text-align: center;	
 		}
 		tr {
 			height: 45px;
 			vertical-align: middle;			
 		}
 		td {
/*  			width: calc(100% / 10); */
 			vertical-align: middle;
 			line-height: 45px;
 		}
 		
 		input {
 			width: 120px;
 			text-align: center;
 		}
 		
 		#divBtn {
 			width: 100%;
 			float: left;
 		}
 		
 		.btn-plus {
 			border-color: #B40D0C;
 			color: #B40D0C;
 			font-size: 18px;
 			height: 34px;
 		}
 		.btn-minus {
 			border-color: #B40D0C;
 			color: #B40D0C;
 		}
 		.btn-save {
 			background-color: #B40D0C;
 			color: white;
 		}
 		
 		a:link, a:visited {
 			text-decoration: none;
 			color: black;
 		}
 		#wrap_admin_movieRating_manage {
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
		.btn_box_save button {
			width: 50px;
			margin-right: 10px;
		}
		.table_movieRating {
			margin-top: 10px;
		}
		th {
			text-align: center;
			font-weight: bold;
			font-size: 14px;
		}
	</style>
	<script type="text/javascript">
		
		$(document).ready(function() {
			
			$.ajax({
				url: "/TicketingProject/admin/charge.do"
				, type: "post"
				, dataType: "json"
				, success: function(data) {
					console.log(data);
					makeTable(data);
				}
				, error: function(xhr) {
					console.log(xhr);
					alert("오류가 발생했습니다. 관리자에게 문의하세요.");
				}
			});
			
			$("#menu").css({
// 				"padding-top": "90px"
// 				,"padding-bottom": "200px"
				"margin-left": "140px"
				,"margin-right": "60px"
			});
			
			
		});
		
		function fnAjax(eleA) {
			
			var str = eleA.innerHTML.indexOf("[");
			var end = eleA.innerHTML.indexOf("]");
			var pageNo = eleA.innerHTML.substr(str+1,end-1);
			
			if(pageNo == "다음") {
				str = eleA.previousSibling.innerHTML.indexOf("[");
				end = eleA.previousSibling.innerHTML.indexOf("]");
				pageNo = parseInt(eleA.previousSibling.innerHTML.substr(str+1,end-1)) + 1;
				
			}else if(pageNo == "이전") {
				str = eleA.nextSibling.innerHTML.indexOf("[");
				end = eleA.nextSibling.innerHTML.indexOf("]");
				pageNo = parseInt(eleA.nextSibling.innerHTML.substr(str+1,end-1)) - 1;
			}
						
			$.ajax({
				url: '/TicketingProject/admin/charge.do?pageNo=' + pageNo 
 				,type: "get"
	 			,dataType: "json"
				,success: function(data2){
					console.log(data2);
					makeTable(data2);
				}
				,error: function(xhr){
					console.log(xhr);
					alert("오류입니다. - fnAjax()");
				}
			});
		}
		
		var style_td1 = " style='width: 20%; padding-left: 5%'";
				
		function makeTable(data) {
			$("#table_charge tbody").empty();
			
			var str = "";
			
			if(data.length > 0) {
				
				for(var i=0 ; i<data.length - 1; i++) {
					str += "<tr>"
							+ "<td>"
								+ "<input type='checkbox'>"
							+ "</td>"
							+ "<td ondblclick='changeValue(this)' class='c_chgWeekendYn'>"
								+ data[i].chgWeekendYn
								+ "<input type='hidden' name='chgChargeCd' value='" + data[i].chgChargeCd + "'>"
								+ "<input type='hidden' name='chgWeekendYn' value='" + data[i].chgWeekendYn + "'>"
							+ "</td>"
							+ "<td ondblclick='changeValue(this)' class='c_cdName1'>"
								+ data[i].cdName1
								+ "<input type='hidden' name='cdName1' value='" + data[i].cdName1 + "'>"
							+ "</td>"
							+ "<td ondblclick='changeValue(this)' class='c_cdName2'>"
								+ data[i].cdName2
								+ "<input type='hidden' name='cdName2' value='" + data[i].cdName2 + "'>"
							+ "</td>"
							+ "<td ondblclick='changeValue(this)' class='c_cdName3'>"
								+ data[i].cdName3
								+ "<input type='hidden' name='cdName3' value='" + data[i].cdName3 + "'>"
							+ "</td>"
							+ "<td ondblclick='changeValue(this)' class='c_cdName4'>"
								+ data[i].cdName4
								+ "<input type='hidden' name='cdName4' value='" + data[i].cdName4 + "'>"
							+ "</td>"
							+ "<td ondblclick='changeValue(this)' class='c_chgPrice'>"
								+ data[i].chgPrice
								+ "<input type='hidden' name='chgPrice' value='" + data[i].chgPrice + "'>"
							+ "</td>"
							+ "<input type='hidden' name='flag' value=''>"
// 							+ "<td ondblclick='changeValue(this)' class=''>"
// 								+ i
// 							+ "</td>"
						+ "</tr>";
						
				} //for문
				
				/* 페이징 처리 시작 */
				str += "<tr>"
					+	"<td colspan='7' align='center'>"

				var currentPageNo = data[data.length-1].currentPageNo;
				var countPerPage = data[data.length-1].countPerPage;
				var pageSize = data[data.length-1].pageSize;
				var firstPageNo = data[data.length-1].firstPageNo;
				var lastPageNo = data[data.length-1].lastPageNo;
				var firstRecNo = data[data.length-1].firstRecNo;
				var lastRecNo = data[data.length-1].lastRecNo;
				var totalCount = data[data.length-1].totalCount;
								
				if(firstPageNo > pageSize) {
					pageNo =  firstPageNo - pageSize;
					str += "<a onclick='fnAjax(this)'>[이전]</a>";
				}
		
				for(var pNo = firstPageNo; pNo <= lastPageNo; pNo++) {
					if(pNo == currentPageNo) {
						str += "<a style='color:orange;' onclick='fnAjax(this)'>[" + pNo + "]</a>";								
					}
					else {
						str += "<a onclick='fnAjax(this)'>[" + pNo + "]</a>";
					}
				}
				
				if(lastPageNo < totalCount/countPerPage) {
					pageNo = firstPageNo + pageSize;								
					str += "<a onclick='fnAjax(this)'>[다음]</a>";
				}
							
				str	+=	"</td>" 
					+ "</tr>"
				
				/* 페이징 처리 끝 */
					
			} else {
				str = "<tr>"
						"<td colspan='7'>조회된 결과가 없습니다.</td>"
					+ "</tr>";	
			}
			
			$("#table_charge tbody").append(str);
		}
	
		function addRow() {
// 			alert("행이 추가되는 기능 구현");
			
			var str	
				=	"<tr>"
						+ "<td style='width: 40px'>"
							+ "<input type='checkbox' class='checkCheckedRow'>"
						+ "</td>"
						+ "<td ondblclick='changeValue(this)' class='c_chgWeekendYn'>"
							+ "<input type='hidden' name='chgChargeCd' value=''>"
							+ "<input type='hidden' name='chgWeekendYn' value=''>"
						+ "</td>"
						+ "<td ondblclick='changeValue(this)' class='c_cdName1'>"
							+ "<input type='hidden' name='cdName1' value=''>"
						+ "</td>"
						+ "<td ondblclick='changeValue(this)' class='c_cdName2'>"
							+ "<input type='hidden' name='cdName2' value=''>"
						+ "</td>"
						+ "<td ondblclick='changeValue(this)' class='c_cdName3'>"
							+ "<input type='hidden' name='cdName3' value=''>"
						+ "</td>"
						+ "<td ondblclick='changeValue(this)' class='c_cdName4'>"
							+ "<input type='hidden' name='cdName4' value=''>"
						+ "</td>"
						+ "<td ondblclick='changeValue(this)' class='c_chgPrice'>"
							+ "<input type='hidden' name='chgPrice' value=''>"
						+ "</td>"
	// 					+ "<td ondblclick='changeValue(this)' class=''>"
	// 						+ i
	// 					+ "</td>"
						+ "<input type='hidden' name='flag' value='M'>"
					+ "</tr>";
			
			$("#table_charge tbody").prepend(str);
			$("#table_changed_check").val("changed");
			
		}
		
		function removeRows() {
// 			alert("선택한 체크박스가 삭제되는 기능 구현");
			
			var checkedRows = $("input:checked");
			
			if(checkedRows.length == 0) {
				alert("삭제할 항목을 선택하세요.");
				
			} else {
				checkedRows.each(function(idx, item) {
					$(item).parent().parent().children("[name='flag']").val("D");
// 					$(item).parent().parent().hide();
					$(item).parent().parent().children().css("color","red");
					$(item).parent().parent().children(".c_chgWeekendYn").append(" 삭제예정");
					$(item).parent().parent().children(".c_cdName1").append(" 삭제예정");
					$(item).parent().parent().children(".c_cdName2").append(" 삭제예정");
					$(item).parent().parent().children(".c_cdName3").append(" 삭제예정");
					$(item).parent().parent().children(".c_cdName4").append(" 삭제예정");
					$(item).parent().parent().children(".c_chgPrice").append(" 삭제예정");
					$(item).prop("checked", false);
				});
				$("#table_changed_check").val("changed");
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
		
		function saveValue(obj) {
			var val = $(obj).val();
			
			if($(obj).parent().attr("class") == "c_chgWeekendYn") {
				$(obj).parent().children("[name='chgWeekendYn']").val(val);
			} else if($(obj).parent().attr("class") == "c_cdName1") {
				$(obj).parent().children("[name='cdName1']").val(val); 
			} else if($(obj).parent().attr("class") == "c_cdName2") {
				$(obj).parent().children("[name='cdName2']").val(val);
			} else if($(obj).parent().attr("class") == "c_cdName3") {
				$(obj).parent().children("[name='cdName3']").val(val);
			} else if($(obj).parent().attr("class") == "c_cdName4") {
				$(obj).parent().children("[name='cdName4']").val(val);
			} else if($(obj).parent().attr("class") == "c_chgPrice") {
				$(obj).parent().children("[name='chgPrice']").val(val);
			}
			
			$(obj).parent().append(val);
			console.log($(obj).parent().parent().children("[name='flag']").val("M"));
			$("#insertChargeValue").remove();
			$("#table_changed_check").val("changed");
		}
		
		function saveTable() {
// 			alert("더블 클릭한 행이 수정되는 기능 구현");
			
			if($("#table_changed_check").val() == "unchanged") {
				alert("변경된 내용이 없습니다.");
				return;
			}
			
			var eleTd = $("#table_charge tbody td.c_chgWeekendYn");
			for(var i=0 ; i<eleTd.length ; i++) {
				if($(eleTd[i]).text() == null || $(eleTd[i]).text() == "") {
					alert("값이 입력되지 않은 항목이 있습니다.");
					return;
				}
			}
			
			eleTd = $("#table_charge tbody td.c_cdName1");
			for(var i=0 ; i<eleTd.length ; i++) {
				if($(eleTd[i]).text() == null || $(eleTd[i]).text() == "") {
					alert("값이 입력되지 않은 항목이 있습니다.");
					return;
				}
			}
			eleTd = $("#table_charge tbody td.c_cdName2");
			for(var i=0 ; i<eleTd.length ; i++) {
				if($(eleTd[i]).text() == null || $(eleTd[i]).text() == "") {
					alert("값이 입력되지 않은 항목이 있습니다.");
					return;
				}
			}
			eleTd = $("#table_charge tbody td.c_cdName3");
			for(var i=0 ; i<eleTd.length ; i++) {
				if($(eleTd[i]).text() == null || $(eleTd[i]).text() == "") {
					alert("값이 입력되지 않은 항목이 있습니다.");
					return;
				}
			}
			eleTd = $("#table_charge tbody td.c_cdName4");
			for(var i=0 ; i<eleTd.length ; i++) {
				if($(eleTd[i]).text() == null || $(eleTd[i]).text() == "") {
					alert("값이 입력되지 않은 항목이 있습니다.");
					return;
				}
			}
			
			eleTd = $("#table_charge tbody td.c_chgPrice");
			for(var i=0 ; i<eleTd.length ; i++) {
				if($(eleTd[i]).text() == null || $(eleTd[i]).text() == "") {
					alert("값이 입력되지 않은 항목이 있습니다.");
					return;
				}
			}
			
			var count = 0;
			var errorCheck = 0;
			var paramList = new Array();
			
			$("#table_charge tbody tr").each(function(idx, item) {
								
				var flag = $(item).children("[name='flag']").val();
				var chgChargeCd = $(item).children(".c_chgWeekendYn").children("[name='chgChargeCd']").val();
				console.log(chgChargeCd);
				var chgWeekendYn = $(item).children(".c_chgWeekendYn").children("[name='chgWeekendYn']").val();
				var cdName1 = $(item).children(".c_cdName1").children("[name='cdName1']").val();
				var cdName2 = $(item).children(".c_cdName2").children("[name='cdName2']").val();
				var cdName3 = $(item).children(".c_cdName3").children("[name='cdName3']").val();
				var cdName4 = $(item).children(".c_cdName4").children("[name='cdName4']").val();
				var chgPrice = $(item).children(".c_chgPrice").children("[name='chgPrice']").val();
				var url = "";
								
				if(flag == null || flag == "") {
// 					alert("flag값 없음!");
					return;
				} else if(flag == "M") {
					if(chgChargeCd == null || chgChargeCd == "") {
// 						alert("등록");
						url = "/TicketingProject/admin/chargeCreate.do";
					} else {
// 						alert("수정");
						url = "/TicketingProject/admin/chargeModify.do";
					}
				} else if(flag == "D") {
// 					alert("삭제");
					url = "/TicketingProject/admin/chargeDelete.do";
				}
				
				var param = {
						chgChargeCd : chgChargeCd
						, chgWeekendYn : chgWeekendYn
						, cdName1 : cdName1
						, cdName2 : cdName2
						, cdName3 : cdName3
						, cdName4 : cdName4
						, chgPrice : chgPrice
				};
				
				$.ajax({
					url: url
					, type: "post"
					, data: param
					, dataType: "json"
					, success: function(data) {
						alert("ajax success 타기");
						console.log(1);
						if(data.result == 1) {
							console.log(2);
							console.log(data);
							count += 1;
						}
					}
					, error: function(xhr) {
						console.log(3);
						console.log(xhr);
						errorCheck += 1;
					}
				});
				
			}); // $("#table_charge tbody tr").each(function(idx, item)
			
			
// 			for(){
// 				paramList = [{}, {}, {}];
// 			}
			
// 			$.ajax({
// 				url: url
// 				, type: "post"
// 				, data: paramList
// 				, dataType: "json"
// 				, success: function(data) {
// 					console.log(1);
// 					console.log(data);
// 					alert(paramList.length + "행이 업데이트 되었습니다.");
// 				}
// 				, error: function(xhr) {
// 					console.log(3);
// 					console.log(xhr);
// 					alert("오류가 발생했습니다. 관리자에게 문의하세요.");
// 				}
// 			});


			if(errorCheck > 0) {
				alert("오류가 발생했습니다. 관리자에게 문의하세요.");
			} else {
				alert("업데이트 되었습니다.");
			}
					
		}
	</script>
</head>	

<body>
	<%@include file="../../common/header.jsp" %>
	<%@include file="/jsp/admin/adminMainBody.jsp" %>
	
	<div id="wrap_admin_seat_manage">
		<div class="container" style="margin-top: 100px">
<!-- 	<div class="container-fluid" style="margin-top: 100px"> -->
<!-- 	  <div class="row content"> -->

	    <div class="col-sm-9">
	      <h2 onclick="window.location.reload()">요금 관리</h2>
	      <hr>
	      	<div id="divBtn">
	      		<button type="button" class="btn btn-plus" onclick="addRow()">+</button>
	      		<button type="button" class="btn btn-minus" onclick="removeRows()">ㅡ</button>
	      		<button type="button" class="btn btn-save" onclick="saveTable()">저장</button>
	      	</div>
	      	<br><br>
	      	<form id="table_charge_check">
				<input id="table_changed_check" type="hidden" value="unchanged">
			</form>
	      	<form>
		      	<table id="table_charge" class="table table-hover table-striped">
		      		<thead>
		      			<tr>
			      			<td style='width: 40px'>선택</td>
			      			<td>관람요일</td>
			      			<td>이용자</td>
			      			<td>시간</td>
			      			<td>좌석</td>	
			      			<td>스크린</td>
			      			<td>가격</td>
		      			</tr>
		      		</thead>
					<!-- 요금 데이터를 읽어와서 tbody에 행 생성 -->
		      		<tbody>
		      		</tbody>
		      	</table>
	      	</form>
	    </div> <!-- col-sm-9 -->
	  </div>
	</div>
<!-- 	</div> -->
<!-- 	</div> -->
	<%@include file="../../common/footer.jsp" %>
</body>
</html>
