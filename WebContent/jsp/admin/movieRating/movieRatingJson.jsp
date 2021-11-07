<%@page import="java.util.List"%>
<%@page import="common.vo.CodeVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% List<CodeVO> movieRatingList = (List)request.getAttribute("movieRatingList"); %>
[
<% for(int i=0 ; i<movieRatingList.size() ; i++) {
		if(i > 0) {
%>
	,
<%
		}
%>
	{
		"cd" : "<%=movieRatingList.get(i).getCd() %>"
		, "cdName" : "<%=movieRatingList.get(i).getCdName() %>"
		, "cdDesc" : "<%=movieRatingList.get(i).getCdDesc() %>"
		, "deleteYn" : "<%=movieRatingList.get(i).getDeleteYn() %>"
	}
<%
	}	
%>

]