<%@page import="common.vo.AtchMovieVO"%>
<%@page import="common.vo.AtchFileVO"%>
<%@page import="common.vo.PagingVO"%>
<%@page import="common.vo.MovieVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
   
<%
   PagingVO pagingVO = (PagingVO) request.getAttribute("pagingVO");
   
   
   List<AtchMovieVO> atchMovieList = (List<AtchMovieVO>)request.getAttribute("atchMovieList");
   
   AtchFileVO atchfileVO = (AtchFileVO) request.getAttribute("atchfileVO");
  // List<AtchFileVO> atchFileList = (List<AtchFileVO>)request.getAttribute("atchFileList");
   
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
</style>
</head>
<body>
	<%@include file="../../common/header.jsp" %>
   <div class="container-fluid">
      <div class="row content">
      	<br><br><br><br><br><br>
         
        
        
        
        <div class="col-sm-2 sidenav">
         	
           <%@include file="/jsp/admin/adminMainBody.jsp" %>
         </div>
         
         <br><br><br><br><br>
         <div class="col-sm-9">
           
            <div class="container">
            
            
            <div class="category">
               <a style="float: right; margin-right: 250px;" href="">카테고리관리</a> 
            </div>
            <h2>영화관리</h2>
            

            <br> <br>
			
			
               <div class="category">
                  <button type="button" class="btn btn-default" style="float: right; margin-right: 250px;"><a href="movieInsert.do">영화등록</a></button>
               </div>
               
            

            <br>
            
            
            
            
            <div class="col-sm-9">
             
             		<%
			               int movieSize = atchMovieList.size();
			                                          
			               if(movieSize > 0){
			                  for(int i=0; i<movieSize; i++){               
			            %>
                              
            
            
               <div class="col-xs-3" >
                  <div class="card h-100">
                     
                     
                      <% 
                       		if (atchMovieList != null) {
                       		 if(atchMovieList.get(i).getAtchFileCd() > 0){
                    	%> 
                    	
                     		<img  class="card-img-top"  width="200px" height="200px"  alt="ㅋㅋ" src="<%=request.getContextPath()%>/filedownload.do?fileId=<%=atchMovieList.get(i).getAtchFileCd()%>&fileSn=<%=atchMovieList.get(i).getFileSn()%>">
							<%=atchMovieList.get(i).getFileOrignName()%> 
                     
                     
                     <% 
                      			
                       		} else {
                    	%> 
                      			<img class="card-img-top" src="<%=request.getContextPath()%>/images/admin/noimage.png" width="200px" height="200px"  alt="ㅋㅋ">
                    
                     
                     <%
							}
                       	}
						%>
						
						
					  
                     
                     <div class="card-body">
                        <br>
                           <div>
                           <span>영화코드:</span>
                           
                           <span><%=atchMovieList.get(i).getMvCd()%></span>
                        </div>
                        <div>
                           <span>영화제목:</span>
                           <span><%=atchMovieList.get(i).getMvNameKor()%></span>
                        </div>
<!--                         <div> -->
<!--                            <span>감독일:</span> -->
<%--                            <span><%=atchMovieList.get(i).getDirector()%></span> --%>
<!--                         </div> -->
<!--                         <div> -->
<!--                            <span>개봉일:</span> -->
<%--                            <span><%=atchMovieList.get(i).getMvRelDate()%></span> --%>
<!--                      </div> -->
                     
                  </div>
                  <br>
                  <div class="card-footer">
                     <button type="button" class="btn btn-default"><a href="movieUpdate.do?mvCd=<%= atchMovieList.get(i).getMvCd()%>">수정</a></button>
                     <button type="button" class="btn btn-default"><a href="movieDelete.do?mvCd=<%= atchMovieList.get(i).getMvCd()%>">삭제</button>
                  </div>
               </div>
               
               
      
         </div>  
      
      
         <%
                  }
                  
               }
                  
         %>
         
       
       	</div>
 	
 	</div>
         
         <!-- 페이징처리시작 -->
      
      <div align="center">
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
      
      
       
      
   
      
    
 
<!--  	<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br> -->

    <%@include file="../../common/footer.jsp" %>
</body>
</html>