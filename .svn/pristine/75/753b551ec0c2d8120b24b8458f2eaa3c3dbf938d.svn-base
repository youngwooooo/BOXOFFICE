<%@page import="common.vo.PagingVO"%>
<%@page import="java.util.List"%>
<%@page import="common.vo.CodeVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% List<CodeVO> list = (List)request.getAttribute("list"); %>
[
	<% for(int i=0 ; i<list.size() ; i++) {
			if(i > 0) {
	%>
		,
	<%
			}
	%>
		{
			"groupCd" : "<%=list.get(i).getGroupCd() %>"
			, "groupCdName" : "<%=list.get(i).getGroupCdName() %>"
			, "cd" : "<%=list.get(i).getCd() %>"
			, "cdName" : "<%=list.get(i).getCdName() %>"
			, "cdDesc" : "<%=list.get(i).getCdDesc() %>"
			, "deleteYn" : "<%=list.get(i).getDeleteYn() %>"
		}
	<%
		}	
	%>
]



