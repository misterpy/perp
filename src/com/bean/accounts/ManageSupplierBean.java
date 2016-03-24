package com.bean.accounts;

import java.util.ArrayList;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.entity.accounts.AccountSupplierObject;

@Stateless
public class ManageSupplierBean implements ManageSupplierBeanRemote{
	public ManageSupplierBean(){}
	
	@PersistenceContext(name="perpPU")
	private EntityManager entityManager;
	
	@Override
	public ArrayList<AccountSupplierObject> getObjects() {
		return (ArrayList<AccountSupplierObject>) entityManager.createQuery("from AccountSupplierObject").getResultList();
	}

	@Override
	public AccountSupplierObject getObjectByPkid(Object pkid) {
		return (AccountSupplierObject) entityManager.createQuery("from AccountSupplierObject where pkid = " + pkid).getSingleResult();
	}

	@Override
	public ArrayList<AccountSupplierObject> getObjectByName(Object name) {
		return (ArrayList<AccountSupplierObject>) entityManager.createQuery("from AccountSupplierObject i where i.name like '%" + name + "%'").getResultList();
	}
}
