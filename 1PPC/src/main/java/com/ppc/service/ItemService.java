package com.ppc.service;

import com.ppc.domain.Item;
import com.ppc.domain.ItemPromo;
import com.ppc.domain.Payload;

public interface ItemService {

	public void kafkaProduce(Payload payload);
	public void kafkaConsume(Payload payload);
	public void insertRegular(Item item);
	public void insertPromo(ItemPromo itemPromo);
}
