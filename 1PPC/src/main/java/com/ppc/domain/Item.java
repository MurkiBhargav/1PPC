package com.ppc.domain;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table(value = "ppc_item_regular")
public class Item {

	@PrimaryKey(value = "item_id")
	private int itemId;
	@Column(value = "item_regular_price")
	private int itemRegularPrice;
	@Column(value = "item_promo_flag")
	private String itemPromoFlag;
	public Item() {
		super();
	}
	public Item(int itemId, int itemRegularPrice, String itemPromoFlag) {
		super();
		this.itemId = itemId;
		this.itemRegularPrice = itemRegularPrice;
		this.itemPromoFlag = itemPromoFlag;
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
	public String getItemPromoFlag() {
		return itemPromoFlag;
	}
	public void setItemPromoFlag(String itemPromoFlag) {
		this.itemPromoFlag = itemPromoFlag;
	}
	@Override
	public String toString() {
		return "Item [itemId=" + itemId + ", itemRegularPrice=" + itemRegularPrice + ", itemPromoFlag=" + itemPromoFlag
				+ "]";
	}
	
}
