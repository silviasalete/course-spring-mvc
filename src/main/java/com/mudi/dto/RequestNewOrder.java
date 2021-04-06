package com.mudi.dto;

import javax.validation.constraints.NotBlank;

import com.mudi.model.Order;

public class RequestNewOrder {

	@NotBlank
	private String orderName;
	
	@NotBlank
	private String orderUrl;
	
	@NotBlank	
	private String orderImage;
	
	@NotBlank
	private String orderDescription;
	
	public String getOrderName() {
		return orderName;
	}
	public void setOrderName(String orderName) {
		this.orderName = orderName;
	}
	public String getOrderUrl() {
		return orderUrl;
	}
	public void setOrderUrl(String orderUrl) {
		this.orderUrl = orderUrl;
	}
	public String getOrderImage() {
		return orderImage;
	}
	public void setOrderImage(String orderImage) {
		this.orderImage = orderImage;
	}
	public String getOrderDescription() {
		return orderDescription;
	}
	public void setOrderDescription(String orderDescription) {
		this.orderDescription = orderDescription;
	}

	public Order toOrder() {
		Order order = new Order();
		order.setName(this.getOrderName());
		order.setUrl(this.getOrderUrl());
		order.setImage(this.getOrderImage());
		order.setDescription(this.getOrderDescription());
		return order;
	}
	
}
