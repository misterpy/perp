package com.entity.accounts;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="acc_supplier")
public class AccountSupplierObject implements Serializable{

	private static final long serialVersionUID = 1907817475624653587L;
	
	private int pkid;
	private String name;
	private String code;
	private String addressNumber;
	private String addressStreet1;
	private String addressStreet2;
	private String addressPoscode;
	private String addressState;
	private String addressCity;
	private String addressCountry;
	private String contactNumber1;
	private String contactNumber2;
	private String contactNumber3;
	
	public AccountSupplierObject(){
		this.name = "";
		this.code = "";
		this.addressNumber = "";
		this.addressStreet1 = "";
		this.addressStreet2 = "";
		this.addressPoscode = "";
		this.addressState = "";
		this.addressCity = "";
		this.addressCountry = "";
		this.contactNumber1 = "";
		this.contactNumber2 = "";
		this.contactNumber3 = "";
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="pkid")
	public int getId(){
		return this.pkid;
	}
	
	public void setId(int buf){
		this.pkid = buf;
	}
	
	@Column(name="name")
	public String getName(){
		return this.name;
	}
	
	public void setName(String buf){
		if(buf!=null){this.name = buf;}
	}
	
	@Column(name="code")
	public String getCode(){
		return this.code;
	}
	
	public void setCode(String buf){
		if(buf!=null){this.code = buf;}
	}
	
	@Column(name="address_number")
	public String getAddressNumber(){
		return this.addressNumber;
	}
	
	public void setAddressNumber(String buf){
		if(buf!=null){this.addressNumber = buf;}
	}
	
	@Column(name="address_1")
	public String getAddressStreet1(){
		return this.addressStreet1;
	}
	
	public void setAddressStreet1(String buf){
		if(buf!=null){this.addressStreet1 = buf;}
	}
	
	@Column(name="address_2")
	public String getAddressStreet2(){
		return this.addressStreet2;
	}
	
	public void setAddressStreet2(String buf){
		if(buf!=null){this.addressStreet2 = buf;}
	}
	
	@Column(name="address_poscode")
	public String getAddressPoscode(){
		return this.addressPoscode;
	}
	
	public void setAddressPoscode(String buf){
		if(buf!=null){this.addressPoscode = buf;}
	}
	
	@Column(name="address_city")
	public String getAddressCity(){
		return this.addressCity;
	}
	
	public void setAddressCity(String buf){
		if(buf!=null){this.addressCity = buf;}
	}
	
	@Column(name="address_state")
	public String getAddressState(){
		return this.addressState;
	}
	
	public void setAddressState(String buf){
		if(buf!=null){this.addressState = buf;}
	}
	
	@Column(name="address_country")
	public String getAddressCountry(){
		return this.addressCountry;
	}
	
	public void setAddressCountry(String buf){
		if(buf!=null){this.addressCountry = buf;}
	}
	
	@Column(name="contact_number1")
	public String getContactNumber1(){
		return this.contactNumber1;
	}
	
	public void setContactNumber1(String buf){
		if(buf!=null){this.contactNumber1 = buf;}	
	}
	
	@Column(name="contact_number2")
	public String getContactNumber2(){
		return this.contactNumber2;
	}
	
	public void setContactNumber2(String buf){
		if(buf!=null){this.contactNumber2 = buf;}	
	}
	
	@Column(name="contact_number3")
	public String getContactNumber3(){
		return this.contactNumber3;
	}
	
	public void setContactNumber3(String buf){
		if(buf!=null){this.contactNumber3 = buf;}
	}
}
