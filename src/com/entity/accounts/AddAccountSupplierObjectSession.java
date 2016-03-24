package com.entity.accounts;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.bean.accounts.AddSupplierBean;
import com.bean.accounts.AddSupplierBeanRemote;

public class AddAccountSupplierObjectSession {
	public AddAccountSupplierObjectSession(){}

	public static void setObject(AccountSupplierObject supplierObject) throws NamingException{
	    try{
	    	AddSupplierBeanRemote supplierBeanRemote = connectDB();
	    	supplierBeanRemote.setObject(supplierObject);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static AddSupplierBeanRemote connectDB(){
		AddSupplierBeanRemote supplierBeanRemote = null;
		
		try{
			final Hashtable jndiProperties = new Hashtable();
			Context context = null;
		    jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
	    
	    	context = new InitialContext(jndiProperties);
		
		    final String appName = "";
		    final String moduleName = "perp";
		    final String distinctName = "";
		    final String beanName = AddSupplierBean.class.getSimpleName();
		    final String viewClassName = AddSupplierBeanRemote.class.getName();
	    
		    supplierBeanRemote = (AddSupplierBeanRemote) context.lookup("ejb:" + appName + "/" + moduleName + "/" + distinctName + "/" + beanName + "!" + viewClassName);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return supplierBeanRemote;
	}
}
