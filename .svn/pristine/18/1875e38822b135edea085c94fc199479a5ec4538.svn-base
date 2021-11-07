<%@page import="common.vo.PostVO"%>
<%@page import="common.vo.PagingVO"%>
<%@page import="java.util.List"%>
<%@page import="common.vo.CodeVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% List<PostVO> list = (List<PostVO>)request.getAttribute("list"); %>
{
	"list" : [
				<% for(int i=0 ; i<list.size() ; i++) {
						if(i > 0) {
				%>
					,
				<%
						}
				%>
					{
						"boardName" : "<%=list.get(i).getBoardName() %>"						
						, "postTitle" : "<%=list.get(i).getPostTitle() %>"
						, "postDate" : "<%=list.get(i).getPostDate() %>"
						, "postView" : "<%=list.get(i).getPostView() %>"						
					}
				<%
				}	
				%>
				]				
	<%
	PagingVO pagingVO = (PagingVO)request.getAttribute("pagingVO");
		
	int totalCount = pagingVO.getTotalCount();
	int currentPageNo = pagingVO.getCurrentPageNo();
	int countPerPage = pagingVO.getCountPerPage();
	int pageSize = pagingVO.getPageSize();
	int firstPageNo = pagingVO.getFirstPageNo();
	int lastPageNo = pagingVO.getLastPageNo();
	int firstRecNo = pagingVO.getFirstRecNo();
	int lastRecNo = pagingVO.getLastRecNo();
	int totalPageCount = pagingVO.getTotalPageCount();
	%>
	, "pagingVO" : {
						"totalCount" : "<%=totalCount %>"
						, "currentPageNo" : "<%=currentPageNo  %>"
						, "countPerPage" : "<%=countPerPage %>"
						, "pageSize" : "<%=pageSize %>"
						, "firstPageNo" : "<%=firstPageNo %>"
						, "lastPageNo" : "<%=lastPageNo %>"
						, "firstRecNo" : "<%=firstRecNo %>"
						, "lastRecNo" : "<%=lastRecNo %>"
						, "totalPageCount" : "<%=totalPageCount %>"
					}
	
}



