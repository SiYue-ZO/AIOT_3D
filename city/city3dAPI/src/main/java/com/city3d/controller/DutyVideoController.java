package com.city3d.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.city3d.dao.entry.DutyVideo;
import com.city3d.dao.entry.DutyVideoVideo;
import com.city3d.service.DutyVideoService;
import com.city3d.service.DutyVideoVideoService;
import com.city3d.utils.CharacterUtils;

@Controller
@RequestMapping("/dutyVideo")
public class DutyVideoController {
    @Autowired
    private DutyVideoService dutyVideoService;

    @Autowired
    private DutyVideoVideoService dutyVideoVideoService;

    @RequestMapping("/getDutyVideo")
    public @ResponseBody List<DutyVideo> getDutyVideo() {
        return dutyVideoService.getDutyVideo();
    }

    @RequestMapping("/insert")
    public @ResponseBody int insert(@RequestBody DutyVideo dutyVideo) throws Exception {
        CharacterUtils characterUtils = new CharacterUtils();
        String uid = characterUtils.getUUID();
        dutyVideo.setDutyVideoId(uid);
        int result = dutyVideoService.insert(dutyVideo);
        int dutyOrder = 0;
        for (DutyVideoVideo dutyVideoVideo : dutyVideo.getDutyVideoVideo()) {
            dutyVideoVideo.setDutyVideoId(uid);
            CharacterUtils dvvCharacterUtils = new CharacterUtils();
            String dvvuid = dvvCharacterUtils.getUUID();
            dutyVideoVideo.setDutyVideoVideoId(dvvuid);
            dutyVideoVideo.setDutyOrder(dutyOrder);
            dutyVideoVideoService.insertDutyVideoVideo(dutyVideoVideo);
            dutyOrder++;
        }
        return result;
    }

    @RequestMapping("/update")
    public @ResponseBody int updateByPrimaryKey(@RequestBody DutyVideo dutyVideo) throws Exception {
        dutyVideoVideoService.deleteDutyVideoVideo(dutyVideo.getDutyVideoId());
        int result = dutyVideoService.updateByPrimaryKey(dutyVideo);
        int dutyOrder = 0;
        for (DutyVideoVideo dutyVideoVideo : dutyVideo.getDutyVideoVideo()) {
            dutyVideoVideo.setDutyVideoId(dutyVideo.getDutyVideoId());
            CharacterUtils dvvCharacterUtils = new CharacterUtils();
            String dvvuid = dvvCharacterUtils.getUUID();
            dutyVideoVideo.setDutyVideoVideoId(dvvuid);
            dutyVideoVideo.setDutyOrder(dutyOrder);
            dutyVideoVideoService.insertDutyVideoVideo(dutyVideoVideo);
            dutyOrder++;
        }
        return result;
    }

    @RequestMapping("/delete")
    public @ResponseBody int deleteByPrimaryKey(@RequestBody DutyVideo dutyVideo) throws Exception {
        dutyVideoVideoService.deleteDutyVideoVideo(dutyVideo.getDutyVideoId());
        return dutyVideoService.deleteByPrimaryKey(dutyVideo.getDutyVideoId());
    }
}
