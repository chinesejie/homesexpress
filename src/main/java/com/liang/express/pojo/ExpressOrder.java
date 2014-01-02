package com.liang.express.pojo;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ExpressOrder")
public class ExpressOrder {
	private ExpressCustomer expressCustomer;

	private ExpressSite finalSite;

	private String note;

	private long oid;

	private ExpressSite originSite;

	private String receiverAddress;

	private String receiverName;
	private String receiverNumber;
	private String senderAddress;

	private String senderName;
	private boolean cancel;
	private Date orderTime;
	private Date getTime;
	private Date flushTime;
	private Date arriveTime;
	private Date sendTime;
	private Date signTime;
	public Date getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}

	public Date getGetTime() {
		return getTime;
	}

	public void setGetTime(Date getTime) {
		this.getTime = getTime;
	}

	public Date getFlushTime() {
		return flushTime;
	}

	public void setFlushTime(Date flushTime) {
		this.flushTime = flushTime;
	}

	public Date getArriveTime() {
		return arriveTime;
	}

	public void setArriveTime(Date arriveTime) {
		this.arriveTime = arriveTime;
	}

	public Date getSendTime() {
		return sendTime;
	}

	public void setSendTime(Date sendTime) {
		this.sendTime = sendTime;
	}

	public Date getSignTime() {
		return signTime;
	}

	public void setSignTime(Date signTime) {
		this.signTime = signTime;
	}

	public boolean isCancel() {
		return cancel;
	}

	public void setCancel(boolean cancel) {
		this.cancel = cancel;
	}

	private String senderNumber;
	private boolean paid;
	private double price;

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public boolean isPaid() {
		return paid;
	}

	public void setPaid(boolean paid) {
		this.paid = paid;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	private double weight;

	private int status;

	@ManyToOne
	public ExpressCustomer getExpressCustomer() {
		return expressCustomer;
	}

	@ManyToOne
	public ExpressSite getFinalSite() {
		return finalSite;
	}

	public String getNote() {
		return note;
	}

	@Id
	@GeneratedValue
	public long getOid() {
		return oid;
	}

	@ManyToOne
	public ExpressSite getOriginSite() {
		return originSite;
	}

	public String getReceiverAddress() {
		return receiverAddress;
	}

	public String getReceiverName() {
		return receiverName;
	}

	public String getReceiverNumber() {
		return receiverNumber;
	}

	public String getSenderAddress() {
		return senderAddress;
	}

	public String getSenderName() {
		return senderName;
	}

	public String getSenderNumber() {
		return senderNumber;
	}

	public double getWeight() {
		return weight;
	}

	public void setExpressCustomer(ExpressCustomer expressCustomer) {
		this.expressCustomer = expressCustomer;
	}

	public void setFinalSite(ExpressSite finalSite) {
		this.finalSite = finalSite;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public void setOid(long oid) {
		this.oid = oid;
	}

	public void setOriginSite(ExpressSite originSite) {
		this.originSite = originSite;
	}

	public void setReceiverAddress(String receiverAddress) {
		this.receiverAddress = receiverAddress;
	}

	public void setReceiverName(String receiverName) {
		this.receiverName = receiverName;
	}

	public void setReceiverNumber(String receiverNumber) {
		this.receiverNumber = receiverNumber;
	}

	public void setSenderAddress(String senderAddress) {
		this.senderAddress = senderAddress;
	}

	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}

	public void setSenderNumber(String senderNumber) {
		this.senderNumber = senderNumber;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

}
