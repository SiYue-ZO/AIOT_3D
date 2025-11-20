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

import com.city3d.dao.entry.NetMan;
import com.city3d.service.NetManService;
import com.city3d.utils.CharacterUtils;

@Controller
@RequestMapping("/netMan")
public class NetManController {
    @Autowired
    private NetManService netManService;

    @RequestMapping("/getNetMan")
    public @ResponseBody List<NetMan> getNetMan() {
        return netManService.getNetMan();
    }

    @RequestMapping("/getNetManById")
    public @ResponseBody NetMan getNetManById(@RequestBody NetMan netMan) {
        return netManService.getNetManById(netMan.getNetManId());
    }

    @RequestMapping("/getNetManByType")
    public @ResponseBody List<NetMan> getNetManByType(@RequestBody NetMan netMan) {
        return netManService.getNetManByType(netMan.getType());
    }

    @RequestMapping("/insert")
    public @ResponseBody int insert(@Nullable @RequestParam("files") MultipartFile[] files,
                                    @RequestParam("netManId") String netManId,
                                    @RequestParam("name") String name,
                                    @RequestParam("post") String post,
                                    @RequestParam("duty") String duty,
                                    @RequestParam("tel") String tel,
                                    @RequestParam("party") String party,
                                    @RequestParam("jobTime") String jobTime,
                                    @RequestParam("note") String note,
                                    @RequestParam("type") String type,
                                    HttpServletRequest request) throws Exception {
        NetMan netMan = new NetMan();
        CharacterUtils characterUtils = new CharacterUtils();
        String uid = characterUtils.getUUID();
        if (files != null) {
            for (MultipartFile file : files) {
                if (!file.isEmpty()) {
                    try {
                        String fileName = "";
                        String extName = file.getOriginalFilename().substring(file.getOriginalFilename().indexOf("."));
                        fileName = "image/netMan/" + name + uid + extName;
                        netMan.setImgurl(fileName);
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
        netMan.setNetManId(uid);
        netMan.setName(name);
        netMan.setPost(post);
        netMan.setDuty(duty);
        netMan.setTel(tel);
        netMan.setParty(party);
        netMan.setJobTime(jobTime);
        netMan.setNote(note);
        netMan.setType(type);
        return netManService.insert(netMan);
    }

    @RequestMapping("/update")
    public @ResponseBody int update(@Nullable @RequestParam("files") MultipartFile[] files,
                                    @RequestParam("netManId") String netManId,
                                    @RequestParam("name") String name,
                                    @RequestParam("post") String post,
                                    @RequestParam("duty") String duty,
                                    @RequestParam("tel") String tel,
                                    @RequestParam("party") String party,
                                    @RequestParam("jobTime") String jobTime,
                                    @RequestParam("note") String note,
                                    @RequestParam("type") String type,
                                    @RequestParam("imgurl") String imgurl,
                                    HttpServletRequest request) throws Exception {
        NetMan netMan = new NetMan();
        netMan.setImgurl(imgurl);
        if (files != null) {
            for (MultipartFile file : files) {
                if (!file.isEmpty()) {
                    try {
                        String fileName = "";
                        String extName = file.getOriginalFilename().substring(file.getOriginalFilename().indexOf("."));
                        fileName = "image/netMan/" + name + netManId + extName;
                        netMan.setImgurl(fileName);
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
        netMan.setNetManId(netManId);
        netMan.setName(name);
        netMan.setPost(post);
        netMan.setDuty(duty);
        netMan.setTel(tel);
        netMan.setParty(party);
        netMan.setJobTime(jobTime);
        netMan.setNote(note);
        netMan.setType(type);
        return netManService.updateByPrimaryKey(netMan);
    }

    @RequestMapping("/delete")
    public @ResponseBody int deleteByPrimaryKey(@RequestBody NetMan netMan) throws Exception {
        if (netMan.getImgurl() != null && !Objects.equals(netMan.getImgurl(), "")) {
            try {
                String path = System.getProperty("catalina.home") + "\\webapps\\city3dfile\\" + netMan.getImgurl();
                File fileDel = new File(path);
                fileDel.createNewFile();
                fileDel.delete();
            } catch (IllegalStateException e) {
                e.printStackTrace();
            }
        }
        return netManService.deleteByPrimaryKey(netMan.getNetManId());
    }

    @RequestMapping("/batchDelete")
    public @ResponseBody int batchDelete(@RequestBody List<NetMan> netMans) throws Exception {
        List<String> netManIds = new ArrayList<>();
        for (NetMan netMan : netMans) {
            netManIds.add(netMan.getNetManId());
            if (netMan.getImgurl() != null && !Objects.equals(netMan.getImgurl(), "")) {
                try {
                    String path = System.getProperty("catalina.home") + "\\webapps\\city3dfile\\" + netMan.getImgurl();
                    File fileDel = new File(path);
                    fileDel.createNewFile();
                    fileDel.delete();
                } catch (IllegalStateException e) {
                    e.printStackTrace();
                }
            }
        }
        return netManService.batchDelete(netManIds);
    }
}
