package com.city3d.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.city3d.dao.entry.CaseMaterial;
import com.city3d.dao.entry.PoliceCase;
import com.city3d.service.CaseMaterialService;
import com.city3d.service.CaseService;
import com.city3d.utils.CharacterUtils;

@Controller
@RequestMapping("/case")
public class CaseController {
    @Autowired
    private CaseService caseService;

    @Autowired
    private CaseMaterialService caseMaterialService;

    @RequestMapping("/getCase")
    public @ResponseBody List<PoliceCase> getCase() {
        return caseService.getCase();
    }

    @RequestMapping("/getCaseAll")
    public @ResponseBody List<PoliceCase> getCaseAll() {
        return caseService.getCaseAll();
    }

    @RequestMapping("/getCaseandNetById")
    public @ResponseBody PoliceCase getCaseandNetById(@RequestBody PoliceCase policeCase) {
        return caseService.getCaseandNetById(policeCase.getCaseId());
    }

    @RequestMapping("/insertEmergencyCase")
    public @ResponseBody int insertEmergencyCase(@RequestBody PoliceCase policeCase) {
        Date caseDate = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        CharacterUtils characterUtils = new CharacterUtils();
        String uid = characterUtils.getUUID();
        policeCase.setCaseId(uid);
        policeCase.setCaseDate(formatter.format(caseDate));
        return caseService.insertEmergencyCase(policeCase);
    }

    @RequestMapping("/queryPoliceCase")
    public @ResponseBody List<PoliceCase> queryPoliceCase(@RequestBody PoliceCase policeCase) {
        if (StringUtils.isBlank(policeCase.getCaseName()) && StringUtils.isBlank(policeCase.getCaseType()) && StringUtils.isBlank(policeCase.getCaseSource())) {
            return caseService.getCase();
        } else {
            return caseService.queryPoliceCase(policeCase);
        }
    }

    @RequestMapping("/updateCase")
    public @ResponseBody int updateCase(@Nullable @RequestParam("files") MultipartFile[] files, @RequestParam("caseId") String caseId,
                                        @RequestParam("caseName") String caseName, @RequestParam("caseType") String caseType, @RequestParam("caseAddr") String caseAddr,
                                        @RequestParam("caseDate") String caseDate, @RequestParam("caseSource") String caseSource, @RequestParam("victim") String victim,
                                        @RequestParam("suspect") String suspect, @RequestParam("caseDescribe") String caseDescribe, @RequestParam("caseResult") String caseResult,
                                        @RequestParam("caseResult") String casePosition, HttpServletRequest request) throws Exception {
        PoliceCase policeCase = new PoliceCase();
        policeCase.setCaseId(caseId);
        policeCase.setCaseName(caseName);
        policeCase.setCaseType(caseType);
        policeCase.setCaseAddr(caseAddr);
        policeCase.setCaseDate(caseDate);
        policeCase.setCaseSource(caseSource);
        policeCase.setVictim(victim);
        policeCase.setSuspect(suspect);
        policeCase.setCaseDescribe(caseDescribe);
        policeCase.setCaseResult(caseResult);
        policeCase.setCaseResult(casePosition);
        int result = caseService.updateByPrimaryKey(policeCase);
        if (files != null) {
            for (MultipartFile file : files) {
                if (!file.isEmpty()) {
                    try {
                        String fileName = "";
                        CaseMaterial caseMaterial = new CaseMaterial();
                        String extName = file.getOriginalFilename().substring(file.getOriginalFilename().indexOf("."));
                        if (extName.equals(".png") || extName.equals(".jpg") || extName.equals(".jpeg") || extName.equals(".gif") || extName.equals(".bmp")
                                || extName.equals(".PNG") || extName.equals(".JPG") || extName.equals(".JPEG") || extName.equals(".GIF") || extName.equals(".BMP")) {
                            fileName = "casepicture/case_" + new Date().getTime() + extName;
                            String path = request.getServletContext().getRealPath("").replace("\\city3dAPI", "") + "/city3dfile/" + fileName;
                            File newFile = new File(path);
                            //父级目录  不在  就创建一个
                            if (!newFile.getParentFile().exists()) {
                                newFile.mkdirs();
                            }
                            caseMaterial.setMaterialType("img");
                            file.transferTo(newFile);//通过CommonsMultipartFile的方法直接写文件
                        } else {
                            fileName = "casevideo/case_" + new Date().getTime() + extName;
                            String path = request.getServletContext().getRealPath("").replace("\\city3dAPI", "") + "/city3dfile/" + fileName;
                            File newFile = new File(path);
                            //父级目录  不在  就创建一个
                            if (!newFile.getParentFile().exists()) {
                                newFile.mkdirs();
                            }
                            caseMaterial.setMaterialType("vid");
                            file.transferTo(newFile);//通过CommonsMultipartFile的方法直接写文件
                        }
                        CharacterUtils characterUtils = new CharacterUtils();
                        String caseMaterialId = characterUtils.getUUID();
                        caseMaterial.setCaseMaterialId(caseMaterialId);
                        caseMaterial.setCaseId(caseId);
                        caseMaterial.setMaterialUrl(fileName);
                        result = caseMaterialService.uploadImg(caseMaterial);
                        result = result == 0 ? 2 : result;
                    } catch (IllegalStateException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return result;
    }

    @RequestMapping("/delete")
    public @ResponseBody int deleteByPrimaryKey(@RequestBody PoliceCase policeCase) throws Exception {
        int result = caseService.deleteByPrimaryKey(policeCase.getCaseId());
        CaseMaterial caseMaterial = new CaseMaterial();
        caseMaterial.setCaseId(policeCase.getCaseId());
        List<CaseMaterial> list = caseMaterialService.getCaseMaterialByIdAndType(caseMaterial);
        for (CaseMaterial caseMaterialList : list) {
            result = deleteCaseMaterial(caseMaterialList);
        }
        return result;
    }

    @RequestMapping("/getCaseMaterialById")
    public @ResponseBody List<CaseMaterial> getCaseMaterialById(@RequestBody CaseMaterial caseMaterial) {
        return caseMaterialService.getCaseMaterialByIdAndType(caseMaterial);
    }

    @RequestMapping("/deleteCaseMaterial")
    public @ResponseBody int deleteCaseMaterial(@RequestBody CaseMaterial caseMaterial) throws Exception {
        int result = 0;
        try {
            result = caseMaterialService.deleteCaseMaterial(caseMaterial.getCaseMaterialId());
            String url = caseMaterial.getMaterialUrl().substring(caseMaterial.getMaterialUrl().indexOf("city3dfile/"));
            String path = System.getProperty("catalina.home") + "\\webapps\\" + url;
            File fileDel = new File(path);
            fileDel.createNewFile();
            fileDel.delete();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }
        return result;
    }
}
