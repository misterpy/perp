package com.entity.accounts;

import java.util.ArrayList;
import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import com.bean.accounts.ManageSupplierBean;
import com.bean.accounts.ManageSupplierBeanRemote;

public class ManageAccountSupplierObjectSession {
	private ArrayList supplierObjectList;
	
	public ManageAccountSupplierObjectSession(){
		this.supplierObjectList = new ArrayList();
	}
	
	public void getObjects() throws NamingException{
		try{
			ArrayList<AccountSupplierObject> objectsList = new ArrayList<AccountSupplierObject>();
			
			ManageSupplierBeanRemote supplierBeanRemote = connectDB();

			objectsList = (ArrayList<AccountSupplierObject>) supplierBeanRemote.getObjects();
			
			setObjectList(objectsList);
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void getObjectByPkid(int pkid) throws NamingException{
		try{
			ManageSupplierBeanRemote supplierBeanRemote = connectDB();
			
			AccountSupplierObject supplierObject = new AccountSupplierObject();
			
			supplierObject = (AccountSupplierObject) supplierBeanRemote.getObjectByPkid(pkid);
			setObject(supplierObject);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void getObjectByName(String name) throws NamingException{
		try{
			ArrayList supplierObjectList = new ArrayList();
			ManageSupplierBeanRemote supplierBeanRemote = connectDB();
			
			supplierObjectList = (ArrayList) supplierBeanRemote.getObjectByName(name);
			setObjectList(supplierObjectList);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static ManageSupplierBeanRemote connectDB(){
		ManageSupplierBeanRemote supplierBeanRemote = null;
		
		try{
			final Hashtable jndiProperties = new Hashtable();
			Context context = null;
		    jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
	    	context = new InitialContext(jndiProperties);
		
		    final String appName = "";
		    final String moduleName = "perp";
		    final String distinctName = "";
		    final String beanName = ManageSupplierBean.class.getSimpleName();
		    final String viewClassName = ManageSupplierBeanRemote.class.getName();
	    
		    supplierBeanRemote = (ManageSupplierBeanRemote) context.lookup("ejb:" + appName + "/" + moduleName + "/" + distinctName + "/" + beanName + "!" + viewClassName);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return supplierBeanRemote;
	}
	
	public void setObjectList(ArrayList buf){
		this.supplierObjectList.clear();
		this.supplierObjectList = (ArrayList) buf;
	}
	
	public ArrayList getObjectList(){
		return this.supplierObjectList;
	}
	
	public void setObject(AccountSupplierObject buf){
		this.supplierObjectList.clear();
		this.supplierObjectList.add(buf);
	}
}
