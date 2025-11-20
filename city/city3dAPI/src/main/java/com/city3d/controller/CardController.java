package com.city3d.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.city3d.dao.entry.Card;
import com.city3d.service.CardService;
import com.city3d.utils.CharacterUtils;

@Controller
@RequestMapping("/card")
public class CardController {
	@Autowired
	private CardService cardService;
	
	@RequestMapping("/getCardAll")
	public @ResponseBody List<Card> getCardAll() {
		return cardService.getCardAll();
	}
	
	@RequestMapping("/getCardById")
	public @ResponseBody Card getCardById(String crId) {
		return cardService.getCardById(crId);
	}
	
	@RequestMapping("/getCardByCard")
	public @ResponseBody List<Card> getCardByCard(@RequestBody Card card) {
		return cardService.getCardByCard(card);
	}
	
	@RequestMapping("/insert")
	public @ResponseBody int insert(@RequestBody Card card) throws Exception {
		CharacterUtils characterUtils = new CharacterUtils();
		String uid = characterUtils.getUUID();
		card.setCrId(uid);
		return cardService.insert(card);
	}
	
	@RequestMapping("/update")
	public @ResponseBody int updateByPrimaryKey(@RequestBody Card card) throws Exception {
		return cardService.updateByPrimaryKey(card);
	}
	
	@RequestMapping("/delete")
	public @ResponseBody int deleteByPrimaryKey(String crId) throws Exception {
		return cardService.deleteByPrimaryKey(crId);
	}
}
