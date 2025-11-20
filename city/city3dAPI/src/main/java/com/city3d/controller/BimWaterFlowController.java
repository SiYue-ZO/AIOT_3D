package com.city3d.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.city3d.dao.entry.BimWaterFlow;
import com.city3d.service.BimWaterFlowService;
import com.city3d.utils.CharacterUtils;

@Controller
@RequestMapping("/bimWaterFlow")
public class BimWaterFlowController {
    @Autowired
    private BimWaterFlowService bimWaterFlowService;

    @RequestMapping("/getBimWaterFlow")
    public @ResponseBody List<BimWaterFlow> getBimWaterFlow() throws Exception {
        return bimWaterFlowService.getBimWaterFlow();
    }

    @RequestMapping("/insert")
    public @ResponseBody int insert(@RequestBody BimWaterFlow bimWaterFlow) throws Exception {
        CharacterUtils characterUtils = new CharacterUtils();
        String uid = characterUtils.getUUID();
        bimWaterFlow.setBimFlowId(uid);
        return bimWaterFlowService.insert(bimWaterFlow);
    }

    @RequestMapping("/update")
    public @ResponseBody int updateByPrimaryKey(@RequestBody BimWaterFlow bimWaterFlow) throws Exception {
        return bimWaterFlowService.updateByPrimaryKey(bimWaterFlow);
    }

    @RequestMapping("/delete")
    public @ResponseBody int deleteByPrimaryKey(@RequestBody BimWaterFlow bimWaterFlow) throws Exception {
        return bimWaterFlowService.deleteByPrimaryKey(bimWaterFlow.getBimFlowId());
    }
}
