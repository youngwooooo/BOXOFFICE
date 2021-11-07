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
	
	<!-- 그래프 -->
	<script src="https://code.highcharts.com/highcharts.js"></script>
	<script src="https://code.highcharts.com/modules/data.js"></script>
	<script src="https://code.highcharts.com/modules/exporting.js"></script>
	<script src="https://code.highcharts.com/modules/export-data.js"></script>
	<script src="https://code.highcharts.com/modules/accessibility.js"></script>
	<script type="text/javascript" src="../../../js/admin/sales/graphHTMLTable.js" defer></script>
	<link rel="stylesheet" href="../../../css/admin/sales/graphHTMLTable.css">
	
	<!-- 탭 명 -->
	<title>박스오피스 | 매출 관리</title>
	<style type="text/css">
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
		$(document).ready(function(){
			$("table").children("thead").children().children()
			.css({"background-color":"black", "color":"white"});
			
			$("#menu").css({
				"padding-top": "80px"
//	 			,"padding-bottom": "200px"
				,"margin-left": "140px"
			});
			
		});
	</script>
</head>
<body>
	<%@include file="../../common/header.jsp" %>
	<%@include file="/jsp/admin/adminMainBody.jsp" %>
	<div id="wrap_admin_movieRating_manage">
		<div class="container" style="margin-top: 100px">
			<h2 class="title">매출 관리<span></span></h2>
			<hr>
			<figure class="highcharts-figure">
			<div id="container"></div>
				<table id="datatable">
			    <thead>
			      <tr>
			        <th class="headerSort" tabindex="0" role="columnheader button" title="Sort ascending">연도
			        </th>
			        <th class="headerSort" tabindex="0" role="columnheader button" title="Sort ascending">매출액
			        </th>
			        <th>관객수
			        </th>
			      </tr>
			    </thead>
			    <tbody>
			      <tr>
			        <td>2017
			        </td>
			        <td>902667356338	
			        </td>
			        <td>113907067
			        </td>
			      </tr>
			      <tr>
			        <td>2018
			        </td>
			        <td>912746432308	
			        </td>
			        <td>110149287
			        </td>
			      </tr>
			      <tr>
			        <td>2019
			        </td>
			        <td>970793408451	
			        </td>
			        <td>115621862
			        </td>
			      </tr>
			      <tr>
			        <td>2020
			        </td>
			        <td>350412173790	
			        </td>
			        <td>40462371
			        </td>
			      </tr>
			      <tr>
			        <td>2021
			        </td>
			        <td>30208718780
			        </td>
			        <td>3353274
			        </td>
			      </tr>
			    </tbody>
			    <tfoot></tfoot>
			  </table>
			<hr>
		</div>
<!-- 	<hr> -->
	</div>
<!-- 	<hr> -->
	<%@include file="../../common/footer.jsp" %>
</body>
</html>