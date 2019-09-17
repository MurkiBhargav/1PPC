package com.ppc.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.ppc.dao.ItemDao;
import com.ppc.domain.BadData;
import com.ppc.domain.Item;
import com.ppc.domain.ItemPromo;
import com.ppc.domain.Payload;
import com.ppc.service.ItemService;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private ItemDao itemDao;
	@Autowired
	private KafkaTemplate<String, Payload> kafkaTemplate;
	
	private static String topic = "oneppc";
	
	@Override
	public void kafkaProduce(Payload payload) {
		kafkaTemplate.send(topic, payload);
		System.out.println("Produced : "+payload);
	}

	@Override
	@KafkaListener(topics = "oneppc", groupId = "ppc", containerFactory="kafkaListenerContainerFactory")
	public void kafkaConsume(Payload payload) {
		System.out.println("Consumed : "+payload);
		if(payload.getEventType().equalsIgnoreCase("UPSERT_REGULAR")) {
			Item item = new Item();
			item.setItemId(payload.getItemId());
			item.setItemRegularPrice(payload.getItemRegularPrice());
			item.setItemPromoFlag(payload.getItemPromoFlag());
			insertRegular(item);
		}else if(payload.getEventType().equalsIgnoreCase("UPSERT_PROMO")) {
			ItemPromo itemPromo = new ItemPromo();
			itemPromo.setItemId(payload.getItemId());
			itemPromo.setPromoDiscount(payload.getPromoDiscount());
			insertPromo(itemPromo);
		}
	}

	@Override
	public void insertRegular(Item item) {
		if(item.getItemPromoFlag().equalsIgnoreCase("Y")) {
			Optional<ItemPromo> optionalItemPromo = itemDao.getPromo(item.getItemId());
			if(optionalItemPromo.isPresent()) {
				ItemPromo itemPromo = optionalItemPromo.get();
				item.setItemRegularPrice(item.getItemRegularPrice()-itemPromo.getPromoDiscount());
				itemDao.insert(item);
			}else {
				BadData badData =new BadData();
				badData.setItemId(item.getItemId());
				badData.setItemRegularPrice(item.getItemRegularPrice());
				badData.setItemPromoFlag(item.getItemPromoFlag());
				badData.setReProcess("TRUE");
				itemDao.insert(badData);
			}
		}else
			itemDao.insert(item);
	}

	@Override
	public void insertPromo(ItemPromo itemPromo) {
		itemDao.insert(itemPromo);
		Optional<BadData> optionalBadData = itemDao.getBadData(itemPromo.getItemId());
		if(optionalBadData.isPresent()) {
			BadData badData = optionalBadData.get();
			if(badData.getReProcess().equalsIgnoreCase("TRUE")) {
				Item item = new Item();
				item.setItemId(badData.getItemId());
				item.setItemRegularPrice(badData.getItemRegularPrice()-itemPromo.getPromoDiscount());
				item.setItemPromoFlag(badData.getItemPromoFlag());
				itemDao.insert(item);
				itemDao.delete(badData);
			}
		}
	}
}
