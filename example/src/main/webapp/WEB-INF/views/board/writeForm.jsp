<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
 <script type="text/javascript" src="/resources/include/js/jquery-1.12.4.min.js"></script>
 <script type="text/javascript" src="/resources/include/js/common.js"></script>
 <script type="text/javascript">
 $(function() {
		$("#boardInsertBtn").click(function() {
			// 입력값 체크
			if (!chkSubmit($('#b_name'), "이름을")) return;
			else if (!chkSubmit($('#b_title'), "제목을")) return;
			else if (!chkSubmit($('#b_content'), "작성할 내용을")) return;
			else if (!chkSubmit($("#b_pwd"), "비밀번호를")) return;
			else {
				if($("#file").val() != "") {
					if(!chkFile($("#file"))) return;
				}
				$("#f_writeForm").attr({
					"method":"post",
					"action":"/board/boardInsert.do"
				})
				$("#f_writeForm").submit();
			}
		})
	})
 </script>
</head>
<body>
	<div class="contentContainer" >
			<div class="contentTB">
				<form id="f_writeForm" enctype="multipart/form-data">		<!-- enctype은 태그가 아닌 attr에서도 사용이 가능. 첨부파일 시 사용. -->
					<table id="boardWrite">
						<colgroup>
							<col width="17%" />
							<col width="83%" />
						</colgroup>
						<tr>
							<td class="ac">작성자</td>
							<td><input type="text" id="b_name" name="b_name" /></td>
						</tr>
						<tr>
							<td class="ac">글제목</td>
							<td><input type="text" id="b_title" name="b_title" /></td>
						</tr>
						<tr>
							<td class="ac vm">내용</td>
							<td><textarea name="b_content" id="b_content"></textarea></td>
						</tr>
						<tr>
							<td>비밀번호</td>
							<td><input type="password" id="b_pwd" name="b_pwd" /></td>
						</tr>
					</table>
					<input type="button" id="boardInsertBtn" value="글쓰기" />
				</form>
			</div>
		</div>
</body>
</html>