package com.city3d.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.city3d.dao.entry.MapPhotos;
import com.city3d.service.MapPhotosService;
import com.city3d.utils.CharacterUtils;

@Controller
@RequestMapping("/mapPhotos")
public class MapPhotosController {
    @Autowired
    private MapPhotosService mapPhotosService;

    @RequestMapping("/getMapPhotos")
    public @ResponseBody List<MapPhotos> getMapPhotos() {
        return mapPhotosService.getMapPhotos();
    }

    @RequestMapping("/getMapPhotosByTime")
    public @ResponseBody List<MapPhotos> getMapPhotosByTime(@RequestBody MapPhotos mapPhotos) {
        String startTime = mapPhotos.getPhotoName();
        String endTime = mapPhotos.getPhotoTime();
        return mapPhotosService.getMapPhotosByTime(startTime, endTime);
    }

    @RequestMapping("/insert")
    public @ResponseBody int insert(@RequestParam("files") MultipartFile[] files,
                                    @RequestParam("photoName") String[] photoName,
                                    @RequestParam("photoPos") String[] photoPos,
                                    @RequestParam("photoTime") String[] photoTime,
                                    HttpServletRequest request) throws Exception {
        int result = 0;
        for (int i = 0; i < files.length; i++) {
            if (!files[i].isEmpty()) {
                try {
                    CharacterUtils characterUtils = new CharacterUtils();
                    String uid = characterUtils.getUUID();
                    String extName = files[i].getOriginalFilename().substring(files[i].getOriginalFilename().indexOf("."));
                    String fileName = "mapphotos/" + photoName[i] + uid + extName;
                    String path = request.getServletContext().getRealPath("").replace("\\city3dAPI", "") + "/city3dfile/" + fileName;
                    File newFile = new File(path);
                    //父级目录不在就创建一个
                    if (!newFile.getParentFile().exists()) {
                        newFile.mkdirs();
                    }
                    files[i].transferTo(newFile);//通过CommonsMultipartFile的方法直接写文件
                    MapPhotos mapPhotos = new MapPhotos();
                    mapPhotos.setPhotoId(uid);
                    mapPhotos.setPhotoName(photoName[i]);
                    mapPhotos.setPhotoPos(photoPos[i]);
                    mapPhotos.setPhotoTime(photoTime[i]);
                    result = mapPhotosService.insert(mapPhotos);
                } catch (IllegalStateException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }

    @RequestMapping("/delete")
    public @ResponseBody int deleteByPrimaryKey(@RequestBody MapPhotos mapPhotos) throws Exception {
        try {
            String extName = mapPhotos.getPhotoName().substring(mapPhotos.getPhotoName().indexOf("."));
            String path = System.getProperty("catalina.home") + "\\webapps\\city3dfile\\mapphotos\\" + mapPhotos.getPhotoName() + mapPhotos.getPhotoId() + extName;
            File fileDel = new File(path);
            fileDel.createNewFile();
            fileDel.delete();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }
        return mapPhotosService.deleteByPrimaryKey(mapPhotos.getPhotoId());
    }

    @RequestMapping("/batchDelete")
    public @ResponseBody int batchDelete(@RequestBody List<MapPhotos> mapPhotoses) throws Exception {
        List<String> photoIds = new ArrayList<>();
        for (MapPhotos mapPhotos : mapPhotoses) {
            photoIds.add(mapPhotos.getPhotoId());
            try {
                String extName = mapPhotos.getPhotoName().substring(mapPhotos.getPhotoName().indexOf("."));
                String path = System.getProperty("catalina.home") + "\\webapps\\city3dfile\\mapphotos\\" + mapPhotos.getPhotoName() + mapPhotos.getPhotoId() + extName;
                File fileDel = new File(path);
                fileDel.createNewFile();
                fileDel.delete();
            } catch (IllegalStateException e) {
                e.printStackTrace();
            }
        }
        return mapPhotosService.batchDelete(photoIds);
    }
}
