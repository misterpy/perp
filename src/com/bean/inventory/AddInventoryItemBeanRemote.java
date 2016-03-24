package com.bean.inventory;

import java.util.ArrayList;

import javax.ejb.Remote;
import com.entity.inventory.InventoryItemObject;

@Remote
public interface AddInventoryItemBeanRemote {

	public void setObject(InventoryItemObject itemObject);
	
	public void removeObject(InventoryItemObject itemObject);
	
    public InventoryItemObject getObject(Object pkid);
}
