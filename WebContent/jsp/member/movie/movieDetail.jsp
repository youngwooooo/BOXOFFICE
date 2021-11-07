<%@page import="java.util.List"%>
<%@page import="common.vo.AtchFileVO"%>
<%@page import="common.vo.MovieVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%
	MovieVO movieVO = (MovieVO) request.getAttribute("movieVO");

	List<AtchFileVO> atchFileList = (List<AtchFileVO>) request.getAttribute("atchFileList");
%>
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

.category {
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
				<h2>영화상세페이지</h2>

				<br> <br> <br>



				<div class="row">



					<form method="post" enctype="multipart/form-data"
						action="<%=request.getContextPath()%>/admin/movieUpdate.do"
						class="form-horizontal">

						<%
							if (atchFileList != null) {
								for (AtchFileVO fileVO : atchFileList) {
						%>

						<div class="col-sm-3">
							<img
								src="<%=request.getContextPath()%>/images/admin/<%=fileVO.getFileOrignName()%>"
								class="img-thumbnail" alt="<%=fileVO.getFileOrignName()%>"
								width="200px" height="300px">
						</div>

						<%
							}

							} else {
						%>

						<div class="col-sm-3">
							<img
								src="<%=request.getContextPath()%>/images/admin/noimage.png"
								class="img-thumbnail" alt="" width="200px" height="300px">
						</div>

						<%
							}
						%>


						<div class="col-sm-9">

							<div class="form-group">
								<label class="control-label col-sm-2" for="mvCd">영화코드</label>
								<div class="col-sm-10 form-inline">
									<input type="text" class="form-control" id="mvCd" name="mvCd"
										readonly="readonly" value="<%=movieVO.getMvCd()%>"> <span
										id="mvCdSpan"></span>
								</div>
							</div>

							<div class="form-group">
								<label class="control-label col-sm-2" for="mvNameKor">영화제목(kor)</label>
								<div class="col-sm-10 form-inline">
									<input type="text" class="form-control" id="mvNameKor"
										readonly="readonly" name="mvNameKor" value="<%=movieVO.getMvNameKor()%>">
									<span id="mvNameKorSpan"></span>
								</div>
							</div>

							<div class="form-group">
								<label class="control-label col-sm-2" for="mvNameEng">영화제목(eng)</label>
								<div class="col-sm-10 form-inline">
									<input type="text" class="form-control" id="mvNameEng"
										readonly="readonly" name="mvNameEng" value="<%=movieVO.getMvNameEng()%>">
									<span id="mvNameEngSpan"></span>
								</div>
							</div>

							<div class="form-group">
								<label class="control-label col-sm-2" for="mvRelDate">개봉일</label>
								<div class="col-sm-10 form-inline">
									<input type="text" class="form-control" id="mvRelDate"
										readonly="readonly" name="mvRelDate" value="<%=movieVO.getMvRelDate()%>">
									<span id="mvRelDateSpan"></span>
								</div>
							</div>

							<div class="form-group">
								<label class="control-label col-sm-2" for="mvRatingCd">관람등급</label>
								<div class="col-sm-10 form-inline">
									<input type="text" class="form-control" id="mvRatingCd"
										readonly="readonly" name="mvRatingCd" value="<%=movieVO.getMvRatingCd()%>">
									<span id="mvRatingCdSpan"></span>
								</div>
							</div>

							<div class="form-group">
								<label class="control-label col-sm-2" for="mvRunningTime">러닝타임</label>
								<div class="col-sm-10 form-inline">
									<input type="text" class="form-control" id="mvRunningTime"
										readonly="readonly" name="mvRunningTime" value="<%=movieVO.getMvRunningTime()%>">
									<span id="mvRunningTimeSpan"></span>
								</div>
							</div>

							<div class="form-group">
								<label class="control-label col-sm-2" for="director">감독</label>
								<div class="col-sm-10 form-inline">
									<input type="text" class="form-control" id="director"
										readonly="readonly" name="director" value="<%=movieVO.getDirector()%>"> <span
										id="directorSpan"></span>
								</div>
							</div>

							<div class="form-group">
								<label class="control-label col-sm-2" for="actor">배우</label>
								<div class="col-sm-10 form-inline">
									<input type="text" class="form-control" id="actor" name="actor"
										readonly="readonly" value="<%=movieVO.getActor()%>"> <span id="actorSpan"></span>
								</div>
							</div>

							<div class="form-group">
								<label class="control-label col-sm-2" for="showYn">상영여부</label>
								<div class="col-sm-10 form-inline">
									<input type="text" class="form-control" id="showYn"
										readonly="readonly" name="showYn" value="<%=movieVO.getShowYn()%>"> <span
										id="showYnSpan"></span>
								</div>
							</div>


							<div class="form-group">
								<label class="control-label col-sm-2" for="mvPlot">줄거리</label>
								<div class="col-sm-10 form-inline">
									<textarea rows="5" cols="30" readonly="readonly"> <%=movieVO.getMvPlot()%></textarea>
									<span id="mvPlotSpan"></span>
								</div>
							</div>

							<div class="form-group">
								<label class="control-label col-sm-2" for="dubbingYn">더빙유무</label>
								<div class="col-sm-10 form-inline">
									<input type="text" class="form-control" id="dubbingYn"
										readonly="readonly" name="dubbingYn" value="<%=movieVO.getDubbingYn()%>">
									<span id="dubbingYnSpan"></span>
								</div>
							</div>

							<div class="form-group">
								<label class="control-label col-sm-2" for="mvCompany">제작사</label>
								<div class="col-sm-10 form-inline">
									<input type="text" class="form-control" id="mvCompany"
										readonly="readonly" name="mvCompany" value="<%=movieVO.getMvCompany()%>">
									<span id="mvCompanySpan"></span>
								</div>
							</div>

							<div class="form-group">
								<label class="control-label col-sm-2" for="mvCountry">제작국가</label>
								<div class="col-sm-10 form-inline">
									<input type="text" class="form-control" id="mvCountry"
										readonly="readonly" name="mvCountry" value="<%=movieVO.getMvCountry()%>">
									<span id="mvCountrySpan"></span>
								</div>
							</div>




							<div class="form-group">
								<label class="control-label col-sm-2" for="mvShowStartDate">상영시작일자</label>
								<div class="col-sm-10 form-inline">
									<input type="text" class="form-control" id="mvShowStartDate"
										readonly="readonly" name="mvShowStartDate"
										value="<%=movieVO.getMvShowStartDate()%>"> <span
										id="mvShowStartDateSpan"></span>
								</div>
							</div>

							<div class="form-group">
								<label class="control-label col-sm-2" for="mvShowEndDate">상영종료일자</label>
								<div class="col-sm-10 form-inline">
									<input type="text" class="form-control" id="mvShowEndDate"
										readonly="readonly" name="mvShowEndDate" value="<%=movieVO.getMvShowEndDate()%>">
									<span id="mvShowEndDateSpan"></span>
								</div>
							</div>

							<div class="form-group">
								<label class="control-label col-sm-2" for="mvShowEndDate">상영종료일자</label>
								<div class="col-sm-10 form-inline">
									<input type="text" class="form-control" id="mvShowEndDate"
										readonly="readonly" name="mvShowEndDate" value="<%=movieVO.getMvShowEndDate()%>">
									<span id="mvShowEndDateSpan"></span>
								</div>
							</div>

							



							<div class="form-group lastRow">
								<div class="col-sm-offset-2 col-sm-13">
									<button type="button" class="btn btn-default">
										<a href="movielist.do">취소</a>
									</button>
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
