package com.liang.express.pojo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "WeixinMessage")
public class WeixinMessage {
	private long lid;
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Id
	@GeneratedValue
	public long getLid() {
		return lid;
	}

	public void setLid(long lid) {
		this.lid = lid;
	}

}
