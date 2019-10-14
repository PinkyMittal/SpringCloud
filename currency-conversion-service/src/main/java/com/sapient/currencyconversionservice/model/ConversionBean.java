package com.sapient.currencyconversionservice.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ConversionBean {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name="valueFrom") 
	private String from;
	
	@Column(name="valueTo") 
	private String to;
	
	private BigDecimal rate;
	
	private BigDecimal qty;
	
	private BigDecimal amt;
	private int port;
	public ConversionBean() {}
	public ConversionBean(Long id, String from, String to, BigDecimal rate, BigDecimal qty, BigDecimal amt, int port) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.rate = rate;
		this.qty = qty;
		this.amt = amt;
		this.port = port;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public BigDecimal getRate() {
		return rate;
	}
	public void setRate(BigDecimal rate) {
		this.rate = rate;
	}
	public BigDecimal getQty() {
		return qty;
	}
	public void setQty(BigDecimal qty) {
		this.qty = qty;
	}
	public BigDecimal getAmt() {
		return amt;
	}
	public void setAmt(BigDecimal amt) {
		this.amt = amt;
	}
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
    
	
	
}
