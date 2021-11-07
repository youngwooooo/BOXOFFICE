<%@page import="common.vo.CinemaVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% List<CinemaVO> list = (List)request.getAttribute("list"); %>
[
<% for(int i=0 ; i<list.size() ; i++) {
		if(i > 0) {
%>
	,
<%
		}
%>
	{
		"cinemacd" : "<%=list.get(i).getCinemaCd() %>"
		, "cinemaName" : "<%=list.get(i).getCinemaName() %>"
		, "cinemaTel" : "<%=list.get(i).getCinemaTel() %>"
		, "cinemaTheaterCount" : "<%=list.get(i).getTheaterCount() %>"
		, "cinemaStatusCd" : "<%=list.get(i).getCinemaStatusCd() %>"
	}
<%
	}	
%>

]