package com.city3d.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.city3d.dao.entry.Viewtag;
import com.city3d.service.TagService;
import com.city3d.utils.CharacterUtils;

@Controller
@RequestMapping("/tag")
public class TagController {
    @Autowired
    private TagService tagService;

    @RequestMapping("/getTag")
    public @ResponseBody List<Viewtag> getTag() {
        return tagService.getTag();
    }

    @RequestMapping("/delete")
    public @ResponseBody int delete(@RequestBody Viewtag tag) throws Exception {
        return tagService.deleteByPrimaryKey(tag.getTagId());
    }

    @RequestMapping("/insert")
    public @ResponseBody int insert(@RequestBody Viewtag tag) throws Exception {
        CharacterUtils characterUtils = new CharacterUtils();
        String uid = characterUtils.getUUID();
        tag.setTagId(uid);
        return tagService.insert(tag);
    }
}
