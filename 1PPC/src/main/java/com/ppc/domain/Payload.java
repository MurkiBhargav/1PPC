package com.ppc.domain;

public class Payload {

	private int itemId;
	private int itemRegularPrice;
	private int promoDiscount;
	private String itemPromoFlag;
	private String eventType;
	public Payload() {
		super();
	}
	public Payload(int itemId, int itemRegularPrice, int promoDiscount, String itemPromoFlag, String eventType) {
		super();
		this.itemId = itemId;
		this.itemRegularPrice = itemRegularPrice;
		this.promoDiscount = promoDiscount;
		this.itemPromoFlag = itemPromoFlag;
		this.eventType = eventType;
	}
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public int getItemRegularPrice() {
		return itemRegularPrice;
	}
	public void setItemRegularPrice(int itemRegularPrice) {
		this.itemRegularPrice = itemRegularPrice;
	}
	public int getPromoDiscount() {
		return promoDiscount;
	}
	public void setPromoDiscount(int promoDiscount) {
		this.promoDiscount = promoDiscount;
	}
	public String getItemPromoFlag() {
		return itemPromoFlag;
	}
	public void setItemPromoFlag(String itemPromoFlag) {
		this.itemPromoFlag = itemPromoFlag;
	}
	public String getEventType() {
		return eventType;
	}
	public void setEventType(String eventType) {
		this.eventType = eventType;
	}
	@Override
	public String toString() {
		return "Payload [itemId=" + itemId + ", itemRegularPrice=" + itemRegularPrice + ", promoDiscount="
				+ promoDiscount + ", itemPromoFlag=" + itemPromoFlag + ", eventType=" + eventType + "]";
	}
	
}
