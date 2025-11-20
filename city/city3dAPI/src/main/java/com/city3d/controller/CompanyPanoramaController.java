package com.city3d.controller;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.city3d.dao.entry.CompanyPanorama;
import com.city3d.service.CompanyPanoramaService;
import com.city3d.utils.CharacterUtils;
import com.city3d.utils.Res;

@Controller
@RequestMapping("/companyPanorama")
public class CompanyPanoramaController {
    //此接口没有应用，留作学习使用
    @Autowired
    private CompanyPanoramaService companyPanoramaService;

    @RequestMapping("/getCompanyPanoramaByCompanyId")
    public @ResponseBody List<CompanyPanorama> getCompanyPanoramaByCompanyId(String companyId) {
        return companyPanoramaService.getCompanyPanoramaByCompanyId(companyId);
    }

    @RequestMapping("/getByCompanyId")
    public @ResponseBody Object getByCompanyId(@RequestBody Map param) {
        String companyId = (String) param.get("companyId");
        if (StringUtils.isEmpty(companyId)) {
            return null;
        }
        return companyPanoramaService.findByCompanyId(companyId);
    }

    @RequestMapping("/save")
    public @ResponseBody Object save(@RequestBody CompanyPanorama entity) {
        if (StringUtils.isBlank(entity.getPanoramaId())) {
            CharacterUtils characterUtils = new CharacterUtils();
            String panoramaId = characterUtils.getUUID();
            entity.setPanoramaId(panoramaId);
            int result = companyPanoramaService.save(entity);
            return Res.success();
        } else {
            int result = companyPanoramaService.updateByPrimaryKey(entity);
            return Res.success();
        }
    }

    @RequestMapping("/delete")
    public @ResponseBody Object delete(@RequestBody Map param) {
        String id = (String) param.get("panoramaId");
        int result = companyPanoramaService.deleteByPrimaryKey(id);
        //companyPanoramaRepository.deleteById(id);
        return Res.success();
    }
}
