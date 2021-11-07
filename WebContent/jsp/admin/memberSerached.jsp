<%@page import="java.text.SimpleDateFormat"%>
<%@page import="common.vo.MemberVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	List<MemberVO> memSearchList = (List<MemberVO>)request.getAttribute("memSearchList");
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
%>
[
<% if(memSearchList.size() > 0){
	for(int i=0; i<memSearchList.size(); i++){
%>
	{
	 "rowNum" : "1"
     , "memCd" : "<%=memSearchList.get(i).getMemCd() %>"
     , "memId" : "<%=memSearchList.get(i).getMemId() %>"
     , "memName" : "<%=memSearchList.get(i).getMemName() %>"
     , "memBir" : "<%=sdf.format(memSearchList.get(i).getMemBir()) %>"
     , "msName" : "<%=memSearchList.get(i).getMsName() %>"
     , "memHp" : "<%=memSearchList.get(i).getMemHp() %>"
     , "memMail" : "<%=memSearchList.get(i).getMemMail() %>"
     , "joinDate" : "<%=sdf.format(memSearchList.get(i).getJoinDate()) %>"
     , "managerYn" : "<%=memSearchList.get(i).getManagerYn() %>"
	}
<%		
	}
%>

<%	
} 
%>
]