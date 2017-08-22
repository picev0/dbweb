
<!-- contentType=の中は"が多いとjasperexceptionになるので注意 -->
<%@page contentType="text/html; charset=UTF-8"%>
<%@page import="java.util.List, websample.Master"%>

<HTML>
<HEAD>
<TITLE>SELECT SAMPLE</TITLE>
</HEAD>
<BODY>

<TABLE BORDER = "1">

<TR>
<TH>商品ID
<TH>商品名
<TH>グループ名
<TH>仕入単価
<TH>卸単価
<%
    List list = (List)request.getAttribute("list");
    for(int i=0; i<list.size(); i++){
    	Master master = (Master)list.get(i);
%>
        <TR>
            <TD><%=master.getId()%>
            <TD><%=master.getName()%>
            <TD><%=master.getGroup()%>
            <TD><%=master.getPurchasePrice()%>
            <TD><%=master.getWholesalePrice()%>

<%
    }
%>

</TABLE>
</BODY>
</HTML>