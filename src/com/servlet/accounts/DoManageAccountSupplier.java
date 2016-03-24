package com.servlet.accounts;

import java.io.IOException;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.entity.accounts.ManageAccountSupplierObjectSession;

@WebServlet("/DoManageAccountSupplier")
public class DoManageAccountSupplier extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public DoManageAccountSupplier() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String contextPath = request.getContextPath();
		String form_name = request.getParameter("formName");
		String search_by = request.getParameter("search_by");
		
		if(form_name!=null && search_by!=null){
			if(search_by.equals("by_pkid")){
				getSupplierByPkid(request);
			}else if(search_by.equals("by_name")){
				getSupplierByName(request);
			}else if(search_by.equals("list_all")){
				getAllSuppliers(request);
			}
		}
		
		response.sendRedirect(response.encodeRedirectURL(contextPath + "/acc_manage_supplier_page.jsp"));
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	
	private void getAllSuppliers(HttpServletRequest request){
		try {
			HttpSession session = request.getSession();
			ManageAccountSupplierObjectSession objectSession = (ManageAccountSupplierObjectSession) session.getAttribute("mgt-manage-supplier-account-object");
			
			objectSession.getObjects();
			System.out.println("Now executing getAllSuppliers in DoManageAccountSupplier");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	private void getSupplierByPkid(HttpServletRequest request){
		try {
			HttpSession session = request.getSession();
			ManageAccountSupplierObjectSession objectSession = (ManageAccountSupplierObjectSession) session.getAttribute("mgt-manage-supplier-account-object");
			
			int supplier_pkid = Integer.parseInt(request.getParameter("supplier_pkid"));
			objectSession.getObjectByPkid(supplier_pkid);
			
			System.out.println("Now executing getSupplierByPkid in DoManageAccountSupplier");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	private void getSupplierByName(HttpServletRequest request){
		try {
			HttpSession session = request.getSession();
			ManageAccountSupplierObjectSession objectSession = (ManageAccountSupplierObjectSession) session.getAttribute("mgt-manage-supplier-account-object");
			
			String supplier_name = request.getParameter("supplier_name");
			supplier_name  = supplier_name.replace(" ", "%");
			objectSession.getObjectByName(supplier_name );
			
			System.out.println("Now executing getSupplierByName in DoManageAccountSupplier");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

}
