package com.servlet.inventory;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.entity.inventory.AddGrnObjectSession;
import com.entity.inventory.ManageInventoryItemObjectSession;

@WebServlet("/DoManageInventoryItem")
public class DoManageInventoryItem extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public DoManageInventoryItem() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String contextPath = request.getContextPath();
		String form_name = request.getParameter("formName");
		String search_by = request.getParameter("search_by");
		try {
			if(search_by==null){
				if(form_name.equals("add_grn")){
					addGrn(request);
					response.sendRedirect(response.encodeRedirectURL(contextPath + "/inv_add_grn_page.jsp"));
				}else if(form_name.equals("add_stocks")){
					addStocks(request);
					response.sendRedirect(response.encodeRedirectURL(contextPath + "/inv_manage_inventory_item_page.jsp"));
				}
			}else if(form_name!=null && search_by!=null){
				if(search_by.equals("by_pkid")){
					getItemByPkid(request);
				}else if(search_by.equals("by_name")){
					getItemsByName(request);
				}else if(search_by.equals("list_all")){
					getAllItems(request);
				}
				
				response.sendRedirect(response.encodeRedirectURL(contextPath + "/inv_manage_inventory_item_page.jsp"));
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	
	private void getAllItems(HttpServletRequest request){
		try {
			HttpSession session = request.getSession();
			ManageInventoryItemObjectSession objectSession = (ManageInventoryItemObjectSession) session.getAttribute("inv-inventory-item-object");
			
			objectSession.getObjects();
			System.out.println("Now executing getAllItems in DoManageInventoryItem");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	private void getItemByPkid(HttpServletRequest request){
		try {
			HttpSession session = request.getSession();
			ManageInventoryItemObjectSession objectSession = (ManageInventoryItemObjectSession) session.getAttribute("inv-inventory-item-object");
			
			int item_pkid = Integer.parseInt(request.getParameter("item_id"));
			objectSession.getObjectByPkid(item_pkid);
			
			System.out.println("Now executing getItemByPkid in DoManageInventoryItem");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	private void getItemsByName(HttpServletRequest request){
		try {
			HttpSession session = request.getSession();
			ManageInventoryItemObjectSession objectSession = (ManageInventoryItemObjectSession) session.getAttribute("inv-inventory-item-object");
			
			String item_name = request.getParameter("item_name");
			item_name = item_name.replace(" ", "|");
			objectSession.getObjectByName(item_name);
			
			System.out.println("Now executing getItemsByName in DoManageInventoryItem");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	private void addGrn(HttpServletRequest request){
		HttpSession session = request.getSession();
		AddGrnObjectSession objectSession = (AddGrnObjectSession) session.getAttribute("inv-add-grn-object");
		
		if(objectSession==null){
			objectSession = new AddGrnObjectSession();
			session.setAttribute("inv-add-grn-object", objectSession);
		}
		
		String item_name = request.getParameter("item_name");
		String item_code = request.getParameter("item_code");
		int item_pkid = Integer.parseInt(request.getParameter("item_pkid"));
		String item_serializable = request.getParameter("serializable");
		
		objectSession.setItemName(item_name);
		objectSession.setItemId(item_pkid);
		objectSession.setItemCode(item_code);
		objectSession.setItemSerializable(item_serializable);
		
		System.out.println("Now executing addGrn in DoManageInventoryItem");
	}
	
	private void addStocks(HttpServletRequest request) throws ParseException{
		try {
			HttpSession session = request.getSession();
			AddGrnObjectSession objectSession = (AddGrnObjectSession) session.getAttribute("inv-add-grn-object");
			
			double buy_price = Double.parseDouble(request.getParameter("buy_price"));
			double sell_price = Double.parseDouble(request.getParameter("sell_price"));
			int item_qty = Integer.parseInt(request.getParameter("item_qty"));
			int supplier_id = Integer.parseInt(request.getParameter("supplier_id"));
			String serial_number = request.getParameter("serial_number");
			
			String expiry_date_string = request.getParameter("expiry_date");
			Date date = (Date) new SimpleDateFormat("yyyy-MM-dd").parse(expiry_date_string);
			Timestamp expiry_date = new Timestamp(date.getTime());
			
			objectSession.setBuyPrice(buy_price);
			objectSession.setSellPrice(buy_price);
			objectSession.setItemQty(item_qty);
			objectSession.setSupplierId(supplier_id);
			objectSession.setSerialNumber(serial_number);
			objectSession.setExpiryDate(expiry_date);
			
			objectSession.setObject();
			
			System.out.println("Now executing addStocks in DoManageInventoryItem");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
}
