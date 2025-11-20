package com.city3d.controller;

import java.io.File;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/uploadFile")
public class UploadFileController {
    @RequestMapping("/uploadkml")
    public @ResponseBody int uploadkml(@RequestParam("file") MultipartFile[] files, Model model, @RequestParam("fileName") String fileName, HttpServletRequest request, HttpServletResponse response) throws Exception {
        int result = 0;
        for (MultipartFile file : files) {
            if (!file.isEmpty()) {
                try {
                    String fullfileName = fileName + file.getOriginalFilename().substring(file.getOriginalFilename().indexOf("."));
                    String path = System.getProperty("catalina.home") + "\\webapps\\city3dfile\\kml\\" + fullfileName;
                    File newFile = new File(path);
                    //父级目录  不在  就创建一个
                    if (!newFile.getParentFile().exists()) {
                        newFile.mkdirs();
                    }
                    //通过CommonsMultipartFile的方法直接写文件
                    file.transferTo(newFile);
                } catch (IllegalStateException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }

    @RequestMapping("/uploadshp")
    public @ResponseBody int uploadshp(@RequestParam("file") MultipartFile[] files, Model model, @RequestParam("fileName") String fileName, HttpServletRequest request, HttpServletResponse response) throws Exception {
        int result = 0;
        for (MultipartFile file : files) {
            if (!file.isEmpty()) {
                try {
                    String ext = file.getOriginalFilename().substring(file.getOriginalFilename().indexOf("."));
                    if (ext.equals(".xml")) {
                        ext = ".shp" + ext;
                    }
                    String fullfileName = fileName + ext;
                    String path = System.getProperty("catalina.home") + "\\webapps\\city3dfile\\shp\\" + fullfileName;
                    File newFile = new File(path);
                    //父级目录  不在  就创建一个
                    if (!newFile.getParentFile().exists()) {
                        newFile.mkdirs();
                    }
                    //通过CommonsMultipartFile的方法直接写文件
                    file.transferTo(newFile);
                } catch (IllegalStateException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }
}