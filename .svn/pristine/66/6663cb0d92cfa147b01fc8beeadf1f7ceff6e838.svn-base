<%@page import="java.util.List"%>
<%@page import="common.vo.CodeVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% List<CodeVO> timeList = (List)request.getAttribute("timeList"); %>
[
<% for(int i=0 ; i<timeList.size() ; i++) {
		if(i > 0) {
%>
	,
<%
		}
%>
	{
		"cd" : "<%=timeList.get(i).getCd() %>"
		, "cdName" : "<%=timeList.get(i).getCdName() %>"
		, "cdDesc" : "<%=timeList.get(i).getCdDesc() %>"
		, "deleteYn" : "<%=timeList.get(i).getDeleteYn() %>"
	}
<%
	}	
%>

]