package com.entity.inventory;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="inv_item_stock")
public class InventoryItemStockObject implements Serializable{

	private static final long serialVersionUID = -4481344563482160578L;
	
	private int pkid;
	private int qty;
	private double buyPrice;
	private double sellPrice;
	private Timestamp expiryDate;
	private int supplierId;
	private int itemId;
	private String serialNumber;
	
	public InventoryItemStockObject(){}
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="pkid")
	public int getId(){
		return this.pkid;
	}
	
	public void setId(int buf){
		this.pkid = buf;
	}
	
	@Column(name="quantity")
	public int getQty(){
		return this.qty;
	}
	
	public void setQty(int buf){
		this.qty = buf;
	}
	
	@Column(name="buy_price")
	public double getBuyPrice(){
		return this.buyPrice;
	}
	
	public void setBuyPrice(double buf){
		this.buyPrice = buf;
	}
	
	@Column(name="sell_price")
	public double getSellPrice(){
		return this.sellPrice;
	}
	
	public void setSellPrice(double buf){
		this.sellPrice = buf;
	}
	
	@Column(name="expiry_date")
	public Timestamp getExpiryDate(){
		return this.expiryDate;
	}
	
	public void setExpiryDate(Timestamp buf){
		this.expiryDate = buf;
	}
	
	@Column(name="item_id")
	public int getItemId(){
		return this.itemId;
	}
	
	public void setItemId(int buf){
		this.itemId = buf;
	}
	
	@Column(name="supplier_id")
	public int getSupplierId(){
		return this.supplierId;
	}
	
	public void setSupplierId(int buf){
		this.supplierId = buf;
	}
	
	@Column(name="serial_number")
	public String getSerialNumber(){
		return this.serialNumber;
	}
	
	public void setSerialNumber(String buf){
		this.serialNumber = buf;
	}
	
}
