package com.qin.domain;

import java.io.Serializable;

public class Dept implements Serializable{
	private Integer did;
	private String dname;
	
	public Dept() {
		// TODO Auto-generated constructor stub
	}

	public Dept(Integer did, String dname) {
		super();
		this.did = did;
		this.dname = dname;
	}

	public Integer getDid() {
		return did;
	}

	public void setDid(Integer did) {
		this.did = did;
	}

	public String getDname() {
		return dname;
	}

	public void setDname(String dname) {
		this.dname = dname;
	}

	@Override
	public String toString() {
		return "Dept [did=" + did + ", dname=" + dname + "]";
	}
	
	
	
}
