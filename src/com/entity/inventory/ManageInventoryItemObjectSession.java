package com.entity.inventory;

import java.util.ArrayList;
import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.bean.inventory.ManageInventoryItemBean;
import com.bean.inventory.ManageInventoryItemBeanRemote;

public class ManageInventoryItemObjectSession {
	
	private ArrayList inventoryObjectList;
	
	public ManageInventoryItemObjectSession(){
		this.inventoryObjectList = new ArrayList();
	}
	
	public void getObjects() throws NamingException{
		try{
			ArrayList<InventoryItemObject> objectsList = new ArrayList<InventoryItemObject>();
			
			ManageInventoryItemBeanRemote itemBeanRemote = connectDB();

			objectsList = (ArrayList<InventoryItemObject>) itemBeanRemote.getObjects();
			
			setObjectList(objectsList);
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void getObjectByPkid(int pkid) throws NamingException{
		try{
			ManageInventoryItemBeanRemote itemBeanRemote = connectDB();
			
			InventoryItemObject itemObject = new InventoryItemObject();
			
			itemObject = (InventoryItemObject) itemBeanRemote.getObjectByPkid(pkid);
			setObject(itemObject);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void getObjectByName(String name) throws NamingException{
		try{
			ArrayList itemObjectList = new ArrayList();
			ManageInventoryItemBeanRemote itemBeanRemote = connectDB();
			
			itemObjectList = (ArrayList) itemBeanRemote.getObjectByName(name);
			setObjectList(itemObjectList);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static ManageInventoryItemBeanRemote connectDB(){
		ManageInventoryItemBeanRemote itemBeanRemote = null;
		
		try{
			final Hashtable jndiProperties = new Hashtable();
			Context context = null;
		    jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
	    	context = new InitialContext(jndiProperties);
		
		    final String appName = "";
		    final String moduleName = "perp";
		    final String distinctName = "";
		    final String beanName = ManageInventoryItemBean.class.getSimpleName();
		    final String viewClassName = ManageInventoryItemBeanRemote.class.getName();
	    
			itemBeanRemote = (ManageInventoryItemBeanRemote) context.lookup("ejb:" + appName + "/" + moduleName + "/" + distinctName + "/" + beanName + "!" + viewClassName);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return itemBeanRemote;
	}
	
	public void setObjectList(ArrayList buf){
		this.inventoryObjectList.clear();
		this.inventoryObjectList = (ArrayList) buf;
	}
	
	public ArrayList getObjectList(){
		return this.inventoryObjectList;
	}
	
	public void setObject(InventoryItemObject buf){
		this.inventoryObjectList.clear();
		this.inventoryObjectList.add(buf);
	}
}
