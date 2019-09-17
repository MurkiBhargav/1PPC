package com.ppc.domain;

import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table(value = "bad_item")
public class BadData {

	@PrimaryKey(value = "item_id")
	private int itemId;
	@Column(value = "item_regular_price")
	private int itemRegularPrice;
	@Column(value = "item_promo_flag")
	private String itemPromoFlag;
	@Column(value = "re_process")
	private String reProcess;
	public BadData() {
		super();
	}
	public BadData(int itemId, int itemRegularPrice, String itemPromoFlag, String reProcess) {
		super();
		this.itemId = itemId;
		this.itemRegularPrice = itemRegularPrice;
		this.itemPromoFlag = itemPromoFlag;
		this.reProcess = reProcess;
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
	public String getReProcess() {
		return reProcess;
	}
	public void setReProcess(String reProcess) {
		this.reProcess = reProcess;
	}
	@Override
	public String toString() {
		return "BadData [itemId=" + itemId + ", itemRegularPrice=" + itemRegularPrice + ", itemPromoFlag="
				+ itemPromoFlag + ", reProcess=" + reProcess + "]";
	}
	
	
}
