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

import com.city3d.dao.entry.PeopleVehicle;
import com.city3d.service.PeopleVehicleService;
import com.city3d.utils.CharacterUtils;

@Controller
@RequestMapping("/peopleVehicle")
public class PeopleVehicleController {
    @Autowired
    private PeopleVehicleService peopleVehicleService;

    @RequestMapping("/getPeopleVehicle")
    public @ResponseBody List<PeopleVehicle> getPeopleVehicle() {
        return peopleVehicleService.selectPeopleVehicleAll();
    }

    @RequestMapping("/insert")
    public @ResponseBody int insert(@Nullable @RequestParam("files") MultipartFile[] files, @RequestParam("vehicleId") String vehicleId,
                                    @RequestParam("ppId") String ppId, @RequestParam("carBrand") String carBrand,
                                    @RequestParam("carCode") String carCode, @RequestParam("carNo") String carNo, @RequestParam("carType") String carType,
                                    @RequestParam("color") String color, @RequestParam("engineNo") String engineNo, @RequestParam("carImgUrl") String carImgUrl,
                                    @RequestParam("registerData") String registerData, @RequestParam("carRemark") String carRemark,
                                    HttpServletRequest request) throws Exception {
        PeopleVehicle peopleVehicle = new PeopleVehicle();
        if (files != null) {
            for (MultipartFile file : files) {
                if (!file.isEmpty()) {
                    try {
                        String fileName = "";
                        String extName = file.getOriginalFilename().substring(file.getOriginalFilename().indexOf("."));
                        fileName = "image/vehicle/vehicle_" + carNo + carCode + extName;
                        peopleVehicle.setCarImgUrl(fileName);
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
        peopleVehicle.setVehicleId(uid);
        peopleVehicle.setPpId(ppId);
        peopleVehicle.setCarBrand(carBrand);
        peopleVehicle.setCarCode(carCode);
        peopleVehicle.setCarNo(carNo);
        peopleVehicle.setCarType(carType);
        peopleVehicle.setColor(color);
        peopleVehicle.setEngineNo(engineNo);
        peopleVehicle.setRegisterData(registerData);
        peopleVehicle.setCarRemark(carRemark);
        return peopleVehicleService.insert(peopleVehicle);
    }

    @RequestMapping("/update")
    public @ResponseBody int update(@Nullable @RequestParam("files") MultipartFile[] files, @RequestParam("vehicleId") String vehicleId,
                                    @RequestParam("ppId") String ppId, @RequestParam("carBrand") String carBrand,
                                    @RequestParam("carCode") String carCode, @RequestParam("carNo") String carNo, @RequestParam("carType") String carType,
                                    @RequestParam("color") String color, @RequestParam("engineNo") String engineNo, @RequestParam("carImgUrl") String carImgUrl,
                                    @RequestParam("registerData") String registerData, @RequestParam("carRemark") String carRemark,
                                    HttpServletRequest request) throws Exception {
        PeopleVehicle peopleVehicle = new PeopleVehicle();
        peopleVehicle.setCarImgUrl(carImgUrl);
        if (files != null) {
            for (MultipartFile file : files) {
                if (!file.isEmpty()) {
                    try {
                        String fileName = "";
                        String extName = file.getOriginalFilename().substring(file.getOriginalFilename().indexOf("."));
                        fileName = "image/vehicle/vehicle_" + carNo + carCode + extName;
                        peopleVehicle.setCarImgUrl(fileName);
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
        peopleVehicle.setVehicleId(vehicleId);
        peopleVehicle.setPpId(ppId);
        peopleVehicle.setCarBrand(carBrand);
        peopleVehicle.setCarCode(carCode);
        peopleVehicle.setCarNo(carNo);
        peopleVehicle.setCarType(carType);
        peopleVehicle.setColor(color);
        peopleVehicle.setEngineNo(engineNo);
        peopleVehicle.setRegisterData(registerData);
        peopleVehicle.setCarRemark(carRemark);
        return peopleVehicleService.updateByPrimaryKey(peopleVehicle);
    }

    @RequestMapping("/delete")
    public @ResponseBody int delete(@RequestBody PeopleVehicle peopleVehicle) throws Exception {
        if (peopleVehicle.getCarImgUrl() != null && !Objects.equals(peopleVehicle.getCarImgUrl(), "")) {
            try {
                String path = System.getProperty("catalina.home") + "\\webapps\\city3dfile\\" + peopleVehicle.getCarImgUrl();
                File fileDel = new File(path);
                fileDel.createNewFile();
                fileDel.delete();
            } catch (IllegalStateException e) {
                e.printStackTrace();
            }
        }
        return peopleVehicleService.deleteByPrimaryKey(peopleVehicle.getVehicleId());
    }

    @RequestMapping("/batchDelete")
    public @ResponseBody int batchDelete(@RequestBody List<PeopleVehicle> peopleVehicles) throws Exception {
        List<String> vehicleIds = new ArrayList<>();
        for (PeopleVehicle peopleVehicle : peopleVehicles) {
            vehicleIds.add(peopleVehicle.getVehicleId());
            if (peopleVehicle.getCarImgUrl() != null && !Objects.equals(peopleVehicle.getCarImgUrl(), "")) {
                try {
                    String path = System.getProperty("catalina.home") + "\\webapps\\city3dfile\\" + peopleVehicle.getCarImgUrl();
                    File fileDel = new File(path);
                    fileDel.createNewFile();
                    fileDel.delete();
                } catch (IllegalStateException e) {
                    e.printStackTrace();
                }
            }
        }
        return peopleVehicleService.batchDelete(vehicleIds);
    }
}
