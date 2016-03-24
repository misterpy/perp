package com.servlet.inventory;

import java.io.IOException;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.entity.inventory.*;

@WebServlet("/DoAddInventoryItem")
public class DoAddInventoryItem extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public DoAddInventoryItem() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String contextPath = request.getContextPath();
		String form_name = request.getParameter("formName");
		
		if(form_name!=null){
			if(form_name.equals("add_item")){
				addItem(request);
			}
		}
		
		response.sendRedirect(response.encodeRedirectURL(contextPath + "/inv_add_inventory_item_page.jsp"));
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	
	private void addItem(HttpServletRequest request){
		String item_name = request.getParameter("item_name");
		String item_code = request.getParameter("item_code");
		String item_type = request.getParameter("item_type");
		String serializable = request.getParameter("serializable");
		
		InventoryItemObject itemObject = new InventoryItemObject();
		itemObject.setName(item_name);
		itemObject.setCode(item_code);
		itemObject.setType(item_type);
		itemObject.setSerializable(serializable);
		
		System.out.println("This is the inserted values ----> item_name: " + item_name + ", item_code: " + item_code + ", item_type: " + item_type + ", serializable: " + serializable);
		
		try {
			AddInventoryItemObjectSession.setObject(itemObject);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
