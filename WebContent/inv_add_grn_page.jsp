    <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ page import="com.entity.inventory.*, java.util.*" %>
    
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
    <html>
    <head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Add inventory item</title>
    
    <!-- Load jQuery JS -->
    <script src="Resources/jquery/jquery-1.11.1.min.js"></script>
    <!-- Load jQuery UI Main JS  -->
    <script src="Resources/jquery/jquery-ui.min.js"></script>
    
    <!-- Load SCRIPT.JS which will create datepicker for input field  -->
    <script src="Resources/etc/datepicker-scripts.js"></script>
    
    <link rel="stylesheet" href="Resources/jquery/jquery-ui.theme.min.css" />
    
    </head>
    <body>
    
	<%
		AddGrnObjectSession objectSession = (AddGrnObjectSession) session.getAttribute("inv-add-grn-object");
		
		if(objectSession==null){
			objectSession = new AddGrnObjectSession();
			session.setAttribute("inv-add-grn-object", objectSession);
		}
	%>
    <h1>PERP: Add stocks</h1>
    <a href="/perp">Back to main menu</a>
    <hr>
    <table>
    	<tr>
	    	<td>Item id:  </td>
	    	<td><%=objectSession.getItemId()%></td>
	    </tr>
	    <tr>
	    	<td>Item name:  </td>
	    	<td><%=objectSession.getItemName()%></td>
	    </tr>
	    <tr>
	    	<td>Item code:  </td>
	    	<td><%=objectSession.getItemCode()%></td>
	    </tr>
	    <tr>
	    	<td>Serializable item: </td>
	    	<td><%=objectSession.getItemSerializable()%></td>
	    </tr>
    </table>
    
    <form name=add_stocks method=get action="/perp/DoManageInventoryItem">
    <input type="hidden" name="formName" value="add_stocks"/>
    <table>
    	<tr>
    		<td>Buy price: </td>
    		<td><input type="number" name="buy_price" value="0.00"></td>
    	</tr>
    	<tr>
    		<td>Sell price: </td>
    		<td><input type="number" name="sell_price" value="0.00"></td>
    	</tr>
    	<tr>
    		<td>Quantity: </td>
    		<td><input type="number" name="item_qty" value="0"></td>
    	</tr>
    	<tr>
    		<td>Supplier id: </td>
    		<td><input type="number" name="supplier_id" value="0"></td>
    	</tr>
    	<tr>
    		<td>Serial number: </td>
    		<td>
    			<textarea rows="4" cols="50" name="serial_number"></textarea>
			</td>
    	</tr>
    	<tr>
    		<td>Expiry date: </td>
    		<td><input type="text" name="expiry_date" id="datepicker"></td>
    	</tr>
    </table>
    <input type=submit name=submit value="submit">
    </form>
    
    </body>
    </html>