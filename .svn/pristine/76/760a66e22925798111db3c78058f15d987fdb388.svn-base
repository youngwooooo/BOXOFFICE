<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.ArrayList"%>
<%@page import="common.vo.DetailMemberVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	List<DetailMemberVO> memDetailList = (List<DetailMemberVO>)request.getAttribute("memDetailList");
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
%>    
[

<% 
	for(int i=0; i<memDetailList.size(); i++){
		String memAddr = memDetailList.get(i).getMemZip() + " " + memDetailList.get(i).getMemAddr1() + " " + memDetailList.get(i).getMemAddr2();
%>
	{
		"memCd" : "<%=memDetailList.get(i).getMemCd() %>"
		, "memId" : "<%=memDetailList.get(i).getMemId() %>"
		, "memName" : "<%=memDetailList.get(i).getMemName() %>"
		, "memBir" : "<%=sdf.format(memDetailList.get(i).getMemBir()) %>"
		, "MsName" : "<%=memDetailList.get(i).getMsName() %>"
		, "memMileage" : "<%=memDetailList.get(i).getMemMileage() %>"
		, "memHp" : "<%=memDetailList.get(i).getMemHp() %>"
		, "memMail" : "<%=memDetailList.get(i).getMemMail() %>"
		, "cdName" : "<%=memDetailList.get(i).getCdName() %>"
		, "memAddr" : "<%=memAddr %>"
		, "joinDate" : "<%=sdf.format(memDetailList.get(i).getJoinDate()) %>"
		, "manageYn" : "<%=memDetailList.get(i).getManagerYn() %>"
	}	
<%		
	}
%>


]

