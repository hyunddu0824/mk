<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	  <div class="contentContainer">
           <div class="contentTit"><h3>�ۻ�</h3></div>
            <form name="f_data" id="f_data" method="post">
            	<input type="hidden" id="b_num" name="b_num" value="${detail.b_num}">
            	<input type="hidden" name="b_file" id="b_file" value="${detail.b_file}">
            </form>
           
          	<!-- =========��й�ȣ Ȯ�� ��ư �� ��ư �߰� ����========= -->
            <table id="boardPwdBut">
               <tr>
               	 <td id="btd1">
               	  	<div id="pwdChk">
               	  		<form name="f_pwd" id="f_pwd">
               	  			<input type="hidden" name="b_num" value="${detail.b_num}" />
               	  			<label for="b_pwd" id="l_pwd">��й�ȣ:</label>
               	  			<input type="password" name="b_pwd" id="b_pwd" />
               	  			<input type="button" id="pwdBtn" value="Ȯ��" />
               	  			<span id="msg"></span>			
               	  		</form>
               	  	</div>	
               	  </td>
                  <td id="btd2">
                     <input type="button" value="����" id="updateFormBtn">
                     <input type="button" value="����" id="boardDeleteBtn">
                     <input type="button" value="���" id="boardListBtn">
                  </td>
               </tr>
            </table>
            <!-- =========��й�ȣ Ȯ�� ��ư �� ��ư �߰� ����========= -->
                     
            <!-- =========�� ���� �����ֱ� ����========= -->
            <div class="contentTB">
               <table>
                  <colgroup>
                     <col width="25%" />
                     <col width="25%" />
                     <col width="25%" />
                     <col width="25%" />
                  </colgroup>
                  <tbody>
                     <tr>
                        <td class="ac">�ۼ���</td>
                        <td>${detail.b_name}</td>
                        <td class="ac">�ۼ���</td>
                        <td>${detail.b_date}</td>
                     </tr>
                     <tr>
                        <td class="ac">����</td>
                        <td colspan="3">${detail.b_title }</td>
                     </tr>
                     <tr class="ctr">
                        <td class="ac">����</td>
                        <td colspan="3">${detail.b_content}</td>
                     </tr>
                     <c:if test="${detail.b_file !=''}">
                     <tr>
                     	  <td class="ac">÷������ �̹���</td>
                     	  <td colspan="3"><img id="fileImage"></td>
                     </tr>
                     </c:if>
                  </tbody>
               </table>
            </div>
         </div>
</body>
</html>