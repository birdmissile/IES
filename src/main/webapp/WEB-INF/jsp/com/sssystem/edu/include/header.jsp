<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<header>
	<div id="con">
		<div id="top">
			<div id="logo">
				<a href="/iessvn/index.do"><img src="/iessvn/images/Logo.png" alt="�系�����ý���" title="�系�����ý���" /></a>
			</div>

		</div>
		<div id="userInfo">
			<span id="userIntro"><em>${user.user_nm }</em> ����� ȯ���մϴ� :)</span> <span
				id="userManu"> <a href="#">ȸ����������</a> &nbsp;| &nbsp;<a
				href="/iessvn/member/login.do" onclick="return confirm('�α׾ƿ� �Ͻðڽ��ϱ�?');">�α׾ƿ�</a> &nbsp;| &nbsp;<a href="/iessvn/admin/member/list.do">������</a>
			</span>
		</div>
		<nav>
			<ul id="topMenu">
				<li><a href="/iessvn/learn/list.do?page=1">����</a></li>
				<li><a href="/iessvn/board/list.do?board_gb=20">��������</a></li>
				<li><a href="/iessvn/qna/list.do?board_gb=60">���ǻ���</a></li>
				<li><a href="/iessvn/board/list.do?board_gb=10">Ŀ�´�Ƽ</a></li>
			</ul>
		</nav>
	</div>
</header>
<script>
$("#topMenu li").css("cursor", "pointer");
$("#topMenu li").hover(function(){
	$("#topMenu li").removeClass("current");
	$(this).addClass("current");
}, function(){
	this.removeClass("current");
})
</script>