package com.ppc.dao.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ppc.dao.ItemDao;
import com.ppc.domain.BadData;
import com.ppc.domain.Item;
import com.ppc.domain.ItemPromo;
import com.ppc.repository.BadDataRepository;
import com.ppc.repository.ItemPromoRepository;
import com.ppc.repository.ItemRepository;

@Repository
public class ItemDaoImpl implements ItemDao {

	@Autowired
	private ItemRepository itemRepository;
	@Autowired
	private ItemPromoRepository itemPromoRepository;
	@Autowired
	private BadDataRepository badDataRepository;
	@Override
	public void insert(Item item) {
		itemRepository.save(item);
	}

	@Override
	public void insert(ItemPromo itemPromo) {
		itemPromoRepository.save(itemPromo);
	}

	@Override
	public void insert(BadData badData) {
		badDataRepository.save(badData);
	}

	@Override
	public Optional<Item> getItem(int id) {
		return itemRepository.findById(id);
	}

	@Override
	public Optional<BadData> getBadData(int id) {
		return badDataRepository.findById(id);
	}

	@Override
	public Optional<ItemPromo> getPromo(int id) {
		return itemPromoRepository.findById(id);
	}

	@Override
	public void delete(BadData badData) {
		badDataRepository.delete(badData);
	}

}
