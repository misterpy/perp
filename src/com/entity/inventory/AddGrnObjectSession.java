package com.entity.inventory;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Hashtable;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.bean.inventory.AddInventoryItemBeanRemote;
import com.bean.inventory.AddInventoryItemStockBean;
import com.bean.inventory.AddInventoryItemStockBeanRemote;
import com.bean.inventory.ManageInventoryItemBean;
import com.bean.inventory.ManageInventoryItemBeanRemote;

public class AddGrnObjectSession {
	private int itemId;
	private String itemCode;
	private String itemName;
	private String itemSerializable;
	private int itemQty;
	private double buyPrice;
	private double sellPrice;
	private Timestamp expiryDate;
	private int supplierId;
	private int stocksId;
	private String serialNumber;
	
	private InventoryItemStockObject queryObject;
	
	public AddGrnObjectSession(){
		this.itemId = 0;
		this.itemCode = "";
		this.itemName = "";
		this.itemSerializable = "";
		this.itemQty = 0;
		this.buyPrice = 0;
		this.sellPrice = 0;
		this.supplierId = 0;
		this.stocksId = 0;
		this.serialNumber = "";
		this.queryObject = new InventoryItemStockObject();
	}
	
	public void reset(){
		this.itemId = 0;
		this.itemCode = "";
		this.itemName = "";
		this.itemSerializable = "";
		this.itemQty = 0;
		this.buyPrice = 0;
		this.sellPrice = 0;
		this.supplierId = 0;
		this.stocksId = 0;
		this.serialNumber = "";
		
		this.queryObject = new InventoryItemStockObject();
	}
	
	public void setItemId(int buf){
		this.itemId = buf;
	}
	
	public int getItemId(){
		return this.itemId;
	}
	
	public void setItemName(String buf){
		this.itemName = buf;
	}
	
	public String getItemName(){
		return this.itemName;
	}
	
	public void setItemCode(String buf){
		this.itemCode = buf;
	}
	
	public String getItemCode(){
		return this.itemCode;
	}
	
	public void setItemSerializable(String buf){
		this.itemSerializable = buf;
	}
	
	public String getItemSerializable(){
		return this.itemSerializable;
	}
	
	public void setItemQty(int buf){
		this.itemQty = buf;
	}
	
	public int getItemQty(){
		return this.itemQty;
	}
	
	public void setBuyPrice(double buf){
		this.buyPrice = buf;
	}
	
	public double getBuyPrice(){
		return this.buyPrice;
	}
	
	public void setSellPrice(double buf){
		this.sellPrice = buf;
	}
	
	public double getSellPrice(){
		return this.sellPrice;
	}
	
	public void setExpiryDate(Timestamp buf){
		this.expiryDate = buf;
	}
	
	public Timestamp getExpiryDate(){
		return this.expiryDate;
	}
	
	public void setSupplierId(int buf){
		this.supplierId = buf;
	}
	
	public int getSupplierId(){
		return this.supplierId;
	}
	
	public void setStocksId(int buf){
		this.stocksId = buf;
	}
	
	public int getStocksId(){
		return this.stocksId;
	}
	
	public void setSerialNumber(String buf){
		this.serialNumber = buf;
	}
	
	public String getSerialNumber(){
		return this.serialNumber;
	}
	
	public static AddInventoryItemStockBeanRemote connectDB(){
		AddInventoryItemStockBeanRemote itemStockBeanRemote = null;
		
		try{
			final Hashtable jndiProperties = new Hashtable();
			Context context = null;
		    jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
	    	context = new InitialContext(jndiProperties);
		
		    final String appName = "";
		    final String moduleName = "perp";
		    final String distinctName = "";
		    final String beanName = AddInventoryItemStockBean.class.getSimpleName();
		    final String viewClassName = AddInventoryItemStockBeanRemote.class.getName();
	    
		    itemStockBeanRemote = (AddInventoryItemStockBeanRemote) context.lookup("ejb:" + appName + "/" + moduleName + "/" + distinctName + "/" + beanName + "!" + viewClassName);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		return itemStockBeanRemote;
	}
	
	public void getObjectBySerialNumber(String serialNumber) throws NamingException{
		try{
			AddInventoryItemStockBeanRemote itemStockBeanRemote = connectDB();
			
			InventoryItemStockObject queryObject = (InventoryItemStockObject) itemStockBeanRemote.getObjectBySerialNumber(serialNumber);
			setQueryObject(queryObject);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void setObject() throws NamingException{
	    try{
	    	AddInventoryItemStockBeanRemote itemStockBeanRemote = connectDB();
	    	
	    	InventoryItemStockObject itemStockObject = new InventoryItemStockObject();
			itemStockObject.setBuyPrice(this.buyPrice);
			itemStockObject.setExpiryDate(this.expiryDate);
			itemStockObject.setItemId(this.itemId);
			itemStockObject.setQty(this.itemQty);
			itemStockObject.setSellPrice(this.sellPrice);
			itemStockObject.setSupplierId(this.supplierId);
			itemStockObject.setSerialNumber(this.serialNumber);
			
	    	itemStockBeanRemote.setObject(itemStockObject);
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void setQueryObject(InventoryItemStockObject buf){
		this.queryObject = buf;
	}
	
	public InventoryItemStockObject getQueryObject(){
		return this.queryObject;
	}
	
}
