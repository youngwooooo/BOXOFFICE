<%@page import="java.util.List"%>
<%@page import="common.vo.ShowTimetableVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
[
<%
List<ShowTimetableVO> showTimetableList = (List<ShowTimetableVO>)request.getAttribute("showTimetableList");
for(int i=0; i<showTimetableList.size(); i++) {
	if(i > 0) {
		%>,<% 
	}
	%>
	{
		"cinemaCd" : "<%=showTimetableList.get(i).getCinemaCd() %>"
		, "mvCd" : "<%=showTimetableList.get(i).getMvCd() %>"
		, "showCd" : "<%=showTimetableList.get(i).getShowCd() %>"
		, "showDate" : "<%=showTimetableList.get(i).getShowDate() %>"
		, "showEndTime" : "<%=showTimetableList.get(i).getShowEndTime() %>"
		, "showStartTime" : "<%=showTimetableList.get(i).getShowStartTime() %>"
		, "theaterCd" : "<%=showTimetableList.get(i).getTheaterCd() %>"
		, "mvNameKor" : "<%=showTimetableList.get(i).getMvNameKor() %>"
	}
	<%
}
%>
]