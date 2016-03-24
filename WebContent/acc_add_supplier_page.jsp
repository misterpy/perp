    <%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
    <html>
    <head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Add inventory item</title>
    </head>
    <body>
    
    <h1>PERP: Add supplier</h1>
    <a href="/perp">Back to main menu</a>
    <hr>
    <form name="add_supplier" method=get action="/perp/DoAddAccountSupplier">
    <input type="hidden" name="formName" value="add_supplier"/>
    <table>
	    <tr>
	    	<td>Supplier name:  </td>
	    	<td><input type="text" name="supplier_name"></td>
	    </tr>
	    <tr>
	    	<td>Supplier code:  </td>
	    	<td><input type="text" name="supplier_code"></td>
	    </tr>
	    <tr>
	    	<td>Address: </td>
	    	<td>
	    		<table>
	    		<tr>
	    			<td>Number: </td>
	    			<td><input type="text" name="address_number"><br></td>
	    		</tr>
	    		<tr>
	    			<td>Street: </td>
	    			<td><input type="text" name="address_1"><br><input type="text" name="address_2"></td>
	    		</tr>
	    		<tr>
	    			<td>Poscode: </td>
	    			<td><input type="text" name="address_poscode"></td>
	    			<td>City: </td>
	    			<td><input type="text" name="address_city"></td>
	    		</tr>
	    		<tr>
	    			<td>State: </td>
	    			<td><input type="text" name="address_state"></td>
	    			<td>Country: </td>
	    			<td><input type="text" name="address_country"></td>
	    		</tr>
	    		</table>
	    	</td>
	    </tr>
	    <tr>
	    	<td>Contact number 1: </td>
	    	<td><input type="text" name="contact_number1"></td>
	    </tr>
	    <tr>
	    	<td>Contact number 2: </td>
	    	<td><input type="text" name="contact_number2"></td>
	    </tr>
	    <tr>
	    	<td>Contact number 3: </td>
	    	<td><input type="text" name="contact_number3"></td>
	    </tr>
    </table>
    <input type=submit name=submit value="submit">
    </form>
    
    </body>
    </html>