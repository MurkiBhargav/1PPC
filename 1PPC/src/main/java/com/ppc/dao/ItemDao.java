package com.ppc.dao;

import java.util.Optional;

import com.ppc.domain.BadData;
import com.ppc.domain.Item;
import com.ppc.domain.ItemPromo;

public interface ItemDao {

	public void insert(Item item);
	public void insert(ItemPromo itemPromo);
	public void insert(BadData badData);
	public Optional<Item> getItem(int id);
	public Optional<BadData> getBadData(int id);
	public Optional<ItemPromo> getPromo(int id);
	public void delete(BadData badData);
}
