package com.city3d.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.city3d.dao.entry.FireControl;
import com.city3d.service.FireControlService;
import com.city3d.utils.CharacterUtils;

@Controller
@RequestMapping("/fireControl")
public class FireControlController {
    //此接口没有应用，留作学习使用
    @Autowired
    private FireControlService fireControlService;

    @RequestMapping("/getFireControl")
    public @ResponseBody List<HashMap<String, String>> getFireControl() {
        return fireControlService.getFireControl();
    }

    @RequestMapping("/getFireControlNoPic")
    public @ResponseBody List<FireControl> getFireControlNoPic() {
        return fireControlService.getFireControlNoPic();
    }

    @RequestMapping("/getFireControlById")
    public @ResponseBody FireControl getFireControlById(String fcId) {
        return fireControlService.getFireControlById(fcId);
    }

    @RequestMapping("/queryFireControl")
    public @ResponseBody List<FireControl> queryFireControl(@RequestBody FireControl fireControl) {
        return fireControlService.queryFireControl(fireControl);
    }

    @RequestMapping("/insert")
    public @ResponseBody int insert(@RequestBody FireControl fireControl) throws Exception {
        CharacterUtils characterUtils = new CharacterUtils();
        String uid = characterUtils.getUUID();
        fireControl.setFireCtlId(uid);
        return fireControlService.insert(fireControl);
    }

    @RequestMapping("/update")
    public @ResponseBody int updateByPrimaryKey(@RequestBody FireControl fireControl) throws Exception {
        return fireControlService.updateByPrimaryKey(fireControl);
    }

    @RequestMapping("/delete")
    public @ResponseBody int deleteByPrimaryKey(String fcId) throws Exception {
        return fireControlService.deleteByPrimaryKey(fcId);
    }
}
