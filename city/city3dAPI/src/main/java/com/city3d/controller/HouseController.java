package com.city3d.controller;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
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

import com.city3d.dao.entry.House;
import com.city3d.dao.entry.HousePanorama;
import com.city3d.service.HousePanoramaService;
import com.city3d.service.HouseService;
import com.city3d.utils.CharacterUtils;

@Controller
@RequestMapping("/house")
public class HouseController {
    @Autowired
    private HouseService houseService;

    @Autowired
    private HousePanoramaService housePanoramaService;

    @RequestMapping("/getHouseById")
    public @ResponseBody House getHouseById(@RequestBody House house) {
        return houseService.findHouseById(house.getHouseId());
    }

    @RequestMapping("/queryHouse")
    public @ResponseBody List<House> queryHouse(@RequestBody House house) {
        return houseService.queryHouse(house);
    }

    @RequestMapping("/getHouseByAddId")
    public @ResponseBody List<House> getHouseByAddId(@RequestBody House house) {
        return houseService.getHouseByAddId(house.getAddId());
    }

    @RequestMapping("/insert")
    public @ResponseBody int insert(@Nullable @RequestParam("files") MultipartFile[] files, @RequestParam("houseId") String houseId,
                                    @RequestParam("addId") String addId, @RequestParam("ppId") String ppId, @RequestParam("buldingStructure") String buldingStructure,
                                    @RequestParam("houseArea") String houseArea, @RequestParam("houseCount") String houseCount, @RequestParam("houseType") String houseType,
                                    @RequestParam("houseUse") String houseUse, @RequestParam("propertyNo") String propertyNo, @RequestParam("propertyType") String propertyType,
                                    @RequestParam("beginDate") String beginDate, @RequestParam("endDate") String endDate, @RequestParam("houseUrl") String houseUrl,
                                    @Nullable @RequestParam("photos") MultipartFile[] photos, HttpServletRequest request) throws Exception {
        House house = new House();
        CharacterUtils characterUtils = new CharacterUtils();
        String uid = characterUtils.getUUID();
        if (photos != null) {
            for (MultipartFile file : photos) {
                if (!file.isEmpty()) {
                    try {
                        String fileName = "";
                        String extName = file.getOriginalFilename().substring(file.getOriginalFilename().indexOf("."));
                        fileName = "image/house/house_" + uid + houseUse + propertyNo + extName;
                        house.setHousePhotos(fileName);
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
        house.setHouseId(uid);
        house.setAddId(addId);
        house.setPpId(ppId);
        house.setBuldingStructure(buldingStructure);
        house.setHouseArea(houseArea);
        house.setHouseCount(houseCount);
        house.setHouseType(houseType);
        house.setHouseUse(houseUse);
        house.setPropertyNo(propertyNo);
        house.setPropertyType(propertyType);
        house.setBeginDate(beginDate);
        house.setEndDate(endDate);
        String fianlCommunity = houseUrl;
        if (houseUrl.contains(",")) {
            fianlCommunity = houseUrl.substring(1);
        }
        house.setHouseUrl(fianlCommunity);
        int result = houseService.insert(house);
        if (files != null) {
            for (MultipartFile file : files) {
                if (!file.isEmpty()) {
                    try {
                        String fileName = "";
                        HousePanorama housePanorama = new HousePanorama();
                        String extName = file.getOriginalFilename().substring(file.getOriginalFilename().indexOf("."));
                        fileName = "image/panorama/pano_" + new Date().getTime() + extName;
                        String path = request.getServletContext().getRealPath("").replace("\\city3dAPI", "") + "/city3dfile/" + fileName;
                        File newFile = new File(path);
                        //父级目录不在就创建一个
                        if (!newFile.getParentFile().exists()) {
                            newFile.mkdirs();
                        }
                        file.transferTo(newFile);//通过CommonsMultipartFile的方法直接写文件
                        String panoramaId = characterUtils.getUUID();
                        housePanorama.setPanoramaId(panoramaId);
                        housePanorama.setHouseId(uid);
                        housePanorama.setHousePanorama(fileName);
                        housePanorama.setHousePattern("室内");
                        result = housePanoramaService.insert(housePanorama);
                        result = result == 0 ? 2 : result;
                    } catch (IllegalStateException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        return result;
    }

    @RequestMapping("/update")
    public @ResponseBody int update(@Nullable @RequestParam("files") MultipartFile[] files, @RequestParam("houseId") String houseId,
                                    @RequestParam("addId") String addId, @RequestParam("ppId") String ppId, @RequestParam("buldingStructure") String buldingStructure,
                                    @RequestParam("houseArea") String houseArea, @RequestParam("houseCount") String houseCount, @RequestParam("houseType") String houseType,
                                    @RequestParam("houseUse") String houseUse, @RequestParam("propertyNo") String propertyNo, @RequestParam("propertyType") String propertyType,
                                    @RequestParam("beginDate") String beginDate, @RequestParam("endDate") String endDate, @RequestParam("houseUrl") String houseUrl,
                                    @RequestParam("housePhotos") String housePhotos, @Nullable @RequestParam("photos") MultipartFile[] photos,
                                    HttpServletRequest request) throws Exception {
        House house = new House();
        house.setHousePhotos(housePhotos);
        if (photos != null) {
            for (MultipartFile file : photos) {
                if (!file.isEmpty()) {
                    try {
                        String fileName = "";
                        String extName = file.getOriginalFilename().substring(file.getOriginalFilename().indexOf("."));
                        fileName = "image/house/house_" + houseId + houseUse + propertyNo + extName;
                        house.setHousePhotos(fileName);
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
        house.setHouseId(houseId);
        house.setAddId(addId);
        house.setPpId(ppId);
        house.setBuldingStructure(buldingStructure);
        house.setHouseArea(houseArea);
        house.setHouseCount(houseCount);
        house.setHouseType(houseType);
        house.setHouseUse(houseUse);
        house.setPropertyNo(propertyNo);
        house.setPropertyType(propertyType);
        house.setBeginDate(beginDate);
        house.setEndDate(endDate);
        house.setHouseUrl(houseUrl);
        int result = houseService.updateByPrimaryKey(house);
        if (files != null) {
            for (MultipartFile file : files) {
                if (!file.isEmpty()) {
                    try {
                        String fileName = "";
                        HousePanorama housePanorama = new HousePanorama();
                        String extName = file.getOriginalFilename().substring(file.getOriginalFilename().indexOf("."));
                        fileName = "image/panorama/pano_" + new Date().getTime() + extName;
                        String path = request.getServletContext().getRealPath("").replace("\\city3dAPI", "") + "/city3dfile/" + fileName;
                        File newFile = new File(path);
                        //父级目录不在就创建一个
                        if (!newFile.getParentFile().exists()) {
                            newFile.mkdirs();
                        }
                        file.transferTo(newFile);//通过CommonsMultipartFile的方法直接写文件
                        CharacterUtils characterUtils = new CharacterUtils();
                        String panoramaId = characterUtils.getUUID();
                        housePanorama.setPanoramaId(panoramaId);
                        housePanorama.setHouseId(houseId);
                        housePanorama.setHousePanorama(fileName);
                        housePanorama.setHousePattern("室内");
                        result = housePanoramaService.insert(housePanorama);
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
    public @ResponseBody int deleteByPrimaryKey(@RequestBody House house) throws Exception {
        if (house.getHousePhotos() != null && !Objects.equals(house.getHousePhotos(), "")) {
            try {
                String path = System.getProperty("catalina.home") + "\\webapps\\city3dfile\\" + house.getHousePhotos();
                File fileDel = new File(path);
                fileDel.createNewFile();
                fileDel.delete();
            } catch (IllegalStateException e) {
                e.printStackTrace();
            }
        }
        int result = houseService.deleteByPrimaryKey(house.getHouseId());
        List<HousePanorama> list = housePanoramaService.getHousePanoramaByHosueId(house.getHouseId());
        for (HousePanorama housePanorama : list) {
            result = deleteHousePanoramaPri(housePanorama);
        }
        return result;
    }

    @RequestMapping("/batchDelete")
    public @ResponseBody int batchDelete(@RequestBody List<House> houses) throws Exception {
        List<String> houseIds = new ArrayList<>();
        for (House house : houses) {
            houseIds.add(house.getHouseId());
            if (house.getHousePhotos() != null && !Objects.equals(house.getHousePhotos(), "")) {
                try {
                    String path = System.getProperty("catalina.home") + "\\webapps\\city3dfile\\" + house.getHousePhotos();
                    File fileDel = new File(path);
                    fileDel.createNewFile();
                    fileDel.delete();
                } catch (IllegalStateException e) {
                    e.printStackTrace();
                }
            }
        }
        return houseService.batchDelete(houseIds);
    }

    @RequestMapping("/getHousePanoramaByHosueId")
    public @ResponseBody List<HousePanorama> getHousePanoramaByHosueId(@RequestBody HousePanorama housePanorama) {
        return housePanoramaService.getHousePanoramaByHosueId(housePanorama.getHouseId());
    }

    @RequestMapping("/deleteHousePanorama")
    public @ResponseBody int deleteHousePanorama(@RequestBody HousePanorama housePanorama) throws Exception {
        int result = 0;
        try {
            result = housePanoramaService.deleteByPrimaryKey(housePanorama.getPanoramaId());
            String url = housePanorama.getHousePanorama().substring(housePanorama.getHousePanorama().indexOf("city3dfile/"));
            String path = System.getProperty("catalina.home") + "\\webapps\\" + url;
            File fileDel = new File(path);
            fileDel.createNewFile();
            fileDel.delete();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }
        return result;
    }

    public int deleteHousePanoramaPri(@RequestBody HousePanorama housePanorama) throws Exception {
        int result = 0;
        try {
            result = housePanoramaService.deleteByPrimaryKey(housePanorama.getPanoramaId());
            String path = System.getProperty("catalina.home") + "\\webapps\\city3dfile\\" + housePanorama.getHousePanorama();
            File fileDel = new File(path);
            fileDel.createNewFile();
            fileDel.delete();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }
        return result;
    }
}
