package com.bean.inventory;

import java.util.ArrayList;
import javax.ejb.Remote;
import com.entity.inventory.InventoryItemObject;

@Remote
public interface ManageInventoryItemBeanRemote {
	
	public ArrayList<InventoryItemObject> getObjects();
	
    public InventoryItemObject getObjectByPkid(Object pkid);
    
    public ArrayList<InventoryItemObject> getObjectByName(Object name);

}
