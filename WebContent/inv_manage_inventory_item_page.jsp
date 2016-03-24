<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    
<%@ page import="com.entity.inventory.*, java.util.*" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Manage inventory item</title>
</head>
<body>

<%
	ManageInventoryItemObjectSession objectSession = (ManageInventoryItemObjectSession) session.getAttribute("inv-inventory-item-object");
	if(objectSession==null){
		objectSession = new ManageInventoryItemObjectSession();
		session.setAttribute("inv-inventory-item-object", objectSession);
	}
%>

<h1>PERP: Manage inventory item</h1>
    <a href="/perp">Back to main menu</a>
    <hr>
    <form name="manage_item" method=get action="/perp/DoManageInventoryItem">
    <input type="hidden" name="formName" value="manage_item"/>
    <table>
    	<tr>
    		<td>Search by: List all?<input type="radio" name="search_by" value="list_all"/> | </td>
    		<td>Item name?<input type="radio" name="search_by" value="by_name"/> | Item id?<input type="radio" name="search_by" value="by_pkid"/></td>
    	</tr>
   		<tr>
	    	<td>Item id:  </td>
	    	<td><input type="text" name="item_id"></td>
	    </tr>
	    <tr>
	    	<td>Item name:  </td>
	    	<td><input type="text" name="item_name"></td>
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
		<th>Serializable</th>
		<th>Options</th>
	</tr>
<%
		Iterator itemIterator= objectList.iterator();
		while(itemIterator.hasNext()){
			InventoryItemObject itemObject = (InventoryItemObject) itemIterator.next();
%>
	<tr>
		<td><%=itemObject.getId()%></td>
		<td><%=itemObject.getName()%></td>
		<td><%=itemObject.getCode()%></td>
		<td><%=itemObject.getSerializable()%></td>
		<td><a href="/perp/DoManageInventoryItem?formName=add_grn&item_pkid=<%=itemObject.getId()%>&item_name=<%=itemObject.getName()%>&item_code=<%=itemObject.getCode()%>&serializable=<%=itemObject.getSerializable()%>">Add stocks</a></td>
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