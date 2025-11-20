package com.city3d.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.city3d.dao.entry.SysFunc;
import com.city3d.dao.entry.SysRole;
import com.city3d.service.FuncService;
import com.city3d.utils.CharacterUtils;

@Controller
@RequestMapping("/func")
public class FuncController {
    @Autowired
    private FuncService funcService;

    @RequestMapping("/getFunc")
    public @ResponseBody List<SysFunc> getFunc() {
        return funcService.getFunc();
    }

    @RequestMapping("/insert")
    public @ResponseBody int insert(@RequestBody SysFunc sysFunc) throws Exception {
        CharacterUtils characterUtils = new CharacterUtils();
        String uid = characterUtils.getUUID();
        sysFunc.setFuncId(uid);
        return funcService.insert(sysFunc);
    }

    @RequestMapping("/update")
    public @ResponseBody int updateByPrimaryKey(@RequestBody SysFunc sysFunc) throws Exception {
        return funcService.updateByPrimaryKey(sysFunc);
    }

    @RequestMapping("/delete")
    public @ResponseBody int deleteByPrimaryKey(@RequestBody SysFunc sysFunc) throws Exception {
        return funcService.deleteByPrimaryKey(sysFunc.getFuncId());
    }

    @RequestMapping("/getFuncByLevel")
    public @ResponseBody List<SysFunc> getFuncByLevel(@RequestBody SysFunc sysFunc) {
        return funcService.getFuncByLevel(sysFunc);
    }

    @RequestMapping("/getFuncAndRel")
    public @ResponseBody List<SysFunc> getFuncAndRel(@RequestBody SysRole sysRole) {
        return funcService.getFuncAndRel(sysRole.getRoleId());
    }

    @RequestMapping("/getFuncBySrc")
    public @ResponseBody List<SysFunc> getFuncBySrc(@RequestBody SysFunc sysFunc) {
        return funcService.getFuncBySrc(sysFunc.getFuncSrc());
    }
}
