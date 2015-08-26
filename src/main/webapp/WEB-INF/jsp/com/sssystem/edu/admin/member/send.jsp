
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Ajax ������ ���� �׽�Ʈ 2</title>
<script type="text/javascript">
    
    var xmlReq; // ���������� ����.
    // Ajax ��ü ���� ����
    function createAjax() {
        xmlReq = new XMLHttpRequest();
    }
     
    // Ajax ��ü�� �̿��� ������ ���� ����
    function ajaxSend() {
       createAjax();
       var user_nm = document.getElementById("user_nm").value;
       var birth = document.getElementById("birth").value;
	       xmlReq.onreadystatechange = callBack; // ��ȣ ����ݰ� Ʋ����.!
	       xmlReq.open("GET", "receive.jsp?user_nm="+user_nm+"&birth="+birth, true);
	       xmlReq.send(null);
       // send�� �������� �񵿱���̱� ������ ���α׷��� ��� ����ȴ�.
   }
    
   // �ݹ� �Լ� ����
   function callBack() {
       if(xmlReq.readyState == 4) {
           if(xmlReq.status == 200) {
               printData();
           }
       }
   }
    
   // ��� ��� ����
   function printData() {
       var result = xmlReq.responseXML;
       
       var rootNode = result.documentElement;
       // <root>true</root> , <root>false</root>
       var rootValue = rootNode.firstChild.nodeValue;
       var rootTag = document.getElementById("error");
       
       var nameNode = rootNode.getElementsByTagName("name");
       var nameValue = nameNode.item(0).firstChild.nodeValue;
       
       if (nameValue != 'unknown'){
	       if(rootValue == "true") {
	           rootTag.innerHTML = "��� ������ ���̵�";
	       } else {
	           rootTag.innerHTML = "�ߺ��� ���̵�";
	       }
       } else {
    	   rootTag.innerHTML = "";
       }
   }
</script>
</head>
<body>
<div>ID �ߺ� Ȯ��</div>
<div>
���̵�: <input type="text" id="user_nm" onkeyup="ajaxSend()"> <br>
����: <input type="text" id="birth" onkeyup="ajaxSend()"> <br>
<span id="error" style="color: blue;"></span>
<a href="http://localhost/iessvn/admin/member/receive.jsp?user_nm=�ں�ö&birth=0000-00-00">�̵�</a>
</div>
</body>
</html>