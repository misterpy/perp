package com.entity.inventory;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="inv_item")
public class InventoryItemObject implements Serializable{
	
	private static final long serialVersionUID = -4359833018715495991L;
	
	private int pkid;
	private String name;
	private String code;
	private String serializable;
	private String type;
	
	public InventoryItemObject(){
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
		this.name = buf;
	}
	
	@Column(name="code")
	public String getCode(){
		return this.code;
	}
	
	public void setCode(String buf){
		this.code = buf;
	}
	
	
	@Column(name="type")
	public String getType(){
		return this.type;
	}
	
	public void setType(String buf){
		this.type = buf;
	}
	
	@Column(name="serializable")
	public String getSerializable(){
		return this.serializable;
	}
	
	public void setSerializable(String buf){
		if(buf==null){
			this.serializable = "false";
		}else{
			this.serializable = buf;
		}
	}
}
