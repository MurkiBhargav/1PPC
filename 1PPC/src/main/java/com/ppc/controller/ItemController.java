package com.ppc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ppc.domain.Payload;
import com.ppc.service.ItemService;

@RestController
public class ItemController {

	@Autowired
	private ItemService itemService;
	
	@RequestMapping(value = "/item", method = RequestMethod.POST)
	public void createItem(@RequestBody Payload payload) {
		itemService.kafkaProduce(payload);
	}
}
