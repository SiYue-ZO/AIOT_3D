package com.city3d.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.city3d.dao.entry.CityThing;
import com.city3d.service.CityThingService;
import com.city3d.utils.CharacterUtils;

@Controller
@RequestMapping("/cityThing")
public class CityThingController {
	@Autowired
	private CityThingService cityThingService;
	
	@RequestMapping("/getCityThing")
	public @ResponseBody List<CityThing> getCityThing() {
		return cityThingService.getCityThing();
	}
	
	@RequestMapping("/getCityThingByPid")
	public @ResponseBody List<CityThing> getCityThingByPid(@RequestBody CityThing cityThing) {
		return cityThingService.getCityThingByPid(cityThing.getThingPid());
	}
	
	@RequestMapping("/insert")
	public @ResponseBody int insert(@RequestBody CityThing cityThing) throws Exception {
		CharacterUtils characterUtils = new CharacterUtils();
		String uid = characterUtils.getUUID();
		cityThing.setThingId(uid);
		return cityThingService.insert(cityThing);
	}
	
	@RequestMapping("/update")
	public @ResponseBody int update(@RequestBody CityThing cityThing) throws Exception {
		return cityThingService.updateByPrimaryKey(cityThing);
	}
	
	@RequestMapping("/delete")
	public @ResponseBody int delete(@RequestBody CityThing cityThing) throws Exception {
		return cityThingService.deleteByPrimaryKey(cityThing.getThingId());
	}

	@RequestMapping("/batchDelete")
	public @ResponseBody int batchDelete(@RequestBody List<CityThing> cityThings) throws Exception {
		List<String> thingIds = new ArrayList<>();
		for(CityThing cityThing : cityThings) {
			thingIds.add(cityThing.getThingId());
		}
		return cityThingService.batchDelete(thingIds);
	}
}
