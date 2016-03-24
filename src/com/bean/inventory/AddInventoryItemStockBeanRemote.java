package com.bean.inventory;

import javax.ejb.Remote;

import com.entity.inventory.InventoryItemStockObject;

@Remote
public interface AddInventoryItemStockBeanRemote {
	public void setObject(InventoryItemStockObject itemObject);
	
	public void removeObject(InventoryItemStockObject itemObject);
	
    public InventoryItemStockObject getObjectBySerialNumber(Object serialNumber);
}
