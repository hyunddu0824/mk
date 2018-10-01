<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core"%>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>


<script type="text/javascript" src="/resources/include/js/jquery-1.12.4.min.js"></script>
<script type="text/javascript">
	$(function() {
		
	})
</script>
</head>
<body>

	<form name="detailForm" id="detailform">
		<input type="hidden" id="b_no" name="b_no">
	</form>
		<table border="1" class="table table-condensed">
			<thead>
				<tr>
					<td>번호</td>
					<td>제목</td>
					<td>작성자</td>
					<td>등록일 </td>
				</tr>
			</thead>
			
			<tbody id ="list">
				<c:choose>
					<c:when test="${not empty boardList }">
						<c:forEach var="board" items="${boardList }">
							<tr class="tac" data-num="${board.b_no }">
								<td>${board.b_no }</td>
								<td class="goDetail tal">${board.b_title }</td>
								<td class="name">${board.b_name }</td>
								<td>${baord.b_date }</td>
							</tr>
						</c:forEach>
					</c:when>
					<c:otherwise>
							<tr>
								<td colspan="4" class="tac">등록된 게시물이 존재하지 않습니다.</td>
							</tr>
					</c:otherwise>
				</c:choose>
			</tbody>
		</table>	

		<div class="contentBtn">
			<input type="button" value="글쓰기" id="insertFormBtn" />
		</div>
</body>
</html>