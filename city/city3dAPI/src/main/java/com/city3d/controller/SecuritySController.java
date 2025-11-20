package com.city3d.controller;

import java.util.ArrayList;
import java.util.List;

import com.city3d.service.SysRoleSecurityService;
import com.city3d.vo.RoleSecurity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.city3d.dao.entry.Security;
import com.city3d.service.SecuritySService;
import com.city3d.utils.CharacterUtils;

@Controller
@RequestMapping("/securityS")
public class SecuritySController {
    @Autowired
    private SecuritySService securitySService;

    @Autowired
    private SysRoleSecurityService sysRoleSecurityService;

    @RequestMapping("/getSecurityAll")
    public @ResponseBody List<Security> getSecurityAll() {
        return securitySService.getSecurityAll();
    }

    @RequestMapping("/getSecuritySById")
    public @ResponseBody Security getSecuritySById(@RequestBody Security security) {
        return securitySService.getSecuritySById(security.getSecurityId());
    }

    @RequestMapping("/querySecurityS")
    public @ResponseBody List<Security> querySecurityS(@RequestBody Security security) {
        return securitySService.querySecurityS(security);
    }

    @RequestMapping("/countSecuritySByPid")
    public @ResponseBody int countSecuritySByPid(@RequestBody Security security) {
        return securitySService.countSecuritySByPid(security);
    }

    @RequestMapping("/insert")
    public @ResponseBody int insert(@RequestBody RoleSecurity roleSecurity) throws Exception {
        CharacterUtils characterUtils = new CharacterUtils();
        String uid = characterUtils.getUUID();
        roleSecurity.getSecurity().setSecurityId(uid);

        CharacterUtils characterUtilsRole = new CharacterUtils();
        String uidRole = characterUtilsRole.getUUID();
        roleSecurity.getSysRoleSecurity().setRoleSecurityId(uidRole);
        roleSecurity.getSysRoleSecurity().setSecurityId(uid);

        sysRoleSecurityService.insertSysRoleSecurity(roleSecurity.getSysRoleSecurity());
        return securitySService.insert(roleSecurity.getSecurity());
    }

    @RequestMapping("/update")
    public @ResponseBody int updateByPrimaryKey(@RequestBody Security security) throws Exception {
        return securitySService.updateByPrimaryKey(security);
    }

    @RequestMapping("/delete")
    public @ResponseBody int deleteByPrimaryKey(@RequestBody Security security) throws Exception {
        return securitySService.deleteByPrimaryKey(security.getSecurityId());
    }

    @RequestMapping("/batchDelete")
    public @ResponseBody int batchDelete(@RequestBody List<Security> securitys) throws Exception {
        List<String> securityIds = new ArrayList<>();
        for (Security security : securitys) {
            securityIds.add(security.getSecurityId());
        }
        return securitySService.batchDelete(securityIds);
    }
}
