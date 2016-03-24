package com.servlet.accounts;

import java.io.IOException;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.entity.accounts.AccountSupplierObject;
import com.entity.accounts.AddAccountSupplierObjectSession;

@WebServlet("/DoAddAccountSupplier")
public class DoAddAccountSupplier extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
    public DoAddAccountSupplier() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String contextPath = request.getContextPath();
		String form_name = request.getParameter("formName");
		
		if(form_name!=null){
			if(form_name.equals("add_supplier")){
				addSupplierAccount(request);
			}
		}

		response.sendRedirect(response.encodeRedirectURL(contextPath + "/acc_add_supplier_page.jsp"));
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	
	private void addSupplierAccount(HttpServletRequest request){
		String supplier_name = request.getParameter("supplier_name");
		String supplier_code = request.getParameter("supplier_code");
		String address_number = request.getParameter("address_number");
		String address_1 = request.getParameter("address_1");
		String address_2 = request.getParameter("address_2");
		String address_poscode = request.getParameter("address_poscode");
		String address_city = request.getParameter("address_city");
		String address_state = request.getParameter("address_state");
		String address_country = request.getParameter("address_country");
		String contact_number1 = request.getParameter("contact_number1");
		String contact_number2 = request.getParameter("contact_number2");
		String contact_number3 = request.getParameter("contact_number3");
		
		AccountSupplierObject supplierObject = new AccountSupplierObject();
		supplierObject.setName(supplier_name);
		supplierObject.setCode(supplier_code);
		supplierObject.setAddressNumber(address_number);
		supplierObject.setAddressStreet1(address_1);
		supplierObject.setAddressStreet2(address_2);
		supplierObject.setAddressPoscode(address_poscode);
		supplierObject.setAddressCity(address_city);
		supplierObject.setAddressState(address_state);
		supplierObject.setAddressCountry(address_country);
		supplierObject.setContactNumber1(contact_number1);
		supplierObject.setContactNumber2(contact_number2);
		supplierObject.setContactNumber3(contact_number3);
		
		System.out.println("Now executing addSupplierAccount in servlet DoAddAccountSupplier ...");
		
		try {
			AddAccountSupplierObjectSession.setObject(supplierObject);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
