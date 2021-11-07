<%@page import="common.vo.SeatVO"%>
<%@page import="java.util.List"%>
<%@page import="common.vo.TheaterVO"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% 
	List<SeatVO> seatList = (List<SeatVO>)request.getAttribute("seatList");
%>
[
	<% for(int i=0 ; i<seatList.size() ; i++) { 
			SeatVO seatVO = seatList.get(i);
			if(i > 0) { %>
	,
	<%
			} 
	%>
	{
		"seatCd" : "<%=seatVO.getSeatCd() %>"
		, "theaterCd" : "<%=seatVO.getTheaterCd() %>"
		, "seatNo" : "<%=seatVO.getSeatNo() %>"
		, "seatTypeCd" : "<%=seatVO.getSeatTypeCd() %>"
		, "deleteYn" : "<%=seatVO.getDeleteYn() %>"
	}
	<% } %>
]