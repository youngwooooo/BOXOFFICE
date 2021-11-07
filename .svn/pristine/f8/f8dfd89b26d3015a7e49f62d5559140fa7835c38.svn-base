<%@page import="common.vo.CodeVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Bootstrap Example</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
	
<script type="text/javascript">

	function readFile(){
	
		var fileList = document.getElementById("atchFile").files;
		
		if(fileList == null || fileList.length == 0){
			alert("선택한 파일이 없습니다.");
			return;
		}
		
		var file = fileList[0];
		var reader = new FileReader();
		
		var arr = file.type.split('/');
		
		if(arr[0] == "image"){
			reader.readAsDataURL(file);
			reader.onload = function(e) {
				document.getElementById("imgresult").src = reader.result;
			}
		}
	
	}
	
	function selectFile(){
		
		$("#number").val();
		
	}
	
	
	
	function duplicateMovieCd(){
		$("#mvCdSpan").text("");
		$("#mvCdSpan").removeClass("text-success");
		$("#mvCdSpan").removeClass("text-danger");
		
		var mvCd = $("#mvCd").val();
		if(mvCd.trim().length == 0){
			alert("영화코드를 입력하세요.");
			$("#mvCd").focus();
			return;
		}
		
		$.ajax({
			url: "/TicketingProject/MovieServlet"
			,type: "get"
			,data: {'mvCd' : mvCd}
			,dataType: "json"
			,success: function(data){
				
				// data = {resultCnt : 0}
				if(data.resultCnt > 0){
					alert("이미 사용중인 코드 입니다.");
					$("#mvCdSpan").text("이미 사용중인 코드 입니다.");
					$("#mvCdSpan").addClass("text-danger");
					$("#mvCd").focus();
					
				}else if(data.resultCnt == 0){
					$("#mvCdSpan").text("사용 가능한 코드 입니다.");
					$("#mvCdSpan").addClass("text-success");
				}else{
					console.log(data);
					alert("오류발생. 관리자에게 문의하세요.");
				}
			}
			,error: function(xhr){
				console.log(xhr);
				alert("오류발생. 관리자에게 문의하세요.");
			}
		});
		
	}
	
	function save(){
		//유효성체크
		return;
		
		
		if(confirm("저장하시겠습니까?")) {
			$("#fm").submit();
		}
		
	}

</script>
<style>
/* Set height of the grid so .sidenav can be 100% (adjust if needed) */
.row.content {
	height: 1500px
}
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
.category{
	font-size: small;
	float: right;
}
button {
	float: right;
	background: black;
	color: white;
}
/* On small screens, set height to 'auto' for sidenav and grid */
@media screen and (max-width: 767px) {
	.sidenav {
		height: auto;
		padding: 15px;
	}
	.row.content {
		height: auto;
	}
}
</style>
</head>
<body>
	<div class="container-fluid">
		<div class="row content">
			<div class="col-sm-2 sidenav">
				<h4>관리자 페이지</h4>
				<hr>
				<ul class="nav nav-pills nav-stacked">
					<li><a href="#section1">Home</a></li>
					<li class="active"><a href="movieregister.jsp">영화관리</a></li>
					<li><a href="#section3">Family</a></li>
					<li><a href="#section3">Photos</a></li>
				</ul>
				<br>
				<div class="input-group">
					<input type="text" class="form-control" placeholder="Search Blog..">
					<span class="input-group-btn">
						<button class="btn btn-default" type="button">
							<span class="glyphicon glyphicon-search"></span>
						</button>
					</span>
				</div>
				<br>
			</div>

			<div class="col-sm-9">
				<h4>
					<small>RECENT POSTS</small>
				</h4>
				<hr>
				<h2>영화등록</h2>
				<br><br><br>
				<div class="row">
					<form id="fm" method="post" enctype="multipart/form-data" action="<%=request.getContextPath() %>/admin/movieInsert.do" class="form-horizontal">
						
						<div class="col-sm-3">
							<img id="imgresult" src="<%=request.getContextPath() %>/images/admin/man.png" class="img-thumbnail" alt="Cinque Terre" width="200px" height="300px" >
							<br><br>
							<input type="file" id="atchFile" name="atchFileCd" onchange="readFile()"></input>
						</div>
					
						<div class="col-sm-9">
							<div class="form-group">
		                     	<label class="control-label col-sm-2" for="mvCd">영화코드</label>
		                     		<div class="col-sm-10 form-inline">
		                    		<input type="text" class="form-control" id="mvCd" name="mvCd">
		                      		<button type="button" onclick="duplicateMovieCd()">중복확인</button>
		                     		<span id="mvCdSpan"></span>
		                     		</div>
		            		</div> 
		            		
		            		<div class="form-group">
		                     	<label class="control-label col-sm-2" for="mvNameKor">영화제목(kor)</label>
		                     		<div class="col-sm-10 form-inline">
		                    		<input type="text" class="form-control" id="mvNameKor"
		                      		name="mvNameKor">
		                     		<span id="mvNameKorSpan"></span>
		                     		</div>
		            		</div> 
		            		<div class="form-group">
		                     	<label class="control-label col-sm-2" for="mvNameEng">영화제목(eng)</label>
		                     		<div class="col-sm-10 form-inline">
		                    		<input type="text" class="form-control" id="mvNameEng"
		                      		name="mvNameEng">
		                     		<span id="mvNameEngSpan"></span>
		                     		</div>
		            		</div>
		            		
		            		<div class="form-group">
		                     	<label class="control-label col-sm-2" for="mvRelDate">개봉일</label>
		                     		<div class="col-sm-10 form-inline">
		                    		<input type="text" class="form-control" id="mvRelDate"
		                      		name="mvRelDate">
		                     		<span id="mvRelDateSpan"></span>
		                     		</div>
		            		</div>
		            		<div class="form-group">
		                     	<label class="control-label col-sm-2" for="mvRatingCd">관람등급</label>
		                     		<div class="col-sm-10 form-inline">
		                    		<input type="text" class="form-control" id="mvRatingCd"
		                      		name="mvRatingCd">
		                     		<span id="mvRatingCdSpan"></span>
		                     		</div>
		            		</div>
		            		<div class="form-group">
		                     	<label class="control-label col-sm-2" for="mvRunningTime">러닝타임</label>
		                     		<div class="col-sm-10 form-inline">
		                    		<input type="text" class="form-control" id="mvRunningTime"
		                      		name="mvRunningTime">
		                     		<span id="mvRunningTimeSpan"></span>
		                     		</div>
		            		</div>
		            		<div class="form-group">
		                     	<label class="control-label col-sm-2" for="director">감독</label>
		                     		<div class="col-sm-10 form-inline">
		                    		<input type="text" class="form-control" id="director"
		                      		name="director">
		                     		<span id="directorSpan"></span>
		                     		</div>
		            		</div>
		            		<div class="form-group">
		                     	<label class="control-label col-sm-2" for="actor">배우</label>
		                     		<div class="col-sm-10 form-inline">
		                    		<input type="text" class="form-control" id="actor"
		                      		name="actor">
		                     		<span id="actorSpan"></span>
		                     		</div>
		            		</div>
		            		<div class="form-group">
		                     	<label class="control-label col-sm-2" for="showYn">상영여부</label>
		                     		<div class="col-sm-10 form-inline">
		                    		<input type="text" class="form-control" id="showYn"
		                      		name="showYn">
		                     		<span id="showYnSpan"></span>
		                     		</div>
		            		</div>
		            		<div class="form-group">
		                     	<label class="control-label col-sm-2" for="mvPlot">줄거리</label>
		                     		<div class="col-sm-10 form-inline">
		                    		<textarea rows="5" cols="30"></textarea>
		                     		<span id="mvPlotSpan"></span>
		                     		</div>
		            		</div>
		           			<div class="form-group">
		                     	<label class="control-label col-sm-2" for="dubbingYn">더빙유무</label>
		                     		<div class="col-sm-10 form-inline">
		                    		<input type="text" class="form-control" id="dubbingYn"
		                      		name="dubbingYn">
		                     		<span id="dubbingYnSpan"></span>
		                     		</div>
		            		</div>
		            		<div class="form-group">
		                     	<label class="control-label col-sm-2" for="mvCompany">제작사</label>
		                     		<div class="col-sm-10 form-inline">
		                    		<input type="text" class="form-control" id="mvCompany"
		                      		name="mvCompany">
		                     		<span id="mvCompanySpan"></span>
		                     		</div>
		            		</div>
		            		<div class="form-group">
		                     	<label class="control-label col-sm-2" for="mvCountry">제작국가</label>
		                     		<div class="col-sm-10 form-inline">
		                    		<input type="text" class="form-control" id="mvCountry"
		                      		name="mvCountry">
		                     		<span id="mvCountrySpan"></span>
		                     		</div>
		            		</div>
		            		<div class="form-group">
		                     	<label class="control-label col-sm-2" for="mvShowStartDate">상영시작일자</label>
	                     		<div class="col-sm-10 form-inline">
		                    		<input type="text" class="form-control" id="mvShowStartDate"
		                      		name="mvShowStartDate">
		                     		<span id="mvShowStartDateSpan"></span>
	                     		</div>
		            		</div>
		            		<div class="form-group">
		                     	<label class="control-label col-sm-2" for="mvShowEndDate">상영종료일자</label>
	                     		<div class="col-sm-10 form-inline">
		                    		<input type="text" class="form-control" id="mvShowEndDate"
		                      		name="mvShowEndDate">
		                     		<span id="mvShowEndDateSpan"></span>
	                     		</div>
		            		</div>
		            		
		            		<div class="form-group">
		                     	<label class="control-label col-sm-2" for="mvShowEndDate">카테고리항목</label>
	                     		<div class="col-sm-10 form-inline">
		                    		<select name="groupCd" onchange="selectFile()" id="number">		                    			
		                    			<%
		                    			List<CodeVO> cv = (List<CodeVO>) request.getAttribute("genreName");
		                    			for(int i=0; i<cv.size() ; i++){%>
		                    			<option> 
		                    			<%=cv.get(i).getCdName() %>
		                    			</option>
		                    			<%} %>	                    			
		                    		</select>
		                     		<span id="mvShowEndDateSpan"></span>
	                     		</div>
		            		</div>
            		
		           		   <div class="form-group lastRow">
				               <div class="col-sm-offset-2 col-sm-13">
				                  <button type="button" class="btn btn-default"><a href="movielist.do">취소</a></button>
								  <button type="reset" class="btn btn-default">재작성</button>
								  <button type="submit" class="btn btn-default" >저장</button>
				               </div>
				            </div>
			            </div>
            		
            		</form>
				</div>
			</div>
		</div>
	</div>
	<footer class="container-fluid">
		<p>Footer Text</p>
	</footer>
</body>
</html>
