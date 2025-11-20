package com.city3d.controller;

import com.city3d.dao.entry.PipelineRoad;
import com.city3d.service.PipelineRoadService;
import com.city3d.utils.CharacterUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/pipelineRoad")
public class PipelineRoadController {
    @Autowired
    private PipelineRoadService pipelineRoadService;

    @RequestMapping("/getPipelineRoad")
    public @ResponseBody List<PipelineRoad> getPipelineRoad() {
        return pipelineRoadService.getPipelineRoad();
    }

    @RequestMapping("/insert")
    public @ResponseBody int insert(@RequestBody PipelineRoad pipelineRoad) throws Exception {
        CharacterUtils characterUtils = new CharacterUtils();
        String uid = characterUtils.getUUID();
        pipelineRoad.setRoadId(uid);
        return pipelineRoadService.insert(pipelineRoad);
    }

    @RequestMapping("/update")
    public @ResponseBody int update(@RequestBody PipelineRoad pipelineRoad) throws Exception {
        return pipelineRoadService.updateByPrimaryKey(pipelineRoad);
    }

    @RequestMapping("/delete")
    public @ResponseBody int delete(@RequestBody PipelineRoad pipelineRoad) throws Exception {
        return pipelineRoadService.deleteByPrimaryKey(pipelineRoad.getRoadId());
    }
}
