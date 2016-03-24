<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    
<%@ page import="com.entity.accounts.*, java.util.*" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Manage inventory item</title>
</head>
<body>

<%
	ManageAccountSupplierObjectSession objectSession = (ManageAccountSupplierObjectSession) session.getAttribute("mgt-manage-supplier-account-object");
	if(objectSession==null){
		objectSession = new ManageAccountSupplierObjectSession();
		session.setAttribute("mgt-manage-supplier-account-object", objectSession);
	}
%>

<h1>PERP: Manage supplier account</h1>
    <a href="/perp">Back to main menu</a>
    <hr>
    <form name="manage_item" method=get action="/perp/DoManageAccountSupplier">
    <input type="hidden" name="formName" value="manage_supplier"/>
    <table>
    	<tr>
    		<td>Search by: List all?<input type="radio" name="search_by" value="list_all"/> | </td>
    		<td>Supplier name?<input type="radio" name="search_by" value="by_name"/> | Supplier id?<input type="radio" name="search_by" value="by_pkid"/></td>
    	</tr>
   		<tr>
	    	<td>Supplier id:  </td>
	    	<td><input type="text" name="supplier_pkid"></td>
	    </tr>
	    <tr>
	    	<td>Supplier name:  </td>
	    	<td><input type="text" name="supplier_name"></td>
	    </tr>
    </table>
    <input type=submit name=submit value="submit">
    </form>
	
<%
	ArrayList objectList = (ArrayList) objectSession.getObjectList();

	if(!objectList.isEmpty()){
%>
<table>
	<tr>
		<th>Id</th>
		<th>Name</th>
		<th>Code</th>
		<th>City</th>
		<th>State</th>
		<th>Options</th>
	</tr>
<%
		Iterator iterator= objectList.iterator();
		while(iterator.hasNext()){
			AccountSupplierObject supplierObject = (AccountSupplierObject) iterator.next();
%>
	<tr>
		<td><%=supplierObject.getId()%></td>
		<td><%=supplierObject.getName()%></td>
		<td><%=supplierObject.getCode()%></td>
		<td><%=supplierObject.getAddressCity()%></td>
		<td><%=supplierObject.getAddressState()%></td>
		<td></td>
	</tr>	
<%
		}
%>
</table>
<%
	}
%>
</body>
</html>