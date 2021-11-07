<%@page import="java.util.List"%>
<%@page import="common.vo.CodeVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% List<CodeVO> audienceList = (List)request.getAttribute("audienceList"); %>
[
<% for(int i=0 ; i<audienceList.size() ; i++) {
		if(i > 0) {
%>
	,
<%
		}
%>
	{
		"cd" : "<%=audienceList.get(i).getCd() %>"
		, "cdName" : "<%=audienceList.get(i).getCdName() %>"
		, "cdDesc" : "<%=audienceList.get(i).getCdDesc() %>"
		, "deleteYn" : "<%=audienceList.get(i).getDeleteYn() %>"
	}
<%
	}	
%>

]