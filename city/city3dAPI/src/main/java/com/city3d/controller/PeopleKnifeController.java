package com.city3d.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.city3d.dao.entry.PeopleKnife;
import com.city3d.service.PeopleKnifeService;
import com.city3d.utils.CharacterUtils;

@Controller
@RequestMapping("/peopleKnife")
public class PeopleKnifeController {
    @Autowired
    private PeopleKnifeService peopleKnifeService;

    @RequestMapping("/getPeopleKnife")
    public @ResponseBody List<PeopleKnife> getPeopleKnife() {
        return peopleKnifeService.getPeopleKnife();
    }

    @RequestMapping("/insert")
    public @ResponseBody int insert(@Nullable @RequestParam("files") MultipartFile[] files, @RequestParam("knifeId") String knifeId,
                                    @RequestParam("ppId") String ppId, @RequestParam("knifeLenth") String knifeLenth,
                                    @RequestParam("qrCode") String qrCode, @RequestParam("fixedSituation") String fixedSituation,
                                    @RequestParam("knifeType") String knifeType, @RequestParam("knifeRemark") String knifeRemark,
                                    @RequestParam("knifeImgUrl") String knifeImgUrl,
                                    HttpServletRequest request) throws Exception {
        PeopleKnife peopleKnife = new PeopleKnife();
        if (files != null) {
            for (MultipartFile file : files) {
                if (!file.isEmpty()) {
                    try {
                        String fileName = "";
                        String extName = file.getOriginalFilename().substring(file.getOriginalFilename().indexOf("."));
                        fileName = "image/knife/knife_" + knifeType + qrCode + extName;
                        peopleKnife.setKnifeImgUrl(fileName);
                        String path = request.getServletContext().getRealPath("").replace("\\city3dAPI", "") + "/city3dfile/" + fileName;
                        File newFile = new File(path);
                        //父级目录不在就创建一个
                        if (!newFile.getParentFile().exists()) {
                            newFile.mkdirs();
                        }
                        file.transferTo(newFile);//通过CommonsMultipartFile的方法直接写文件
                    } catch (IllegalStateException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        CharacterUtils characterUtils = new CharacterUtils();
        String uid = characterUtils.getUUID();
        peopleKnife.setKnifeId(uid);
        peopleKnife.setPpId(ppId);
        peopleKnife.setKnifeLenth(knifeLenth);
        peopleKnife.setQrCode(qrCode);
        peopleKnife.setFixedSituation(fixedSituation);
        peopleKnife.setKnifeType(knifeType);
        peopleKnife.setKnifeRemark(knifeRemark);
        return peopleKnifeService.save(peopleKnife);
    }

    @RequestMapping("/update")
    public @ResponseBody int update(@Nullable @RequestParam("files") MultipartFile[] files, @RequestParam("knifeId") String knifeId,
                                    @RequestParam("ppId") String ppId, @RequestParam("knifeLenth") String knifeLenth,
                                    @RequestParam("qrCode") String qrCode, @RequestParam("fixedSituation") String fixedSituation,
                                    @RequestParam("knifeType") String knifeType, @RequestParam("knifeRemark") String knifeRemark,
                                    @RequestParam("knifeImgUrl") String knifeImgUrl,
                                    HttpServletRequest request) throws Exception {
        PeopleKnife peopleKnife = new PeopleKnife();
        peopleKnife.setKnifeImgUrl(knifeImgUrl);
        if (files != null) {
            for (MultipartFile file : files) {
                if (!file.isEmpty()) {
                    try {
                        String fileName = "";
                        String extName = file.getOriginalFilename().substring(file.getOriginalFilename().indexOf("."));
                        fileName = "image/knife/knife_" + knifeType + qrCode + extName;
                        peopleKnife.setKnifeImgUrl(fileName);
                        String path = request.getServletContext().getRealPath("").replace("\\city3dAPI", "") + "/city3dfile/" + fileName;
                        File newFile = new File(path);
                        //父级目录不在就创建一个
                        if (!newFile.getParentFile().exists()) {
                            newFile.mkdirs();
                        }
                        file.transferTo(newFile);//通过CommonsMultipartFile的方法直接写文件
                    } catch (IllegalStateException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        peopleKnife.setKnifeId(knifeId);
        peopleKnife.setPpId(ppId);
        peopleKnife.setKnifeLenth(knifeLenth);
        peopleKnife.setQrCode(qrCode);
        peopleKnife.setFixedSituation(fixedSituation);
        peopleKnife.setKnifeType(knifeType);
        peopleKnife.setKnifeRemark(knifeRemark);
        return peopleKnifeService.updateByPrimaryKey(peopleKnife);
    }

    @RequestMapping("/delete")
    public @ResponseBody int delete(@RequestBody PeopleKnife peopleKnife) throws Exception {
        if (peopleKnife.getKnifeImgUrl() != null && !Objects.equals(peopleKnife.getKnifeImgUrl(), "")) {
            try {
                String path = System.getProperty("catalina.home") + "\\webapps\\city3dfile\\" + peopleKnife.getKnifeImgUrl();
                File fileDel = new File(path);
                fileDel.createNewFile();
                fileDel.delete();
            } catch (IllegalStateException e) {
                e.printStackTrace();
            }
        }
        return peopleKnifeService.deleteByPrimaryKey(peopleKnife.getKnifeId());
    }

    @RequestMapping("/batchDelete")
    public @ResponseBody int batchDelete(@RequestBody List<PeopleKnife> peopleKnifes) throws Exception {
        List<String> knifeIds = new ArrayList<>();
        for (PeopleKnife peopleKnife : peopleKnifes) {
            knifeIds.add(peopleKnife.getKnifeId());
            if (peopleKnife.getKnifeImgUrl() != null && !Objects.equals(peopleKnife.getKnifeImgUrl(), "")) {
                try {
                    String path = System.getProperty("catalina.home") + "\\webapps\\city3dfile\\" + peopleKnife.getKnifeImgUrl();
                    File fileDel = new File(path);
                    fileDel.createNewFile();
                    fileDel.delete();
                } catch (IllegalStateException e) {
                    e.printStackTrace();
                }
            }
        }
        return peopleKnifeService.batchDelete(knifeIds);
    }
}
