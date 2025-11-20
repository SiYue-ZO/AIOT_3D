package com.city3d.controller;

import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.city3d.dao.entry.CompanyCheck;
import com.city3d.service.CompanyCheckService;
import com.city3d.utils.CharacterUtils;
import com.city3d.utils.Res;

@Controller
@RequestMapping("/companyCheck")
public class CompanyCheckController {
    //此接口没有应用，留作学习使用
    @Autowired
    private CompanyCheckService companyCheckService;

    @RequestMapping("/getByCompanyId")
    public @ResponseBody Object getByCompanyId(@RequestBody Map param) {
        String companyId = (String) param.get("companyId");
        if (StringUtils.isEmpty(companyId)) {
            return null;
        }
        return companyCheckService.findByCompanyId(companyId);
    }

    @RequestMapping("/save")
    public @ResponseBody Object save(@RequestBody CompanyCheck entity) {
        if (StringUtils.isBlank(entity.getCompanyCheckId())) {
            CharacterUtils characterUtils = new CharacterUtils();
            String companyCheckId = characterUtils.getUUID();
            entity.setCompanyCheckId(companyCheckId);
            int result = companyCheckService.save(entity);
            return Res.success();
        } else {
            int result = companyCheckService.updateByPrimaryKey(entity);
            return Res.success();
        }
    }

    @RequestMapping("/delete")
    public @ResponseBody Object delete(@RequestBody Map param) {
        String id = (String) param.get("companyCheckId");
        int result = companyCheckService.deleteByPrimaryKey(id);
        return Res.success();
    }

}
