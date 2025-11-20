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

import com.city3d.dao.entry.PeopleMachine;
import com.city3d.service.PeopleMachineService;
import com.city3d.utils.CharacterUtils;

@Controller
@RequestMapping("/peopleMachine")
public class PeopleMachineController {
    @Autowired
    private PeopleMachineService peopleMachineService;

    @RequestMapping("/getPeopleMachine")
    public @ResponseBody List<PeopleMachine> getPeopleMachine() {
        return peopleMachineService.selectPeopleMachineAll();
    }

    @RequestMapping("/insert")
    public @ResponseBody int insert(@Nullable @RequestParam("files") MultipartFile[] files,
                                    @RequestParam("machineId") String machineId,
                                    @RequestParam("ppId") String ppId,
                                    @RequestParam("qrCode") String qrCode,
                                    @RequestParam("machineType") String machineType,
                                    @RequestParam("machineRemark") String machineRemark,
                                    @RequestParam("machineImgUrl") String machineImgUrl,
                                    HttpServletRequest request) throws Exception {
        PeopleMachine peopleMachine = new PeopleMachine();
        if (files != null) {
            for (MultipartFile file : files) {
                if (!file.isEmpty()) {
                    try {
                        String fileName = "";
                        String extName = file.getOriginalFilename().substring(file.getOriginalFilename().indexOf("."));
                        fileName = "image/machine/machine_" + machineType + qrCode + extName;
                        peopleMachine.setMachineImgUrl(fileName);
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
        peopleMachine.setMachineId(uid);
        peopleMachine.setPpId(ppId);
        peopleMachine.setQrCode(qrCode);
        peopleMachine.setMachineRemark(machineRemark);
        peopleMachine.setMachineType(machineType);
        return peopleMachineService.save(peopleMachine);
    }

    @RequestMapping("/update")
    public @ResponseBody int update(@Nullable @RequestParam("files") MultipartFile[] files,
                                    @RequestParam("machineId") String machineId,
                                    @RequestParam("ppId") String ppId,
                                    @RequestParam("qrCode") String qrCode,
                                    @RequestParam("machineType") String machineType,
                                    @RequestParam("machineRemark") String machineRemark,
                                    @RequestParam("machineImgUrl") String machineImgUrl,
                                    HttpServletRequest request) throws Exception {
        PeopleMachine peopleMachine = new PeopleMachine();
        peopleMachine.setMachineImgUrl(machineImgUrl);
        if (files != null) {
            for (MultipartFile file : files) {
                if (!file.isEmpty()) {
                    try {
                        String fileName = "";
                        String extName = file.getOriginalFilename().substring(file.getOriginalFilename().indexOf("."));
                        fileName = "image/machine/machine_" + machineType + qrCode + extName;
                        peopleMachine.setMachineImgUrl(fileName);
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
        peopleMachine.setMachineId(machineId);
        peopleMachine.setPpId(ppId);
        peopleMachine.setQrCode(qrCode);
        peopleMachine.setMachineRemark(machineRemark);
        peopleMachine.setMachineType(machineType);
        return peopleMachineService.updateByPrimaryKey(peopleMachine);
    }

    @RequestMapping("/delete")
    public @ResponseBody int delete(@RequestBody PeopleMachine peopleMachine) throws Exception {
        if (peopleMachine.getMachineImgUrl() != null && !Objects.equals(peopleMachine.getMachineImgUrl(), "")) {
            try {
                String path = System.getProperty("catalina.home") + "\\webapps\\city3dfile\\" + peopleMachine.getMachineImgUrl();
                File fileDel = new File(path);
                fileDel.createNewFile();
                fileDel.delete();
            } catch (IllegalStateException e) {
                e.printStackTrace();
            }
        }
        return peopleMachineService.deleteByPrimaryKey(peopleMachine.getMachineId());
    }

    @RequestMapping("/batchDelete")
    public @ResponseBody int batchDelete(@RequestBody List<PeopleMachine> peopleMachines) throws Exception {
        List<String> machineIds = new ArrayList<>();
        for (PeopleMachine peopleMachine : peopleMachines) {
            machineIds.add(peopleMachine.getMachineId());
            if (peopleMachine.getMachineImgUrl() != null && !Objects.equals(peopleMachine.getMachineImgUrl(), "")) {
                try {
                    String path = System.getProperty("catalina.home") + "\\webapps\\city3dfile\\" + peopleMachine.getMachineImgUrl();
                    File fileDel = new File(path);
                    fileDel.createNewFile();
                    fileDel.delete();
                } catch (IllegalStateException e) {
                    e.printStackTrace();
                }
            }
        }
        return peopleMachineService.batchDelete(machineIds);
    }
}
