<%@tag import="com.sssystem.edu.common.Paging"%>
<%@ tag language="java" pageEncoding="EUC-KR"%>
<%@ attribute name="page" %>
<%@ attribute name="totalCnt" %>
<%@ attribute name="par" %>
<%
int page = Integer.parseInt((String)getJspContext().findAttribute("page"));
int totalCnt = Integer.parseInt((String)getJspContext().findAttribute("totalCnt"));

Paging paging = new Paging();
paging.setPageNo(page);
paging.setPageSize(10);
paging.setTotalCount(totalCnt);
%>
<%--< 1 2 3 4 5 6 7 8 9 10 > --%>
<div class="paging">
		<a href="#" title="ù ������" class="first arrow" onclick="jsGoPage(1, '${par }');return false;"><span style="cursor:pointer;">�� ó�� �������� �̵�</span></a>
		<a href="#" title="���� ������" class="prev arrow" onclick="jsGoPage(<%=paging.getPrevPageNo() %>,'${par }');return false;"><span style="cursor:pointer;">������������ �̵�</span></a>
	
	<%for (int i=paging.getStartPageNo(); i<=paging.getEndPageNo(); i++) {%>
		<a href="#" title="<%=i %> ������"<%if (paging.getPageNo() == i) { %> class="current"<%} %> onclick="jsGoPage(<%=i %>,'${par }');return false;"><span style="cursor:pointer;"><%=i %></span></a>
	<%} %>
	
		<a href="#" title="���� ������" class="next arrow" onclick="jsGoPage(<%=paging.getNextPageNo() %>,'${par }');return false;"><span style="cursor:pointer;">���� �������� �̵�</span></a>
		<a href="#" title="������ ������" class="end arrow" onclick="jsGoPage(<%=paging.getEndPageNo() %>,'${par }');return false;"><span style="cursor:pointer;">�� ������ �������� �̵�</span></a>
</div>