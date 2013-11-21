package com.mquick.shared;

import java.io.Serializable;

public class ClientEntity implements Serializable {
	private static final long serialVersionUID = 1061926354422350601L;

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getSerial() {
		return serial;
	}
	public void setSerial(String serial) {
		this.serial = serial;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public int getMaigcCode() {
		return maigcCode;
	}
	public void setMaigcCode(int maigcCode) {
		this.maigcCode = maigcCode;
	}

	private Integer id = 0;
    private String	serial;
    private String	name;
    private int maigcCode;
    // TODO: list of all wars.
}
