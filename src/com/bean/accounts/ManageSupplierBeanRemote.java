package com.bean.accounts;

import java.util.ArrayList;
import javax.ejb.Remote;
import com.entity.accounts.AccountSupplierObject;

@Remote
public interface ManageSupplierBeanRemote {
	public ArrayList<AccountSupplierObject> getObjects();
	
    public AccountSupplierObject getObjectByPkid(Object pkid);
    
    public ArrayList<AccountSupplierObject> getObjectByName(Object name);
}
