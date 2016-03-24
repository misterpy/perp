package com.bean.accounts;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.entity.accounts.AccountSupplierObject;

@Stateless
public class AddSupplierBean implements AddSupplierBeanRemote{
	
	public AddSupplierBean(){}
	
	@PersistenceContext(name="perpPU")
	private EntityManager entityManager;
	
	public void setObject(AccountSupplierObject supplierObject){
		entityManager.merge(supplierObject);
	}
	
	public void removeObject(AccountSupplierObject supplierObject){
		entityManager.remove(entityManager.merge(supplierObject));
	}
	
	public AccountSupplierObject getObject(Object pkid){
		return entityManager.find(com.entity.accounts.AccountSupplierObject.class, pkid);
	}
}
