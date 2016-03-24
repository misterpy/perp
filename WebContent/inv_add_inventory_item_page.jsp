    <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
    <html>
    <head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Add inventory item</title>
    </head>
    <body>
    
    <h1>PERP: Add inventory item</h1>
    <a href="/perp">Back to main menu</a>
    <hr>
    <form name="add_item" method=get action="/perp/DoAddInventoryItem">
    <input type="hidden" name="formName" value="add_item"/>
    <table>
	    <tr>
	    	<td>Item name:  </td>
	    	<td><input type="text" name="item_name"></td>
	    </tr>
	    <tr>
	    	<td>Item code:  </td>
	    	<td><input type="text" name="item_code"></td>
	    </tr>
	    <tr>
	    	<td>Item type: </td>
	    	<td>
	    		<select name="item_type">
				<option value="Inventory" selected="selected">Inventory</option>
				</select>
	    	</td>
	    </tr>
	    <tr>
	    	<td>Serializable item? </td>
	    	<td><input type="checkbox" name="serializable" value="true"></td>
	    </tr>
    </table>
    <input type=submit name=submit value="submit">
    </form>
    
    </body>
    </html>