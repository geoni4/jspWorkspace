<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
  Date now = new Date();
  SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd(E)");
%>
<%=sdf.format(now) %>
