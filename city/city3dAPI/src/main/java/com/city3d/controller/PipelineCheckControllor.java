package com.city3d.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.city3d.dao.entry.PipelineCheck;
import com.city3d.service.PipelineCheckService;
import com.city3d.utils.CharacterUtils;

@Controller
@RequestMapping("/pipelineCheck")
public class PipelineCheckControllor {
	@Autowired
	private PipelineCheckService pipelineCheckService;
	
	@RequestMapping("/getPipelineCheck")
	public @ResponseBody List<PipelineCheck> getPipelineCheck() {
		return pipelineCheckService.getPipelineCheck();
	}
	
	@RequestMapping("/insert")
	public @ResponseBody int insert(@RequestBody PipelineCheck pipelineCheck) throws Exception{
		CharacterUtils characterUtils = new CharacterUtils();
		String uid = characterUtils.getUUID();
		pipelineCheck.setCheckId(uid);
		return pipelineCheckService.insert(pipelineCheck);
	}
	
	@RequestMapping("/update")
	public @ResponseBody int updateByPrimaryKey(@RequestBody PipelineCheck pipelineCheck) throws Exception{
		return pipelineCheckService.updateByPrimaryKey(pipelineCheck);
	}
	
	@RequestMapping("/delete")
	public @ResponseBody int deleteByPrimaryKey(@RequestBody PipelineCheck pipelineCheck) throws Exception{
		return pipelineCheckService.deleteByPrimaryKey(pipelineCheck.getCheckId());
	}
	
	@RequestMapping("/getPipelineCheckByAdd")
	public @ResponseBody List<PipelineCheck> getPipelineCheckByAdd(@RequestBody PipelineCheck pipelineCheck) {
		return pipelineCheckService.getPipelineCheckByAdd(pipelineCheck);
	}
	
	@RequestMapping("/batchDelete")
	public @ResponseBody int batchDelete(@RequestBody List<PipelineCheck> pipelineChecks) throws Exception {
		List<String> checkIds = new ArrayList<>();
		for(PipelineCheck pipelineCheck : pipelineChecks) {
			checkIds.add(pipelineCheck.getCheckId());
		}
		return pipelineCheckService.batchDelete(checkIds);
	}
}
