<%--
    ■ SYSTEM                : MVC모델 샘플 프로젝트
    ■ SOURCE FILE NAME      : userInfo.jsp
    ■ DESCRIPTION           : usertable data 가져오기
    ■ COMPANY               : 목포대학교    
    ■ PROGRAM DATE          : 2020.10.09
    ■ EDIT HISTORY          : 2020.10.09    
--%>
<%--
	페이지 접근 방법: localhost:8080/MVC_Sample/userInfo/userInfo.jsp
 --%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="userTable.*" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>userInfo</title>
</head>
<body>
<%
	request.setCharacterEncoding("UTF-8");

	usertableDAO daoUser = new usertableDAO();
	
	ArrayList<usertableDTO> userDataList = daoUser.getUserData();
	
	for(int i=0;i<userDataList.size();i++) {
%>		사용자 이름: <%=userDataList.get(i).getUserName() %> <br>						<%
	}
%>
</body>
</html>