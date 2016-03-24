package com.entity.inventory;

import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.bean.inventory.AddInventoryItemBean;
import com.bean.inventory.AddInventoryItemBeanRemote;

public class AddInventoryItemObjectSession {

	public AddInventoryItemObjectSession(){}
	
	public static void setObject(InventoryItemObject itemObject) throws NamingException{
	    try{
	    	AddInventoryItemBeanRemote itemBeanRemote = connectDB();
			itemBeanRemote.setObject(itemObject);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static AddInventoryItemBeanRemote connectDB(){
		AddInventoryItemBeanRemote itemBeanRemote = null;
		
		try{
			final Hashtable jndiProperties = new Hashtable();
			Context context = null;
		    jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
	    
	    	context = new InitialContext(jndiProperties);
		
		    final String appName = "";
		    final String moduleName = "perp";
		    final String distinctName = "";
		    final String beanName = AddInventoryItemBean.class.getSimpleName();
		    final String viewClassName = AddInventoryItemBeanRemote.class.getName();
	    
			itemBeanRemote = (AddInventoryItemBeanRemote) context.lookup("ejb:" + appName + "/" + moduleName + "/" + distinctName + "/" + beanName + "!" + viewClassName);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return itemBeanRemote;
	}
}