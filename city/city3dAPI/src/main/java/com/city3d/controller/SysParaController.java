package com.city3d.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.city3d.dao.entry.SysPara;
import com.city3d.service.SysParaService;
import com.city3d.utils.CharacterUtils;

@Controller
@RequestMapping("/sys")
public class SysParaController {
    @Autowired
    private SysParaService sysParaService;

    @RequestMapping("/getSys")
    public @ResponseBody List<SysPara> getSys() {
        return sysParaService.getSysPara();
    }

    @RequestMapping("/getSysById")
    public @ResponseBody SysPara getSysById(String sysId) {
        return sysParaService.findSysParaById(sysId);
    }

    @RequestMapping("/querySysParabyType")
    public @ResponseBody List<SysPara> querySysParabyType(@RequestBody SysPara sysPara) {
        return sysParaService.querySysParabyType(sysPara);
    }

    @RequestMapping("/insert")
    public @ResponseBody int insert(@RequestBody SysPara sysPara) throws Exception {
        CharacterUtils characterUtils = new CharacterUtils();
        String uid = characterUtils.getUUID();
        sysPara.setSysId(uid);
        return sysParaService.insert(sysPara);
    }

    @RequestMapping("/update")
    public @ResponseBody int updateByPrimaryKey(@RequestBody SysPara sysPara) throws Exception {
        return sysParaService.updateByPrimaryKey(sysPara);
    }

    @RequestMapping("/delete")
    public @ResponseBody int deleteByPrimaryKey(@RequestBody SysPara sysPara) throws Exception {
        return sysParaService.deleteByPrimaryKey(sysPara.getSysId());
    }
}
