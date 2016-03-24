package com.bean.inventory;

import java.util.ArrayList;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.entity.inventory.InventoryItemObject;

@Stateless
public class AddInventoryItemBean implements AddInventoryItemBeanRemote {
	
	public AddInventoryItemBean(){
	}
	
	@PersistenceContext(name="perpPU")
	private EntityManager entityManager;
	
	public void setObject(InventoryItemObject itemObject) {
		entityManager.merge(itemObject);
	}
	
	public void removeObject(InventoryItemObject itemObject) {
		entityManager.remove(entityManager.merge(itemObject));
    }
	
    public InventoryItemObject getObject(Object pkid) {
        return entityManager.find(com.entity.inventory.InventoryItemObject.class, pkid);
    }
}