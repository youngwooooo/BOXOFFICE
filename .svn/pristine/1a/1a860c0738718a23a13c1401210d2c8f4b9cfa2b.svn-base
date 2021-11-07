<%@page import="java.util.List"%>
<%@page import="common.vo.CodeVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% List<CodeVO> seatList = (List)request.getAttribute("seatList"); %>
[
<% for(int i=0 ; i<seatList.size() ; i++) {
		if(i > 0) {
%>
	,
<%
		}
%>
	{
		"cd" : "<%=seatList.get(i).getCd() %>"
		, "cdName" : "<%=seatList.get(i).getCdName() %>"
		, "cdDesc" : "<%=seatList.get(i).getCdDesc() %>"
		, "deleteYn" : "<%=seatList.get(i).getDeleteYn() %>"
	}
<%
	}	
%>

]