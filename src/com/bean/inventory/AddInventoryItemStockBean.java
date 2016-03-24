package com.bean.inventory;

import java.util.ArrayList;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.entity.inventory.InventoryItemObject;
import com.entity.inventory.InventoryItemStockObject;

@Stateless
public class AddInventoryItemStockBean implements AddInventoryItemStockBeanRemote{
	
	public AddInventoryItemStockBean(){}
	
	
	@PersistenceContext(name="perpPU")
	private EntityManager entityManager;
	
	@Override
	public void setObject(InventoryItemStockObject itemObject) {
		entityManager.merge(itemObject);
	}

	@Override
	public void removeObject(InventoryItemStockObject itemObject) {
		entityManager.remove(entityManager.merge(itemObject));
	}

	@Override
	public InventoryItemStockObject getObjectBySerialNumber(Object serialNumber) {
		return (InventoryItemStockObject) entityManager.createNativeQuery("select * from inv_item_stock where serial_number = '" + serialNumber + "'", InventoryItemStockObject.class).getSingleResult();
	}

}
