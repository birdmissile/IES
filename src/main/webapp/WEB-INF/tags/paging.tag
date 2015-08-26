<%@tag import="com.sssystem.edu.common.Paging"%>
<%@ tag language="java" pageEncoding="EUC-KR"%>
<%@ attribute name="page" %>
<%@ attribute name="totalCnt" %>
<%@ attribute name="par" %>
<%
String str_page = (String)getJspContext().findAttribute("page");
String str_total = (String)getJspContext().findAttribute("totalCnt");
if (str_page == null || str_page.equals("")) str_page = "0";
if (str_total == null || str_total.equals("")) str_total = "0";

int page = Integer.parseInt(str_page);
int totalCnt = Integer.parseInt(str_total);

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