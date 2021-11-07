<%@page import="common.vo.AtchFileVO"%>
<%@page import="common.vo.PagingVO"%>
<%@page import="common.vo.MovieVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
   
<%
   List<MovieVO> movieList = (List<MovieVO>)request.getAttribute("movieList");
   PagingVO pagingVO = (PagingVO) request.getAttribute("pagingVO");
	
   List<AtchFileVO> atchFileList = (List<AtchFileVO>)request.getAttribute("atchFileList");
   
%>    

<!DOCTYPE html>
<html lang="en">
<head>
<title>박스오피스 | 영화</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
   href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
   src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
   src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<style>

<<<<<<< .mine



.row.content {
   height: 1500px
}

/* Set gray background color and 100% height */


/* Set black background color, white text and some padding */
footer {
   background-color: #555;
   color: white;
   padding: 15px;
}


.category{
   font-size: small;
}

button {
   background: black;
   color: white;
}


.pagination {
	align: center;
}

* {
	align-items: center;
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
||||||| .r174619



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
}

button {
   background: black;
   color: white;
}


.pagination {
	align: center;
}

* {
	align-items: center;
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
=======
	#wrap_admin_seat_manage {
				width: 1000px;
				margin: 0 auto;
				display: flex;
				flex-flow: row nowrap;
				justify-content: center;
			}
			
	#divPage {
				width: 1000px;
	/* 			margin-top: 95px; */
				margin-bottom: 116px;
				margin-left: 22%;
				margin-right: 22%;
			}
			
	.category{
	   font-size: small;
	}
	
	button {
	   background: black;
	   color: white;
	}
	
	
	.pagination {
		align: center;
	}
	
	* {
		align-items: center;
	}
	
	#btn{
		float: right;
		margin-top: 20px;
		width: 100%;
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
   <%@include file="../../common/header.jsp" %>
   
   <div class="container-fluid">
      <div class="row content">
      <%@include file="/jsp/admin/adminMainBody.jsp" %>

        
        
         <div class="col-sm-9">
           
            <div class="container">
            
            
            <div class="category">
               <a style="float: right; margin-right: 250px;" href="">카테고리관리</a> 
            </div>
            <h2>영화관리</h2>
            

  
<!--    <div class="container-fluid"> -->
<!--       <div class="row content"> -->
      
      	<div id="divPage">
			<div id="wrap_admin_seat_manage">
				<div class="container" style="margin-top: 100px">
					<h2 class="title" style="font-size: 4rem; margin-left: 448px;">영화
					</h2>
		         	<div>
			<hr>
<!--             <div class="container"> -->
            <br>
>>>>>>> .r174768
			<div class="col-sm-8" align="center">
<!-- 	            <div class="input-group"> -->
<!-- 	               <input type="text" class="form-control" placeholder="영화를 입력해주세요"> -->
<!-- 	               <span class="input-group-btn"> -->
<!-- 	                  <button class="btn btn-default" type="button"> -->
<!-- 	                     <span class="glyphicon glyphicon-search"></span> -->
<!-- 	                  </button> -->
<!-- 	               </span>  -->
<!-- 	             </div> -->
	             <br>
             </div>
<!--                <div class="category"> -->
<!--                   <button type="button" class="btn btn-default"><a href="movieInsert.do">영화등록</a></button> -->
<!--                </div> -->
            <br>
			<div class="col-sm-12">
           		<%
	               int movieSize = movieList.size();
	                                          
	               if(movieSize > 0){
	                  for(int i=0; i<movieSize; i++){               
	            %>
			<div class="col-xs-3" >
				<div class="card h-100">
                     <a href="#">
                     
                      <%--  <% 
                       		if (atchFileList != null) {
                    			for(AtchFileVO fileVO : atchFileList){
                    	%> --%> 
                     		<%-- img class="card-img-top" src="<%=request.getContextPath()%>/images/admin/<%=fileVO.getFileOrignName()%>" width="200px" height="200px"  alt="ㅋㅋ"></a> --%>
                     	<%-- <% 
                      			}
                       		} else {
                    	%> --%>
                    	
                    	
                      	
                      	<a href="movieUpdate.do?mvCd=<%= movieList.get(i).getMvCd()%>"><img class="card-img-top" src="<%=request.getContextPath()%>/images/admin/noimage.png" width="200px" height="200px"  alt="ㅋㅋ"></a>
                     
                     
                     <%-- 	<%
							}
						%> --%>
						
					<div class="card-body">
                        <br>
<!--                            <div> -->
<!-- 	                           <span>영화코드:</span> -->
	                           
<%-- 	                           <span><%=movieList.get(i).getMvCd()%></span> --%>
<!-- 	                        </div> -->
	                        <div>
	                           <span>영화제목:</span>
	                           <span><%=movieList.get(i).getMvNameKor()%></span>
	                        </div>
	                        <div>
	                           <span>감독일:</span>
	                           <span><%=movieList.get(i).getDirector()%></span>
	                        </div>
	                        <div>
	                           <span>개봉일:</span>
	                           <span><%=movieList.get(i).getMvRelDate()%></span>
	                    	</div>
	                        <div>
	                           <span>영화장르:</span>
	                           <span><%=movieList.get(i).getMvRelDate()%></span>
	                    	</div>
	                  </div>
                  	  <br>
                  	  </div>
      		</div>  
      
      
         <%
                  }
                  
               }
                  
         %>
         
       
       	</div>
 	
 	</div>
         
         <!-- 페이징처리시작 -->
      
      <div id="btn" align="center">
	      <ul class="pagination" >
	         
	         <li >
	            <%if(pagingVO.getFirstPageNo()> pagingVO.getPageSize()){ // %>
	            <a href="<%=request.getContextPath() %>/admin/movielist.do?pageNo=<%=pagingVO.getFirstPageNo() - pagingVO.getPageSize() %>">[이전]</a>   
	            <% }%>
	            <%for(int pNo = pagingVO.getFirstPageNo(); pNo <= pagingVO.getLastPageNo(); pNo++) { %>
	            <a <%if(pNo == pagingVO.getCurrentPageNo()){ %> style="background-color: black; color:white" <%} %> href="<%=request.getContextPath() %>/admin/movielist.do?pageNo=<%=pNo %>"><%=pNo %></a>
	            <% }%>
	            <%if(pagingVO.getLastPageNo() < pagingVO.getTotalPageCount()){ // %>
	            <a href="<%=request.getContextPath() %>/admin/movielist.do?pageNo=<%=pagingVO.getFirstPageNo() + pagingVO.getPageSize() %>">[이후]</a>   
	            <% }%>
	         </li>
	      </ul>
      </div>
      </div>
      </div>
      </div>
<!--       </div> -->
 
<!--  	<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br> -->

    <%@include file="../../common/footer.jsp" %>
</body>
</html>