<%@page import="common.vo.PagingVO"%>
<%@page import="java.util.List"%>
<%@page import="common.vo.CdChargeVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
[
<%
List<CdChargeVO> list = (List<CdChargeVO>)request.getAttribute("list");
for(int i=0; i<list.size(); i++) {
	if(i > 0) {
		%>,<% 
	}
	CdChargeVO vo = list.get(i);
	
	String chgChargeCd = vo.getChgChargeCd();
	String chgWeekendYn = vo.getChgWeekendYn();
	String cdName1 = vo.getCdName1();
	String cdName2 = vo.getCdName2();
	String cdName3 = vo.getCdName3();
	String cdName4 = vo.getCdName4();
	String chgPrice = vo.getChgPrice();
	
	%>
	{
		"chgChargeCd" : "<%=chgChargeCd %>"
		,"chgWeekendYn" : "<%=chgWeekendYn %>"
		, "cdName1" : "<%=cdName1  %>"
		, "cdName2" : "<%=cdName2 %>"
		, "cdName3" : "<%=cdName3 %>"
		, "cdName4" : "<%=cdName4 %>"
		, "chgPrice" : "<%=chgPrice %>"
	}
	<%
}
%>
<%
PagingVO pagingVO = (PagingVO)request.getAttribute("pagingVO");
	
int totalCount = pagingVO.getTotalCount();
int currentPageNo = pagingVO.getCurrentPageNo();
int countPerPage = pagingVO.getCountPerPage();
int pageSize = pagingVO.getPageSize();
int firstPageNo = pagingVO.getFirstPageNo();
int lastPageNo = pagingVO.getLastPageNo();
int firstRecNo = pagingVO.getFirstRecNo();
int lastRecNo = pagingVO.getLastRecNo();
%>
, {
	"totalCount" : "<%=totalCount %>"
	, "currentPageNo" : "<%=currentPageNo  %>"
	, "countPerPage" : "<%=countPerPage %>"
	, "pageSize" : "<%=pageSize %>"
	, "firstPageNo" : "<%=firstPageNo %>"
	, "lastPageNo" : "<%=lastPageNo %>"
	, "firstRecNo" : "<%=firstRecNo %>"
	, "lastRecNo" : "<%=lastRecNo %>"
}
]