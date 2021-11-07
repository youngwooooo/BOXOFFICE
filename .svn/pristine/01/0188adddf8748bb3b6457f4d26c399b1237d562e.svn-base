<%@page import="common.vo.PagingVO"%>
<%@page import="common.vo.CodeVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

%>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
  <style>
    /* Set height of the grid so .sidenav can be 100% (adjust if needed) */
    .row.content {height: 1500px}
    
    /* Set gray background color and 100% height */
    .sidenav {
      background-color: #f1f1f1;
      height: 100%;
    }
    
    /* Set black background color, white text and some padding */
    footer {
      background-color: #555;
      color: white;
      padding: 15px;
    }
    
    /* On small screens, set height to 'auto' for sidenav and grid */
    @media screen and (max-width: 767px) {
      .sidenav {
        height: auto;
        padding: 15px;
      }
      .row.content {height: auto;} 
    }

  </style>
  <script type="text/javascript">
  	$(function(){
  		$.ajax({
  			url : "/TicketingProject/admin/movieRatingList.do"
  			, type : "post"
//   		, data : ""
			, dataType : "json"
			, success : function(data){
				makeTable(data);
			}
			, error : function(xhr){
				alert("오류");
				console.log(xhr)
			}

  		});
  	});
  
  	function addTd(){
  		var td = "<tr>"
  			+ "<td><input type='checkbox'></td>"
  			+ "<td><input type='hidden' name='groupCd' value='A01'>A01</td>"
  			+ "<td><input type='text' name='groupCdName'></td>"
  			+ "<td><input type='text' name='cd'style='width: 100%;'></td>"
  			+ "<td><input type='text' name='cdName' style='width: 100%;'></td>"
  			+ "<td><input type='text' name='cdDesc' style='width: 100%;'></td>"
  			+ "<td><input type='text' name='deleteYn' style='width: 100%;'></td>"
  			+ "</tr>";

  		
  		$("#movieRatingTable tbody").append(td);
  	}
  	
  	function makeTable(data){
  		$("#movieRatingTable tbody").empty;
  		
  		str = "";
  		if(data.length == 0){
  			str += "<tr><td colspan=7>관람등급 조회결과가 존재하지 않습니다.</td></tr>"
  		}else {
	  		for(var i=0; i<data.length; i++){
	  			str += "<tr>"
	  					+ "<td><input type='checkbox' name='checkedVal'></td>"
	  					+ "<td>" + data[i].groupCd + "</td>"
	  					+ "<td>" + data[i].groupCdName + "</td>"
	  					+ "<td id='cdVal'>" + data[i].cd + "</td>"
	  					+ "<td>" + data[i].cdName + "</td>"
	  					+ "<td>" + data[i].cdDesc + "</td>"
	  					+ "<td>" + data[i].deleteYn + "</td>"
	  					+ "</tr>";
	  		}
  			$("#movieRatingTable tbody").append(str);
  		}
  	}
  	
  	function saveData(){
  		var param = {
  						groupCd : $("[name='groupCd']").val()
  						, groupCdName : $("[name='groupCdName']").val()
  						, cd : $("[name='cd']").val()
  						, cdName : $("[name='cdName']").val()
  						, cdDesc : $("[name='cdDesc']").val()
  						, deleteYn : $("[name='deleteYn']").val()
  					};
  		console.log(param);
  		$.ajax({
  			url : "/TicketingProject/admin/movieRatingInsert.do"
  			, type : "post"
  			, data : param
  			, dataType : "json"
  			, success : function(data){
  				if(data.result == 1){
  					alert("데이터 받기 성공");
  	  				console.log(data);	
  				}
  				
  			}
  			, error : function(xhr){
  				alert("오류")
  				console.log(xhr);
  			}
  			
  		});
  		
  	}
  	
  	function deleteData(){
  		var checked = $("input:checked")
  		if(checked.length == 0){
  			alert("삭제할 데이터를 선택해주세요.");
  		}else{
  			var param = checked.parent().children("#cdVal");
  			console.log(param);
  		}
  		
  		
//   		var url = "movieRatingDelete.do?cd=" + param;
//   		location.href =  url;
  	}
  </script> 
</head>
<body>

<div class="container-fluid">
  <div class="row content">
    <div class="col-sm-2 sidenav">
      <h4>관리자 페이지</h4>
      <ul class="nav nav-pills nav-stacked">
        <li><a href="adminMain.jsp">Home</a></li>
        <li><a href="memberManagement.jsp">회원 관리</a></li>
        <li><a href="#">영화 관리</a></li>
        <li class="active"><a href="movieRating.jsp">관람등급 관리</a></li>
        <li><a href="#">상영 관리</a></li>
        <li><a href="#">스낵 관리</a></li>
        <li><a href="#">지점 관리</a></li>
        <li><a href="#">게시판 관리</a></li>
        <li><a href="#">요금 및 등급 관리</a></li>
        <li><a href="#">매출 관리</a></li>
      </ul><br>
</div>
    <div class="col-sm-10">
       <h1 class="h3 mb-2 text-gray-800">관람등급 목록</h1>
       	<hr>
            <div class="table-responsive">
            <form id="fm">
                <table class="table table-bordered" id="movieRatingTable">
                <colgroup>
                	<col width="50px;">
                	<col width="110px;">
                	<col width="150px;">
                	<col width="150px;">
                	<col width="200px;">
                	<col width="auto;">
                	<col width="100px;">
                </colgroup>
                    <thead>
                        <tr>
                        	<th>선택</th>
                            <th>그룹 코드</th>
                            <th>그룹코드 이름</th>
                            <th>관람등급 코드</th>
                            <th>관람등급 코드이름</th>
                            <th>관람등급 설명</th>
                            <th>삭제여부</th>
                        </tr>
                    </thead>
                    <tbody>
                   
                    </tbody>
                </table>
               </form>
            </div>
            <div>
	            <button type="button" onclick="addTd()">등록</button>
	            <button type="button" onclick="saveData()">저장</button>
	            <button type="button" onclick="deleteData()">삭제</button>
            </div>
        </div>
    </div>
</div>


<footer class="container-fluid">
  <p>Footer Text</p>
</footer>

</body>
</html>