/**
 * 
 */
$(function(){
      callEditor( "ta1"); 
      callPeriod($("#from, #to"));
      
    if(document.frm.state.value=="update"){
    	document.getElementById("sub").innerHTML = "����";
    	//document.frm.submit.value="����";
   		document.getElementById('pagetitle').innerHTML = "�ۼ���";
    }
	$(".chkAll").click(function(){
		var area = $(this).parent().parent();
		area.find('input:checkbox').not(this).prop('checked', this.checked);
	});
	$( "#icons li" ).hover(
		function() {
			$( this ).addClass( "ui-state-hover" );
		},
		function() {
			$( this ).removeClass( "ui-state-hover" );
		}
	);
	$("#category_mod").click(function(){
		var nm = $("#category_nm").val();
		var no = $("#category_no option:selected").val();
		if (nm == '') {
			alert("ī�װ����� �Է��� �ּ���!");
			return false;
		}
		var params = "action=add&nm="+ nm +"&no="+ no;
		new ajax.xhr.Request("/iessvn/learn/category.do", params, categoryList, "POST");
	})
	$("#category_del").click(function(){
		var no = $("#category_no option:selected").val();
		if (no == '') {
			alert("�����Ͻ� ī�װ��� ������ �ּ���!");
			return false;
		}
		var params = "action=del&no="+ no;
		new ajax.xhr.Request("/iessvn/learn/category.do", params, categoryList, "POST");
	})
	$("#test_add").css("cursor", "pointer");
	$("#test_add").click(function(){
		var no = $(this).attr("edu");
		var url = "../test/write.do?edu="+ no;
		testWinOpen(url);
	})
	$("img.rollover").hover(function(){
		var src = $(this).attr("src").match(/[^\.]+/) + "_over.png";
		$(this).attr("src", src);
	}, function(){
		var src = $(this).attr("src").replace("_over", "");
		$(this).attr("src", src);
	})
});
function testWinOpen(url){
	window.open(url, 'testWin', 'width=400, height=400');
}
function categoryList(xhr){
	if (xhr.readyState==4 && xhr.status==200) {
		var jsonData = eval('('+ xhr.responseText +')');
		categoryReload(jsonData);
	}
}
function categoryReload(jsonData){
	if (jsonData.msg != ""){
		alert(jsonData.msg);
	} else {
		var json = eval(jsonData.data);
		alert(json.length);
		$("#category_no option[value!='']").remove();
		for (var i=0;i<json.length;i++) {
			var option = $("<option value='"+ json[i].no +"'>"+ json[i].nm.replace(" ", "&nbsp;") +"</option>");
			$("#category_no").append(option);
		}
	}
}
function formchk(){
	oEditors.getById["ta1"].exec("UPDATE_CONTENTS_FIELD", []);
	//document.getElementById("ir1").value
	//return false;
		return true;
}

function submitchk(){
	oEditors.getById["ta1"].exec("UPDATE_CONTENTS_FIELD", []);
		document.frm.submit();
}

function addTest(json){
	var newDiv = creaetDiv(json);
	$("#testList").append(newDiv);
}
function modTest(json){
	var no = parseInt(json.no) - 1;
	var oldDiv = $("#testList li:eq("+ no +")");
	var newDiv = creaetDiv(json);
	oldDiv.replaceWith(newDiv);
}
function creaetDiv(json){
	var html = $("<li>"+ json.no +". "+ json.question +"&nbsp;</li>");
	var em = $("<em></em>");
	var mod = "<a href='../test/write.do?no="+ json.test_no +"' onclick='testWinOpen(this.href); return false;'>����</a>";
	var del = "<a href='../test/delete.do?no="+ json.test_no +"' onclick=\"return confirm('���� �����Ͻðڽ��ϱ�?')\">����</a>";
	em.append(mod);
	em.append(" | ");
	em.append(del);
	html.append(em);
	return html;
}
