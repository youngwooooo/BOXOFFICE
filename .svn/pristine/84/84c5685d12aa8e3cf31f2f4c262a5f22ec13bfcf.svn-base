<%@page import="common.vo.CinemaVO"%>
<%@page import="common.vo.MovieVO"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	Map<String, Object> mapForSetMain = (Map<String, Object>)request.getAttribute("mapForSetMain");

	List<MovieVO> movieList = (List<MovieVO>)mapForSetMain.get("movieList");
	List<CinemaVO> cinemaList = (List<CinemaVO>)mapForSetMain.get("cinemaList");
%>

[
	<% for(int i=0 ; i<movieList.size() ; i++) {
			MovieVO movieVO = movieList.get(i);
			if(i > 0) {
	%>
	,
	<%
			}
	%>
	{
		"flag" : "m"
		, "mvCd" : "<%=movieVO.getMvCd() %>"
		, "mvName" : "<%=movieVO.getMvNameKor() %>"
<%
			if(movieVO.getFileStoreName() != null) {
%>
		, "fileStoreName" : "<%=movieVO.getFileStoreName() %>"
<%
			} else {
%>
		, "fileStoreName" : 0
<%		
			}
%>
	}
	<% } %>
	
	<% for(int i=0 ; i<cinemaList.size() ; i++) {
			CinemaVO cinemaVO = cinemaList.get(i);
			if(movieList.size() == 0) {
				if(i > 0) {
	%>
		,
	<%
				}
			} else {
	%>
		,
	<%	
			}
	%>
	{
		"flag" : "c"
		, "cinemaCd" : "<%=cinemaVO.getCinemaCd() %>"
		, "cinemaName" : "<%=cinemaVO.getCinemaName() %>"
	}
	<% } %>
	
]
