package com.sudipto.assignment1;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="quote")
public class Quote {

	@Id
	@Column(name="timestamp")
	private Timestamp timestamp;
	
	@Column(name="symbol")
	private String symbol;
	
	@Column(name="sharesTraded")
	private String sharesTraded;
	
	@Column(name="priceTraded")
	private Double priceTraded;
	
	@Column(name="changeDirection")
	private String changeDirection;
	
	@Column(name="changeAmount")
	private Double changeAmount;

	public Quote() {}

	public Quote(Timestamp timestamp, String symbol, String sharesTraded, Double priceTraded, String changeDirection,
			Double changeAmount) {
		super();
		this.timestamp = timestamp;
		this.symbol = symbol;
		this.sharesTraded = sharesTraded;
		this.priceTraded = priceTraded;
		this.changeDirection = changeDirection;
		this.changeAmount = changeAmount;
	}

	public Timestamp getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Timestamp timestamp) {
		this.timestamp = timestamp;
	}

	public String getSymbol() {
		return symbol;
	}

	public void setSymbol(String symbol) {
		this.symbol = symbol;
	}

	public String getSharesTraded() {
		return sharesTraded;
	}

	public void setSharesTraded(String sharesTraded) {
		this.sharesTraded = sharesTraded;
	}

	public Double getPriceTraded() {
		return priceTraded;
	}

	public void setPriceTraded(Double priceTraded) {
		this.priceTraded = priceTraded;
	}

	public String getChangeDirection() {
		return changeDirection;
	}

	public void setChangeDirection(String changeDirection) {
		this.changeDirection = changeDirection;
	}

	public Double getChangeAmount() {
		return changeAmount;
	}

	public void setChangeAmount(Double changeAmount) {
		this.changeAmount = changeAmount;
	}

}
