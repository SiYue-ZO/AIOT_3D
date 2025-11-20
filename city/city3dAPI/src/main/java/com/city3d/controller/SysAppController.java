package com.city3d.controller;

import java.io.File;
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

import com.city3d.dao.entry.SysApp;
import com.city3d.service.SysAppService;
import com.city3d.utils.CharacterUtils;

@Controller
@RequestMapping("/sysApp")
public class SysAppController {
    @Autowired
    private SysAppService sysAppService;

    @RequestMapping("/getSysApp")
    public @ResponseBody List<SysApp> getSysApp() {
        return sysAppService.getSysApp();
    }

    @RequestMapping("/insert")
    public @ResponseBody int insert(@Nullable @RequestParam("files") MultipartFile[] files,
                                    @RequestParam("appId") String appId,
                                    @RequestParam("appName") String appName,
                                    @RequestParam("appUiMode") String appUiMode,
                                    @RequestParam("appPos") String appPos,
                                    @RequestParam("appImage") String appImage,
                                    @RequestParam("appTerrain") String appTerrain,
                                    @RequestParam("appVersion") String appVersion,
                                    HttpServletRequest request) throws Exception {
        SysApp sysApp = new SysApp();
        CharacterUtils characterUtils = new CharacterUtils();
        String uid = characterUtils.getUUID();
        if (files != null) {
            for (MultipartFile file : files) {
                if (!file.isEmpty()) {
                    try {
                        String fileName = "";
                        String extName = file.getOriginalFilename().substring(file.getOriginalFilename().indexOf("."));
                        fileName = "image/logo/" + appName + uid + extName;
                        sysApp.setAppLogo(fileName);
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
        sysApp.setAppId(uid);
        sysApp.setAppName(appName);
        sysApp.setAppPos(appPos);
        sysApp.setAppUiMode(appUiMode);
        sysApp.setAppImage(appImage);
        sysApp.setAppTerrain(appTerrain);
        sysApp.setAppVersion(appVersion);
        return sysAppService.insert(sysApp);
    }

    @RequestMapping("/update")
    public @ResponseBody int update(@Nullable @RequestParam("files") MultipartFile[] files,
                                    @RequestParam("appId") String appId,
                                    @RequestParam("appName") String appName,
                                    @RequestParam("appUiMode") String appUiMode,
                                    @RequestParam("appPos") String appPos,
                                    @RequestParam("appLogo") String appLogo,
                                    @RequestParam("appImage") String appImage,
                                    @RequestParam("appTerrain") String appTerrain,
                                    @RequestParam("appVersion") String appVersion,
                                    HttpServletRequest request) throws Exception {
        SysApp sysApp = new SysApp();
        sysApp.setAppLogo(appLogo);
        if (files != null) {
            for (MultipartFile file : files) {
                if (!file.isEmpty()) {
                    try {
                        String fileName = "";
                        String extName = file.getOriginalFilename().substring(file.getOriginalFilename().indexOf("."));
                        fileName = "image/logo/" + appName + appId + extName;
                        sysApp.setAppLogo(fileName);
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
        sysApp.setAppId(appId);
        sysApp.setAppName(appName);
        sysApp.setAppPos(appPos);
        sysApp.setAppUiMode(appUiMode);
        sysApp.setAppImage(appImage);
        sysApp.setAppTerrain(appTerrain);
        sysApp.setAppVersion(appVersion);
        return sysAppService.updateByPrimaryKey(sysApp);
    }

    @RequestMapping("/delete")
    public @ResponseBody int deleteByPrimaryKey(@RequestBody SysApp sysApp) throws Exception {
        if (sysApp.getAppLogo() != null && !Objects.equals(sysApp.getAppLogo(), "")) {
            try {
                String path = System.getProperty("catalina.home") + "\\webapps\\city3dfile\\" + sysApp.getAppLogo();
                File fileDel = new File(path);
                fileDel.createNewFile();
                fileDel.delete();
            } catch (IllegalStateException e) {
                e.printStackTrace();
            }
        }
        return sysAppService.deleteByPrimaryKey(sysApp.getAppId());
    }

    @RequestMapping("/getAppById")
    public @ResponseBody SysApp getAppById(@RequestBody SysApp sysApp) {
        return sysAppService.getAppById(sysApp.getAppId());
    }
}
