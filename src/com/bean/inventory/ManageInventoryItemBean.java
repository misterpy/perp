package com.bean.inventory;

import java.util.ArrayList;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.entity.inventory.InventoryItemObject;

@Stateless
public class ManageInventoryItemBean implements ManageInventoryItemBeanRemote{
	
	public ManageInventoryItemBean(){}
	
	@PersistenceContext(name="perpPU")
	private EntityManager entityManager;
	
	@Override
	public ArrayList<InventoryItemObject> getObjects() {
		return (ArrayList<InventoryItemObject>) entityManager.createQuery("from InventoryItemObject").getResultList();
	}

	@Override
	public InventoryItemObject getObjectByPkid(Object pkid) {
		return (InventoryItemObject) entityManager.createQuery("from InventoryItemObject where pkid = " + pkid).getSingleResult();
	}

	@Override
	public ArrayList<InventoryItemObject> getObjectByName(Object name) {
		return (ArrayList) entityManager.createNativeQuery("select * from inv_item where name similar to '%(" + name + ")%'", InventoryItemObject.class).getResultList();
	}

}
