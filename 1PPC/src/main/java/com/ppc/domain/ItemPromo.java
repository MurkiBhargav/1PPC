package com.ppc.domain;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table(value = "ppc_item_promo")
public class ItemPromo {

	@PrimaryKey(value = "item_id")
	private int itemId;
	@Column(value = "promo_discount")
	private int promoDiscount;
	public ItemPromo() {
		super();
	}
	public ItemPromo(int itemId, int promoDiscount) {
		super();
		this.itemId = itemId;
		this.promoDiscount = promoDiscount;
	}
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public int getPromoDiscount() {
		return promoDiscount;
	}
	public void setPromoDiscount(int promoDiscount) {
		this.promoDiscount = promoDiscount;
	}
	@Override
	public String toString() {
		return "ItemPromo [itemId=" + itemId + ", promoDiscount=" + promoDiscount + "]";
	}
	
}
