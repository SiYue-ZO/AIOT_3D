package com.city3d.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.city3d.dao.entry.Pipeline;
import com.city3d.service.PipelineService;
import com.city3d.utils.CharacterUtils;

@Controller
@RequestMapping("/pipeline")
public class PipelineControllor {
    @Autowired
    private PipelineService pipelineService;

    @RequestMapping("/getPipeline")
    public @ResponseBody List<Pipeline> getPipeline() {
        return pipelineService.getPipeline();
    }

    @RequestMapping("/insert")
    public @ResponseBody int insert(@RequestBody Pipeline pipeline) throws Exception {
        CharacterUtils characterUtils = new CharacterUtils();
        String uid = characterUtils.getUUID();
        pipeline.setPipeId(uid);
        return pipelineService.insert(pipeline);
    }

    @RequestMapping("/update")
    public @ResponseBody int updateByPrimaryKey(@RequestBody Pipeline pipeline) throws Exception {
        return pipelineService.updateByPrimaryKey(pipeline);
    }

    @RequestMapping("/delete")
    public @ResponseBody int deleteByPrimaryKey(@RequestBody Pipeline pipeline) throws Exception {
        return pipelineService.deleteByPrimaryKey(pipeline.getPipeId());
    }

    @RequestMapping("/getPipelineById")
    public @ResponseBody Pipeline getPipelineById(@RequestBody Pipeline pipeline) {
        return pipelineService.getPipelineById(pipeline.getPipeId());
    }

    @RequestMapping("/getPipelineByPlName")
    public @ResponseBody List<Pipeline> getPipelineByPlName(@RequestBody Pipeline pipeline) {
        return pipelineService.getPipelineByPlName(pipeline);
    }

    @RequestMapping("/batchDelete")
    public @ResponseBody int batchDelete(@RequestBody List<Pipeline> pipelines) throws Exception {
        List<String> pipeIds = new ArrayList<>();
        for (Pipeline pipeline : pipelines) {
            pipeIds.add(pipeline.getPipeId());
        }
        return pipelineService.batchDelete(pipeIds);
    }

    @RequestMapping("/insertBatch")
    public @ResponseBody int insertBatch(@RequestBody List<Pipeline> pipelines) {
        for (Pipeline pipeline : pipelines) {
            CharacterUtils characterUtils = new CharacterUtils();
            String uid = characterUtils.getUUID();
            pipeline.setPipeId(uid);
        }
        return pipelineService.insertBatch(pipelines);
    }
}
