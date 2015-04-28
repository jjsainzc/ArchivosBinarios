package com.example.archivosbinarios.datos;

import java.io.Serializable;
import java.util.Date;

public class Prueba implements Serializable {
	private String attrStr;
	private  Integer attrInt;
	private  Date attrDate;
	
	private static final long serialVersionUID = 1L;
	
	public Prueba() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Prueba(String attrStr, Integer attrInt, Date attrDate) {
		super();
		this.attrStr = attrStr;
		this.attrInt = attrInt;
		this.attrDate = attrDate;
	}

	public String getAttrStr() {
		return attrStr;
	}

	public void setAttrStr(String attrStr) {
		this.attrStr = attrStr;
	}

	public Integer getAttrInt() {
		return attrInt;
	}

	public void setAttrInt(Integer attrInt) {
		this.attrInt = attrInt;
	}

	public Date getAttrDate() {
		return attrDate;
	}

	public void setAttrDate(Date attrDate) {
		this.attrDate = attrDate;
	}

	
	
}