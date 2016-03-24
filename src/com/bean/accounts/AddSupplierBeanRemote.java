package com.bean.accounts;

import javax.ejb.Remote;
import com.entity.accounts.AccountSupplierObject;

@Remote
public interface AddSupplierBeanRemote {
	
	public void setObject(AccountSupplierObject supplierObject);
	
	public void removeObject(AccountSupplierObject supplierObject);
	
    public AccountSupplierObject getObject(Object pkid);
}
