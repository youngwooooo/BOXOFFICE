<%@page import="common.vo.TheaterVO"%>
<%@page import="common.vo.SeatVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% 
	TheaterVO theaterVO = (TheaterVO)request.getAttribute("theaterVO");
	List<SeatVO> seatList = (List<SeatVO>)request.getAttribute("seatList");
%>
[
	{
		"theaterCd" : "<%=theaterVO.getTheaterCd() %>"
		, "rowCount" : "<%=theaterVO.getRowCount() %>"
		, "colCount" : "<%=theaterVO.getColCount() %>"
	}
	<% for(int i=0 ; i<seatList.size() ; i++) { 
			SeatVO seatVO = seatList.get(i);
	%>
	, {
		"seatCd" : "<%=seatVO.getSeatCd() %>"
		, "theaterCd" : "<%=seatVO.getTheaterCd() %>"
		, "seatNo" : "<%=seatVO.getSeatNo() %>"
		, "seatTypeCd" : "<%=seatVO.getSeatTypeCd() %>"
		, "deleteYn" : "<%=seatVO.getDeleteYn() %>"
	}
	<% } %>
]