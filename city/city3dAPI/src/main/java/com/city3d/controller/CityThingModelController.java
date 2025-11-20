package com.city3d.controller;

import com.city3d.dao.entry.CityThingModel;
import com.city3d.service.CityThingModelService;
import com.city3d.utils.CharacterUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.List;

@Controller
@RequestMapping("/cityThingModel")
public class CityThingModelController {
    @Autowired
    private CityThingModelService cityThingModelService;

    @RequestMapping("/getCityThingModel")
    public @ResponseBody List<CityThingModel> getCityThingModel() {
        return cityThingModelService.getCityThingModel();
    }

    @RequestMapping("/insert")
    public @ResponseBody int insert(@Nullable @RequestParam("files") MultipartFile[] files,
                                    @RequestParam("thingModelId") String thingModelId,
                                    @RequestParam("thingModelPid") String thingModelPid,
                                    @RequestParam("thingModelName") String thingModelName,
                                    @RequestParam("thingModelUrl") String thingModelUrl,
                                    HttpServletRequest request) throws Exception {
        CityThingModel cityThingModel = new CityThingModel();
        if (files != null) {
            for (MultipartFile file : files) {
                if (!file.isEmpty()) {
                    try {
                        String fileName = "";
                        String extName = file.getOriginalFilename().substring(file.getOriginalFilename().indexOf("."));
                        fileName = "data/model/cityThing/thing_" + thingModelName + "_" + thingModelPid + extName;
                        cityThingModel.setThingModelUrl(fileName);
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
        cityThingModel.setThingModelId(uid);
        cityThingModel.setThingModelPid(thingModelPid);
        cityThingModel.setThingModelName(thingModelName);
        return cityThingModelService.insert(cityThingModel);
    }

    @RequestMapping("/update")
    public @ResponseBody int update(@Nullable @RequestParam("files") MultipartFile[] files,
                                    @RequestParam("thingModelId") String thingModelId,
                                    @RequestParam("thingModelPid") String thingModelPid,
                                    @RequestParam("thingModelName") String thingModelName,
                                    @RequestParam("thingModelUrl") String thingModelUrl,
                                    HttpServletRequest request) throws Exception {
        CityThingModel cityThingModel = new CityThingModel();
        cityThingModel.setThingModelUrl(thingModelUrl);
        if (files != null) {
            for (MultipartFile file : files) {
                if (!file.isEmpty()) {
                    try {
                        String fileName = "";
                        String extName = file.getOriginalFilename().substring(file.getOriginalFilename().indexOf("."));
                        fileName = "data/model/cityThing/thing_" + thingModelName + "_" + thingModelPid + extName;
                        cityThingModel.setThingModelUrl(fileName);
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
        cityThingModel.setThingModelId(thingModelId);
        cityThingModel.setThingModelPid(thingModelPid);
        cityThingModel.setThingModelName(thingModelName);
        return cityThingModelService.updateByPrimaryKey(cityThingModel);
    }

    @RequestMapping("/delete")
    public @ResponseBody int delete(@RequestBody CityThingModel cityThingModel) throws Exception {
        return cityThingModelService.deleteByPrimaryKey(cityThingModel.getThingModelId());
    }
}
