<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<% int price = (Integer)request.getAttribute("price"); %>
{
	"price" : "<%=price %>"
}