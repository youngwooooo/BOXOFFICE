<%@page import="common.vo.TicketingShowVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	List<TicketingShowVO> showList = (List<TicketingShowVO>)request.getAttribute("showList");
%>
[
<%	
	if(showList.size() > 0) {
		for(int i=0 ; i<showList.size() ; i++) {
			TicketingShowVO ticketingShowVO = showList.get(i);
			if(i > 0) {
%>
	,
<% 			} %>
	{
		"showCd" : "<%=ticketingShowVO.getShowCd() %>"
		, "mvCd" : "<%=ticketingShowVO.getMvCd() %>"
		, "mvNameKor" : "<%=ticketingShowVO.getMvNameKor() %>"
		, "cinemaCd" : "<%=ticketingShowVO.getCinemaCd() %>"
		, "cinemaName" : "<%=ticketingShowVO.getCinemaName() %>"
		, "theaterCd" : "<%=ticketingShowVO.getTheaterCd() %>"
		, "theaterNo" : "<%=ticketingShowVO.getTheaterNo() %>"
		, "screenCd" : "<%=ticketingShowVO.getScreenCd() %>"
		, "screenName" : "<%=ticketingShowVO.getScreenName() %>"
		, "showDate" : "<%=ticketingShowVO.getShowDate() %>"
		, "showStartTime" : "<%=ticketingShowVO.getShowStartTime() %>"
		, "showEndTime" : "<%=ticketingShowVO.getShowEndTime() %>"
<%
			if(ticketingShowVO.getFileStoreName() != null) {
%>
		, "fileStoreName" : "<%=ticketingShowVO.getFileStoreName() %>"
<%
			} else {
%>
		, "fileStoreName" : 0
<%		
			}
%>
	}
<%  
		}
	}
%>
]
