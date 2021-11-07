<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<!-- html 화면 -->
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<!-- 부트스트랩 -->
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
	<!-- 탭 명 -->
	<title>박스오피스 | 스크린 관리</title>
	<style type="text/css">
		#wrap_admin_screen_manage {
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
		.table_screen {
			margin-top: 10px;
		}
		<!-- 더블클릭 했을 때 td 너비 변경되지 않게 하는 css -->
		td {
			width: calc(100% / 4);
		}
	</style>
	<script type="text/javascript">
		$(document).ready(function() {
			
			$("#menu").css({
				"padding-top": "90px"
				,"padding-bottom": "200px"
	 			,"margin-left": "140px"
			});
			
			$.ajax({
				url: "/TicketingProject/admin/screen.do"
				, type: "post"
// 				, data: ""
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
			
		});
		
		function makeTable(data) {
			$("#table_screen tbody").empty();
			
			var str = "";
			
			if(data.length == 0) {
				str = "<tr>"
						"<td colspan='4'>조회된 결과가 없습니다.</td>"
					+ "</tr>";
					
			} else {
				for(var i=0 ; i<data.length ; i++) {
					str += "<tr>"
							+ "<td>"
								+ "<input type='checkbox'>"
							+ "</td>"
							+ "<td ondblclick='changeValue(this)' class='screen_cd'>"
								+ data[i].cdName
								+ "<input type='hidden' name='cd' value='" + data[i].cd + "'>"
								+ "<input type='hidden' name='cdName' value='" + data[i].cdName + "'>"
							+ "</td>"
							+ "<td ondblclick='changeValue(this)' class='screen_cdDesc'>"
								+ data[i].cdDesc
								+ "<input type='hidden' name='cdDesc' value='" + data[i].cdDesc + "'>"
							+ "</td>"
							+ "<td class='screen_deleteYn'>";
							
					if(data[i].deleteYn == "N") {
						str += "<button type='button' class='btn btn-default btn-sm' onclick='changeDeleteYn(this)'>사용중지</button>"
							 + "<input type='hidden' name='deleteYn' value='" + data[i].deleteYn + "'>";
							 
					} else {
						str += "<button type='button' class='btn btn-sm' onclick='changeDeleteYn(this)'>사용하기</button>"
							 + "<input type='hidden' name='deleteYn' value='" + data[i].deleteYn + "'>";
					}
					str += "</td>"
						+ "<input type='hidden' name='flag' value=''>"
						+ "</tr>";
				}
			}
			
			$("#table_screen tbody").append(str);
		}
		
		function changeDeleteYn(obj) {
			if($(obj).text() == "사용하기") {
				$(obj).addClass("btn-default");
				$(obj).text("사용중지");
				$(obj).next().val("N");
				
			} else {
				$(obj).removeClass("btn-default");
				$(obj).text("사용하기");
				$(obj).next().val("Y");
			}
			
			$(obj).parent().parent().children("[name='flag']").val("M");
			$("#table_changed_check").val("changed");
		}
		
		function addRow() {
			var str = "<tr>"
						+ "<td>"
							+ "<input type='checkbox' class='checkCheckedRow'>"
						+ "</td>"
						+ "<td ondblclick='changeValue(this)' class='screen_cd'>"
							+ "<input type='hidden' name='cd' value=''>"
							+ "<input type='hidden' name='cdName' value=''>"
						+ "</td>"
						+ "<td ondblclick='changeValue(this)' class='screen_cdDesc'>"
							+ "<input type='hidden' name='cdDesc' value=''>"
						+ "</td>"
						+ "<td class='screen_deleteYn'>"
							+ "<button type='button' class='btn btn-default btn-sm' onclick='changeDeleteYn(this)'>사용중지</button>"
							+ "<input type='hidden' name='deleteYn' value='N'>"
						+ "</td>"
						+ "<input type='hidden' name='flag' value='M'>"
					+ "</tr>";
			
			$("#table_screen tbody").append(str);
			$("#table_changed_check").val("changed");
		}
		
		function removeRows() {
			var checkedRows = $("input:checked");
			
			if(checkedRows.length == 0) {
				alert("삭제할 항목을 선택하세요.");
				
			} else {
				checkedRows.each(function(idx, item) {
					$(item).parent().parent().children("[name='flag']").val("D");
					$(item).parent().parent().hide();
					$(item).parent().parent().children(".screen_cd").append("삭제예정");
					$(item).parent().parent().children(".screen_cdDesc").append("삭제예정");
					$(item).prop("checked", false);
				});
				$("#table_changed_check").val("changed");
			}
		}
		
		function changeValue(obj) {
			var ele = $(obj).children();
			var val = $(obj).text();
			$(obj).text("");
			
			var str = "<input id='insertScreenValue' type='text' value='" + val + "' onfocusout='saveValue(this)'>"
			$(obj).append(str);
			$(obj).append(ele);
			$("#insertScreenValue").focus();
		}
		
		function saveValue(obj) {
			var val = $(obj).val();
			
			if($(obj).parent().attr("class") == "screen_cd") {
				$(obj).parent().children("[name='cdName']").val(val);
			} else if($(obj).parent().attr("class") == "screen_cdDesc") {
				$(obj).parent().children("[name='cdDesc']").val(val);
			}
			
			$(obj).parent().append(val);
			console.log($(obj).parent().parent().children("[name='flag']").val("M"));
			$("#insertScreenValue").remove();
			$("#table_changed_check").val("changed");
		}
		
		function saveTable() {
			if($("#table_changed_check").val() == "unchanged") {
				alert("변경된 내용이 없습니다.");
				return;
			}
			
			var eleTd = $("#table_screen tbody td.screen_cd");
			for(var i=0 ; i<eleTd.length ; i++) {
				if($(eleTd[i]).text() == null || $(eleTd[i]).text() == "") {
					alert("값이 입력되지 않은 항목이 있습니다.");
					return;
				}
			}
			
			eleTd = $("#table_screen tbody td.screen_cdDesc");
			for(var i=0 ; i<eleTd.length ; i++) {
				if($(eleTd[i]).text() == null || $(eleTd[i]).text() == "") {
					alert("값이 입력되지 않은 항목이 있습니다.");
					return;
				}
			}
			
			var count = 0;
			var errorCheck = 0;
			
			$("#table_screen tbody tr").each(function(idx, item) {
				var flag = $(item).children("[name='flag']").val();
				var cdStr = $(item).children(".screen_cd").children("[name='cd']").val();
				var cdNameStr = $(item).children(".screen_cd").children("[name='cdName']").val();
				var cdDescStr = $(item).children(".screen_cdDesc").children("[name='cdDesc']").val();
				var deleteYnStr = $(item).children(".screen_deleteYn").children("[name='deleteYn']").val();
				var url = "";
				
				if(flag == null || flag == "") {
					return;
				} else if(flag == "M") {
					if(cdStr == null || cdStr == "") {
						url = "/TicketingProject/admin/screenCreate.do";
					} else {
						console.log(1);
						url = "/TicketingProject/admin/screenModify.do";
					}
				} else if(flag == "D") {
					url = "/TicketingProject/admin/screenDelete.do";
				}
				
				var param = {
						cd : cdStr
						, cdName : cdNameStr
						, cdDesc : cdDescStr
						, deleteYn : deleteYnStr
				};
				
				$.ajax({
					url: url
					, type: "post"
					, data: param
					, dataType: "json"
					, async: false
					, success: function(data) {
						if(data.result > 0) {
							console.log(data.result);
							count += 1;
						}
					}
					, error: function(xhr) {
						console.log(xhr);
						errorCheck += 1;
					}
				});
				
			});
			
			if(errorCheck > 0) {
				alert("오류가 발생했습니다. 관리자에게 문의하세요.");
			} else {
				alert(count + "건이 업데이트 되었습니다.");
			}
		}
	</script>
</head>
<body>
	<%@include file="../../common/header.jsp" %>
	<%@include file="/jsp/admin/adminMainBody.jsp" %>
	<div id="wrap_admin_screen_manage">
		<div class="container" style="margin-top: 100px">
			<h2 class="title">스크린 관리<span>스크린 유형 관리</span></h2>
			<hr>
			<div class="btn_box_table">
				<button type="button" class="btn btn-danger btn-sm" onclick="addRow()">＋</button>
				<button type="button" class="btn btn-danger btn-sm" onclick="removeRows()">－</button>
			</div>
			<form>
				<table id="table_screen" class="table table-hover table-striped table_screen">
					<thead>
						<tr>
							<th>선택</th>
							<th>스크린 유형</th>
							<th>스크린 설명</th>
							<th>사용여부</th>
						</tr>
					</thead>
					<tbody>
					</tbody>
				</table>
			</form>
			<form id="table_screen_check">
				<input id="table_changed_check" type="hidden" value="unchanged">
			</form>
			<div class="btn_box_save">
				<button type="button" class="btn btn-danger" onclick="saveTable()">저장</button>
			</div>
			<hr>
		</div>
	</div>
	<%@include file="../../common/footer.jsp" %>
</body>
</html>